/**
 * @Title: IMAnncSetting.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 群公告设置
 * 
 * @author Jimmy
 * @date 2015-11-3 下午8:25:27
 * @version v1.0
 */

public class IMAnncSettingReqVO extends SNVersion {
	/** */
	private static final long serialVersionUID = 1L;

	private IMAnncSettingVO params;

	public IMAnncSettingVO getParams() {
		return params;
	}

	public void setParams(IMAnncSettingVO params) {
		this.params = params;
	}
}
