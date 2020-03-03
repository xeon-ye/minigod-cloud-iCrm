package com.minigod.persist.po;
import com.minigod.persist.tables.TSecTransferredStockM;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 转入股票主
 */
@Entity(table=TSecTransferredStockM.class)
public class SecTransferredStockM implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String secName;//劵商名称
	private String accountName;//账户姓名
	private String accountNumber;//账户号码
	private String receiveSec;//接收劵商
	private String receiveAccount;//接收账户
	private String inviter;//邀请人
	private Integer userId;//用户id
	private Integer isShares;//转入股票  1港股 2美股
	private String ccass;//CCASS代码
	private Integer state;//状态 0 已保存 1已提交 2已受理 3 已退回 4已完成
	private Integer isFind = 1;//是否全部加载 0 否 1 是
	private Integer transferState;//转入状态 0未转入 1已转入
	private Date createdTime;//创建时间
	private Date modifyTime;//更新时间
	private String backPerson;//退回操作人
	private String backReason;//退回理由
	private String info;//前端保存参数
	private Long accImgId;//转入凭证图片ID
	private String intoTwo;//前端保存第二部数据
	private Integer isReward = 0;//是否发放补贴
	private String clientId;//交易账号
	private String rolloutContacts;//转出券商的联系人
	private String contactsPhoneNum;//转出券商的联系人电话

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getSecName () {
        return secName;
    }

    public void setSecName (String secName) {
        this.secName = secName;
    }

    public String getAccountName () {
        return accountName;
    }

    public void setAccountName (String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber () {
        return accountNumber;
    }

    public void setAccountNumber (String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getReceiveSec () {
        return receiveSec;
    }

    public void setReceiveSec (String receiveSec) {
        this.receiveSec = receiveSec;
    }

    public String getReceiveAccount () {
        return receiveAccount;
    }

    public void setReceiveAccount (String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public String getInviter () {
        return inviter;
    }

    public void setInviter (String inviter) {
        this.inviter = inviter;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getIsShares () {
        return isShares;
    }

    public void setIsShares (Integer isShares) {
        this.isShares = isShares;
    }

    public String getCcass () {
        return ccass;
    }

    public void setCcass (String ccass) {
        this.ccass = ccass;
    }

    public Integer getState () {
        return state;
    }

    public void setState (Integer state) {
        this.state = state;
    }

    public Integer getIsFind () {
        return isFind;
    }

    public void setIsFind (Integer isFind) {
        this.isFind = isFind;
    }

    public Integer getTransferState () {
        return transferState;
    }

    public void setTransferState (Integer transferState) {
        this.transferState = transferState;
    }

    public Date getCreatedTime () {
        return createdTime;
    }

    public void setCreatedTime (Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime () {
        return modifyTime;
    }

    public void setModifyTime (Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getBackPerson () {
        return backPerson;
    }

    public void setBackPerson (String backPerson) {
        this.backPerson = backPerson;
    }

    public String getBackReason () {
        return backReason;
    }

    public void setBackReason (String backReason) {
        this.backReason = backReason;
    }

    public String getInfo () {
        return info;
    }

    public void setInfo (String info) {
        this.info = info;
    }

    public Long getAccImgId () {
        return accImgId;
    }

    public void setAccImgId (Long accImgId) {
        this.accImgId = accImgId;
    }

    public String getIntoTwo () {
        return intoTwo;
    }

    public void setIntoTwo (String intoTwo) {
        this.intoTwo = intoTwo;
    }

    public Integer getIsReward () {
        return isReward;
    }

    public void setIsReward (Integer isReward) {
        this.isReward = isReward;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public String getRolloutContacts () {
        return rolloutContacts;
    }

    public void setRolloutContacts (String rolloutContacts) {
        this.rolloutContacts = rolloutContacts;
    }

    public String getContactsPhoneNum () {
        return contactsPhoneNum;
    }

    public void setContactsPhoneNum (String contactsPhoneNum) {
        this.contactsPhoneNum = contactsPhoneNum;
    }
}