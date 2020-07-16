package com.sunline.modules.activemq.test;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * @author: Larry Lai
 * @date: 2019/10/30 19:36
 * @version: v1.0
 */

@Service
public class Consumer {

//    @JmsListener(destination = "userInfo_cubp")
    public void receiveMsg(String text) {

        System.out.println("接收消息：" + text);
    }
}
