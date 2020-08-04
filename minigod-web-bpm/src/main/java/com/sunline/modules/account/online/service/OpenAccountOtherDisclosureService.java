package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.OpenAccountOtherDisclosureEntity;

import java.util.List;
import java.util.Map;

/**
 * 其他信息披露表
 * 
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */
public interface OpenAccountOtherDisclosureService {
	
	OpenAccountOtherDisclosureEntity queryObject(Long id);
	
	List<OpenAccountOtherDisclosureEntity> queryList(Map<String, Object> map);

    List<OpenAccountOtherDisclosureEntity> queryListByBean(OpenAccountOtherDisclosureEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(OpenAccountOtherDisclosureEntity openAccountOtherDisclosure);
	
	int update(OpenAccountOtherDisclosureEntity openAccountOtherDisclosure);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);

	int saveBatch(List<OpenAccountOtherDisclosureEntity> list);
	
	List<OpenAccountOtherDisclosureEntity> queryByApplicationId(String applicationId);

    /**
     * 按applicationId删除
     * @param applicationId
     * @return
     */
	int deleteByApplicationId(String applicationId);
}
