package com.minigod.persist.po;
import com.minigod.persist.tables.THqUserBasicInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=THqUserBasicInfo.class)
public class HqUserBasicInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long userBasicId;
	private Long packageId;//行情ID
	private Long userId;//用户ID
	private Date createTime;
	private Date updateTime;
	private Boolean isStatus = true;//0-无效，1-有效

    public Long getUserBasicId () {
        return userBasicId;
    }

    public void setUserBasicId (Long userBasicId) {
        this.userBasicId = userBasicId;
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
}