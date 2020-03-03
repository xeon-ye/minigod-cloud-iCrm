package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>PtfStaticType<code> 实盘组合模块的所有错误码介于 3000到4000。
 *
 * @author Jimmy
 * @date 2015-4-14 下午4:00:12
 * @version v1.0
 */
public class RealPtfStaticType {
	
	private static final Map<Integer, CodeType> map = new HashMap<Integer, RealPtfStaticType.CodeType>();

	//组合模块
	public enum CodeType {
		NOT_ENOUGH_FUNDS(3001, "用户资金余额不足"),
		SESSION_INVALID(3002, "会话号无效或已过期, 请重新登陆"),
		ACC_UNBIND(3003, "未绑定的账号"),
		REQUEST_TIMEOUT(3500, "请求超时"),
		BRK_CONTENT_BLANK(3501, "券商返回数据为空"), 
		BRK_ERROR_BLANK(3502, "券商返回的错误信息为空"), 
		BRK_CODE_BLANK(3503, "券商返回的错误信息有错误信息，而无错误码"),
		ACC_BIND_FAIL(3504, "绑定失败"),
		STOCKCODE_ERROR(3505, "股票代码错误"),
		PARAM_ELLEGAL(3506, "非法的参数"),
		ACC_UNBIND_FAIL(3507, "解绑失败"),
		LOGIN_TIMEOUT(3508, "券商登录超时，请稍后重试"),
		BINDACC_TIMEOUT(3509, "券商绑定超时，请稍后重试"),
		UNBINDACC_TIMEOUT(3510, "券商解绑超时，请稍后重试"),
		BRK_SYS_UPDATING(3511, "券商系统维护中，请稍后再来尝试"),
		ERROR_UNKNOWN(3999, "未知错误");
		
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
