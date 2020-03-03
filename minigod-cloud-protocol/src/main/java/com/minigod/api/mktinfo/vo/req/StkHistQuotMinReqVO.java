/**
 * @Title: StkHistQuotReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 历史行情请求对象
 *
 * @author 余俊斌
 * @date 2015年7月20日 上午10:06:20
 * @version v1.0
 */

public class StkHistQuotMinReqVO extends SNVersion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8196942307139978758L;
	
	StkHistQuotMinParamVO params;

	public StkHistQuotMinParamVO getParams() {
		return params;
	}

	public void setParams(StkHistQuotMinParamVO params) {
		this.params = params;
	}



}
