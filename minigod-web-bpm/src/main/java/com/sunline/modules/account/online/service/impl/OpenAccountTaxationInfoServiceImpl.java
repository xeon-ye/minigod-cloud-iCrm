package com.sunline.modules.account.online.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.account.online.dao.OpenAccountTaxationInfoDao;
import com.sunline.modules.account.online.entity.CustomerAccountOpenImgEntity;
import com.sunline.modules.account.online.entity.OpenAccountTaxationInfoEntity;
import com.sunline.modules.account.online.service.OpenAccountTaxationInfoService;

/**
 * 税务信息表
 *
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */

@Service("openAccountTaxationInfoService")
public class OpenAccountTaxationInfoServiceImpl implements OpenAccountTaxationInfoService {
	@Autowired
	private OpenAccountTaxationInfoDao openAccountTaxationInfoDao;
	
	@Override
	public OpenAccountTaxationInfoEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountTaxationInfoDao.queryObject(id);
	}
	
	@Override
	public List<OpenAccountTaxationInfoEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountTaxationInfoDao.queryList(map);
	}

    @Override
    public List<OpenAccountTaxationInfoEntity> queryListByBean(OpenAccountTaxationInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountTaxationInfoDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountTaxationInfoDao.queryTotal(map);
	}
	
	@Override
	public int save(OpenAccountTaxationInfoEntity openAccountTaxationInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountTaxationInfoDao.save(openAccountTaxationInfo);
	}
	
	@Override
	public int update(OpenAccountTaxationInfoEntity openAccountTaxationInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountTaxationInfoDao.update(openAccountTaxationInfo);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountTaxationInfoDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountTaxationInfoDao.deleteBatch(ids);
	}

    @Override
    public int saveBatch(List<OpenAccountTaxationInfoEntity> list) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountTaxationInfoDao.saveBatch(list);
    }

	@Override
	public List<OpenAccountTaxationInfoEntity> queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		OpenAccountTaxationInfoEntity queryCondition = new OpenAccountTaxationInfoEntity();
		queryCondition.setApplicationId(applicationId);
		return openAccountTaxationInfoDao.queryListByBean(queryCondition);		
	}

    /**
     * 按applicationId删除
     * @param applicationId
     * @return
     */
    @Override
    public int deleteByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountTaxationInfoDao.deleteByApplicationId(applicationId);
    }
}
