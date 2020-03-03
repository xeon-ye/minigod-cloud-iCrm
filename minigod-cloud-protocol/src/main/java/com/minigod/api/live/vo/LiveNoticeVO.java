package com.minigod.api.live.vo;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.io.Serializable;

/**
 * 
 */
@TransferBean
public class LiveNoticeVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer liveNoticeId;
    @TransferID
    private Long userId;
    private String ownerId;
    private String ownerName;
    private String groupId;
	private String title;
	private String content;
	private String startTime;
	private Integer status;//1:正常；2：取消; 3:改期
	private String createTime;
	private String updateTime;
	private String reason;//取消或者改期原因
    private String userIcon;

    public Integer getLiveNoticeId () {
        return liveNoticeId;
    }

    public void setLiveNoticeId (Integer liveNoticeId) {
        this.liveNoticeId = liveNoticeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public String getStartTime () {
        return startTime;
    }

    public void setStartTime (String startTime) {
        this.startTime = startTime;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }

    public String getCreateTime () {
        return createTime;
    }

    public void setCreateTime (String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (String updateTime) {
        this.updateTime = updateTime;
    }

    public String getReason () {
        return reason;
    }

    public void setReason (String reason) {
        this.reason = reason;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }
}