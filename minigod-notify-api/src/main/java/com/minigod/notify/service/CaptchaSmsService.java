package com.minigod.notify.service;

import com.minigod.notify.protocol.enums.CaptchaSmsTypeEnum;
import com.minigod.notify.protocol.enums.CaptchaValidEnum;
import com.minigod.notify.protocol.vo.request.params.CaptchaReqParams;
import com.minigod.notify.protocol.vo.response.CaptchaResVo;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "minigod-notify-service")
public interface CaptchaSmsService {
    // 保存短信验证码
    public CaptchaResVo saveCaptcha(String phone, CaptchaSmsTypeEnum captchaType);

    public CaptchaResVo saveCaptcha(CaptchaReqParams captchaReqVo);

    public CaptchaValidEnum verifyCaptcha(CaptchaReqParams captchaReqParams);

    public Boolean isValidCaptcha(CaptchaReqParams captchaReqParams);

}