package com.sunline.modules.dbs.service.impl;

import com.sunline.modules.dbs.dao.DbsAreBankFlowDao;
import com.sunline.modules.dbs.entity.DbsAreBankFlowEntity;
import com.sunline.modules.dbs.service.DbsAreBankFlowService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;

/**
 * DBS银行手续费流水
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-05-16 13:20:24
 */

@Service("dbsAreBankFlowService")
public class DbsAreBankFlowServiceImpl implements DbsAreBankFlowService {
	@Autowired
	private DbsAreBankFlowDao dbsAreBankFlowDao;
	
	@Override
	public DbsAreBankFlowEntity queryObject(Long id){
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return dbsAreBankFlowDao.queryObject(id);
	}
	
	@Override
	public List<DbsAreBankFlowEntity> queryList(Map<String, Object> map){
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return dbsAreBankFlowDao.queryList(map);
	}

    @Override
    public List<DbsAreBankFlowEntity> queryListByBean(DbsAreBankFlowEntity entity) {
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsAreBankFlowDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return dbsAreBankFlowDao.queryTotal(map);
	}
	
	@Override
	public int save(DbsAreBankFlowEntity dbsAreBankFlow){
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		//dbsAreBankFlow.setId(Utils.uuid());
		return dbsAreBankFlowDao.save(dbsAreBankFlow);
	}
	
	@Override
	public int update(DbsAreBankFlowEntity dbsAreBankFlow){
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return dbsAreBankFlowDao.update(dbsAreBankFlow);
	}
	
	@Override
	public int delete(Long id){
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return dbsAreBankFlowDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
		DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return dbsAreBankFlowDao.deleteBatch(ids);
	}
	
}
