package com.sunline.modules.commission.dao;


import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.entity.ChannelFareSetupLogEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 渠道佣金套餐设置日志表
 *
 * @author lcs
 * @date 2018-08-21 17:05:24
 */
@Mapper
public interface ChannelFareSetupLogDao extends BaseDao<ChannelFareSetupLogEntity> {

    List<ChannelFareSetupLogEntity> queryAcceptList(ChannelFareSetupLogEntity entity);

    List<ChannelFareSetupLogEntity> queryByParams(ChannelFareSetupLogEntity entity);

    ChannelFareSetupLogEntity queryByChannelId(ChannelFareSetupLogEntity entity);

    int updateStatus(ChannelFareSetupLogEntity entity);

    int updateByBusId(ChannelFareSetupLogEntity entity);

    int updateSyncStatus(ChannelFareSetupLogEntity entity);

    int updateByChannelId(ChannelFareSetupLogEntity entity);
}
