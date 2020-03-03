package com.minigod.persist.po;
import com.minigod.persist.tables.TBrokerOpenAccount;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TBrokerOpenAccount.class)
public class BrokerOpenAccount implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer brokerOpenId;//券商开户ID
	private Integer brokerId;//券商ID
	private Integer userId;//用户ID
	private Integer times;//次数
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getBrokerOpenId () {
        return brokerOpenId;
    }

    public void setBrokerOpenId (Integer brokerOpenId) {
        this.brokerOpenId = brokerOpenId;
    }

    public Integer getBrokerId () {
        return brokerId;
    }

    public void setBrokerId (Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getTimes () {
        return times;
    }

    public void setTimes (Integer times) {
        this.times = times;
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