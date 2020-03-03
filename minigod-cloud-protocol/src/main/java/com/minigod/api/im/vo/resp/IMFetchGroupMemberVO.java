/**
 * @Title: IMFetchGroupMemberVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

import com.minigod.api.im.enums.EAffiliation;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-16 下午4:27:13
 * @version v1.0
 */
@TransferBean
public class IMFetchGroupMemberVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String memberId; // 成员的 IM ID
	@TransferID
	private Long userId; // minigod用户ID
	@Emoji
	private String nickName; // 成员的昵称
	private String icon; // 成员的头像
	private String firstLetter;
	private EAffiliation affiliation; // M – 普通成员,P – 付款成员 ,O – 群主
	private Long expireTs; // 到期的时间戳 仅当affiliation为P时, 此字段有效
	private Long lastActiveTs; // 最后活跃的时间戳

	public Long getExpireTs() {
		return expireTs;
	}

	public void setExpireTs(Long expireTs) {
		this.expireTs = expireTs;
	}

	public Long getLastActiveTs() {
		return lastActiveTs;
	}

	public void setLastActiveTs(Long lastActiveTs) {
		this.lastActiveTs = lastActiveTs;
	}

	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public EAffiliation getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(EAffiliation affiliation) {
		this.affiliation = affiliation;
	}
}
