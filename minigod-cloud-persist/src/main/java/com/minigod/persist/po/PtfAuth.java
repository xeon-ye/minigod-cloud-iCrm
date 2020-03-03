package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfAuth;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TPtfAuth.class)
public class PtfAuth implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfAuthId;//组合权限id
	private Integer ptfId;//组合id
	private Integer authUserId;//组合可见权限用户id
	private Boolean isStatus;//记录是否有效，1有效0无效
	private Date createTime;//记录创建时间
	private Date updateTime;//记录更新时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getPtfAuthId () {
        return ptfAuthId;
    }

    public void setPtfAuthId (Integer ptfAuthId) {
        this.ptfAuthId = ptfAuthId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getAuthUserId () {
        return authUserId;
    }

    public void setAuthUserId (Integer authUserId) {
        this.authUserId = authUserId;
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
}