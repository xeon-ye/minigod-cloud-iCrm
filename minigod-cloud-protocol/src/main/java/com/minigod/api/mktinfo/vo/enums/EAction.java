/**
 * @Title: ERedisChannelAction.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.enums;

/**
 * @description 主要用户redis pub/sub, 订阅者与发布者的信息的交互
 *
 * @author Jimmy
 * @date 2015-12-7 下午3:19:48
 * @version v1.0
 */

public enum EAction {
	ACLEAN, // A股清盘
	HCLEAN, // H股清盘
	PTFCLEAN, // 组合清盘
	PTFQUOT, // 组合行情更新
	SUBSCRIBE, // 订阅
	UNSUBSCRIBE, // 取消订阅
	STKHEAT , // 个股热度
	AQUOTUPDATED, // A股行情更新
	HQUOTUPDATED, // H股行情更新
	SH_TRADETICKER_UPDATED, // 上交所分笔更新
	SZ_TRADETICKER_UPDATED, // 深交所分笔更新
	/**
	 * Added by CaiJianbo
	 */
	HKEXCLEAN,    //港股清盘
	HKEXQUOTUPDATED, //港股行情更新
	HKEX_DELAY_QUOT_UPDATED,
	HKEX_BROKER_QUEUEU_PDATED, //港股经纪队列更新
	HKEX_TRADETICKER_UPDATED, // 港股分笔更新

	USEXCLEAN, //美股清盘
	USEXQUOTUPDATED, //美股行情更新
	US_TRADETICKER_UPDATED, // 美股分笔更新

	SH_TIMESHARING_UPDATED,
	SZ_TIMESHARING_UPDATED,
	HK_TIMESHARING_UPDATED,
	US_TIMESHARING_UPDATED,
	
	// 沪港通
	XHK_BALANCE, // 港股通余额
	HGT_TOP, // 沪股通TOP
	HGT_GGT, // 港股通（沪）TOP
	HGT_AH, // AH股（沪）TOP
	// 深港通
	SGT_TOP, // 沪股通TOP
	SGT_GGT, // 港股通（沪）TOP
	SGT_AH, // AH股（沪）TOP
	
	/**
	 * 1分钟
	 */
	Minute1,
	/**
	 * 5分钟
	 */
	Minute5,
	/**
	 * 15分钟
	 */
	Minute15,
	/**
	 * 30分钟
	 */
	Minute30,
	/**
	 * 60分钟
	 */
	Minute60,
	
	// 市场首页（港股）
	HK_INDEX_UPDATE, // 港股首页指数更新
	HK_INDU_UPDATED, // 港股行业更新
	HK_TOP_UPDATED, // 港股龙虎榜更新
	HK_TOP_GEM_UPDATE, // 港股创业板更新
	HK_TOP_MAIN_UPDATE, // 港股主板更新
	// 市场首页（美股）
	US_INDEX_UPDATE, // 美股首页指数更新
	TRADE, // 成交推送
}
