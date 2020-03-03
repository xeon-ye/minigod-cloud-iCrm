package com.minigod.api.user.vo.request.adviser;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: ReqSaveOpenInfoVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-9-28 下午5:15:47
 * @version v1.0
 */
public class ReqSaveOpenInfoVO  extends SNVersion {

	private static final long serialVersionUID = 2406842815060417640L;
	
	private SaveOpenInfoVO  params;

	public SaveOpenInfoVO getParams() {
		return params;
	}

	public void setParams(SaveOpenInfoVO params) {
		this.params = params;
	}
	
}
