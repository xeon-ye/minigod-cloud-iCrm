package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfIdRequestVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-11 上午10:35:52
 * @version v1.0
 */
@TransferBean
public class PtfIdRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private PtfIdVO params;

	public PtfIdVO getParams() {
		return params;
	}

	public void setParams(PtfIdVO params) {
		this.params = params;
	}

}
