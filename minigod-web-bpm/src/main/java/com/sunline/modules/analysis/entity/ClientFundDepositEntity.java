package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 客户账户存款记录表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 16:22:19
 */
public class ClientFundDepositEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Integer id;
    //小神号
    private Integer userId;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//清算日期
	private String initDate;
	//存款类型[D-存入 W-存出]
	private String depositType;
	//币种代码[0-人民币 1-美元 2-港币]
	private String moneyType;
	//操作方式
	private String opEntrustWay;
	//银行标识
	private String bankId;
	//银行账号
	private String bankAccount;
	//资金发生数
	private BigDecimal occurBalance;
	//备注
	private String remark;
	//当前备注
	private String localeRemark;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

    // 开始日期
    private String beginDate;
    // 结束日期
    private String endDate;
    // 客户姓名
    private String clientName;
    // 渠道名称
    private String channelName;
    // 渠道id
    private String channelId;
    // 证券名称
    private String stockName;
    //渠道授权ids
    private List<String> channelIds;

    // 净资产范围类型 [1=<50万 2=50万-250万 3=250万-500万 4=>500万]
    private String netCapital;

    // 定位串
    private String positionStr;

    // 柜台预留号码
    private String phoneNumber;

    // 柜台预留电子邮箱
    private String email;

    // 开户邀请人
    private String inviterId;
    // 首次入金标识
    private String firstDepFlag;

    private String clientNameSpell;

    // 累计入金总额
    private String totalIncAmount;
    // 累计出金总额
    private String totalOutAmount;

    // 出入金的总和
    private String totalAmount;

    // 年收入最大值
    private String maxAnnualIncome;

    // 财产种类最大值总和
    private String maxPropertyAmount;
    // 年收入
    private String annualIncome;
    // 财产种类
    private Integer propertyType;
    // 财产值
    private String propertyAmount;
    private String applicationId;

    //交易帐号（批量查询）
    private List<String> batchTradeAccountList;

    //小神帐号（批量查询）
    private List<String> batchUserIdList;

    /**
     * 弹出菜单选择的 渠道号
     * @return
     */
    private String checkedChannelId;

    public String getCheckedChannelId() {
        return checkedChannelId;
    }

    public void setCheckedChannelId(String checkedChannelId) {
        this.checkedChannelId = checkedChannelId;
    }

    /**
     *  菜单选择 多渠道号查询params
     * @return
     */

    private List<String> checkedChannelIds;

    public List<String> getCheckedChannelIds() {
        return checkedChannelIds;
    }

    public void setCheckedChannelIds(List<String> checkedChannelIds) {
        this.checkedChannelIds = checkedChannelIds;
    }

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

	/**
	 * 设置：自增ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Integer getId() {
		return id;
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
	 * 设置：清算日期
	 */
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}
	/**
	 * 获取：清算日期
	 */
	public String getInitDate() {
		return initDate;
	}

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
	 * 设置：存款类型[D-存入 W-存出]
	 */
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	/**
	 * 获取：存款类型[D-存入 W-存出]
	 */
	public String getDepositType() {
		return depositType;
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
	 * 设置：操作方式
	 */
	public void setOpEntrustWay(String opEntrustWay) {
		this.opEntrustWay = opEntrustWay;
	}
	/**
	 * 获取：操作方式
	 */
	public String getOpEntrustWay() {
		return opEntrustWay;
	}
	/**
	 * 设置：银行标识
	 */
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	/**
	 * 获取：银行标识
	 */
	public String getBankId() {
		return bankId;
	}
	/**
	 * 设置：银行账号
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * 获取：银行账号
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 设置：资金发生数
	 */
	public void setOccurBalance(BigDecimal occurBalance) {
		this.occurBalance = occurBalance;
	}
	/**
	 * 获取：资金发生数
	 */
	public BigDecimal getOccurBalance() {
		return occurBalance;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：当前备注
	 */
	public void setLocaleRemark(String localeRemark) {
		this.localeRemark = localeRemark;
	}
	/**
	 * 获取：当前备注
	 */
	public String getLocaleRemark() {
		return localeRemark;
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
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNetCapital() {
        return netCapital;
    }

    public void setNetCapital(String netCapital) {
        this.netCapital = netCapital;
    }

    public String getPositionStr() {
        return positionStr;
    }

    public void setPositionStr(String positionStr) {
        this.positionStr = positionStr;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }

    public String getFirstDepFlag() {
        return firstDepFlag;
    }

    public void setFirstDepFlag(String firstDepFlag) {
        this.firstDepFlag = firstDepFlag;
    }

    public String getClientNameSpell() {
        return clientNameSpell;
    }

    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    public String getTotalIncAmount() {
        return totalIncAmount;
    }

    public void setTotalIncAmount(String totalIncAmount) {
        this.totalIncAmount = totalIncAmount;
    }

    public String getMaxAnnualIncome() {
        return maxAnnualIncome;
    }

    public void setMaxAnnualIncome(String maxAnnualIncome) {
        this.maxAnnualIncome = maxAnnualIncome;
    }

    public String getMaxPropertyAmount() {
        return maxPropertyAmount;
    }

    public void setMaxPropertyAmount(String maxPropertyAmount) {
        this.maxPropertyAmount = maxPropertyAmount;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Integer getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyAmount() {
        return propertyAmount;
    }

    public void setPropertyAmount(String propertyAmount) {
        this.propertyAmount = propertyAmount;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getTotalOutAmount() {
        return totalOutAmount;
    }

    public void setTotalOutAmount(String totalOutAmount) {
        this.totalOutAmount = totalOutAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<String> getBatchTradeAccountList() {
        return batchTradeAccountList;
    }

    public void setBatchTradeAccountList(List<String> batchTradeAccountList) {
        this.batchTradeAccountList = batchTradeAccountList;
    }

    public List<String> getBatchUserIdList() {
        return batchUserIdList;
    }

    public void setBatchUserIdList(List<String> batchUserIdList) {
        this.batchUserIdList = batchUserIdList;
    }
}
