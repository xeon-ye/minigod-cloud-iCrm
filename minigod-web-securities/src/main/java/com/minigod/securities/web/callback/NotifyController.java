package com.minigod.securities.web.callback;

import com.minigod.common.pojo.request.BaseRequest;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.notify.service.EmailService;
import com.minigod.notify.service.CaptchaSmsService;
import com.minigod.protocol.account.request.params.OpenImgReqParams;
import com.minigod.protocol.notify.request.params.CaptchaReqParams;
import com.minigod.protocol.notify.request.params.NotifyEmailReqParams;
import com.minigod.protocol.notify.response.CaptchaResVo;
import com.minigod.securities.annotation.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callback/notify_api")
@Validated
@Slf4j
public class NotifyController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private CaptchaSmsService captchaSmsService;

    @PostMapping("/send_mail")
    public ResResult sendMail( @RequestBody BaseRequest<NotifyEmailReqParams> requestVo) {
        //
        NotifyEmailReqParams notifyEmailReqParams = requestVo.getParams();
        return emailService.sendMail(notifyEmailReqParams.getSendTo(), notifyEmailReqParams.getSendFrom()
                , notifyEmailReqParams.getSubject(), notifyEmailReqParams.getContent(), notifyEmailReqParams.getPaths());
    }

    @PostMapping("/send_sms")
    public CaptchaResVo sendSms(@RequestBody BaseRequest<CaptchaReqParams> requestVo) {
        CaptchaReqParams captchaReqParams = requestVo.getParams();
        return captchaSmsService.saveCaptcha(captchaReqParams);
    }

}
