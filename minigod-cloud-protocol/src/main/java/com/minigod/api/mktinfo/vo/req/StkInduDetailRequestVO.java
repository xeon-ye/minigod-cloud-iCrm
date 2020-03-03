/**
 * @Title: StkFiveBetsRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 获取行业详情
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午2:48:21
 * @version v1.0
 */
public class StkInduDetailRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private StkInduDetailParamVO params;

	public StkInduDetailParamVO getParams() {
		return params;
	}

	public void setParams(StkInduDetailParamVO params) {
		this.params = params;
	}

}
