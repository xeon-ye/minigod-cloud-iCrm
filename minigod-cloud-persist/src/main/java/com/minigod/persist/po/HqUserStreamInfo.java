package com.minigod.persist.po;
import com.minigod.persist.tables.THqUserStreamInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=THqUserStreamInfo.class)
public class HqUserStreamInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long userStreamId;
	private Long packageId;//行情ID
	private Long userId;
	private Date startTime;//服务开始时间
	private Date endTime;//服务结束时间
	private Date createTime;
	private Date updateTime;
	private Boolean isStatus = true;//0-无效，1-有效
	private Boolean isExpire = true;//0过期,1正常
	private Boolean isShare = false;//0-个人，1-共享

    public Long getUserStreamId () {
        return userStreamId;
    }

    public void setUserStreamId (Long userStreamId) {
        this.userStreamId = userStreamId;
    }

    public Long getPackageId () {
        return packageId;
    }

    public void setPackageId (Long packageId) {
        this.packageId = packageId;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public Date getStartTime () {
        return startTime;
    }

    public void setStartTime (Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime () {
        return endTime;
    }

    public void setEndTime (Date endTime) {
        this.endTime = endTime;
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

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Boolean getIsExpire () {
        return isExpire;
    }

    public void setIsExpire (Boolean isExpire) {
        this.isExpire = isExpire;
    }

    public Boolean getIsShare () {
        return isShare;
    }

    public void setIsShare (Boolean isShare) {
        this.isShare = isShare;
    }
}