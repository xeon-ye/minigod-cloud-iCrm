package com.minigod.api.weixin.vo.resp;

import java.io.Serializable;

public class OAuth2AccessToken implements Serializable {
	private static final long serialVersionUID = 6708273479218585755L;
	private String accessToken;
	private int expiresIn;
    private String refreshToken;
    private String openId;
    private String scope;
    private String unionId;
    public String getAccessToken() {
  		return accessToken;
  	}
  	public void setAccessToken(String accessToken) {
  		this.accessToken = accessToken;
  	}
  	public int getExpiresIn() {
  		return expiresIn;
  	}
  	public void setExpiresIn(int expiresIn) {
  		this.expiresIn = expiresIn;
  	}
  	public String getRefreshToken() {
  		return refreshToken;
  	}
  	public void setRefreshToken(String refreshToken) {
  		this.refreshToken = refreshToken;
  	}
  	public String getOpenId() {
  		return openId;
  	}
  	public void setOpenId(String openId) {
  		this.openId = openId;
  	}
  	public String getScope() {
  		return scope;
  	}
  	public void setScope(String scope) {
  		this.scope = scope;
  	}
  	public String getUnionId() {
  		return unionId;
  	}
  	public void setUnionId(String unionId) {
  		this.unionId = unionId;
  	}
}
