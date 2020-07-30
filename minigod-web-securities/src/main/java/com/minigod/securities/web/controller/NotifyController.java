package com.minigod.securities.web.controller;

import com.minigod.common.pojo.response.ResResult;
import com.minigod.notify.service.CaptchaEmailService;
import com.minigod.notify.service.CaptchaSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify_api")
@Validated
@Slf4j
public class NotifyController {
    @Autowired
    private CaptchaEmailService captchaEmailService;
    @Autowired
    private CaptchaSmsService captchaSmsService;
    @PostMapping("/send_mail")
    public ResResult sendMail(){
        return null;
    }
    @PostMapping("/send_sms")
    public ResResult sendSms(){
        return null;
    }

}
