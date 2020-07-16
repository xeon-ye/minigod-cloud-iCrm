package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 客户转托管信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 10:26:17
 */
public class StockTransferInfoEntity implements Serializable {
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
    //成交数量
    private Integer occurAmount;
    //证券类别[0-股票 1-基金 D-权证]
    private String stockType;
    //币种代码[0-人民币 1-美元 2-港币]
    private String moneyType;
    //操作代码
    private String businessFlag;
    //最新价
    private BigDecimal lastPrice;
    //证券市值
    private BigDecimal stockMktValue;
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
    // 证券名称
    private String stockName;
    //渠道授权ids
    private List<String> channelIds;

    // 净资产范围类型 [1=<50万 2=50万-250万 3=250万-500万 4=>500万]
    private String netCapital;

    // 柜台预留号码
    private String phoneNumber;

    // 柜台预留电子邮箱
    private String email;

    // 渠道id
    private String channelId;

    // 定位串[日期+交易类别+流水号]
    private String positionStr;

    // 开户邀请人
    private String inviterId;

    private String clientNameSpell;

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

    /**
     * 转仓类型批量查询
     */
    private List<String> businessFlagList;

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
     * 设置：成交数量
     */
    public void setOccurAmount(Integer occurAmount) {
        this.occurAmount = occurAmount;
    }

    /**
     * 获取：成交数量
     */
    public Integer getOccurAmount() {
        return occurAmount;
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
     * 设置：操作代码
     */
    public void setBusinessFlag(String businessFlag) {
        this.businessFlag = businessFlag;
    }

    /**
     * 获取：操作代码
     */
    public String getBusinessFlag() {
        return businessFlag;
    }

    /**
     * 设置：最新价
     */
    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    /**
     * 获取：最新价
     */
    public BigDecimal getLastPrice() {
        return lastPrice;
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

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }

    public String getClientNameSpell() {
        return clientNameSpell;
    }

    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    public List<String> getBusinessFlagList() {
        return businessFlagList;
    }

    public void setBusinessFlagList(List<String> businessFlagList) {
        this.businessFlagList = businessFlagList;
    }
}
