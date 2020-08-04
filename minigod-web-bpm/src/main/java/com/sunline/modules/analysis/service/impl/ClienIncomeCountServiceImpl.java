package com.sunline.modules.analysis.service.impl;

import com.sunline.modules.analysis.dao.ClienIncomeCountDao;
import com.sunline.modules.analysis.entity.ClienIncomeCountEntity;
import com.sunline.modules.analysis.service.ClienIncomeCountService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入金交易统计
 *
 * @author lcs
 * @email
 * @date 2018-06-19 14:56:39
 */
@Service("ClienIncomeCountService")
public class ClienIncomeCountServiceImpl implements ClienIncomeCountService {

    @Autowired
    private ClienIncomeCountDao clienIncomeCountDao;

    @Override
    public ClienIncomeCountEntity queryCount(ClienIncomeCountEntity clienIncomeCountEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clienIncomeCountDao.queryCount(clienIncomeCountEntity);
    }

    @Override
    public List<ClienIncomeCountEntity> queryDataMonth(ClienIncomeCountEntity clienIncomeCountEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);

        if(clienIncomeCountEntity.getType().equals("incomeMoney")){
            return clienIncomeCountDao.queryMonthIncomeMoney(clienIncomeCountEntity);
        }else
        if(clienIncomeCountEntity.getType().equals("incomeCount")){
            return clienIncomeCountDao.queryMonthIncomeCount(clienIncomeCountEntity);
        }else
        if(clienIncomeCountEntity.getType().equals("tradeMoney")){
            return clienIncomeCountDao.queryMonthTradeMoney(clienIncomeCountEntity);
        }else
        if(clienIncomeCountEntity.getType().equals("tradeCount")){
            return clienIncomeCountDao.queryMonthTradeCount(clienIncomeCountEntity);
        }else{
            return clienIncomeCountDao.queryDataMonth(clienIncomeCountEntity);
        }
    }

    @Override
    public List<ClienIncomeCountEntity> queryDataWeek(ClienIncomeCountEntity clienIncomeCountEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clienIncomeCountDao.queryDataWeek(clienIncomeCountEntity);
    }

    @Override
    public List<ClienIncomeCountEntity> queryDataDay(ClienIncomeCountEntity clienIncomeCountEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clienIncomeCountDao.queryDataDay(clienIncomeCountEntity);
    }
}
