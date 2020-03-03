package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerUserRelation;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 经理人关系表
 */
@Entity(table=TBrokerUserRelation.class)
public class BrokerUserRelation implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Long brokerId;//经理人ID
	private Long parentId;// 上级经理人ID
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getBrokerId () {
        return brokerId;
    }

    public void setBrokerId (Long brokerId) {
        this.brokerId = brokerId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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