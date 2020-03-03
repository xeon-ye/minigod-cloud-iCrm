package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;


/**
 * <code>PtfStaticType<code> 行情资讯模块的所有错误码
 * 
 * @author Jimmy
 * @since MiniGod v0.0.1 (2014-11-13)
 * 
 */
public class MktStaticType {
	private static final Map<Integer, CodeType> map = new HashMap<Integer, MktStaticType.CodeType>();

	/**
	 * <code>StkStatusType<code> 股票的状态
	 * 
	 */
	public static class StkStatusType {
		/** 正常交易 */
		public static final int NORMAL = 0;
		/** 涨停 */
		public static final int LIMIT_UP = 1;
		/** 跌停 */
		public static final int LIMIT_DOWN = 2;
		/** 停牌 */
		public static final int SUSP = 3;
		/** 退市 */
		public static final int DELITING = 4;
		/** IPO期间 */
		public static final int DURING_IPO = 5;
	}

	public enum CodeType {
		ASSETID_UNKNOWN(4000, "获取资产信息失败"),
		ASSETINFO_NULL(4001, "获取资产信息失败"),
		STKINFO_NULL(4002, "获取股票信息失败"),
		DIVINFO_NULL(4003, "获取分红信息失败"),
		ALLOT_NULL(4004,"获取配股信息失败"), 
		FINIDX_NULL(4005, "获取财务指标信息失败"),
		SHAREIDX_NULL(4006, "获取股本信息失败"), 
		TRADEDAY_NULL(4007, "获取交易日历信息失败"), 
		TIMESHARE_NULL(4008, "获取分时数据失败"), 
		QUOTE_NULL(4009, "获取实时行情数据失败"), 
		CORP_NULL(4010, "获取公司信息失败"),
		INDU_NULL(4011, "获取股票行业失败"), 
		DAYLYDATA_NULL(4012, "获取历史日K数据失败"),
		TSPARA_ERROR(4013, "分时参数错误"), //
		ERROR_UNKNOWN(4999, "未知错误"),
		INVALID_LABELID(6000,"无效的概念ID或者请求的概念ID不存在"), 
		INVALID_EVENTID(6001,"无效的事件ID或者请求的事件ID不存在"), 
		LABELID_NOT_NULL(6002, "概念ID不能为空"),
		EVENTID_NOT_NULL(6003, "事件ID不能为空"), 
		PULLMODE_NOT_NULL(6004, "拉取概念事件方式不能为空"),
		COUNT_NOT_NULL(6005, "拉取概念事件条数不能为空"),
		FLAG_NOT_NULL(6006, "全文检索搜索标识不能为空"), 
		CONDITION_NOT_NULL(6007, "全文检索搜索内容不能为空"), ;
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
