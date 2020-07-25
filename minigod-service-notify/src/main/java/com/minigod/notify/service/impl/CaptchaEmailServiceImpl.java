package com.minigod.notify.service.impl;


import com.minigod.common.pojo.response.ResResult;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.mail.util.ResponseData;
import com.minigod.notify.helper.NotifyService;
import com.minigod.notify.service.CaptchaEmailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@FeignClient(value = "minigod-service-notify")
public class CaptchaEmailServiceImpl extends BaseBeanFactory implements CaptchaEmailService {
    @Autowired
    private NotifyService notifyService;

    /**
     * 发送邮件
     *
     * @param sendTo
     * @param sendFrom
     * @param subject
     * @param content
     * @param paths
     * @return
     */
    public ResResult sendMail(String sendTo, String sendFrom, String subject, String content, List<String> paths) {

        try {
            if (StringUtils.isEmpty(sendTo) || StringUtils.isEmpty(sendFrom)
                    || StringUtils.isEmpty(subject) || StringUtils.isEmpty(content)) {
                return ResResult.parameterErrorMessage();
            }
            notifyService.setSendTo(sendTo);
            notifyService.setSendFrom(sendFrom);
            ResponseData re = notifyService.notifySendCloudMail(subject, content, paths);
            if (re != null && re.getResult()) {
                return ResResult.success();
            } else {
                ResResult resResult = new ResResult();
                resResult.setCode(re.getStatusCode());
                resResult.setMessage(re.getMessage());
                return resResult;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return ResResult.errorWithMessage("发送失败");
        }

    }
}
