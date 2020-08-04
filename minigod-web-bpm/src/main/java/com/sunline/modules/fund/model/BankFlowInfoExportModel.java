package com.sunline.modules.fund.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;


/**
 * 客户入金申请信息导出model
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */
@Data
public class BankFlowInfoExportModel extends BaseRowModel {

	@ExcelProperty(value = "Bank Name" ,index = 0)
	private String bankName;

	@ExcelProperty(value = "Value Date" ,index = 1)
	private String valueDate;

	@ExcelProperty(value = "Account Name" ,index = 2)
	private String accName;

	@ExcelProperty(value = "Account Number" ,index = 3)
	private String accNo;

	@ExcelProperty(value = "Sub Account Name" ,index = 4)
	private String subAccname;

	@ExcelProperty(value = "Sub Account No." ,index = 5)
	private String subAccno;

	@ExcelProperty(value = "currency" ,index = 6)
	private String currency;

	@ExcelProperty(value = "Credit Amount" ,index = 7)
	private String creditAmount;

	@ExcelProperty(value = "Transaction Reference" ,index = 8)
	private String referenceNo;

	@ExcelProperty(value = "Particulars" ,index = 9)
	private String particulars;
}
