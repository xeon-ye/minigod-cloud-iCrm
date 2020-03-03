package com.minigod.persist.po;
import com.minigod.persist.tables.TSnActivConfig;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 开户活动配置表
 */
@Entity(table=TSnActivConfig.class)
public class SnActivConfig implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long activeConfigId;
	private String activeName;//活动名称
	private Integer activeType;//1、开户 2、入金 3、转仓
	private Date startTime;//活动开始日期
	private Date endTime;//活动结束日期
	private String remark;//活动备注
	private Integer status = 0;//记录状态 0有效 1失效
	private Date createTime;//创建时间
	private Date updateTime;//更新时间

    public Long getActiveConfigId () {
        return activeConfigId;
    }

    public void setActiveConfigId (Long activeConfigId) {
        this.activeConfigId = activeConfigId;
    }

    public String getActiveName () {
        return activeName;
    }

    public void setActiveName (String activeName) {
        this.activeName = activeName;
    }

    public Integer getActiveType () {
        return activeType;
    }

    public void setActiveType (Integer activeType) {
        this.activeType = activeType;
    }

    public Date getStartTime () {
        return startTime;
    }

    public void setStartTime (Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime () {
        return endTime;
    }

    public void setEndTime (Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
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