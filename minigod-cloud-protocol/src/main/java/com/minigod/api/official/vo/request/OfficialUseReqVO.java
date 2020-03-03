package com.minigod.api.official.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>UseReqVO<code>
 * 
 * @author panlz
 * @since MiniGod v1.0 (2015-06-24)
 * 用户登录、注册、验证码请求类，公用
 * 
 */
public class OfficialUseReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private OfficialUserVO params;

	public OfficialUserVO getParams() {
		return params;
	}

	public void setParams(OfficialUserVO params) {
		this.params = params;
	}
}
