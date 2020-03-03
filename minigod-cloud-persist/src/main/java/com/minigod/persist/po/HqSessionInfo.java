package com.minigod.persist.po;
import com.minigod.persist.tables.THqSessionInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=THqSessionInfo.class)
public class HqSessionInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;
	private Long userId;
	private Date upTime;
	private Date downTime;
	private Boolean isOnline = true;
	private String loginFrom;
	private String loginIp;
	private String msg;
	private String sessionCode;

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

    public Date getUpTime () {
        return upTime;
    }

    public void setUpTime (Date upTime) {
        this.upTime = upTime;
    }

    public Date getDownTime () {
        return downTime;
    }

    public void setDownTime (Date downTime) {
        this.downTime = downTime;
    }

    public Boolean getIsOnline () {
        return isOnline;
    }

    public void setIsOnline (Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public String getLoginFrom () {
        return loginFrom;
    }

    public void setLoginFrom (String loginFrom) {
        this.loginFrom = loginFrom;
    }

    public String getLoginIp () {
        return loginIp;
    }

    public void setLoginIp (String loginIp) {
        this.loginIp = loginIp;
    }

    public String getMsg () {
        return msg;
    }

    public void setMsg (String msg) {
        this.msg = msg;
    }

    public String getSessionCode () {
        return sessionCode;
    }

    public void setSessionCode (String sessionCode) {
        this.sessionCode = sessionCode;
    }
}