package com.sunline.modules.stock.dao;


import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.stock.entity.StockOrderInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 股票订单信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-12-07 15:19:20
 */
@Mapper
public interface StockOrderInfoDao extends BaseDao<StockOrderInfoEntity> {

    List<StockOrderInfoEntity> queryList(StockOrderInfoEntity entity);

    /**
     * 发送通知 更改发送状态
     * @param id
     * @return
     */
    int updateStatus(Integer id);


}
