/**
 * @Title: CardLuckDrawRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-7-29 下午6:42:23
 * @version v1.0
 */

public class CardLuckDrawRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String giftType;
	private String gift;
	public String getGiftType() {
		return giftType;
	}
	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
}
