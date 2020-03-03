package com.minigod.persist.po;
import com.minigod.persist.tables.THqAccountShareInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=THqAccountShareInfo.class)
public class HqAccountShareInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long accountShareId;
	private Long shareUserId;
	private Long userId;
	private Date createTime;
	private Boolean isStatus = true;//0-无效，1-有效

    public Long getAccountShareId () {
        return accountShareId;
    }

    public void setAccountShareId (Long accountShareId) {
        this.accountShareId = accountShareId;
    }

    public Long getShareUserId () {
        return shareUserId;
    }

    public void setShareUserId (Long shareUserId) {
        this.shareUserId = shareUserId;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }
}