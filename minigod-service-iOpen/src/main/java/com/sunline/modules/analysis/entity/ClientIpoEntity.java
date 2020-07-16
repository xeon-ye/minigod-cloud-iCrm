package com.sunline.modules.analysis.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 打新查询entity
 *
 * @author  lcs
 * @date 2018-06-22 14:00:00
 * @
 */

public class ClientIpoEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private String id;
    /**
     * 交易帐号
     */
    private String clientId;
    /**
     * 资金帐号
     */
    private String fundAccount;
    /**
     * 认购日期
     */
    private String currDate;
    /**
     * 认购方式
     */
    private String type;
    /**
     * 认购股数
     */
    private String quantityApply;
    /**
     * 认购金额
     */
    private String applyAmount;
    /**
     * 认购状态
     */
    private String status;
    /**
     * 证券代码
     */
    private String stockCode;
    /**
     * 证券名称
     */
    private String stockName;
    /**
     * 上市日期
     */
    private String tradingDate;
    /**
     * 中签数量

     */
    private String quantityAllotted;

    /**
     * 渠道授权
     */
    List<String> channelIds;

    /**
     * 客户号
     * @return
     */
    private String userId;

    /**
     * 客户姓名
     * @return
     */
    private String clientName;

    /**
     * 渠道
     * @return
     */
    private String channelName;
    /**
     * 渠道号
     * @return
     */
    private String channelId;

    /**
     * 申请状态
     */
    private String statusCheck;

    /**
     * 开始结束日期
     */
    private String beginDate;
    private String endDate;

    private String phoneNumber;

    /**
     * 弹出菜单选择的 渠道号
     * @return
     */
    private String checkedChannelId;

    /**
     * 股票代码（批量查询）
     */
    private List<String> batchStkCodeList;

    /**
     * 融资利息
     */
    private BigDecimal financingAmount;

    /**
     * 中签金额
     */
    private BigDecimal finalAmount;

    /**
     *  菜单选择 多渠道号查询params
     */
    private List<String> checkedChannelIds;

    /**
     * 截至日期(扣款日期)
     */
    private String cutoffDate;

    /**
     * 证券市场
     */
    private String exchangeType;

    /**
     * 申购资金比例
     */
    private String depositRate;

    /**
     * 客户申购资金
     */
    private String depositAmount;

    /**
     * IPO利率
     */
    private String ipoIntrate;

    /**
     * 手续费
     */
    private BigDecimal handlingFee;

    public String getCheckedChannelId() {
        return checkedChannelId;
    }

    public void setCheckedChannelId(String checkedChannelId) {
        this.checkedChannelId = checkedChannelId;
    }

    public List<String> getCheckedChannelIds() {
        return checkedChannelIds;
    }

    public void setCheckedChannelIds(List<String> checkedChannelIds) {
        this.checkedChannelIds = checkedChannelIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCurrDate() {
        return currDate;
    }

    public void setCurrDate(String currDate) {
        this.currDate = currDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantityApply() {
        return quantityApply;
    }

    public void setQuantityApply(String quantityApply) {
        this.quantityApply = quantityApply;
    }

    public String getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(String applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(String tradingDate) {
        this.tradingDate = tradingDate;
    }

    public String getQuantityAllotted() {
        return quantityAllotted;
    }

    public void setQuantityAllotted(String quantityAllotted) {
        this.quantityAllotted = quantityAllotted;
    }

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getStatusCheck() {
        return statusCheck;
    }

    public void setStatusCheck(String statusCheck) {
        this.statusCheck = statusCheck;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getBatchStkCodeList() {
        return batchStkCodeList;
    }

    public void setBatchStkCodeList(List<String> batchStkCodeList) {
        this.batchStkCodeList = batchStkCodeList;
    }

    public BigDecimal getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(BigDecimal financingAmount) {
        this.financingAmount = financingAmount;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getCutoffDate() {
        return cutoffDate;
    }

    public void setCutoffDate(String cutoffDate) {
        this.cutoffDate = cutoffDate;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getDepositRate() {
        return depositRate;
    }

    public void setDepositRate(String depositRate) {
        this.depositRate = depositRate;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getIpoIntrate() {
        return ipoIntrate;
    }

    public void setIpoIntrate(String ipoIntrate) {
        this.ipoIntrate = ipoIntrate;
    }

    public BigDecimal getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(BigDecimal handlingFee) {
        this.handlingFee = handlingFee;
    }
}
