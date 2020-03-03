package com.minigod.persist.po;
import com.minigod.persist.tables.TRewardRecord;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 红包发送记录表
 */
@Entity(table=TRewardRecord.class)
public class RewardRecord implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer rrId;//主键
	private String batchNo;//批次号
	private String batchDesc;//批次描述
	private String rewardAcountNo;//发款账户号
	private String isUserfulNow;//是否马上可用标志：Y表示马上可用，N 表示要等到下个月后结算才能用户
	private String rewardDesc;//入账描述
	private String sendDesc;//发放推送描述
	private String msgTitle;//服务通知标题
	private String msgContent;//服务通知内容
	private Integer rewardNo;//当次发放序号
	private Integer userId;//用户ID
	private BigDecimal amount;
	private Integer rewardStatus;//状态标识，0未审核，1审核通过，2作废
	private Date createTime;//创建时间
	private Date updateTime;//更新时间

    public Integer getRrId () {
        return rrId;
    }

    public void setRrId (Integer rrId) {
        this.rrId = rrId;
    }

    public String getBatchNo () {
        return batchNo;
    }

    public void setBatchNo (String batchNo) {
        this.batchNo = batchNo;
    }

    public String getBatchDesc () {
        return batchDesc;
    }

    public void setBatchDesc (String batchDesc) {
        this.batchDesc = batchDesc;
    }

    public String getRewardAcountNo () {
        return rewardAcountNo;
    }

    public void setRewardAcountNo (String rewardAcountNo) {
        this.rewardAcountNo = rewardAcountNo;
    }

    public String getIsUserfulNow () {
        return isUserfulNow;
    }

    public void setIsUserfulNow (String isUserfulNow) {
        this.isUserfulNow = isUserfulNow;
    }

    public String getRewardDesc () {
        return rewardDesc;
    }

    public void setRewardDesc (String rewardDesc) {
        this.rewardDesc = rewardDesc;
    }

    public String getSendDesc () {
        return sendDesc;
    }

    public void setSendDesc (String sendDesc) {
        this.sendDesc = sendDesc;
    }

    public String getMsgTitle () {
        return msgTitle;
    }

    public void setMsgTitle (String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent () {
        return msgContent;
    }

    public void setMsgContent (String msgContent) {
        this.msgContent = msgContent;
    }

    public Integer getRewardNo () {
        return rewardNo;
    }

    public void setRewardNo (Integer rewardNo) {
        this.rewardNo = rewardNo;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount () {
        return amount;
    }

    public void setAmount (BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getRewardStatus () {
        return rewardStatus;
    }

    public void setRewardStatus (Integer rewardStatus) {
        this.rewardStatus = rewardStatus;
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