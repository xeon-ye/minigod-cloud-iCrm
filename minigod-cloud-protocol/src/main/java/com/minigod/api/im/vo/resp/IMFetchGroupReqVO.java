/**
 * @Title: IMFetchGroupReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-13 下午12:29:21
 * @version v1.0
 */
@TransferBean
public class IMFetchGroupReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long groupRequestId; // 请求进群的记录ID
	private String groupName; // 群名称
	@TransferID
	private Long userId; // 请求的用户ID
	private String userIcon; // 用户头像
	@Emoji
	private String nickname; // 请求用户的昵称
	private String content; // 请求的内容
	private String businessStatus; // 业务处理状态 String N – 待处理,P – 通过,R – 拒绝
	private Integer uType;
	private String remark;
	private Long ts;

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}

	public Long getGroupRequestId() {
		return groupRequestId;
	}

	public void setGroupRequestId(Long groupRequestId) {
		this.groupRequestId = groupRequestId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
