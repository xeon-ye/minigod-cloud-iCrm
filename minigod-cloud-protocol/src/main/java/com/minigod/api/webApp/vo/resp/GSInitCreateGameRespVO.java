/**
 * @Title: InitCreateGameRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-12 上午10:57:06
 * @version v1.0
 */

public class GSInitCreateGameRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userIcon;
	private List<String> tradeDate;
	private Map<String,List<String>> toTradeDate;
	
	public List<String> getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(List<String> tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public Map<String, List<String>> getToTradeDate() {
		return toTradeDate;
	}
	public void setToTradeDate(Map<String, List<String>> toTradeDate) {
		this.toTradeDate = toTradeDate;
	}
}
