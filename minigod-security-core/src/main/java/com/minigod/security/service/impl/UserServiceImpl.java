package com.minigod.security.service.impl;

import com.minigod.common.odps.service.RedisMapService;
import com.minigod.common.pojo.CertTypeEnum;
import com.minigod.common.verify.utils.VerifyUtil;
//import RedisMapService;
import com.minigod.common.pojo.StaticType.*;
import com.minigod.common.bean.BaseBeanFactory;
import com.minigod.notify.protocol.enums.CaptchaSmsTypeEnum;
import com.minigod.notify.protocol.vo.request.params.CaptchaReqParams;
import com.minigod.notify.service.CaptchaSmsService;
import com.minigod.security.mapper.CustomOpenInfoMapper;
import com.minigod.security.mapper.CustomSessionMapper;
import com.minigod.security.protocol.enums.UserLoginWayEnum;
import com.minigod.security.protocol.model.CustomOpenInfo;
import com.minigod.security.protocol.model.CustomSession;
import com.minigod.security.protocol.vo.request.params.LoginReqParams;
import com.minigod.security.protocol.vo.request.params.RetisterReqParams;
import com.minigod.security.protocol.vo.response.LoginResVo;
import com.minigod.security.service.UserCacheService;
import com.minigod.security.service.UserService;
import com.minigod.security.protocol.enums.CubpMessageResource;
import com.minigod.common.exception.InternalApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
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

    private Integer userIdType = CertTypeEnum.userId.getTypeValue();
    private Integer phoneType = CertTypeEnum.phone.getTypeValue();
    private Integer emailType = CertTypeEnum.email.getTypeValue();

    private Integer loginWayPwd = UserLoginWayEnum.pwd.getTypeValue();
    private Integer loginWayCaptcha = UserLoginWayEnum.captcha.getTypeValue();
    private Integer loginWayOther = UserLoginWayEnum.other.getTypeValue();

    // TODO 校验密码
    private Boolean verifyPwd(String key, String checkPwd, String realPwd) {

        return false;
    }

    // TODO 校验验证码
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
    public LoginResVo login(LoginReqParams loginReqParams) {
        // 参数校验
        if (loginReqParams == null) {
            log.error("参数异常: LoginReqParams");
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }
        Integer certType = loginReqParams.getCertType();
        String certCode = loginReqParams.getCertCode();
        Integer loginWay = loginReqParams.getLoginWay();
        String pwd = loginReqParams.getPassword();
        Integer captchaId = loginReqParams.getCaptchaId();

        // 参数校验 - 基本
        if (certType == null || loginWay == null || StringUtils.isEmpty(certCode)) {
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        // 参数校验 - 密码登录||验证码等
        if ((loginWay.equals(loginWayPwd) || loginWay.equals(loginWayCaptcha)) && StringUtils.isEmpty(pwd)) {
            throw new InternalApiException(CodeType.BAD_PARAMS, MessageResource.BAD_PARAMS);
        }

        CustomOpenInfo userInfo = null;

        // 用户ID登录
        if (certType.equals(userIdType)) {
            // TODO: 用户ID格式校验??
            userInfo = customOpenInfoMapper.selectOneById(Integer.valueOf(certCode));
        }
        // 手机号登录
        else if (certType.equals(phoneType)) {
            // 手机号校验
            if (!VerifyUtil.verifyMobile(certCode)) {
                log.error("手机号格式异常." + certCode);
                throw new InternalApiException(CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_PHONE);
            }

            // 根据手机号码获取用户
            userInfo = customOpenInfoMapper.selectOneByPhone(certCode);
        }
        // 邮箱登录
        else if (certCode.equals(emailType)) {
            throw new Error("暂不支持邮箱登录");
//            if (!VerifyUtil.isEmail(certCode)) {
//                log.error("邮箱格式异常." + certCode);
//                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_EMAIL);
//            }
//            // 通过邮箱获取用户信息
//            userInfo = customOpenInfoMapper.selectOneByEmail(certCode);
        }

        if (userInfo == null) {
            log.error("用户不存在: {}", certCode);
            throw new InternalApiException(CodeType.BAD_ARGS, CubpMessageResource.NO_USER);
        }

        // 校验密码登录 && 校验密码准确性
        if (loginWay.equals(loginWayPwd) && !verifyPwd(certCode, pwd, userInfo.getPassword())) {
            throw new InternalApiException(CodeType.BAD_ARGS, CubpMessageResource.BAD_ACCOUNT_OR_PWD);
        }

        // 校验验证码登录 & 校验验证码准确性
        if (loginWay.equals(loginWayCaptcha) && !verifyCaptcha(certType, certCode, captchaId, pwd, CaptchaSmsTypeEnum.loginSms)) {
            throw new InternalApiException(CodeType.BAD_ARGS, CubpMessageResource.BAD_OR_EXPIRE_CAPTCHA);
        }

        // TODO: 其他校验方式

        CustomSession session = saveLogin(userInfo);

        if (session == null) {
            throw new InternalApiException(CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_LOGIN);
        }

        LoginResVo loginResVo = new LoginResVo();
        loginResVo.setToken(session.getToken());

        //登录成功打印日志，把userId打印出来，方便统计日活量
        log.info("登录成功-login success --- user_id:" + userInfo.getId());

        return loginResVo;
    }
}
