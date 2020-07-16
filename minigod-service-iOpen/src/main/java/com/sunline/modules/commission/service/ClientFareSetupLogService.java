package com.sunline.modules.commission.service;

import com.sunline.modules.commission.entity.ClientFareSetupLogEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;
import java.util.Map;

/**
 * 客户佣金套餐设置日志表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-23 17:34:01
 */
public interface ClientFareSetupLogService {
	
	ClientFareSetupLogEntity queryObject(Object id);

	ClientFareSetupLogEntity queryClientFareInfo(ClientFareSetupLogEntity entity);

    Page<ClientFareSetupLogEntity> queryList(ClientFareSetupLogEntity entity,int pageNum);

    Page<ClientFareSetupLogEntity> queryAcceptList(ClientFareSetupLogEntity entity,int pageNum);

    List<ClientFareSetupLogEntity> queryListByBean(ClientFareSetupLogEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientFareSetupLogEntity clientFareSetupLog);
	
	int update(ClientFareSetupLogEntity clientFareSetupLog);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);

    int updateByBusId(ClientFareSetupLogEntity clientFareSetupLog);
}
