package com.sunline.modules.report.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.report.entity.TradeReportEntity;

import java.util.List;
import java.util.Map;

/**
 * 交易统计报表
 * 
 * @author LCS
 * @email jim@zszhizhu.com
 * @date 2019-03-19 15:56:19
 */
public interface TradeReportService {

	Page<TradeReportEntity> queryReport(TradeReportEntity entity, int num);

	List<TradeReportEntity> queryList(TradeReportEntity entity);
}
