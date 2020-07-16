package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.StockTransferInfoEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;

/**
 * 客户转仓查询
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 10:26:17
 */
public interface StockTransferInfoService {

    /**
     * 客户转仓查询
     *
     * @param stockTransferInfoEntity
     * @param pageNum
     * @return
     */
    Page<StockTransferInfoEntity> findPage(StockTransferInfoEntity stockTransferInfoEntity, int pageNum);

    /**
     * 客户转仓查询导出excel数据
     *
     * @param stockTransferInfoEntity
     * @return
     */
    List<StockTransferInfoEntity> findStkTransferInfoExcelList(StockTransferInfoEntity stockTransferInfoEntity);

    /**
     * 客户转仓发送记录查询
     * @param stockTransferInfoEntity
     * @return
     */
    List<StockTransferInfoEntity> queryStockTransferInfoSend(StockTransferInfoEntity stockTransferInfoEntity);
}
