package com.minigod.persist.po;
import com.minigod.persist.tables.TPlatRobotLog;
import com.minigod.db4j.annotation.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 股小量请求历史表
 */
@Entity(table=TPlatRobotLog.class)
public class PlatRobotLog implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String msgid;//消息流水号
	private String ask = "0";//互动内容
	private String userId;//用户ID
	private String userName = "1";//用户昵称
	private String type;//类型
	private Date createTime;//创建时间

	public PlatRobotLog() {
		
	}

	public PlatRobotLog(String msgid, String ask, String userId,
			String userName, String type, Date createTime) {
		super();
		this.msgid = msgid;
		this.ask = ask;
		this.userId = userId;
		this.userName = userName;
		this.type = type;
		this.createTime = createTime;
	}

	public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getMsgid () {
        return msgid;
    }

    public void setMsgid (String msgid) {
        this.msgid = msgid;
    }

    public String getAsk () {
        return ask;
    }

    public void setAsk (String ask) {
        this.ask = ask;
    }

    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }
}