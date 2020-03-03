/**
 * @Title: GetOptionStockVo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import java.util.List;

import com.minigod.api.vo.BaseVO;

/**
 * <code>StkQuotVO</code>
 * 
 * @author xiongpan
 * @date 2015-7-1 下午1:46:23
 * @version v1.0
 */
public class OptionStockVO extends BaseVO {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> assetIds;

	private String fields;
	
	private String handleType;//xiongpan 自选股处理类别（添加或删除）1-添加 0-删除
	
	private String istotalUpdate;//xiongpan 自选股处理类别 是否全盘更新   1-代表全盘更新   0-否

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

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}
	public String getIstotalUpdate() {
		return istotalUpdate;
	}

	public void setIstotalUpdate(String istotalUpdate) {
		this.istotalUpdate = istotalUpdate;
	}
}
