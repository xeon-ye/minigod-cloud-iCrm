package com.sunline.modules.report.dao;

import com.sunline.modules.report.entity.TradeReportEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 交易统计报表
 * 
 * @author LCS
 * @email jim@zszhizhu.com
 * @date 2019-03-19 15:56:19
 */
@Mapper
public interface TradeReportDao extends BaseDao<TradeReportEntity> {

    List<TradeReportEntity> queryReportDay(TradeReportEntity entity);
    List<TradeReportEntity> queryReportMon(TradeReportEntity entity);
    List<TradeReportEntity> queryReportYear(TradeReportEntity entity);
}
