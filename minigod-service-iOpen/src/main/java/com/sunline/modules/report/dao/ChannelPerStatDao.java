package com.sunline.modules.report.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.report.entity.ChannelPerformanceStatEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: 渠道业绩统计报表
 * @author: Larry Lai
 * @date: 2018-07-28 16:45
 * @version: v1.0
 */
@Mapper
public interface ChannelPerStatDao extends BaseDao {

    /**
     * 开户报表统计
     * @param channelPerformanceStatEntity
     * @return
     */
   List<ChannelPerformanceStatEntity> queryList(ChannelPerformanceStatEntity channelPerformanceStatEntity);

}
