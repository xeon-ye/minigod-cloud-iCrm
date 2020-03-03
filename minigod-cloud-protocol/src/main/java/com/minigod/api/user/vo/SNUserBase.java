package com.minigod.api.user.vo;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.grm.fc.vo.resp.EF07000001VO;
import com.minigod.api.user.vo.response.UpdateAppInfoVO;
import com.minigod.api.user.vo.response.UserBaseInfoVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class SNUserBase implements Serializable {
	private static final long serialVersionUID = 6494832075593991752L;

	@TransferID
	private Long userId; //用户ID
	private String sessionId; //会话标示
	private Integer sessionUserId; //通过会话找到的用户ID
	private String deviceCode; //设备标示，IOS采用自带的设备标示,安卓采用随机生成的设备标示

	@TransferID
	private Long tarUserId;//目标用户ID
	
	@TransferID
	private Long rcmdUserId;//引荐人 ID

	@TransferID
	private Long srcUserId;//源ID
	private Long flag;//显示的字段位移
	private Long localVersion;//本地版本号,此参数传递0表示全量拉取最新版本

	private UpdateAppInfoVO updateInfo; // 在登陆时，需要检测版本信息
	
	@TransferID
	private UserBaseInfoVO userInfo; // 在登陆时，将用户信息输出
	private String reqSrc; // S:主动搜索 N:新的朋友页面点添加 W:微信

	//用户的详细详细
	private Integer gender;//用户性别(1男，0女)
	private String phoneNum;//手机号
	
	@Emoji
	private String profile;//用户简介
	
	@Emoji
	private String signature;//用户签名
	
	private String bigUserIcon;//大图像
	
	@Emoji
	private String nickname;//用户昵称
	private String vTitle;//认证头衔	1.	认证用户返回认证头衔 2.	非认证用户不返回
	private String userIcon;//头像下载地址	 缩略头像下载地址
	private Integer vType;//认证标识	 0为没有认证,1为已认证

	private Integer targetNo;//是否创建过组合
	
	private List<String> imIds; // IM的ID集合
	private EF07000001VO ef07000001VO; //行情信息

	public EF07000001VO getEf07000001VO() {
		return ef07000001VO;
	}

	public void setEf07000001VO(EF07000001VO ef07000001VO) {
		this.ef07000001VO = ef07000001VO;
	}

	public Integer getTargetNo() {
		return targetNo;
	}

	public void setTargetNo(Integer targetNo) {
		this.targetNo = targetNo;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public Long getTarUserId() {
		return tarUserId;
	}

	public void setTarUserId(Long tarUserId) {
		this.tarUserId = tarUserId;
	}

	public Long getRcmdUserId() {
		return rcmdUserId;
	}

	public void setRcmdUserId(Long rcmdUserId) {
		this.rcmdUserId = rcmdUserId;
	}

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public Long getLocalVersion() {
		return localVersion;
	}

	public void setLocalVersion(Long localVersion) {
		this.localVersion = localVersion;
	}

	public UpdateAppInfoVO getUpdateInfo() {
		return updateInfo;
	}

	public void setUpdateInfo(UpdateAppInfoVO updateInfo) {
		this.updateInfo = updateInfo;
	}

	public Long getSrcUserId() {
		return srcUserId;
	}

	public void setSrcUserId(Long srcUserId) {
		this.srcUserId = srcUserId;
	}

	public String getReqSrc() {
		return reqSrc;
	}

	public void setReqSrc(String reqSrc) {
		this.reqSrc = reqSrc;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getBigUserIcon() {
		return bigUserIcon;
	}

	public void setBigUserIcon(String bigUserIcon) {
		this.bigUserIcon = bigUserIcon;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public Integer getvType() {
		return vType;
	}

	public void setvType(Integer vType) {
		this.vType = vType;
	}

	public UserBaseInfoVO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserBaseInfoVO userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getSessionUserId() {
		return sessionUserId;
	}

	public void setSessionUserId(Integer sessionUserId) {
		this.sessionUserId = sessionUserId;
	}

	public List<String> getImIds() {
		return imIds;
	}

	public void setImIds(List<String> imIds) {
		this.imIds = imIds;
	}
}
