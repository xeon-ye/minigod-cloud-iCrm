/**
 * @Title: RtQuotSubstribeVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
import java.util.List;


/**
 * <code>RtQuotSubstribeVO</code>
 *
 * @author Jimmy
 * @date 2015-7-11 上午10:30:33
 * @version v1.0
 */

public class RtQuotSubscribeVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public List<String> assetIds;

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}
}
