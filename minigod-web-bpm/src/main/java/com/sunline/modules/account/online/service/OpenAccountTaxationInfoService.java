package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.CustomerAccountOpenImgEntity;
import com.sunline.modules.account.online.entity.OpenAccountTaxationInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 税务信息表
 * 
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */
public interface OpenAccountTaxationInfoService {
	
	OpenAccountTaxationInfoEntity queryObject(Long id);
	
	List<OpenAccountTaxationInfoEntity> queryList(Map<String, Object> map);

    List<OpenAccountTaxationInfoEntity> queryListByBean(OpenAccountTaxationInfoEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(OpenAccountTaxationInfoEntity openAccountTaxationInfo);
	
	int update(OpenAccountTaxationInfoEntity openAccountTaxationInfo);
	
	int delete(Long id);


	int deleteBatch(Long[] ids);

	int saveBatch(List<OpenAccountTaxationInfoEntity> list);
	
	public List<OpenAccountTaxationInfoEntity> queryByApplicationId(String applicationId);

    /**
     * 按applicationId删除
     * @param applicationId
     * @return
     */
    int deleteByApplicationId(String applicationId);
}
