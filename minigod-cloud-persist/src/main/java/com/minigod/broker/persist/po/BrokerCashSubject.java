package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerCashSubject;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TBrokerCashSubject.class)
public class BrokerCashSubject implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private String subjectId;//科目编号/科目ID
	private String name;//科目名称
	private String direction;//余额方向
	private Boolean isStatus;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public String getSubjectId () {
        return subjectId;
    }

    public void setSubjectId (String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getDirection () {
        return direction;
    }

    public void setDirection (String direction) {
        this.direction = direction;
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