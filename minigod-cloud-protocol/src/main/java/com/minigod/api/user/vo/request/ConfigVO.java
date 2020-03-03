/**
 * @Title: ConfigVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 拉取参数类
 * 
 * @author 谢尚河
 * @date 2015-7-30 上午11:13:28
 * @version v1.0
 */

public class ConfigVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private Config params;

	public Config getParams() {
		return params;
	}

	public void setParams(Config params) {
		this.params = params;
	}

}
