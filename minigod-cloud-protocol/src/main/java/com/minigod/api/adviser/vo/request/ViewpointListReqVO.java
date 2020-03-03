/**
 * @Title: ViewpointListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-4 上午10:01:07
 * @version v1.0
 */
@TransferBean
public class ViewpointListReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	@TransferID
	private ViewpointListVO params;

	public ViewpointListVO getParams() {
		return params;
	}

	public void setParams(ViewpointListVO params) {
		this.params = params;
	}
}
