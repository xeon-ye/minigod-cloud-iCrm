package com.sunline.modules.activiti.service.impl;

import com.google.common.collect.Maps;
import com.sunline.modules.activiti.dao.ExtendActFlowbusDao;
import com.sunline.modules.activiti.entity.ExtendActFlowbusEntity;
import com.sunline.modules.activiti.service.ExtendActFlowbusService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service("extendActFlowbusService")
public class ExtendActFlowbusServiceImpl implements ExtendActFlowbusService {
	@Autowired
	private ExtendActFlowbusDao extendActFlowbusDao;
	
	@Override
	public ExtendActFlowbusEntity queryObject(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActFlowbusDao.queryObject(id);
	}

	@Override
	public void save(ExtendActFlowbusEntity extendActFlowbus){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActFlowbusDao.save(extendActFlowbus);
	}
	
	@Override
	public void update(ExtendActFlowbusEntity extendActFlowbus){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActFlowbusDao.update(extendActFlowbus);
	}
	@Override
	public void delete(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActFlowbusDao.delete(id);
	}

	@Override
	public int updateByBusId(ExtendActFlowbusEntity extendActFlowbusEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActFlowbusDao.updateByBusId(extendActFlowbusEntity);
	}

	@Override
	public ExtendActFlowbusEntity queryByBusIdInsId(String instanceId, String busId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		Map<String,Object> params = Maps.newHashMap();
		params.put("instanceId",instanceId);
		params.put("busId",busId);
		return extendActFlowbusDao.queryByBusIdInsId(params);
	}
}
