/**
 * @Title: GXBindAccRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

/**
 * @description 绑定请求
 * 
 * @author Jimmy
 * @date 2015-3-12 上午9:25:29
 * @version v1.0
 */

public class GXBindAccRequest extends GXRequest {
	private static final long serialVersionUID = 1L;
	// 交易密码
	private String trdpwd;
	// 是否开通市价委托
	private Integer ktsjwt;
	// 加密Key
	private String key;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getKtsjwt() {
		return ktsjwt;
	}

	public void setKtsjwt(Integer ktsjwt) {
		this.ktsjwt = ktsjwt;
	}

	public String getTrdpwd() {
		return trdpwd;
	}

	public void setTrdpwd(String trdpwd) {
		this.trdpwd = trdpwd;
	}

}
