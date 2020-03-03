/**
 * @Title: SharePkContentReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-8-3 上午11:26:48
 * @version v1.0
 */
@TransferBean
public class SharePkContentReqVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@TransferID
	private String uId;
	private Integer adId;

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}
}
