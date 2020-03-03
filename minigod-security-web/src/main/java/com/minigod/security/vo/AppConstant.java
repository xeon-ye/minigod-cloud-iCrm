package com.minigod.security.vo;

public class AppConstant {
	/** 翻卡次数redis的key **/
	public static final String CARD_LUCK_DRAW_COUNT_KEY = "adCardDrawKey";
	/** 翻卡次数redis的有效时间 一个月 **/
	public static final int CARD_LUCK_DRAW_COUNT_TIME = 60 * 60 * 24 * 30;
	/** 红包redis的key **/
	public static final String AD_RED_POOL_KEY = "adRedPoolKey";
	/** 红包奖池redis的有效时间 2天 **/
	public static final int AD_RED_POOL_TIME = 60 * 60 * 24 * 2;
	/** 分享活动得卡牌redis的有效时间 2天 **/
	public static final int AD_SHARE_TIME = 60 * 60 * 24 * 2;
	/** 2元红包 **/
	public static final String luck2 = "luck2";
	/** 5元红包 **/
	public static final String luck5 = "luck5";
	/** 10元红包 **/
	public static final String luck10 = "luck10";
	/** webApp定时器模块名  **/
	public static final String WEBAPP_MODULE_NAME = "webapp";
	/** pk大盘结果定时器 **/
	public static final String AD_PK_STATUS_JOB = "adPkStatusJob";
	/** 奖池发放 **/
	public static final String AD_LUCK_POOLS_JOB = "adLuckPoolsJob";
	/** 股神来了开盘任务 **/
	public static final String GS_MARKET_OPEN_JOB = "gsMarketOpenJob";
	/** 股神来了收盘任务 **/
	public static final String GS_MARKET_CLOSE_JOB = "gsMarketCloseJob";
	/** 股神来了人数未满提醒任务 **/
	public static final String GS_GAME_EXPIRETIME_JOB = "gsGameExpireTimeJob";
	/** 股神来了成交价任务 **/
	public static final String GS_CFM_PRICE_JOB = "gsCfmPriceJob";
	/** 股神来了用户累计收益率任务 **/
	public static final String GS_USER_TOTAL_YIELD = "gsUserTotalYield";
	/**一战到底开盘任务 **/
	public static final String GAMEFIGHT_MARKET_OPEN_JOB = "gameFightMarketOpenJob";
	/**一战到底收盘任务 **/
	public static final String GAMEFIGHT_MARKET_CLOSE_JOB = "gameFightMarketCloseJob";
	/**一战到底收盘任务--统计数据用 **/
	public static final String GAMEFIGHT_MARKET_CLOSE_STATISTICS_JOB = "gameFightMarketCloseStatisticsJob";
	/**一战到底开盘提醒任务 **/
	public static final String GAMEFIGHT_EXPIRE_TIME_SEND_JOB = "gameFightExpireTimeSendJob";
	/**一战到底收盘结果提醒任务 **/
	public static final String GAMEFIGHT_MARKET_CLOSE_RESULT_SEND_JOB = "gameFightMarketCloseResultSendJob";
	/**一战到底收盘赛程结束提醒任务 **/
	public static final String GAMEFIGHT_MARKET_EVENTEND_SEND_JOB = "gameFightMarketEventEndSendJob";
	/**开户调度任务，调用bpm接口**/
	public static final String OPEN_ACCOUNT_TIME_JOB = "openAccountTimeJob";
	/**中银子账号过期做失效处理**/
	public static final String SUB_ACCOUNT_EXPIRE_JOB = "SubAccountExpireJob";

	/**	交易日期redis的key **/
	public static final String TRD_DAYINFO_COUNT_KEY = "gs_trdDayInfoCountKey";

	public static final String TRD_DAYINFO_KEY = "gs_trdDayInfoKey";

