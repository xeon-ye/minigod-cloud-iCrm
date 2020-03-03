/**
 * @Title: UserBindBrokerVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-4-22 下午8:56:02
 * @version v1.0
 */

public class UserBindBrokerVO {
	private Integer brokerId;
	private String brkCustid;
	private Boolean isCurrent;
	private String shortName;
	private String brokerIcon;
	public Integer getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}
	public String getBrkCustid() {
		return brkCustid;
	}
	public void setBrkCustid(String brkCustid) {
		this.brkCustid = brkCustid;
	}
	public Boolean getIsCurrent() {
		return isCurrent;
	}
	public void setIsCurrent(Boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getBrokerIcon() {
		return brokerIcon;
	}
	public void setBrokerIcon(String brokerIcon) {
		this.brokerIcon = brokerIcon;
	}
}
