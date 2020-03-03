/**
 * @Title: CheckRealSellTransRequestVO.java
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
 * @author panlz
 * @date 2015-3-30 下午3:49:02
 * @version v1.0
 */
@TransferBean
public class CheckRealSellTransRequestVO extends SNVersion {
private static final long serialVersionUID = 1L;
	
	@TransferID
	private CheckRealSellTransVO params;

	public CheckRealSellTransVO getParams() {
		return params;
	}

	public void setParams(CheckRealSellTransVO params) {
		this.params = params;
	}

	 
}
