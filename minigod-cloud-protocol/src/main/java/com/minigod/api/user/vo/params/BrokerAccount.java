package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class BrokerAccount extends SNUserBase {
	private static final long serialVersionUID = 8528665242167786357L;
	private Integer brokerId;//券商ID
	private String brokerUser;//券商的登录名AES加密串
	private String brokerPassword;//券商登录密码的AES加密串

	public Integer getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerUser() {
		return brokerUser;
	}

	public void setBrokerUser(String brokerUser) {
		this.brokerUser = brokerUser;
	}

	public String getBrokerPassword() {
		return brokerPassword;
	}

	public void setBrokerPassword(String brokerPassword) {
		this.brokerPassword = brokerPassword;
	}
}
