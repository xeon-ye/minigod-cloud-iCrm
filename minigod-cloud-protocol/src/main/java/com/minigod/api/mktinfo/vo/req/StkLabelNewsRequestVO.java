/**
 * @Title: StkFiveBetsRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 获取概念事件
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午5:01:43
 * @version v1.0
 */
public class StkLabelNewsRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private StkLabelNewsParamVO params;

	public StkLabelNewsParamVO getParams() {
		return params;
	}

	public void setParams(StkLabelNewsParamVO params) {
		this.params = params;
	}

}
