package com.sunline.modules.analysis.service.impl;

import com.sunline.modules.analysis.dao.StockTransferInfoDao;
import com.sunline.modules.analysis.entity.StockTransferInfoEntity;
import com.sunline.modules.analysis.service.StockTransferInfoService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户转仓查询
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 10:26:17
 */

@Service("stockTransferInfoService")
public class StockTransferInfoServiceImpl implements StockTransferInfoService {

    @Autowired
    private StockTransferInfoDao stockTransferInfoDao;


    /**
     * 客户转仓查询
     *
     * @param stockTransferInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<StockTransferInfoEntity> findPage(StockTransferInfoEntity stockTransferInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        stockTransferInfoDao.queryList(stockTransferInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 客户转仓查询导出excel数据
     *
     * @param stockTransferInfoEntity
     * @return
     */
    @Override
    public List<StockTransferInfoEntity> findStkTransferInfoExcelList(StockTransferInfoEntity stockTransferInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<StockTransferInfoEntity> stockTransferInfoList = stockTransferInfoDao.queryList(stockTransferInfoEntity);
        return stockTransferInfoList;
    }

    /**
     * 客户转仓发送记录查询
     * @param stockTransferInfoEntity
     * @return
     */
    @Override
    public List<StockTransferInfoEntity> queryStockTransferInfoSend(StockTransferInfoEntity stockTransferInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<StockTransferInfoEntity> stockTransferInfoList = stockTransferInfoDao.queryStockTransferInfoSend(stockTransferInfoEntity);
        return stockTransferInfoList;
    }
}
