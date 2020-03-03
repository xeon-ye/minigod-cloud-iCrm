/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description 精选投顾观点请求类
 *
 * @author MiniGod
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */

public class AdviserNoteRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private BaseVO params;

	public BaseVO getParams() {
		return params;
	}

	public void setParams(BaseVO params) {
		this.params = params;
	}
	
}
