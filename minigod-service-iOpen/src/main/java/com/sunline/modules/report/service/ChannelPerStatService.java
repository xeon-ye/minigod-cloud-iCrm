package com.sunline.modules.report.service;


import com.sunline.modules.common.page.Page;
import com.sunline.modules.report.entity.ChannelPerformanceStatEntity;

import java.util.List;

/**
 * @description: 渠道业绩统计报表
 * @author: Larry Lai
 * @date: 2018-07-28 16:45
 * @version: v1.0
 */
public interface ChannelPerStatService {

    /**
     * @param channelPerformanceStatEntity
     * @return
     */
    List<ChannelPerformanceStatEntity> channelPerInfoExpExcel(ChannelPerformanceStatEntity channelPerformanceStatEntity);
    /**
     * 分页
     * @param channelPerformanceStatEntity
     * @param pageNum
     * @return
     */
    Page<ChannelPerformanceStatEntity> findPage(ChannelPerformanceStatEntity channelPerformanceStatEntity, int pageNum);

}
