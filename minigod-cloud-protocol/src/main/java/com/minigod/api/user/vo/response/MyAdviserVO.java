/**
 * @Title: MyAdviserVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-11 下午5:09:50
 * @version v1.0
 */
@TransferBean
public class MyAdviserVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TransferID
	private Long userId;// 用户ID
	@Emoji
	private String nickname;// 用户昵称
	private String userIcon;// 头像下载地址 缩略头像下载地址
	private String adviserName;// 认证名称
	@Emoji
	private String orgName;// 所属投顾机构名称
	private String attentionedCount;// 关注人数

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getAdviserName() {
		return adviserName;
	}

	public void setAdviserName(String adviserName) {
		this.adviserName = adviserName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAttentionedCount() {
		return attentionedCount;
	}

	public void setAttentionedCount(String attentionedCount) {
		this.attentionedCount = attentionedCount;
	}
}
