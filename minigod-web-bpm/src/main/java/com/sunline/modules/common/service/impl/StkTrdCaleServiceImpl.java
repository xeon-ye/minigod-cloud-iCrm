package com.sunline.modules.common.service.impl;

import com.sunline.modules.common.utils.SumDateUtil;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.sunline.modules.common.dao.StkTrdCaleDao;
import com.sunline.modules.common.entity.StkTrdCaleEntity;
import com.sunline.modules.common.service.StkTrdCaleService;

@Service("stkTrdCaleService")
public class StkTrdCaleServiceImpl implements StkTrdCaleService {
    @Autowired
    private StkTrdCaleDao stkTrdCaleDao;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 通过自然日查(不同市场)上一个或下一个交易日
     *
     * @param
     * @return
     */
    @Override
    public StkTrdCaleEntity getLastNextDay(String normalDate, String regionCode) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        StkTrdCaleEntity entity = stkTrdCaleDao.queryByDateAndCode(normalDate, regionCode);
        StkTrdCaleEntity stkTradeCale = new StkTrdCaleEntity();
        stkTradeCale.setLastTrd(entity.getLastTrd());
        stkTradeCale.setNextTrd(entity.getNextTrd());
        return stkTradeCale;
    }

    /**
     * 通过自然日查(不同市场)周首个交易日或周最后交易日
     *
     * @param normalDate, regionCode
     * @return
     */
    @Override
    public StkTrdCaleEntity getWkFstLstTrdDay(String normalDate, String regionCode) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        StkTrdCaleEntity stkTradeCale = new StkTrdCaleEntity();
        boolean isTrdDay = true;
        String firstDay = "";
        String lastDay = "";
        //从日期所在周第一天循环 若为交易日则停止
        while (isTrdDay) {
            if ("".equals(firstDay) || firstDay == null) {
                //获取指定日期所在周第一天日期
                firstDay = SumDateUtil.getMondayOfThisWeek(normalDate);
            } else {
                firstDay = SumDateUtil.nextDay(firstDay);
            }
            StkTrdCaleEntity entity = stkTrdCaleDao.queryByDateAndCode(firstDay, regionCode);
            isTrdDay = entity.getIsTradeDay();
        }
        stkTradeCale.setFirstTrdOfWk(firstDay);
        isTrdDay = false;
        //从日期所在周最后一天循环 若为交易日则停止
        while (isTrdDay) {
            if ("".equals(lastDay) || firstDay == null) {
                //获取指定日期所在周最后一天日期
                lastDay = SumDateUtil.getSundayOfThisWeek(normalDate);
            } else {
                lastDay = SumDateUtil.lastDay(lastDay);
            }
            StkTrdCaleEntity entity = stkTrdCaleDao.queryByDateAndCode(lastDay, regionCode);
            isTrdDay = entity.getIsTradeDay();
        }
        stkTradeCale.setLastTrdOfWk(lastDay);
        return stkTradeCale;
    }

    /**
     * 通过自然日查(不同市场)月首个交易日或月最后交易日
     *
     * @param normalDate, regionCode
     * @return
     */
    @Override
    public StkTrdCaleEntity getMtFstLstTrdDay(String normalDate, String regionCode) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        StkTrdCaleEntity stkTradeCale = new StkTrdCaleEntity();
        boolean isTrdDay = true;
        String firstDay = "";
        String lastDay = "";
        //从日期所在月第一天循环 若为交易日则停止
        while (isTrdDay) {
            if ("".equals(firstDay) || firstDay == null) {
                //获取指定日期所在月第一天日期
                firstDay = SumDateUtil.getFirstDayThisMonth(normalDate);
            } else {
                firstDay = SumDateUtil.nextDay(firstDay);
            }
            StkTrdCaleEntity entity = stkTrdCaleDao.queryByDateAndCode(firstDay, regionCode);
            isTrdDay = entity.getIsTradeDay();
        }
        stkTradeCale.setFirstTrdOfMt(firstDay);
        isTrdDay = false;
        //从日期所在月最后一天循环 若为交易日则停止
        while (isTrdDay) {
            if ("".equals(lastDay) || firstDay == null) {
                //获取指定日期所在月最后一天日期
                lastDay = SumDateUtil.getLastDayThisMonth(normalDate);
            } else {
                lastDay = SumDateUtil.lastDay(lastDay);
            }
            StkTrdCaleEntity entity = stkTrdCaleDao.queryByDateAndCode(lastDay, regionCode);
            isTrdDay = entity.getIsTradeDay();
        }
        stkTradeCale.setLastTrdOfMt(lastDay);
        return stkTradeCale;
    }

    /**
     * 通过自然日查(不同市场)年首个交易日或年最后交易日
     *
     * @param normalDate, regionCode
     * @return
     */
    @Override
    public StkTrdCaleEntity getYearFstLstTrdDay(String normalDate, String regionCode) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        StkTrdCaleEntity stkTradeCale = new StkTrdCaleEntity();
        boolean isTrdDay = true;
        String firstDay = "";
        String lastDay = "";
        //从日期所在年第一天循环 若为交易日则停止
        while (isTrdDay) {
            if ("".equals(firstDay) || firstDay == null) {
                //获取指定日期所在年第一天日期
                firstDay = SumDateUtil.getFirstDayThisYear(normalDate);
            } else {
                firstDay = SumDateUtil.nextDay(firstDay);
            }
            StkTrdCaleEntity entity = stkTrdCaleDao.queryByDateAndCode(firstDay, regionCode);
            isTrdDay = entity.getIsTradeDay();
        }
        stkTradeCale.setFirstTrdOfYear(firstDay);
        isTrdDay = false;
        //从日期所在年最后一天循环 若为交易日则停止
        while (isTrdDay) {
            if ("".equals(lastDay) || firstDay == null) {
                //获取指定日期所在年最后一天日期
                lastDay = SumDateUtil.getLastDayThisYear(normalDate);
            } else {
                lastDay = SumDateUtil.lastDay(lastDay);
            }
            StkTrdCaleEntity entity = stkTrdCaleDao.queryByDateAndCode(lastDay, regionCode);
            isTrdDay = entity.getIsTradeDay();
        }
        stkTradeCale.setLastTrdOfYear(lastDay);
        return stkTradeCale;
    }

    /**
     * 通过自然日查(不同市场)的交易日历信息
     *
     * @param normalDate, regionCode
     * @return
     */
    @Override
    public StkTrdCaleEntity getTrdCale(String normalDate, String regionCode) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        StkTrdCaleEntity entity = stkTrdCaleDao.queryByDateAndCode(normalDate, regionCode);
        return entity;
    }

    @Override
    public Integer getTrdDayNumByTrdDate(String trdBeginDate, String trdEndDate) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return stkTrdCaleDao.getTrdDayNumByTrdDate(trdBeginDate, trdEndDate);
    }
}
