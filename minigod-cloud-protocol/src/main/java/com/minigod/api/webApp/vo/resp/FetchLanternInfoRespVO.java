/**
 * @Title: FetchLanternInfoRespVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2016-2-16 下午6:27:27
 * @version v1.0
 */
public class FetchLanternInfoRespVO implements Serializable {
	private static final long serialVersionUID = 7408806810483846652L;
	/** 0 – 未领取过,1 – 领取过,2 – 活动已经结束 */
	private String activityStatus;

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

}