	public static final String KEY_SEQ = "_";
	/** 股神来了推荐胜率key **/
	public static final String GS_GAME_PRO_KEY = "gs_gameProKey";
	/** 有效时间一天 */
	public static final int VALID_ONE_DAY = 60 * 60 * 24;
	/** 每天参与荐股的个数 **/
	public static final int GAME_STK_DAY_COUNT = 5;
	/** 每天参与荐股的次数超过5个错误码 **/
	public static final int GAME_STK_DAY_COUNT_ERROR_CODE = 1001;
	/** 每天参与荐股的次数超过5个提示信息 **/
	public static final String GAME_STK_DAY_COUNT_ERROR_MSG = "每天限5场哦，明天再来吧";
	/** 参数人数的判断错误码 **/
	public static final int GAME_LIMIT_NUM_FULL_CODE = 1002;
	/** 参数人数的判断提示信息 **/
	public static final String GAME_LIMIT_NUM_FULL_MSG = "塞不下更多人了，亲";
	/** 参数时间判断错误码 **/
	public static final int GAME_EVENT_START_TIME_CODE = 1003;
	/** 参数时间判断提示信息 **/
	public static final String GAME_EVENT_START_TIME_MSG = "来晚一步，比赛开始咯";
	/** 已参赛错误码 **/
	public static final int GAME_EVENT_HAS_JOIN_CODE = 1004;
	/** 已参赛提示信息 **/
	public static final String GAME_EVENT_HAS_JOIN_MSG = "你已参赛";
	/** 参数人数少于3人错误码 **/
	public static final int GAME_EVENT_LIMIT_NUM_CODE = 1005;
	/** 参数人数少于3人提示信息 **/
	public static final String GAME_EVENT_LIMIT_NUM_MSG = "参数人数不能少于3人哦";
	/** 赛事开始时间已过期错误码 **/
	public static final int GAME_EVENT_START_TIME_OUT_CODE = 1006;
	/** 赛事开始时间已过期提示信息 **/
	public static final String GAME_EVENT_START_TIME_OUT_MSG = "赛事开始时间已过，请刷新重试";
	/** 此股票已荐错误码 **/
	public static final int GAME_EVENT_ASSETID_EXIST = 1007;
	/** 此股票已荐提示信息 **/
	public static final String GAME_EVENT_ASSETID_EXIST_MSG = "您的股票有人推荐了呢，换一只吧！";

	public static final String GAME_ACC_BALANCE_NOT_ENOUGH = "账户资金不足";
	/** 排名第一 **/
	public static final Integer RANK_FIRST = 1;
	/** 股神来了sessionUserId **/
	public static String  SESSION_USER_ID = "weixin_session_userId";
	/** 一战到底sessionUserId **/
	public static String  FIGHT_SESSION_USER_ID = "fight_weixin_session_userId";

	public static String  H5_SESSION_USER_ID = "h5_session_userId";// session用户id
	public static String  H5_SESSION_SOURCE_ID = "h5_session_sourceId";// session来源ID

	public static String  APP_SESSION_USER_ID = "app_session_userId";// session用户id
	public static String  APP_SESSION_ID = "app_session_id";// session id

	public static String IPO_TRADE_CHECK = "ipo_trade_check";


	/** 交易来源 **/
	public static String TRANS_SOURCE_IOS ="ios";
	public static String TRANS_SOURCE_ANDROID ="android";
	public static String TRANS_SOURCE_H5 = "h5";


	/** token 存在redis的key **/
	public static String WEIXIN_TOKEN_KEY = "weixin_token_key_";
	/** token 的过期时间1个小时  **/
	public static int WEIXIN_TOKEN_TIME = 60 * 60;

	public static String NEWS_DETAIL_NO_DATA = "这篇新闻飞走了，再去看看其他的吧";

	public static String OAUTH_BASE_TYPE = "base";

	public static String OAUTH_USERINFO_TYPE = "userInfo";

	public static String SHARE_TYPE = "share_type";

	public static String ENTRY_TYPE = "entry_type";

	public static String FIGHT_ENTRY_TYPE = "fight_entry_type";

	public static String FIGHT_SHARE_TYPE = "fight_SHARE_type";

	public static String GAME_ADVISER = "game_adviser";

	public static String SYS_CONFIG_BONUSAMOUNT = "bonus";

	/** 流米流量token 存在redis的key **/
	public static String LIUMI_TOKEN_KEY = "liumi_token_key";
	/** 流米流量token 存在redis的有效时间 **/
	public static int LIUMI_TOKEN_TIME_OUT = 12 * 60 * 60;
	/** 邀请新人的奖励redis的key **/
	public static String INVITE_NEW_USER_AWARD_KEY = "invite_new_user_award_";
	/** 邀请新人的奖励 存在redis的有效时间 **/
	public static int INVITE_NEW_USER_AWARD_TIME_OUT = 60 * 2;

	//二维码图片命名前缀
	public static String IMG_BASE_NAME = "open_";

	//二维码图片目标
	public static String  QRCODE_BASE_PATH="/webstatic/upload/qrcode/";

	public static String  SESSION_ADD_FRIEND_WEIXIN_INFO = "session_add_friend_weixin_info";// session中微信信息

	public static class DF {
		/** 分割符号为'-' */
		public static final String YYYY_MM_DD = "yyyy-MM-dd";

		public static final String YYYYMMDD = "yyyyMMdd";
		/** 分割符号为'：' */
		public static final String HH_MM_SS = "HH:mm:ss";
		/** 年份分隔符号为'-', 时间分隔符为'：' */
		public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
		/** 年月 */
		public static final String MM_DD = "MM-dd";
	}

	public static class SecType {
		/** 股票 */
		public static final int STK = 1;
		/** 债券 */
		public static final int BOND = 2;
		/** 基金 */
		public static final int FUND = 3;
		/** 权证 */
		public static final int SHR_WARRANT = 4;
		/** 指数 */
		public static final int IDX = 5;
	}

	// 用户凭证
	public static final String ACCESS_TOKEN = "access_token";

	// 用户手机号
	public static final String USER_MOBILE = "user_mobile";

}
