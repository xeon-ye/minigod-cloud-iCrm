package com.minigod.persist.po;
import com.minigod.persist.tables.TFriendGroup;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TFriendGroup.class)
public class FriendGroup implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer groupId;//分组id
	private Integer userId;//用户id，系统设置的公共组用户id为null
	private String groupName;//组名
	private Integer groupNum;//组成员的数量
	private Boolean isEdit = true;//0不可编辑，1可编辑
	private Integer sortId;//排序id
	private Boolean isStatus = true;//状态 0-无效，默认1-有效
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getGroupId () {
        return groupId;
    }

    public void setGroupId (Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getGroupName () {
        return groupName;
    }

    public void setGroupName (String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupNum () {
        return groupNum;
    }

    public void setGroupNum (Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Boolean getIsEdit () {
        return isEdit;
    }

    public void setIsEdit (Boolean isEdit) {
        this.isEdit = isEdit;
    }

    public Integer getSortId () {
        return sortId;
    }

    public void setSortId (Integer sortId) {
        this.sortId = sortId;
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