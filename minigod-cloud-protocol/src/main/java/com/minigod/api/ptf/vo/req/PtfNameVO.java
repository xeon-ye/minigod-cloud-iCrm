/**
 * @Title: PtfNameVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */
package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

/**
 * @Description: 组合名称校验请求值对象
 *
 * @author minigod
 * @date 2014-09-29 9:29:16
 * @version v1.0
 */

public class PtfNameVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = -2594325446661740774L;
	
	/** 组合的名称*/
	private String name; 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
