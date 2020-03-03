package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: FetchInfoRequestVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-11 上午9:52:15
 * @version v1.0
 */
@TransferBean
public class FetchInfoRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private FetchInfoVO params;

	public FetchInfoVO getParams() {
		return params;
	}

	public void setParams(FetchInfoVO params) {
		this.params = params;
	}

}
