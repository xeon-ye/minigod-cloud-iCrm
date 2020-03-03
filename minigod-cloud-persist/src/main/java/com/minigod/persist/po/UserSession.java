package com.minigod.persist.po;
import com.minigod.persist.tables.TUserSession;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 会话管理表
 */
@Entity(table=TUserSession.class)
public class UserSession implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer sessionId;//会话的ID
	private Integer userId;//用户ID
	private Integer userType = 1;//0游客用户；1认证登录用户；2实盘用户。目前对于非游客都是1
	private Integer deviceId;//设备ID
	private String sessionCode;
	private Date expireTime;//session过期时间
	private String msg;
	private Boolean isStatus = true;//是否有效(1有效,0无效)
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

    public Integer getSessionId () {
        return sessionId;
    }

    public void setSessionId (Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getUserType () {
        return userType;
    }

    public void setUserType (Integer userType) {
        this.userType = userType;
    }

    public Integer getDeviceId () {
        return deviceId;
    }

    public void setDeviceId (Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getSessionCode () {
        return sessionCode;
    }

    public void setSessionCode (String sessionCode) {
        this.sessionCode = sessionCode;
    }

    public Date getExpireTime () {
        return expireTime;
    }

    public void setExpireTime (Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getMsg () {
        return msg;
    }

    public void setMsg (String msg) {
        this.msg = msg;
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