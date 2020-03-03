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
 * 
 * @description 调仓描述
 *
 * @author MiniGod
 * @date 2015-4-7 下午4:20:22
 * @version v1.0
 */
@TransferBean
public class AdjustComDetailRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@Emoji
	private AdjustComDetailVO params;

	public AdjustComDetailVO getParams() {
		return params;
	}

	public void setParams(AdjustComDetailVO params) {
		this.params = params;
	}
}
