/**
 * @Title: Config.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import java.util.List;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-7-30 上午11:15:19
 * @version v1.0
 */

public class Config extends SNUserBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 参数列表
	private List<String> keys;

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
}
