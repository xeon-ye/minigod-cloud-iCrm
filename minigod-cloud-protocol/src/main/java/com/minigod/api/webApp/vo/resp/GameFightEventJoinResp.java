/**
 * @Title: GameFightEventJoinResp.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author panlz
 * @date 2016-01-08 下午5:17:02
 * @version v1.0
 */

@TransferBean
public class GameFightEventJoinResp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private GameFightLatestEnd latestEnd ; 
	@TransferID
	private GameFightStayPhase stayPhase ;
	@TransferID
	private GameFightMyPhase myPhase ;
	
	private Integer isAttention ; //是否关注
	private Integer status ; //状态 1参赛报名 2交易时间赛事查看 3再次竞猜  4竞猜失败

	public GameFightLatestEnd getLatestEnd() {
		return latestEnd;
	}

	public void setLatestEnd(GameFightLatestEnd latestEnd) {
		this.latestEnd = latestEnd;
	}

	public GameFightStayPhase getStayPhase() {
		return stayPhase;
	}

	public void setStayPhase(GameFightStayPhase stayPhase) {
		this.stayPhase = stayPhase;
	}

	public GameFightMyPhase getMyPhase() {
		return myPhase;
	}

	public void setMyPhase(GameFightMyPhase myPhase) {
		this.myPhase = myPhase;
	}

	public Integer getIsAttention() {
		return isAttention;
	}

	public void setIsAttention(Integer isAttention) {
		this.isAttention = isAttention;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@TransferBean
	public static class GameFightLatestEnd implements Serializable {
		private static final long serialVersionUID = 1L;
		@TransferID
		private String eventId; // 赛事id
		private Integer phase; // 第N期
		private Long endTime; // 结束时间
		private Integer status; // 赛事状态
		private Integer totalNum; // 参与总人数
		private Double prize; // 参与总人数
		private String winner; // 冠军

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

		public Long getEndTime() {
			return endTime;
		}

		public void setEndTime(Long endTime) {
			this.endTime = endTime;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getTotalNum() {
			return totalNum;
		}

		public void setTotalNum(Integer totalNum) {
			this.totalNum = totalNum;
		}

		public Double getPrize() {
			return prize;
		}

		public void setPrize(Double prize) {
			this.prize = prize;
		}

		public String getWinner() {
			return winner;
		}

		public void setWinner(String winner) {
			this.winner = winner;
		}

	}

	@TransferBean
	public static class GameFightStayPhase implements Serializable {
		private static final long serialVersionUID = 1L;

		@TransferID
		private String eventId; // 赛事id
		private Integer phase; // 第N期
		private Long startTime; // 开始时间
		private Integer totalNum; // 参赛人数
		private Double prize; // 基础奖金
		private Long guessDate; // 竞猜日期
		private Integer guessValue; // 竞猜值 跌0 涨1
		private Integer guessUpNum; // 猜涨人数
		private Integer guessDownNum; // 猜跌人数
		private Integer shareType; // 分享类型 人数不够0 奖金翻倍 1 其他 2
		private Integer shareRemainNum; // 分享剩余人数 shareType=0,1返回
		private Double sharePrize; // 分享翻倍奖金 shareType=1返回

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

		public Long getStartTime() {
			return startTime;
		}

		public void setStartTime(Long startTime) {
			this.startTime = startTime;
		}

		public Integer getTotalNum() {
			return totalNum;
		}

		public void setTotalNum(Integer totalNum) {
			this.totalNum = totalNum;
		}

		public Double getPrize() {
			return prize;
		}

		public void setPrize(Double prize) {
			this.prize = prize;
		}

		public Long getGuessDate() {
			return guessDate;
		}

		public void setGuessDate(Long guessDate) {
			this.guessDate = guessDate;
		}

		public Integer getGuessValue() {
			return guessValue;
		}

		public void setGuessValue(Integer guessValue) {
			this.guessValue = guessValue;
		}

		public Integer getGuessUpNum() {
			return guessUpNum;
		}

		public void setGuessUpNum(Integer guessUpNum) {
			this.guessUpNum = guessUpNum;
		}

		public Integer getGuessDownNum() {
			return guessDownNum;
		}

		public void setGuessDownNum(Integer guessDownNum) {
			this.guessDownNum = guessDownNum;
		}

		public Integer getShareType() {
			return shareType;
		}

		public void setShareType(Integer shareType) {
			this.shareType = shareType;
		}

		public Integer getShareRemainNum() {
			return shareRemainNum;
		}

		public void setShareRemainNum(Integer shareRemainNum) {
			this.shareRemainNum = shareRemainNum;
		}

		public Double getSharePrize() {
			return sharePrize;
		}

		public void setSharePrize(Double sharePrize) {
			this.sharePrize = sharePrize;
		}

	}

	@TransferBean
	public static class GameFightMyPhase implements Serializable {
		private static final long serialVersionUID = 1L;

		@TransferID
		private String eventId; // 赛事id
		private Integer phase; // 第N期
		private Long startTime; // 开始时间
		private Integer totalNum; // 参赛人数
		private Integer remainNum; // 剩余人数
		private Double prize; // 基础奖金
		private Integer runDay; // 持续交易日
		private Double sseIndex; // 上证指数
		private String sseTime; // 上证指数对应的时间
		private Double sseYield; // 上证涨幅
		private Long guessDate; // 竞猜日期
		private Integer guessValue; // 竞猜值 跌0 涨1
		private Integer guessUpNum; // 猜涨人数
		private Integer guessDownNum; // 猜跌人数
		private Integer latestPhase; // 最新期号
		private Integer eventStatus; // 赛事的状态
		private Integer gusessResult; // 竞猜结果
		private Long gusessEndTime; // 竞猜结束时间

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

		public Long getStartTime() {
			return startTime;
		}

		public void setStartTime(Long startTime) {
			this.startTime = startTime;
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

		public Double getSseIndex() {
			return sseIndex;
		}

		public void setSseIndex(Double sseIndex) {
			this.sseIndex = sseIndex;
		}

		public String getSseTime() {
			return sseTime;
		}

		public void setSseTime(String sseTime) {
			this.sseTime = sseTime;
		}

		public Double getSseYield() {
			return sseYield;
		}

		public void setSseYield(Double sseYield) {
			this.sseYield = sseYield;
		}

		public Integer getGuessValue() {
			return guessValue;
		}

		public void setGuessValue(Integer guessValue) {
			this.guessValue = guessValue;
		}

		public Long getGuessDate() {
			return guessDate;
		}

		public void setGuessDate(Long guessDate) {
			this.guessDate = guessDate;
		}

		public Integer getGuessUpNum() {
			return guessUpNum;
		}

		public void setGuessUpNum(Integer guessUpNum) {
			this.guessUpNum = guessUpNum;
		}

		public Integer getGuessDownNum() {
			return guessDownNum;
		}

		public void setGuessDownNum(Integer guessDownNum) {
			this.guessDownNum = guessDownNum;
		}

		public Integer getLatestPhase() {
			return latestPhase;
		}

		public void setLatestPhase(Integer latestPhase) {
			this.latestPhase = latestPhase;
		}

		public Integer getEventStatus() {
			return eventStatus;
		}

		public void setEventStatus(Integer eventStatus) {
			this.eventStatus = eventStatus;
		}

		public Integer getGusessResult() {
			return gusessResult;
		}

		public void setGusessResult(Integer gusessResult) {
			this.gusessResult = gusessResult;
		}

		public Long getGusessEndTime() {
			return gusessEndTime;
		}

		public void setGusessEndTime(Long gusessEndTime) {
			this.gusessEndTime = gusessEndTime;
		}

	}

}
