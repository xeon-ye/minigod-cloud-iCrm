/**
 * @Title: IMCreateGroupReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-15 下午1:00:40
 * @version v1.0
 */
@TransferBean
public class IMCreateGroupReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@TransferID
	private IMCreateGroupVO params;

	public IMCreateGroupVO getParams() {
		return params;
	}

	public void setParams(IMCreateGroupVO params) {
		this.params = params;
	}
}
