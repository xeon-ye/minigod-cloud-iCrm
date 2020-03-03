package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

public class AdviserStaticType {

	private static final Map<Integer, CodeType> map = new HashMap<Integer, AdviserStaticType.CodeType>();

	//自媒体模块相关,CODE 10000-11000区间
	public enum CodeType {

		ERROR_UNKNOWN(100, "未知错误，请稍后重试或联系客服"),
		ASK_LIMIT(10001, "今日您的提问机会已用完，开户成功后将不受提问限制。"),
//		QA_SWITCH_CLOSE(10002, "亲！关注自媒体后可向TA提问!"),
		QA_SWITCH_CLOSE(10002, "TA暂不接受陌生人的提问，您可以添加关注后向TA提问。"),
		QUESTION_NOT_EXIST(10003, "问题不存在"),
		ANSWER_NOT_EXIST(10004, "答案不存在"),
		QUESTION_NOT_PERMISSION(10005, "你无权限操作此问题"),
		ASK_SQUARE_SUCEESS(0,"自媒体解答后会第一时间通知您，您可在“自媒体广场-我关注的自媒体-自媒体服务台-问答”中查看。"),
		ASK_EXCLUSIVE_SUCEESS_1(0,"自媒体解答后会第一时间通知您，您可在“自媒体-我的自媒体-"),
		ASK_EXCLUSIVE_SUCEESS_2(0,"-问答”中查看。"),
		ALREADY_RUSH(10006,"啊哦！您手慢了，该提问已被其他自媒体抢答了！"),
		NOT_UNANSWERED_STATUS(10008,"非未回答状态，无权操作此问题"),
		ANSWER_TIMEOUT(10009,"解答已超时"),
		NEED_ANSWER_SOME_QUESTION(10010, "为了给您提供更精准的投资服务，在体验前，请回答几个简单的问题吧!（仅需回答一次）"),
		NEED_ADVISER_AGREE(10011, "已申请成功，等待对方验证中"),
		CHARGE_SERVICE_PROVIDE_NOT_EXPIRE(10012, "该客户购买了你的服务未到期，还不能移除哦"),
		CHARGE_SERVICE_PARTICIPATION_NOT_EXPIRE(10013, "参与的付费服务未到期"),
		NOT_COMMENT(10014, "非广场问答不能进行评价操作"),
		NIGHT_TIME_MSG(0, "现在是非工作时间，请留下您的问题，自媒体会在工作时间给您及时解答。"),
		NOT_GIVE_UP(10015,"终结者不允许进行放弃回答操作"),
		
		VIEWPOINT_NOT_EXIT(10016, "该观点不存在或已被删除"),
		INTERACTION_IS_BLANK(10017, "评论内容不能为空"),
		COMMENT_NOT_EXIT(10018, "该评论不存在或已被删除"),
		VIEWPOINT_CLIENT_SEE(10019, "此观点只能客户能看"),
		VIEWPOINT_CLIENT_WRITE(10020, "此观点只有登录用户能评论"),
		NOT_ADVISER_TYPE(10021, "非自媒体身份不能发表观点"),
		NOT_PERMISSION (10022, "没权限进行操作"),
		CONTENT_OUT_LIMIT(10023,"你输入的内容过长"),
		PRICE_LENGTH_LIMIT(10024,"你输入的成本价长度过长"),
		ASK_CONTENT_NULL(10025,"你输入的问题为空"),
		ANSWER_CONTENT_NULL(10026,"你解答的内容为空"),
		ASK_CONTENT_LENGTH_LIMIT(10027,"你输入的问题长度过长"),
		ANSWER_CONTENT_LENGTH_LIMIT(10028,"你输入的内容长度过长"),
		ANSWER_CONTENT_LENGTH_SHORT(10029,"您的解答内容太过于简单啦，请输入至少20个字的解答！"),
		ONE_UNSATISFIED_MSG(10030,"很抱歉，解答没能让您满意，您可以重发给其他自媒体来解答，现在重发吗？"),
		TWO_UNSATISFIED_MSG(10031,"很抱歉，解答没能让您满意。"),
		ADVISER_NOT_ASK(10032, "您已是自媒体，不能向其他自媒体提问哦"),
		ADVISER_FIRST_ASK(10033, "首次提问，请进行投资偏好测评");
//		NOT_ATTENTION_MEDIA(100034, "TA暂不接受陌生人的提问，您可以添加关注后向TA提问。");
		
		
		private int code;
		private String message;

		private CodeType(int code, String message) {
			this.code = code;
			this.message = message;
			map.put(code, this);
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public static final String getMessage(int code) {
			CodeType _code = map.get(code);
			if (_code == null) {
				return ERROR_UNKNOWN.getMessage();
			}
			return _code.getMessage();
		}
	}
}
