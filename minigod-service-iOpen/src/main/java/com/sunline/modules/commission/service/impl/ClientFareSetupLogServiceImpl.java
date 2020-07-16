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
import com.sunline.modules.commission.dao.ClientFareSetupLogDao;
import com.sunline.modules.commission.entity.ClientFareSetupLogEntity;
import com.sunline.modules.commission.service.ClientFareSetupLogService;

/**
 * 客户佣金套餐设置日志表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-23 17:34:01
 */

@Service("clientFareSetupLogService")
public class ClientFareSetupLogServiceImpl implements ClientFareSetupLogService {
	@Autowired
	private ClientFareSetupLogDao clientFareSetupLogDao;
	
	@Override
	public ClientFareSetupLogEntity queryObject(Object id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFareSetupLogDao.queryObject(id);
	}

    @Override
    public ClientFareSetupLogEntity queryClientFareInfo(ClientFareSetupLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupLogDao.queryClientFareInfo(entity);
    }

    @Override
	public Page<ClientFareSetupLogEntity> queryList(ClientFareSetupLogEntity entity,int pageNum){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFareSetupLogDao.queryList(entity);
        return PageHelper.endPage();

	}

    @Override
    public Page<ClientFareSetupLogEntity> queryAcceptList(ClientFareSetupLogEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFareSetupLogDao.queryAcceptList(entity);
        return PageHelper.endPage();
    }

    @Override
    public List<ClientFareSetupLogEntity> queryListByBean(ClientFareSetupLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupLogDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFareSetupLogDao.queryTotal(map);
	}
	
	@Override
	public int save(ClientFareSetupLogEntity clientFareSetupLog){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientFareSetupLog.setId(Utils.uuid());
		return clientFareSetupLogDao.save(clientFareSetupLog);
	}
	
	@Override
	public int update(ClientFareSetupLogEntity clientFareSetupLog){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupLogDao.update(clientFareSetupLog);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupLogDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupLogDao.deleteBatch(ids);
	}

    @Override
    public int updateByBusId(ClientFareSetupLogEntity clientFareSetupLog) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareSetupLogDao.updateByBusId(clientFareSetupLog);
    }

}
