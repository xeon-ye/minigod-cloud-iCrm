package com.minigod.persist.po;
import com.minigod.persist.tables.TUserFinancCallback;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserFinancCallback.class)
public class UserFinancCallback implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;
	private Integer userId;
	private Integer inviter;
	private Date createTime;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getInviter () {
        return inviter;
    }

    public void setInviter (Integer inviter) {
        this.inviter = inviter;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }
}