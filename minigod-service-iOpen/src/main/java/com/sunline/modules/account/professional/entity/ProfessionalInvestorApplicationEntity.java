package com.sunline.modules.account.professional.entity;

import com.sunline.modules.activiti.annotation.ActTable;
import com.sunline.modules.common.entity.ActivitiBaseEntity;
import com.sunline.modules.fund.entity.ClientFundDepositImageEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 专业投资者认定申请信息表
 * 
 * @author jim
 * @email jim@zszhizhu.com
 * @date 2019-12-04 11:31:49
 */
@Data
@ActTable(tableName = "professional_investor_application", pkName = "application_id")
public class ProfessionalInvestorApplicationEntity extends ActivitiBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//流水号
	private String applicationId;
	//小神号
	private Integer userId;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//资产组合,逗号隔开
	private String portfolios;
	//申请时间
	private Date applyTime;
	//认定时间
	private Date accreditTime;
	//失效时间
	private Date expireTime;
	//撤销时间
	private Date revokeTime;
	//12个月内总资产
	private BigDecimal totalAssets;
	//12个月内总资产对应日期
	private Date totalAssetsDate;
	//预约申请状态[0-未知 1-初审中 2-复审中 3-认定成功 4-已退回 5-已终止 6-已撤销 7-已失效]
	private Integer applicationStatus;
	//审核结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	private Integer approveResult;
	//流程实例ID
	private String instanceId;
	//流程定义ID
	private String defid;
	//流程发起时间
	private Date startTime;
	//业务流程状态[1=草稿 2=审批中 3=结束]
	private String status;
	//当前节点名称
	private String currentNode;
	//指定任务处理人
	private String assignDrafter;
	//审核流程记录
	private String flowPath;
	//流程审批结果[1-同意 2-不同意 3-审批中]
	private String actResult;
	//最后审核人
	private String lastApprovalUser;
	//最后审核意见
	private String approvalOpinion;
	//流程发起人ID
	private String startUserId;
	//流程发起人ID
	private String createUser;
	//流程更新人ID
	private String updateUser;
	//回调APP端结果状态[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	private Integer callbackStatus;
	//恒生处理状态[0-未知 1-处理成功 2-处理失败]
	private Integer hsDealStatus;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//中文姓名
	private String clientName;
	//英文名/拼音
	private String clientNameSpell;
	//手机号
	private String phoneNumber;
	//性别[0=男 1=女 2=其它]
	private Integer sex;
	//资产凭证
	private List<ClientFundDepositImageEntity> assetsImgs;
	//补充凭证
	private List<ClientFundDepositImageEntity> addImgs;
}
