/**
 * @Title: GXHisCmfRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

/**
 * @description 历史成交
 * 
 * @author Jimmy
 * @date 2015-3-12 下午1:45:40
 * @version v1.0
 */

public class GXHisCmfRequest extends GXTodayCmfRequest {
	private static final long serialVersionUID = 1L;
	// 起始日期
	private String strdate;
	// 终止日期
	private String enddate;

	public String getStrdate() {
		return strdate;
	}

	public void setStrdate(String strdate) {
		this.strdate = strdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

}
