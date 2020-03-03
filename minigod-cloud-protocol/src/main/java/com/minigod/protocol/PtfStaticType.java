/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>PtfStaticType<code> 组合模块的所有错误码介于 2000到3000。
 * 
 */
public class PtfStaticType {
	
	private static final Map<Integer, CodeType> map = new HashMap<Integer, CodeType>();

	//组合模块
	public enum CodeType {
		INVALID_PTFID(2004, "无效的组合ID"),
		QUOTINFO_ERROR(2007, "取行情数据失败"),
		STKPRICE_ERROR(2008, "获取股票的价格失败"),
		TRD_DAY_ERROR(2009, "获取交易日失败"),
		NO_AUTH_VIEW(2022, "组合已被删除 或者 没有权限浏览该组合信息"),
		FIND_FETCH_PTFFLAG(2023, "不是好友关系"),
		ASSETS_BLANK(2039, "组合拐点的资产为空"),
		ASSETS_LIST_BLANK(2040, "组合指数对象集合为空"),
		STK_STATUS_BLANK(2042, "获取股票的状态为空"),
		PERMISSION_ERROR(2060, "你的权限不够"),
		SIMU_CREATE_ACC_ERROR(2100, "模拟通道创建账号异常"),
		BROKER_CUST_INVALID(2104, "您已关联国信证券账户，请使用原账户登录"),
		TRADE_TIME_ERROR(2105, "当前时间非交易时间"),
		
		BROKER_INVALID(2106, "当前请求的券商和组合设定的券商不一致"),
		PARM_ERROR(2107, "参数不正确"),
		UNSPORT_BROKER(2108, "不支持的券商ID"),
		NOT_ENOUGHT_MONEY(2109, "本次交易需冻结资金{0}元，当前可用资金不足"),
		BROKER_ACCOUNT_NOT_ACTIVE(2110, "您的证券账户尚未激活，激活后下一工作日可进行关联，请留意券商发送的激活短信"),
		CANNOT_BUY_PTF(2111, "无法购买本组合"),
		ADJUST_USERID_ERROR(2201, "组合跟单者不允许调仓"),
		PTF_ORDERS(2204, "组合委托记录为空"),
		
		FOLLOW_NOT_CHANGED(2205, "此次跟单无需操作，已完成，请忽略本次跟单吧"),
		
		DEPOSITACC_ERROR(2206, "主资金账号不唯一"),
		ERR_DOUBLICATED_REQUEST(2208, "存在请求ID相同但请求要素不一致的重复客户端请求"),
		REALPTF_STK_ORDER_INCONSISTENT(2209, "前端上传的组合委托数据与服务端数据库不一致"),
		ORDER_EXPIRED(2210, "购买组合订单过期，请刷新"),
		WEIXIN_FAILD(2211, "微信服务器返回失败"),
		UPDATE_RECORDS_ERROR(2301, "数据库更新记录异常"),
		PARM_TOO_LONG(2302, "{0}超出长度限制{1}位"),
		
		CREATE_PTF_COUNT_LIMIT(2401, "优秀的投资者不会管理超过{0}个组合，请回去清理一下吧"),
		// TODO 待确认
		UPGRADE_VERSION(2402, "目前版本过低请升级"),// 提示升级返回码
		PTF_AMOUNT_ERROR(2403, "服务器数据返回失败"),
		ERROR_UNKNOWN(2500, "未知错误");
		
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
	
	/**
	 * 888 提示信息列表，请不要将非888的内容放到本类中！
	 * @author THINK
	 *
	 */
	public static final class DirectDspMsg{

		//实盘新增股票预检
		public static final String CHECK_ADD_STK_TRANS_COUNT_OVERLIMIT = "您已选择{0}支股票，超过了组合{1}支股票上限";
		public static final String CHECK_ADD_STK_TRANS_NOT_TRADE_DAY = "今天不是交易日";
		public static final String CHECK_ADD_STK_TRANS_NOT_TRADE_TIME = "当前并非交易时间";
		
		//实盘组合撤单预检
		public static final String CHECK_PTF_WITHDRAW_NOT_WITHDRAWABLE = "无可撤单的个股委托！";
		
		//模拟组合撤单预检
		public static final String CHECK_SIMU_PTF_WITHDRAW_NOT_WITHDRAWABLE = "无可撤单的个股委托！";
		
