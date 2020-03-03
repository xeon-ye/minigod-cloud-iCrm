package com.minigod.api.user.vo.response;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * 用户简要信息
 */

@TransferBean
public class UserSummaryVO implements Serializable {

	private static final long serialVersionUID = 8739893014317460424L;

	@Emoji
	private String nickname;//用户昵称
	private String vTitle;//认证头衔	1.	认证用户返回认证头衔 2.	非认证用户不返回
	private String userIcon;//头像下载地址	 缩略头像下载地址
	private Integer vType;//认证标识	 0为没有认证,1为已认证
	private Integer uType;//用户类型(默认所有用户均为1类型;1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；)

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public Integer getvType() {
		return vType;
	}

	public void setvType(Integer vType) {
		this.vType = vType;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}
}
