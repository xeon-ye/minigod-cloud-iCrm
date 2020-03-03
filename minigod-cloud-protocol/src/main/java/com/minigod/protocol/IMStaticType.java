/**
 * @Title: IMStaticType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-15 下午2:28:54
 * @version v1.0
 */

public class IMStaticType {

	private static final Map<Integer, CodeType> map = new HashMap<Integer, IMStaticType.CodeType>();

	//组合模块
	public enum CodeType {
		CREATE_GROUP_FAIL(9100, "创建失败，请重试"),
		DELETE_GROUP_FAIL(9101, "删除失败，请重试"),
		ADD_NEW_MEMBERS_FAIL(9102, "增加新成员失败，请重试"),
		DELETE_MEMBERS_FAIL(9103, "删除成员失败，请重试"),
		NOT_JOIN_GROUP(9104, "还没有加入到该直播群哦"),
		QUIT_GROUP_FAIL(9105, "退出失败，请重试哦"),
		FETCH_GROUP_INFO_FAIL(9106, "获取直播群信息失败，请重试"),
		ALL_USERINFO_NOT_FOUND(9107, "没有找到直播群成员的信息，请重试"),
		CREATE_GROUP_PERMISSION_DENIED(9108, "仅认证过通过的投顾才可以创建直播群哦"),
		REACH_MAX_GROUP_COUNT(9109, "您的直播群数量已达到上限，无法继续创建"),
		GROUP_NOTFOUND(9110, "该直播群不存在"),
		ADD_MEMBERS_PERMISSION_DENIED(9111, "仅直播群主人可以邀请新成员哦"),
		DELETE_MEMBERS_PERMISSION_DENIED(9112, "仅直播群主人可以删除群成员哦"),
		REACH_MAX_GROUPMEMBER_COUNT(9113, "直播群成员数量已达到上限啦"),
		OWNER_DELETE_SELF_NOT_ALLOW(9114, "不能删除自己哦"),
		DELETE_GROUP_PERMISSION_DENIED(9115, "仅直播群主人可以解散群哦"),
		UPDATE_GROUPINFO_FAIL(9116, "更新群信息失败，请重试"),
		GROUP_NAME_TOO_LONG(9017, "直播群名称过长，请重新输入哦"),
		GROUP_DESC_TOO_LONG(9018, "直播群简介过长，请重新输入哦"),
		DELETE_CHARGE_GROUP_FAIL(9019, "不能解散收费的直播群哦"),
		DELETE_P_MEMBER_FAIL(9020, "不能删除付费的群成员哦"),
		INVITE_CLIENTFRIEND_ONLY(9021, "只能邀请您的客户或者好友进直播群哦"),
		PRICE_LT_ZERO(9022, "输入的价格不能少于或等于0哦"),
		NOT_CHARGE_GROUP(9023, "不是收费的直播群, 不支持此操作哦"),
		JOIN_GROUP_PERMISSION_DENIED(9024, "不是直播群主人的客户, 没有加入直播群的权限哦"),
		NOT_CLIENT_PERMISSION_DENIED(9025, "不是客户关系哦"),
		CHARGE_GROUP_NOT_ALLOW(9026, "收费的直播群，请刷新重试哦"),
		NEEDVERIFY_GROUP_NOT_ALLOW(9027, "需要验证的直播群，请刷新重试哦"),
		NONEEDVERIFY_GROUP_NOT_ALLOW(9028, "不需要验证的直播群，请刷新重试哦"),
		IN_GROUP_NOT_ALLOW(9029, "您已经是这个直播群的群成员，请刷新重试哦"),
		GROUP_ORDER_NOT_EXISTS(9030, "不存的订单号"),
		GOURP_ORDER_PERMISSION_DENIED(9031, "您没有查看此订单的权限哦"),
		REQ_CONTENT_TOO_LONG(9032, "输入的内容过长，请重新输入"),
		SALES_PRICE_NOT_INCORRECT(9033, "促销价不能大于等于正常价格，请重新输入"),
		REWARD_AMOUNT_NOT_ALLOW(9034, "输入的金额有误，请重新输入"),
		APPLY_GROUP_PERMISSION_DENIED(9035, "成为该投顾的客户或好友了，才能申请进群哦"),
		DELETE_CHARGE_GRP_FAIL(9036, "还有付费成员未到期，或存在未支付的订单，不能解散哦"),
		ORDER_EXPIRED(9037, "购买直播群订单过期，请刷新重试哦"),
		NO_NEED_CHARGE(9038, "您已经是该直播群的成员了， 不需要付费哦"),
		REACH_LIMITED_ORDER(9039, "单笔订单不能超过3000元哦"),
		REWARD_SELF_FAIL(9040, "不能打赏给自己哦"),
		JOIN_GRP_FAIL(9041, "加入直播群失败哦，请重试"),
		NOT_FRIENDSHIP_RELATION(9042, "还不是好友关系，不能设置免打扰哦"),
		CHATROOM_NOTFOUND(9043, "该聊天室不存在"),
		CHATROOM_NOTFOUND_BYASSETID(9044, "该证券对应的聊天室不存在"),
		REACH_MAX_CHATROOMMEMBER_COUNT(9045, "l聊天室成员数量已达到上限啦"),
		DELETE_CHATROOM_MEMBERS_PERMISSION_DENIED(90445, "仅聊天室主人可以删除群成员哦"),
		ERROR_UNKNOWN(9999, "啊哦，出现了未知错误，请重试或联系客服");
		
		private int errorCode;
		private String errorMessage;

		private CodeType(int errorCode, String errorMessage) {
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
			map.put(errorCode, this);
		}

		public int getCode() {
			return errorCode;
		}

		public String getErrorMsg() {
			return errorMessage;
		}

		public static final CodeType get(int errorCode) {
			CodeType code = map.get(errorCode);
			if (code == null) {
				return ERROR_UNKNOWN;
			}
			return code;
		}

		public static final String getErrorMessage(int errorCode) {
			CodeType code = map.get(errorCode);
			if (code == null) {
				return ERROR_UNKNOWN.getErrorMsg();
			}
			return code.getErrorMsg();
		}
	}
	
}
