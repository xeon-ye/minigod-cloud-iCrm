package com.sunline.modules.account.online.callback;

import com.sunline.modules.account.online.model.CustomerAccOpenApproveInfo;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SpringContextUtils;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Tim
 * @createDate 2020/8/5
 * @description
 */
@Component
public class CustomerAccMarginOpenApproveCallBack {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MessageSendInfoService messageSendInfoService;

    public void callback(ProcessTaskDto processTaskDto, Map<String, Object> map) {

        try {

            //logger.info("==========增开审批回调Start==========");

            CustomerAccOpenApproveInfo customerAccountOpenApproveInfo = new CustomerAccOpenApproveInfo();
            customerAccountOpenApproveInfo.setApplicationId(processTaskDto.getBusId());

            TaskService taskService = (TaskService) SpringContextUtils.getBean("taskService");
            Task task = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).singleResult();
            if (null != task) {
                customerAccountOpenApproveInfo.setCurrentNode(task.getName());
            } else {
                customerAccountOpenApproveInfo.setCurrentNode(CodeUtils.getCodeName("OPEN_ACCOUNT_MARGIN_NODE_NAME", "5"));
            }

            CustomerAccOpenService customerAccountOpenService = (CustomerAccOpenService) SpringContextUtils.getBean("customerAccountOpenService");
            customerAccountOpenService.approveMarginCallback(customerAccountOpenApproveInfo, processTaskDto,task);

            //logger.info("==========增开审批回调End==========");

        } catch (Exception e) {
            logger.error("增开审批回调异常", e);
        }
    }
}
