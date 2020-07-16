package com.sunline.modules.fund.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 客户入金申请信息导出model
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */
@Data
public class ClientFundDepositEntryExportModel extends BaseRowModel {

	@ExcelProperty(value = "流水号" ,index = 0)
	private String applicationId;

	@ExcelProperty(value = "申请时间" ,index = 1)
	private Date applicationTime;

	@ExcelProperty(value = "资金帐号" ,index = 2)
	private String fundAccount;

	@ExcelProperty(value = "英文名" ,index = 3)
	private String clientNameSpell;

	@ExcelProperty(value = "币种" ,index = 4)
	private String moneyType;

	@ExcelProperty(value = "申请金额" ,index = 5)
	private String depositBalance;

	@ExcelProperty(value = "到账金额" ,index = 6)
	private String benefitBalance;

	@ExcelProperty(value = "汇款银行" ,index = 7)
	private String depositBank;

	@ExcelProperty(value = "汇款账号" ,index = 8)
	private String depositNo;

}
