package com.sunline.modules.commission.service.impl;

import com.sunline.modules.commission.dao.ClientFareListSumRecordDao;
import com.sunline.modules.commission.entity.ClientFareListSumRecordEntity;
import com.sunline.modules.commission.service.ClientFareListSumRecordService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author lcs
 * @email
 * @date 2018-08-20 13:17:13
 */
@Service("clientFareListSumRecordService")
public class ClientFareListSumRecordServiceImpl implements ClientFareListSumRecordService {
	@Autowired
	private ClientFareListSumRecordDao clientFareListSumRecordDao;
	
	@Override
	public ClientFareListSumRecordEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFareListSumRecordDao.queryObject(id);
	}
	
	@Override
	public List<ClientFareListSumRecordEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFareListSumRecordDao.queryList(map);
	}

    @Override
    public List<ClientFareListSumRecordEntity> queryListByBean(ClientFareListSumRecordEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListSumRecordDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientFareListSumRecordDao.queryTotal(map);
	}
	
	@Override
	public int save(ClientFareListSumRecordEntity clientFareListSumRecord){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientFareListSumRecord.setId(Utils.uuid());
		return clientFareListSumRecordDao.save(clientFareListSumRecord);
	}
	
	@Override
	public int update(ClientFareListSumRecordEntity clientFareListSumRecord){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListSumRecordDao.update(clientFareListSumRecord);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListSumRecordDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListSumRecordDao.deleteBatch(ids);
	}
	
}
