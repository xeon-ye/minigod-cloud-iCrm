package com.sunline.modules.fund.entity;

import com.sunline.modules.activiti.annotation.ActTable;
import com.sunline.modules.common.entity.ActivitiBaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 客户出金退款申请表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-05-23 13:23:38
 */
@ActTable(tableName = "fund_withdraw_refund_application", pkName = "application_id")
public class FundWithdrawRefundApplyEntity  extends ActivitiBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//流水号
	private String applicationId;
	//出金流水号
	private String withdrawApplicationId;
	//币种代码[0-人民币 1-美元 2-港币]
	private String currencyType;
	//退款金额
	private BigDecimal refundAmount;
	//银行手续费
	private BigDecimal refundBankFee;
	//退款净金额
	private BigDecimal netRefundAmount;
	//退款方式[1-有手续费 2-无手续费]
	private Integer refundType;
	//当前节点名称
	private String currentNode;
	//审核结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	private Integer approveResult;
	//最后审核人
	private String lastApprovalUser;
	//最后审核意见
	private String approvalOpinion;
	//回调APP端结果状态[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	private Integer callbackStatus;
	//业务流程状态[1=草稿 2=审批中 3=结束]
	private String status;
	//流程实例ID
	private String instanceId;
	//流程定义ID
	private String defid;
	//业务流程单据编号
	private String code;
	//流程发起人ID
	private String startUserId;
	//流程发起人ID
	private String createUser;
	//流程更新人ID
	private String updateUser;
	//流程发起时间
	private Date startTime;
	//流程审批结果[1-同意 2-不同意 3-审批中]
	private String actResult;
	//指定任务处理人
	private String assignDrafter;
	//预约申请状态[0-未知 1-退款待入账 2-退款已入账 3-退款不匹配]
	private Integer applicationStatus;
	//恒生银行编号
	private String hsBankId;
	//恒生银行帐户
	private String hsBankAccount;
	//恒生银行名称
	private String hsBankName;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

    //交易帐号
    private String clientId;
    //资金帐号
    private String fundAccount;
    //收款人名称
    private String clientNameSpell;
    //提取方式[0-香港银行卡 1-大陆银行卡]
    private Integer withdrawType;
    //收款银行名称
    private String bankName;
    //收款银行帐户
    private String bankNo;
    //SWIFT代码
    private String swiftCode;
    //联系地址
    private String contactAddress;
    //币种代码[0-人民币 1-美元 2-港币]
    private String moneyType;
    //提取金额
    private BigDecimal occurBalance;
    //冻结资金
    private BigDecimal frozenBalance;
    //现金余额
    private BigDecimal currentBalance;

    private Integer userId;
    private String clientName;
    private Integer sex;
    private String phoneNumber;
    private Integer sourceChannelId;
    private Integer idKind;
    private String idNo;
    private String clientNameEn;

    private String beginTime;
    private String endTime;
    private String fundWithdrawBalance;

    private List<String> currentNodes;
	private BigDecimal chargeMoney;
	private BigDecimal actualBalance;

    //恒生处理状态[0-未知 1-处理成功 2-处理失败]
    private Integer hsDealStatus;

	/**
	 * 设置：自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：流水号
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * 获取：流水号
	 */
	public String getApplicationId() {
		return applicationId;
	}
	/**
	 * 设置：出金流水号
	 */
	public void setWithdrawApplicationId(String withdrawApplicationId) {
		this.withdrawApplicationId = withdrawApplicationId;
	}
	/**
	 * 获取：出金流水号
	 */
	public String getWithdrawApplicationId() {
		return withdrawApplicationId;
	}
	/**
	 * 设置：币种代码[0-人民币 1-美元 2-港币]
	 */
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}
	/**
	 * 获取：币种代码[0-人民币 1-美元 2-港币]
	 */
	public String getMoneyType() {
		return moneyType;
	}
	/**
	 * 设置：退款金额
	 */
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	/**
	 * 获取：退款金额
	 */
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	/**
	 * 设置：银行手续费
	 */
	public void setRefundBankFee(BigDecimal refundBankFee) {
		this.refundBankFee = refundBankFee;
	}
	/**
	 * 获取：银行手续费
	 */
	public BigDecimal getRefundBankFee() {
		return refundBankFee;
	}
	/**
	 * 设置：退款净金额
	 */
	public void setNetRefundAmount(BigDecimal netRefundAmount) {
		this.netRefundAmount = netRefundAmount;
	}
	/**
	 * 获取：退款净金额
	 */
	public BigDecimal getNetRefundAmount() {
		return netRefundAmount;
	}
	/**
	 * 设置：退款方式[1-有手续费 2-无手续费]
	 */
	public void setRefundType(Integer refundType) {
		this.refundType = refundType;
	}
	/**
	 * 获取：退款方式[1-有手续费 2-无手续费]
	 */
	public Integer getRefundType() {
		return refundType;
	}
	/**
	 * 设置：当前节点名称
	 */
	public void setCurrentNode(String currentNode) {
		this.currentNode = currentNode;
	}
	/**
	 * 获取：当前节点名称
	 */
	public String getCurrentNode() {
		return currentNode;
	}
	/**
	 * 设置：审核结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	 */
	public void setApproveResult(Integer approveResult) {
		this.approveResult = approveResult;
	}
	/**
	 * 获取：审核结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	 */
	public Integer getApproveResult() {
		return approveResult;
	}
	/**
	 * 设置：最后审核人
	 */
	public void setLastApprovalUser(String lastApprovalUser) {
		this.lastApprovalUser = lastApprovalUser;
	}
	/**
	 * 获取：最后审核人
	 */
	public String getLastApprovalUser() {
		return lastApprovalUser;
	}
	/**
	 * 设置：最后审核意见
	 */
	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}
	/**
	 * 获取：最后审核意见
	 */
	public String getApprovalOpinion() {
		return approvalOpinion;
	}
	/**
	 * 设置：回调APP端结果状态[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	 */
	public void setCallbackStatus(Integer callbackStatus) {
		this.callbackStatus = callbackStatus;
	}
	/**
	 * 获取：回调APP端结果状态[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	 */
	public Integer getCallbackStatus() {
		return callbackStatus;
	}
	/**
	 * 设置：业务流程状态[1=草稿 2=审批中 3=结束]
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：业务流程状态[1=草稿 2=审批中 3=结束]
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：流程实例ID
	 */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：流程实例ID
	 */
	public String getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：流程定义ID
	 */
	public void setDefid(String defid) {
		this.defid = defid;
	}
	/**
	 * 获取：流程定义ID
	 */
	public String getDefid() {
		return defid;
	}
	/**
	 * 设置：业务流程单据编号
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：业务流程单据编号
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：流程发起人ID
	 */
	public void setStartUserId(String startUserId) {
		this.startUserId = startUserId;
	}
	/**
	 * 获取：流程发起人ID
	 */
	public String getStartUserId() {
		return startUserId;
	}
	/**
	 * 设置：流程发起人ID
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：流程发起人ID
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：流程更新人ID
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：流程更新人ID
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：流程发起时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：流程发起时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：流程审批结果[1-同意 2-不同意 3-审批中]
	 */
	public void setActResult(String actResult) {
		this.actResult = actResult;
	}
	/**
	 * 获取：流程审批结果[1-同意 2-不同意 3-审批中]
	 */
	public String getActResult() {
		return actResult;
	}
	/**
	 * 设置：指定任务处理人
	 */
	public void setAssignDrafter(String assignDrafter) {
		this.assignDrafter = assignDrafter;
	}
	/**
	 * 获取：指定任务处理人
	 */
	public String getAssignDrafter() {
		return assignDrafter;
	}
	/**
	 * 设置：预约申请状态[0-未知 1-退款待入账 2-退款已入账 3-退款不匹配]
	 */
	public void setApplicationStatus(Integer applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	/**
	 * 获取：预约申请状态[0-未知 1-退款待入账 2-退款已入账 3-退款不匹配]
	 */
	public Integer getApplicationStatus() {
		return applicationStatus;
	}
	/**
	 * 设置：恒生银行编号
	 */
	public void setHsBankId(String hsBankId) {
		this.hsBankId = hsBankId;
	}
	/**
	 * 获取：恒生银行编号
	 */
	public String getHsBankId() {
		return hsBankId;
	}
	/**
	 * 设置：恒生银行帐户
	 */
	public void setHsBankAccount(String hsBankAccount) {
		this.hsBankAccount = hsBankAccount;
	}
	/**
	 * 获取：恒生银行帐户
	 */
	public String getHsBankAccount() {
		return hsBankAccount;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getClientNameSpell() {
        return clientNameSpell;
    }

    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    public Integer getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(Integer withdrawType) {
        this.withdrawType = withdrawType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public BigDecimal getOccurBalance() {
        return occurBalance;
    }

    public void setOccurBalance(BigDecimal occurBalance) {
        this.occurBalance = occurBalance;
    }

    public BigDecimal getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(BigDecimal frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(Integer sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    public Integer getIdKind() {
        return idKind;
    }

    public void setIdKind(Integer idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getClientNameEn() {
        return clientNameEn;
    }

    public void setClientNameEn(String clientNameEn) {
        this.clientNameEn = clientNameEn;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFundWithdrawBalance() {
        return fundWithdrawBalance;
    }

    public void setFundWithdrawBalance(String fundWithdrawBalance) {
        this.fundWithdrawBalance = fundWithdrawBalance;
    }

    public List<String> getCurrentNodes() {
        return currentNodes;
    }

    public void setCurrentNodes(List<String> currentNodes) {
        this.currentNodes = currentNodes;
    }

    public Integer getHsDealStatus() {
        return hsDealStatus;
    }

    public void setHsDealStatus(Integer hsDealStatus) {
        this.hsDealStatus = hsDealStatus;
    }

	public String getHsBankName() {
		return hsBankName;
	}

	public void setHsBankName(String hsBankName) {
		this.hsBankName = hsBankName;
	}

	public BigDecimal getChargeMoney() {
		return chargeMoney;
	}

	public void setChargeMoney(BigDecimal chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	public BigDecimal getActualBalance() {
		return actualBalance;
	}

	public void setActualBalance(BigDecimal actualBalance) {
		this.actualBalance = actualBalance;
	}
}
