package com.sunline.modules.commission.callback;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.commission.entity.ClientFareSetupEntity;
import com.sunline.modules.commission.entity.ClientFareSetupLogEntity;
import com.sunline.modules.commission.service.ChannelFareSetupLogService;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.commission.service.ClientFareSetupLogService;
import com.sunline.modules.commission.service.ClientFareSetupService;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.utils.SpringContextUtils;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @description: 客户佣金套餐设置审批回调类
 * @author: Larry Lai
 * @date: 2018/8/30 19:59
 * @version: v1.0
 */

@Component
public class ClientFareSetApproveCallBack {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void callback(ProcessTaskDto processTaskDto, Map<String, Object> map) {
        try {

            ClientFareSetupService clientFareSetupService = (ClientFareSetupService) SpringContextUtils.getBean("clientFareSetupService");
            ClientFareSetupLogService clientFareSetupLogService = (ClientFareSetupLogService) SpringContextUtils.getBean("clientFareSetupLogService");

            ClientFareSetupEntity clientFareSetupEntity = new ClientFareSetupEntity();
            ClientFareSetupLogEntity clientFareSetupLogEntity = new ClientFareSetupLogEntity();

            ClientFareSetupEntity clientFareSetInfo = clientFareSetupService.queryObject(processTaskDto.getBusId());
            ClientFareSetupLogEntity clientFareSetLogInfo = clientFareSetupLogService.queryObject(processTaskDto.getBusId());

            TaskService taskService = (TaskService) SpringContextUtils.getBean("taskService");
            Task task = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).singleResult();
            if (null == task) {

                if (null != clientFareSetInfo && clientFareSetInfo.getAuditStatus() == CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex()) {
                    clientFareSetupEntity.setId(clientFareSetInfo.getId());
                    clientFareSetupEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());
                    clientFareSetupEntity.setAuditUser(processTaskDto.getDealId());
                    clientFareSetupEntity.setAuditTime(new Date());

                    clientFareSetupService.update(clientFareSetupEntity);
                }

                if (null != clientFareSetLogInfo && clientFareSetLogInfo.getAuditStatus() == CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex()) {

                    clientFareSetupLogEntity.setId(clientFareSetLogInfo.getId());
                    clientFareSetupLogEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());
                    clientFareSetupLogEntity.setAuditUser(processTaskDto.getDealId());
                    clientFareSetupLogEntity.setAuditTime(new Date());

                    clientFareSetupLogService.update(clientFareSetupLogEntity);
                }
            }
        } catch (Exception e) {
            logger.error("客户佣金套餐设置审批回调异常", e);
        }

    }
}
