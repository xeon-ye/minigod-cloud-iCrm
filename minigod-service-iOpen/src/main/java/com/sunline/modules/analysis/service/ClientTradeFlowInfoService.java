package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.ClientTradeFlowInfoEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;

/**
 * 客户交易流水汇总表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-24 17:56:39
 */
public interface ClientTradeFlowInfoService {
    /**
     * 交易查询
     *
     * @param clientTradeFlowInfoEntity
     * @param pageNum
     * @return
     */
    Page<ClientTradeFlowInfoEntity> findPage(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, int pageNum);

    /**
     * 交易查询导出excel数据
     *
     * @param clientTradeFlowInfoEntity
     * @return
     */
    List<ClientTradeFlowInfoEntity> findTrdDetailListExcelList(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity);

    /**
     * 交易统计
     *
     * @param clientTradeFlowInfoEntity
     * @param pageNum
     * @return
     */
    Page<ClientTradeFlowInfoEntity> findGroupPage(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, int pageNum);

    /**
     * 交易统计导出excel数据
     *
     * @param clientTradeFlowInfoEntity
     * @return
     */
    List<ClientTradeFlowInfoEntity> findTrdGroupListExcelList(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity);

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
    List<ClientTradeFlowInfoEntity> findChannelReturnList(ClientTradeFlowInfoEntity queryCondition);

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int saveBatch(List<ClientTradeFlowInfoEntity> list);
}
