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

public class TInformSysMsg extends AbstractTable {

	static {
		init();
	}

	private TInformSysMsg(){
		super.tableName = "inform_sys_msg";
	}

	private TInformSysMsg(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TInformSysMsg getInstance() {
		return new TInformSysMsg();
	}

	public static final TInformSysMsg getInstance(String aliasName) {
		return new TInformSysMsg(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("msgType", "msg_type");
		allFieldMap.put("msgLevel", "msg_level");
		allFieldMap.put("tempCode", "temp_code");
		allFieldMap.put("title", "title");
		allFieldMap.put("content", "content");
		allFieldMap.put("clientType", "client_type");
		allFieldMap.put("msgGroup", "msg_group");
		allFieldMap.put("targetId", "target_id");
		allFieldMap.put("sendType", "send_type");
		allFieldMap.put("sendWay", "send_way");
		allFieldMap.put("sendTime", "send_time");
		allFieldMap.put("sendStatus", "send_status");
		allFieldMap.put("retryCnt", "retry_cnt");
		allFieldMap.put("oprId", "opr_id");
		allFieldMap.put("oprName", "opr_name");
		allFieldMap.put("url", "url");
		allFieldMap.put("updVersion", "upd_version");
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
	 * 主键 | bigint(20)
	 */
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"id","id","主键");
	public final TableField<Long> id = new TableFieldImpl<Long>(this,"id","id","主键");

	/**
	 * 消息类型(A:活动 R:提醒 N:公告 X:要闻 B:播报) | char(1)
	 */
	public final TableField<String> msgType = new TableFieldImpl<String>(this,"msg_type","msgType","消息类型(A:活动 R:提醒 N:公告 X:要闻 B:播报)");

	/**
	 * 消息级别(I:重要 G:普通) | char(1)
	 */
	public final TableField<String> msgLevel = new TableFieldImpl<String>(this,"msg_level","msgLevel","消息级别(I:重要 G:普通)");

	/**
	 * 通知模板编码 | int(10)
	 */
	public final TableField<Integer> tempCode = new TableFieldImpl<Integer>(this,"temp_code","tempCode","通知模板编码");

	/**
	 * 标题 | varchar(100)
	 */
	public final TableField<String> title = new TableFieldImpl<String>(this,"title","title","标题");

	/**
	 * 通知内容 | varchar(2000)
	 */
	public final TableField<String> content = new TableFieldImpl<String>(this,"content","content","通知内容");

	/**
	 * 客户端类型(0-全部终端 1-Android 2-IOS) | int(1)
	 */
	public final TableField<Integer> clientType = new TableFieldImpl<Integer>(this,"client_type","clientType","客户端类型(0-全部终端 1-Android 2-IOS)");

	/**
	 * 消息分组(P-个人，A-全站，L-标签用户，T-用户分组) | char(1)
	 */
	public final TableField<String> msgGroup = new TableFieldImpl<String>(this,"msg_group","msgGroup","消息分组(P-个人，A-全站，L-标签用户，T-用户分组)");

	/**
	 * msg_group=P时,记录为用户id;当msg_group=A时,为0 | int(11)
	 */
	public final TableField<Integer> targetId = new TableFieldImpl<Integer>(this,"target_id","targetId","msg_group=P时,记录为用户id;当msg_group=A时,为0");

	/**
	 * 推送类型(0-强消息 1-弱消息) | int(1)
	 */
	public final TableField<Integer> sendType = new TableFieldImpl<Integer>(this,"send_type","sendType","推送类型(0-强消息 1-弱消息)");

	/**
	 * 推送方式(0-即时 1-定时) | int(1)
	 */
	public final TableField<Integer> sendWay = new TableFieldImpl<Integer>(this,"send_way","sendWay","推送方式(0-即时 1-定时)");

	/**
	 * 推送时间,推送方式为定时时,不为空 | datetime
	 */
	public final DateTableField<Date> sendTime = new DateTableFieldImpl<Date>(this,"send_time","sendTime","推送时间,推送方式为定时时,不为空");

	/**
	 * 推送状态(0-未发送，1-已发送 2-发送失败) | int(1)
	 */
	public final TableField<Integer> sendStatus = new TableFieldImpl<Integer>(this,"send_status","sendStatus","推送状态(0-未发送，1-已发送 2-发送失败)");

	/**
	 * 重发次数 | int(10)
	 */
	public final TableField<Integer> retryCnt = new TableFieldImpl<Integer>(this,"retry_cnt","retryCnt","重发次数");

	/**
	 * 权限审核人ID | int(11)
	 */
	public final TableField<Integer> oprId = new TableFieldImpl<Integer>(this,"opr_id","oprId","权限审核人ID");

	/**
	 * 权限审核人名称 | varchar(30)
	 */
	public final TableField<String> oprName = new TableFieldImpl<String>(this,"opr_name","oprName","权限审核人名称");

	/**
	 * 跳转页面地址 | varchar(100)
	 */
	public final TableField<String> url = new TableFieldImpl<String>(this,"url","url","跳转页面地址");

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

	private final TableField<?>[] allFields = new TableField<?>[] {id,msgType,msgLevel,tempCode,title,content,clientType,msgGroup,targetId,sendType,sendWay,sendTime,sendStatus,retryCnt,oprId,oprName,url,updVersion,createTime,updateTime};

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
		return "TInformSysMsg[table=inform_sys_msg]";
	}
}
