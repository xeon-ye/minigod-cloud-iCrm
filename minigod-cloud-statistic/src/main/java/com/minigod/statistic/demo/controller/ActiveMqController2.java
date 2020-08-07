package com.minigod.statistic.demo.controller;

import com.minigod.common.pojo.response.ResResult;
import com.minigod.mq.activemq.utils.MqUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 队列消息控制器
 *
 * @author
 */
    @RestController
    @RequestMapping("/activeMq2")
    @Api(tags = "消息测试API", description = "队列消息控制器")
    @Slf4j
    public class ActiveMqController2 {


        @Autowired
        private Queue queue;

        @Autowired
        private Topic topic;

        @GetMapping("send")
        @ApiOperation(value = "发送消息到队列")
        public ResResult send(@RequestParam("msg") String msg) {
            MqUtil.sendQueueMessage(queue, msg);
            return ResResult.success("success!");
        }

        @GetMapping("/topic")
        @ApiOperation(value = "发送消息到主题")
        public ResResult handlerActiveMq(@RequestParam("msg") String msg) {
            MqUtil.sendTopicMessage(topic, msg);
            return ResResult.success("success!");
        }


}
