/**
 * @Title: StkRealtimeInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description 个股实时信息，前端App接口使用
 *
 * @author 余俊斌
 * @date 2015年3月24日 下午8:51:47
 * @version v1.0
 */

public class StkRealtimeInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 资产ID
	 */
	private String assetId;
	/**
	 * 现价
	 */
	private String price;
	/**
	 * 涨跌幅
	 */
	private Double changePct;
	/**
	 * 股票状态标示
	 */
	private Integer status;
	/**
	 * 错误码
	 */
	private Integer errCode;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Double getChangePct() {
		return changePct;
	}

	public void setChangePct(Double changePct) {
		this.changePct = changePct;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}
}
