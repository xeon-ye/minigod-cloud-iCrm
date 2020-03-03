package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description   F10股东分析 请求VO
 *
 * @author xiongpan
 * @date 2015-10-14 下午9:20:33
 * @version v1.0
 */
public class JyHolderAnalysisReqVO extends SNVersion {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JyHolderAnalysisVO params;
	public JyHolderAnalysisVO getParams() {
		return params;
	}
	public void setParams(JyHolderAnalysisVO params) {
		this.params = params;
	}

	

}
