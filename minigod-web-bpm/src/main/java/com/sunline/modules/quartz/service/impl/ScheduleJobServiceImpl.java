package com.sunline.modules.quartz.service.impl;

import com.google.common.collect.Maps;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.quartz.dao.ScheduleJobDao;
import com.sunline.modules.quartz.entity.ScheduleJobEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.quartz.service.ScheduleJobService;
import com.sunline.modules.quartz.utils.ScheduleUtils;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService {
	@Autowired
    private Scheduler scheduler;
	@Autowired
	private ScheduleJobDao schedulerJobDao;
	
	/**
	 * 项目启动时，初始化定时器
	 */
	@PostConstruct
	public void init(){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		List<ScheduleJobEntity> scheduleJobList = schedulerJobDao.queryList(Maps.newHashMap());
		for(ScheduleJobEntity scheduleJob : scheduleJobList){
			CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
            //如果不存在，则创建
            if(cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
            }else {
                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
            }
		}
	}
	
	@Override
	public ScheduleJobEntity queryObject(Long jobId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return schedulerJobDao.queryObject(jobId);
	}

	@Override
	public List<ScheduleJobEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return schedulerJobDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return schedulerJobDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(ScheduleJobEntity scheduleJob) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		scheduleJob.setCreateTime(new Date());
		scheduleJob.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
		UserEntity currentUser = UserUtils.getCurrentUser();
		scheduleJob.setBapid(currentUser.getBapid());
		scheduleJob.setBaid(currentUser.getBaid());
		scheduleJob.setCreateId(currentUser.getId());
		scheduleJob.setCreateTime(new Date());
        schedulerJobDao.save(scheduleJob);
        
        ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
    }
	
	@Override
	@Transactional
	public void update(ScheduleJobEntity scheduleJob) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
		UserEntity currentUser = UserUtils.getCurrentUser();
        scheduleJob.setUpdateId(currentUser.getId());
        scheduleJob.setUpdateTime(new Date());
        schedulerJobDao.update(scheduleJob);
    }

	@Override
	@Transactional
    public void deleteBatch(Long[] jobIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
    	for(Long jobId : jobIds){
    		ScheduleUtils.deleteScheduleJob(scheduler, jobId);
    	}
    	
    	//删除数据
    	schedulerJobDao.deleteBatch(jobIds);
	}

	@Override
    public int updateBatch(Long[] jobIds, int status){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
    	Map<String, Object> map = Maps.newHashMap();
    	map.put("list", jobIds);
    	map.put("status", status);
    	return schedulerJobDao.updateBatch(map);
    }
    
	@Override
	@Transactional
    public void run(Long[] jobIds) {
    	for(Long jobId : jobIds){
    		ScheduleUtils.run(scheduler, queryObject(jobId));
    	}
    }

	@Override
	@Transactional
    public void pause(Long[] jobIds) {
        for(Long jobId : jobIds){
    		ScheduleUtils.pauseJob(scheduler, jobId);
    	}
        
    	updateBatch(jobIds, Constant.ScheduleStatus.PAUSE.getValue());
    }

	@Override
	@Transactional
    public void resume(Long[] jobIds) {
    	for(Long jobId : jobIds){
    		ScheduleUtils.resumeJob(scheduler, jobId);
    	}

    	updateBatch(jobIds, Constant.ScheduleStatus.NORMAL.getValue());
    }
    
}
