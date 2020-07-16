package com.sunline.modules.fund.callback;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SpringContextUtils;
import com.sunline.modules.fund.model.ClientFundWithdrawApplyInfo;
import com.sunline.modules.fund.service.ClientFundWithdrawApplyService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 出金申请工作流回调处理
 * @author: Larry Lai
 * @date: 2019/4/2 13:47
 * @version: v1.0
 */

@Component
public class ClientFundWithdrawCallBack {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 出金业务工作流统一回调
     *
     * @param processTaskDto
     * @param map
     */
    public void callback(ProcessTaskDto processTaskDto, Map<String, Object> map) {

        try {

            ClientFundWithdrawApplyInfo clientFundWithdrawApplyInfo = new ClientFundWithdrawApplyInfo();
            clientFundWithdrawApplyInfo.setApplicationId(processTaskDto.getBusId());

            TaskService taskService = (TaskService) SpringContextUtils.getBean("taskService");
            Task task = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).singleResult();
            if (null != task) {
                clientFundWithdrawApplyInfo.setCurrentNode(task.getName());
            } else {
                clientFundWithdrawApplyInfo.setCurrentNode(CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "5"));
            }

            ClientFundWithdrawApplyService clientFundWithdrawApplyService = (ClientFundWithdrawApplyService) SpringContextUtils.getBean("clientFundWithdrawApplyService");
            clientFundWithdrawApplyService.approveCallback(clientFundWithdrawApplyInfo, processTaskDto, task);

        } catch (Exception e) {
            logger.error("出金审核回调异常", e);
        }
    }
}
