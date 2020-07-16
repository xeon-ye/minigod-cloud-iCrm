package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-06-10 17:17:58
 */
public class ChannelReturnEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //流水序号
    private Long serialNo;
    //小神号
    private Integer userId;
    //交易账号
    private String clientId;
    //资金账号
    private String fundAccount;
    //交易日期
    private Date tradeDate;
    //证券市场[K-港交所 P-美国市场]
    private String exchangeType;
    //证券代码
    private String stockCode;
    //交易类别[0B-买入 OS-卖出]
    private String tradeKind;
    //证券类别[0-股票 1-基金 D-权证]
    private String stockType;
    //委托方式[7-网上委托 T-电话委托]
    private String entrustWay;
    //币种代码[0-人名币 1-美元 2-港币]
    private String moneyType;
    //成交数量
    private Integer businessAmount;
    //成交金额
    private BigDecimal businessBalance;
    //成交价格
    private BigDecimal businessPrice;
    //佣金
    private BigDecimal feeCount;
    //净佣金
    private BigDecimal profitFeeCount;
    //其他费用
    private BigDecimal otherFeeCount;
    //资金发生数
    private BigDecimal occurBalance;
    //会话类型[0-正常交易时段 1-非正常交易时段 2-暗盘时段]
    private String sessionType;
    //交易流水号
    private Integer sequenceNo;
    //分拆序号
    private Integer allocationId;
    //入账状态[0-待入账 1-入帐中 2-已入账 3-入账失败]
    private Integer entryStatus;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;

    // 客户姓名
    private String clientName;
    // 证券名称
    private String stockName;
    // 开始日期
    private String beginDate;
    // 结束日期
    private String endDate;
    // 渠道名称
    private String channelName;
    // 渠道id
    private String channelId;
    // 佣金比例
    private BigDecimal feeCountRatio;
    /**
     * 授权渠道
     */
    private List<String> channelIds;

    /**
     * 弹出菜单选择的 渠道号
     *
     * @return
     */
    private String checkedChannelId;

    //佣金下限
    private BigDecimal minFeeCount;
    //佣金上限
    private BigDecimal maxFeeCount;

    private Date maxTradeDate;
    private Date minTradeDate;

    private String totalRefund;

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
     * 设置：流水序号
     */
    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 获取：流水序号
     */
    public Long getSerialNo() {
        return serialNo;
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
     * 设置：交易账号
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取：交易账号
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置：资金账号
     */
    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    /**
     * 获取：资金账号
     */
    public String getFundAccount() {
        return fundAccount;
    }

    /**
     * 设置：交易日期
     */
    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    /**
     * 获取：交易日期
     */
    public Date getTradeDate() {
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
     * 设置：交易类别[0B-买入 OS-卖出]
     */
    public void setTradeKind(String tradeKind) {
        this.tradeKind = tradeKind;
    }

    /**
     * 获取：交易类别[0B-买入 OS-卖出]
     */
    public String getTradeKind() {
        return tradeKind;
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
     * 设置：委托方式[7-网上委托 T-电话委托]
     */
    public void setEntrustWay(String entrustWay) {
        this.entrustWay = entrustWay;
    }

    /**
     * 获取：委托方式[7-网上委托 T-电话委托]
     */
    public String getEntrustWay() {
        return entrustWay;
    }

    /**
     * 设置：币种代码[0-人名币 1-美元 2-港币]
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    /**
     * 获取：币种代码[0-人名币 1-美元 2-港币]
     */
    public String getMoneyType() {
        return moneyType;
    }

    /**
     * 设置：成交数量
     */
    public void setBusinessAmount(Integer businessAmount) {
        this.businessAmount = businessAmount;
    }

    /**
     * 获取：成交数量
     */
    public Integer getBusinessAmount() {
        return businessAmount;
    }

    /**
     * 设置：成交金额
     */
    public void setBusinessBalance(BigDecimal businessBalance) {
        this.businessBalance = businessBalance;
    }

    /**
     * 获取：成交金额
     */
    public BigDecimal getBusinessBalance() {
        return businessBalance;
    }

    /**
     * 设置：成交价格
     */
    public void setBusinessPrice(BigDecimal businessPrice) {
        this.businessPrice = businessPrice;
    }

    /**
     * 获取：成交价格
     */
    public BigDecimal getBusinessPrice() {
        return businessPrice;
    }

    /**
     * 设置：佣金
     */
    public void setFeeCount(BigDecimal feeCount) {
        this.feeCount = feeCount;
    }

    /**
     * 获取：佣金
     */
    public BigDecimal getFeeCount() {
        return feeCount;
    }

    /**
     * 设置：净佣金
     */
    public void setProfitFeeCount(BigDecimal profitFeeCount) {
        this.profitFeeCount = profitFeeCount;
    }

    /**
     * 获取：净佣金
     */
    public BigDecimal getProfitFeeCount() {
        return profitFeeCount;
    }

    /**
     * 设置：其他费用
     */
    public void setOtherFeeCount(BigDecimal otherFeeCount) {
        this.otherFeeCount = otherFeeCount;
    }

    /**
     * 获取：其他费用
     */
    public BigDecimal getOtherFeeCount() {
        return otherFeeCount;
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
     * 设置：会话类型[0-正常交易时段 1-非正常交易时段 2-暗盘时段]
     */
    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    /**
     * 获取：会话类型[0-正常交易时段 1-非正常交易时段 2-暗盘时段]
     */
    public String getSessionType() {
        return sessionType;
    }

    /**
     * 设置：交易流水号
     */
    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    /**
     * 获取：交易流水号
     */
    public Integer getSequenceNo() {
        return sequenceNo;
    }

    /**
     * 设置：分拆序号
     */
    public void setAllocationId(Integer allocationId) {
        this.allocationId = allocationId;
    }

    /**
     * 获取：分拆序号
     */
    public Integer getAllocationId() {
        return allocationId;
    }

    /**
     * 设置：入账状态[0-待入账 1-入帐中 2-已入账 3-入账失败]
     */
    public void setEntryStatus(Integer entryStatus) {
        this.entryStatus = entryStatus;
    }

    /**
     * 获取：入账状态[0-待入账 1-入帐中 2-已入账 3-入账失败]
     */
    public Integer getEntryStatus() {
        return entryStatus;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public BigDecimal getFeeCountRatio() {
        return feeCountRatio;
    }

    public void setFeeCountRatio(BigDecimal feeCountRatio) {
        this.feeCountRatio = feeCountRatio;
    }

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    public String getCheckedChannelId() {
        return checkedChannelId;
    }

    public void setCheckedChannelId(String checkedChannelId) {
        this.checkedChannelId = checkedChannelId;
    }

    public BigDecimal getMinFeeCount() {
        return minFeeCount;
    }

    public void setMinFeeCount(BigDecimal minFeeCount) {
        this.minFeeCount = minFeeCount;
    }

    public BigDecimal getMaxFeeCount() {
        return maxFeeCount;
    }

    public void setMaxFeeCount(BigDecimal maxFeeCount) {
        this.maxFeeCount = maxFeeCount;
    }

    public Date getMaxTradeDate() {
        return maxTradeDate;
    }

    public void setMaxTradeDate(Date maxTradeDate) {
        this.maxTradeDate = maxTradeDate;
    }

    public Date getMinTradeDate() {
        return minTradeDate;
    }

    public void setMinTradeDate(Date minTradeDate) {
        this.minTradeDate = minTradeDate;
    }

    public String getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(String totalRefund) {
        this.totalRefund = totalRefund;
    }
}
