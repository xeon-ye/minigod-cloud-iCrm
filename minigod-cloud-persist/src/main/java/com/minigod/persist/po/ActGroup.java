package com.minigod.persist.po;
import com.minigod.persist.tables.TActGroup;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TActGroup.class)
public class ActGroup implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer actGroupId;
	private String actGroupName;
	private Integer userId;
	private Date createTime;
	private Date updateTime;
	private Integer memberNum = 1;
	private Integer lockVersion = 1;
	private Boolean isStatus = true;

    public Integer getActGroupId () {
        return actGroupId;
    }

    public void setActGroupId (Integer actGroupId) {
        this.actGroupId = actGroupId;
    }

    public String getActGroupName () {
        return actGroupName;
    }

    public void setActGroupName (String actGroupName) {
        this.actGroupName = actGroupName;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
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

    public Integer getMemberNum () {
        return memberNum;
    }

    public void setMemberNum (Integer memberNum) {
        this.memberNum = memberNum;
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
}