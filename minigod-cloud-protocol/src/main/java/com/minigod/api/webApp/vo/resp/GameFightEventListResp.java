/**
 * @Title: GameFightEventListResp.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author panlz
 * @date 2016-01-18 下午5:17:02
 * @version v1.0
 */

@TransferBean
public class GameFightEventListResp implements Serializable {
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<GamefightEventResp> datas;

	public List<GamefightEventResp> getDatas() {
		return datas;
	}

	public void setDatas(List<GamefightEventResp> datas) {
		this.datas = datas;
	}

	@TransferBean
	public static class GamefightEventResp implements Serializable {
		private static final long serialVersionUID = 1L;
		@TransferID
		private String eventId; // 赛事id
		private Integer phase; // 第N期
		private Integer totalNum; // 参与总人数
		private Integer remainNum; // 剩余人数
		private Double prize; // 基础奖金
		private Integer runDay; // 持续交易日
		private Integer myWinNum; // 我的连续天数
		private Integer isWin; // 是否冠军 0非冠军 1冠军
		private Integer status; // 1进行中 2 已结束

		public String getEventId() {
			return eventId;
		}

		public void setEventId(String eventId) {
			this.eventId = eventId;
		}

		public Integer getPhase() {
			return phase;
		}

		public void setPhase(Integer phase) {
			this.phase = phase;
		}

		public Integer getTotalNum() {
			return totalNum;
		}

		public void setTotalNum(Integer totalNum) {
			this.totalNum = totalNum;
		}

		public Integer getRemainNum() {
			return remainNum;
		}

		public void setRemainNum(Integer remainNum) {
			this.remainNum = remainNum;
		}

		public Double getPrize() {
			return prize;
		}

		public void setPrize(Double prize) {
			this.prize = prize;
		}

		public Integer getRunDay() {
			return runDay;
		}

		public void setRunDay(Integer runDay) {
			this.runDay = runDay;
		}

		public Integer getMyWinNum() {
			return myWinNum;
		}

		public void setMyWinNum(Integer myWinNum) {
			this.myWinNum = myWinNum;
		}

		public Integer getIsWin() {
			return isWin;
		}

		public void setIsWin(Integer isWin) {
			this.isWin = isWin;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}
	}

}
