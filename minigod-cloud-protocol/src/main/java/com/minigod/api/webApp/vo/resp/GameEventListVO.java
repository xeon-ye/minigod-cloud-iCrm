/**
 * @Title: GameEventListVO.java
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
 * @date 2015-9-15 下午5:17:02
 * @version v1.0
 */

@TransferBean
public class GameEventListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private String gameEventId ; //赛事id
	private Integer gameStatus ; //赛事状态
	private Integer num; // 参数人数
	private String startDate; // 比赛开始时间
	private String endDate; // 比赛结束时间
	private Integer isWinner ; //是否股神，0-不是，1-是
	private String  gameName ; //赛事名称
	private String userIcon; //头像
	private String initUserName ; //发起人姓名
	private Long time ; //距离开赛时间戳
	private String myStkName ; //我的牛股名
	private String myStkCode ; //我的牛股代码
	private Integer myRank ; //我的排名
	private Double myChangePct ; //我的涨跌幅
	private String wUserName ; //牛股冠军名称
	private String wStkName ; //牛股名
	private String wStkCode ; //牛股代码
	private Double wChangePct ; //牛股涨跌幅
	private String prizeAmount; // 冠军奖励金额
	private Integer isPrize; // 0-没奖励，1-有奖励
	
	public Integer getIsPrize() {
		return isPrize;
	}
	public void setIsPrize(Integer isPrize) {
		this.isPrize = isPrize;
	}
	public String getPrizeAmount() {
		return prizeAmount;
	}
	public void setPrizeAmount(String prizeAmount) {
		this.prizeAmount = prizeAmount;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
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
	
	public String getGameEventId() {
		return gameEventId;
	}
	public void setGameEventId(String gameEventId) {
		this.gameEventId = gameEventId;
	}
	public Integer getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(Integer gameStatus) {
		this.gameStatus = gameStatus;
	}
	public Integer getIsWinner() {
		return isWinner;
	}
	public void setIsWinner(Integer isWinner) {
		this.isWinner = isWinner;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public String getInitUserName() {
		return initUserName;
	}
	public void setInitUserName(String initUserName) {
		this.initUserName = initUserName;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getMyStkName() {
		return myStkName;
	}
	public void setMyStkName(String myStkName) {
		this.myStkName = myStkName;
	}
	public String getMyStkCode() {
		return myStkCode;
	}
	public void setMyStkCode(String myStkCode) {
		this.myStkCode = myStkCode;
	}
	public Integer getMyRank() {
		return myRank;
	}
	public void setMyRank(Integer myRank) {
		this.myRank = myRank;
	}
	public Double getMyChangePct() {
		return myChangePct;
	}
	public void setMyChangePct(Double myChangePct) {
		this.myChangePct = myChangePct;
	}
	public String getwUserName() {
		return wUserName;
	}
	public void setwUserName(String wUserName) {
		this.wUserName = wUserName;
	}
	public String getwStkName() {
		return wStkName;
	}
	public void setwStkName(String wStkName) {
		this.wStkName = wStkName;
	}
	public String getwStkCode() {
		return wStkCode;
	}
	public void setwStkCode(String wStkCode) {
		this.wStkCode = wStkCode;
	}
	public Double getwChangePct() {
		return wChangePct;
	}
	public void setwChangePct(Double wChangePct) {
		this.wChangePct = wChangePct;
	}
	
}
