/**
 * @Title: InterfaceUpdateCheckVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import java.io.Serializable;
import java.util.Map;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @description 接口检查更新值对象
 * 
 * @author minigod
 * @date 2015-8-11 下午6:01:01
 * @version v1.0
 */

public class InterfaceUpdateCheckVO extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, Long> infList;

	public Map<String, Long> getInfList() {
		return infList;
	}

	public void setInfList(Map<String, Long> infList) {
		this.infList = infList;
	}

}
