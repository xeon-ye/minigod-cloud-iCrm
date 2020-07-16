package com.sunline.modules.report.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.report.dao.ChannelPerStatDao;
import com.sunline.modules.report.entity.ChannelPerformanceStatEntity;
import com.sunline.modules.report.service.ChannelPerStatService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 渠道业绩统计报表
 * @author: Larry Lai
 * @date: 2018-07-28 16:45
 * @version: v1.0
 */

@Service("openClientCountService")
public class ChannelPerStatServiceImpl implements ChannelPerStatService {

    @Autowired
    private ChannelPerStatDao channelPerStatDao;

    /**
     * 开户报表统计 导出
     *
     * @param channelPerformanceStatEntity
     * @return
     */
    @Override
    public List<ChannelPerformanceStatEntity> channelPerInfoExpExcel(ChannelPerformanceStatEntity channelPerformanceStatEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return channelPerStatDao.queryList(channelPerformanceStatEntity);
    }

    /**
     * 开户报表统计
     *
     * @param channelPerformanceStatEntity
     * @return
     */

    @Override
    public Page<ChannelPerformanceStatEntity> findPage(ChannelPerformanceStatEntity channelPerformanceStatEntity, int pageNum) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);

        // 分页变量
        Integer fromIndex;
        Integer toIndex;
        Integer pageOffset = pageNum;

        List<ChannelPerformanceStatEntity> channelPerformanceStatEntityList = channelPerStatDao.queryList(channelPerformanceStatEntity);

        // 设置分页
        fromIndex = Math.min(((pageOffset - 1) * Constant.pageSize), channelPerformanceStatEntityList.size());
        toIndex = Math.min(pageOffset * Constant.pageSize, channelPerformanceStatEntityList.size());

        Page page = new Page(channelPerformanceStatEntityList.subList(fromIndex, toIndex), channelPerformanceStatEntityList.size(), Constant.pageSize, pageNum);

        return page;
    }


}
