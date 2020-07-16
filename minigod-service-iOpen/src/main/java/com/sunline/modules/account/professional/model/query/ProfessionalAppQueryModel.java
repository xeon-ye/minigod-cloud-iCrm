package com.sunline.modules.account.professional.model.query;

import lombok.Data;

import java.util.List;


/**
 * 专业投资者认定申请信息model
 * 
 * @author jim
 * @email jim@zszhizhu.com
 * @date 2019-12-04 11:31:49
 */
@Data
public class ProfessionalAppQueryModel{

	//流水号
	private String applicationId;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//预约申请状态[0-未知 1-初审中 2-复审中 3-认定成功 4-已退回 5-已终止 6-已撤销 7-已失效]
	private Integer applicationStatus;
	//小神号
	private Integer userId;
	//中文姓名
	private String clientName;
	//英文名/拼音
	private String clientNameSpell;
	//手机号
	private String phoneNumber;
	//客户状态
	private String clientStatus;

	//审核人
	private String assignDrafter;

	//权限节点名称
	private List<String> currentNodes;

	//申请时间
	private String applyDateSt;
	private String applyDateEd;

	//认定时间
	private String accreditDateSt;
	private String accreditDateEd;

	//失效时间
	private String expireDateSt;
	private String expireDateEd;

	//撤销时间
	private String revokeDateSt;
	private String revokeDateEd;

	//导出标记 1-总记录列表 2-可撤销列表
	private String flag;

	//排序列
	private String sidx;
	//排序方式
	private String order;
}
