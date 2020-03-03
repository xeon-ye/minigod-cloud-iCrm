/**
 * @Title: IMGroupSetting.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-19 下午4:41:50
 * @version v1.0
 */

public class IMNodisturbingSettingReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private IMNodisturbingSettingVO params;

	public IMNodisturbingSettingVO getParams() {
		return params;
	}

	public void setParams(IMNodisturbingSettingVO params) {
		this.params = params;
	}
}
