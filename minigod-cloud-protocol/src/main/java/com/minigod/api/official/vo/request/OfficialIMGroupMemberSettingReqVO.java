/**
 * @Title: IMGroupMemberSettingReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.official.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-8 下午7:24:25
 * @version v1.0
 */

public class OfficialIMGroupMemberSettingReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private OfficialIMGroupMemberSettingVO params;

	public OfficialIMGroupMemberSettingVO getParams() {
		return params;
	}

	public void setParams(OfficialIMGroupMemberSettingVO params) {
		this.params = params;
	}
}
