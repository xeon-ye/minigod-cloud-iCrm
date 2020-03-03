/**
 * @Title: AdjustFactorVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * @description 最新的个股复权调整因子包装类
 *
 * @author 余俊斌
 * @date 2015年7月30日 上午11:31:07
 * @version v1.0
 */

public class LatestAdjustFactorVO implements Serializable {

	private static final long serialVersionUID = -7862963180763084513L;

	private String assetId;
	private double adjustFactor;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public double getAdjustFactor() {
		return adjustFactor;
	}

	public void setAdjustFactor(double adjustFactor) {
		this.adjustFactor = adjustFactor;
	}

}
