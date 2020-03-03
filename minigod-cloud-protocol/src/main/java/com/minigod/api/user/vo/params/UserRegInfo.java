/**
 * @Title: UserRegInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.params;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

import java.io.Serializable;
import java.util.List;

/**
 * @description 用户注册对象
 * 
 * @author minigod
 * @date 2015-4-22 下午4:40:20
 * @version v1.0
 */

@TransferBean
public class UserRegInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Cert> cert;

	private String areaCode;//区号

	private String phoneNum;//当前注册用户的手机号

	private String token;

	private String key; //解密码的KEY
	private String pwd;// 用户密码，如果是第三方令牌则填写该值

	@Emoji
	private String nickname;// 用户昵称(允许重复)

	private Integer gender; // 用户性别

	private String userIcon;// 用户图像

	private Integer eventId;// 事件ID

	@Emoji
	private DeviceInfo deviceInfo; // 设备信息

	private String ip;//客户端IP

	private String userSourceChannelId;

	private String invUserId;

	private int isJfGroup;

	private String regSourceType;

	private String regSource;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public int getIsJfGroup() {
		return isJfGroup;
	}

	public void setIsJfGroup(int isJfGroup) {
		this.isJfGroup = isJfGroup;
	}

	public String getUserSourceChannelId() {
		return userSourceChannelId;
	}

	public void setUserSourceChannelId(String userSourceChannelId) {
		this.userSourceChannelId = userSourceChannelId;
	}

	public String getInvUserId() {
		return invUserId;
	}

	public void setInvUserId(String invUserId) {
		this.invUserId = invUserId;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public List<Cert> getCert() {
		return cert;
	}

	public void setCert(List<Cert> cert) {
		this.cert = cert;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRegSourceType() {
		return regSourceType;
	}

	public void setRegSourceType(String regSourceType) {
		this.regSourceType = regSourceType;
	}

	public String getRegSource() {
		return regSource;
	}

	public void setRegSource(String regSource) {
		this.regSource = regSource;
	}

	public static class Cert implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer certType; // 凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ)

		private String certCode; // 凭证内容(手机号、邮箱、QQ号，微博号、微信号、minigod用户名、OpenID等)

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
	}
}
