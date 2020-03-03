package com.minigod.api.user.vo.api;

import java.io.Serializable;

/**
 * @Title: UserWinxinInfo.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-12-3 下午4:16:56
 * @version v1.0
 */

public class UserWinxinInfo implements Serializable {

	private static final long serialVersionUID = 8826947720906135013L;

	private String weixiOpenId;

	private String weixinUnionid;

	private String nickName;

	private String realName;

	public String getWeixiOpenId() {
		return weixiOpenId;
	}

	public void setWeixiOpenId(String weixiOpenId) {
		this.weixiOpenId = weixiOpenId;
	}

	public String getWeixinUnionid() {
		return weixinUnionid;
	}

	public void setWeixinUnionid(String weixinUnionid) {
		this.weixinUnionid = weixinUnionid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
