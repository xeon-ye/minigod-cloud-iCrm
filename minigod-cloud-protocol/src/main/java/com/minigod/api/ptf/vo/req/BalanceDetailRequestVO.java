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
 * @description 持仓详情查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */
@TransferBean
public class BalanceDetailRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private BalanceDetailVO params;

	public BalanceDetailVO getParams() {
		return params;
	}

	public void setParams(BalanceDetailVO params) {
		this.params = params;
	}
	
}
