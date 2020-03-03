/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.minigod.api.ptf.vo.enums.EOrderProperty;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2016-3-12 下午2:08:01
 * @version v1.0
 */

public class OrderPropVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, EOrderProperty> orderMap = new HashMap<String, EOrderProperty>();
	private String ordMessage;

	public Map<String, EOrderProperty> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<String, EOrderProperty> orderMap) {
		this.orderMap = orderMap;
	}

	public String getOrdMessage() {
		return ordMessage;
	}

	public void setOrdMessage(String ordMessage) {
		this.ordMessage = ordMessage;
	}

}
