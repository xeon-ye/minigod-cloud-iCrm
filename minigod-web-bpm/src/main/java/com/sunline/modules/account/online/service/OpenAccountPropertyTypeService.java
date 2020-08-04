package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.OpenAccountPropertyTypeEntity;
import com.sunline.modules.account.online.entity.OpenAccountTaxationInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 财产种类表
 * 
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */
public interface OpenAccountPropertyTypeService {
	
	OpenAccountPropertyTypeEntity queryObject(Long id);
	
	List<OpenAccountPropertyTypeEntity> queryList(Map<String, Object> map);

    List<OpenAccountPropertyTypeEntity> queryListByBean(OpenAccountPropertyTypeEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(OpenAccountPropertyTypeEntity openAccountPropertyType);
	
	int update(OpenAccountPropertyTypeEntity openAccountPropertyType);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);

    int saveBatch(List<OpenAccountPropertyTypeEntity> list);
    
    public List<OpenAccountPropertyTypeEntity> queryByApplicationId(String applicationId);

    /**
     * 按applicationId删除
     * @param applicationId
     * @return
     */
    int deleteByApplicationId(String applicationId);
}
