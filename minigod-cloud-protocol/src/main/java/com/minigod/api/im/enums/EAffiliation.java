/**
 * @Title: EAffiliation.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.enums;

import org.apache.commons.lang.StringUtils;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-15 下午3:10:11
 * @version v1.0
 */

public enum EAffiliation {
	M, // 普通成员
	P, // 付费成员
	G, // 游客
	O; //群主
	
	public static EAffiliation getAffiliation(String sAffiliation) {
		if (StringUtils.isBlank(sAffiliation)) {
			return null;
		}
		if (M.toString().equals(sAffiliation)) {
			return M;
		} else if (P.toString().equals(sAffiliation)) {
			return P;
		} else if (O.toString().equals(sAffiliation)) {
			return O;
		}
		return null;
	}
}
