package com.sunline.modules.quartz.service.impl;

import com.sunline.modules.quartz.dao.ScheduleJobLogDao;
import com.sunline.modules.quartz.entity.ScheduleJobLogEntity;
import com.sunline.modules.quartz.service.ScheduleJobLogService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {
	@Autowired
	private ScheduleJobLogDao scheduleJobLogDao;
	
	@Override
	public ScheduleJobLogEntity queryObject(Long jobId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return scheduleJobLogDao.queryObject(jobId);
	}

	@Override
	public List<ScheduleJobLogEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return scheduleJobLogDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return scheduleJobLogDao.queryTotal(map);
	}

	@Override
	public void save(ScheduleJobLogEntity log) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		scheduleJobLogDao.save(log);
	}

}
