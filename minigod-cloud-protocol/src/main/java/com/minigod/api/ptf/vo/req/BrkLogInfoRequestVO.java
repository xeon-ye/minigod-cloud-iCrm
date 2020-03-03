/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @description 券商登录请求接口类
 *
 * @author minigod
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */
@TransferBean
public class BrkLogInfoRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	@Emoji
	private BrkLogInfoVO params;

	public BrkLogInfoVO getParams() {
		return params;
	}

	public void setParams(BrkLogInfoVO params) {
		this.params = params;
	}
	
}
