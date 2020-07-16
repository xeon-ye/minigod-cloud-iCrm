package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 客户资金流水汇总表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-28 14:24:52
 */
public class ClientAssetFlowInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//小神号
	private Integer userId;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//交易日期
	private String tradeDate;
	//币种代码[0-人民币 1-美元 2-港币]
	private String moneyType;
	//现金余额
	private BigDecimal currentBalance;
	//冻结资金
	private BigDecimal frozenBalance;
	//证券市值
	private BigDecimal marketValueCur;
	//总资产
	private BigDecimal totalAssets;
	//创建时间
	private String createTime;
	//修改时间
	private String updateTime;
    // 客户姓名
    private String clientName;
    // 渠道名称
    private String channelName;
    // 渠道号
    private String channelId;
    // 资产上限
    private BigDecimal maxTotalAssets;
    // 资产下限
    private BigDecimal minTotalAssets;
    //渠道授权
    private List<String> channelIds;
    //多个交易帐号
    private List<String> clientIds;
    // 表名
    private String tableName;
	// 开始日期
	private String beginDate;
	// 结束日期
	private String endDate;
	//交易天数
	private Integer tradeDateNum;

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
	 * 设置：小神号
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：小神号
	 */
	public Integer getUserId() {
		return userId;
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
	 * 设置：交易日期
	 */
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	/**
	 * 获取：交易日期
	 */
	public String getTradeDate() {
		return tradeDate;
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
	 * 设置：现金余额
	 */
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	/**
	 * 获取：现金余额
	 */
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	/**
	 * 设置：冻结资金
	 */
	public void setFrozenBalance(BigDecimal frozenBalance) {
		this.frozenBalance = frozenBalance;
	}
	/**
	 * 获取：冻结资金
	 */
	public BigDecimal getFrozenBalance() {
		return frozenBalance;
	}
	/**
	 * 设置：证券市值
	 */
	public void setMarketValueCur(BigDecimal marketValueCur) {
		this.marketValueCur = marketValueCur;
	}
	/**
	 * 获取：证券市值
	 */
	public BigDecimal getMarketValueCur() {
		return marketValueCur;
	}
	/**
	 * 设置：总资产
	 */
	public void setTotalAssets(BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}
	/**
	 * 获取：总资产
	 */
	public BigDecimal getTotalAssets() {
		return totalAssets;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdateTime() {
		return updateTime;
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

    public BigDecimal getMaxTotalAssets() {
        return maxTotalAssets;
    }

    public void setMaxTotalAssets(BigDecimal maxTotalAssets) {
        this.maxTotalAssets = maxTotalAssets;
    }

    public BigDecimal getMinTotalAssets() {
        return minTotalAssets;
    }

    public void setMinTotalAssets(BigDecimal minTotalAssets) {
        this.minTotalAssets = minTotalAssets;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<String> getClientIds() {
        return clientIds;
    }

    public void setClientIds(List<String> clientIds) {
        this.clientIds = clientIds;
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

	public Integer getTradeDateNum() {
		return tradeDateNum;
	}

	public void setTradeDateNum(Integer tradeDateNum) {
		this.tradeDateNum = tradeDateNum;
	}
}
