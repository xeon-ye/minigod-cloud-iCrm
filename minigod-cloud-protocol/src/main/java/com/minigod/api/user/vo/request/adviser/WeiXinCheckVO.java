package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: WeiXinCheckVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午4:58:21
 * @version v1.0
 */

public class WeiXinCheckVO extends SNVersion implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;

	private WeiXinCheck params;

	public WeiXinCheck getParams() {
		return params;
	}

	public void setParams(WeiXinCheck params) {
		this.params = params;
	}
}
