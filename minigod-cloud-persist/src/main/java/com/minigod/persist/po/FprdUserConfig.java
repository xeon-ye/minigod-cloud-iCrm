package com.minigod.persist.po;
import com.minigod.persist.tables.TFprdUserConfig;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 理财用户业务配置表
 */
@Entity(table=TFprdUserConfig.class)
public class FprdUserConfig implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userConfigId;//用户配置ID,主键，自增长字段
	private Integer userId;//用户Id,用户id为0表示所有人的默认配置。
	private BigDecimal currencyBaseInterestRate;//基准利率,0.01表示1%,默认0.07
	private BigDecimal currencyOnceLowerLimit;//用户单次购买下限,默认下限为1K
	private BigDecimal currencyRedeemLowerLimit;//单次提现下限
	private BigDecimal currencyBuyQuota;//用户可购买总额度
	private BigDecimal currencyUpperInterestRate;//用户最高年华利率,0.01表示1%,默认0.09
	private Integer currencyFreeWithdrawCount;//月免费提现次数,默认2
	private BigDecimal currencyDayWithdrawLimit;//日提现额度限制,默认5W
	private String currencyRefreshNotice;//是否接受额度更新通知,Y/N,默认N
	private BigDecimal currencyWithdrawFee;//提现手续费
	private Integer createBy;//由谁创建,OMS操作人ID
	private Integer updateBy;//由谁更改,OMS操作人ID
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间

    public Integer getUserConfigId () {
        return userConfigId;
    }

    public void setUserConfigId (Integer userConfigId) {
        this.userConfigId = userConfigId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getCurrencyBaseInterestRate () {
        return currencyBaseInterestRate;
    }

    public void setCurrencyBaseInterestRate (BigDecimal currencyBaseInterestRate) {
        this.currencyBaseInterestRate = currencyBaseInterestRate;
    }

    public BigDecimal getCurrencyOnceLowerLimit () {
        return currencyOnceLowerLimit;
    }

    public void setCurrencyOnceLowerLimit (BigDecimal currencyOnceLowerLimit) {
        this.currencyOnceLowerLimit = currencyOnceLowerLimit;
    }

    public BigDecimal getCurrencyRedeemLowerLimit () {
        return currencyRedeemLowerLimit;
    }

    public void setCurrencyRedeemLowerLimit (BigDecimal currencyRedeemLowerLimit) {
        this.currencyRedeemLowerLimit = currencyRedeemLowerLimit;
    }

    public BigDecimal getCurrencyBuyQuota () {
        return currencyBuyQuota;
    }

    public void setCurrencyBuyQuota (BigDecimal currencyBuyQuota) {
        this.currencyBuyQuota = currencyBuyQuota;
    }

    public BigDecimal getCurrencyUpperInterestRate () {
        return currencyUpperInterestRate;
    }

    public void setCurrencyUpperInterestRate (BigDecimal currencyUpperInterestRate) {
        this.currencyUpperInterestRate = currencyUpperInterestRate;
    }

    public Integer getCurrencyFreeWithdrawCount () {
        return currencyFreeWithdrawCount;
    }

    public void setCurrencyFreeWithdrawCount (Integer currencyFreeWithdrawCount) {
        this.currencyFreeWithdrawCount = currencyFreeWithdrawCount;
    }

    public BigDecimal getCurrencyDayWithdrawLimit () {
        return currencyDayWithdrawLimit;
    }

    public void setCurrencyDayWithdrawLimit (BigDecimal currencyDayWithdrawLimit) {
        this.currencyDayWithdrawLimit = currencyDayWithdrawLimit;
    }

    public String getCurrencyRefreshNotice () {
        return currencyRefreshNotice;
    }

    public void setCurrencyRefreshNotice (String currencyRefreshNotice) {
        this.currencyRefreshNotice = currencyRefreshNotice;
    }

    public BigDecimal getCurrencyWithdrawFee () {
        return currencyWithdrawFee;
    }

    public void setCurrencyWithdrawFee (BigDecimal currencyWithdrawFee) {
        this.currencyWithdrawFee = currencyWithdrawFee;
    }

    public Integer getCreateBy () {
        return createBy;
    }

    public void setCreateBy (Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy () {
        return updateBy;
    }

    public void setUpdateBy (Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }
}