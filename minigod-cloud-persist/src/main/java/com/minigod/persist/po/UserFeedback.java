package com.minigod.persist.po;
import com.minigod.persist.tables.TUserFeedback;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户反馈表
 */
@Entity(table=TUserFeedback.class)
public class UserFeedback implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer feedbackId;//用户反馈ID
	private Integer userId;//用户ID
	private String nickName;
	private String contact;
	private String ip;
	private String content;
	private String imageUrl;
	private String source;
	private String replyStatus = "N";//回复状态(N-未回复,Y-已回复)
	private Date replyTime;//最近回复时间
	private String handleStatus = "N";//是否已经处理(N-待处理,Y-已处理)
	private String handleComment;
	private Date handleTime;//最后处理时间
	private Integer handleOpr;//处理人
	private Boolean isStatus = true;//记录状态(默认1有效，0无效)
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

    public Integer getFeedbackId () {
        return feedbackId;
    }

    public void setFeedbackId (Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getNickName () {
        return nickName;
    }

    public void setNickName (String nickName) {
        this.nickName = nickName;
    }

    public String getContact () {
        return contact;
    }

    public void setContact (String contact) {
        this.contact = contact;
    }

    public String getIp () {
        return ip;
    }

    public void setIp (String ip) {
        this.ip = ip;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public String getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSource () {
        return source;
    }

    public void setSource (String source) {
        this.source = source;
    }

    public String getReplyStatus () {
        return replyStatus;
    }

    public void setReplyStatus (String replyStatus) {
        this.replyStatus = replyStatus;
    }

    public Date getReplyTime () {
        return replyTime;
    }

    public void setReplyTime (Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getHandleStatus () {
        return handleStatus;
    }

    public void setHandleStatus (String handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getHandleComment () {
        return handleComment;
    }

    public void setHandleComment (String handleComment) {
        this.handleComment = handleComment;
    }

    public Date getHandleTime () {
        return handleTime;
    }

    public void setHandleTime (Date handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getHandleOpr () {
        return handleOpr;
    }

    public void setHandleOpr (Integer handleOpr) {
        this.handleOpr = handleOpr;
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