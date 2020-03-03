package com.minigod.api.discover.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>DiscNewsReqVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-03)
 *
 */
public class DiscNewsReqVO extends SNVersion {

	private static final long serialVersionUID = 1825011933664783416L;
	
	private DiscNewsVO params;

	/**
	 * @return the params
	 */
	public DiscNewsVO getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(DiscNewsVO params) {
		this.params = params;
	}
	
	
	
	
	

}
