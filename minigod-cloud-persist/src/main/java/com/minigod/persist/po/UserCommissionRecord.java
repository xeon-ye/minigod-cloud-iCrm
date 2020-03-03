package com.minigod.persist.po;
import com.minigod.persist.tables.TUserCommissionRecord;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserCommissionRecord.class)
public class UserCommissionRecord implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer userId;
	private String fundAccount;
	private String clientId;
	private String exchangeType;
	private String params;
	private Date startDate;
	private Date endDate;
	private Long rewardId;//奖励记录id
	private Date createTime;
	private Date updateTime;
	private Integer status;//0 生效 1 失效

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getFundAccount () {
        return fundAccount;
    }

    public void setFundAccount (String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public String getExchangeType () {
        return exchangeType;
    }

    public void setExchangeType (String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getParams () {
        return params;
    }

    public void setParams (String params) {
        this.params = params;
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

    public Long getRewardId () {
        return rewardId;
    }

    public void setRewardId (Long rewardId) {
        this.rewardId = rewardId;
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

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }
}