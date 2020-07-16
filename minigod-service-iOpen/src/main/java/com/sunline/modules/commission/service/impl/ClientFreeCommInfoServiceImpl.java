package com.sunline.modules.commission.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.commission.dao.ClientFreeCommInfoDao;
import com.sunline.modules.commission.entity.ClientFreeCommInfoEntity;
import com.sunline.modules.commission.service.ClientFreeCommInfoService;

/**
 * 客户免佣套餐信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 19:55:32
 */

@Service("clientFreeCommissionInfoService")
public class ClientFreeCommInfoServiceImpl implements ClientFreeCommInfoService {
	@Autowired
	private ClientFreeCommInfoDao clientFreeCommissionInfoDao;
	
	@Override
	public ClientFreeCommInfoEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFreeCommissionInfoDao.queryObject(id);
	}
	
	@Override
	public List<ClientFreeCommInfoEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFreeCommissionInfoDao.queryList(map);
	}

    @Override
    public List<ClientFreeCommInfoEntity> queryListByBean(ClientFreeCommInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFreeCommissionInfoDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFreeCommissionInfoDao.queryTotal(map);
	}
	
	@Override
	public int save(ClientFreeCommInfoEntity clientFreeCommissionInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientFreeCommissionInfo.setId(Utils.uuid());
		return clientFreeCommissionInfoDao.save(clientFreeCommissionInfo);
	}
	
	@Override
	public int update(ClientFreeCommInfoEntity clientFreeCommissionInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFreeCommissionInfoDao.update(clientFreeCommissionInfo);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFreeCommissionInfoDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFreeCommissionInfoDao.deleteBatch(ids);
	}
	
}
