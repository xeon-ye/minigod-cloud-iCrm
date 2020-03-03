/**
 * @Title: StkFiveBetsRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 获取行业成分股
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午4:28:42
 * @version v1.0
 */
public class StkJfStockRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private StkJfStockParamVO params;

	public StkJfStockParamVO getParams() {
		return params;
	}

	public void setParams(StkJfStockParamVO params) {
		this.params = params;
	}

}
