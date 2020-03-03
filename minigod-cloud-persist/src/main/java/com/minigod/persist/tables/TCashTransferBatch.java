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

public class TCashTransferBatch extends AbstractTable {

	static {
		init();
	}

	private TCashTransferBatch(){
		super.tableName = "cash_transfer_batch";
	}

	private TCashTransferBatch(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TCashTransferBatch getInstance() {
		return new TCashTransferBatch();
	}

	public static final TCashTransferBatch getInstance(String aliasName) {
		return new TCashTransferBatch(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("cashBatchId", "cash_batch_id");
		allFieldMap.put("userBatchId", "user_batch_id");
		allFieldMap.put("batchOrder", "batch_order");
		allFieldMap.put("status", "status");
		allFieldMap.put("orderMd5", "order_md5");
		allFieldMap.put("parseStatus", "parse_status");
		allFieldMap.put("parseError", "parse_error");
		allFieldMap.put("batchType", "batch_type");
		allFieldMap.put("description", "description");
		allFieldMap.put("executeStatus", "execute_status");
		allFieldMap.put("executeLine", "execute_line");
		allFieldMap.put("currentError", "current_error");
		allFieldMap.put("submitRealName", "submit_real_name");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("lockVersion", "lock_version");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 批次id，自增长字段，主键 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"cash_batch_id","cashBatchId","批次id，自增长字段，主键");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","批次id，自增长字段，主键");

	public final TableField<Integer> cashBatchId = new TableFieldImpl<Integer>(this,"cash_batch_id","cashBatchId","批次id，自增长字段，主键");

	/**
	 * 用户提交请求中的批次ID,日期+批次类别+两位日内序号,EX:20150126A01 | char(11)
	 */
	public final TableField<String> userBatchId = new TableFieldImpl<String>(this,"user_batch_id","userBatchId","用户提交请求中的批次ID,日期+批次类别+两位日内序号,EX:20150126A01");

	/**
	 * 客户提交的批次信息 | mediumtext
	 */
	public final TableField<String> batchOrder = new TableFieldImpl<String>(this,"batch_order","batchOrder","客户提交的批次信息");

	/**
	 * 整体执行状态，W:准备执行P:执行中E:错误中断，待人工介入S:已结束，处理完毕 | char(1)
	 */
	public final TableField<String> status = new TableFieldImpl<String>(this,"status","status","整体执行状态，W:准备执行P:执行中E:错误中断，待人工介入S:已结束，处理完毕");

	/**
	 * 数据批次信息摘要 | char(32)
	 */
	public final TableField<String> orderMd5 = new TableFieldImpl<String>(this,"order_md5","orderMd5","数据批次信息摘要");

	/**
	 * 转换状态，W:待解析S:解析成功E:解析错误 | char(1)
	 */
	public final TableField<String> parseStatus = new TableFieldImpl<String>(this,"parse_status","parseStatus","转换状态，W:待解析S:解析成功E:解析错误");

	/**
	 * 解析失败原因 | varchar(128)
	 */
	public final TableField<String> parseError = new TableFieldImpl<String>(this,"parse_error","parseError","解析失败原因");

	/**
	 * 批次类型，A:批量发钱 | char(1)
	 */
	public final TableField<String> batchType = new TableFieldImpl<String>(this,"batch_type","batchType","批次类型，A:批量发钱");

	/**
	 * 批次描述 | varchar(128)
	 */
	public final TableField<String> description = new TableFieldImpl<String>(this,"description","description","批次描述");

	/**
	 * 处理状态，W:等待处理P:部分已处理S:全部处理成功 | char(1)
	 */
	public final TableField<String> executeStatus = new TableFieldImpl<String>(this,"execute_status","executeStatus","处理状态，W:等待处理P:部分已处理S:全部处理成功");

	/**
	 * 批次执行到哪里，为传入批次命令的转账请求序号 | int(11)
	 */
	public final TableField<Integer> executeLine = new TableFieldImpl<Integer>(this,"execute_line","executeLine","批次执行到哪里，为传入批次命令的转账请求序号");

	/**
	 * 当前执行行错误信息 | varchar(128)
	 */
	public final TableField<String> currentError = new TableFieldImpl<String>(this,"current_error","currentError","当前执行行错误信息");

	/**
	 * 提交的用户的真实姓名 | varchar(32)
	 */
	public final TableField<String> submitRealName = new TableFieldImpl<String>(this,"submit_real_name","submitRealName","提交的用户的真实姓名");

	/**
	 * 状态，0停用,默认1正常使用 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","状态，0停用,默认1正常使用");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	private final TableField<?>[] allFields = new TableField<?>[] {cashBatchId,userBatchId,batchOrder,status,orderMd5,parseStatus,parseError,batchType,description,executeStatus,executeLine,currentError,submitRealName,isStatus,createTime,updateTime,lockVersion};

	public TableField<?>[] getAllFields() {
		return allFields;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getPK() {
		return pk;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getLockVersion() {
		return lock;
	}

	public final boolean isAutoGeneratedPK() {
		return true;
	}

	public final boolean isLockVersion() {
		return true;
	}

	public String toString() {
		return "TCashTransferBatch[table=cash_transfer_batch]";
	}
}
