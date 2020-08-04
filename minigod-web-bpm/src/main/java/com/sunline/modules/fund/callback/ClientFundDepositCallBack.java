package com.sunline.modules.fund.callback;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SpringContextUtils;
import com.sunline.modules.fund.model.ClientFundDepositWorkFlow;
import com.sunline.modules.fund.service.ClientFundDepositApplicationService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ClientFundDepositCallBack {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 入金金业务工作流统一回调
     *
     * @param processTaskDto
     * @param map
     */
    public void callback(ProcessTaskDto processTaskDto, Map<String, Object> map) {
        try {
            ClientFundDepositWorkFlow workFlow = new ClientFundDepositWorkFlow();
            workFlow.setApplicationId(processTaskDto.getBusId());
            TaskService taskService = (TaskService) SpringContextUtils.getBean("taskService");
            Task task = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).singleResult();
            if (null != task) {
                workFlow.setCurrentNode(task.getName());
            } else {
                workFlow.setCurrentNode(CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "5"));
            }
            ClientFundDepositApplicationService fundDepositApplicationService = (ClientFundDepositApplicationService) SpringContextUtils.getBean("clientFundDepositApplicationService");
            fundDepositApplicationService.approveCallback(workFlow, processTaskDto, task);
        } catch (Exception e) {
            logger.error("入金审核回调异常", e);
        }
    }
}
