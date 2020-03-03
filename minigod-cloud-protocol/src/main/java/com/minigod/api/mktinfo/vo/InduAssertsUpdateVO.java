/**
 * @Title: SpLabelChgExt.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.mktinfo.vo.resp.StkBaseInfo;


/**
 * @author jjchou
 * @version v1.0
 * @project: minigod
 * @description:
 * @copyright:2017
 * @company: 
 * 2017年6月19日
 */
public class InduAssertsUpdateVO implements Serializable {// add by jjchou

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String induCode;// 行业编码
	private String induName;// 行业名称
	private List<String> assetIds;// 成分股列表

	public String getInduCode() {
		return induCode;
	}

	public void setInduCode(String induCode) {
		this.induCode = induCode;
	}

	public String getInduName() {
		return induName;
	}

	public void setInduName(String induName) {
		this.induName = induName;
	}

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}

}
