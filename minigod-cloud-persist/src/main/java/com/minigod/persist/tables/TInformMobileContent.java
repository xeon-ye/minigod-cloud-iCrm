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

public class TInformMobileContent extends AbstractTable {

	static {
		init();
	}

	private TInformMobileContent(){
		super.tableName = "inform_mobile_content";
	}

	private TInformMobileContent(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TInformMobileContent getInstance() {
		return new TInformMobileContent();
	}

	public static final TInformMobileContent getInstance(String aliasName) {
		return new TInformMobileContent(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("tempCode", "temp_code");
		allFieldMap.put("userType", "user_type");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("cellPhone", "cell_phone");
		allFieldMap.put("title", "title");
		allFieldMap.put("content", "content");
		allFieldMap.put("discription", "discription");
		allFieldMap.put("channel", "channel");
		allFieldMap.put("sendStatus", "send_status");
		allFieldMap.put("sendType", "send_type");
		allFieldMap.put("timing", "timing");
		allFieldMap.put("failCnt", "fail_cnt");
		allFieldMap.put("retryCnt", "retry_cnt");
		allFieldMap.put("sendTime", "send_time");
		allFieldMap.put("receiveTime", "receive_time");
		allFieldMap.put("oprId", "opr_id");
		allFieldMap.put("oprName", "opr_name");
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
	 * 模板编码 | int(10)
	 */
	public final TableField<Integer> tempCode = new TableFieldImpl<Integer>(this,"temp_code","tempCode","模板编码");

	/**
	 * 用户类型 | int(1)
	 */
	public final TableField<Integer> userType = new TableFieldImpl<Integer>(this,"user_type","userType","用户类型");

	/**
	 * 用户ID | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 手机号码 | varchar(20)
	 */
	public final TableField<String> cellPhone = new TableFieldImpl<String>(this,"cell_phone","cellPhone","手机号码");

	/**
	 * 短信标题 | varchar(100)
	 */
	public final TableField<String> title = new TableFieldImpl<String>(this,"title","title","短信标题");

	/**
	 * 短信内容 | varchar(2000)
	 */
	public final TableField<String> content = new TableFieldImpl<String>(this,"content","content","短信内容");

	/**
	 * 描述 | varchar(100)
	 */
	public final TableField<String> discription = new TableFieldImpl<String>(this,"discription","discription","描述");

	/**
	 * 短信渠道(1:玖富) | int(2)
	 */
	public final TableField<Integer> channel = new TableFieldImpl<Integer>(this,"channel","channel","短信渠道(1:玖富)");

	/**
	 * 推送状态(0-未发送，1-已发送 2-发送失败) | int(1)
	 */
	public final TableField<Integer> sendStatus = new TableFieldImpl<Integer>(this,"send_status","sendStatus","推送状态(0-未发送，1-已发送 2-发送失败)");

	/**
	 * 发送类型(0-即时 1-定时) | int(1)
	 */
	public final TableField<Integer> sendType = new TableFieldImpl<Integer>(this,"send_type","sendType","发送类型(0-即时 1-定时)");

	/**
	 * 定时发送时间 | datetime
	 */
	public final DateTableField<Date> timing = new DateTableFieldImpl<Date>(this,"timing","timing","定时发送时间");

	/**
	 * 失败次数 | int(10)
	 */
	public final TableField<Integer> failCnt = new TableFieldImpl<Integer>(this,"fail_cnt","failCnt","失败次数");

	/**
	 * 重发次数 | int(10)
	 */
	public final TableField<Integer> retryCnt = new TableFieldImpl<Integer>(this,"retry_cnt","retryCnt","重发次数");

	/**
	 * 发送时间 | datetime
	 */
	public final DateTableField<Date> sendTime = new DateTableFieldImpl<Date>(this,"send_time","sendTime","发送时间");

	/**
	 * 接收时间 | datetime
	 */
	public final DateTableField<Date> receiveTime = new DateTableFieldImpl<Date>(this,"receive_time","receiveTime","接收时间");

	/**
	 * 权限审核人ID | int(11)
	 */
	public final TableField<Integer> oprId = new TableFieldImpl<Integer>(this,"opr_id","oprId","权限审核人ID");

	/**
	 * 权限审核人名称 | varchar(30)
	 */
	public final TableField<String> oprName = new TableFieldImpl<String>(this,"opr_name","oprName","权限审核人名称");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","更新时间");

	private final TableField<?>[] allFields = new TableField<?>[] {id,tempCode,userType,userId,cellPhone,title,content,discription,channel,sendStatus,sendType,timing,failCnt,retryCnt,sendTime,receiveTime,oprId,oprName,createTime,updateTime};

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
		return "TInformMobileContent[table=inform_mobile_content]";
	}
}
