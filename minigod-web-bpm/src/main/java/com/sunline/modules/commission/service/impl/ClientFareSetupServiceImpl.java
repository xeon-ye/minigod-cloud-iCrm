package com.sunline.modules.commission.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.commission.dao.ClientFareSetupDao;
import com.sunline.modules.commission.entity.ClientFareSetupEntity;
import com.sunline.modules.commission.service.ClientFareSetupService;

/**
 * 客户佣金套餐设置表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-23 17:27:15
 */

@Service("clientFareSetupService")
public class ClientFareSetupServiceImpl implements ClientFareSetupService {
	@Autowired
	private ClientFareSetupDao clientFareSetupDao;
	
	@Override
	public ClientFareSetupEntity queryObject(Object id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFareSetupDao.queryObject(id);
	}

    @Override
    public Page<ClientFareSetupEntity> queryList(ClientFareSetupEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFareSetupDao.queryList(entity);
        return PageHelper.endPage();
    }

    @Override
    public List<ClientFareSetupEntity> queryListByBean(ClientFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFareSetupDao.queryTotal(map);
	}
	
	@Override
	public int save(ClientFareSetupEntity clientFareSetup){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientFareSetup.setId(Utils.uuid());
		return clientFareSetupDao.save(clientFareSetup);
	}
	
	@Override
	public int update(ClientFareSetupEntity clientFareSetup){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupDao.update(clientFareSetup);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupDao.deleteBatch(ids);
	}

    /**
     * 获取客户设佣信息
     * @param entity
     * @return
     */
    @Override
    public List<ClientFareSetupEntity> getClientFareSetupInfo(ClientFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupDao.getClientFareSetupInfo(entity);
    }

    @Override
    public int updateByBusId(ClientFareSetupEntity clientFareSetup) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupDao.updateByBusId(clientFareSetup);
    }

    @Override
    public List<ClientFareSetupEntity> checkAuditStatus(ClientFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupDao.checkAuditStatus(entity);
    }

}
