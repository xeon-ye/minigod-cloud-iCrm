/**
 * @Title: StkKDJParamVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.mktinfo.vo.enums.EHistQuotType;
import com.minigod.api.mktinfo.vo.enums.EQuotAdjustType;
import com.minigod.api.vo.BaseVO;

/**
 * @description 查询技术指标请求参数
 *
 * @author 余俊斌
 * @date 2015年8月17日 下午2:47:28
 * @version v1.0
 */

public class StkTechnicalIndicatorParamVO extends BaseVO {

	private static final long serialVersionUID = 4204051453577630818L;
	
	private String assetId;
	private EHistQuotType type;
	private Integer count;
	private Long ts;
	private EQuotAdjustType adjust;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public EHistQuotType getType() {
		return type;
	}

	public void setType(EHistQuotType type) {
		this.type = type;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}

	public EQuotAdjustType getAdjust() {
		return adjust;
	}

	public void setAdjust(EQuotAdjustType adjust) {
		this.adjust = adjust;
	}

}
