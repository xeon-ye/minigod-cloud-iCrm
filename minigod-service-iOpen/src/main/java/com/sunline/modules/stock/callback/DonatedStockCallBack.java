package com.sunline.modules.stock.callback;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SpringContextUtils;
import com.sunline.modules.stock.model.DonatedStockApproveInfo;
import com.sunline.modules.stock.service.DonatedStockApplicationInfoService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author fuyy
 * @createDate 2018/12/7
 * @description
 */
@Component
public class DonatedStockCallBack {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void callback(ProcessTaskDto processTaskDto, Map<String, Object> map) {

        try {


            DonatedStockApproveInfo donatedStockApproveInfo = new DonatedStockApproveInfo();
            donatedStockApproveInfo.setApplicationId(processTaskDto.getBusId());

            TaskService taskService = (TaskService) SpringContextUtils.getBean("taskService");
            Task task = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).singleResult();
            if (null != task) {
                donatedStockApproveInfo.setCurrentNode(task.getName());
            } else {
                donatedStockApproveInfo.setCurrentNode(CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "6"));
            }

            DonatedStockApplicationInfoService donatedStockService = (DonatedStockApplicationInfoService) SpringContextUtils.getBean("donatedStockApplicationInfoService");
            donatedStockService.approveCallback(donatedStockApproveInfo, processTaskDto, task);


        } catch (Exception e) {
            logger.error("赠股审批回调异常", e);
        }
    }

}
