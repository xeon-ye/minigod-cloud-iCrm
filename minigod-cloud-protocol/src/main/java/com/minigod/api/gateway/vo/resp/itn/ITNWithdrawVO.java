/**
 * @Title: ITNWithdrawVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.itn;

import java.io.Serializable;

/**
 * @description iTN撤单返回
 *
 * @author 余俊斌
 * @date 2015年7月7日 上午11:30:28
 * @version v1.0
 */

public class ITNWithdrawVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String entrust_no;

	public String getEntrust_no() {
		return entrust_no;
	}

	public void setEntrust_no(String entrust_no) {
		this.entrust_no = entrust_no;
	}
}
