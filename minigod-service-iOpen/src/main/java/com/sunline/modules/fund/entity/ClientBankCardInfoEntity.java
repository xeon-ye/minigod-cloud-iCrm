package com.sunline.modules.fund.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 银行卡管理记录表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */
public class ClientBankCardInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//交易帐号
	private String clientId;
	//资金帐号
	private String fundAccount;
	//银行卡类型[0-香港银行卡 1-大陆银行卡]
	private Integer bankType;
	//银行名称
	private String bankName;
	//银行账号
	private String bankNo;
	//银行代码
	private String bankCode;
	//银行账户名
	private String bankAccount;
	//登记时间
	private Date registerTime;
	//解登时间
	private Date untiedTime;
	//当前状态[0-无效 1-有效]
	private Integer status;
	//创建人
	private String createUser;
	//更新人
	private String updateUser;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//小神号
	private String userId;
	//客户姓名
	private String clientName;
	//手机号码
	private String phoneNumber;
	//开户途径
	private String openAccountType;

	/**
	 * 设置：自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：交易帐号
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * 获取：交易帐号
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * 设置：资金帐号
	 */
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
	/**
	 * 获取：资金帐号
	 */
	public String getFundAccount() {
		return fundAccount;
	}
	/**
	 * 设置：银行卡类型[0-香港银行卡 1-大陆银行卡]
	 */
	public Integer getBankType() {
		return bankType;
	}
	/**
	 * 设置：银行卡类型[0-香港银行卡 1-大陆银行卡]
	 */
	public void setBankType(Integer bankType) {
		this.bankType = bankType;
	}
	/**
	 * 设置：银行名称
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * 获取：银行名称
	 */
	public String getBankName() {
		return bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * 设置：银行账号
	 */
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	/**
	 * 获取：银行账号
	 */
	public String getBankNo() {
		return bankNo;
	}
	/**
	 * 设置：银行账户名
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * 获取：银行账户名
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 设置：登记时间
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getRegisterTime() {
		return registerTime;
	}
	/**
	 * 设置：解登时间
	 */
	public void setUntiedTime(Date untiedTime) {
		this.untiedTime = untiedTime;
	}
	/**
	 * 获取：解登时间
	 */
	public Date getUntiedTime() {
		return untiedTime;
	}
	/**
	 * 设置：当前状态[0-无效 1-有效]
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：当前状态[0-无效 1-有效]
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：更新人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：更新人
	 */
	public String getUpdateUser() {
		return updateUser;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOpenAccountType() {
		return openAccountType;
	}

	public void setOpenAccountType(String openAccountType) {
		this.openAccountType = openAccountType;
	}
}
