package com.sunline.modules.account.online.service;


import com.sunline.modules.account.online.entity.OpenAccountCaVerityInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * CA认证信息表
 * 
 * @author lcs
 * @date 2019-01-17 10:10:43
 */
public interface OpenAccountCaVerityInfoService {
	
	OpenAccountCaVerityInfoEntity queryObject(Long id);
	
	List<OpenAccountCaVerityInfoEntity> queryList(Map<String, Object> map);

    List<OpenAccountCaVerityInfoEntity> queryListByBean(OpenAccountCaVerityInfoEntity entity);

    /**
     * 查询最新的一条记录
     * @param entity
     * @return
     */
    OpenAccountCaVerityInfoEntity queryRecentByApplicationId(OpenAccountCaVerityInfoEntity entity);

	int queryTotal(Map<String, Object> map);
	
	int save(OpenAccountCaVerityInfoEntity openAccountCaVerityInfo);
	
	int update(OpenAccountCaVerityInfoEntity openAccountCaVerityInfo);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);
}
