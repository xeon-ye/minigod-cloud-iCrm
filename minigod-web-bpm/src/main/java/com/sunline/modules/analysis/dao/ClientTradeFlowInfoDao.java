package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.ClientTradeFlowInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户交易流水汇总表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-24 17:56:39
 */
@Mapper
public interface ClientTradeFlowInfoDao extends BaseDao<ClientTradeFlowInfoEntity> {

    /**
     * 交易统计
     *
     * @param id
     * @return
     */
    List<ClientTradeFlowInfoEntity> queryGroupList(Object id);


    /**
     * 交易查询  图示数据
     *
     * @param entity
     * @return
     */
    List<ClientTradeFlowInfoEntity> queryListGroupByParam(ClientTradeFlowInfoEntity entity);


    /**
     * 获取客户首次交易信息
     *
     * @param entity
     * @return
     */
    List<ClientTradeFlowInfoEntity> getFirstTrdInfo(ClientTradeFlowInfoEntity entity);

    /**
     * 获取渠道返佣数据
     *
     * @param queryCondition
     * @return
     */
    List<ClientTradeFlowInfoEntity> queryChannelReturnList(ClientTradeFlowInfoEntity queryCondition);
}
