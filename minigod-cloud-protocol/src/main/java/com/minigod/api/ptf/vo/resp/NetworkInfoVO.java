package com.minigod.api.ptf.vo.resp;

import com.minigod.api.ptf.vo.resp.NetworkRankingVO;

import java.io.Serializable;
import java.util.List;

/**
 * <code>NetworkInfoVO<code> 投资人脉用户信息实体
 * 
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-26)
 * 
 */
public class NetworkInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userImage;// 当前用户头像

	private String userName;// 当前用户名称

	private Integer userEffect;// 当前用户影响力分数

	private Integer userRanking;// 当前用户排名

	private Integer exceedUserCount;// 超过用户数

	private String beatUserPercentage;// 打败用户百分比

	private List<NetworkRankingVO> list;// minigod用户排名list

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getExceedUserCount() {
		return exceedUserCount;
	}

	public void setExceedUserCount(Integer exceedUserCount) {
		this.exceedUserCount = exceedUserCount;
	}

	public String getBeatUserPercentage() {
		return beatUserPercentage;
	}

	public void setBeatUserPercentage(String beatUserPercentage) {
		this.beatUserPercentage = beatUserPercentage;
	}

	public Integer getUserEffect() {
		return userEffect;
	}

	public void setUserEffect(Integer userEffect) {
		this.userEffect = userEffect;
	}

	public Integer getUserRanking() {
		return userRanking;
	}

	public void setUserRanking(Integer userRanking) {
		this.userRanking = userRanking;
	}

	public List<NetworkRankingVO> getList() {
		return list;
	}

	public void setList(List<NetworkRankingVO> list) {
		this.list = list;
	}

}
