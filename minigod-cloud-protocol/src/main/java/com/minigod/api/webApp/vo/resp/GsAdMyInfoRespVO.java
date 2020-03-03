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
public class GsAdMyInfoRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userName ; //用户名
	private String userIcon ; //用户头像
	private Integer gameNum ; //参加比赛场数
	private String preferIndu ; //偏好行业
	private String preferExchange ; //偏好版块
	private Double cYield ; //累计收益率
	private Double cFriendPro ; //累计收益率战胜群友比
	private Double rPro ; //推荐胜率
	private Double rFriendPro ; //胜率战胜群友比例
	@TransferID
	private String gameUserId; // 当前用户id
	
	public String getGameUserId() {
		return gameUserId;
	}
	public void setGameUserId(String gameUserId) {
		this.gameUserId = gameUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public Integer getGameNum() {
		return gameNum;
	}
	public void setGameNum(Integer gameNum) {
		this.gameNum = gameNum;
	}
	public String getPreferIndu() {
		return preferIndu;
	}
	public void setPreferIndu(String preferIndu) {
		this.preferIndu = preferIndu;
	}
	public String getPreferExchange() {
		return preferExchange;
	}
	public void setPreferExchange(String preferExchange) {
		this.preferExchange = preferExchange;
	}
	public Double getcYield() {
		return cYield;
	}
	public void setcYield(Double cYield) {
		this.cYield = cYield;
	}
	public Double getcFriendPro() {
		return cFriendPro;
	}
	public void setcFriendPro(Double cFriendPro) {
		this.cFriendPro = cFriendPro;
	}
	public Double getrPro() {
		return rPro;
	}
	public void setrPro(Double rPro) {
		this.rPro = rPro;
	}
	public Double getrFriendPro() {
		return rFriendPro;
	}
	public void setrFriendPro(Double rFriendPro) {
		this.rFriendPro = rFriendPro;
	}
}
