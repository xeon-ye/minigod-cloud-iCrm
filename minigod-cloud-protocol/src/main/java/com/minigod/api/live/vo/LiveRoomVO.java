/**
 * @Title: IMFetchGroupListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.live.vo;

import com.minigod.api.im.enums.EIsCharge;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * 
 * @author huhu
 * @date 2016-6-20 下午1:16:02
 * @version v1.0
 */
@TransferBean
public class LiveRoomVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = -2260388125919493487L;


	private String name; // 群组的名称,直播的昵称
	private String ownerId;
	private String ownerName;
	private String description; // 群描述，直播描述
	private String icon; // 群头像

	private EIsCharge isCharge; // 是否收费
	private String price; // 价格
	private String salesPrice; // 优惠价
	private String vipPrice; // VIP优惠价
	private String needVerify = "N"; // 是否需要验证,Y – 需要, N – 不需要 （默认）
	private Integer maxUsers=5000;//成员上限数，直播群的从投顾表里获取

	private String chatroomKind;//聊天室种类：1官方，2港股，3美股，4期货
	private String groupType;//1群组；2聊天室；3直播室

	private Integer liveRoomId;
	private String groupId;
	private String cellPhone; //手机号
	private String liveUserId;//直播用户号
	private String createTime;
	private String updateTime;
	private Integer status;

	//当前正在播放的视频id
	private String vid;
	private String vidNickName;
	private String vidTitle;
	private String vidCreateTime;

	//最近的直播预告
	private String liveNoticeTitle;
	private String liveNoticeContent;
	private String liveNoticeStartTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public EIsCharge getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(EIsCharge isCharge) {
		this.isCharge = isCharge;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(String vipPrice) {
		this.vipPrice = vipPrice;
	}

	public String getNeedVerify() {
		return needVerify;
	}

	public void setNeedVerify(String needVerify) {
		this.needVerify = needVerify;
	}

	public Integer getMaxUsers() {
		return maxUsers;
	}

	public void setMaxUsers(Integer maxUsers) {
		this.maxUsers = maxUsers;
	}

	public String getChatroomKind() {
		return chatroomKind;
	}

	public void setChatroomKind(String chatroomKind) {
		this.chatroomKind = chatroomKind;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public Integer getLiveRoomId() {
		return liveRoomId;
	}

	public void setLiveRoomId(Integer liveRoomId) {
		this.liveRoomId = liveRoomId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getLiveUserId() {
		return liveUserId;
	}

	public void setLiveUserId(String liveUserId) {
		this.liveUserId = liveUserId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getVidNickName() {
		return vidNickName;
	}

	public void setVidNickName(String vidNickName) {
		this.vidNickName = vidNickName;
	}

	public String getVidTitle() {
		return vidTitle;
	}

	public void setVidTitle(String vidTitle) {
		this.vidTitle = vidTitle;
	}

	public String getLiveNoticeTitle() {
		return liveNoticeTitle;
	}

	public void setLiveNoticeTitle(String liveNoticeTitle) {
		this.liveNoticeTitle = liveNoticeTitle;
	}

	public String getLiveNoticeContent() {
		return liveNoticeContent;
	}

	public void setLiveNoticeContent(String liveNoticeContent) {
		this.liveNoticeContent = liveNoticeContent;
	}

	public String getLiveNoticeStartTime() {
		return liveNoticeStartTime;
	}

	public void setLiveNoticeStartTime(String liveNoticeStartTime) {
		this.liveNoticeStartTime = liveNoticeStartTime;
	}

	public String getVidCreateTime() {
		return vidCreateTime;
	}

	public void setVidCreateTime(String vidCreateTime) {
		this.vidCreateTime = vidCreateTime;
	}
}
