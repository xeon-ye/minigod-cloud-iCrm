package com.sunline.modules.commission.dao;

import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 渠道佣金套餐设置表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 21:25:11
 */
@Mapper
public interface ChannelFareSetupDao extends BaseDao<ChannelFareSetupEntity> {
    /**
     * 查询客户所属渠道免佣配置
     * @param clientId
     * @return
     */
    ChannelFareSetupEntity getClientFreeCommConfig(Object clientId);

    /**
     * 获取渠道设佣客户名单信息
     * @param entity
     * @return
     */
    List<ChannelFareSetupEntity> getChannelClientFareSetInfo(ChannelFareSetupEntity entity);

    /**
     * 获取免佣到期渠道设佣客户名单信息
     * @param entity
     * @return
     */
    List<ChannelFareSetupEntity> getClientFreeCommDueSetInfo(ChannelFareSetupEntity entity);

    /**
     * 查询单条记录
     * @param entity
     * @return
     */
    ChannelFareSetupEntity queryByParams(ChannelFareSetupEntity entity);

    /**
     * 根据渠道号和方案类型修改
     * @param entity
     * @return
     */
    int updateByChannelId(ChannelFareSetupEntity entity);

    ChannelFareSetupEntity qryInfoByBean(ChannelFareSetupEntity entity);

    int updateByBusId(ChannelFareSetupEntity entity);

    int deleteByChanneld(ChannelFareSetupEntity entity);

    /**
     * 查询审核状态
     * @param entity
     * @return
     */
    List<ChannelFareSetupEntity> checkAuditStatus(ChannelFareSetupEntity entity);

    /**
     * 查询客户所属渠道佣金套餐
     * @param clientId
     * @return
     */
    ChannelFareSetupEntity getClientFarePackage(Object clientId);
}
