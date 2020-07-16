package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.OpenAccountProcessLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户开户业务流程日志表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-10-11 20:55:10
 */
public interface OpenAccountProcessLogService {
	
	OpenAccountProcessLogEntity queryObject(Long id);
	
	List<OpenAccountProcessLogEntity> queryList(Map<String, Object> map);

    List<OpenAccountProcessLogEntity> queryListByBean(OpenAccountProcessLogEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(OpenAccountProcessLogEntity openAccountProcessLog);
	
	int update(OpenAccountProcessLogEntity openAccountProcessLog);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);
	
	int updateByTaskId(OpenAccountProcessLogEntity openAccountProcessLog);
	
	/*
	 * 通过交易流水号获取最大一条记录
	 */
	OpenAccountProcessLogEntity queryObjectByApplicationId(String applicationId);
}
