package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfIdFlagRequestVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-11 上午11:28:51
 * @version v1.0
 */
@TransferBean
public class PtfIdFlagRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private PtfIdFlagVO params;

	public PtfIdFlagVO getParams() {
		return params;
	}

	public void setParams(PtfIdFlagVO params) {
		this.params = params;
	}

}
