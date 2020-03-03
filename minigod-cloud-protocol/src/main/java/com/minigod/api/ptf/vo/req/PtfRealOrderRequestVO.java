/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 组合委托请求值对象
 *
 * @author 许德佑
 * @date 2015-3-16
 * @version v2.0
 */
@TransferBean
public class PtfRealOrderRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private PtfRealOrderVO params;

	public PtfRealOrderVO getParams() {
		return params;
	}

	public void setParams(PtfRealOrderVO params) {
		this.params = params;
	}
	
}
