/**
 * @Title: RewardListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-3 下午8:13:42
 * @version v1.0
 */

public class RewardListVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	private String rewardType;
	private String targetId;
	private Integer count;
	private Integer readId;
	public String getRewardType() {
		return rewardType;
	}
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getReadId() {
		return readId;
	}
	public void setReadId(Integer readId) {
		this.readId = readId;
	} 
}
