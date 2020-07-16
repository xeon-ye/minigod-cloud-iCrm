package com.sunline.modules.market.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 行情套餐购买信息表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-05-13 11:07:10
 */
public class ClientMarketPackageInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//流水号
	private String applicationId;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//行情套餐[1-国际标准版 2-内地优惠手机版 3-内地优惠升级版]
	private Integer packageName;
	//单价
	private BigDecimal packagePrice;
	//总价
	private BigDecimal totalCost;
    //行情类型[1-港股行情 2-美股行情]
	private Integer packageType;
	//有效期
	private String validityPeriod;
	//购买日期
	private Date buyDate;
    //币种代码[0-人民币 1-美元 2-港币]
    private String moneyType;
	//扣款状态[1-待扣款 2-扣款成功 3-扣款失败]
	private Integer deductionStatus;
	//恒生银行编号
	private String hsBankId;
	//恒生银行帐户
	private String hsBankAccount;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

    //小神号
    private String userId;
    //客户姓名
    private String clientName;
    //手机号
    private String phoneNumber;

    private String beginTime;
    private String endTime;
    /**
     * 授权渠道
     */
    private List<String> channelIds;

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
     * 获取：行情套餐
     *
     * @return packageName
     */
    public Integer getPackageName() {
        return packageName;
    }

    /**
     * 设置：行情套餐
     */
    public void setPackageName(Integer packageName) {
        this.packageName = packageName;
    }

    /**
	 * 设置：单价
	 */
	public void setPackagePrice(BigDecimal packagePrice) {
		this.packagePrice = packagePrice;
	}
	/**
	 * 获取：单价
	 */
	public BigDecimal getPackagePrice() {
		return packagePrice;
	}
	/**
	 * 设置：总价
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	/**
	 * 获取：总价
	 */
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	/**
	 * 设置：有效期
	 */
	public void setValidityPeriod(String validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	/**
	 * 获取：有效期
	 */
	public String getValidityPeriod() {
		return validityPeriod;
	}
	/**
	 * 设置：购买日期
	 */
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	/**
	 * 获取：购买日期
	 */
	public Date getBuyDate() {
		return buyDate;
	}

    /**
     * 获取 moneyType
     *
     * @return moneyType
     */
    public String getMoneyType() {
        return moneyType;
    }

    /**
     * 设置 moneyType
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    /**
	 * 设置：扣款状态[1-待扣款 2-扣款成功 3-扣款失败]
	 */
	public void setDeductionStatus(Integer deductionStatus) {
		this.deductionStatus = deductionStatus;
	}
	/**
	 * 获取：扣款状态[1-待扣款 2-扣款成功 3-扣款失败]
	 */
	public Integer getDeductionStatus() {
		return deductionStatus;
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
     * 获取 packageType
     *
     * @return packageType
     */
    public Integer getPackageType() {
        return packageType;
    }

    /**
     * 设置 packageType
     */
    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }

    /**
     * 获取 channelIds
     *
     * @return channelIds
     */
    public List<String> getChannelIds() {
        return channelIds;
    }

    /**
     * 设置 channelIds
     */
    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }
}
