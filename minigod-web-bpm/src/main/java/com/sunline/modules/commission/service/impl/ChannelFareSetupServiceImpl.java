package com.sunline.modules.commission.service.impl;

import com.sunline.modules.commission.dao.ChannelFareSetupDao;
import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 渠道佣金套餐设置表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 21:25:11
 */

@Service("channelFareSetupService")
public class ChannelFareSetupServiceImpl implements ChannelFareSetupService {
    @Autowired
    private ChannelFareSetupDao channelFareSetupDao;

    @Override
    public ChannelFareSetupEntity queryObject(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.queryObject(id);
    }

    @Override
    public List<ChannelFareSetupEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.queryList(map);
    }

    @Override
    public List<ChannelFareSetupEntity> queryListByBean(ChannelFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.queryTotal(map);
    }

    @Override
    public int save(ChannelFareSetupEntity channelFareSetup) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        channelFareSetup.setId(Utils.uuid());
        return channelFareSetupDao.save(channelFareSetup);
    }

    @Override
    public int update(ChannelFareSetupEntity channelFareSetup) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.update(channelFareSetup);
    }

    @Override
    public int delete(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.deleteBatch(ids);
    }

    /**
     * 查询客户所属渠道免佣配置
     *
     * @param clientId
     * @return
     */
    @Override
    public ChannelFareSetupEntity getClientFreeCommConfig(Object clientId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.getClientFreeCommConfig(clientId);
    }

    /**
     * 获取渠道设佣客户名单信息
     *
     * @param entity
     * @return
     */
    @Override
    public List<ChannelFareSetupEntity> getChannelClientFareSetInfo(ChannelFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.getChannelClientFareSetInfo(entity);
    }

    /**
     * 获取免佣到期渠道设佣客户名单信息
     *
     * @param entity
     * @return
     */
    @Override
    public List<ChannelFareSetupEntity> getClientFreeCommDueSetInfo(ChannelFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.getClientFreeCommDueSetInfo(entity);
    }

    /**
     * 查询单条记录
     *
     * @param entity
     * @return
     */
    @Override
    public ChannelFareSetupEntity queryByParams(ChannelFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.queryByParams(entity);
    }

    @Override
    public int updateByChannelId(ChannelFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.updateByChannelId(entity);
    }

    @Override
    public ChannelFareSetupEntity qryInfoByBean(ChannelFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.qryInfoByBean(entity);
    }

    @Override
    public int updateByBusId(ChannelFareSetupEntity channelFareSetup) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.updateByBusId(channelFareSetup);
    }

    @Override
    public int deleteByChanneld(ChannelFareSetupEntity channelFareSetup) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.deleteByChanneld(channelFareSetup);
    }

    @Override
    public List<ChannelFareSetupEntity> checkAuditStatus(ChannelFareSetupEntity channelFareSetup) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.checkAuditStatus(channelFareSetup);
    }

    /**
     * 查询客户所属渠道佣金套餐
     * @param channelId
     * @return
     */
    @Override
    public ChannelFareSetupEntity getClientFarePackage(Object channelId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupDao.getClientFarePackage(channelId);
    }
}
