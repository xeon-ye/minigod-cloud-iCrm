/**
 * @Title: StkRealtimeInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 获取个股实时信息请求
 *
 * @author 余俊斌
 * @date 2015年3月24日 下午8:45:11
 * @version v1.0
 */

public class StkRealtimeInfoRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private StkRealtimeInfoParamVO params;

	public StkRealtimeInfoParamVO getParams() {
		return params;
	}

	public void setParams(StkRealtimeInfoParamVO params) {
		this.params = params;
	}
}
