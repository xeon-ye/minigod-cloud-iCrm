package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.ClienIncomeCountEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 入金交易统计
 *
 * @author lcs
 * @email
 * @date 2018-06-19 14:56:39
 */
@Mapper
public interface ClienIncomeCountDao extends BaseDao {

    ClienIncomeCountEntity  queryCount(ClienIncomeCountEntity clienIncomeCountEntity);

    List<ClienIncomeCountEntity> queryDataMonth(ClienIncomeCountEntity clienIncomeCountEntity);
    List<ClienIncomeCountEntity> queryMonthIncomeMoney(ClienIncomeCountEntity clienIncomeCountEntity);
    List<ClienIncomeCountEntity> queryMonthIncomeCount(ClienIncomeCountEntity clienIncomeCountEntity);
    List<ClienIncomeCountEntity> queryMonthTradeMoney(ClienIncomeCountEntity clienIncomeCountEntity);
    List<ClienIncomeCountEntity> queryMonthTradeCount(ClienIncomeCountEntity clienIncomeCountEntity);


    List<ClienIncomeCountEntity> queryDataWeek(ClienIncomeCountEntity clienIncomeCountEntity);
    List<ClienIncomeCountEntity> queryDataDay(ClienIncomeCountEntity clienIncomeCountEntity);

}
