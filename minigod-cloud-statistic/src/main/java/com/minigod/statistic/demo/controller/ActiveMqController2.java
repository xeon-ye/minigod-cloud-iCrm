package com.minigod.statistic.demo.controller;

import com.minigod.common.pojo.response.ResResult;
import com.minigod.mq.activemq.utils.MqUtil;
import com.minigod.protocol.statistic.model.Statistic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        @PostMapping("send")
        @ApiOperation(value = "发送消息到队列")
        public ResResult send(@RequestBody Statistic msg) {
            MqUtil.sendQueueMessage(queue, msg);
            return ResResult.success("success!");
        }

        @PostMapping("/topic")
        @ApiOperation(value = "发送消息到主题")
        public ResResult handlerActiveMq(@RequestBody Statistic msg) {
            MqUtil.sendTopicMessage(topic, msg);
            return ResResult.success("success!");
        }
}
