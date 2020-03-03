/**
 * @Title: AdNiuUserInfoReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import java.io.Serializable;
import java.util.List;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-18 下午2:47:42
 * @version v1.0
 */

public class AdNiuUserLimitNumReqVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer adId;
	private List<Integer> userIds;
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	public List<Integer> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}
	
}