		//实盘组合买入预检
		public static final String CHECK_REAL_BUY_TRAN_NOT_ANY_STK = "该组合无持仓个股，暂时无法买入哦";
		public static final String CHECK_REAL_BUY_TRAN_ALL_SKT_IN_OTHER_PTF = "该组合的所有资产都在您的其他实盘组合中，暂时无法购买哦";
		public static final String CHECK_REAL_SELL_NOT_CURRENT_BROKER = "当前券商不存在本组合的持仓";
		public static final String CHECK_REAL_SELL_FOLLOWER_COUNT_LIMIT = "对不起，一个组合最大跟单人数当前限制为{0}，您暂时无法跟单噢";
		
		//实盘组合卖出预检
		public static final String CHECK_REAL_SELL_TRANS_NO_STK = "该组合无持仓个股，暂时无法卖出哦";
		
		//模拟新增股票预检
		public static final String CHECK_SIMU_ADD_STK_TRANS_MAX_STK_LIMIT_ONE = "您已选择{0}支股票，超过了组合{1}支股票上限";
		public static final String CHECK_SIMU_ADD_STK_TRANS_MAX_STK_LIMIT_TWO = "您已选择{0}支股票，超过了组合{1}支股票上限";
		public static final String CHECK_SIMU_ADD_STK_TRANS_NOT_SUPPORT_ASSET = "模拟组合暂不支持分级基金/封闭基金({0})，您可以将模拟组合升级为实盘后再买入";
		
		//删除组合
		public static final String DELETE_PTF_CANNOT_DELETE_HAS_FOLLOWER = "您的组合已有人实盘跟单，不能删除哦！";
		public static final String DELETE_PTF_CANNOT_DELETE_FOR_IN_SALE = "您的组合已有客户购买，不能删除哦！";
		public static final String DELETE_PTF_CANNOT_DELETE_HAS_TRADING = "组合有在途交易，无法删除哦！";
		public static final String DELETE_PTF_CANNOT_DELETE_HAS_SERVICING_ORDER = "组合有服务中的订单，无法删除哦！";
		public static final String DELETE_PTF_CANNOT_REAL_PTF = "实盘组合无法删除哦！";
		
		//删除实盘组合持仓
		public static final String DELETE_REAL_PTFBAL_HODING_STK = "组合还有持仓，无法删除哦！";
		public static final String DELETE_REAL_PTFBAL = "实盘组合持仓无法删除哦！";
		public static final String DELETE_REAL_PTFBAL_TRADING = "组合持仓中存在在途交易，无法删除删除组合。";
		
		//跟单预检
		public static final String FOLLOW_CHECK_FOLLOWER_TRADING = "上一笔跟单交易未完成，暂时无法跟单哦";
		
		//拉取组合列表
		public static final String FIND_FETCH_PTFFLAG = "您和他还不是好友关系哦";//试图读取不是好友的组合列表
		
		//创建模拟组合
		public static final String SAVE_AND_CREATE_SIMU_PTF_AT_LEAST_ONE_FRIEND = "对部分好友可见，请至少选择一位好友哦";
		public static final String SAVE_AND_CREATE_SIMU_PTF_ADVISOR_PTF_PERMISSION_ALL_ONLY = "投顾组合的权限只能为全部可见";
		public static final String SAVE_AND_CREATE_SIMU_PTF_STK_COUNT_LIMIT = "组合内股票数量不能超过{0}支";
		public static final String SAVE_AND_CREATE_SIMU_PTF_STK_DELITING = "股票{0}已经退市。";
		public static final String SAVE_AND_CREATE_SIMU_PTF_STK_DURING_IPO = "股票{0}还未上市。";
		public static final String SAVE_AND_CREATE_SIMU_PTF_STK_MAX_ORDER_LIMIT = "{0}的单笔委托数不能超过{1}股";
		public static final String SAVE_AND_CREATE_SIMU_PTF_NOT_SUPPORT_CHAR = "组合名称不能包含字符$";
		
		//券商登陆
		public static final String SAVE_BROKER_LOGIN_INFO_NOT_SUPPORT_MULT_ACC = "很抱歉，目前暂不支持融资融券账户登录";
		
		//组合关注
		public static final String SAVE_OR_UPDATE_PTFFAV_CANNOT_FAV_SELF = "不能关注自己的组合";
		public static final String SAVE_OR_UPDATE_PTFFAV_PERMISSION_DENIED = "您没有关注该组合的权限";
		public static final String SAVE_OR_UPDATE_PTFFAV_TOO_MANY_FAVS = "对不起，您关注的组合已超过{0}，无法再关注其他组合";
		
		//组合关注或购买
		public static final String SAVE_OR_UPDATE_PTF_FAVORSALE_PERMISSION_DENIED = "您没有{0}该组合的权限";
		
		//实盘组合委托
		public static final String SAVE_PTF_REAL_ORDER_LIMIT_PRICE = "价格输入有误，请重新输入";
		
