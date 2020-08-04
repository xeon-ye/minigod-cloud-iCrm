package com.sunline.modules.fund.entity;

import com.sunline.modules.activiti.annotation.ActTable;
import com.sunline.modules.common.entity.ActivitiBaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 客户入金申请信息表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */
@ActTable(tableName = "client_fund_deposit_application", pkName = "application_id")
public class ClientFundDepositApplicationEntity extends ActivitiBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//流水号
	private String applicationId;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//SWIFT代码
	private String swiftCode;
	//入金方式[0-香港银行卡 1-大陆银行卡]
	private Integer depositType;
	//汇款方式[0-未知 1-网银汇款 2-支票汇款 3-FPS]
	private Integer remittanceType;
	//汇款银行
	private String depositBank;
	//汇款银行代码
	private String depositBankCode;
	//汇款账号
	private String depositNo;
	//汇款账户名称
	private String depositAccount;
	//收款银行
	private String benefitBank;
	// 收款银行代码
	private String benefitBankCode;
	//收款账号
	private String benefitNo;
	//收款账户名称
	private String benefitAccount;
	//申请金额
	private BigDecimal depositBalance;
	//联系地址
	private String contactAddress;
	//申请时间
	private Date applicationTime;
	//币种代码[0-人民币 1-美元 2-港币]
	private String moneyType;
	//审核结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	private Integer approveResult;
	//流程实例ID
	private String instanceId;
	//流程定义ID
	private String defid;
	//预约申请状态[0-未知 1-待处理 2-处理中 3-入账中 4-入账失败 5-已入账 6-退回客服 7-退回客户]
	private Integer applicationStatus;
	//流程发起时间
	private Date startTime;
	//当前节点名称
	private String currentNode;
	//指定任务处理人
	private String assignDrafter;
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
	//恒生银行编号
	private String hsBankId;
	//恒生银行帐户
	private String hsBankAccount;
	//恒生处理状态[0-未知 1-处理成功 2-处理失败]
	private Integer hsDealStatus;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
    private List<String> currentNodes;

    //小神号
    private String userId;
    //客户姓名
    private String clientName;
    //英文名
    private String clientNameSpell;
    //手机号码
    private String phoneNumber;
    //渠道
    private String sourceChannelId;
    //性别
    private Integer sex;
    //开户途径
    private String openAccountType;
    //开户银行卡
    private String bankType;
    //是否首次入金
    private String firstDepFlag;
    //开户时间
    private Date openAccountTime;
    //证件类型[0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]
    private Integer idkind;
    //证件号码
    private String idNo;
    //客户凭证
    private List<ClientFundDepositImageEntity> despositImage;

    //银行凭证
    private List<ClientFundDepositImageEntity> bankImage;

	//到账金额
	private BigDecimal benefitBalance;

	//申请开始结束日期
    private String beginTime;
    private String endTime;

    // 列表展示标识
    private String flag;
	//柜台入账时间
	private Date entryTime;

    //银行入账时间
    private Date bankEntryTime;

    //银行流水号
    private String referenceNo;

	//银行入账开始结束日期
	private String bankEntryStTime;
	private String bankEntryEdTime;

	//柜台入账开始结束日期
	private String entryStTime;
	private String entryEdTime;

	//加急处理[0-未加急 1-已加急]
	private Integer fireAid;

	//忽略前状态
	private Integer beforeStatus;

	//是否已绑定
	private int isBanding;

	private String openApplicationId;

	private List<String> applicationIds;

	//存入金额范围查询
	private String depositBalanceMin;
	private String depositBalanceMax;

	//排序[字典=COMMON_ORDER]
	private String order;

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
	 * 设置：交易帐号
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * 获取：交易帐号
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * 设置：资金帐号
	 */
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
	/**
	 * 获取：资金帐号
	 */
	public String getFundAccount() {
		return fundAccount;
	}
	/**
	 * 设置：SWIFT代码
	 */
	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
	/**
	 * 获取：SWIFT代码
	 */
	public String getSwiftCode() {
		return swiftCode;
	}
	/**
	 * 设置：入金方式[0-香港银行卡 1-大陆银行卡]
	 */
	public void setDepositType(Integer depositType) {
		this.depositType = depositType;
	}
	/**
	 * 获取：入金方式[0-香港银行卡 1-大陆银行卡]
	 */
	public Integer getDepositType() {
		return depositType;
	}
	/**
	 * 设置：汇款方式[0-未知 1-网银汇款 2-支票汇款]
	 */
	public void setRemittanceType(Integer remittanceType) {
		this.remittanceType = remittanceType;
	}
	/**
	 * 获取：汇款方式[0-未知 1-网银汇款 2-支票汇款]
	 */
	public Integer getRemittanceType() {
		return remittanceType;
	}
	/**
	 * 设置：汇款银行
	 */
	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}
	/**
	 * 获取：汇款银行
	 */
	public String getDepositBank() {
		return depositBank;
	}

	public String getDepositBankCode() {
		return depositBankCode;
	}

	public void setDepositBankCode(String depositBankCode) {
		this.depositBankCode = depositBankCode;
	}

	/**
	 * 设置：汇款账号
	 */
	public void setDepositNo(String depositNo) {
		this.depositNo = depositNo;
	}
	/**
	 * 获取：汇款账号
	 */
	public String getDepositNo() {
		return depositNo;
	}
	/**
	 * 设置：汇款账户名称
	 */
	public void setDepositAccount(String depositAccount) {
		this.depositAccount = depositAccount;
	}
	/**
	 * 获取：汇款账户名称
	 */
	public String getDepositAccount() {
		return depositAccount;
	}
	/**
	 * 设置：收款银行
	 */
	public void setBenefitBank(String benefitBank) {
		this.benefitBank = benefitBank;
	}
	/**
	 * 获取：收款银行
	 */
	public String getBenefitBank() {
		return benefitBank;
	}

	public String getBenefitBankCode() {
		return benefitBankCode;
	}

	public void setBenefitBankCode(String benefitBankCode) {
		this.benefitBankCode = benefitBankCode;
	}

	/**
	 * 设置：收款账号
	 */
	public void setBenefitNo(String benefitNo) {
		this.benefitNo = benefitNo;
	}
	/**
	 * 获取：收款账号
	 */
	public String getBenefitNo() {
		return benefitNo;
	}
	/**
	 * 设置：收款账户名称
	 */
	public void setBenefitAccount(String benefitAccount) {
		this.benefitAccount = benefitAccount;
	}
	/**
	 * 获取：收款账户名称
	 */
	public String getBenefitAccount() {
		return benefitAccount;
	}
	/**
	 * 设置：申请金额
	 */
	public void setDepositBalance(BigDecimal depositBalance) {
		this.depositBalance = depositBalance;
	}
	/**
	 * 获取：申请金额
	 */
	public BigDecimal getDepositBalance() {
		return depositBalance;
	}
	/**
	 * 设置：联系地址
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	/**
	 * 获取：联系地址
	 */
	public String getContactAddress() {
		return contactAddress;
	}
	/**
	 * 设置：申请时间
	 */
	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getApplicationTime() {
		return applicationTime;
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
	 * 设置：预约申请状态[0-未知 1-待处理 2-处理中 3-入账中 4-入账失败 5-已入账 6-退回客服 7-退回客户]
	 */
	public void setApplicationStatus(Integer applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	/**
	 * 获取：预约申请状态[0-未知 1-待处理 2-处理中 3-入账中 4-入账失败 5-已入账 6-退回客服 7-退回客户]
	 */
	public Integer getApplicationStatus() {
		return applicationStatus;
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
	 * 设置：恒生处理状态[0-未知 1-处理成功 2-处理失败]
	 */
	public void setHsDealStatus(Integer hsDealStatus) {
		this.hsDealStatus = hsDealStatus;
	}
	/**
	 * 获取：恒生处理状态[0-未知 1-处理成功 2-处理失败]
	 */
	public Integer getHsDealStatus() {
		return hsDealStatus;
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

    /**
     * 获取 userId
     *
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 clientName
     *
     * @return clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置 clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取 clientNameSpell
     *
     * @return clientNameSpell
     */
    public String getClientNameSpell() {
        return clientNameSpell;
    }

    /**
     * 设置 clientNameSpell
     */
    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    /**
     * 获取 phoneNumber
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置 phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取 sourceChannelId
     *
     * @return sourceChannelId
     */
    public String getSourceChannelId() {
        return sourceChannelId;
    }

    /**
     * 设置 sourceChannelId
     */
    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    /**
     * 获取 sex
     *
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置 sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取 openAccountType
     *
     * @return openAccountType
     */
    public String getOpenAccountType() {
        return openAccountType;
    }

    /**
     * 设置 openAccountType
     */
    public void setOpenAccountType(String openAccountType) {
        this.openAccountType = openAccountType;
    }

    /**
     * 获取 bankType
     *
     * @return bankType
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * 设置 bankType
     */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /**
     * 获取 firstDepFlag
     *
     * @return firstDepFlag
     */
    public String getFirstDepFlag() {
        return firstDepFlag;
    }

    /**
     * 设置 firstDepFlag
     */
    public void setFirstDepFlag(String firstDepFlag) {
        this.firstDepFlag = firstDepFlag;
    }

    /**
     * 获取 openAccountTime
     *
     * @return openAccountTime
     */
    public Date getOpenAccountTime() {
        return openAccountTime;
    }

    /**
     * 设置 openAccountTime
     */
    public void setOpenAccountTime(Date openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    /**
     * 获取 idkind
     *
     * @return idkind
     */
    public Integer getIdkind() {
        return idkind;
    }

    /**
     * 设置 idkind
     */
    public void setIdkind(Integer idkind) {
        this.idkind = idkind;
    }

    /**
     * 获取 idNo
     *
     * @return idNo
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置 idNo
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * 获取 despositImage
     *
     * @return despositImage
     */
    public List<ClientFundDepositImageEntity> getDespositImage() {
        return despositImage;
    }

    /**
     * 设置 despositImage
     */
    public void setDespositImage(List<ClientFundDepositImageEntity> despositImage) {
        this.despositImage = despositImage;
    }

    /**
     * 获取 bankImage
     *
     * @return bankImage
     */
    public List<ClientFundDepositImageEntity> getBankImage() {
        return bankImage;
    }

    /**
     * 设置 bankImage
     */
    public void setBankImage(List<ClientFundDepositImageEntity> bankImage) {
        this.bankImage = bankImage;
    }

	public BigDecimal getBenefitBalance() {
		return benefitBalance;
	}

	public void setBenefitBalance(BigDecimal benefitBalance) {
		this.benefitBalance = benefitBalance;
	}

	/**
     * 获取 beginTime
     *
     * @return beginTime
     */
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * 设置 beginTime
     */
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取 endTime
     *
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置 endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取 currentNodes
     *
     * @return currentNodes
     */
    public List<String> getCurrentNodes() {
        return currentNodes;
    }

    /**
     * 设置 currentNodes
     */
    public void setCurrentNodes(List<String> currentNodes) {
        this.currentNodes = currentNodes;
    }

    /**
     * 获取 flag
     *
     * @return flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置 flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

	public String getBankEntryStTime() {
		return bankEntryStTime;
	}

	public void setBankEntryStTime(String bankEntryStTime) {
		this.bankEntryStTime = bankEntryStTime;
	}

	public String getBankEntryEdTime() {
		return bankEntryEdTime;
	}

	public void setBankEntryEdTime(String bankEntryEdTime) {
		this.bankEntryEdTime = bankEntryEdTime;
	}

	public Date getBankEntryTime() {
		return bankEntryTime;
	}

	public void setBankEntryTime(Date bankEntryTime) {
		this.bankEntryTime = bankEntryTime;
	}

	public String getEntryStTime() {
		return entryStTime;
	}

	public void setEntryStTime(String entryStTime) {
		this.entryStTime = entryStTime;
	}

	public String getEntryEdTime() {
		return entryEdTime;
	}

	public void setEntryEdTime(String entryEdTime) {
		this.entryEdTime = entryEdTime;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Integer getFireAid() {
		return fireAid;
	}

	public void setFireAid(Integer fireAid) {
		this.fireAid = fireAid;
	}

	public String getOpenApplicationId() {
		return openApplicationId;
	}

	public void setOpenApplicationId(String openApplicationId) {
		this.openApplicationId = openApplicationId;
	}

	public List<String> getApplicationIds() {
		return applicationIds;
	}

	public void setApplicationIds(List<String> applicationIds) {
		this.applicationIds = applicationIds;
	}

	public String getDepositBalanceMin() {
		return depositBalanceMin;
	}

	public void setDepositBalanceMin(String depositBalanceMin) {
		this.depositBalanceMin = depositBalanceMin;
	}

	public String getDepositBalanceMax() {
		return depositBalanceMax;
	}

	public void setDepositBalanceMax(String depositBalanceMax) {
		this.depositBalanceMax = depositBalanceMax;
	}

	public Integer getBeforeStatus() {
		return beforeStatus;
	}

	public void setBeforeStatus(Integer beforeStatus) {
		this.beforeStatus = beforeStatus;
	}

	public int getIsBanding() {
		return isBanding;
	}

	public void setIsBanding(int isBanding) {
		this.isBanding = isBanding;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
