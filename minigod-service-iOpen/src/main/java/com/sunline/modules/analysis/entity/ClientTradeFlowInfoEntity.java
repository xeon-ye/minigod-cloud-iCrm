package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 客户交易流水汇总表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-24 17:56:39
 */
public class ClientTradeFlowInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //小神号
    private Integer userId;
    private Integer serialNo;
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
    //交易类别[0B-买入 0S-卖出]
    private String tradeKind;
    //证券类别[0-股票 1-基金 D-权证 CBB-牛熊证 OPT-债券 WTS-涡轮 DER-衍生权证]
    private String stockType;
    //委托方式[7-网上委托 4-自助委托 T-电话委托]
    private String entrustWay;
    //币种代码[0-人民币 1-美元 2-港币]
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
    //交易流水号
    private Integer sequenceNo;
    private Integer allocationId;
    //创建时间
    private String createTime;
    //修改时间
    private String updateTime;
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

    //会话类型[0-正常交易时段 1-非正常交易时段 2-暗盘时段]
    private String sessionType;

    //佣金下限
    private BigDecimal minFeeCount;
    //佣金上限
    private BigDecimal maxFeeCount;
    //交易帐号（批量查询）
    private List<String> batchTradeAccountList;

    public String getCheckedChannelId() {
        return checkedChannelId;
    }

    public void setCheckedChannelId(String checkedChannelId) {
        this.checkedChannelId = checkedChannelId;
    }

    /**
     * 菜单选择 多渠道号查询params
     *
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

    public BigDecimal getFeeCountRatio() {
        return feeCountRatio;
    }

    public void setFeeCountRatio(BigDecimal feeCountRatio) {
        this.feeCountRatio = feeCountRatio;
    }

    public BigDecimal getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(BigDecimal businessPrice) {
        this.businessPrice = businessPrice;
    }

    /**
     * 图示分类 flag
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String countBusAmount;
    private String countBusBalance;
    private String countFreeRadio;

    public String getCountBusAmount() {
        return countBusAmount;
    }

    public void setCountBusAmount(String countBusAmount) {
        this.countBusAmount = countBusAmount;
    }

    public String getCountBusBalance() {
        return countBusBalance;
    }

    public void setCountBusBalance(String countBusBalance) {
        this.countBusBalance = countBusBalance;
    }

    public String getCountFreeRadio() {
        return countFreeRadio;
    }

    public void setCountFreeRadio(String countFreeRadio) {
        this.countFreeRadio = countFreeRadio;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    /**
     * 获取 minFeeCount
     *
     * @return minFeeCount
     */
    public BigDecimal getMinFeeCount() {
        return minFeeCount;
    }

    /**
     * 设置 minFeeCount
     */
    public void setMinFeeCount(BigDecimal minFeeCount) {
        this.minFeeCount = minFeeCount;
    }

    /**
     * 获取 maxFeeCount
     *
     * @return maxFeeCount
     */
    public BigDecimal getMaxFeeCount() {
        return maxFeeCount;
    }

    /**
     * 设置 maxFeeCount
     */
    public void setMaxFeeCount(BigDecimal maxFeeCount) {
        this.maxFeeCount = maxFeeCount;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Integer allocationId) {
        this.allocationId = allocationId;
    }

    public List<String> getBatchTradeAccountList() {
        return batchTradeAccountList;
    }

    public void setBatchTradeAccountList(List<String> batchTradeAccountList) {
        this.batchTradeAccountList = batchTradeAccountList;
    }
}
