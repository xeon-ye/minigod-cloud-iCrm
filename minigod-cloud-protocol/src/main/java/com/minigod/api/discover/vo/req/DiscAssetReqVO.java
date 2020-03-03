
package com.minigod.api.discover.vo.req;
import com.minigod.api.user.vo.SNVersion;

/**
 * <code>DiscAssetReqVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-04)
 *
 */
public class DiscAssetReqVO extends SNVersion {

	private static final long serialVersionUID = 1825011933664783416L;
	
	private DiscAssetVO params;

	/**
	 * @return the params
	 */
	public DiscAssetVO getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(DiscAssetVO params) {
		this.params = params;
	}



	
}
