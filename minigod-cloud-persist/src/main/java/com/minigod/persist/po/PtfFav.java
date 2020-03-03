package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfFav;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TPtfFav.class)
public class PtfFav implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfFavId;//组合ID
	private Integer userId;//用户ID
	private Integer ptfId;//组合id
	private Integer displayNo;//自选组合展示序号
	private Boolean owner;//组合创建者
	private Date createTime;//创建时间
	private Date updateTime;//记录更新时间
	private Boolean isStatus;//记录是否有效，1有效，0无效

    public Integer getPtfFavId () {
        return ptfFavId;
    }

    public void setPtfFavId (Integer ptfFavId) {
        this.ptfFavId = ptfFavId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getDisplayNo () {
        return displayNo;
    }

    public void setDisplayNo (Integer displayNo) {
        this.displayNo = displayNo;
    }

    public Boolean getOwner () {
        return owner;
    }

    public void setOwner (Boolean owner) {
        this.owner = owner;
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