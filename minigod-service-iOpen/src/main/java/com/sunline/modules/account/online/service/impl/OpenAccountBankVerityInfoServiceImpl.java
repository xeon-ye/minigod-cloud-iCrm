package com.sunline.modules.account.online.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.account.online.dao.*;
import com.sunline.modules.account.online.entity.OpenAccountBankVerityInfoEntity;
import com.sunline.modules.account.online.service.OpenAccountBankVerityInfoService;

/**
 * 银行卡四要素验证信息表
 *
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */

@Service("openAccountBankVerityInfoService")
public class OpenAccountBankVerityInfoServiceImpl implements OpenAccountBankVerityInfoService {
	@Autowired
	private OpenAccountBankVerityInfoDao openAccountBankVerityInfoDao;
	
	@Override
	public OpenAccountBankVerityInfoEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountBankVerityInfoDao.queryObject(id);
	}
	
	@Override
	public List<OpenAccountBankVerityInfoEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountBankVerityInfoDao.queryList(map);
	}

    @Override
    public List<OpenAccountBankVerityInfoEntity> queryListByBean(OpenAccountBankVerityInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBankVerityInfoDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountBankVerityInfoDao.queryTotal(map);
	}
	
	@Override
	public int save(OpenAccountBankVerityInfoEntity openAccountBankVerityInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountBankVerityInfoDao.save(openAccountBankVerityInfo);
	}
	
	@Override
	public int update(OpenAccountBankVerityInfoEntity openAccountBankVerityInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBankVerityInfoDao.update(openAccountBankVerityInfo);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBankVerityInfoDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBankVerityInfoDao.deleteBatch(ids);
	}

    @Override
    public int saveBatch(List<OpenAccountBankVerityInfoEntity> list) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBankVerityInfoDao.saveBatch(list);
    }

    @Override
    public List<OpenAccountBankVerityInfoEntity> queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        OpenAccountBankVerityInfoEntity queryCondition = new OpenAccountBankVerityInfoEntity();
        queryCondition.setApplicationId(applicationId);
        return openAccountBankVerityInfoDao.queryListByBean(queryCondition);
    }
}
