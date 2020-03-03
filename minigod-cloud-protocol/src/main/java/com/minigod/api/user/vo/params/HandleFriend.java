package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.TransferBean;

@TransferBean
public class HandleFriend extends SNUserBase {
	private static final long serialVersionUID = 1827960851264866186L;
	private Integer resp;// 0表示拒绝请求，1表示同意请求。

	public Integer getResp() {
		return resp;
	}

	public void setResp(Integer resp) {
		this.resp = resp;
	}
}