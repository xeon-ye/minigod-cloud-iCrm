package com.sunline.modules.dbs.service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.dbs.entity.SecItemaccountApplyEntity;

/**
 * 中银子账号配置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-07-03 11:22:55
 */
public interface SecItemaccountApplyService {
	
	SecItemaccountApplyEntity queryObject(Long id);
	
	List<SecItemaccountApplyEntity> queryList(Map<String, Object> map);

    List<SecItemaccountApplyEntity> queryListByBean(SecItemaccountApplyEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(SecItemaccountApplyEntity secItemaccountApply);
	
	int update(SecItemaccountApplyEntity secItemaccountApply);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);
}
