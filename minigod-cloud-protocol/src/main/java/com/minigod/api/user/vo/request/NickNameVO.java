package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.NickName;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;


/**
 * 修改用户昵称 
 */

@TransferBean
public class NickNameVO extends SNVersion {

	private static final long serialVersionUID = -4795436481254306490L;

	@Emoji
	private NickName params;

	public NickName getParams() {
		return params;
	}

	public void setParams(NickName params) {
		this.params = params;
	}
}
