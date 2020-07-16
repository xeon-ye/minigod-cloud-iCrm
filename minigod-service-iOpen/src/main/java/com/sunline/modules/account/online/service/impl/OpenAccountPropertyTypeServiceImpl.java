package com.sunline.modules.account.online.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.account.online.dao.OpenAccountPropertyTypeDao;
import com.sunline.modules.account.online.entity.OpenAccountPropertyTypeEntity;
import com.sunline.modules.account.online.entity.OpenAccountTaxationInfoEntity;
import com.sunline.modules.account.online.service.OpenAccountPropertyTypeService;

/**
 * 财产种类表
 *
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */

@Service("openAccountPropertyTypeService")
public class OpenAccountPropertyTypeServiceImpl implements OpenAccountPropertyTypeService {
	@Autowired
	private OpenAccountPropertyTypeDao openAccountPropertyTypeDao;
	
	@Override
	public OpenAccountPropertyTypeEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountPropertyTypeDao.queryObject(id);
	}
	
	@Override
	public List<OpenAccountPropertyTypeEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountPropertyTypeDao.queryList(map);
	}

    @Override
    public List<OpenAccountPropertyTypeEntity> queryListByBean(OpenAccountPropertyTypeEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountPropertyTypeDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountPropertyTypeDao.queryTotal(map);
	}
	
	@Override
	public int save(OpenAccountPropertyTypeEntity openAccountPropertyType){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountPropertyTypeDao.save(openAccountPropertyType);
	}
	
	@Override
	public int update(OpenAccountPropertyTypeEntity openAccountPropertyType){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountPropertyTypeDao.update(openAccountPropertyType);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountPropertyTypeDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountPropertyTypeDao.deleteBatch(ids);
	}

    @Override
    public int saveBatch(List<OpenAccountPropertyTypeEntity> list) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountPropertyTypeDao.saveBatch(list);
    }

	@Override
	public List<OpenAccountPropertyTypeEntity> queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		OpenAccountPropertyTypeEntity queryCondition = new OpenAccountPropertyTypeEntity();
		queryCondition.setApplicationId(applicationId);
		return openAccountPropertyTypeDao.queryListByBean(queryCondition);	
	}

    @Override
    public int deleteByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
            return openAccountPropertyTypeDao.deleteByApplicationId(applicationId);
    }
}
