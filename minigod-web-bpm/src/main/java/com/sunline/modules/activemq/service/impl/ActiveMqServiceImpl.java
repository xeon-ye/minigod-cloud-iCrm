package com.sunline.modules.activemq.service.impl;

import cn.hutool.json.JSONUtil;
import com.sunline.modules.activemq.entity.ActiveMsgEntity;
import com.sunline.modules.activemq.entity.ActivemqResendEntity;
import com.sunline.modules.activemq.service.ActiveMqService;
import com.sunline.modules.activemq.service.ActivemqResendService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.util.Date;

/**
 * @description: MQ服务
 * @author: Larry Lai
 * @date: 2020/1/3 10:11
 * @version: v1.0
 */

@Service("activeMqService")
public class ActiveMqServiceImpl implements ActiveMqService {
    private static final Logger logger = LoggerFactory.getLogger(ActiveMqServiceImpl.class);

    @Autowired
    private MessageSendInfoService messageSendInfoService;

    @Autowired
    private ActivemqResendService activemqResendService;

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 推送消息
     * @param msg
     */
    @Override
    public void sendMessage(ActiveMsgEntity msg) {
        String txt = "";
        try {
            // 设置发送模式
            Destination destination = null;
            if (1 == msg.getPublishType()) {
                destination = new ActiveMQQueue(msg.getBizCode());
            } else if (2 == msg.getPublishType()) {
                destination = new ActiveMQTopic(msg.getBizCode());
            }

            // 设置发送消息
            if (1 == msg.getMsgType()) {
                txt = msg.getMsg();
            } else if (2 == msg.getMsgType()) {
                txt = JSONUtil.toJsonStr(msg.getMessage());
            }

            final String message = txt;
            // 空消息不发
            if (StringUtils.isNotBlank(message)) {
                jmsTemplate.convertAndSend(destination, message);
            }

            logger.info("ActiveMq producer succeed，" + "[bizCode：" + msg.getBizCode() + "，message：" + txt + "]");

        } catch (Exception e) {
            logger.error("ActiveMq producer failed，" + "[bizCode：" + msg.getBizCode() + "，message：" + txt + "]", e);
            ActivemqResendEntity entity = new ActivemqResendEntity();
            entity.setBizCode(msg.getBizCode());
            entity.setStatus(BpmCommonEnum.CommonProcessResultStatus.COMMON_PROCESS_RESULT_STATUS_FAILED_VALUE);
            entity.setPublishtype(msg.getPublishType());
            entity.setMessage(txt);
            entity.setCreateTime(new Date());
            entity.setUpdateTime(new Date());
            activemqResendService.save(entity);
            generateSendEmail("消息队列推送异常", "消息主题：" + msg.getBizCode() + "，消息内容：" + txt + "，异常信息：" + e.getMessage());
        }
    }


    /**
     * 发送邮件通知
     *
     * @param title
     * @param message
     */
    private void generateSendEmail(String title, String message) {
        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(SysConfigUtil.getSysConfigValue("SYSTEM_NOTICE_EMAIL_GROUP", "it@zszhizhu.com;laijieqiang@zszhizhu.com"));
        messageSendInfoEntity.setMessageTitle(title);
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(message);
        messageSendInfoEntity.setContentType(0);

        messageSendInfoService.save(messageSendInfoEntity);
    }
}
