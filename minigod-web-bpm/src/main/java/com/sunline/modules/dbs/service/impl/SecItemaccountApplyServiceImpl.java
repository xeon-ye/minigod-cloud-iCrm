package com.sunline.modules.dbs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.dbs.dao.SecItemaccountApplyDao;
import com.sunline.modules.dbs.entity.SecItemaccountApplyEntity;
import com.sunline.modules.dbs.service.SecItemaccountApplyService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;

/**
 * 中银子账号配置表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-07-03 11:22:55
 */

@Service("secItemaccountApplyService")
public class SecItemaccountApplyServiceImpl implements SecItemaccountApplyService {
	@Autowired
	private SecItemaccountApplyDao secItemaccountApplyDao;
	
	@Override
	public SecItemaccountApplyEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
		return secItemaccountApplyDao.queryObject(id);
	}
	
	@Override
	public List<SecItemaccountApplyEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
		return secItemaccountApplyDao.queryList(map);
	}

    @Override
    public List<SecItemaccountApplyEntity> queryListByBean(SecItemaccountApplyEntity entity) {
    	DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
        return secItemaccountApplyDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
		return secItemaccountApplyDao.queryTotal(map);
	}
	
	@Override
	public int save(SecItemaccountApplyEntity secItemaccountApply){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
		return secItemaccountApplyDao.save(secItemaccountApply);
	}
	
	@Override
	public int update(SecItemaccountApplyEntity secItemaccountApply){
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
        return secItemaccountApplyDao.update(secItemaccountApply);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
        return secItemaccountApplyDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
        return secItemaccountApplyDao.deleteBatch(ids);
	}
	
}
