/**
 * @Title: MarketStatusVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

import com.minigod.api.mktinfo.vo.enums.EMarketStatus;

/**
 * @description 市场状态对象
 *
 * @author 余俊斌
 * @date 2016年1月12日 下午2:22:53
 * @version v1.0
 */

public class MarketStatusVO implements Serializable {

	/**
	 * redis中保存所使用的key
	 */
	public static final String REDIS_KEY = "status";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8765623609905833974L;
	
	/**
	 * 市场状态
	 */
	private EMarketStatus marketStatus;
	/**
	 * 状态更新的时间
	 */
	private String updateTime;

	public EMarketStatus getMarketStatus() {
		return marketStatus;
	}

	public void setMarketStatus(EMarketStatus marketStatus) {
		this.marketStatus = marketStatus;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
