
package com.minigod.api.discover.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>DiscIdeaVersionReqVO<code>
 * 
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-02)
 */
public class DiscLabelVersionReqVO extends SNVersion {

	private static final long serialVersionUID = 1825011933664783416L;

	private DiscLabelVersionVO params;

	/**
	 * @return the params
	 */
	public DiscLabelVersionVO getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(DiscLabelVersionVO params) {
		this.params = params;
	}

}
