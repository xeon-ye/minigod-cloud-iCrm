package com.minigod.api.user.vo.response;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 获取推荐好友信息对象
 */
@TransferBean
public class RespFriendVO implements Serializable {

	private static final long serialVersionUID = 340831528495266018L;

	private Integer msgId;//friendReqId的值

	@TransferID
	private Long userId;//用户ID

	@Emoji
	private String nickname;//用户昵称

	private String userIcon;//用户图像

	@Emoji
	private String cmnt;//备注名

	//0别人向我发送好友申请，等待我处理，客户端按钮“验证”(同意不同意);
	//1我可以添加别人为好友，客户端按钮“添加”;
	//2表示已是好友，客户端按钮“已添加”;
	//3我发送好友申请待对方确认，客户端按钮“待验证”;
	private Integer status;

	@Emoji
	private String message;//推荐信息提示

	private Integer cId;//联系人ID
	private String pn;//电话号码

	@Emoji
	private String cn;//联系人名,联系人名字

	private Integer isRead; // 信息是否已读
	@TransferID
	private Long tarUserId; // 目标用户ID
	@Emoji
	private String tarNickname; // 目标用户昵称
	private String tarUserIcon; // 目标用户头像绝对地址
	private Long orderId;//客户端以此id进行消息降序排序
	private Integer isStatus;//0-无效，1-有效，无效的记录不展示

	private String reqSrc;//请求来源

	@TransferID
	private Long rcmdUserId;//引荐人 ID
	private Integer uType;//用户类型(默认所有用户均为1类型;1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；)
	
	private String imId;

	private Integer isNodisturbing;//是否免打扰,1是0否

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public Long getTarUserId() {
		return tarUserId;
	}

	public void setTarUserId(Long tarUserId) {
		this.tarUserId = tarUserId;
	}

	public String getTarNickname() {
		return tarNickname;
	}

	public void setTarNickname(String tarNickname) {
		this.tarNickname = tarNickname;
	}

	public String getTarUserIcon() {
		return tarUserIcon;
	}

	public void setTarUserIcon(String tarUserIcon) {
		this.tarUserIcon = tarUserIcon;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(Integer isStatus) {
		this.isStatus = isStatus;
	}

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}

	public String getReqSrc() {
		return reqSrc;
	}

	public void setReqSrc(String reqSrc) {
		this.reqSrc = reqSrc;
	}

	public Long getRcmdUserId() {
		return rcmdUserId;
	}

	public void setRcmdUserId(Long rcmdUserId) {
		this.rcmdUserId = rcmdUserId;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public String getImId() {
		return imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
	}

	public Integer getIsNodisturbing() {
		return isNodisturbing;
	}

	public void setIsNodisturbing(Integer isNodisturbing) {
		this.isNodisturbing = isNodisturbing;
	}
}
