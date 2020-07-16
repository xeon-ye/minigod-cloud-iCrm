package com.sunline.modules.commission.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.commission.dao.ClientFreeCommSetDao;
import com.sunline.modules.commission.entity.ClientFreeCommSetEntity;
import com.sunline.modules.commission.service.ClientFreeCommSetService;

/**
 * 客户免佣套餐设置表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 19:40:27
 */

@Service("clientFreeCommissionSetupService")
public class ClientFreeCommSetServiceImpl implements ClientFreeCommSetService {
	@Autowired
	private ClientFreeCommSetDao clientFreeCommissionSetupDao;
	
	@Override
	public ClientFreeCommSetEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFreeCommissionSetupDao.queryObject(id);
	}
	
	@Override
	public List<ClientFreeCommSetEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFreeCommissionSetupDao.queryList(map);
	}

    @Override
    public List<ClientFreeCommSetEntity> queryListByBean(ClientFreeCommSetEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFreeCommissionSetupDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFreeCommissionSetupDao.queryTotal(map);
	}
	
	@Override
	public int save(ClientFreeCommSetEntity clientFreeCommissionSetup){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientFreeCommissionSetup.setId(Utils.uuid());
		return clientFreeCommissionSetupDao.save(clientFreeCommissionSetup);
	}
	
	@Override
	public int update(ClientFreeCommSetEntity clientFreeCommissionSetup){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFreeCommissionSetupDao.update(clientFreeCommissionSetup);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFreeCommissionSetupDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFreeCommissionSetupDao.deleteBatch(ids);
	}

    /**
     * 获取符合免佣设置的客户列表
     * @param entity
     * @return
     */
    @Override
    public List<ClientFreeCommSetEntity> getIsFreeCommClientInfo(ClientFreeCommSetEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFreeCommissionSetupDao.getIsFreeCommClientInfo(entity);
    }

}
