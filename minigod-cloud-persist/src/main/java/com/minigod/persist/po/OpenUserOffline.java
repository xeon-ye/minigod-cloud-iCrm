package com.minigod.persist.po;
import com.minigod.persist.tables.TOpenUserOffline;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TOpenUserOffline.class)
public class OpenUserOffline implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Long userId;//用户ID
	private String info;//线下开户申请信息
	private Integer pushrecved;//回调状态(0:未回调 1:成功 2:失败)
	private Integer state;//申请状态(0:未申请 1:已申请)
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public String getInfo () {
        return info;
    }

    public void setInfo (String info) {
        this.info = info;
    }

    public Integer getPushrecved () {
        return pushrecved;
    }

    public void setPushrecved (Integer pushrecved) {
        this.pushrecved = pushrecved;
    }

    public Integer getState () {
        return state;
    }

    public void setState (Integer state) {
        this.state = state;
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