package com.minigod.account.service.impl;

import com.minigod.account.helper.RestProxyHelper;
import com.minigod.common.odps.service.RedisMapService;
import com.minigod.common.pojo.CertTypeEnum;
import com.minigod.common.verify.utils.VerifyUtil;
import com.minigod.common.pojo.StaticType.*;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.protocol.account.other.response.OtherUserInfoResVo;
import com.minigod.protocol.account.request.params.LogoutParams;
import com.minigod.protocol.notify.enums.CaptchaSmsTypeEnum;
import com.minigod.protocol.notify.request.params.CaptchaReqParams;
import com.minigod.notify.service.CaptchaSmsService;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.persist.account.mapper.CustomSessionMapper;
import com.minigod.protocol.account.enums.PasswordTypeEnum;
import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.model.CustomSession;
import com.minigod.protocol.account.request.params.LoginReqParams;
import com.minigod.protocol.account.request.params.RetisterReqParams;
import com.minigod.protocol.account.response.LoginResVo;
import com.minigod.account.service.UserCacheService;
import com.minigod.account.service.UserService;
import com.minigod.common.exception.InternalApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserServiceImpl extends BaseBeanFactory implements UserService {

    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomSessionMapper customSessionMapper;
    @Autowired
    UserCacheService userCacheService;
    @Autowired
    private CaptchaSmsService smsService;
    @Autowired
    public RedisMapService redisMapService;
    @Autowired
    public RestProxyHelper restProxyHelper;

    private Integer otherType = CertTypeEnum.other.getTypeValue();
    private Integer phoneType = CertTypeEnum.phone.getTypeValue();
    private Integer emailType = CertTypeEnum.email.getTypeValue();
    private Integer userIdType = CertTypeEnum.userId.getTypeValue();
    private Integer tradeAccountType = CertTypeEnum.tradeAccount.getTypeValue();

    private Integer passwordTypePwd = PasswordTypeEnum.password.getTypeValue();
    private Integer passwordTypeCaptcha = PasswordTypeEnum.captcha.getTypeValue();
    private Integer passwordTypeOther = PasswordTypeEnum.other.getTypeValue();

    // TODO 校验密码
    private Boolean verifyPwd(String key, String checkPwd, String realPwd) {

        return checkPwd.equals(realPwd);
    }

    // 校验验证码
    private Boolean verifyCaptcha(Integer certType, String certCode, Integer captchaId, String captchaCode, CaptchaSmsTypeEnum smsType) {
        CaptchaReqParams captchaInfo = new CaptchaReqParams();
        captchaInfo.setCertType(certType);
        captchaInfo.setCertCode(certCode);
        captchaInfo.setType(smsType.getKey());
        captchaInfo.setCaptchaId(captchaId);
        captchaInfo.setCaptcha(captchaCode);

        return smsService.isValidCaptcha(captchaInfo);
    }

    // 保存登录信息
    private CustomSession saveLogin(CustomOpenInfo user) {
        try {
            if (user == null) {
                return null;
            }

            Integer userId = user.getId();
            // 处理Session
            CustomSession sessionInfo = userCacheService.saveCustomSession(userId);

            return sessionInfo;
        } catch (Exception e) {
            log.error("登录异常: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public LoginResVo register(RetisterReqParams retisterReqParams) {
        try {
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public LoginResVo loginByOther(LoginReqParams params) {
        // 参数校验
        if (params == null) {
            log.error("参数异常: LoginReqParams");
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        String certCode = params.getCertCode();
        String pwd = params.getPassword();

        // 非其他系统账号，直接走内部系统账号登录逻辑
        if (params.getCertType() != null && !params.getCertType().equals(otherType)) {
            return login(params);
        }

        // 参数校验 - 基本
        if (StringUtils.isEmpty(certCode)) {
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        OtherUserInfoResVo otherUserInfoResVo = restProxyHelper.checkUser(certCode, pwd);

        if (otherUserInfoResVo != null && otherUserInfoResVo.getIsRealUser()) {
            CustomOpenInfo userInfo = null;

            String phoneNumber = otherUserInfoResVo.getPhoneNumber();

            // 手机号校验
            if (StringUtils.isEmpty(phoneNumber) || !VerifyUtil.verifyMobile(phoneNumber)) {
                log.error("手机号格式异常." + certCode);
                throw new InternalApiException(CodeType.BAD_ARGS, MessageResource.BAD_FORMAT_PHONE);
            }

            // 根据手机号码获取用户
            userInfo = customOpenInfoMapper.selectOneByPhone(phoneNumber);

            if (userInfo == null) {
                log.info("外部系统用户不存在本地：", phoneNumber);
                userInfo = new CustomOpenInfo();

                userInfo.setPhone(otherUserInfoResVo.getPhoneNumber());

                customOpenInfoMapper.insertSelective(userInfo);
            }

            CustomSession session = saveLogin(userInfo);

            if (session == null) {
                throw new InternalApiException(CodeType.DISPLAY_ERROR, MessageResource.FAIL_LOGIN_BY_OTHER);
            }

            LoginResVo loginResVo = new LoginResVo();
            loginResVo.setToken(session.getToken());

            //登录成功打印日志，把userId打印出来，方便统计日活量
            log.info("登录成功-login success --- user_id:" + userInfo.getId());

            return loginResVo;
        } else {
            // TODO
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

    }

    @Override
    public LoginResVo login(LoginReqParams params) {
        // 参数校验
        if (params == null) {
            log.error("参数异常: LoginReqParams = {}", params);
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }
        Integer certType = params.getCertType();
        String certCode = params.getCertCode();
        Integer passwordType = params.getPasswordType();
        String pwd = params.getPassword();
        Integer captchaId = params.getCaptchaId();

        // 参数校验 - 基本
        if (certType == null || passwordType == null || StringUtils.isEmpty(certCode)) {
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        // 参数校验 - 合法性
        if (!CertTypeEnum.isContainCertType(certType) || !PasswordTypeEnum.isContainCertType(passwordType)) {
            // 非法的 账号| 密码类型
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        // 其他系统账号，直接走外部系统账号登录逻辑
        if (certType.equals(otherType)) {
            return loginByOther(params);
        }

        // 参数校验 - 非其他密码类型（即密码|验证码登录)，必须有密码
        if (!passwordType.equals(passwordTypeOther) && StringUtils.isEmpty(pwd)) {
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        CustomOpenInfo userInfo = null;

        // 用户ID登录
        if (certType.equals(userIdType)) {
            // 暂不支持用户ID登录
//            userInfo = customOpenInfoMapper.selectOneById(Integer.valueOf(certCode));
            throw new InternalApiException(MessageResource.SERVICE_UN_SUPPORT);
        }
        // 手机号登录
        else if (certType.equals(phoneType)) {
            // 手机号校验
            if (!VerifyUtil.verifyMobile(certCode)) {
                log.error("手机号格式异常." + certCode);
//                throw new InternalApiException(CodeType.BAD_ARGS, MessageResource.BAD_FORMAT_PHONE);
                throw new InternalApiException(CodeType.DISPLAY_ERROR, MessageResource.BAD_OR_EXPIRE_CAPTCHA);
            }

            // 根据手机号码获取用户
            userInfo = customOpenInfoMapper.selectOneByPhone(certCode);

            if (userInfo == null) {
                userInfo = new CustomOpenInfo();
                userInfo.setPhone(certCode);
                customOpenInfoMapper.insertSelective(userInfo);
            }
        }
        // 邮箱登录
        else if (certCode.equals(emailType)) {
            // 暂不支持邮箱登录
            throw new InternalApiException(MessageResource.SERVICE_UN_SUPPORT);
//            if (!VerifyUtil.isEmail(certCode)) {
//                log.error("邮箱格式异常." + certCode);
//                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, MessageResource.BAD_FORMAT_EMAIL);
//            }
//            // 通过邮箱获取用户信息
//            userInfo = customOpenInfoMapper.selectOneByEmail(certCode);
        }
        // 交易账号登录
        else if (certType.equals(tradeAccountType)) {
            // 暂不支持交易账号登录
            throw new InternalApiException(MessageResource.SERVICE_UN_SUPPORT);
        }
        // 其他内部系统账号登录
        else {
            // 暂不支持其他账号类型登录
            throw new InternalApiException(MessageResource.SERVICE_UN_SUPPORT);
        }

        if (userInfo == null) {
            log.error("用户不存在: {}", certCode);
            throw new InternalApiException(CodeType.BAD_ARGS, MessageResource.NO_USER);
        }

        // 校验密码登录 && 校验密码准确性
        if (passwordType.equals(passwordTypePwd) && !verifyPwd(certCode, pwd, userInfo.getPassword())) {
            throw new InternalApiException(CodeType.BAD_ARGS, MessageResource.BAD_ACCOUNT_OR_PWD);
        }

        // 校验验证码登录 & 校验验证码准确性
        if (passwordType.equals(passwordTypeCaptcha) && !verifyCaptcha(certType, certCode, captchaId, pwd, CaptchaSmsTypeEnum.loginSms)) {
            throw new InternalApiException(CodeType.BAD_ARGS, MessageResource.BAD_OR_EXPIRE_CAPTCHA);
        }

        if (passwordType.equals(passwordTypeOther)) {
            // 暂不其他密码类型登录
            throw new InternalApiException(MessageResource.SERVICE_UN_SUPPORT);
        }

        CustomSession session = saveLogin(userInfo);

        if (session == null) {
            throw new InternalApiException(CodeType.DISPLAY_ERROR, MessageResource.FAIL_LOGIN);
        }

        LoginResVo loginResVo = new LoginResVo();
        loginResVo.setToken(session.getToken());

        //登录成功打印日志，把userId打印出来，方便统计日活量
        log.info("登录成功, user_id:" + userInfo.getId());

        return loginResVo;
    }

    @Override
    public void logout(Integer userId, LogoutParams logoutParams) {
        if (logoutParams == null || StringUtils.isEmpty(logoutParams.getToken())) {
            throw new InternalApiException(CodeType.BAD_ARGS, MessageResource.NO_USER);
        }
        userCacheService.expireCustomSession(userId, logoutParams.getToken());

    }
}
