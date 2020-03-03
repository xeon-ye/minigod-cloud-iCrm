/**
 * @Title: PtfLikeRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author minigod
 * @date 2015-4-11 上午10:32:18
 * @version v1.0
 */
@TransferBean
public class PtfLikeRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	@TransferID
	private PtfLikeVO params;

	public PtfLikeVO getParams() {
		return params;
	}

	public void setParams(PtfLikeVO params) {
		this.params = params;
	}
	
}
