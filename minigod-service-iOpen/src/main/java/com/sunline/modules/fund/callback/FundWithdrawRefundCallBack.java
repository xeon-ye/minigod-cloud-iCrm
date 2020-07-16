package com.sunline.modules.fund.callback;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SpringContextUtils;
import com.sunline.modules.fund.model.FundWithdrawRefundApplyInfo;
import com.sunline.modules.fund.service.FundWithdrawRefundApplyService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 出金退款工作流回调处理
 * @author: Larry Lai
 * @date: 2019/4/2 13:47
 * @version: v1.0
 */

@Component
public class FundWithdrawRefundCallBack {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 出金退款工作流统一回调
     *
     * @param processTaskDto
     * @param map
     */
    public void callback(ProcessTaskDto processTaskDto, Map<String, Object> map) {

        try {

            FundWithdrawRefundApplyInfo fundWithdrawRefundApplyInfo = new FundWithdrawRefundApplyInfo();
            fundWithdrawRefundApplyInfo.setApplicationId(processTaskDto.getBusId());

            TaskService taskService = (TaskService) SpringContextUtils.getBean("taskService");
            Task task = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).singleResult();
            if (null != task) {
                fundWithdrawRefundApplyInfo.setCurrentNode(task.getName());
            } else {
                fundWithdrawRefundApplyInfo.setCurrentNode(CodeUtils.getCodeName("FUND_WITHDRAW_REFUND_NODE_NAME", "3"));
            }

            FundWithdrawRefundApplyService fundWithdrawRefundApplyService = (FundWithdrawRefundApplyService) SpringContextUtils.getBean("fundWithdrawRefundApplyService");
            fundWithdrawRefundApplyService.approveCallback(fundWithdrawRefundApplyInfo, processTaskDto, task);

        } catch (Exception e) {
            logger.error("出金退款审核回调异常", e);
        }
    }
}
