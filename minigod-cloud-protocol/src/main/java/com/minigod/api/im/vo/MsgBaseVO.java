/**
 * @Title: MsgBaseVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-9-25 下午3:25:07
 * @version v1.0
 */

public class MsgBaseVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> ext;

	public Map<String, Object> getExt() {
		return ext;
	}

	public void setExt(Map<String, Object> ext) {
		this.ext = ext;
	}
}
