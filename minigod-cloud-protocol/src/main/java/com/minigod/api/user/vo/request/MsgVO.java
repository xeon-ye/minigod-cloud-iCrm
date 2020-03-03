package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.Msg;

/**
 * 标记消息为已处理
 */

public class MsgVO extends SNVersion {

	private static final long serialVersionUID = -4795436481254306490L;

	private Msg params;

	public Msg getParams() {
		return params;
	}

	public void setParams(Msg params) {
		this.params = params;
	}
}
