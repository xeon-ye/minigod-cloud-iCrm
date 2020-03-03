package com.minigod.api.session.vo;


import java.io.Serializable;
import java.util.Date;

public class SessionStore implements Serializable {

	private static final long serialVersionUID = 1L;

	private String storeKey;//redis存储的Key
	//token令牌
	private String token;
	//UserSession
	private Integer userId;//用户ID
	private Integer userType = 1;//0游客用户；1认证登录用户；2实盘用户。目前对于非游客都是1
	private Integer deviceId;//设备ID
	private String sessionCode;
	private Date expireTime;//session过期时间
	private String msg;
	private Boolean isStatus = true;//是否有效(1有效,0无效)
	private Date createTime;//创建时间
	private Date updateTime;//更新时间


	private String nickName;//用户昵称
	//UserDevice
	private String deviceName;//iPhone 6 Plus
	private String openCode;//用户设备openCode
	private String deviceCode;//用户设备deviceCode
	private String deviceModel;//OPPO R9s,iPhone, 192.168.1.170

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getSessionCode() {
		return sessionCode;
	}

	public void setSessionCode(String sessionCode) {
		this.sessionCode = sessionCode;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(Boolean status) {
		isStatus = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStoreKey() {
		return storeKey;
	}

	public void setStoreKey(String storeKey) {
		this.storeKey = storeKey;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}
}