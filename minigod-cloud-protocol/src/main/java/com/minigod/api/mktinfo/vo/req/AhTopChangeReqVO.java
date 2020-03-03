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
public class AhTopChangeReqVO extends BaseVO {// add by jjchou

	private static final long serialVersionUID = 6056417904384758872L;
	private AhTopChangeParamVO params;
	public AhTopChangeParamVO getParams() {
		return params;
	}
	public void setParams(AhTopChangeParamVO params) {
		this.params = params;
	}
}
