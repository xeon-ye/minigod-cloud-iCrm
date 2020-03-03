/**
 * @Title: StkQuotReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

public class TrdcaleParamVO extends BaseVO  {
	private static final long serialVersionUID = 1L;

	private String normalDate;
	
	private String regionCode;

	public String getNormalDate() {
		return normalDate;
	}

	public void setNormalDate(String normalDate) {
		this.normalDate = normalDate;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
}
