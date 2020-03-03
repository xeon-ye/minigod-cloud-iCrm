package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserQuestion;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserQuestion.class)
public class AdviserQuestion implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer questionId;//问题ID
	private Integer userId;//提问用户id
	private Integer assignUserId;//指派回答用户id，指定专人回答，记录指定人用户id，属于广场问答分发的非指派此字段为空
	private Integer userIdType;//用户类型 1一起牛用户 2微信用户
	private Integer questionSource;//问题来源  1广场问答(后续微信问答也属于广场问答)，2专属投顾问答
	private Integer questionType;//问题类型 1股票，2大盘，3其它
	private String assetId;//资产id
	private BigDecimal costPrice;//成本价
	private String position;//仓位
	private String content;//提问内容
	private Integer rushStatus = 0;//抢答状态，默认0待抢答 ，  1已抢答，因未抢答或抢答且超时再次推送给下一批投顾将此状态重置成0
	private Date timeoutTime;//超时时间 未抢答或已抢答状态下超时则触发推送给下一批投顾，另不满意时用户再次问其他投顾或投顾放弃回答也会触发推送给下一批投顾,触发时再次设置下一个超时时间 永不过期时间设置9999-12-31 12:00:00
	private Integer matchNum = 1;//匹配推送次数 默认1 每匹配推送给下一批投顾 +1
	private Integer unsatisfyNum;//不满意推送次数 点不满意发送给其他投顾 +1
	private Integer bestAnswerId;
	private Integer latestAnswerId;//最新的答案id
	private Date fristDistributeTime;//第一次分发时间
	private Boolean isLock = false;//投顾举报锁住 0正常  1锁住 
	private Integer lockVersion = 1;//乐观锁
	private Boolean isStatus = true;//记录状态 1-有效，0-无效
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getQuestionId () {
        return questionId;
    }

    public void setQuestionId (Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getAssignUserId () {
        return assignUserId;
    }

    public void setAssignUserId (Integer assignUserId) {
        this.assignUserId = assignUserId;
    }

    public Integer getUserIdType () {
        return userIdType;
    }

    public void setUserIdType (Integer userIdType) {
        this.userIdType = userIdType;
    }

    public Integer getQuestionSource () {
        return questionSource;
    }

    public void setQuestionSource (Integer questionSource) {
        this.questionSource = questionSource;
    }

    public Integer getQuestionType () {
        return questionType;
    }

    public void setQuestionType (Integer questionType) {
        this.questionType = questionType;
    }

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public BigDecimal getCostPrice () {
        return costPrice;
    }

    public void setCostPrice (BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public String getPosition () {
        return position;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Integer getRushStatus () {
        return rushStatus;
    }

    public void setRushStatus (Integer rushStatus) {
        this.rushStatus = rushStatus;
    }

    public Date getTimeoutTime () {
        return timeoutTime;
    }

    public void setTimeoutTime (Date timeoutTime) {
        this.timeoutTime = timeoutTime;
    }

    public Integer getMatchNum () {
        return matchNum;
    }

    public void setMatchNum (Integer matchNum) {
        this.matchNum = matchNum;
    }

    public Integer getUnsatisfyNum () {
        return unsatisfyNum;
    }

    public void setUnsatisfyNum (Integer unsatisfyNum) {
        this.unsatisfyNum = unsatisfyNum;
    }

    public Integer getBestAnswerId () {
        return bestAnswerId;
    }

    public void setBestAnswerId (Integer bestAnswerId) {
        this.bestAnswerId = bestAnswerId;
    }

    public Integer getLatestAnswerId () {
        return latestAnswerId;
    }

    public void setLatestAnswerId (Integer latestAnswerId) {
        this.latestAnswerId = latestAnswerId;
    }

    public Date getFristDistributeTime () {
        return fristDistributeTime;
    }

    public void setFristDistributeTime (Date fristDistributeTime) {
        this.fristDistributeTime = fristDistributeTime;
    }

    public Boolean getIsLock () {
        return isLock;
    }

    public void setIsLock (Boolean isLock) {
        this.isLock = isLock;
    }

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
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