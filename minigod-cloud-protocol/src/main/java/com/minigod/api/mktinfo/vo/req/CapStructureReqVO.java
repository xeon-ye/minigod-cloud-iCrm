package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 股本结构请求VO
 *
 * @author xiongpan
 * @date 2015-9-27 下午9:20:33
 * @version v1.0
 */
public class CapStructureReqVO  extends SNVersion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CapStructureVO params;
	public CapStructureVO getParams() {
		return params;
	}
	public void setParams(CapStructureVO params) {
		this.params = params;
	}

}
