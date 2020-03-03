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

public class TInvestMsg extends AbstractTable {

	static {
		init();
	}

	private TInvestMsg(){
		super.tableName = "invest_msg";
	}

	private TInvestMsg(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TInvestMsg getInstance() {
		return new TInvestMsg();
	}

	public static final TInvestMsg getInstance(String aliasName) {
		return new TInvestMsg(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("msgId", "msg_id");
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("fromUser", "from_user");
		allFieldMap.put("msgType", "msg_type");
		allFieldMap.put("displayGroup", "display_group");
		allFieldMap.put("title", "title");
		allFieldMap.put("msgContent", "msg_content");
		allFieldMap.put("relaType", "rela_type");
		allFieldMap.put("relaId", "rela_id");
		allFieldMap.put("relaText", "rela_text");
		allFieldMap.put("srcType", "src_type");
		allFieldMap.put("srcId", "src_id");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("updVersion", "upd_version");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("sendTime", "send_time");
		allFieldMap.put("sendStatus", "send_status");
		allFieldMap.put("sendWay", "send_way");
		allFieldMap.put("msgGroup", "msg_group");
		allFieldMap.put("clientType", "client_type");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 信息ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"msg_id","msgId","信息ID");
	public final TableField<Integer> msgId = new TableFieldImpl<Integer>(this,"msg_id","msgId","信息ID");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 发表人ID | int(11)
	 */
	public final TableField<Integer> fromUser = new TableFieldImpl<Integer>(this,"from_user","fromUser","发表人ID");

	/**
	 * 消息类型 | char(1)
	 */
	public final TableField<String> msgType = new TableFieldImpl<String>(this,"msg_type","msgType","消息类型");

	/**
	 * 消息显示分组 | int(11)
	 */
	public final TableField<Integer> displayGroup = new TableFieldImpl<Integer>(this,"display_group","displayGroup","消息显示分组");

	/**
	 * 消息标题 | varchar(64)
	 */
	public final TableField<String> title = new TableFieldImpl<String>(this,"title","title","消息标题");

	/**
	 *  | varchar(1024)
	 */
	public final TableField<String> msgContent = new TableFieldImpl<String>(this,"msg_content","msgContent","");

	/**
	 * 关联对象类型 | char(1)
	 */
	public final TableField<String> relaType = new TableFieldImpl<String>(this,"rela_type","relaType","关联对象类型");

	/**
	 * 关联对象ID | bigint(20)
	 */
	public final TableField<Long> relaId = new TableFieldImpl<Long>(this,"rela_id","relaId","关联对象ID");

	/**
	 *  | varchar(500)
	 */
	public final TableField<String> relaText = new TableFieldImpl<String>(this,"rela_text","relaText","");

	/**
	 * 源表类型 | char(1)
	 */
	public final TableField<String> srcType = new TableFieldImpl<String>(this,"src_type","srcType","源表类型");

	/**
	 * 源表ID | int(11)
	 */
	public final TableField<Integer> srcId = new TableFieldImpl<Integer>(this,"src_id","srcId","源表ID");

	/**
	 * 是否有效 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","是否有效");

	/**
	 * 更新版本号 | bigint(19)
	 */
	public final TableField<Long> updVersion = new TableFieldImpl<Long>(this,"upd_version","updVersion","更新版本号");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","更新时间");

	/**
	 * 推送时间,推送方式为定时时,不为空 | datetime
	 */
	public final DateTableField<Date> sendTime = new DateTableFieldImpl<Date>(this,"send_time","sendTime","推送时间,推送方式为定时时,不为空");

	/**
	 * 推送状态(0-未发送，1-已发送 2-发送失败) | int(1)
	 */
	public final TableField<Integer> sendStatus = new TableFieldImpl<Integer>(this,"send_status","sendStatus","推送状态(0-未发送，1-已发送 2-发送失败)");

	/**
	 * 推送方式(0-即时 1-定时) | int(1)
	 */
	public final TableField<Integer> sendWay = new TableFieldImpl<Integer>(this,"send_way","sendWay","推送方式(0-即时 1-定时)");

	/**
	 * 消息分组(P-个人，A-全站，L-标签用户，T-用户分组) | char(1)
	 */
	public final TableField<String> msgGroup = new TableFieldImpl<String>(this,"msg_group","msgGroup","消息分组(P-个人，A-全站，L-标签用户，T-用户分组)");

	/**
	 * 客户端类型(0-全部终端 1-Android 2-IOS) | int(1)
	 */
	public final TableField<Integer> clientType = new TableFieldImpl<Integer>(this,"client_type","clientType","客户端类型(0-全部终端 1-Android 2-IOS)");

	private final TableField<?>[] allFields = new TableField<?>[] {msgId,ptfId,userId,fromUser,msgType,displayGroup,title,msgContent,relaType,relaId,relaText,srcType,srcId,isStatus,updVersion,createTime,updateTime,sendTime,sendStatus,sendWay,msgGroup,clientType};

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
		return "TInvestMsg[table=invest_msg]";
	}
}
