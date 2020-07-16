package com.sunline.modules.account.professional.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Date;


/**
 * 专业投资者认定可撤销列表导出model
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-12-18 14:52:31
 */
@Data
public class ProfessionalCancelListExportModel extends BaseRowModel {

	@ExcelProperty(value = "申请日期" ,index = 0)
	private String applyTime;

	@ExcelProperty(value = "认定日期" ,index = 1)
	private String accreditTime;

	@ExcelProperty(value = "失效日期" ,index = 2)
	private String expireTime;

	@ExcelProperty(value = "小神号" ,index = 3)
	private Integer userId;

	@ExcelProperty(value = "客户账号" ,index = 4)
	private String clientId;

	@ExcelProperty(value = "姓名" ,index = 5)
	private String clientName;

	@ExcelProperty(value = "英文名" ,index = 6)
	private String clientNameSpell;

	@ExcelProperty(value = "证券手机号" ,index = 7)
	private String phoneNumber;

}
