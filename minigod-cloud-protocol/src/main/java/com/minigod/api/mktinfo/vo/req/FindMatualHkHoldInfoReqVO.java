package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

import java.util.List;


/**
 * @author jjchou
 * @version v1.0
 * @project: minigod
 * @description:
 * @copyright:2017
 * @company: 
 * 2017年6月19日
 */
public class FindMatualHkHoldInfoReqVO extends BaseVO {// add by jjchou

	private static final long serialVersionUID = 6056417904384758872L;
	private FindMatualHkHoldInfoParamVO params;
	public FindMatualHkHoldInfoParamVO getParams() {
		return params;
	}
	public void setParams(FindMatualHkHoldInfoParamVO params) {
		this.params = params;
	}
}
