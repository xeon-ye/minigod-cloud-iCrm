package com.minigod.persist.po;
import com.minigod.persist.tables.TFprdCurrencyAccelerate;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 理财活期加息状态表
 */
@Entity(table=TFprdCurrencyAccelerate.class)
public class FprdCurrencyAccelerate implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer currencyAccelerateId;//加息id,主键，自增长字段
	private Integer userId;//加息用户ID
	private Date startDate;//加息开始日期
	private Date endDate;//加息结束日期
	private BigDecimal rate;//加息额度
	private Integer couponId;//使用对应的卡券ID
	private String extCouponId;//外部返回的卡券ID
	private String sendStatus;//发送状态	W:等待E:错误U:未知（或异常）S:成功
	private String errorMsg;//错误信息
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getCurrencyAccelerateId () {
        return currencyAccelerateId;
    }

    public void setCurrencyAccelerateId (Integer currencyAccelerateId) {
        this.currencyAccelerateId = currencyAccelerateId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Date getStartDate () {
        return startDate;
    }

    public void setStartDate (Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate () {
        return endDate;
    }

    public void setEndDate (Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getRate () {
        return rate;
    }

    public void setRate (BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getCouponId () {
        return couponId;
    }

    public void setCouponId (Integer couponId) {
        this.couponId = couponId;
    }

    public String getExtCouponId () {
        return extCouponId;
    }

    public void setExtCouponId (String extCouponId) {
        this.extCouponId = extCouponId;
    }

    public String getSendStatus () {
        return sendStatus;
    }

    public void setSendStatus (String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getErrorMsg () {
        return errorMsg;
    }

    public void setErrorMsg (String errorMsg) {
        this.errorMsg = errorMsg;
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