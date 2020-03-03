package com.minigod.persist.po;
import com.minigod.persist.tables.TUserDoubleVerify;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserDoubleVerify.class)
public class UserDoubleVerify implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer udvId;//主键ID
	private Integer userId;//用户ID
	private Date lastDatetime;//勾选过7天的过期时间
	private String equipmentNum;//设备号
	private Boolean udvStatus = false;//状态值，0表示未删除,1表示已删除
	private Boolean selectedType = false;//是否选择7天内不再提醒 0是没选中，1表示选中
	private Date createTime;//创建时间
	private Date updateTime = new Date();//更新时间

    public Integer getUdvId () {
        return udvId;
    }

    public void setUdvId (Integer udvId) {
        this.udvId = udvId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Date getLastDatetime () {
        return lastDatetime;
    }

    public void setLastDatetime (Date lastDatetime) {
        this.lastDatetime = lastDatetime;
    }

    public String getEquipmentNum () {
        return equipmentNum;
    }

    public void setEquipmentNum (String equipmentNum) {
        this.equipmentNum = equipmentNum;
    }

    public Boolean getUdvStatus () {
        return udvStatus;
    }

    public void setUdvStatus (Boolean udvStatus) {
        this.udvStatus = udvStatus;
    }

    public Boolean getSelectedType () {
        return selectedType;
    }

    public void setSelectedType (Boolean selectedType) {
        this.selectedType = selectedType;
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