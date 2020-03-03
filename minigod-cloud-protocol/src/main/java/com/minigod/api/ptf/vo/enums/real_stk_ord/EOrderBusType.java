/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.real_stk_ord;

/**
 * @description 个股委托业务类别
 *
 * @author minigod
 * @date 2015-3-17
 * @version v1.0
 */

public enum EOrderBusType {
	W("撤单", "W"),
	MTV("议案投票", "MTV"),
	ETFP("ETF申购", "ETFP"),
	ETFR("ETF赎回", "ETFR"),
	FP("基金申购", "FP"),
	FR("基金赎回", "FR"),
	FB("基金认购", "FB"),
	DW("分红方式", "DW"),
	FE("认购行权", "FE"),
	PTE("认沽行权", "PTE"),
	CE("现金行权", "CE"),
	TCT("全转托管", "TCT"),
	B("证券买入", "B"),
	NS("网下股票认购", "NS"),
	SP("定价申购", "SP"),
	BTPR("解除预受", "BTPR"),
	BP("竞价申购", "BP"),
	TS("转股", "TS"),
	BTTS("回售", "BTTS"),
	TNCS("网上现金认购", "TNCS"),
	PFA("配股缴款", "PFA"),
	OFCS("网下现金认购", "OFCS"),
	GUP("放弃缴款", "GUP"),
	TBF("买断融资", "TBF"),
	TBS("买断融券", "TBS"),
	TPOP("配售申购", "TPOP"),
	MQ("融券", "MQ"),
	FS("融资", "FS"),
	PC("配售缴款", "PC"),
	TSC("指定交易", "TSC"),
	RTS("解除指定", "RTS"),
	TRS("回购指定", "TRS"),
	RR("回购解除", "RR"),
	PAO("预受要约", "PAO"),
	CT("转托管", "CT"),
	FT("基金转换", "FT"),
	WC("权证创设", "WC"),
	WD("权证注销", "WD"),
	ITM("入质", "ITM"),
	AM("出质", "AM"),
	TLB("转限买入", "TLB"),
	TLS("转限卖出", "TLS"),
	CC("担保品划入", "CC"),
	CD("担保品划出", "CD"),
	SR("自营转融券", "SR"),
	MTS("融券转自营", "MTS"),
	BAC("现券还券", "BAC"),
	TTSS("余券划转", "TTSS"),
	S("证券卖出", "S"),
	ITB("意向买", "ITB"),
	ITS("意向卖", "ITS"),
	PB("定价买", "PB"),
	PS("定价卖", "PS"),
	CB("确认买", "CB"),
	CS("确认卖", "CS"),
	TIP("国债发行买入", "TIP"),
	TIS("国债预发行卖出", "TIS"),
	TIRT("约定购回初始交易", "TIRT"),
	ARRT("约定购回购回交易", "ARRT"),
	ATB("协议交易买入", "ATB"),
	ATS("协议交易卖出", "ATS"),
	BD("债券分销", "BD"),
	JB("金天利买入", "JB"),
	JR("金天利续约", "JR"),
	JTET("金天利提前终止", "JTET"),
	OE("期权行权", "OE"),
	JTIM("金天利入质", "JTIM"),
	JP("金天利出质", "JP"),
	FIPM("固定收益平台入质", "FIPM"),
	FIPP("固定收益平台出质", "FIPP"),
	FICM("固定收益客户入质", "FICM"),
	FICQ("固定收益客户出质", "FICQ"),
	ROTF("基金拆分", "ROTF"),
	FM("基金合并", "FM"),
	ZFR("融资购回", "ZFR"),
	ZSR("融券购回", "ZSR"),
	BPB("竞价限价买入", "BPB"),
	BPS("竞价限价卖出", "BPS"),
	ELPB("增强限价买入", "ELPB"),
	ELPS("增强限价卖出", "ELPS"),
	ZLPB("零股限价卖出", "ZLPB"),
	UNKNOWN("未知", "UNKNOW");
	
	private String typeName;
	private String typeValue;

	private EOrderBusType(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public String getTypeValue() {
		return this.typeValue;
	}
	
	public String getTypeName() {
		return this.typeName;
	}

}
