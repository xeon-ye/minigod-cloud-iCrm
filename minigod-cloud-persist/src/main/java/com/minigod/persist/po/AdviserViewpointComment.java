package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserViewpointComment;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserViewpointComment.class)
public class AdviserViewpointComment implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer commentId;//互动id
	private String clientReqId;//客户端防重发唯一id
	private Long viewpointId;//观点id
	private Integer fromUser;//发表用户id
	private Integer toUser;//回复用户id默认为0
	private String content;//互动内容
	private Boolean isStatus;//记录状态(0-无效，1-有效)
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getCommentId () {
        return commentId;
    }

    public void setCommentId (Integer commentId) {
        this.commentId = commentId;
    }

    public String getClientReqId () {
        return clientReqId;
    }

    public void setClientReqId (String clientReqId) {
        this.clientReqId = clientReqId;
    }

    public Long getViewpointId () {
        return viewpointId;
    }

    public void setViewpointId (Long viewpointId) {
        this.viewpointId = viewpointId;
    }

    public Integer getFromUser () {
        return fromUser;
    }

    public void setFromUser (Integer fromUser) {
        this.fromUser = fromUser;
    }

    public Integer getToUser () {
        return toUser;
    }

    public void setToUser (Integer toUser) {
        this.toUser = toUser;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
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