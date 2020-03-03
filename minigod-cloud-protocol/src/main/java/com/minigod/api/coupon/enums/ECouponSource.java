/**
 * @Title: ECouponSource.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.coupon.enums;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2016-1-12 下午4:00:13
 * @version v1.0
 */

public enum ECouponSource {
//	OMS(0, "OMS发放"),
	REG(1, "用户注册"),
	REG_INVITED(1, "用户注册被邀请方"),
	// 邀请
	REG_INVITER(2, "用户注册邀请方"), 
	FNL_INVITER(2, "理财产品邀请方"),
	// VIP 老用户
	VIP(3, "vip专享"),
	// 元宵活动
	LANTERN_FESTIVAL(4, "元宵节福利")
	;
    
	private int activityId;
	private String desc;

	private ECouponSource(int activityId, String sDesc) {
		this.activityId = activityId;
		this.desc = sDesc;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
