/**
 * @Title: GXStkAccRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

import com.minigod.api.gateway.vo.req.guoxin.GXRequest;

/**
 * @description 股东账号查询
 * 
 * @author Jimmy
 * @date 2015-3-12 下午12:48:33
 * @version v1.0
 */

public class GXStkAccRequest extends GXRequest {
	private static final long serialVersionUID = 1L;
	// 交易市场
	private String market;
	// 查询方向
	private String qryflag;

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getQryflag() {
		return qryflag;
	}

	public void setQryflag(String qryflag) {
		this.qryflag = qryflag;
	}

}
