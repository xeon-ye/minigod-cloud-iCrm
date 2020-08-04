package com.sunline.modules.activiti.service.impl;

import com.sunline.modules.activiti.dao.ExtendActNodefieldDao;
import com.sunline.modules.activiti.entity.ExtendActNodefieldEntity;
import com.sunline.modules.activiti.service.ExtendActNodefieldService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("extendActNodefieldService")
public class ExtendActNodefieldServiceImpl implements ExtendActNodefieldService {
	@Autowired
	private ExtendActNodefieldDao extendActNodefieldDao;
	
	@Override
	public ExtendActNodefieldEntity queryObject(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActNodefieldDao.queryObject(id);
	}
	
	@Override
	public List<ExtendActNodefieldEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActNodefieldDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActNodefieldDao.queryTotal(map);
	}
	
	@Override
	public void save(ExtendActNodefieldEntity extendActNodefield){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActNodefieldDao.save(extendActNodefield);
	}
	
	@Override
	public void update(ExtendActNodefieldEntity extendActNodefield){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActNodefieldDao.update(extendActNodefield);
	}
	
	@Override
	public void delete(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActNodefieldDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActNodefieldDao.deleteBatch(ids);
	}

	@Override
	public List<ExtendActNodefieldEntity> queryByNodes(List<String> nodes) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActNodefieldDao.queryByNodes(nodes);
	}
}
