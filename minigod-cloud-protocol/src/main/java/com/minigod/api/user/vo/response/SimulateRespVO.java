/**
 * @Title: MySummaryReqVo.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import com.minigod.api.vo.BaseVO;

import java.io.Serializable;

/**
 * @description
 * 
 * @author kouyandong
 * @date 2016-1-20 下午2:58:45
 * @version v1.0
 */

public class SimulateRespVO implements Serializable {

	private static final long serialVersionUID = -3185789091421988715L;

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
