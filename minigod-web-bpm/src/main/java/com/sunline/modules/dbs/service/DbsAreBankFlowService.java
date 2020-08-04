package com.sunline.modules.dbs.service;

import com.sunline.modules.dbs.entity.DbsAreBankFlowEntity;

import java.util.List;
import java.util.Map;

/**
 * DBS银行手续费流水
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-05-16 13:20:24
 */
public interface DbsAreBankFlowService {
	
	DbsAreBankFlowEntity queryObject(Long id);
	
	List<DbsAreBankFlowEntity> queryList(Map<String, Object> map);

    List<DbsAreBankFlowEntity> queryListByBean(DbsAreBankFlowEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(DbsAreBankFlowEntity dbsAreBankFlow);
	
	int update(DbsAreBankFlowEntity dbsAreBankFlow);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);
}
