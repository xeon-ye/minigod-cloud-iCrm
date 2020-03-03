package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

import com.minigod.api.webApp.vo.req.GameFightbaseReqVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * <code>GameFightGuessActionReqVO<code>
 * 
 * @author panlz 一战到底 猜涨跌 请求类
 * 
 */
@TransferBean
public class GameFightGuessActionReqVO extends GameFightbaseReqVO implements Serializable {
	private static final long serialVersionUID = -5232267923290668354L;
	@TransferID
	private String eventId; // 赛事id
	private String guessValue; // 竞猜值

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getGuessValue() {
		return guessValue;
	}

	public void setGuessValue(String guessValue) {
		this.guessValue = guessValue;
	}

}
