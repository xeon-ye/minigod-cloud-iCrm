/**
 * @Title: CheckRealBuyTransRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 实盘组合买入预检请求值对象
 *
 * @author minigod
 * @date 2015-3-16 下午2:02:44
 * @version v1.0
 */
@TransferBean
public class CheckRealBuyTransRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private CheckRealBuyTransVO params;

	public CheckRealBuyTransVO getParams() {
		return params;
	}

	public void setParams(CheckRealBuyTransVO params) {
		this.params = params;
	}
	
}

