package com.sunline.modules.analysis.service.impl;

import com.sunline.modules.analysis.dao.ClientFundDepositSendLogDao;
import com.sunline.modules.analysis.entity.ClientFundDepositSendLogEntity;
import com.sunline.modules.analysis.service.ClientFundDepositSendLogService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("clientFundDepositSendLogService")
public class ClientFundDepositSendLogServiceImpl implements ClientFundDepositSendLogService {
	@Autowired
	private ClientFundDepositSendLogDao clientFundDepositSendLogDao;
	
	@Override
	public ClientFundDepositSendLogEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
		return clientFundDepositSendLogDao.queryObject(id);
	}
	
	@Override
	public List<ClientFundDepositSendLogEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
		return clientFundDepositSendLogDao.queryList(map);
	}

    @Override
    public List<ClientFundDepositSendLogEntity> queryListByBean(ClientFundDepositSendLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientFundDepositSendLogDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
		return clientFundDepositSendLogDao.queryTotal(map);
	}
	
	@Override
	public int save(ClientFundDepositSendLogEntity clientFundDepositSendLog){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientFundDepositSendLog.setId(Utils.uuid());
		return clientFundDepositSendLogDao.save(clientFundDepositSendLog);
	}
	
	@Override
	public int update(ClientFundDepositSendLogEntity clientFundDepositSendLog){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositSendLogDao.update(clientFundDepositSendLog);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositSendLogDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositSendLogDao.deleteBatch(ids);
	}
	
}
