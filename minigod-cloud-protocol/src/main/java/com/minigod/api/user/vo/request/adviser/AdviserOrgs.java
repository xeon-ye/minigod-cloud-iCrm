package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @Title: WeiXinCheckVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午4:58:21
 * @version v1.0
 */

public class AdviserOrgs extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;

	private Integer lastVersion;//最后的版本号,按增量获取

	public Integer getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(Integer lastVersion) {
		this.lastVersion = lastVersion;
	}
}
