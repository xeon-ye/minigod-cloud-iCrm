package com.minigod.notify.service.impl;


import com.minigod.common.bean.BaseBeanFactory;
import com.minigod.notify.service.CaptchaEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@FeignClient(value = "minigod-notify-service")
public class CaptchaEmailServiceImpl extends BaseBeanFactory implements CaptchaEmailService {

}
