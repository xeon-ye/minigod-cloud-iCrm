/**
 * @Title: FnlProdStaticType.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2016-1-15 下午4:38:12
 * @version v1.0
 */

public class FnlProdStaticType {
	private static final Map<Integer, CodeType> map = new HashMap<Integer, FnlProdStaticType.CodeType>();

	// 理财相关,CODE 11000-12000区间
	public enum CodeType {
		ERROR_UNKNOWN(100, "未知错误，请稍后重试或联系客服"), 
		QUOTA_LACK(11001, "有额度时，我们将通过APP系统消息通知您（请确保系统通知开启）"),
		ALL_WITHDRAW(11002, "提现后剩余资产不能低于%s元，是否全部提出"),
		NO_WITHDRAWABLE_AMOUNT(11003, "提现后剩余资产不能低于%s元，是否全部提出");

		private int code;
		private String message;

		private CodeType(int code, String message) {
			this.code = code;
			this.message = message;
			map.put(code, this);
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public static final String getMessage(int code) {
			CodeType _code = map.get(code);
			if (_code == null) {
				return ERROR_UNKNOWN.getMessage();
			}
			return _code.getMessage();
		}
	}
}
