/**
 * @Title: GSsaveGameInfoRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author MiniGod
 * @date 2015-9-13 下午3:16:52
 * @version v1.0
 */
@TransferBean
public class GSsaveGameStkRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	private String gameEventId;

	public String getGameEventId() {
		return gameEventId;
	}

	public void setGameEventId(String gameEventId) {
		this.gameEventId = gameEventId;
	}
}
