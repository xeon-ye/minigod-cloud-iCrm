package com.sunline.modules.commission.service;

import com.sunline.modules.commission.entity.ClientFreeCommSetEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户免佣套餐设置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 19:40:27
 */
public interface ClientFreeCommSetService {
	
	ClientFreeCommSetEntity queryObject(Integer id);
	
	List<ClientFreeCommSetEntity> queryList(Map<String, Object> map);

    List<ClientFreeCommSetEntity> queryListByBean(ClientFreeCommSetEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientFreeCommSetEntity clientFreeCommissionSetup);
	
	int update(ClientFreeCommSetEntity clientFreeCommissionSetup);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);

    /**
     * 获取符合免佣设置的客户列表
     * @param entity
     * @return
     */
    List<ClientFreeCommSetEntity> getIsFreeCommClientInfo(ClientFreeCommSetEntity entity);
}
