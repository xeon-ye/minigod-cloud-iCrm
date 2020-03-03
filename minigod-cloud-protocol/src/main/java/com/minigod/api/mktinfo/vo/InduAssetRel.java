/**
 * @Title: InduAssetRel.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.util.Date;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-18 下午5:26:40
 * @version v1.0
 */

public class InduAssetRel extends InduCodeInfoSimpleVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String assetId;// 资产id
	private Date change_date;// 修改时间

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Date getChange_date() {
		return change_date;
	}

	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}

}
