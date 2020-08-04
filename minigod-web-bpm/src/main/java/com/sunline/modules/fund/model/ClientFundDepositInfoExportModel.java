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
public class ClientFundDepositInfoExportModel extends BaseRowModel {

	@ExcelProperty(value = "流水号" ,index = 0)
	private String applicationId;

	@ExcelProperty(value = "申请时间" ,index = 1,format = "yyyy-MM-dd")
	private Date applicationTime;

	@ExcelProperty(value = "小神号" ,index = 2)
	private String userId;

	@ExcelProperty(value = "客户姓名" ,index = 3)
	private String clientName;

	@ExcelProperty(value = "英文名" ,index = 4)
	private String clientNameSpell;

	@ExcelProperty(value = "性别" ,index = 5)
	private String sex;

	@ExcelProperty(value = "手机号码" ,index = 6)
	private String phoneNumber;

	@ExcelProperty(value = "开户途径" ,index = 7)
	private String openAccountType;

	@ExcelProperty(value = "是否首次入金" ,index = 8)
	private String firstDepFlag;

	@ExcelProperty(value = "币种" ,index = 9)
	private String moneyType;

	@ExcelProperty(value = "申请金额" ,index = 10)
	private String depositBalance;

	@ExcelProperty(value = "汇款银行" ,index = 11)
	private String depositBank;

	@ExcelProperty(value = "汇款账号" ,index = 12)
	private String depositNo;

	@ExcelProperty(value = "渠道" ,index = 13)
	private String sourceChannelId;

	@ExcelProperty(value = "状态" ,index = 14)
	private String applicationStatus;

}
