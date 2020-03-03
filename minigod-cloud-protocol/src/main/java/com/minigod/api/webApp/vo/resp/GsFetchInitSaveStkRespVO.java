/**
 * @Title: GsFetchInitSaveStkReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-22 下午2:34:37
 * @version v1.0
 */

public class GsFetchInitSaveStkRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String userIcon;
	private String gameEventName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public String getGameEventName() {
		return gameEventName;
	}
	public void setGameEventName(String gameEventName) {
		this.gameEventName = gameEventName;
	}

}
