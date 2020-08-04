package com.sunline.modules.commission.service;

import com.sunline.modules.commission.entity.ClientFreeCommInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户免佣套餐信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 19:55:32
 */
public interface ClientFreeCommInfoService {
	
	ClientFreeCommInfoEntity queryObject(Integer id);
	
	List<ClientFreeCommInfoEntity> queryList(Map<String, Object> map);

    List<ClientFreeCommInfoEntity> queryListByBean(ClientFreeCommInfoEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientFreeCommInfoEntity clientFreeCommissionInfo);
	
	int update(ClientFreeCommInfoEntity clientFreeCommissionInfo);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
