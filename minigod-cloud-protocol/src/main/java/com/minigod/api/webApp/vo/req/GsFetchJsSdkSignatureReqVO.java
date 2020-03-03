/**
 * @Title: GsFetchJsSdkSignature.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-22 下午7:19:09
 * @version v1.0
 */

public class GsFetchJsSdkSignatureReqVO  extends GSbaseReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
