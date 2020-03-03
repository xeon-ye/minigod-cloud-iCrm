/**
 * @Title: EFunctionID.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.rtpushserver.vo.enums;

/**
 * <code>EFunctionId</code> !!注意此类不能随意修改
 * 
 * @author Jimmy
 * @date 2015-7-8 下午7:27:44
 * @version v1.0
 */

public class EFunctionId {
	public static final int HEARBEAT = 0; // 心跳
	public static final int LOGIN = 1; // 登录验证
	public static final int RTQUOTATION = 2; // A股/港股 实时行情推送
	public static final int ASKBID5 = 3; // A股买卖五档
	public static final int TIMESHARING = 4; // A股/港股 分时
	public static final int CMFDETAIL = 5; // A股成交明细
	public static final int IDXRTQUOTATION = 6; // A股/港股 指数实时行情推送
	public static final int FUNDRTQUOTATION = 7; //A股/港股 基金实时行情推送
	public static final int QUOTCLEANQUOTATION = 8; // A股 清盘通知
	public static final int DISHBASEPRICE = 9; // A股/港股 推送大图盘口基础价格数据
	public static final int OPTIONSTOCKRTQUOTATION = 10; // 自选股实时行情推送 xiongpan , A股与H股共用
	public static final int CONCEPTPUSH = 11; // A股/港股 概念数据的推送
	public static final int INDUSTRYPUSH = 12; // A股/港股 行业数据的推送
	public static final int HOTSTK = 13; // A股/港股 热门个股
	public static final int MKTIDX = 14; // A股/港股 市场页面的指数
	public static final int MARKETINDEX = 15; // A股/港股 市场首页汇总接口
	public static final int PORTFOLIOQUOTATION = 16; // 自选组合实时推送 AngelaTao
	public static final int ASKBID10 = 17; // 港股买卖十档
	public static final int HKEX_BROKER_QUEUEU_PDATED = 18; // 经纪队列数据推送
	public static final int QUOTCLEANQUOTATION_HK = 19;// 港股清盘通知
	public static final int QUOTCLEANQUOTATION_US = 20;// 美股清盘通知
	public static final int ASKBID1 = 21;// 1当
	public static final int ONLINEQUOTE = 99;// 行情session离线推送
	public static final int EXPIREQUOTE = 98;// 行情session过期推送
	
	public static final int TRADE_TICKER = 97; // 分笔成交
	public static final int ENTRUST_TRADE = 96; // 委托成交
	
	public static final int UPCHANGEPCTPUSH=22;//涨幅榜
	public static final int DOWNCHANGEPCTPUSH=23;//跌幅榜
	public static final int TURNRATEPUSH=24;//换手率推送
	public static final int AMPLITUDEPUSH=25;//振幅榜
	
	// 沪港通
	public static final int HGT_BALANCE = 70; // 沪股通余额：HK2SH余额、百分比、SH2HK余额、百分比
	public static final int HGT_TOP = 71; // 沪股通TOP：股票代码、名称、价格、涨跌百分比
	public static final int HGT_GGT = 72; // 港股通（沪）TOP：同上
	public static final int HGT_AH = 73; // AH股（沪）TOP：A股票代码、价格、涨跌百分比、H股代码、名称、价格、涨跌百分比、溢价
	// 深港通
	public static final int SGT_BALANCE = 74; // 深股通余额
	public static final int SGT_TOP = 75; // 沪股通TOP
	public static final int SGT_GGT = 76; // 港股通（沪）TOP
	public static final int SGT_AH = 77; // AH股（沪）TOP
	
	// 分钟线
	public static final int MINUTE1=30;//1分钟K线
	public static final int MINUTE5=31;//5分钟K线
	public static final int MINUTE15=32;//15分钟K线
	public static final int MINUTE30=33;//30分钟K线
	public static final int MINUTE60=34;//60分钟K线
	
	// 将来代码区间划分：100-199A股，200-299港股，300-399美股
	// 市场首页（港股）
	public static final int MKT_HK_INDEX = 200; // 首页的指数
	public static final int MKT_HK_INDU = 201; // 领涨行业
	public static final int MKT_HK_TOP = 202; // 龙虎榜
	public static final int MKT_HK_GEM = 203; // 创业板
	public static final int MKT_HK_MAIN = 204; // 主板
	// 市场首页（美股）
	public static final int MKT_US_INDEX = 300; // 首页的几支指数（股票）
	public static final int MKT_US_TOP = 301; // 龙虎榜
	public static final int MKT_US_ZH = 302; // 中概股
	public static final int MKT_US_HOT = 303; // 热门股
	public static final int MKT_US_TECH = 304; // 科技股
	
}
