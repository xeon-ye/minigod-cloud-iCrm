package com.minigod.persist.po;
import com.minigod.persist.tables.TUserOpenAccountData;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户开户数据
 */
@Entity(table=TUserOpenAccountData.class)
public class UserOpenAccountData implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String clientId;//客户号（交易帐号）
	private Integer userId;//犇犇号
	private Date applyDate;//创建时间
	private Date fillDataDate;
	private Date witnessDate;//见证时间
	private Date openDate;//开户时间
	private Date activeDate;//激活时间
	private String clientSelfSwitch;
	private Boolean isReward = false;
	private Date createTime;
	private Date updateTime;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Date getApplyDate () {
        return applyDate;
    }

    public void setApplyDate (Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getFillDataDate () {
        return fillDataDate;
    }

    public void setFillDataDate (Date fillDataDate) {
        this.fillDataDate = fillDataDate;
    }

    public Date getWitnessDate () {
        return witnessDate;
    }

    public void setWitnessDate (Date witnessDate) {
        this.witnessDate = witnessDate;
    }

    public Date getOpenDate () {
        return openDate;
    }

    public void setOpenDate (Date openDate) {
        this.openDate = openDate;
    }

    public Date getActiveDate () {
        return activeDate;
    }

    public void setActiveDate (Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getClientSelfSwitch () {
        return clientSelfSwitch;
    }

    public void setClientSelfSwitch (String clientSelfSwitch) {
        this.clientSelfSwitch = clientSelfSwitch;
    }

    public Boolean getIsReward () {
        return isReward;
    }

    public void setIsReward (Boolean isReward) {
        this.isReward = isReward;
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