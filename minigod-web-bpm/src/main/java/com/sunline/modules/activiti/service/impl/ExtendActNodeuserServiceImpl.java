package com.sunline.modules.activiti.service.impl;

import com.sunline.modules.activiti.dao.ExtendActNodeuserDao;
import com.sunline.modules.activiti.entity.ExtendActNodeuserEntity;
import com.sunline.modules.activiti.service.ExtendActNodeuserService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("extendActNodeuserService")
public class ExtendActNodeuserServiceImpl implements ExtendActNodeuserService {
	@Autowired
	private ExtendActNodeuserDao extendActNodeuserDao;
	
	@Override
	public ExtendActNodeuserEntity queryObject(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActNodeuserDao.queryObject(id);
	}
	
	@Override
	public List<ExtendActNodeuserEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActNodeuserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActNodeuserDao.queryTotal(map);
	}
	
	@Override
	public void save(ExtendActNodeuserEntity extendActNodeuser){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActNodeuserDao.save(extendActNodeuser);
	}
	
	@Override
	public void update(ExtendActNodeuserEntity extendActNodeuser){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActNodeuserDao.update(extendActNodeuser);
	}
	
	@Override
	public void delete(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActNodeuserDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActNodeuserDao.deleteBatch(ids);
	}

	@Override
	public List<ExtendActNodeuserEntity> getNodeUserByNodeId(String nodeId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActNodeuserDao.getNodeUserByNodeId(nodeId);
	}
}
