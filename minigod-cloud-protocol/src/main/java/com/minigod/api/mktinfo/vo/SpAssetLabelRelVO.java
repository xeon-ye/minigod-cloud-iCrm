/**
 * @Title: SpAssetLabelRelVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-18 下午9:24:18
 * @version v1.0
 */

public class SpAssetLabelRelVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer labelId;// 标签ID
	private String assetId;// 资产ID(股票、债券、基金等实际资产的ID，或资产分组的ID。如：600900.SH
							// 它分两部份：股票代码：市场)
	private String labelName;// 数据来源

	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

}
