/**
 * @Title: OfficialViewpointNumRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.official.vo.response;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-23 上午11:28:15
 * @version v1.0
 */

public class OfficialViewpointNumRespVO  implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer totalNum; // 全部条数
	private Integer todayNum; // 今日条数
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getTodayNum() {
		return todayNum;
	}
	public void setTodayNum(Integer todayNum) {
		this.todayNum = todayNum;
	}
}
