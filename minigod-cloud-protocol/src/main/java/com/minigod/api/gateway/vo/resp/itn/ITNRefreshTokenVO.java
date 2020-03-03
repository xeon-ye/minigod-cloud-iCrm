/**
 * @Title: RefreshTokenVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description 刷新令牌返回
 *
 * @author 余俊斌
 * @date 2015年7月6日 下午12:07:38
 * @version v1.0
 */

public class ITNRefreshTokenVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 访问令牌
	private String access_token;
	// 令牌类型 - 目前必为"Bearer"
	private String token_type;
	// 访问令牌生命周期(秒)
	private String expires_in;
	// 授权范围
	private String scope;
	// 刷新令牌
	private String refresh_token;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

}
