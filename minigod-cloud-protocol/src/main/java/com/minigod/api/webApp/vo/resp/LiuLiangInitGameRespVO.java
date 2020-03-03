/**
 * @Title: LiuLiangInitGameRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-16 下午1:42:31
 * @version v1.0
 */

public class LiuLiangInitGameRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String postPackage;
	private String phoneNum;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPostPackage() {
		return postPackage;
	}
	public void setPostPackage(String postPackage) {
		this.postPackage = postPackage;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
