package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: MsgStaticType.java
 * @Description: 消息平台错误码静态类
 * @Copyright: © 2014 minigod
 * @Company: minigod
 * 
 * @author minigod
 * @date 2014-11-28 下午4:29:29
 * @version v1.0
 */

public class MsgStaticType {

	public static final Map<Integer, CodeType> map = new HashMap<Integer, CodeType>();

	/**
	 * 观点消息
	 */
	public static final int VIEWPOINT_MSG = 11001;
	
	/**
	 * 投资圈消息
	 */
	public static final int PTF_MSG = 2001;
	
	/**
	 * 调仓消息
	 */
	public static final int REBALANCE_MSG = 12002;
	/**
	 * 评论消息
	 */
	public static final int COMMENT_MSG = 12003;
	
	public static final int USER_MSG = 2004; // 新的好友消息
	/**
	 * 点赞消息
	 */
	public static final int LIKE_MSG = 12005;

	/**
	 * 关注消息
	 */
	public static final int FAV_MSG = 12006;
	/**
	 * 服务通知
	 */
	public static final int SERVICE_MSG = 12007;

	/**
	 * 股价提醒
	 */
	public static final int STK_PRICE_REMINDER_MSG = 12012;

	/**
	 * 实盘跟单者跟单通知
	 */
	public static final int FOLLOW_MSG = 2008;


	public static final int TRADE_MSG = 4010; // 实盘交易信息

	public static final int SYSTEM_MSG = 5010; // 系统通知
	
	public static final int OPEN_ACCOUNT_MSG = 2009; // 开户通知

	public enum CodeType {
		SUCESS(5000, "请求成功"), //
		PARAMETER_ERROR(5001, "参数错误"), //
		NONE_DATA(5002, "无满足条件的数据"), //
		CAPTCHA_ERROR(5003, "手机验证码发送失败"), //
		PUSH_ERROR(5004, "消息推送失败"), //
		PARAMMATCH_ERROR(5005, "请求的参数与消息配置表配置的参数不一致"), //
		REQUESTBUSY_ERROR(5006, "请求过于频繁"), //
		SAVEFAILED_ERROR(5007, "短信信息保存失败"), //
		UNKNOWN_ERROR(5499, "未知错误");

		private int errorCode; // 错误码
		private String errorMessage; // 错误信息

		// 枚举类的构造函数，枚举类在实例化的第一次会调用此构造函数，且只会实例化一次
		private CodeType(int errorCode, String errorMessage) {
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
			map.put(errorCode, this);
		}

		// 获取错误码
		public int getErrorCode() {
			return errorCode;
		}

		// 获取错误信息
		public String getErrorMessage() {
			return errorMessage;
		}

		// 根据请求的错误码返回错误信息，如果不存在则返回定义好的未知错误信息
		public static final String getErrorMessage(int errorCode) {
			CodeType codeType = map.get(errorCode);
			if (codeType == null) {
				return UNKNOWN_ERROR.getErrorMessage();
			}
			return codeType.getErrorMessage();
		}

		// 根据请求的代码返回枚举的实例，如果不存在返回定义好的未知枚举实例
		public static final CodeType getCodeType(int errorCode) {
			CodeType codeType = map.get(errorCode);
			if (codeType == null) {
				return UNKNOWN_ERROR;
			}
			return codeType;
		}
	}

	/**
	 * <code>MsgCode<code> 消息通道码
	 */
	public static class MsgCode {
		// 发送开户成功通知
		public static final int SEND_OPEN_ACCOUNT_SC = 1071;
		// 发送验证码短信
		public static final int SEND_CAPTCHA = 1001;
		// 发送忘记密码验证邮件
		public static final int EMAIL_SEND_VERIFY = 1002;
		// 上传通讯录，匹配好友
		public static final int MATCHING_FRIENDS = 1011;
		// 对方同意我的好友申请消息
		public static final int OPPSOSITE_AGREE = 1012;
		// 对方申请添加我为好友,message为空默认模板
		public static final int OPPSOSITE_APPLY = 1013;
		// 对方申请添加我为好友，message不为空常用模板
		public static final int OPPSOSITE_APPLY1 = 10131;
		// 通讯录好友注册成功了minigod账户，告知通讯录好友
		public static final int FRIEND_REGISTER = 1014;
		// 通讯录好友注册成功了minigod账户，告知通讯录好友
		public static final int FRIEND_REGISTER_JOIN = 10140;
		
