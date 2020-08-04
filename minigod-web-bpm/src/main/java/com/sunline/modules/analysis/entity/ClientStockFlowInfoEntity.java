package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 客户股票流水汇总表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-02 17:12:17
 */
public class ClientStockFlowInfoEntity implements Serializable {
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
	//证券市场[K-港交所 P-美国市场]
	private String exchangeType;
	//证券代码
	private String stockCode;
	//证券名称
	private String stockName;
	//证券类别[0-股票 1-基金 D-权证]
	private String stockType;
	//币种代码[0-人民币 1-美元 2-港币]
	private String moneyType;
	//期初数量
	private Integer beginAmount;
	//当前数量
	private Integer currentAmount;
	//冻结数量
	private Integer frozenAmount;
	//解冻数量
	private Integer unfrozenAmount;
	//买入均价
	private BigDecimal costPrice;
	//证券市值
	private BigDecimal stockMktValue;
	//参考盈亏
	private BigDecimal referProfitCost;
	//创建时间
	private String createTime;
	//修改时间
	private String updateTime;
    // 客户姓名
    private String clientName;
    // 渠道名称
    private String channelName;
    // 渠道名称
    private String channelId;
    //渠道授权ids
    private List<String> channelIds;
    // 表名
    private String tableName;

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
	 * 设置：证券市场[K-港交所 P-美国市场]
	 */
	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}
	/**
	 * 获取：证券市场[K-港交所 P-美国市场]
	 */
	public String getExchangeType() {
		return exchangeType;
	}
	/**
	 * 设置：证券代码
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	/**
	 * 获取：证券代码
	 */
	public String getStockCode() {
		return stockCode;
	}
	/**
	 * 设置：证券名称
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	/**
	 * 获取：证券名称
	 */
	public String getStockName() {
		return stockName;
	}
	/**
	 * 设置：证券类别[0-股票 1-基金 D-权证]
	 */
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	/**
	 * 获取：证券类别[0-股票 1-基金 D-权证]
	 */
	public String getStockType() {
		return stockType;
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
	 * 设置：期初数量
	 */
	public void setBeginAmount(Integer beginAmount) {
		this.beginAmount = beginAmount;
	}
	/**
	 * 获取：期初数量
	 */
	public Integer getBeginAmount() {
		return beginAmount;
	}
	/**
	 * 设置：当前数量
	 */
	public void setCurrentAmount(Integer currentAmount) {
		this.currentAmount = currentAmount;
	}
	/**
	 * 获取：当前数量
	 */
	public Integer getCurrentAmount() {
		return currentAmount;
	}
	/**
	 * 设置：冻结数量
	 */
	public void setFrozenAmount(Integer frozenAmount) {
		this.frozenAmount = frozenAmount;
	}
	/**
	 * 获取：冻结数量
	 */
	public Integer getFrozenAmount() {
		return frozenAmount;
	}
	/**
	 * 设置：解冻数量
	 */
	public void setUnfrozenAmount(Integer unfrozenAmount) {
		this.unfrozenAmount = unfrozenAmount;
	}
	/**
	 * 获取：解冻数量
	 */
	public Integer getUnfrozenAmount() {
		return unfrozenAmount;
	}
	/**
	 * 设置：买入均价
	 */
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	/**
	 * 获取：买入均价
	 */
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	/**
	 * 设置：证券市值
	 */
	public void setStockMktValue(BigDecimal stockMktValue) {
		this.stockMktValue = stockMktValue;
	}
	/**
	 * 获取：证券市值
	 */
	public BigDecimal getStockMktValue() {
		return stockMktValue;
	}
	/**
	 * 设置：参考盈亏
	 */
	public void setReferProfitCost(BigDecimal referProfitCost) {
		this.referProfitCost = referProfitCost;
	}
	/**
	 * 获取：参考盈亏
	 */
	public BigDecimal getReferProfitCost() {
		return referProfitCost;
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
}
