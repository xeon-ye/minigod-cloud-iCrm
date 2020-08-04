package com.sunline.modules.report.service.impl;

import com.google.common.collect.Lists;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import com.sunline.modules.report.dao.TradeReportDao;
import com.sunline.modules.report.entity.TradeReportEntity;
import com.sunline.modules.report.service.TradeReportService;

/**
 * 交易统计报表
 *
 * @author LCS
 * @email jim@zszhizhu.com
 * @date 2019-03-19 15:56:19
 */

@Service("tradeReportService")
public class TradeReportServiceImpl implements TradeReportService {
    @Autowired
    private TradeReportDao tradeReportDao;
    private static  DecimalFormat DF = new DecimalFormat("0");

    /**
     * 分页
     *
     * @param entity
     * @param pageNum
     * @return
     */
    @Override
    public Page<TradeReportEntity> queryReport(TradeReportEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        List<TradeReportEntity> resultList = Lists.newArrayList();
        if("0".equals(entity.getDate())){
            resultList = tradeReportDao.queryReportDay(entity);
        }else if("1".equals(entity.getDate())){
            resultList = tradeReportDao.queryReportMon(entity);
        }else if("2".equals(entity.getDate())){
            resultList = tradeReportDao.queryReportYear(entity);
        }

        for (TradeReportEntity reportEntity : resultList) {
            reportEntity.setEntrustWay(entity.getEntrustWay());
            reportEntity.setClientType(entity.getClientType());
            //数量环比
            if (reportEntity.getLasTradeCount() != 0) {
                reportEntity.setCountRatioH(Double.parseDouble(DF.format((double)(reportEntity.getTradeCount() - reportEntity.getLasTradeCount()) / reportEntity.getLasTradeCount() * 100)));
            } else {
                reportEntity.setCountRatioH(100);
            }

            //数量同比
            if (reportEntity.getYesTradeCount() != 0) {
                reportEntity.setCountRatioT(Double.parseDouble(DF.format((double)(reportEntity.getTradeCount() - reportEntity.getYesTradeCount()) / reportEntity.getYesTradeCount() * 100)));
            } else {
                reportEntity.setCountRatioT(100);
            }

            //金额环比
            if (reportEntity.getLasTradeBalance() != null && "0".equals(reportEntity.getLasTradeBalance().stripTrailingZeros())) {
                reportEntity.setBalanceRatioH(reportEntity.getTradeBalance().multiply(reportEntity.getLasTradeBalance()).divide(reportEntity.getLasTradeBalance()).doubleValue()*100);
            } else {
                reportEntity.setBalanceRatioH(100);
            }

            //金额同比
            if (reportEntity.getYesTradeBalance() !=null && "0".equals(reportEntity.getYesTradeBalance().stripTrailingZeros())) {
                reportEntity.setBalanceRatioT(reportEntity.getTradeBalance().multiply(reportEntity.getYesTradeBalance()).divide(reportEntity.getYesTradeBalance()).doubleValue()*100);
            } else {
                reportEntity.setBalanceRatioT(100);
            }
        }
        return PageHelper.endPage();
    }

    @Override
    public List<TradeReportEntity> queryList(TradeReportEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<TradeReportEntity> resultList = Lists.newArrayList();
        if("0".equals(entity.getDate())){
            resultList = tradeReportDao.queryReportDay(entity);
        }else if("1".equals(entity.getDate())){
            resultList = tradeReportDao.queryReportMon(entity);
        }else if("2".equals(entity.getDate())){
            resultList = tradeReportDao.queryReportYear(entity);
        }

        for (TradeReportEntity reportEntity : resultList) {
            //数量环比
            if (reportEntity.getLasTradeCount() != 0) {
                reportEntity.setCountRatioH(Double.parseDouble(DF.format((double)(reportEntity.getTradeCount() - reportEntity.getLasTradeCount()) / reportEntity.getLasTradeCount() * 100)));
            } else {
                reportEntity.setCountRatioH(100);
            }

            //数量同比
            if (reportEntity.getYesTradeCount() != 0) {
                reportEntity.setCountRatioT(Double.parseDouble(DF.format((double)(reportEntity.getTradeCount() - reportEntity.getYesTradeCount()) / reportEntity.getYesTradeCount() * 100)));
            } else {
                reportEntity.setCountRatioT(100);
            }

            //金额环比
            if (reportEntity.getLasTradeBalance() != null && "0".equals(reportEntity.getLasTradeBalance().stripTrailingZeros())) {
                reportEntity.setBalanceRatioH(reportEntity.getTradeBalance().multiply(reportEntity.getLasTradeBalance()).divide(reportEntity.getLasTradeBalance()).doubleValue()*100);
            } else {
                reportEntity.setBalanceRatioH(100);
            }

            //金额同比
            if (reportEntity.getYesTradeBalance() !=null && "0".equals(reportEntity.getYesTradeBalance().stripTrailingZeros())) {
                reportEntity.setBalanceRatioT(reportEntity.getTradeBalance().multiply(reportEntity.getYesTradeBalance()).divide(reportEntity.getYesTradeBalance()).doubleValue()*100);
            } else {
                reportEntity.setBalanceRatioT(100);
            }

            reportEntity.setEntrustWay(entity.getEntrustWay());
            reportEntity.setClientType(entity.getClientType());
        }
        return resultList;
    }

}
