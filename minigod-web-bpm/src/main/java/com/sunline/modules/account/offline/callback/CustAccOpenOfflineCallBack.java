package com.sunline.modules.account.offline.callback;

import com.sunline.modules.account.offline.service.CustAccOpenOfflineService;
import com.sunline.modules.account.online.model.CustomerAccOpenApproveInfo;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SpringContextUtils;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CustAccOpenOfflineCallBack {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void callback(ProcessTaskDto processTaskDto, Map<String, Object> map) {

        try {

//            logger.info("==========线下开户审批回调Start==========");

            CustomerAccOpenApproveInfo customerAccountOpenApproveInfo = new CustomerAccOpenApproveInfo();
            customerAccountOpenApproveInfo.setApplicationId(processTaskDto.getBusId());

            TaskService taskService = (TaskService) SpringContextUtils.getBean("taskService");
            Task task = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).singleResult();
            if (null != task) {
                customerAccountOpenApproveInfo.setCurrentNode(task.getName());
            } else {
                customerAccountOpenApproveInfo.setCurrentNode(CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "6"));
            }

            CustAccOpenOfflineService custAccOpenOfflineService = (CustAccOpenOfflineService) SpringContextUtils.getBean("custAccOpenOfflineService");
            custAccOpenOfflineService.approveCallback(customerAccountOpenApproveInfo, processTaskDto,task);

//            logger.info("==========线下开户审批回调end==========");

        } catch (Exception e) {
            logger.error("线下开户审批回调异常", e);
        }
    }

}
