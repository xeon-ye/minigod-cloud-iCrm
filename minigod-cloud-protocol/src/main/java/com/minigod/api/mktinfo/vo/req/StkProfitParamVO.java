/**
 * @Title: StkNewsDetailParamVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 个股利润指标信息参数
 *
 * @author 余俊斌
 * @date 2015年10月13日 下午8:15:11
 * @version v1.0
 */
public class StkProfitParamVO extends BaseVO {

	private static final long serialVersionUID = 6633452678564707449L;
	
	private String assetId;
	private String date;
	private Integer type;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
