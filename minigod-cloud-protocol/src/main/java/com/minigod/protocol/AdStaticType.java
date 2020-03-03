package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

public class AdStaticType {

	private static final Map<Integer, CodeType> map = new HashMap<Integer, AdStaticType.CodeType>();

	//活动模块相关
	public enum CodeType {
		
		ERROR_UNKNOWN(100, "未知错误，请稍后重试或联系客服"),
		GAME_STK_INFO_NULL(888, "赛事个股不存在"),
		GAME_EVENT_NULL(888, "赛事不存在"),
		GAME_FIGHT_EVENT_END(888, "赛事已结束或已作废"),
		GAME_FIGHT_EVENT_START(888, "当前赛事已开赛"),
		GAME_FIGHT_JOIN_END(888, "当前赛事的用户已为结束状态，请参加下一场比赛"),
		GAME_FIGHT_TRADE_TIME(888, "交易时间,不允许操作"); 


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
