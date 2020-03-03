package com.minigod.api.user.vo.response.adviser;

import java.io.Serializable;

/**
 * @Title: RespAdviserOpenDetail.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-9-28 上午8:46:50
 * @version v1.0
 */

public class RespAdviserOpenDetail implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	
	private String nickname ; //开关值
	
	private String userIcon ; //头像绝对地址
	
	private String logoName ; //Logo名称
	
	private Integer uType ; //1：普通用户；2：投顾
	
	private Integer gender ; //用户性别(1男，0女)
	
	private String licCode ; //执业编号
	
	private String adOrgName ; //orgName+AdviserName
	
	private String realName;//真实姓名
	
	private String act ; //开户活动
	
	private String bkge ; //开户佣金
	
	private String[] pvlg ; //开户专享特权
	
	private String instr ; //开户说明
	
	private String openUrl ; //开户url
	
	private String qrcodeUrl ; //二维码url
	
	private String shareUrl ; //分享url
	
	private String androidPkg ; //开户APP andriod包
	
	private String iosPkg ; //开户APP ios包
	

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getLicCode() {
		return licCode;
	}

	public void setLicCode(String licCode) {
		this.licCode = licCode;
	}

	public String getAdOrgName() {
		return adOrgName;
	}

	public void setAdOrgName(String adOrgName) {
		this.adOrgName = adOrgName;
	}
	
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getBkge() {
		return bkge;
	}

	public void setBkge(String bkge) {
		this.bkge = bkge;
	}

	public String[] getPvlg() {
		return pvlg;
	}

	public void setPvlg(String[] pvlg) {
		this.pvlg = pvlg;
	}

	public String getInstr() {
		return instr;
	}

	public void setInstr(String instr) {
		this.instr = instr;
	}

	public String getOpenUrl() {
		return openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}
	
	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}

	public String getAndroidPkg() {
		return androidPkg;
	}

	public void setAndroidPkg(String androidPkg) {
		this.androidPkg = androidPkg;
	}

	public String getIosPkg() {
		return iosPkg;
	}

	public void setIosPkg(String iosPkg) {
		this.iosPkg = iosPkg;
	}
	 
}
