package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerAccountRelation;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 经理人客户信息表
 */
@Entity(table=TBrokerAccountRelation.class)
public class BrokerAccountRelation implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Long brokerId;//经理人ID
	private Integer userId;//犇犇号
	private Date regDate;//注册时间
	private Integer accountStatus = 3;//0:已转仓,1:已入金,2:已开户,3:未开户
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getBrokerId () {
        return brokerId;
    }

    public void setBrokerId (Long brokerId) {
        this.brokerId = brokerId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Date getRegDate () {
        return regDate;
    }

    public void setRegDate (Date regDate) {
        this.regDate = regDate;
    }

    public Integer getAccountStatus () {
        return accountStatus;
    }

    public void setAccountStatus (Integer accountStatus) {
        this.accountStatus = accountStatus;
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