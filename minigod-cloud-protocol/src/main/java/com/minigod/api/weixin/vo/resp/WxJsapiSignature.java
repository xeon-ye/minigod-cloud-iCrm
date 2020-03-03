package com.minigod.api.weixin.vo.resp;

import java.io.Serializable;

/**
 * @author jjchou
 * @version v1.0
 * @project: minigod
 * @description:
 * @copyright:2017
 * @company: 
 * 2017年9月26日
 */
public class WxJsapiSignature implements Serializable {

	private static final long serialVersionUID = 9199454207859993179L;
	private String appId;
    private String nonceStr;
    private String timestamp;
	private String url;
    private String signature;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
    public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
