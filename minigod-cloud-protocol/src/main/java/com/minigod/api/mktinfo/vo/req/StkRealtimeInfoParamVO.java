/**
 * @Title: StkRealtimeInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import java.util.List;

import com.minigod.api.vo.BaseVO;

/**
 * @description 获取个股实时信息请求
 *
 * @author 余俊斌
 * @date 2015年3月24日 下午8:45:11
 * @version v1.0
 */

public class StkRealtimeInfoParamVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	// 资产ID
	private List<String> assetIds;

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}

}
