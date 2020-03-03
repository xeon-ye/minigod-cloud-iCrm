package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

import java.util.List;

/**
 * 
 * <code>StkSumVO<code>[个股概要信息查询类]
 *
 * @author Colin
 * @since MiniGod v0.0.1(2014-11-20)
 *
 */
public class AssetTopVO extends BaseVO {
	/**  */
	private static final long serialVersionUID = 6162966329716046378L;

	private String market; //市场

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}
}
