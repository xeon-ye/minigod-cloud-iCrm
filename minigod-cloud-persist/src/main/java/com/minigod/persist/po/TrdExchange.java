package com.minigod.persist.po;
import com.minigod.persist.tables.TTrdExchange;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TTrdExchange.class)
public class TrdExchange implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer userId = 0;//用户id
	private String realName = "";//用户真实姓名
	private String phoneNo;//手机号
	private String clientId = "0";//交易号
	private String fundAccount = "0";//资金帐号
	private Integer exchangeType;//兑换类型(1-港币兑换美元 2-美元兑换港币)
	private Integer exchangeAmount = 0;//兑换金额
	private Integer exchangeStatus = 0;//兑换状态（1-已提交 2-已受理 3-已退回 4-已完成）
	private String remark = "0";//退回原因
	private Integer STATUS = 0;//记录状态 0有效 1失效
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion = 0;//乐观锁版本号
	private String assetId;//资产ID

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getRealName () {
        return realName;
    }

    public void setRealName (String realName) {
        this.realName = realName;
    }

    public String getPhoneNo () {
        return phoneNo;
    }

    public void setPhoneNo (String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public String getFundAccount () {
        return fundAccount;
    }

    public void setFundAccount (String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public Integer getExchangeType () {
        return exchangeType;
    }

    public void setExchangeType (Integer exchangeType) {
        this.exchangeType = exchangeType;
    }

    public Integer getExchangeAmount () {
        return exchangeAmount;
    }

    public void setExchangeAmount (Integer exchangeAmount) {
        this.exchangeAmount = exchangeAmount;
    }

    public Integer getExchangeStatus () {
        return exchangeStatus;
    }

    public void setExchangeStatus (Integer exchangeStatus) {
        this.exchangeStatus = exchangeStatus;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }

    public Integer getSTATUS () {
        return STATUS;
    }

    public void setSTATUS (Integer STATUS) {
        this.STATUS = STATUS;
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

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }
}