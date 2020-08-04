package com.sunline.modules.account.online.protocol;

import java.io.Serializable;
import java.util.Date;



/**
 * 银行卡四要素验证信息表
 * 
 * @author PENGFENG
 * @email 
 * @date 2018-09-28 14:10:22
 */
public class OpenAccountBankVerityInfoProtocol implements Serializable {
	private static final long serialVersionUID = 1L;

	//小神号
	private Integer userId;
	//用户名称
	private String clientName;
	//手机号码
	private String phoneNumber;
	//身份证号码
	private String idNo;
	//银行卡号
	private String bankCard;
	//状态[0-不通过 1-通过]
	private Integer verifyStatus;
	//验证次数
	private Integer verifyCount;
	//验证时间
	private Date verityTime;

	/**
	 * 设置：小神号
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：小神号
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名称
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * 获取：用户名称
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置：手机号码
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 获取：手机号码
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 设置：身份证号码
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置：银行卡号
	 */
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	/**
	 * 获取：银行卡号
	 */
	public String getBankCard() {
		return bankCard;
	}
	/**
	 * 设置：状态[0-不通过 1-通过]
	 */
	public void setVerifyStatus(Integer verifyStatus) {
		this.verifyStatus = verifyStatus;
	}
	/**
	 * 获取：状态[0-不通过 1-通过]
	 */
	public Integer getVerifyStatus() {
		return verifyStatus;
	}
	/**
	 * 设置：验证次数
	 */
	public void setVerifyCount(Integer verifyCount) {
		this.verifyCount = verifyCount;
	}
	/**
	 * 获取：验证次数
	 */
	public Integer getVerifyCount() {
		return verifyCount;
	}
	/**
	 * 设置：验证时间
	 */
	public void setVerityTime(Date verityTime) {
		this.verityTime = verityTime;
	}
	/**
	 * 获取：验证时间
	 */
	public Date getVerityTime() {
		return verityTime;
	}
}