		//模拟组合委托
		public static final String SAVE_PTF_SIMU_ORDER_LIMIT_ORDER_INVALID = "价格输入有误，请重新输入";
		
		//实盘组合撤单
		public static final String SAVE_PTF_WITHDRAW_NO_WITHDRAWABLE = "委托已全部结束，无法撤销";
		
		//模拟组合撤单
		public static final String SAVE_SIMU_PTF_WITHDRAW_ALL_DEALED = "该笔委托已全部成交，无法撤销";
		
		//更新组合信息
		public static final String UPDATE_PTFINFO_AT_LEAST_ONE_FRIEND = "对部分好友可见，请至少选择一位好友哦";
		public static final String UPDATE_PTFINFO_CANNOT_BE_PRIVATE = "组合已有好友跟单，不能将权限设为仅自己可见哦";
		public static final String UPDATE_PTFINFO_CANNOT_BE_PRIVATE_FOR_IN_SALE = "组合已有客户购买，不能将权限设为仅自己可见哦";
		public static final String UPDATE_PTFINFO_CANNOT_HIDE_FROM_FOLLOWER = "当前有好友跟单，无法取消TA的查看权限";
		public static final String UPDATE_PTFINFO_CANNOT_HIDE_FROM_FOLLOWER_FOR_IN_SALE = "有购买的客户，无法取消TA的查看权限";
		public static final String UPDATE_PTFINFO_NAME_DUBLICATED = "您已经有相同名称的组合，换一个吧";
		public static final String UPDATE_PTFINFO_NAME_EMPTY = "组合名称不能为空";
		public static final String UPDATE_PTFINFO_NAME_NOT_SUPPORT_CHAR = "组合名称不能包含字符$";
		
		//券商端持仓创建组合
		public static final String SAVE_AND_CREATE_PTF_FRM_BRK_STK_COUNT_LIMIT = "组合内股票数量不能超过{0}支";
		public static final String SAVE_AND_CREATE_PTF_FRM_BRK_STK_NAME_DUBLICATED = "您已经有相同名称的组合，换一个吧";
		public static final String SAVE_AND_CREATE_PTF_FRM_BRK_STK_NOT_TRADE_DAY = "当前非交易日，无法从券商端持仓创建组合哦";
		public static final String SAVE_AND_CREATE_PTF_FRM_BRK_NOT_SUPPORT_CHAR = "组合名称不能包含字符$";
		public static final String SAVE_AND_CREATE_PTF_FRM_BRK_ALREAD_EXIST = "该券商对应的组合已存在！";
	}
	
	
	/**
	 * 客户端需要特殊处理的错误码对应的错误信息。非888
	 */
	public static final class CordinateDspMsg{
		
		/**
		 * 交易时间错误 TRADE_TIME_ERROR
		 */
		public static final String TRADE_TIME_ERROR_SIMU_TRADE_TIME_LIMIT = "很抱歉，系统正在清算中，您可以在17点后再来尝试";
		public static final String TRADE_TIME_ERROR_REAL_TRADE_TIME_LIMIT = "很抱歉，现在已收市，您可以在下一交易日（{0}月{1}日）再来交易";
		
		/**
		 * FOLLOW_NOT_CHANGED
		 */
		public static final String FOLLOW_CHECK_UNCHANGED_WITHOUT_WARN = "此次跟单无需操作，已完成，请忽略本次跟单吧";
//		public static final String FOLLOW_CHECK_UNCHANGED_WITH_WARN = "由于上述原因暂无可用调整哦";
		
		/**
		 * BROKER_CUST_INVALID
		 */
		public static final String BROKER_CUST_INVALID_USE_ORIGN_ID = "您已关联国信证券账户，请使用原账户登录";
		
		
		

	}
	
	/**
	 *	接口中定义返回的信息 
	 */
	public static final class InterfaceMessage{
		//组合买入预检
		public static final String CHECK_REAL_BUY_TRANS_RSTMSGS = "组合有未完成的交易，此时买入可能会和管理人的比例不一致";
		public static final String CHECK_REAL_BUY_TRANS_STKS_MSG_ONE = "已在 {0} 持仓";
		public static final String CHECK_REAL_BUY_TRANS_STKS_MSG_ONE_OUT = "{0} 已在您的其他实盘组合中，无法添加到当前组合";
		public static final String CHECK_REAL_BUY_TRANS_STKS_MSG_TWO = "已在其它渠道买入";
		public static final String CHECK_REAL_BUY_TRANS_STKS_MSG_TWO_OUT = "{0} 在您的券商账户中已持仓，委托提交后该部分持仓将被纳入组合中";
		
