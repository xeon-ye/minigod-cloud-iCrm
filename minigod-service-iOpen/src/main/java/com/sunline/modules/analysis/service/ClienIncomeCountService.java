package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.ClienIncomeCountEntity;

import java.util.List;

/**
 * 入金交易统计
 *
 * @author lcs
 * @email
 * @date 2018-06-19 14:56:39
 */
public interface ClienIncomeCountService {
    ClienIncomeCountEntity queryCount(ClienIncomeCountEntity clienIncomeCountEntity);

    List<ClienIncomeCountEntity> queryDataMonth(ClienIncomeCountEntity clienIncomeCountEntity);
    List<ClienIncomeCountEntity> queryDataWeek(ClienIncomeCountEntity clienIncomeCountEntity);
    List<ClienIncomeCountEntity> queryDataDay(ClienIncomeCountEntity clienIncomeCountEntity);
}
