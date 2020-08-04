package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.ClientStockFlowInfoEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;

/**
 * 客户股票流水汇总表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-02 17:12:17
 */
public interface ClientStockFlowInfoService {

    /**
     * 股份查询
     *
     * @param clientStockFlowInfoEntity
     * @param pageNum
     * @return
     */
    Page<ClientStockFlowInfoEntity> findPage(ClientStockFlowInfoEntity clientStockFlowInfoEntity, int pageNum);

    /**
     * 股份统计
     *
     * @param clientStockFlowInfoEntity
     * @param pageNum
     * @return
     */
    Page<ClientStockFlowInfoEntity> findGroupPage(ClientStockFlowInfoEntity clientStockFlowInfoEntity, int pageNum);

    /**
     * 股份查询导出excel数据
     *
     * @param clientStockFlowInfoEntity
     * @return
     */
    List<ClientStockFlowInfoEntity> findStkDetailListExcelList(ClientStockFlowInfoEntity clientStockFlowInfoEntity);

    /**
     * 股份统计导出excel数据
     *
     * @param clientStockFlowInfoEntity
     * @return
     */
    List<ClientStockFlowInfoEntity> findStkGroupListExcelList(ClientStockFlowInfoEntity clientStockFlowInfoEntity);
}
