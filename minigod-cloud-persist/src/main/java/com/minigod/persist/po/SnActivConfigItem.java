package com.minigod.persist.po;
import com.minigod.persist.tables.TSnActivConfigItem;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSnActivConfigItem.class)
public class SnActivConfigItem implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String activItemName = "";//活动配置名称
	private Long snActivConfigId;//活动id
	private Integer rewardType;//奖励类型，1免佣 2行情 3现金
	private String ruleInfo;//活动规则
	private Integer STATUS = 0;//记录状态 0有效 1失效
	private Date createTime;//创建时间
	private Date updateTime;//结束时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getActivItemName () {
        return activItemName;
    }

    public void setActivItemName (String activItemName) {
        this.activItemName = activItemName;
    }
    
	public Long getSnActivConfigId() {
		return snActivConfigId;
	}

	public void setSnActivConfigId(Long snActivConfigId) {
		this.snActivConfigId = snActivConfigId;
	}

    public Integer getRewardType () {
        return rewardType;
    }

    public void setRewardType (Integer rewardType) {
        this.rewardType = rewardType;
    }

    public String getRuleInfo () {
        return ruleInfo;
    }

    public void setRuleInfo (String ruleInfo) {
        this.ruleInfo = ruleInfo;
    }

    public Integer getSTATUS () {
        return STATUS;
    }

    public void setSTATUS (Integer STATUS) {
        this.STATUS = STATUS;
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