package com.sunline.modules.account.professional.callback;

import com.sunline.modules.account.professional.service.ProfessionalInvestorApplicationService;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SpringContextUtils;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ProfessionalInvestorCallBack {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 专业投资者认定业务工作流统一回调
     *
     * @param processTaskDto
     */
    public void callback(ProcessTaskDto processTaskDto, Map<String, Object> map) {
        try {
            String currentNode = "";
            TaskService taskService = (TaskService) SpringContextUtils.getBean("taskService");
            Task task = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).singleResult();
            if (null != task) {
                currentNode=task.getName();
            } else {
                currentNode= CodeUtils.getCodeName("PROFESSIONAL_NODE_NAME", "3");
            }
            ProfessionalInvestorApplicationService service = (ProfessionalInvestorApplicationService) SpringContextUtils.getBean("professionalInvestorApplicationService");
            service.approveCallback(currentNode, processTaskDto,task);
        } catch (Exception e) {
            logger.error("专业投资者审核回调异常", e);
        }
    }
}
