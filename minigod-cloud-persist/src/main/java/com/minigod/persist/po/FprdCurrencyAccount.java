package com.minigod.persist.po;
import com.minigod.persist.tables.TFprdCurrencyAccount;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 理财活期用户账户余额表
 */
@Entity(table=TFprdCurrencyAccount.class)
public class FprdCurrencyAccount implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userId;//用户配置ID
	private BigDecimal hqBalance;//活期资产
	private BigDecimal hqYesterdayProfit;//昨日收益
	private BigDecimal hqTotalProfit;//累计收益
	private BigDecimal hqTransitCash;//在途资金
	private BigDecimal hqInterestRate;//当前利率
	private BigDecimal totalMoney;
	private BigDecimal canOutMoney;
	private BigDecimal canBuyMoney;//可以购买的金额
	private String couponReqNo;//请求发放卡券的ID
	private Integer grantUserId;//邀请人
	private String grantStatus;//卡券发放状态: W:等待发放 S:发放成功F:发放失败
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getHqBalance () {
        return hqBalance;
    }

    public void setHqBalance (BigDecimal hqBalance) {
        this.hqBalance = hqBalance;
    }

    public BigDecimal getHqYesterdayProfit () {
        return hqYesterdayProfit;
    }

    public void setHqYesterdayProfit (BigDecimal hqYesterdayProfit) {
        this.hqYesterdayProfit = hqYesterdayProfit;
    }

    public BigDecimal getHqTotalProfit () {
        return hqTotalProfit;
    }

    public void setHqTotalProfit (BigDecimal hqTotalProfit) {
        this.hqTotalProfit = hqTotalProfit;
    }

    public BigDecimal getHqTransitCash () {
        return hqTransitCash;
    }

    public void setHqTransitCash (BigDecimal hqTransitCash) {
        this.hqTransitCash = hqTransitCash;
    }

    public BigDecimal getHqInterestRate () {
        return hqInterestRate;
    }

    public void setHqInterestRate (BigDecimal hqInterestRate) {
        this.hqInterestRate = hqInterestRate;
    }

    public BigDecimal getTotalMoney () {
        return totalMoney;
    }

    public void setTotalMoney (BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getCanOutMoney () {
        return canOutMoney;
    }

    public void setCanOutMoney (BigDecimal canOutMoney) {
        this.canOutMoney = canOutMoney;
    }

    public BigDecimal getCanBuyMoney () {
        return canBuyMoney;
    }

    public void setCanBuyMoney (BigDecimal canBuyMoney) {
        this.canBuyMoney = canBuyMoney;
    }

    public String getCouponReqNo () {
        return couponReqNo;
    }

    public void setCouponReqNo (String couponReqNo) {
        this.couponReqNo = couponReqNo;
    }

    public Integer getGrantUserId () {
        return grantUserId;
    }

    public void setGrantUserId (Integer grantUserId) {
        this.grantUserId = grantUserId;
    }

    public String getGrantStatus () {
        return grantStatus;
    }

    public void setGrantStatus (String grantStatus) {
        this.grantStatus = grantStatus;
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

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }
}