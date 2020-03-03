package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmServerGroup;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGrmServerGroup.class)
public class GrmServerGroup implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer serverGroupId;
	private String groupCode;
	private String groupName;
	private Date createDate;
	private String groupDesc;

    public Integer getServerGroupId () {
        return serverGroupId;
    }

    public void setServerGroupId (Integer serverGroupId) {
        this.serverGroupId = serverGroupId;
    }

    public String getGroupCode () {
        return groupCode;
    }

    public void setGroupCode (String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName () {
        return groupName;
    }

    public void setGroupName (String groupName) {
        this.groupName = groupName;
    }

    public Date getCreateDate () {
        return createDate;
    }

    public void setCreateDate (Date createDate) {
        this.createDate = createDate;
    }

    public String getGroupDesc () {
        return groupDesc;
    }

    public void setGroupDesc (String groupDesc) {
        this.groupDesc = groupDesc;
    }
}