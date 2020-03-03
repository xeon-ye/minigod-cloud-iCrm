/**
 * @Title: IMFetchAnnouncement.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-4 下午4:49:46
 * @version v1.0
 */

public class IMFetchAnnouncementReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private IMFetchAnnouncementVO params;

	public IMFetchAnnouncementVO getParams() {
		return params;
	}

	public void setParams(IMFetchAnnouncementVO params) {
		this.params = params;
	}
}
