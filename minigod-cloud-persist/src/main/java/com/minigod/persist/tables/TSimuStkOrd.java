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

public class TSimuStkOrd extends AbstractTable {

	static {
		init();
	}

	private TSimuStkOrd(){
		super.tableName = "simu_stk_ord";
	}

	private TSimuStkOrd(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSimuStkOrd getInstance() {
		return new TSimuStkOrd();
	}

	public static final TSimuStkOrd getInstance(String aliasName) {
		return new TSimuStkOrd(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("simuStkOrdId", "simu_stk_ord_id");
		allFieldMap.put("simuPtfTransId", "simu_ptf_trans_id");
		allFieldMap.put("assetId", "asset_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("exchangeType", "exchange_type");
		allFieldMap.put("stkCode", "stk_code");
		allFieldMap.put("busType", "bus_type");
		allFieldMap.put("priceType", "price_type");
		allFieldMap.put("ordQty", "ord_qty");
		allFieldMap.put("ordPrc", "ord_prc");
		allFieldMap.put("orgSimuOrdSeq", "org_simu_ord_seq");
		allFieldMap.put("orderTrd", "order_trd");
		allFieldMap.put("simuOrdSeq", "simu_ord_seq");
		allFieldMap.put("innerRetCode", "inner_ret_code");
		allFieldMap.put("outRetCode", "out_ret_code");
		allFieldMap.put("outRetMsg", "out_ret_msg");
		allFieldMap.put("stkDisplayStatus", "stk_display_status");
		allFieldMap.put("stkSendStatus", "stk_send_status");
		allFieldMap.put("stkFinishStatus", "stk_finish_status");
		allFieldMap.put("simuStkOrderStatus", "simu_stk_order_status");
		allFieldMap.put("cfmQty", "cfm_qty");
		allFieldMap.put("cfmPrc", "cfm_prc");
		allFieldMap.put("cfmAmt", "cfm_amt");
		allFieldMap.put("wthQty", "wth_qty");
		allFieldMap.put("stkSendTime", "stk_send_time");
		allFieldMap.put("simuOrdTime", "simu_ord_time");
		allFieldMap.put("stkSyncTime", "stk_sync_time");
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
	 * 个股委托ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"simu_stk_ord_id","simuStkOrdId","个股委托ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","个股委托ID");

	public final TableField<Integer> simuStkOrdId = new TableFieldImpl<Integer>(this,"simu_stk_ord_id","simuStkOrdId","个股委托ID");

	/**
	 * 组合交易ID | int(11)
	 */
	public final TableField<Integer> simuPtfTransId = new TableFieldImpl<Integer>(this,"simu_ptf_trans_id","simuPtfTransId","组合交易ID");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> assetId = new TableFieldImpl<String>(this,"asset_id","assetId","");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 组合ID | int(11)
	 */
	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合ID");

	/**
	 *  | varchar(6)
	 */
	public final TableField<String> exchangeType = new TableFieldImpl<String>(this,"exchange_type","exchangeType","");

	/**
	 *  | varchar(12)
	 */
	public final TableField<String> stkCode = new TableFieldImpl<String>(this,"stk_code","stkCode","");

	/**
	 * 业务类别 | char(2)
	 */
	public final TableField<String> busType = new TableFieldImpl<String>(this,"bus_type","busType","业务类别");

	/**
	 * 报价方式 | char(1)
	 */
	public final TableField<String> priceType = new TableFieldImpl<String>(this,"price_type","priceType","报价方式");

	/**
	 * 委托数量 | decimal(16,4)
	 */
	public final TableField<Double> ordQty = new TableFieldImpl<Double>(this,"ord_qty","ordQty","委托数量");

	/**
	 * 委托价格 | decimal(10,4)
	 */
	public final TableField<Double> ordPrc = new TableFieldImpl<Double>(this,"ord_prc","ordPrc","委托价格");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> orgSimuOrdSeq = new TableFieldImpl<String>(this,"org_simu_ord_seq","orgSimuOrdSeq","");

	/**
	 * 委托交易日 | date
	 */
	public final DateTableField<Date> orderTrd = new DateTableFieldImpl<Date>(this,"order_trd","orderTrd","委托交易日");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> simuOrdSeq = new TableFieldImpl<String>(this,"simu_ord_seq","simuOrdSeq","");

	/**
	 * 内部返回码 | int(11)
	 */
	public final TableField<Integer> innerRetCode = new TableFieldImpl<Integer>(this,"inner_ret_code","innerRetCode","内部返回码");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> outRetCode = new TableFieldImpl<String>(this,"out_ret_code","outRetCode","");

	/**
	 *  | varchar(200)
	 */
	public final TableField<String> outRetMsg = new TableFieldImpl<String>(this,"out_ret_msg","outRetMsg","");

	/**
	 * 委托展示状态 | char(1)
	 */
	public final TableField<String> stkDisplayStatus = new TableFieldImpl<String>(this,"stk_display_status","stkDisplayStatus","委托展示状态");

	/**
	 * 委托发送状态 | char(1)
	 */
	public final TableField<String> stkSendStatus = new TableFieldImpl<String>(this,"stk_send_status","stkSendStatus","委托发送状态");

	/**
	 * 委托结束状态 | char(1)
	 */
	public final TableField<String> stkFinishStatus = new TableFieldImpl<String>(this,"stk_finish_status","stkFinishStatus","委托结束状态");

	/**
	 * 模拟委托状态 | char(2)
	 */
	public final TableField<String> simuStkOrderStatus = new TableFieldImpl<String>(this,"simu_stk_order_status","simuStkOrderStatus","模拟委托状态");

	/**
	 * 成交数量 | decimal(16,4)
	 */
	public final TableField<Double> cfmQty = new TableFieldImpl<Double>(this,"cfm_qty","cfmQty","成交数量");

	/**
	 * 平均价格 | decimal(10,4)
	 */
	public final TableField<Double> cfmPrc = new TableFieldImpl<Double>(this,"cfm_prc","cfmPrc","平均价格");

	/**
	 * 成交金额 | decimal(16,4)
	 */
	public final TableField<Double> cfmAmt = new TableFieldImpl<Double>(this,"cfm_amt","cfmAmt","成交金额");

	/**
	 * 撤单数量 | decimal(16,4)
	 */
	public final TableField<Double> wthQty = new TableFieldImpl<Double>(this,"wth_qty","wthQty","撤单数量");

	/**
	 * 发送时间 | datetime
	 */
	public final DateTableField<Date> stkSendTime = new DateTableFieldImpl<Date>(this,"stk_send_time","stkSendTime","发送时间");

	/**
	 * 模拟委托时间 | datetime
	 */
	public final DateTableField<Date> simuOrdTime = new DateTableFieldImpl<Date>(this,"simu_ord_time","simuOrdTime","模拟委托时间");

	/**
	 * 同步时间 | datetime
	 */
	public final DateTableField<Date> stkSyncTime = new DateTableFieldImpl<Date>(this,"stk_sync_time","stkSyncTime","同步时间");

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

	private final TableField<?>[] allFields = new TableField<?>[] {simuStkOrdId,simuPtfTransId,assetId,userId,ptfId,exchangeType,stkCode,busType,priceType,ordQty,ordPrc,orgSimuOrdSeq,orderTrd,simuOrdSeq,innerRetCode,outRetCode,outRetMsg,stkDisplayStatus,stkSendStatus,stkFinishStatus,simuStkOrderStatus,cfmQty,cfmPrc,cfmAmt,wthQty,stkSendTime,simuOrdTime,stkSyncTime,createTime,updateTime,lockVersion};

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
		return "TSimuStkOrd[table=simu_stk_ord]";
	}
}
