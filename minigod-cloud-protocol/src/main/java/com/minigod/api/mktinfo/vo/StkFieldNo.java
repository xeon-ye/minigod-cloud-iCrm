package com.minigod.api.mktinfo.vo;

/**
 * <code>StkFieldNo</code>
 * 
 * @author Jimmy
 * @date 2015-7-1 下午1:51:31
 * @version v1.0
 */

public class StkFieldNo {
	public static final int ASSETID = 0; // 资产ID
	public static final int NAME = 1; // 资产名称
	public static final int PRICE = 2; // 现价
	public static final int HIGH = 3; // 最高
	public static final int LOW = 4; // 最低
	public static final int OPEN = 5; // 开盘价
	public static final int PRECLOSE = 6; // 昨收价
	public static final int TURNOVER = 7; // 成交额
	public static final int VOLUME = 8; // 成交量
	public static final int CHANGE = 9; // 涨跌
	public static final int CHANGEPCT = 10; // 涨跌幅
	public static final int COMMITTEE = 11; // 委比
	public static final int VOLRATE = 12; // 量比
	public static final int LIMITUP = 13; // 涨停价
	public static final int LIMITDOWN = 14; // 跌停价
	public static final int TS = 15; // 时间戳
	public static final int ASK5 = 16; // 卖价5
	public static final int ASK4 = 17; // 卖价4
	public static final int ASK3 = 18; // 卖价5
	public static final int ASK2 = 19; // 卖价2
	public static final int ASK1 = 20; // 卖价1
	public static final int ASKQTY5 = 21; // 卖量5
	public static final int ASKQTY4 = 22; // 卖量4
	public static final int ASKQTY3 = 23; // 卖量3
	public static final int ASKQTY2 = 24; // 卖量2
	public static final int ASKQTY1 = 25; // 卖量1
	public static final int BID1 = 26; // 买价1
	public static final int BID2 = 27; // 买价2
	public static final int BID3 = 28; // 买价3
	public static final int BID4 = 29; // 买价4
	public static final int BID5 = 30; // 买价5
	public static final int BIDQTY1 = 31; // 买量1
	public static final int BIDQTY2 = 32; // 买量2
	public static final int BIDQTY3 = 33; // 买量3
	public static final int BIDQTY4 = 34; // 买量4
	public static final int BIDQTY5 = 35; // 买量5
	public static final int STYPE = 36; // 证券子类别
	public static final int TURNRATE = 37; // 换手率
	public static final int TOTALVAL = 38; // 总市值
	public static final int PE = 39; // 市盈率
	public static final int PB = 40; // 市净率
	public static final int FMKTVAL = 41; // 流通市值
	public static final int STATUS = 42; // 股票状态
	public static final int UPNUMS = 43; // 涨家数
	public static final int EVENNUMS = 44;// 平家数
	public static final int DOWNNUMS = 45; // 跌家数
	public static final int NETVALUE = 46; // 单位净值
	public static final int TOTALNETVALUE = 47; // 累计净值
	public static final int PREMIUMRATE = 48; // 溢价率
	public static final int LISTINGDATE = 49; // 成立日期

	public static final int BID6 = 50; // 买价6
	public static final int BID7 = 51; // 买价7
	public static final int BID8 = 52; // 买价8
	public static final int BID9 = 53; // 买价9
	public static final int BID10 = 54; // 买价10
	public static final int BIDQTY6 = 55; // 买量6
	public static final int BIDQTY7 = 56; // 买量7
	public static final int BIDQTY8 = 57; // 买量8
	public static final int BIDQTY9 = 58; // 买量9
	public static final int BIDQTY10 = 59; // 买量10
	public static final int ASK10 = 60; // 卖价10
	public static final int ASK9 = 61; // 卖价9
	public static final int ASK8 = 62; // 卖价8
	public static final int ASK7 = 63; // 卖价7
	public static final int ASK6 = 64; // 卖价6
	public static final int ASKQTY10 = 65; // 卖量10
	public static final int ASKQTY9 = 66; // 卖量9
	public static final int ASKQTY8 = 67; // 卖量8
	public static final int ASKQTY7 = 68; // 卖量7
	public static final int ASKQTY6 = 69; // 卖量6

	// add by jiangbin
	public static final int DIVYLD = 70; // 周息率 dividend yield
	public static final int WEEK52HIGH = 71; // 52周最高
	public static final int WEEK52LOW = 72; //52周最低


	//十档 买入排队数量
	public static final int B1ORDERCOUNT = 73;
	public static final int B2ORDERCOUNT = 74;
	public static final int Bb3ORDERCOUNT = 75;
	public static final int B4ORDERCOUNT = 76;
	public static final int B5ORDERCOUNT = 77;
	public static final int B6ORDERCOUNT = 78;
	public static final int B7ORDERCOUNT = 79;
	public static final int B8ORDERCOUNT = 80;
	public static final int B9ORDERCOUNT = 81;
	public static final int B10ORDERCOUNT = 82;

	//十档 卖出排队数量
	public static final int S1ORDERCOUNT = 83;
	public static final int S2ORDERCOUNT = 84;
	public static final int S3ORDERCOUNT = 85;
	public static final int S4ORDERCOUNT = 86;
	public static final int S5ORDERCOUNT = 87;
	public static final int S6ORDERCOUNT = 88;
	public static final int S7ORDERCOUNT = 89;
	public static final int S8ORDERCOUNT = 90;
	public static final int S9ORDERCOUNT = 91;
	public static final int S10ORDERCOUNT = 92;

	//为模拟炒股增加的返回字段
	public static final int SPELLINGABBR  = 100; //拼音简称 spelling_abbr
	public static final int TOTAL          = 101; //总股本 total
	public static final int FLSHR          = 102; //流通股份fl_shr
	public static final int TRNP           = 103; // 净利润tr_np
	public static final int BPS            = 104; //每股净资产 bps
	public static final int LOTSIZE        = 105; //单位交易量即每手股数lot_size

	public static final int TIME           = 106; //时间
	public static final int TIMENO         = 107; //时间节点序号
	public static final int AMPLITUDE      = 108; //振幅

	public static final int COMMISSIONBUYVOL  = 109; //委买数量
	public static final int COMMISSIONSELLVOL = 110; //委卖数量
	public static final int BROKERQUEUE        = 111; //经纪席位
	public static final int MONEYTYPE          = 112; //币种

	public static final int TIMEZONE        =  113; //美国时区

	public static final int STRIKELLEVEL        =  124; //行使价
	public static final int ENTITLEMENTRATIO    =  125; //换股比率
	public static final int ISSUESIZE            =  126; //发行量
	public static final int OSRATIO              =  127; //街货比
	public static final int CALLLEVEL            =  128; //回收价
	public static final int DELTA                 =  129; //对冲值
	public static final int IV                     =  130; //引申波幅
	public static final int MATURITY              = 131; //到期日


	public static final int OPENTSTIME             = 132; //开盘时间
	public static final int CLOSETSTIME            = 133; //收盘时间

	public static final int HISHIGH	= 134; // 历史最高
	public static final int HISLOW	= 135; // 历史最低
	public static final int AVGPRICE = 136; // 平均价
	
	public static final int LEVERAGE = 137; // 有效杠杆
	public static final int LEVERAGERATIO = 138; // 杠杆比例
	
	public static final int EPSP=139;//收益

}