		//实盘组合新增股票预检
//		public static final String CHECK_ADD_STK_TRANS_RSTMSGS_ALREADY_IN_PTF = "{0},已存在当前组合请调仓";
		public static final String CHECK_ADD_STK_TRANS_RSTMSGS_HODING_IN_OTHER_PTF = "{0} 已在您的其他实盘组合中，无法添加到当前组合";
		public static final String CHECK_ADD_STK_TRANS_RSTMSGS_HODING_IN_BROKER = "{0} 在您的券商账户中已持仓，委托提交后该部分持仓将被纳入组合中";
		public static final String CHECK_ADD_STK_TRANS_RSTMSGS_DELITING = "{0} 已退市，无法添加到当前组合";
		public static final String CHECK_ADD_STK_TRANS_RSTMSGS_DURING_IPO = "{0} 还未上市，无法添加到当前组合";
		
		//跟单预检
		public static final String FOLLOW_CHECK_RSTMSGS_QUOT_NOT_FOUND = "{0}未查到对应行情";
//		public static final String FOLLOW_CHECK_RSTMSGS_IN_OTHER_PTF_SUMMARY = "{0} 已在您的其他实盘组合中，无法添加到当前组合";
		public static final String FOLLOW_CHECK_RSTMSGS_IN_OTHER_PTF_DETAIL = "{0} 已在 {1} 中持仓，不能在当前组合中调整";
//		public static final String FOLLOW_CHECK_RSTMSGS_IN_BROKER = "{0} 在您的券商账户中已持仓，委托提交后该部分持仓将被纳入组合中";
		public static final String FOLLOW_CHECK_RSTMSGS_CANT_SELL_TODAY = "当日买入的{0}无法当日卖出";
		public static final String FOLLOW_CHECK_RSTMSGS_NO_NEED_TO_CHANGE_BUY= "{0}需要买入的数量不足100股，无需调整";
		public static final String FOLLOW_CHECK_RSTMSGS_NO_NEED_TO_CHANGE_SELL= "{0}需要卖出的数量不足100股，无需调整";
//		public static final String FOLLOW_CHECK_RSTMSGS_CHANGE_RATE_TOO_SMALL= "{0}需要变更的比例不足5%，无需调整";
	
		//委托属性预检
		public static final String CHECK_ORD_PROP_NOT_CONTINUOUS_BIDING_TIME_FOR_ALLS = "9:30开市前，交易所仅接受限价委托";
		public static final String CHECK_ORD_PROP_PRE_ORDER_FOR_ALLS = "收盘后，券商仅接受限价委托";
		public static final String CHECK_ORD_PROP_PRE_ORDER_BEFORE_630_FOR_ALLS = "15:00至18:30期间的委托可能失败";
		public static final String CHECK_ORD_PROP_LISTING_STKS = "上市首日的股票，交易所仅接受限价委托";
		public static final String CHECK_ORD_PROP_ST_STKS = "沪市ST股票，交易所仅接受限价委托";
		public static final String CHECK_ORD_PROP_LISTING_ST_STKS = "上市首日的股票和沪市ST股票，仅接受限价委托";
		public static final String CHECK_ORD_PROP_NOT_CONTINUOUS_BIDING_TIME_FOR_SZ = "14:57-15:00集合竞价期间，深交所仅接受限价委托";
		public static final String CHECK_ORD_PROP_NOT_CONTINUOUS_BIDING_TIME_FOR_SZ_LISTING_STKS = "14:57~15:00集合竞价期间,深交所仅接受限价委托\n上市首日的股票，仅接受限价委托";
		public static final String CHECK_ORD_PROP_NOT_CONTINUOUS_BIDING_TIME_FOR_SZ_ST_STKS = "14:57-15:00集合竞价期间，深交所仅接受限价委托\n沪市ST股票，仅接受限价委托";
		public static final String CHECK_ORD_PROP_NOT_CONTINUOUS_BIDING_TIME_FOR_SZ_LISTING_ST_STKS = "14:57-15:00集合竞价期间，深交所仅接受限价委托\n上市首日的股票和沪市ST股票，仅接受限价委托";		
		
		//券商端创建组合预检
		public static final String CHECK_CRT_PTF_FROM_BRK_CANNOT_CREATE= "很抱歉！节假日期间暂时不能将持仓创建为组合，请在下一个工作日({0}月{1}日)再来创建";
		
		//组合撤单
		public static final String PTF_WITHDRAW_STK_WITHDRAW_FAILED= "{1} 撤单失败【{2}】";
		public static final String PTF_WITHDRAW_ALL_EXCEPTION= "所有委托撤单异常";
		public static final String PTF_WITHDRAW_ALL_FAILED= "所有委托撤单失败【{1}】";
		
	}
	
	
	
	
	
	
}
