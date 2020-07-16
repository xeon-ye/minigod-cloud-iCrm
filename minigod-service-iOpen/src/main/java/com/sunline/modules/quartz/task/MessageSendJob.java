package com.sunline.modules.quartz.task;

import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 消息发送中心
 * @author: Larry Lai
 * @date: 2018/9/29 15:17
 * @version: v1.0
 */

@Component("messageSendJob")
public class MessageSendJob {

    private final Logger logger = LoggerFactory.getLogger(CustomerAccOpenRetCallback.class);

    @Autowired
    MessageSendInfoService messageSendInfoService;

    public void excute(String params) throws Exception {

        logger.info(params + "任务开始");

        List<MessageSendInfoEntity> unFinishedMessages = messageSendInfoService.queryUnFinishedMessage();
        for (MessageSendInfoEntity unFinishedMessage : unFinishedMessages) {
            boolean isSucceed = messageSendInfoService.sendMessage(unFinishedMessage);
        }
    }

}
