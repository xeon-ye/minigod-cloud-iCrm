package com.sunline.modules.commission.service;

import com.sunline.modules.commission.entity.ClientFareSetupEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;
import java.util.Map;

/**
 * 客户佣金套餐设置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-23 17:27:15
 */
public interface ClientFareSetupService {
	
	ClientFareSetupEntity queryObject(Object id);
	
	Page<ClientFareSetupEntity> queryList(ClientFareSetupEntity entity, int pageNum);

    List<ClientFareSetupEntity> queryListByBean(ClientFareSetupEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientFareSetupEntity clientFareSetup);
	
	int update(ClientFareSetupEntity clientFareSetup);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);

    /**
     * 获取客户设佣信息
     *
     * @param entity
     * @return
     */
    List<ClientFareSetupEntity> getClientFareSetupInfo(ClientFareSetupEntity entity);

    int updateByBusId(ClientFareSetupEntity clientFareSetup);

    /**
     * 查询是否 处于 审核中的记录
     * @param entity
     * @return
     */
    List<ClientFareSetupEntity> checkAuditStatus(ClientFareSetupEntity entity);

}
