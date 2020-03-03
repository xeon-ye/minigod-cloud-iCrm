package com.minigod.api.user.vo.response.adviser;

import java.io.Serializable;

/**
 * @Title: ResqWinxinBindStatus.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午5:57:44
 * @version v1.0
 */

public class ResqWinxinBindStatus implements Serializable {

	private static final long serialVersionUID = -4218378173953198154L;

	private Integer isStatus;//1：存在微信登录凭证，并且当前微信与登录凭证微信一样；2：不存在微信登录凭证；3：当前微信与登录凭证微信不一样；

	public Integer getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(Integer isStatus) {
		this.isStatus = isStatus;
	}
}
