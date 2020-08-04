package com.sunline.modules.quartz.dao;


import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.quartz.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类ScheduleJobLogDao的功能描述:
 * 定时任务日志
 * @auther hxy
 * @date 2017-08-25 16:13:41
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
