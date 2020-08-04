package com.sunline.modules.account.online.service.impl;

import com.sunline.modules.account.online.dao.OpenAccountOperatorLogDao;
import com.sunline.modules.account.online.entity.OpenAccountOperatorLogEntity;
import com.sunline.modules.account.online.service.OpenAccountOperatorLogService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客户开户业务操作员日志表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-11-01 09:34:03
 */

@Service("openAccountOperatorLogService")
public class OpenAccountOperatorLogServiceImpl implements OpenAccountOperatorLogService {
	@Autowired
	private OpenAccountOperatorLogDao openAccountOperatorLogDao;
	
	@Override
	public OpenAccountOperatorLogEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountOperatorLogDao.queryObject(id);
	}
	
	@Override
	public List<OpenAccountOperatorLogEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountOperatorLogDao.queryList(map);
	}

    @Override
    public List<OpenAccountOperatorLogEntity> queryListByBean(OpenAccountOperatorLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOperatorLogDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountOperatorLogDao.queryTotal(map);
	}
	
	@Override
	public int save(OpenAccountOperatorLogEntity openAccountOperatorLog){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        openAccountOperatorLog.setId(Utils.uuid());
		return openAccountOperatorLogDao.save(openAccountOperatorLog);
	}
	
	@Override
	public int update(OpenAccountOperatorLogEntity openAccountOperatorLog){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOperatorLogDao.update(openAccountOperatorLog);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOperatorLogDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountOperatorLogDao.deleteBatch(ids);
	}
	
}
