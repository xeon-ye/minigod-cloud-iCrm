/**
 * @Title: CommitUserPtfReqVO.java
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
 * @date 2015-7-29 下午2:52:23
 * @version v1.0
 */
@TransferBean
public class CommitUserPtfReqVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sessionId;
	private Integer adId;
	@TransferID
	private String ptfId;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	public String getPtfId() {
		return ptfId;
	}
	public void setPtfId(String ptfId) {
		this.ptfId = ptfId;
	}
}
