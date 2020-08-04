package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.OpenAccountBankVerityInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 银行卡四要素验证信息表
 * 
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */
public interface OpenAccountBankVerityInfoService {
	
	OpenAccountBankVerityInfoEntity queryObject(Long id);
	
	List<OpenAccountBankVerityInfoEntity> queryList(Map<String, Object> map);

    List<OpenAccountBankVerityInfoEntity> queryListByBean(OpenAccountBankVerityInfoEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(OpenAccountBankVerityInfoEntity openAccountBankVerityInfo);
	
	int update(OpenAccountBankVerityInfoEntity openAccountBankVerityInfo);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);

	int saveBatch(List<OpenAccountBankVerityInfoEntity> list);

    List<OpenAccountBankVerityInfoEntity> queryByApplicationId(String applicationId);
}
