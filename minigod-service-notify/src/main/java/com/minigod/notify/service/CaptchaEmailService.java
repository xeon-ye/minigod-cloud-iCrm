package com.minigod.notify.service;


import com.minigod.common.pojo.response.ResResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CaptchaEmailService {
    public ResResult sendMail(String sendTo, String sendFrom, String subject, String content, List<String> paths);

}
