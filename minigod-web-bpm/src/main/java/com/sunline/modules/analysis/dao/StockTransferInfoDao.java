package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.StockTransferInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户转托管信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 10:26:17
 */
@Mapper
public interface StockTransferInfoDao extends BaseDao<StockTransferInfoEntity> {

    /**
     * 客户转仓发送记录查询
     *
     * @param id
     * @return
     */
    List<StockTransferInfoEntity> queryStockTransferInfoSend(Object id);

    /**
     * 客户首次转入股票
     *
     * @param id
     * @return
     */
    List<StockTransferInfoEntity> queryFirstStockTransferInfoSend(Object id);
}
