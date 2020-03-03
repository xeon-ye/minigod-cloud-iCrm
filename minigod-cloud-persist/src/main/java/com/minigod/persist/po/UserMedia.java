package com.minigod.persist.po;
import com.minigod.persist.tables.TUserMedia;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户好友表
 */
@Entity(table=TUserMedia.class)
public class UserMedia implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer friendId;//好友关系ID
	private Integer userId;//用户ID
	private Integer friendUserId;//好友用户ID
	private String commentName;
	private String authFlag;
	private Date friendTime;//成为好友时间
	private Date unfriendTime;//解除好友时间
	private Boolean unfriendType;//解除好友类型(1-主动解除,0-对方解除,默认为空)
	private Long creVersion;//创建版本号
	private Long updVersion;//修改版本号
	private Integer groupId;
	private Boolean isStatus = true;//记录状态(0-无效，1-有效)
	private Boolean isInBlacklist = false;//是否在黑名单上 0-不是 1-是
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间
	private String relationType = "F";//关系类型	C – 我的粉丝,A - 我关注的自媒体
	private Date clientTime;//成为客户时间
	private Date unclientTime;//解除客户时间
	private Boolean unclientType;//解除客户类型(1-主动解除,0-对方解除,默认为空)
	private Boolean isNodisturbing = false;//是否免打扰,1是0否

    public Integer getFriendId () {
        return friendId;
    }

    public void setFriendId (Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendUserId () {
        return friendUserId;
    }

    public void setFriendUserId (Integer friendUserId) {
        this.friendUserId = friendUserId;
    }

    public String getCommentName () {
        return commentName;
    }

    public void setCommentName (String commentName) {
        this.commentName = commentName;
    }

    public String getAuthFlag () {
        return authFlag;
    }

    public void setAuthFlag (String authFlag) {
        this.authFlag = authFlag;
    }

    public Date getFriendTime () {
        return friendTime;
    }

    public void setFriendTime (Date friendTime) {
        this.friendTime = friendTime;
    }

    public Date getUnfriendTime () {
        return unfriendTime;
    }

    public void setUnfriendTime (Date unfriendTime) {
        this.unfriendTime = unfriendTime;
    }

    public Boolean getUnfriendType () {
        return unfriendType;
    }

    public void setUnfriendType (Boolean unfriendType) {
        this.unfriendType = unfriendType;
    }

    public Long getCreVersion () {
        return creVersion;
    }

    public void setCreVersion (Long creVersion) {
        this.creVersion = creVersion;
    }

    public Long getUpdVersion () {
        return updVersion;
    }

    public void setUpdVersion (Long updVersion) {
        this.updVersion = updVersion;
    }

    public Integer getGroupId () {
        return groupId;
    }

    public void setGroupId (Integer groupId) {
        this.groupId = groupId;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Boolean getIsInBlacklist () {
        return isInBlacklist;
    }

    public void setIsInBlacklist (Boolean isInBlacklist) {
        this.isInBlacklist = isInBlacklist;
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

    public String getRelationType () {
        return relationType;
    }

    public void setRelationType (String relationType) {
        this.relationType = relationType;
    }

    public Date getClientTime () {
        return clientTime;
    }

    public void setClientTime (Date clientTime) {
        this.clientTime = clientTime;
    }

    public Date getUnclientTime () {
        return unclientTime;
    }

    public void setUnclientTime (Date unclientTime) {
        this.unclientTime = unclientTime;
    }

    public Boolean getUnclientType () {
        return unclientType;
    }

    public void setUnclientType (Boolean unclientType) {
        this.unclientType = unclientType;
    }

    public Boolean getIsNodisturbing () {
        return isNodisturbing;
    }

    public void setIsNodisturbing (Boolean isNodisturbing) {
        this.isNodisturbing = isNodisturbing;
    }
}