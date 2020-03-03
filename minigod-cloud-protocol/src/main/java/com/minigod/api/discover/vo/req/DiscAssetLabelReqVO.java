
package com.minigod.api.discover.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>DiscAssetLabelReqVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-05)
 *
 */
public class DiscAssetLabelReqVO extends SNVersion {

	private static final long serialVersionUID = 1825011933664783416L;

	private DiscAssetLabelVO params;

	/**
	 * @return the params
	 */
	public DiscAssetLabelVO getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(DiscAssetLabelVO params) {
		this.params = params;
	}

}
