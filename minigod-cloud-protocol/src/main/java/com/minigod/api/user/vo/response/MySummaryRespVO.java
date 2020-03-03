/**
 * @Title: MySummaryRespVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import java.io.Serializable;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2016-1-20 下午3:01:39
 * @version v1.0
 */

public class MySummaryRespVO implements Serializable {
	private static final long serialVersionUID = -891024197335501238L;
	private String couponUnread;// 是否存在未读的卡券信息 Y/N
	private Integer couponNum; // 未使用的卡券数量
	private String yesterdayProfit; // 昨日收益 exception:“1.5”表示1.5元

	public String getCouponUnread() {
		return couponUnread;
	}

	public void setCouponUnread(String couponUnread) {
		this.couponUnread = couponUnread;
	}

	public Integer getCouponNum() {
		return couponNum;
	}

	public void setCouponNum(Integer couponNum) {
		this.couponNum = couponNum;
	}

	public String getYesterdayProfit() {
		return yesterdayProfit;
	}

	public void setYesterdayProfit(String yesterdayProfit) {
		this.yesterdayProfit = yesterdayProfit;
	}
}
