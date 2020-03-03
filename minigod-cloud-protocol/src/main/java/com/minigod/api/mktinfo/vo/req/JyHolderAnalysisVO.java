package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;
/**
 * @description F10股东分析 参数VO
 * 
 * @author xiongpan
 * @date 2015-10-14 下午9:21:16
 * @version v1.0
 */
public class JyHolderAnalysisVO extends BaseVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assetId;
	private String date;
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

}
