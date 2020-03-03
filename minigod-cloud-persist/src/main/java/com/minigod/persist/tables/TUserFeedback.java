package com.minigod.persist.tables;
import com.minigod.db4j.table.AllField;
import com.minigod.db4j.table.AbstractTable;
import com.minigod.db4j.table.TableField;
import com.minigod.db4j.table.TableFieldImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.minigod.db4j.table.DateTableField;
import com.minigod.db4j.table.DateTableFieldImpl;

public class TUserFeedback extends AbstractTable {

	static {
		init();
	}

	private TUserFeedback(){
		super.tableName = "user_feedback";
	}

	private TUserFeedback(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserFeedback getInstance() {
		return new TUserFeedback();
	}

	public static final TUserFeedback getInstance(String aliasName) {
		return new TUserFeedback(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("feedbackId", "feedback_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("nickName", "nick_name");
		allFieldMap.put("contact", "contact");
		allFieldMap.put("ip", "ip");
		allFieldMap.put("content", "content");
		allFieldMap.put("imageUrl", "image_url");
		allFieldMap.put("source", "source");
		allFieldMap.put("replyStatus", "reply_status");
		allFieldMap.put("replyTime", "reply_time");
		allFieldMap.put("handleStatus", "handle_status");
		allFieldMap.put("handleComment", "handle_comment");
		allFieldMap.put("handleTime", "handle_time");
		allFieldMap.put("handleOpr", "handle_opr");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 用户反馈ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"feedback_id","feedbackId","用户反馈ID");
	public final TableField<Integer> feedbackId = new TableFieldImpl<Integer>(this,"feedback_id","feedbackId","用户反馈ID");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 *  | varchar(255)
	 */
	public final TableField<String> nickName = new TableFieldImpl<String>(this,"nick_name","nickName","");

	/**
	 *  | varchar(255)
	 */
	public final TableField<String> contact = new TableFieldImpl<String>(this,"contact","contact","");

	/**
	 *  | varchar(255)
	 */
	public final TableField<String> ip = new TableFieldImpl<String>(this,"ip","ip","");

	/**
	 *  | varchar(1000)
	 */
	public final TableField<String> content = new TableFieldImpl<String>(this,"content","content","");

	/**
	 *  | varchar(1000)
	 */
	public final TableField<String> imageUrl = new TableFieldImpl<String>(this,"image_url","imageUrl","");

	/**
	 *  | varchar(255)
	 */
	public final TableField<String> source = new TableFieldImpl<String>(this,"source","source","");

	/**
	 * 回复状态(N-未回复,Y-已回复) | char(1)
	 */
	public final TableField<String> replyStatus = new TableFieldImpl<String>(this,"reply_status","replyStatus","回复状态(N-未回复,Y-已回复)");

	/**
	 * 最近回复时间 | datetime
	 */
	public final DateTableField<Date> replyTime = new DateTableFieldImpl<Date>(this,"reply_time","replyTime","最近回复时间");

	/**
	 * 是否已经处理(N-待处理,Y-已处理) | char(1)
	 */
	public final TableField<String> handleStatus = new TableFieldImpl<String>(this,"handle_status","handleStatus","是否已经处理(N-待处理,Y-已处理)");

	/**
	 *  | varchar(255)
	 */
	public final TableField<String> handleComment = new TableFieldImpl<String>(this,"handle_comment","handleComment","");

	/**
	 * 最后处理时间 | datetime
	 */
	public final DateTableField<Date> handleTime = new DateTableFieldImpl<Date>(this,"handle_time","handleTime","最后处理时间");

	/**
	 * 处理人 | int(11)
	 */
	public final TableField<Integer> handleOpr = new TableFieldImpl<Integer>(this,"handle_opr","handleOpr","处理人");

	/**
	 * 记录状态(默认1有效，0无效) | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态(默认1有效，0无效)");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 最后修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","最后修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {feedbackId,userId,nickName,contact,ip,content,imageUrl,source,replyStatus,replyTime,handleStatus,handleComment,handleTime,handleOpr,isStatus,createTime,updateTime};

	public TableField<?>[] getAllFields() {
		return allFields;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getPK() {
		return pk;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getLockVersion() {
		return null;
	}

	public final boolean isAutoGeneratedPK() {
		return true;
	}

	public final boolean isLockVersion() {
		return false;
	}

	public String toString() {
		return "TUserFeedback[table=user_feedback]";
	}
}
