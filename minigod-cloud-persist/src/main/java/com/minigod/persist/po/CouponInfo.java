package com.minigod.persist.po;
import com.minigod.persist.tables.TCouponInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户卡券
 */
@Entity(table=TCouponInfo.class)
public class CouponInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer couponId;//券ID,主键，自增长
	private String reqNo;//请求发放卡券的ID
	private Integer userId;//用户ID
	private Integer templateId;//卡券模板id
	private String title;//卡券的标题
	private String description;//卡券的描述
	private Integer type;//卡券类型,1:加息券
	private Integer fromUserId;//此卡券来自哪个用户的用户ID
	private Integer activityId;//卡券来源,REG:用户组成OMS:OMS发放
	private String sourceDescription;//来源描述
	private String color;//卡券的颜色
	private String unit;//卡券的单位
	private BigDecimal interestAddRate;//加息利率
	private Integer interestAddDay;//加息天数
	private String couponStatus;//卡券状态N:正常U:已使用E:已过期D:已回收行基本信息
	private Date expireDate;//过期时间
	private Date useTime;//卡券使用的时间
	private String verifyStatus;//审核状态： W - 未审核，P - 通过，N - 不通过
	private Long updVersion;//更新的版本号
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getCouponId () {
        return couponId;
    }

    public void setCouponId (Integer couponId) {
        this.couponId = couponId;
    }

    public String getReqNo () {
        return reqNo;
    }

    public void setReqNo (String reqNo) {
        this.reqNo = reqNo;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getTemplateId () {
        return templateId;
    }

    public void setTemplateId (Integer templateId) {
        this.templateId = templateId;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }

    public Integer getFromUserId () {
        return fromUserId;
    }

    public void setFromUserId (Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getActivityId () {
        return activityId;
    }

    public void setActivityId (Integer activityId) {
        this.activityId = activityId;
    }

    public String getSourceDescription () {
        return sourceDescription;
    }

    public void setSourceDescription (String sourceDescription) {
        this.sourceDescription = sourceDescription;
    }

    public String getColor () {
        return color;
    }

    public void setColor (String color) {
        this.color = color;
    }

    public String getUnit () {
        return unit;
    }

    public void setUnit (String unit) {
        this.unit = unit;
    }

    public BigDecimal getInterestAddRate () {
        return interestAddRate;
    }

    public void setInterestAddRate (BigDecimal interestAddRate) {
        this.interestAddRate = interestAddRate;
    }

    public Integer getInterestAddDay () {
        return interestAddDay;
    }

    public void setInterestAddDay (Integer interestAddDay) {
        this.interestAddDay = interestAddDay;
    }

    public String getCouponStatus () {
        return couponStatus;
    }

    public void setCouponStatus (String couponStatus) {
        this.couponStatus = couponStatus;
    }

    public Date getExpireDate () {
        return expireDate;
    }

    public void setExpireDate (Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getUseTime () {
        return useTime;
    }

    public void setUseTime (Date useTime) {
        this.useTime = useTime;
    }

    public String getVerifyStatus () {
        return verifyStatus;
    }

    public void setVerifyStatus (String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Long getUpdVersion () {
        return updVersion;
    }

    public void setUpdVersion (Long updVersion) {
        this.updVersion = updVersion;
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