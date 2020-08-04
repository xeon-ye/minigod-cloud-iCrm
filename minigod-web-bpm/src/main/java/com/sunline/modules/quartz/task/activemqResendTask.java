package com.sunline.modules.quartz.task;

import com.google.common.collect.Lists;
import com.sunline.modules.activemq.entity.ActiveMsgEntity;
import com.sunline.modules.activemq.entity.ActivemqResendEntity;
import com.sunline.modules.activemq.service.ActiveMqService;
import com.sunline.modules.activemq.service.ActivemqResendService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CrmCommonEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component("activemqResendTask")
public class activemqResendTask {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActivemqResendService activemqResendService;

    @Autowired
    private ActiveMqService producer;

    /**
     * activemq重发消息
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {
        logger.info(params+"任务开始");

        ActivemqResendEntity query = new ActivemqResendEntity();
        query.setStatus(BpmCommonEnum.CommonProcessResultStatus.COMMON_PROCESS_RESULT_STATUS_FAILED_VALUE);
        List<ActivemqResendEntity> activemqResendList = activemqResendService.queryListByBean(query);

        logger.info("activemq重发消息，待处理条数："+activemqResendList.size());

        for(ActivemqResendEntity resendEntity : activemqResendList){
            ActiveMsgEntity msgEntity = new ActiveMsgEntity();
            msgEntity.setPublishType(resendEntity.getPublishtype());
            msgEntity.setMsgType(1);
            msgEntity.setBizCode(resendEntity.getBizCode());
            msgEntity.setMsg(resendEntity.getMessage());
            producer.sendMessage(msgEntity);

            resendEntity.setUpdateTime(new Date());
            resendEntity.setStatus(BpmCommonEnum.CommonProcessResultStatus.COMMON_PROCESS_RESULT_STATUS_SUCCEED_VALUE);
            activemqResendService.update(resendEntity);
        }
    }

}
