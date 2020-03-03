package com.minigod.persist.po;
import com.minigod.persist.tables.TUserThirdpartySession;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 第三方会话管理表
 */
@Entity(table=TUserThirdpartySession.class)
public class UserThirdpartySession implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer thirdpartySessionId;//会话的ID
	private Integer sessionType = 1;//会话类型1、代表正常会话，2、代表互踢会话
	private Integer userId;//用户ID
	private Integer userType = 1;//1认证登录用户；2交易用户。
	private String deviceId;//设备ID，目前存放的是移动端app的设备编号，其他应用如pc和浏览器待商榷
	private String sessionCode;//用于标识用户的会话
	private Date expireTime;//session过期时间
	private String msg;
	private Boolean isStatus = true;//session是否有效(1有效,0无效)
	private String source = "SNS";//session来源，默认是社区，还有其他如IWEB/BCAPP
	private String clientIp;//客户端IP，记录客户端请求ip
	private String serverIp;//服务端IP，用于接口发送消息的服务器
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

    public Integer getThirdpartySessionId () {
        return thirdpartySessionId;
    }

    public void setThirdpartySessionId (Integer thirdpartySessionId) {
        this.thirdpartySessionId = thirdpartySessionId;
    }

    public Integer getSessionType () {
        return sessionType;
    }

    public void setSessionType (Integer sessionType) {
        this.sessionType = sessionType;
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

    public String getDeviceId () {
        return deviceId;
    }

    public void setDeviceId (String deviceId) {
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

    public String getSource () {
        return source;
    }

    public void setSource (String source) {
        this.source = source;
    }

    public String getClientIp () {
        return clientIp;
    }

    public void setClientIp (String clientIp) {
        this.clientIp = clientIp;
    }

    public String getServerIp () {
        return serverIp;
    }

    public void setServerIp (String serverIp) {
        this.serverIp = serverIp;
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