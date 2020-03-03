/**
 * @Title: GsAdGameDetailRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import com.minigod.api.webApp.vo.resp.GsAdGameStkRespVO;

import java.io.Serializable;
import java.util.List;

/**
 * @description 
 *
 * @author panlz
 * @date 2015-9-11 下午5:17:02
 * @version v1.0
 */

public class GsAdGameDetailRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String gameName ; //赛事名
	private Integer gameStatus; // 赛事状态
	private Integer isJoin; // 当前用户是否已参赛
	private String userName ; //发起人名称
	private String startDate ; //比赛开始日期
	private String endDate ; //比赛结束日期
	private Long time; // 距离时间戳
	private Integer num ; //已参赛人数
	private Integer limitNum ; //参赛人数上限
	private Integer redAmount ; //累计红包金额
	private Integer subscribe; // 是否关注了公众号，0-未关注 1-已关注
	private List<GsAdGameStkRespVO> gameStk ;

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public Integer getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(Integer gameStatus) {
		this.gameStatus = gameStatus;
	}

	public Integer getIsJoin() {
		return isJoin;
	}

	public void setIsJoin(Integer isJoin) {
		this.isJoin = isJoin;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public Integer getRedAmount() {
		return redAmount;
	}

	public void setRedAmount(Integer redAmount) {
		this.redAmount = redAmount;
	}

	public List<GsAdGameStkRespVO> getGameStk() {
		return gameStk;
	}

	public void setGameStk(List<GsAdGameStkRespVO> gameStk) {
		this.gameStk = gameStk;
	}
	
}