		//引荐好友，推送消息给小白，XX把牛人引荐给你  %s引荐%s给你:%s
		public static final int OPPSOSITE_RCMD = 1015;
		//引荐好友，介绍成功后通知引荐人,xx和xx在你的介绍下，已成功加为好友啦
		public static final int OPPSOSITE_RCMD_SUCCESS = 1016;
		/** 管理人发表组合观点 */
		public static final int WRITE_NOTE = 1020;
		/** 访客发表组合观点 */
		public static final int VISITOR_WRITE_NOTE = 10143;
		/** 讨论好友，除了被回复人  弱透传*/
		public static final int POST_CMT = 1022;
		/** 主贴创建者，被回复人  强透传*/
		public static final int REPLY_CMT = 1023;
		/** 组合关注 弱透传*/
		public static final int Fav_PTF = 10144;
		/** 组合调整 强透传 */
		public static final int ADJUST_PTF = 10145;
		/** 组合调整 强透传 */
		public static final int REAL_TRADE = 10146;
		/** 跟单买入 弱 透传*/
		public static final int FOLLOW_PTF = 10147;
		/** 组合点赞  弱透传*/
		public static final int LIKE = 10148;
		/** 购买组合成功，通知购买者 强透传*/
		public static final int SUBSCRIBE_PTF_SUCEESS_TO_BUYER = 10149;
		/** 购买组合成功，通知组合创建者 强透传*/
		public static final int SUBSCRIBE_PTF_SUCEESS_TO_SELLER = 10150;
		/** 购买组合失败，通知购买者 强透传*/
		public static final int SUBSCRIBE_PTF_REFUND = 10151;
		/** 组合目标收益已达成，通知购买者 强透传*/
		public static final int SUBSCRIBE_PTF_TARGET_ACHIEVED_TO_BUYER = 10152;
		/** 组合目标收益已达成，通知组合创建者 强透传*/
		public static final int SUBSCRIBE_PTF_TARGET_ACHIEVED_TO_SELLER = 10153;
		/** 组合目标收益未达成，通知购买者 强透传*/
		public static final int SUBSCRIBE_PTF_TARGET_FAILED_REFUND_TO_SELLER = 10154;
		/** 组合服务期到，通知购买者续费 强透传*/
		public static final int SUBSCRIBE_PTF_TARGET_RENEW_REMIND_TO_BUYER = 10155;
		/** 朋友发送投资圈消息 */
		public static final int FRIEND_INVEST_MSG = 10156;
		/** 卡券发放提醒 */
		public static final int GRANT_COUPON_NOTICE = 10157;
		/** 卡券发放弱提示 */
		public static final int GRANT_COUPON_WEAK = 10158;
		/**
		 * 批量转账
		 */
		public static final int BATCH_TRANSFER_WORDS = 10160;
		
		
		
		
		/** 系统自动注册，默认发短信给用户，XXX您的随机密码为：%s*/
		public static final int SEND_RANDPWD = 1017;
		/**修改号码，发短信通知旧手机号, 尊敬的用户，您绑定的手机号码已经修改，请使用新号码登录。*/
		public static final int SEND_OLD_PHONE = 1018;
		//密码错误次数短信
		public static final int SEND_PWD_ERROR_COUNT = 1019;
		//找回密码短信
		public static final int SEND_BACK_PWD = 1026;
		/**组合创建人调仓给跟单用户发送短信*/
		public static final int SEND_FOLLOW_SMS = 1027;
		/** 系统消息 强透传 */
		public static final int SEND_SYS_MSG_STRONG = 1029;
		/** 系统消息  弱透传 */
		public static final int SEND_SYS_MSG_WEAK = 1030;
		/** 给低版本的好友发送消息后, 提醒被邀请人升级 */
		public static final int CHAT_UPGRADE_MIND = 1038;
		/** 邀请低版本的好友进去群组后, 提醒被邀请人升级 */
		public static final int IMGROUP_UPGRADE_MIND = 1039;
		/** 用户被踢下线通知用户*/
		public static final int SEND_LOGOUT_HX = 1040;
		/** 直播间续费提醒 */
		public static final int IMGROUP_EXPIRED_MIND = 1043;
		/** 问答 %s对你提问:%s 广场问答最强消息 弹窗 */
		public static final int QA_SQUARE_ASK = 1044;
		/** 问答 %s对你解答:%s 广场问答最强消息 弹窗*/
		public static final int QA_SQUARE_ANSWER = 1045;
		/** 直播间交易通知 - 小白视角 */
		public static final int IMGROUP_PAID_NOTICE = 1046;
		/** 投顾新观点 */
		public static final int ADVISER_NEW_VIEWPOINT = 1047;
		/** 投顾观点点赞 */
		public static final int ADVISER_VIEWPOINT_LIKE = 1048;
		/** 投顾 观点评论*/
//		public static final int ADVISER_VIEWPOINT_COMMENTS = 1049;
		public static final int ADVISER_VIEWPOINT_COMMENTS = 1059;
		/** 问答 %s对你提问:%s 专属问答强消息 */
		public static final int QA_EXCLUSIVE_ASK = 1050;
		/** 问答 %s对你解答:%s 专属问答强消息*/
		public static final int QA_EXCLUSIVE_ANSWER = 1051;
		/** 直播群申请进群的通知 */
		public static final int IMGROUP_REQ = 1052;
		/** 观点打赏通知 */
		public static final int REWARD_NOTICE = 1053;
		/** 直播间交易通知 - 投顾视角 */
		public static final int ADVISER_IMGROUP_PAID_NOTICE = 1054;
		/** 对环信透传的一个补充, 拉取群列表 */
		public static final int EM_PUSH = 1055;
		/** 购买直播群失败，通知购买者 强透传*/
		public static final int BUY_GRP_REFUND = 1056;
		/** 直播群打赏通知 */
		public static final int GRP_REWARD = 1058;
		/*** 我的投顾列表 */
		public static final int MY_ADVISRES_LIST = 1060;
		/** 官网广场问答 提问消息  */
		public static final int OFFICIAL_QA_SQUARE_ASK = 1061;
		/** 官网专属问答 提问消息  */
		public static final int OFFICIAL_QA_EXCLUSIVE_ASK = 1062;
		/** 卡券发放短信通知  */
		public static final int GRANT_COUPON_SMS_NOTICE = 1063;
		/** 理财产品购买成功发放短信通知  */
		public static final int FNLPROD_BUY_SUCCESS = 1064;
		/** 卡券的过期提醒  */
		public static final int COUPON_EXPIRED_REMIND = 1068;
		/** 行情提醒*/
		public static final int MTK_NOTIFY = 1069;

		/** 股价提醒*/
		public static final int STK_PRICE_NOTIFY = 1070;
		/** 新闻推送*/
		public static final int NEWS_PUSH = 1042;
		/** 自定义服务通知强透传*/
		public static final int SERVICE_MANUAL_NOTIFY_STRONG = 1901;
		/** 自定义服务通知弱透传*/
		public static final int SERVICE_MANUAL_NOTIFY_WEAK = 1902;
		
		//问题评价提醒
		public static final int COMMENT_PROB = 1903;
		
		//通用跳转模版
		public static final int COMMOM_POP = 1000;

		// 发送犇犇经理人验证码短信
		public static final int SEND_BROKER_CAPTCHA = 10161;
	}

}
