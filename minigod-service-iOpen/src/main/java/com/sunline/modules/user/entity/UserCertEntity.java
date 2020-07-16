package com.sunline.modules.user.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户登录凭证表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-22 13:26:40
 */
public class UserCertEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//登录方式ID
	private Integer certId;
	//用户ID
	private Integer userId;
	//凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ,5-微信unionid,6-微信齐牛公众号 openid)
	private Integer certType;
	//
	private String certCode;
	//是否已经验证(针对手机号和邮件，0未验证，1已验证)
	private Integer isValid;
	//能否用于登录(1-能，2-不能)
	private Integer isLogin;
	//记录状态
	private Integer isStatus;
	//创建时间
	private Date createTime;
	//最后修改时间(默认1有效，0无效)
	private Date updateTime;
	//乐观锁版本号
	private Integer lockVersion;

	/**
	 * 设置：登录方式ID
	 */
	public void setCertId(Integer certId) {
		this.certId = certId;
	}
	/**
	 * 获取：登录方式ID
	 */
	public Integer getCertId() {
		return certId;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ,5-微信unionid,6-微信齐牛公众号 openid)
	 */
	public void setCertType(Integer certType) {
		this.certType = certType;
	}
	/**
	 * 获取：凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ,5-微信unionid,6-微信齐牛公众号 openid)
	 */
	public Integer getCertType() {
		return certType;
	}
	/**
	 * 设置：
	 */
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
	/**
	 * 获取：
	 */
	public String getCertCode() {
		return certCode;
	}
	/**
	 * 设置：是否已经验证(针对手机号和邮件，0未验证，1已验证)
	 */
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	/**
	 * 获取：是否已经验证(针对手机号和邮件，0未验证，1已验证)
	 */
	public Integer getIsValid() {
		return isValid;
	}
	/**
	 * 设置：能否用于登录(1-能，2-不能)
	 */
	public void setIsLogin(Integer isLogin) {
		this.isLogin = isLogin;
	}
	/**
	 * 获取：能否用于登录(1-能，2-不能)
	 */
	public Integer getIsLogin() {
		return isLogin;
	}
	/**
	 * 设置：记录状态
	 */
	public void setIsStatus(Integer isStatus) {
		this.isStatus = isStatus;
	}
	/**
	 * 获取：记录状态
	 */
	public Integer getIsStatus() {
		return isStatus;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：最后修改时间(默认1有效，0无效)
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：最后修改时间(默认1有效，0无效)
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：乐观锁版本号
	 */
	public void setLockVersion(Integer lockVersion) {
		this.lockVersion = lockVersion;
	}
	/**
	 * 获取：乐观锁版本号
	 */
	public Integer getLockVersion() {
		return lockVersion;
	}
}
