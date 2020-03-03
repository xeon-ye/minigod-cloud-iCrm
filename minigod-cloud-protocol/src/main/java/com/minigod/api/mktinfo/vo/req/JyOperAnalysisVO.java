package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;
/**
 * @description 个股经营分析参数VO
 * 
 * @author xiongpan
 * @date 2015-10-9 下午9:21:16
 * @version v1.0
 */
public class JyOperAnalysisVO extends BaseVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assetId;
	private String date;//请求日期
	private Integer count;//请求条数
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

}
