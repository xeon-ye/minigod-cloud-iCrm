package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfLike;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 组合点赞表
 */
@Entity(table=TPtfLike.class)
public class PtfLike implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfLikeId;//组合点赞ID
	private Integer ptfId;//组合ID
	private Integer userId;//点赞用户ID
	private Integer ptfCreatorId;//组合创建者ID
	private Date likeDate;//点赞日期
	private Long updVersion;//信息更新时的版本号
	private Boolean isStatus;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getPtfLikeId () {
        return ptfLikeId;
    }

    public void setPtfLikeId (Integer ptfLikeId) {
        this.ptfLikeId = ptfLikeId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getPtfCreatorId () {
        return ptfCreatorId;
    }

    public void setPtfCreatorId (Integer ptfCreatorId) {
        this.ptfCreatorId = ptfCreatorId;
    }

    public Date getLikeDate () {
        return likeDate;
    }

    public void setLikeDate (Date likeDate) {
        this.likeDate = likeDate;
    }

    public Long getUpdVersion () {
        return updVersion;
    }

    public void setUpdVersion (Long updVersion) {
        this.updVersion = updVersion;
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