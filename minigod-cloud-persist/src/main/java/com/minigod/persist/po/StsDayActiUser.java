package com.minigod.persist.po;
import com.minigod.persist.tables.TStsDayActiUser;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TStsDayActiUser.class)
public class StsDayActiUser implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer dayActiId;//主键
	private Integer userId;//用户id
	private Date createTime;//创建时间，用户使用设备的最新时间

    public Integer getDayActiId () {
        return dayActiId;
    }

    public void setDayActiId (Integer dayActiId) {
        this.dayActiId = dayActiId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }
}