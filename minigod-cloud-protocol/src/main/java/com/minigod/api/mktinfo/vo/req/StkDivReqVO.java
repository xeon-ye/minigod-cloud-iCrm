package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 个股分红融资请求VO
 *
 * @author xiongpan
 * @date 2015-10-8 下午9:20:33
 * @version v1.0
 */
public class StkDivReqVO extends SNVersion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StkDivVO params;
	public StkDivVO getParams() {
		return params;
	}
	public void setParams(StkDivVO params) {
		this.params = params;
	}
}
