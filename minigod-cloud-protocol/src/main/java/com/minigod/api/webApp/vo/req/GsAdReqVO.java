package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * <code>GsAdReqVO<code>
 * 
 * @author panlz
 * @since MiniGod v1.0 (2015-09-11)
 * 股神活动请求参数
 * 
 */
@TransferBean
public class GsAdReqVO extends GSbaseReqVO implements Serializable {
	/**  */
	private static final long serialVersionUID = -5232267923290668354L;

	@TransferID
	private String gameEventId ; // 赛事id
	private Integer gameStkId ; //赛事个股id
	@TransferID
	private String gameUserId; // 要查看用户id
	public String getGameEventId() {
		return gameEventId;
	}
	public void setGameEventId(String gameEventId) {
		this.gameEventId = gameEventId;
	}
	public Integer getGameStkId() {
		return gameStkId;
	}
	public void setGameStkId(Integer gameStkId) {
		this.gameStkId = gameStkId;
	}
	public String getGameUserId() {
		return gameUserId;
	}
	public void setGameUserId(String gameUserId) {
		this.gameUserId = gameUserId;
	}
}
