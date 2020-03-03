/**
 * @Title: HeatIndexVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-15 下午2:11:48
 * @version v1.0
 */

public class HeatIndexSumVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String assetId;
	private Double sumOutHeatIndex;
	private Integer countOutHeatIndex;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Double getSumOutHeatIndex() {
		return sumOutHeatIndex;
	}

	public void setSumOutHeatIndex(Double sumOutHeatIndex) {
		this.sumOutHeatIndex = sumOutHeatIndex;
	}

	public Integer getCountOutHeatIndex() {
		return countOutHeatIndex;
	}

	public void setCountOutHeatIndex(Integer countOutHeatIndex) {
		this.countOutHeatIndex = countOutHeatIndex;
	}

}
