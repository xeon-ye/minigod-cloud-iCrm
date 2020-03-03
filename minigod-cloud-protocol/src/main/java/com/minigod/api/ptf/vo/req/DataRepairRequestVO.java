/**
 * @Title: DataRepairRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-5-19 下午2:50:34
 * @version v1.0
 */

public class DataRepairRequestVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = 1L;
	
	private DataRepairVO params;

	public DataRepairVO getParams() {
		return params;
	}

	public void setParams(DataRepairVO params) {
		this.params = params;
	}
}
