/**
 * @Title: StkFiveBetsVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 个股五档行情参数VO
 *
 * @author 余俊斌
 * @date 2015年3月11日 下午3:02:14
 * @version v1.0
 */

public class StkFiveBetsVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String assetId; // 资产ID

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
}
