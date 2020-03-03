/**
 * @Title: IndexOfHeatReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>IndexOfHeatReqVO</code>
 * 
 * @author xiongpan
 * @date 2015-8-18 下午1:45:42
 * @version v1.0
 */
public class IndexOfHeatReqVO extends SNVersion {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndexOfHeatVO getParams() {
		return params;
	}

	public void setParams(IndexOfHeatVO params) {
		this.params = params;
	}

	private IndexOfHeatVO params;

}
