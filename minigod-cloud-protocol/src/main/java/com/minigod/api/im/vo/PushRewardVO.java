/**
 * @Title: RewardPushVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-12-1 下午2:44:45
 * @version v1.0
 */

public class PushRewardVO implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;

	private Long rewardTs;// 打赏时间戳
	private String fromUserId;// 打赏人的用户ID
	private String fromImId; // 打赏人的环信ID
	private String fromNickname;// 打赏人的昵称
	private String toUserId; // 被打赏人的用户ID (暂时是群主)
	private String amount;// 打赏的金额
	private String simpleContent;// 回话列表中显示的内容
	private String detailContent;// 点击红包时，显示的内容
	private Integer type; // 打赏的类型
	private String groupId;

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Long getRewardTs() {
		return rewardTs;
	}

	public void setRewardTs(Long rewardTs) {
		this.rewardTs = rewardTs;
	}

	public String getFromImId() {
		return fromImId;
	}

	public void setFromImId(String fromImId) {
		this.fromImId = fromImId;
	}

	public String getFromNickname() {
		return fromNickname;
	}

	public void setFromNickname(String fromNickname) {
		this.fromNickname = fromNickname;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSimpleContent() {
		return simpleContent;
	}

	public void setSimpleContent(String simpleContent) {
		this.simpleContent = simpleContent;
	}

	public String getDetailContent() {
		return detailContent;
	}

	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
