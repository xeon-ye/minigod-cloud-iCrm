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

public class TSimuPtfTrans extends AbstractTable {

	static {
		init();
	}

	private TSimuPtfTrans(){
		super.tableName = "simu_ptf_trans";
	}

	private TSimuPtfTrans(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSimuPtfTrans getInstance() {
		return new TSimuPtfTrans();
	}

	public static final TSimuPtfTrans getInstance(String aliasName) {
		return new TSimuPtfTrans(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("simuPtfTransId", "simu_ptf_trans_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("clientReqId", "client_req_id");
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("transType", "trans_type");
		allFieldMap.put("orderTime", "order_time");
		allFieldMap.put("orderTrd", "order_trd");
		allFieldMap.put("comment", "comment");
		allFieldMap.put("imGroupIds", "im_group_ids");
		allFieldMap.put("ptfVersion", "ptf_version");
		allFieldMap.put("orderStatus", "order_status");
		allFieldMap.put("ptfSendStatus", "ptf_send_status");
		allFieldMap.put("finishStatus", "finish_status");
		allFieldMap.put("confirmStatus", "confirm_status");
		allFieldMap.put("confirmTime", "confirm_time");
		allFieldMap.put("withdrawStatus", "withdraw_status");
		allFieldMap.put("withdrawTime", "withdraw_time");
		allFieldMap.put("orgTransId", "org_trans_id");
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
	 * 交易编号 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"simu_ptf_trans_id","simuPtfTransId","交易编号");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","交易编号");

	public final TableField<Integer> simuPtfTransId = new TableFieldImpl<Integer>(this,"simu_ptf_trans_id","simuPtfTransId","交易编号");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> clientReqId = new TableFieldImpl<String>(this,"client_req_id","clientReqId","");

	/**
	 * 组合ID | int(11)
	 */
	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合ID");

	/**
	 * 交易类型 | char(1)
	 */
	public final TableField<String> transType = new TableFieldImpl<String>(this,"trans_type","transType","交易类型");

	/**
	 * 委托时间 | datetime
	 */
	public final DateTableField<Date> orderTime = new DateTableFieldImpl<Date>(this,"order_time","orderTime","委托时间");

	/**
	 * 委托交易日 | date
	 */
	public final DateTableField<Date> orderTrd = new DateTableFieldImpl<Date>(this,"order_trd","orderTrd","委托交易日");

	/**
	 *  | varchar(500)
	 */
	public final TableField<String> comment = new TableFieldImpl<String>(this,"comment","comment","");

	/**
	 * 分享的群组列表 | varchar(500)
	 */
	public final TableField<String> imGroupIds = new TableFieldImpl<String>(this,"im_group_ids","imGroupIds","分享的群组列表");

	/**
	 * 组合版本号 | int(11)
	 */
	public final TableField<Integer> ptfVersion = new TableFieldImpl<Integer>(this,"ptf_version","ptfVersion","组合版本号");

	/**
	 * 委托总状态 | char(1)
	 */
	public final TableField<String> orderStatus = new TableFieldImpl<String>(this,"order_status","orderStatus","委托总状态");

	/**
	 * 发送状态 | char(1)
	 */
	public final TableField<String> ptfSendStatus = new TableFieldImpl<String>(this,"ptf_send_status","ptfSendStatus","发送状态");

	/**
	 * 结束状态 | char(1)
	 */
	public final TableField<String> finishStatus = new TableFieldImpl<String>(this,"finish_status","finishStatus","结束状态");

	/**
	 * 成交状态 | char(1)
	 */
	public final TableField<String> confirmStatus = new TableFieldImpl<String>(this,"confirm_status","confirmStatus","成交状态");

	/**
	 * 成交时间 | datetime
	 */
	public final DateTableField<Date> confirmTime = new DateTableFieldImpl<Date>(this,"confirm_time","confirmTime","成交时间");

	/**
	 * 撤单状态 | char(1)
	 */
	public final TableField<String> withdrawStatus = new TableFieldImpl<String>(this,"withdraw_status","withdrawStatus","撤单状态");

	/**
	 * 撤单时间 | datetime
	 */
	public final DateTableField<Date> withdrawTime = new DateTableFieldImpl<Date>(this,"withdraw_time","withdrawTime","撤单时间");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> orgTransId = new TableFieldImpl<String>(this,"org_trans_id","orgTransId","");

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

	private final TableField<?>[] allFields = new TableField<?>[] {simuPtfTransId,userId,clientReqId,ptfId,transType,orderTime,orderTrd,comment,imGroupIds,ptfVersion,orderStatus,ptfSendStatus,finishStatus,confirmStatus,confirmTime,withdrawStatus,withdrawTime,orgTransId,createTime,updateTime,lockVersion};

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
		return "TSimuPtfTrans[table=simu_ptf_trans]";
	}
}
