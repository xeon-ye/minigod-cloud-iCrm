package com.sunline.modules.commission.service;

import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.entity.ChannelFareSetupLogEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;
import java.util.Map;

/**
 * 渠道佣金套餐设置日志表
 *
 * @author lcs
 * @date 2018-08-21 17:05:24
 */
public interface ChannelFareSetupLogService {

    ChannelFareSetupLogEntity queryObject(Integer id);

    List<ChannelFareSetupLogEntity> queryList(Map<String, Object> map);

    Page<ChannelFareSetupLogEntity> queryAcceptList(ChannelFareSetupLogEntity entity, int pageNum);

    List<ChannelFareSetupLogEntity> queryByParams(ChannelFareSetupLogEntity entity);

    ChannelFareSetupLogEntity queryByChannelId(ChannelFareSetupLogEntity entity);

    List<ChannelFareSetupLogEntity> queryListByBean(ChannelFareSetupLogEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(ChannelFareSetupLogEntity channelFareSetupLog);

    int update(ChannelFareSetupLogEntity channelFareSetupLog);

    int updateStatus(ChannelFareSetupLogEntity channelFareSetupLog);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);

    int updateByBusId(ChannelFareSetupLogEntity entity);
    int updateSyncStatus(ChannelFareSetupLogEntity entity);
    int updateByChannelId(ChannelFareSetupLogEntity entity);
}
