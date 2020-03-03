/**
 * @Title: GXUnBindAccRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-5-5 上午10:05:45
 * @version v1.0
 */

public class GXUnBindAccRequest extends GXRequest {
	private static final long serialVersionUID = 7089446158076851131L;
	// 交易密码
	private String trdpwd;
	// 解密key
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
}
