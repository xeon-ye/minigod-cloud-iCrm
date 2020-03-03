/**
 * @Title: ViewpointDeleteVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-3 下午7:48:48
 * @version v1.0
 */

public class ViewpointDeleteVO extends BaseVO{
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
