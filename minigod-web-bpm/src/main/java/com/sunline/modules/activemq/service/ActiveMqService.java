package com.sunline.modules.activemq.service;


import com.sunline.modules.activemq.entity.ActiveMsgEntity;

/**
 * @description: MQ服务
 * @author: Larry Lai
 * @date: 2020/1/3 10:11
 * @version: v1.0
 */

public interface ActiveMqService {

    /**
     * 推送消息
     * @param msg
     */
    void sendMessage(ActiveMsgEntity msg);
}
