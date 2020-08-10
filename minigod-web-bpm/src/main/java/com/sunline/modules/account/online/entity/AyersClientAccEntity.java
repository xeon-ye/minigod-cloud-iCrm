package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AyersClientAccEntity implements Serializable {
    private String uuid;
    private String clientAccId;
    private String clientId;
    /**
     * 账户类型
     * C - Cash
     * D - Cash (Settle)
     * H - House
     * M - Margin
     */
    private String accType;
    private String accCode;
    /**
     * AE代码
     */
    private String aeCode;
    // 2009-02-14
    private Date openDate;
    // 2009-02-14
    private Date closeDate;
    /**
     * A - Active 激活
     * C - Closed 关闭
     * D - Dormant 休眠
     * S - Suspended 暂停
     */
    private String status;
    /**
     * 仅供期货产品使用
     * H – Hedge
     * O – Ominbus
     */
    private String clearingAccType;
    //贷款限额
    private BigDecimal loanLimit;
    //到期日
    private Date loanExpiryDate;
    //交易限额
    private BigDecimal tradingLimit;
    //账单支付号
    private String billPayNo;
    /**
     * 互联网交易
     * Y - Enabled
     * N - Disabled
     */
    private String internetTrading;
    /**
     * Y - Enabled
     * N - Disabled
     */
    private String ivrsTrading;
    /**
     * Y - Enabled
     * N - Disabled
     */
    private String mangoTrading;
    /**
     * Y - Enabled
     * N - Disabled
     */
    private String mobileTrading;
    private String createUser;
    private Date createTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getClientAccId() {
        return clientAccId;
    }

    public void setClientAccId(String clientAccId) {
        this.clientAccId = clientAccId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }

    public String getAeCode() {
        return aeCode;
    }

    public void setAeCode(String aeCode) {
        this.aeCode = aeCode;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClearingAccType() {
        return clearingAccType;
    }

    public void setClearingAccType(String clearingAccType) {
        this.clearingAccType = clearingAccType;
    }

    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
    }

    public Date getLoanExpiryDate() {
        return loanExpiryDate;
    }

    public void setLoanExpiryDate(Date loanExpiryDate) {
        this.loanExpiryDate = loanExpiryDate;
    }

    public BigDecimal getTradingLimit() {
        return tradingLimit;
    }

    public void setTradingLimit(BigDecimal tradingLimit) {
        this.tradingLimit = tradingLimit;
    }

    public String getBillPayNo() {
        return billPayNo;
    }

    public void setBillPayNo(String billPayNo) {
        this.billPayNo = billPayNo;
    }

    public String getIvrsTrading() {
        return ivrsTrading;
    }

    public void setIvrsTrading(String ivrsTrading) {
        this.ivrsTrading = ivrsTrading;
    }

    public String getMangoTrading() {
        return mangoTrading;
    }

    public void setMangoTrading(String mangoTrading) {
        this.mangoTrading = mangoTrading;
    }

    public String getMobileTrading() {
        return mobileTrading;
    }

    public void setMobileTrading(String mobileTrading) {
        this.mobileTrading = mobileTrading;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInternetTrading() {
        return internetTrading;
    }

    public void setInternetTrading(String internetTrading) {
        this.internetTrading = internetTrading;
    }
}
