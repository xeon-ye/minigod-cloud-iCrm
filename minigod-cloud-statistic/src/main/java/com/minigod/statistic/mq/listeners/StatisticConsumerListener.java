package com.minigod.statistic.mq.listeners;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.minigod.protocol.statistic.model.Statistic;
import com.minigod.statistic.service.StatisticCallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
@Slf4j
public class StatisticConsumerListener {
    @Autowired
    StatisticCallService statisticCallService;
    /**
     * 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
     *
     * @param message
     * @return
     */
    @JmsListener(destination = "${spring.activemq.queue-name:statistic-queue}", containerFactory = "jmsListenerContainerQueue")
    @SendTo("statistic-queue")
    public void handleMessage(final TextMessage message) throws JMSException {
        String messageText = message.getText();
        log.info("statistic-queue-consumer收到的报文为:{}", messageText);
        Statistic statistic = JSON.parseObject(messageText, Statistic.class);
        statisticCallService.save(statistic);
    }
}
