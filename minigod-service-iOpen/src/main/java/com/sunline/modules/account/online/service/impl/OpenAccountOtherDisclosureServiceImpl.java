package com.sunline.modules.account.online.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.account.online.dao.OpenAccountOtherDisclosureDao;
import com.sunline.modules.account.online.entity.OpenAccountOtherDisclosureEntity;
import com.sunline.modules.account.online.entity.OpenAccountTaxationInfoEntity;
import com.sunline.modules.account.online.service.OpenAccountOtherDisclosureService;

/**
 * 其他信息披露表
 *
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */

@Service("openAccountOtherDisclosureService")
public class OpenAccountOtherDisclosureServiceImpl implements OpenAccountOtherDisclosureService {
	@Autowired
	private OpenAccountOtherDisclosureDao openAccountOtherDisclosureDao;
	
	@Override
	public OpenAccountOtherDisclosureEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountOtherDisclosureDao.queryObject(id);
	}
	
	@Override
	public List<OpenAccountOtherDisclosureEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountOtherDisclosureDao.queryList(map);
	}

    @Override
    public List<OpenAccountOtherDisclosureEntity> queryListByBean(OpenAccountOtherDisclosureEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOtherDisclosureDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountOtherDisclosureDao.queryTotal(map);
	}
	
	@Override
	public int save(OpenAccountOtherDisclosureEntity openAccountOtherDisclosure){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountOtherDisclosureDao.save(openAccountOtherDisclosure);
	}
	
	@Override
	public int update(OpenAccountOtherDisclosureEntity openAccountOtherDisclosure){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOtherDisclosureDao.update(openAccountOtherDisclosure);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOtherDisclosureDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOtherDisclosureDao.deleteBatch(ids);
	}

    @Override
    public int saveBatch(List<OpenAccountOtherDisclosureEntity> list) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOtherDisclosureDao.saveBatch(list);
    }

	@Override
	public List<OpenAccountOtherDisclosureEntity> queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		OpenAccountOtherDisclosureEntity queryCondition = new OpenAccountOtherDisclosureEntity();
		queryCondition.setApplicationId(applicationId);
		return openAccountOtherDisclosureDao.queryListByBean(queryCondition);
	}

    /**
     * 按applicationId删除
     * @param applicationId
     * @return
     */
    @Override
    public int deleteByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOtherDisclosureDao.deleteByApplicationId(applicationId);
    }
}
