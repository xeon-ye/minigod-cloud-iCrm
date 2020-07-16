package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.ClientAssetFlowInfoEntity;
import com.sunline.modules.analysis.entity.ClientFundCountEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户资金流水汇总表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-28 14:24:52
 */
@Mapper
public interface ClientAssetFlowInfoDao extends BaseDao<ClientAssetFlowInfoEntity> {

    /**
     * 资金统计
     * @param id
     * @return
     */
    List<ClientAssetFlowInfoEntity> queryGroupList(Object id);

    /**
     * 获取总资产大于0的客户名单
     * @param entity
     * @return
     */
    List<ClientAssetFlowInfoEntity> getAssetGtZeroClientList(ClientAssetFlowInfoEntity entity);

    /**
     * 按天查询客户资产
     * @param entity
     * @return
     */
    List<ClientFundCountEntity> countFundByDay(ClientFundCountEntity entity);

    /**
     * 按月查询客户资产
     * @param entity
     * @return
     */
    List<ClientFundCountEntity> countFundByMonth(ClientFundCountEntity entity);

    /**
     * 查询时间段内客户资产大于800万的资产及对应日期
     * @param entity
     * @return
     */
    ClientFundCountEntity queryAssetsByDate(ClientFundCountEntity entity);

    /**
     * 获取连续X交易日，资产大于amount的客户信息
     *
     * @return
     */
    List<Object> getAssetGtTradeDateClientInfoList(ClientAssetFlowInfoEntity entity);
}
