/**
 * @Title: AdviserIndexRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.response;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-10 下午5:49:49
 * @version v1.0
 */

public class AdviserIndexRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String qaSwitch;
	private Integer custAddNum;

	public String getQaSwitch() {
		return qaSwitch;
	}

	public void setQaSwitch(String qaSwitch) {
		this.qaSwitch = qaSwitch;
	}

	public Integer getCustAddNum() {
		return custAddNum;
	}

	public void setCustAddNum(Integer custAddNum) {
		this.custAddNum = custAddNum;
	}


}
