/**
 * @Title: GameFightSseIndexResp.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author panlz
 * @date 2016-01-18 下午5:17:02
 * @version v1.0
 */

public class GameFightSseIndexResp implements Serializable {
	private static final long serialVersionUID = 1L;

	private double index; // 上证指数
	private String time; // 上证指数对应的时间
	private double yield; // 上证涨幅

	public double getIndex() {
		return index;
	}

	public void setIndex(double index) {
		this.index = index;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getYield() {
		return yield;
	}

	public void setYield(double yield) {
		this.yield = yield;
	}

}
