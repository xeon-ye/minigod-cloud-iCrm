package com.minigod.notify.service;

import com.minigod.protocol.notify.enums.CaptchaSmsTypeEnum;
import com.minigod.protocol.notify.enums.CaptchaValidEnum;
import com.minigod.protocol.notify.vo.request.params.CaptchaReqParams;
import com.minigod.protocol.notify.vo.response.CaptchaResVo;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "minigod-service-notify")
public interface CaptchaSmsService {
    // 保存短信验证码
    public CaptchaResVo saveCaptcha(String phone, CaptchaSmsTypeEnum captchaType);

    public CaptchaResVo saveCaptcha(CaptchaReqParams captchaReqVo);

    public CaptchaValidEnum verifyCaptcha(CaptchaReqParams captchaReqParams);

    public Boolean isValidCaptcha(CaptchaReqParams captchaReqParams);

}