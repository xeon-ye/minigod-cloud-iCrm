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
 * 
 * @description 組合新增股票预检
 *
 * @author MiniGod
 * @date 2015-3-30 下午4:19:13
 * @version v1.0
 */
@TransferBean
public class CheckAddStksRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private CheckAddStksVO params;

	public CheckAddStksVO getParams() {
		return params;
	}

	public void setParams(CheckAddStksVO params) {
		this.params = params;
	}
}
