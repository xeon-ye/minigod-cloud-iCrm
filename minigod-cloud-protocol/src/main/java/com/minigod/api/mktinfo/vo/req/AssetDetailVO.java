/**
 * @Title: StkQuotVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

import java.util.List;

/**
 * <code>StkQuotVO</code>
 * 
 * @author Jimmy
 * @date 2015-7-1 下午1:46:23
 * @version v1.0
 */
public class AssetDetailVO extends BaseVO {
	

	private static final long serialVersionUID = 1L;

	private List<String> assetIds;

	private String fields;

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}
}
