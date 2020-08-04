package com.sunline.modules.analysis.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 客户资产统计表
 * 
 * @author jim
 * @date 2019-08-06 14:24:52
 */
@Data
public class ClientFundCountEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//小神号
	private Integer userId;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//交易日期
	private String tradeDate;
	//人民币资产
	private BigDecimal CNYAssets;
	//港币资产
	private BigDecimal HKDAssets;
	//美元资产
	private BigDecimal USDAssets;
	//总资产
	private BigDecimal totalAssets;
    // 客户姓名
    private String clientName;
    // 表名
    private String tableName1;
	// 表名
	private String tableName2;

	/**
	 * 维度时间
	 */
	private String dateTime;

	/**
	 * [维度类型 1-day 2-month]
	 */
	private String dateType;

	//开始日期
	private String stDate;

	//结束日期
	private String edDate;


}
