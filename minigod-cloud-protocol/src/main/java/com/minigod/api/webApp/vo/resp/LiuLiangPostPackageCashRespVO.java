/**
 * @Title: LiuLiangPostPackageCashRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-24 下午2:59:10
 * @version v1.0
 */

public class LiuLiangPostPackageCashRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String phoneNum;
	private String date;
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
