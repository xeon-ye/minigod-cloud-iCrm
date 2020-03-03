package com.minigod.api.user.vo.params;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/** 
 * 注册、登录对象 
 */

@TransferBean
public class ReqUserInfo implements Serializable {

	private static final long serialVersionUID = -1163833696907526399L;
	private String appid;
	private Integer certType;//凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ)
	private String certCode;//凭证内容(手机号、邮箱、QQ号，微博号、微信号、minigod用户名、OpenID等)

	private Integer eventId;//事件ID

	private String key; //解密码的KEY
	private String pwd;//用户密码，如果是第三方令牌则填写该值

	private String token; // 微信token

	@Emoji
	private String nickname;//用户昵称(允许重复)
	private Integer gender;//用户性别(1男，0女)
	private String userIcon;//用户图像
	private String regIp;

	@Emoji
	private DeviceInfo deviceInfo; //设备信息

	private String channel; // 渠道标示，应用是从哪个

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public Integer getCertType() {
		return certType;
	}

	public void setCertType(Integer certType) {
		this.certType = certType;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
