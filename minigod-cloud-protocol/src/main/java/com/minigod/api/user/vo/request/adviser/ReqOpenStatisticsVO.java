package com.minigod.api.user.vo.request.adviser;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: ReqAdviseropenStatisticsVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-9-28 下午5:15:47
 * @version v1.0
 */
@TransferBean
public class ReqOpenStatisticsVO extends SNVersion {

	private static final long serialVersionUID = 2406842815060417640L;
	@TransferID
	private OpenStatisticsVO params;

	public OpenStatisticsVO getParams() {
		return params;
	}

	public void setParams(OpenStatisticsVO params) {
		this.params = params;
	}
}
