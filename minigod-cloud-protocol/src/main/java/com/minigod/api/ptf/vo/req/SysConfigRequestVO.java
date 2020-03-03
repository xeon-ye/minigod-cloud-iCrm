package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: SysConfigRequestVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-18 下午5:55:30
 * @version v1.0
 */

public class SysConfigRequestVO extends SNVersion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private SysConfigVO params;

	public SysConfigVO getParams() {
		return params;
	}

	public void setParams(SysConfigVO params) {
		this.params = params;
	}

}
