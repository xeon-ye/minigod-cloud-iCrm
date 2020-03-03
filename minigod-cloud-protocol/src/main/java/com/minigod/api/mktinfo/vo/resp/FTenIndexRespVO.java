/**
 * @Title: FTenIndexRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-10-15 上午10:06:04
 * @version v1.0
 */

public class FTenIndexRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String finPeriod;
	private List<List<String>> baseIndex;
	private List<List<String>> event;
	private List<List<String>> corp;

	public String getFinPeriod() {
		return finPeriod;
	}

	public void setFinPeriod(String finPeriod) {
		this.finPeriod = finPeriod;
	}

	public List<List<String>> getBaseIndex() {
		return baseIndex;
	}

	public void setBaseIndex(List<List<String>> baseIndex) {
		this.baseIndex = baseIndex;
	}

	public List<List<String>> getEvent() {
		return event;
	}

	public void setEvent(List<List<String>> event) {
		this.event = event;
	}

	public List<List<String>> getCorp() {
		return corp;
	}

	public void setCorp(List<List<String>> corp) {
		this.corp = corp;
	}

}
