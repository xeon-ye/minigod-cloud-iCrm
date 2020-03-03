/**
 * @Title: StkRelationInduLabResp.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import com.minigod.api.mktinfo.vo.resp.SpLabelBaseInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-20 上午10:41:03
 * @version v1.0
 */

public class StkRelationInduLabRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assetId;// 股票资产ID
	private List<SpLabelBaseInfo> labs;
	private List<SpInduBaseInfo> indus;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public List<SpLabelBaseInfo> getLabs() {
		return labs;
	}

	public void setLabs(List<SpLabelBaseInfo> labs) {
		this.labs = labs;
	}

	public List<SpInduBaseInfo> getIndus() {
		return indus;
	}

	public void setIndus(List<SpInduBaseInfo> indus) {
		this.indus = indus;
	}

}
