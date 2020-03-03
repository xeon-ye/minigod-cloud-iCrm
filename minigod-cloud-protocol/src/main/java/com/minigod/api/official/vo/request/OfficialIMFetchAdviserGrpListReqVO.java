/**
 * @Title: IMFetchAdviserGrpListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.official.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-11-4 下午7:55:33
 * @version v1.0
 */
@TransferBean
public class OfficialIMFetchAdviserGrpListReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@TransferID
	private OfficialIMFetchAdviserGrpListVO params;

	public OfficialIMFetchAdviserGrpListVO getParams() {
		return params;
	}

	public void setParams(OfficialIMFetchAdviserGrpListVO params) {
		this.params = params;
	}
	
}
