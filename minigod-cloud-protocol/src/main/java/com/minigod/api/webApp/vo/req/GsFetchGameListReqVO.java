/**
 * @Title: GsFetchGameListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-10-21 上午10:11:37
 * @version v1.0
 */

public class GsFetchGameListReqVO extends GSbaseReqVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer action;
	private Integer readId;
	private Integer count;
	public Integer getAction() {
		return action;
	}
	public void setAction(Integer action) {
		this.action = action;
	}
	public Integer getReadId() {
		return readId;
	}
	public void setReadId(Integer readId) {
		this.readId = readId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
