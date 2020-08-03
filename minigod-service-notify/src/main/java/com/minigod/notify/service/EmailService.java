package com.minigod.notify.service;


import com.minigod.common.pojo.response.ResResult;
import com.minigod.protocol.notify.request.params.EmailFileInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmailService {
    public ResResult sendMail(String sendTo, String sendFrom, String subject, String content, List<EmailFileInfo> emailFileInfos);

}
