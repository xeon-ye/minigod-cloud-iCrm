package com.minigod.persist.po;
import com.minigod.persist.tables.TUserFriendNew;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 新好友表 用于保存每个用户看到的“新的好友”。
 */
@Entity(table=TUserFriendNew.class)
public class UserFriendNew implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer friendNewId;//新好友ID
	private Integer userId;//用户ID
	private String reqDirection;//请求方向：R 推荐（系统推荐或好友引荐，尚未发起请求）；I 我申请加对方；T 对方申请加我；M 纯消息通知（如某某和某某经我推荐成为了好友）
	private String reqStatus;//请求状态： N-不需审核 W-待审核 Y-审核通过
	private Integer targetUserId;//对方用户ID   如果没有对方id，填0
	private Integer rcmdUserId;//引荐人ID，Recommend（引荐）若无引荐人，则填0
	private String reqMemo;
	private String reqSource;//好友来源 ：用于统计，不做逻辑判断：C-通讯录匹配；S-主动搜索；W-微信邀请；R-朋友引荐；M-二度人脉
	private Boolean isNew;//是否新消息：如果是我发起的请求，则对我而言不是新消息；如果是别人请求加我，或者我的请求被对方通过了等等需要通知到我的情况，则对我而言是新消息
	private Long orderVersion;//排序版本号
	private Long updVersion;//修改版本号   用于客户端拉取更新
	private Integer deviceId;
	private Boolean isStatus = true;//记录状态(0-无效,1-有效)
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间
	private Integer lockVersion;//乐观锁版本号
	private String relationType = "F";//关系类型	C – 我的客户,A - 我的投顾,F – 我的好友

    public Integer getFriendNewId () {
        return friendNewId;
    }

    public void setFriendNewId (Integer friendNewId) {
        this.friendNewId = friendNewId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getReqDirection () {
        return reqDirection;
    }

    public void setReqDirection (String reqDirection) {
        this.reqDirection = reqDirection;
    }

    public String getReqStatus () {
        return reqStatus;
    }

    public void setReqStatus (String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public Integer getTargetUserId () {
        return targetUserId;
    }

    public void setTargetUserId (Integer targetUserId) {
        this.targetUserId = targetUserId;
    }

    public Integer getRcmdUserId () {
        return rcmdUserId;
    }

    public void setRcmdUserId (Integer rcmdUserId) {
        this.rcmdUserId = rcmdUserId;
    }

    public String getReqMemo () {
        return reqMemo;
    }

    public void setReqMemo (String reqMemo) {
        this.reqMemo = reqMemo;
    }

    public String getReqSource () {
        return reqSource;
    }

    public void setReqSource (String reqSource) {
        this.reqSource = reqSource;
    }

    public Boolean getIsNew () {
        return isNew;
    }

    public void setIsNew (Boolean isNew) {
        this.isNew = isNew;
    }

    public Long getOrderVersion () {
        return orderVersion;
    }

    public void setOrderVersion (Long orderVersion) {
        this.orderVersion = orderVersion;
    }

    public Long getUpdVersion () {
        return updVersion;
    }

    public void setUpdVersion (Long updVersion) {
        this.updVersion = updVersion;
    }

    public Integer getDeviceId () {
        return deviceId;
    }

    public void setDeviceId (Integer deviceId) {
        this.deviceId = deviceId;
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

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public String getRelationType () {
        return relationType;
    }

    public void setRelationType (String relationType) {
        this.relationType = relationType;
    }
}