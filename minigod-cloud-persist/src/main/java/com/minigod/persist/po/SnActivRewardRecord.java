package com.minigod.persist.po;
import com.minigod.persist.tables.TSnActivRewardRecord;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSnActivRewardRecord.class)
public class SnActivRewardRecord implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Long userId = 0l;//用户id
	private String nickname;//用户昵称
	private Long inviter = 0l;//邀请人id
	private Integer activeType = 0;//活动类别(1 开户 2 入金 3 转仓 )
	private Long snActivConfigId = 0l;//活动id
	private String activName = "";//活动名称
	private Long snActivConfigItemId = 0l;//活动奖励明细id
	private String activItemName;//活动配置项名称
	private Long openAccountId = 0l;//开户Id
	private String clientId = "0";//开户交易号
	private Date openAccountDatetime;//开户时间
	private Long depositId = 0l;//入金Id
	private Integer depositMoney = 0;//入金金额
	private Date depositDatetime;//入金时间
	private Long transferStockId = 0l;//转仓id
	private Integer transferMoney = 0;//转仓金额
	private Date transferStockDateTime;//转仓时间
	private Integer rewardMoney = 0;//奖励金额
	private Integer commissionType = 0;//免佣类型
	private Integer commissionDay = 0;//奖励免用天数
	private Integer rewardType = 0;//奖励类型（1 免佣 2 现金 3 行情）
	private Integer rewardStatus = 0;//奖励状态（0 未领取 1已领取 2 申请中 3 退回 4 使用中 5已完成 ）
	private Date confirmEndDatetime;//奖励领取截至时间
	private Date confirmDatetime;//领取奖励时间
	private Long cashDrawId = 0l;//提现Id
	private Date useDatetime;//奖励使用时间
	private Integer STATUS = 0;//记录状态 0有效 1失效
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public String getNickname () {
        return nickname;
    }

    public void setNickname (String nickname) {
        this.nickname = nickname;
    }

    public Long getInviter () {
        return inviter;
    }

    public void setInviter (Long inviter) {
        this.inviter = inviter;
    }

    public Integer getActiveType () {
        return activeType;
    }

    public void setActiveType (Integer activeType) {
        this.activeType = activeType;
    }

    public Long getSnActivConfigId () {
        return snActivConfigId;
    }

    public void setSnActivConfigId (Long snActivConfigId) {
        this.snActivConfigId = snActivConfigId;
    }

    public String getActivName () {
        return activName;
    }

    public void setActivName (String activName) {
        this.activName = activName;
    }

    public Long getSnActivConfigItemId () {
        return snActivConfigItemId;
    }

    public void setSnActivConfigItemId (Long snActivConfigItemId) {
        this.snActivConfigItemId = snActivConfigItemId;
    }

    public String getActivItemName () {
        return activItemName;
    }

    public void setActivItemName (String activItemName) {
        this.activItemName = activItemName;
    }

    public Long getOpenAccountId () {
        return openAccountId;
    }

    public void setOpenAccountId (Long openAccountId) {
        this.openAccountId = openAccountId;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public Date getOpenAccountDatetime () {
        return openAccountDatetime;
    }

    public void setOpenAccountDatetime (Date openAccountDatetime) {
        this.openAccountDatetime = openAccountDatetime;
    }

    public Long getDepositId () {
        return depositId;
    }

    public void setDepositId (Long depositId) {
        this.depositId = depositId;
    }

    public Integer getDepositMoney () {
        return depositMoney;
    }

    public void setDepositMoney (Integer depositMoney) {
        this.depositMoney = depositMoney;
    }

    public Date getDepositDatetime () {
        return depositDatetime;
    }

    public void setDepositDatetime (Date depositDatetime) {
        this.depositDatetime = depositDatetime;
    }

    public Long getTransferStockId () {
        return transferStockId;
    }

    public void setTransferStockId (Long transferStockId) {
        this.transferStockId = transferStockId;
    }

    public Integer getTransferMoney () {
        return transferMoney;
    }

    public void setTransferMoney (Integer transferMoney) {
        this.transferMoney = transferMoney;
    }

    public Date getTransferStockDateTime () {
        return transferStockDateTime;
    }

    public void setTransferStockDateTime (Date transferStockDateTime) {
        this.transferStockDateTime = transferStockDateTime;
    }

    public Integer getRewardMoney () {
        return rewardMoney;
    }

    public void setRewardMoney (Integer rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public Integer getCommissionType () {
        return commissionType;
    }

    public void setCommissionType (Integer commissionType) {
        this.commissionType = commissionType;
    }

    public Integer getCommissionDay () {
        return commissionDay;
    }

    public void setCommissionDay (Integer commissionDay) {
        this.commissionDay = commissionDay;
    }

    public Integer getRewardType () {
        return rewardType;
    }

    public void setRewardType (Integer rewardType) {
        this.rewardType = rewardType;
    }

    public Integer getRewardStatus () {
        return rewardStatus;
    }

    public void setRewardStatus (Integer rewardStatus) {
        this.rewardStatus = rewardStatus;
    }

    public Date getConfirmEndDatetime () {
        return confirmEndDatetime;
    }

    public void setConfirmEndDatetime (Date confirmEndDatetime) {
        this.confirmEndDatetime = confirmEndDatetime;
    }

    public Date getConfirmDatetime () {
        return confirmDatetime;
    }

    public void setConfirmDatetime (Date confirmDatetime) {
        this.confirmDatetime = confirmDatetime;
    }

    public Long getCashDrawId () {
        return cashDrawId;
    }

    public void setCashDrawId (Long cashDrawId) {
        this.cashDrawId = cashDrawId;
    }

    public Date getUseDatetime () {
        return useDatetime;
    }

    public void setUseDatetime (Date useDatetime) {
        this.useDatetime = useDatetime;
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
}