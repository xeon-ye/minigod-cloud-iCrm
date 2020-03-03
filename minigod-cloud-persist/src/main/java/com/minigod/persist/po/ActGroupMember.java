package com.minigod.persist.po;
import com.minigod.persist.tables.TActGroupMember;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TActGroupMember.class)
public class ActGroupMember implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer actGroupId;
	private Integer memberUserId;
	private Integer shareUserId;
	private Boolean isLead = true;
	private Date createTime;
	private Boolean isStatus = true;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getActGroupId () {
        return actGroupId;
    }

    public void setActGroupId (Integer actGroupId) {
        this.actGroupId = actGroupId;
    }

    public Integer getMemberUserId () {
        return memberUserId;
    }

    public void setMemberUserId (Integer memberUserId) {
        this.memberUserId = memberUserId;
    }

    public Integer getShareUserId () {
        return shareUserId;
    }

    public void setShareUserId (Integer shareUserId) {
        this.shareUserId = shareUserId;
    }

    public Boolean getIsLead () {
        return isLead;
    }

    public void setIsLead (Boolean isLead) {
        this.isLead = isLead;
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