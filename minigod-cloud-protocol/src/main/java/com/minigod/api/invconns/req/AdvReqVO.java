package com.minigod.api.invconns.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * 
 * 
 * <code>AdvReqVO.java<code>[用户广告登记请求VO]
 * 
 * @author Colin
 * @date 2015-1-8 上午10:59:52
 * 
 */
public class AdvReqVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = -4035968035368002862L;
	private BaseVO params;

	public BaseVO getParams() {
		return params;
	}
	public void setParams(BaseVO params) {
		this.params = params;
	}
}
