package com.sunline.modules.account.offline.service;

import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import org.activiti.engine.task.Task;

import com.sunline.modules.account.online.model.CustomerAccOpenApproveInfo;
import com.sunline.modules.activiti.dto.ProcessTaskDto;

/**
*类的功能描述
*
* @author fuyy
* @date 2018年10月29日 下午6:17:16
* 
*/
public interface CustAccOpenOfflineService {
	 void approveCallback(CustomerAccOpenApproveInfo customerAccountOpenApproveInfo, ProcessTaskDto processTaskDto, Task task);
	boolean terminateAccountOpenApplication(CustomerAccountOpenApplyEntity applicationInfo, ProcessTaskDto processTaskDto, int rejectType);
}

