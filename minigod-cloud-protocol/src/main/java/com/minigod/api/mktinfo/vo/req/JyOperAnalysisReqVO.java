package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;
/**
 * @description  个股经营分析请求VO
 *
 * @author xiongpan
 * @date 2015-10-9 下午9:20:33
 * @version v1.0
 */
public class JyOperAnalysisReqVO extends SNVersion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JyOperAnalysisVO params;

	public JyOperAnalysisVO getParams() {
		return params;
	}

	public void setParams(JyOperAnalysisVO params) {
		this.params = params;
	}
	
	

}
