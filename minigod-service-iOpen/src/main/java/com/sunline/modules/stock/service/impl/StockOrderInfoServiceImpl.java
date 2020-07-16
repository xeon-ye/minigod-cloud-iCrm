package com.sunline.modules.stock.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.stock.dao.StockOrderInfoDao;
import com.sunline.modules.stock.entity.StockOrderInfoEntity;
import com.sunline.modules.stock.service.StockOrderInfoService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;

/**
 * 股票订单信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-12-07 15:19:20
 */

@Service("stockOrderInfoService")
public class StockOrderInfoServiceImpl implements StockOrderInfoService {
	@Autowired
	private StockOrderInfoDao stockOrderInfoDao;
	
	@Override
	public StockOrderInfoEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return stockOrderInfoDao.queryObject(id);
	}

    @Override
    public Page findPage(StockOrderInfoEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        stockOrderInfoDao.queryList(entity);
        return PageHelper.endPage();
    }

    @Override
    public List<StockOrderInfoEntity> queryListByBean(StockOrderInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return stockOrderInfoDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return stockOrderInfoDao.queryTotal(map);
	}
	
	@Override
	public int save(StockOrderInfoEntity stockOrderInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return stockOrderInfoDao.save(stockOrderInfo);
	}
	
	@Override
	public int update(StockOrderInfoEntity stockOrderInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return stockOrderInfoDao.update(stockOrderInfo);
	}

    @Override
    public int updateStatus(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return stockOrderInfoDao.updateStatus(id);
    }

    @Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return stockOrderInfoDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return stockOrderInfoDao.deleteBatch(ids);
	}
	
}
