/**
 * @Title: SharePtfReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-12-9 下午5:10:53
 * @version v1.0
 */

public class SharePtfReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ptfId;

	public String getPtfId() {
		return ptfId;
	}

	public void setPtfId(String ptfId) {
		this.ptfId = ptfId;
	}

}
