package com.minigod.persist.po;
import com.minigod.persist.tables.TStatChannel;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TStatChannel.class)
public class StatChannel implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer activityId;//活动ID
	private Integer sourceId;//来源ID
	private Integer userId;//用户ID
	private Integer type;//类型编号 1:注册 2：开户 3：入金
	private Date createTime;//创建时间
	private Date operateTime;//操作时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getActivityId () {
        return activityId;
    }

    public void setActivityId (Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getSourceId () {
        return sourceId;
    }

    public void setSourceId (Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperateTime () {
        return operateTime;
    }

    public void setOperateTime (Date operateTime) {
        this.operateTime = operateTime;
    }
}