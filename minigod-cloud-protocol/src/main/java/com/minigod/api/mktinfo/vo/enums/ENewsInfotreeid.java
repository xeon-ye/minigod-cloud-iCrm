/**
 * @Title: NewsEnums.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.enums;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-7-20 上午9:45:38
 * @version v1.0
 */

public enum ENewsInfotreeid {

	QQ_HK_DHYB("大行研报", 1), //
	QQ_HK_ZB("直播", 2), //
	QQ_HK_JGYB("机构研报", 3), //
	QQ_HK_GGZL("港股专栏", 4), //
	QQ_HK_LZZX("论证咨询", 5), //

	QQ_US_MGXW("美股新闻", 101), //
	QQ_US_GNG("中国概念股", 102), //
	QQ_US_FXPL("分析评论", 103), //
	QQ_US_PMBD("盘面报道", 104), //
	QQ_US_GDXW("滚动新闻", 105),//
	QQ_US_MGKT("美股课堂", 106); //

	private String typeName;
	private int typeValue;

	private ENewsInfotreeid(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public int getTypeValue() {
		return this.typeValue;
	}

	public String getTypeName() {
		return typeName;
	}

}
