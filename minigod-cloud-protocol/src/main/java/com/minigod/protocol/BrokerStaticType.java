package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * @description  券商通道错误码
 *
 * @author Jimmy
 * @date 2015-3-11 上午10:14:20
 * @version v1.0
 */
public class BrokerStaticType {
	private static final Map<Integer, CodeType> map = new HashMap<Integer, BrokerStaticType.CodeType>();
	
	public enum CodeType {
		CONN_TIMEOUT(7100, "连接超时"),
		NOT_LOGIN(7101, "用户未登录"),
		ERROR_UNKNOWN(7999, "未知错误"),;
		
		private int errorCode;
		private String errorMessage;

		private CodeType(int errorCode, String errorMessage) {
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
			map.put(errorCode, this);
		}

		public int getCode() {
			return errorCode;
		}

		public String getErrorMsg() {
			return errorMessage;
		}

		public static final CodeType get(int errorCode) {
			CodeType code = map.get(errorCode);
			if (code == null) {
				return ERROR_UNKNOWN;
			}
			return code;
		}

		public static final String getErrorMessage(int errorCode) {
			CodeType code = map.get(errorCode);
			if (code == null) {
				return ERROR_UNKNOWN.getErrorMsg();
			}
			return code.getErrorMsg();
		}
	}
}
