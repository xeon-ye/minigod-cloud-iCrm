package com.sunline.modules.stock.service;



import com.sunline.modules.common.page.Page;
import com.sunline.modules.stock.entity.StockOrderInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 股票订单信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-12-07 15:19:20
 */
public interface StockOrderInfoService {
	
	StockOrderInfoEntity queryObject(Integer id);

	Page<StockOrderInfoEntity> findPage(StockOrderInfoEntity entity, int pageNum);

    List<StockOrderInfoEntity> queryListByBean(StockOrderInfoEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(StockOrderInfoEntity stockOrderInfo);
	
	int update(StockOrderInfoEntity stockOrderInfo);

    /**
     * 发送通知 更改发送状态
     * @param id
     * @return
     */
	int updateStatus(Integer id);

	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
