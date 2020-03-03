/**
 * @Title: GXHisOrdRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

import com.minigod.api.gateway.vo.req.guoxin.GXTodayOrdRequest;

/**
 * @description 历史委托
 * 
 * @author Jimmy
 * @date 2015-3-12 下午1:34:57
 * @version v1.0
 */

public class GXHisOrdRequest extends GXTodayOrdRequest {
	private static final long serialVersionUID = 1L;
	// 起始时间
	private String strdate;
	// 结束时间
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
