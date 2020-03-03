package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 模拟交易错误码静态类
 *
 * @author 余俊斌
 * @date 2015年3月13日 上午11:15:45
 * @version v1.0
 */
public class SimuStaticType {
	private static final Map<Integer, CodeType> map = new HashMap<Integer, SimuStaticType.CodeType>();

	// 思迪模拟组合
	public enum CodeType {
		ILLEGAL_INPUT_ERROR(8101, "输入非法"),
		TRADE_QTY_ERROR(8102, "买卖数量必须输入整数并且是100的整数倍"),
		LIQUIDATE_ORD_ERROR(8103, "清算时间内不能下单"),
		NEW_STK_ORD_ERROR(8104, "不允许新股委托买卖"),
		REPEAT_OPR_ERROR(8105, "不能重复操作"),
		TRADE_TIM_ERROR(8106, "不允许非交易时间操作"),
		NONE_DATA_ERROR(8107, "找不到所要的数据"),
		ORDER_STATUS_ERROR(8110, "退市/未上市/停牌的股票不允许委托下单"),
		UNKNOWN_ERROR(8199, "未知错误"),
		NO_ERRCODE_ERROR(8899, "没有对应的错误码")
		;

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

		public String getMessage() {
			return errorMessage;
		}

		public static final CodeType get(int errorCode) {
			CodeType code = map.get(errorCode);
			if (code == null) {
				return UNKNOWN_ERROR;
			}
			return code;
		}

		public static final String getErrorMessage(int errorCode) {
			CodeType code = map.get(errorCode);
			if (code == null) {
				return UNKNOWN_ERROR.getMessage();
			}
			return code.getMessage();
		}
	}
		
}
