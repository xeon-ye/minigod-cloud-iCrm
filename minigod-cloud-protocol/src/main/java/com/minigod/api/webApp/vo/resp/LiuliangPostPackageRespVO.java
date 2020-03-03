/**
 * @Title: LiuliangPostPackageRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-19 下午7:41:55
 * @version v1.0
 */

public class LiuliangPostPackageRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String postPackage;
	private String phoneNum;
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
