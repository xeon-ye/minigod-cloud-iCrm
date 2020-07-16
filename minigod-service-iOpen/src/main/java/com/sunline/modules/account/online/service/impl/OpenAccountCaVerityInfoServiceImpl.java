package com.sunline.modules.account.online.service.impl;

import com.sunline.modules.account.online.dao.OpenAccountCaVerityInfoDao;
import com.sunline.modules.account.online.entity.OpenAccountCaVerityInfoEntity;
import com.sunline.modules.account.online.service.OpenAccountCaVerityInfoService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;

/**
 * CA认证信息表
 *
 * @author lcs
 * @date 2019-01-17 10:10:43
 */

@Service("openAccountCaVerityInfoService")
public class OpenAccountCaVerityInfoServiceImpl implements OpenAccountCaVerityInfoService {
	@Autowired
	private OpenAccountCaVerityInfoDao openAccountCaVerityInfoDao;
	
	@Override
	public OpenAccountCaVerityInfoEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountCaVerityInfoDao.queryObject(id);
	}
	
	@Override
	public List<OpenAccountCaVerityInfoEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountCaVerityInfoDao.queryList(map);
	}

    @Override
    public List<OpenAccountCaVerityInfoEntity> queryListByBean(OpenAccountCaVerityInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountCaVerityInfoDao.queryListByBean(entity);
    }

    @Override
    public OpenAccountCaVerityInfoEntity queryRecentByApplicationId(OpenAccountCaVerityInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountCaVerityInfoDao.queryRecentByApplicationId(entity);
    }

    @Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountCaVerityInfoDao.queryTotal(map);
	}
	
	@Override
	public int save(OpenAccountCaVerityInfoEntity openAccountCaVerityInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        openAccountCaVerityInfo.setId(Utils.uuid());
		return openAccountCaVerityInfoDao.save(openAccountCaVerityInfo);
	}
	
	@Override
	public int update(OpenAccountCaVerityInfoEntity openAccountCaVerityInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountCaVerityInfoDao.update(openAccountCaVerityInfo);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountCaVerityInfoDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountCaVerityInfoDao.deleteBatch(ids);
	}
	
}
