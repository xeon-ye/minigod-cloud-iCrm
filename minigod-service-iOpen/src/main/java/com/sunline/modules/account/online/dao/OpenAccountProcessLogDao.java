package com.sunline.modules.account.online.dao;

import com.sunline.modules.account.online.entity.OpenAccountProcessLogEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户开户业务流程日志表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-10-11 20:55:10
 */
@Mapper
public interface OpenAccountProcessLogDao extends BaseDao<OpenAccountProcessLogEntity> {
	int updateByTaskId(OpenAccountProcessLogEntity openAccountProcessLog);
	
	OpenAccountProcessLogEntity queryObjectByApplicationId(String applicationId);
	
}
