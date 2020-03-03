package com.minigod.api.discover.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>DiscLableEventReqVO<code>
 * 
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-02)
 */
public class DiscLabelNewsReqVO extends SNVersion {

	private static final long serialVersionUID = 1825011933664783416L;

	private DiscLabelNewsVO params;

	/**
	 * @return the params
	 */
	public DiscLabelNewsVO getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(DiscLabelNewsVO params) {
		this.params = params;
	}
}
