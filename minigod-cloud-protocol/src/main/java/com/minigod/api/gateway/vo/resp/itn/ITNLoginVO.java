/**
 * @Title: ITNLoginResp.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description iTN登陆返回vo
 *
 * @author 余俊斌
 * @date 2015年7月2日 上午11:03:24
 * @version v1.0
 */

public class ITNLoginVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// 访问令牌
	private String access_token;
	// 令牌类型 - 目前必为"Bearer"
	private String token_type;
	// 访问令牌生命周期 - 表示访问令牌生命周期的秒数
	private String expires_in;
	// 授权范围 - 用于授权服务器通知App应用颁发令牌的访问范围，多个授权范围可以使用逗号（,）连接
	private String scope;
	// 刷新令牌
	private String refresh_token;
	// 用户标识
	private String auth_id;
	// 资金账号
	private String fund_account;
	// 账户客户号
	private String client_id;
	// 账户客户名字
	private String client_name;

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

	public String getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(String auth_id) {
		this.auth_id = auth_id;
	}

	public String getFund_account() {
		return fund_account;
	}

	public void setFund_account(String fund_account) {
		this.fund_account = fund_account;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

}
