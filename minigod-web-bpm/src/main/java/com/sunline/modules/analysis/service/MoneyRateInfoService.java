package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.MoneyRateInfoEntity;
import com.sunline.modules.common.page.Page;

import java.math.BigDecimal;
import java.util.List;

/**
 * 汇率信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-03 13:15:29
 */
public interface MoneyRateInfoService {

    /**
     * 汇率查询
     *
     * @param moneyRateInfoEntity
     * @param pageNum
     * @return
     */
    Page<MoneyRateInfoEntity> findPage(MoneyRateInfoEntity moneyRateInfoEntity, int pageNum);

    /**
     * 汇率查询导出excel数据
     *
     * @param moneyRateInfoEntity
     * @return
     */
    List<MoneyRateInfoEntity> findMoneyRateListExcelList(MoneyRateInfoEntity moneyRateInfoEntity);


    MoneyRateInfoEntity queryObject(MoneyRateInfoEntity entity);

    /**
     * 换汇
     *
     * @param fromMoneyType
     * @param toMoneyType
     * @param amount
     * @return
     */
    BigDecimal exchange(String fromMoneyType, String toMoneyType, BigDecimal amount);
}
