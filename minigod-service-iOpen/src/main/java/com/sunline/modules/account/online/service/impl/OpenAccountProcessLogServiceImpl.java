package com.sunline.modules.account.online.service.impl;

import com.sunline.modules.account.online.dao.OpenAccountProcessLogDao;
import com.sunline.modules.account.online.entity.OpenAccountProcessLogEntity;
import com.sunline.modules.account.online.service.OpenAccountProcessLogService;
import com.sunline.modules.common.utils.ShiroUtils;
import com.sunline.modules.common.utils.UserUtils;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客户开户业务流程日志表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-10-11 20:55:10
 */

@Service("openAccountProcessLogService")
public class OpenAccountProcessLogServiceImpl implements OpenAccountProcessLogService {
    @Autowired
    private OpenAccountProcessLogDao openAccountProcessLogDao;

    @Override
    public OpenAccountProcessLogEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountProcessLogDao.queryObject(id);
    }

    @Override
    public List<OpenAccountProcessLogEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountProcessLogDao.queryList(map);
    }

    @Override
    public List<OpenAccountProcessLogEntity> queryListByBean(OpenAccountProcessLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountProcessLogDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountProcessLogDao.queryTotal(map);
    }

    @Override
    public int save(OpenAccountProcessLogEntity openAccountProcessLog) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        openAccountProcessLog.setId(Utils.uuid());
        return openAccountProcessLogDao.save(openAccountProcessLog);
    }

    @Override
    public int update(OpenAccountProcessLogEntity openAccountProcessLog) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		openAccountProcessLog.setUpdateUser(UserUtils.getCurrentUserId());
		openAccountProcessLog.setUpdateTime(new Date());
        return openAccountProcessLogDao.update(openAccountProcessLog);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountProcessLogDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountProcessLogDao.deleteBatch(ids);
    }

	@Override
	public int updateByTaskId(OpenAccountProcessLogEntity openAccountProcessLog) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        if(null != ShiroUtils.getUserEntity()){
            openAccountProcessLog.setUpdateUser(UserUtils.getCurrentUserId());
        }else{
            openAccountProcessLog.setUpdateUser(UserUtils.getBackgroundWorkflowUser().getId());
        }


		openAccountProcessLog.setUpdateTime(new Date());		
		return openAccountProcessLogDao.updateByTaskId(openAccountProcessLog);
	}

	@Override
	public OpenAccountProcessLogEntity queryObjectByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountProcessLogDao.queryObjectByApplicationId(applicationId);
	}

}
