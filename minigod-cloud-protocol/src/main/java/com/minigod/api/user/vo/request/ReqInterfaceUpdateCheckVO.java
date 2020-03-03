/**
 * @Title: ReqInterfaceUpdateCheckVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 接口检测更新请求值对象
 *
 * @author minigod
 * @date 2015-8-11 下午5:55:16
 * @version v1.0
 */

public class ReqInterfaceUpdateCheckVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;

	private InterfaceUpdateCheckVO params;

	public InterfaceUpdateCheckVO getParams() {
		return params;
	}

	public void setParams(InterfaceUpdateCheckVO params) {
		this.params = params;
	}
	
}
