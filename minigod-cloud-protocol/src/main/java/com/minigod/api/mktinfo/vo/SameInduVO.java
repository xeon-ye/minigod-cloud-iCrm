/**
 * @Title: SameInduVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-10-20 下午2:39:22
 * @version v1.0
 */

public class SameInduVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String assetId;
	private Double peOld;
	private Double pb;
	private Double ebitda;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Double getPeOld() {
		return peOld;
	}

	public void setPeOld(Double peOld) {
		this.peOld = peOld;
	}

	public Double getPb() {
		return pb;
	}

	public void setPb(Double pb) {
		this.pb = pb;
	}

	public Double getEbitda() {
		return ebitda;
	}

	public void setEbitda(Double ebitda) {
		this.ebitda = ebitda;
	}

}
