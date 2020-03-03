/**
 * @Title: StkTsRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * <code>StkTsRespVO</code>
 * 
 * @author Jimmy
 * @date 2015-7-16 下午3:05:00
 * @version v1.0
 */
public class StkTsRespVO implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;

	private List<List<Object>> data;
	private String preClose;
	private String maxPrice ;
	private String minPrice ;

	public List<List<Object>> getData() {
		return data;
	}

	public void setData(List<List<Object>> data) {
		this.data = data;
	}

	public String getPreClose() {
		return preClose;
	}

	public void setPreClose(String preClose) {
		this.preClose = preClose;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	
}
