/*
 * FileName: IdVO.java
 * Copyright: Copyright 2014-12-5 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * 
 * @description 这里描述类的用处
 *
 * @author MiniGod
 * @date 2015-4-11 下午3:21:55
 * @version v1.0
 */
public class IdVO extends BaseVO{
	/**  */
	private static final long serialVersionUID = 1L;

	private String type;
	
	private Integer id;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
