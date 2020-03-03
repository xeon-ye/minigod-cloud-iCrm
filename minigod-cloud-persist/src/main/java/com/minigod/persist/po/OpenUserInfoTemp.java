package com.minigod.persist.po;
import com.minigod.persist.tables.TOpenUserInfoTemp;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TOpenUserInfoTemp.class)
public class OpenUserInfoTemp implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;
	private Integer userId;
	private String jsonInfo;
	private Long step;
	private Date createTime;
	private Date updateTime;

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

    public String getJsonInfo () {
        return jsonInfo;
    }

    public void setJsonInfo (String jsonInfo) {
        this.jsonInfo = jsonInfo;
    }

    public Long getStep () {
        return step;
    }

    public void setStep (Long step) {
        this.step = step;
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