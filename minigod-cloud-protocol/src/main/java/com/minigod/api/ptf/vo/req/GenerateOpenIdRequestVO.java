/**
 * @Title: GenerateOpenIdRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 生成minigodOpenID请求VO
 *
 * @author 余俊斌、许德佑
 * @date 2015年3月10日 上午11:04:13
 * @version v1.0
 */

public class GenerateOpenIdRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private GenerateOpenIdVO params;

	public GenerateOpenIdVO getParams() {
		return params;
	}

	public void setParams(GenerateOpenIdVO params) {
		this.params = params;
	}
}
