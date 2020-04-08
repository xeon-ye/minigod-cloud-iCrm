package com.minigod.notify.service.impl;

import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.CertTypeEnum;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.utils.CharUtil;
import com.minigod.common.verify.utils.VerifyUtil;
import com.minigod.notify.helper.NotifyService;
import com.minigod.persist.notify.mapper.CaptchaSmsMapper;
import com.minigod.protocol.notify.enums.CaptchaSmsTypeEnum;
import com.minigod.protocol.notify.enums.CaptchaValidEnum;
import com.minigod.protocol.notify.model.CaptchaSms;
import com.minigod.protocol.notify.response.CaptchaResVo;
import com.minigod.notify.service.CaptchaSmsService;
import com.minigod.protocol.notify.request.params.CaptchaReqParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class CaptchaSmsServiceImpl extends BaseBeanFactory implements CaptchaSmsService {
    @Autowired
    CaptchaSmsMapper smsMapper;
    @Autowired
    private NotifyService notifyService;

    Integer MAX_VALID_TIMES = 5;

    private Integer phoneType = CertTypeEnum.phone.getTypeValue();

    @Override
    public CaptchaResVo saveCaptcha(String phone, CaptchaSmsTypeEnum captchaType) {
        if (!VerifyUtil.verifyMobile(phone)) {
            log.error("手机号格式异常." + phone);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_PHONE);
        }

        Integer expires = notifyService.getSmsExpiresTime() * 1000;
        Integer interval = notifyService.getSmsIntervalTime() * 1000;


        CaptchaSms lastCaptcha = smsMapper.selectFirstByPhoneOrderByCreateTimeDesc(phone);

        Long currentTime = new Date().getTime();

        // 验证码请求过于频繁
        if (lastCaptcha != null && lastCaptcha.getCreateTime() != null && (currentTime - lastCaptcha.getCreateTime().getTime()) < interval) {
            log.error("短信验证码请求过于频繁，请稍后重试:." + phone);
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FETCH_SMS_CAPTCHA_OFTEN);
        }

        CaptchaResVo captchaResVo = new CaptchaResVo();

        String captcha = CharUtil.getRandomNum(6);
        Date expiresTime = new Date((new Date().getTime() + expires));

        CaptchaSms captchaSms = new CaptchaSms();
        captchaSms.setCaptcha(captcha);
        captchaSms.setPhone(phone);
        captchaSms.setType(captchaType.getKey());
        captchaSms.setExpiresTime(expiresTime);
        captchaSms.setIsChecked(false);
        captchaSms.setIsUsed(false);
        captchaSms.setValidateCount((byte) 0);
        captchaSms.setCreateTime(new Date());
        captchaSms.setUpdateTime(new Date());

        smsMapper.insert(captchaSms);

        captchaResVo.setCaptchaId(captchaSms.getId());
        captchaResVo.setExpiresTime(captchaSms.getExpiresTime());

        return captchaResVo;
    }

    @Override
    public CaptchaResVo saveCaptcha(CaptchaReqParams params) {
        if (params == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        Integer certType = params.getCertType();
        String certCode = params.getCertCode();
        String captchaType = params.getType();

        CaptchaSmsTypeEnum captchaTypeInfo = CaptchaSmsTypeEnum.getInfo(captchaType);

        if (certType == null || StringUtils.isEmpty(certCode) || captchaTypeInfo == null || !certType.equals(phoneType)) {
            log.error("参数异常-消息类型异常: captchaType:." + captchaType);
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        return saveCaptcha(certCode, captchaTypeInfo);
    }

    private void updateCaptchaSms(CaptchaSms captchaSms, Boolean isChecked) {
        captchaSms.setUpdateTime(new Date());
        captchaSms.setValidateCount((byte) (captchaSms.getValidateCount() + 1));
        if (isChecked) {
            captchaSms.setIsChecked(true);
        }
        smsMapper.updateByPrimaryKeySelective(captchaSms);
    }

    @Override
    public CaptchaValidEnum verifyCaptcha(CaptchaReqParams params) {
        if (params == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        Integer certType = params.getCertType();
        String certCode = params.getCertCode();
        String type = params.getType();
        Integer captchaId = params.getCaptchaId();
        String captcha = params.getCaptcha();

        CaptchaSmsTypeEnum captchaTypeInfo = CaptchaSmsTypeEnum.getInfo(type);

        if (certType == null || StringUtils.isEmpty(certCode) || captchaTypeInfo == null || captchaId == null || StringUtils.isEmpty(captcha) || !certType.equals(phoneType)) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        CaptchaSms captchaSms = smsMapper.selectOneByIdAndPhoneAndExpiresTimeAfter(captchaId, certCode, new Date());

        // 验证码不存在
        if (captchaSms == null) {
            // TODO: 验证码错误或已过期
            return CaptchaValidEnum.error;
        }

        String smsType = captchaSms.getType();
        String smsCaptcha = captchaSms.getCaptcha();
        Byte smsValidateCount = captchaSms.getValidateCount();
        Boolean isChecked = captchaSms.getIsChecked();
        Boolean isUsed = captchaSms.getIsUsed();

        // 已使用
        if (isChecked || isUsed) {
            return CaptchaValidEnum.isUsed;
        }

        // 验证码验证次数过多
        if (smsValidateCount > MAX_VALID_TIMES) {
            return CaptchaValidEnum.isOverTimes;
        }

        // 根据验证码类型，做分类验证码校验（EXP:注册验证码，不能用于登录）
        // 验证码错误或已过期
        if (!smsType.equals(captchaTypeInfo.getKey()) || !smsCaptcha.equals(captcha)) {
            updateCaptchaSms(captchaSms, false);
            return CaptchaValidEnum.error;
        }

        updateCaptchaSms(captchaSms, captchaTypeInfo.getOnce());

        return CaptchaValidEnum.success;
    }

    @Override
    public Boolean isValidCaptcha(CaptchaReqParams captchaReqParams) {
        CaptchaValidEnum captchaValid = null;
        try {
            captchaValid = verifyCaptcha(captchaReqParams);
        } catch (Exception e) {
            log.error("verify sms captcha error:", e);
        }

        if (captchaValid == null) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.BAD_OR_EXPIRE_CAPTCHA);
        }

        Integer captchaType = captchaValid.getTypeValue();

        if (captchaType.equals(CaptchaValidEnum.error.getTypeValue())) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.BAD_OR_EXPIRE_CAPTCHA);
        }

        if (captchaType.equals(CaptchaValidEnum.isOverTimes.getTypeValue())) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.IS_OVET_TIMES_CAPTCHA);
        }

        if (captchaType.equals(CaptchaValidEnum.isUsed.getTypeValue())) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.IS_USED_CAPTCHA);
        }
        return true;
    }
}