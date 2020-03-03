package com.minigod.api.user.vo.request;
import java.io.Serializable;

/**
 * 
 */
public class UserDoubleVerifyVO implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userId;//用户ID
	private String equipmentNum;//设备号
	private String authCode; //验证码
	private String sevenNRemFlag;//7天内不再提醒状态 0表示未勾选,1表示已勾选
	private Integer eventId;//验证码主键
	private String equipmentName; //设备名称
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEquipmentNum() {
		return equipmentNum;
	}
	public void setEquipmentNum(String equipmentNum) {
		this.equipmentNum = equipmentNum;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getSevenNRemFlag() {
		return sevenNRemFlag;
	}
	public void setSevenNRemFlag(String sevenNRemFlag) {
		this.sevenNRemFlag = sevenNRemFlag;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
}