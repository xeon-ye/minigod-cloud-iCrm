package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserViewpointLike;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserViewpointLike.class)
public class AdviserViewpointLike implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer likeId;
	private Long viewpointId;//观点id
	private Integer userId;//点赞用户id
	private Boolean isStatus;//记录状态
	private Date createTime;
	private Date updateTime;

    public Integer getLikeId () {
        return likeId;
    }

    public void setLikeId (Integer likeId) {
        this.likeId = likeId;
    }

    public Long getViewpointId () {
        return viewpointId;
    }

    public void setViewpointId (Long viewpointId) {
        this.viewpointId = viewpointId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
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