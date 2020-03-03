package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: AdviserOrgsVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午5:15:47
 * @version v1.0
 */

public class AdviserOrgsVO extends SNVersion implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;

	private AdviserOrgs params;

	public AdviserOrgs getParams() {
		return params;
	}

	public void setParams(AdviserOrgs params) {
		this.params = params;
	}
}
