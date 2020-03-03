/**
 * @Title: GXLoginRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

/**
 * @description 国信请求类
 * 
 * @author Jimmy
 * @date 2015-3-10 下午2:18:14
 * @version v1.0
 */

public class GXLoginRequest extends GXRequest {
	private static final long serialVersionUID = 1L;
	// 交易密码
	private String trdpwd;
	// 认证类型
	private String authtype;
	// 认证数据
	private String authdata;
	// 加密Key
	private String key;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTrdpwd() {
		return trdpwd;
	}

	public void setTrdpwd(String trdpwd) {
		this.trdpwd = trdpwd;
	}

	public String getAuthtype() {
		return authtype;
	}

	public void setAuthtype(String authtype) {
		this.authtype = authtype;
	}

	public String getAuthdata() {
		return authdata;
	}

	public void setAuthdata(String authdata) {
		this.authdata = authdata;
	}

}
