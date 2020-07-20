package com.minigod.notify.service.impl;


import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.notify.service.CaptchaEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@FeignClient(value = "minigod-service-notify")
public class CaptchaEmailServiceImpl extends BaseBeanFactory implements CaptchaEmailService {

}
