/**
 * @Title: ERealtionRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.enums;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-16 下午7:26:58
 * @version v1.0
 */

public enum ERealtionRequest {

	Y, //
	N; //

	public boolean equals(String str) {
		return this.toString().equals(str);
	}

}
