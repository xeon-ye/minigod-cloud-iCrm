/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * 
 * @description 帖子详情页请求类
 *
 * @author MiniGod
 * @date 2015-4-4 上午11:21:39
 * @version v1.0
 */

public class NoteInfoRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private NoteInfoDetailVO params;

	public NoteInfoDetailVO getParams() {
		return params;
	}

	public void setParams(NoteInfoDetailVO params) {
		this.params = params;
	}
}
