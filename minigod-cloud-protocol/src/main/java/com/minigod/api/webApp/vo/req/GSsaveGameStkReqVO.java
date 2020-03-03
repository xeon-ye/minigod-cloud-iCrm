/**
 * @Title: GSsaveGameStkReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

import com.minigod.api.webApp.vo.req.GSbaseReqVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-14 下午2:57:44
 * @version v1.0
 */
@TransferBean
public class GSsaveGameStkReqVO extends GSbaseReqVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String reqId;
	@TransferID
	private String gameEventId;
	private String stkCode;
	private String reason;
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getGameEventId() {
		return gameEventId;
	}
	public void setGameEventId(String gameEventId) {
		this.gameEventId = gameEventId;
	}
	public String getStkCode() {
		return stkCode;
	}
	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
