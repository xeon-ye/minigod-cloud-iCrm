package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.OpenAccountOperatorLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户开户业务操作员日志表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-11-01 09:34:03
 */
public interface OpenAccountOperatorLogService {
	
	OpenAccountOperatorLogEntity queryObject(Long id);
	
	List<OpenAccountOperatorLogEntity> queryList(Map<String, Object> map);

    List<OpenAccountOperatorLogEntity> queryListByBean(OpenAccountOperatorLogEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(OpenAccountOperatorLogEntity openAccountOperatorLog);
	
	int update(OpenAccountOperatorLogEntity openAccountOperatorLog);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);
}
