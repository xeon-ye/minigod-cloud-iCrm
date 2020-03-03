package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @Title: updateWeiXinBind.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午5:05:47
 * @version v1.0
 */

public class UpdateWeiXinBind extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;

	private String token;//微信的token
	private String openCode;//微信的code

	private String key; //解密码的KEY
	private String pwd;// 用户密码，如果是第三方令牌则填写该值

	private Integer handleType;//1：微信首次绑定 2：更换微信绑定 3：解绑微信信息

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getHandleType() {
		return handleType;
	}

	public void setHandleType(Integer handleType) {
		this.handleType = handleType;
	}
}
