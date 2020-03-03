/**
 * @Title: IMFetchGroupNumRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-21 下午7:45:13
 * @version v1.0
 */

public class IMFetchGroupNumRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer groupNum;
	private Integer groupChargeNum;
	public Integer getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}
	public Integer getGroupChargeNum() {
		return groupChargeNum;
	}
	public void setGroupChargeNum(Integer groupChargeNum) {
		this.groupChargeNum = groupChargeNum;
	}
}
