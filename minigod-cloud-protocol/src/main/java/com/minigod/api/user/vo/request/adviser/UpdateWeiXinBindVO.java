package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: updateWeiXinBind.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午5:05:47
 * @version v1.0
 */

public class UpdateWeiXinBindVO extends SNVersion implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;

	private UpdateWeiXinBind params;

	public UpdateWeiXinBind getParams() {
		return params;
	}

	public void setParams(UpdateWeiXinBind params) {
		this.params = params;
	}
}
