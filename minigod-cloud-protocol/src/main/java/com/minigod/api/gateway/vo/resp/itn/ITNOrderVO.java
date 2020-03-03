/**
 * @Title: ITNOrderVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description 委托返回
 *
 * @author 余俊斌
 * @date 2015年7月2日 下午3:28:15
 * @version v1.0
 */

public class ITNOrderVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 委托编号
	private String entrust_no;

	public String getEntrust_no() {
		return entrust_no;
	}

	public void setEntrust_no(String entrust_no) {
		this.entrust_no = entrust_no;
	}

}
