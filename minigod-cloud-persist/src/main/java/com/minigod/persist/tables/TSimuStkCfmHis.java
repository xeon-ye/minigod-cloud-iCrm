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

public class TSimuStkCfmHis extends AbstractTable {

	static {
		init();
	}

	private TSimuStkCfmHis(){
		super.tableName = "simu_stk_cfm_his";
	}

	private TSimuStkCfmHis(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSimuStkCfmHis getInstance() {
		return new TSimuStkCfmHis();
	}

	public static final TSimuStkCfmHis getInstance(String aliasName) {
		return new TSimuStkCfmHis(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("simuStkCfmId", "simu_stk_cfm_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("simuStkOrdId", "simu_stk_ord_id");
		allFieldMap.put("simuOrdSeq", "simu_ord_seq");
		allFieldMap.put("exchangeType", "exchange_type");
		allFieldMap.put("stkCode", "stk_code");
		allFieldMap.put("stkAcc", "stk_acc");
		allFieldMap.put("busType", "bus_type");
		allFieldMap.put("simuCfmSeq", "simu_cfm_seq");
		allFieldMap.put("cfmTime", "cfm_time");
		allFieldMap.put("cfmTrd", "cfm_trd");
		allFieldMap.put("cfmPrc", "cfm_prc");
		allFieldMap.put("cfmQty", "cfm_qty");
		allFieldMap.put("cfmAmt", "cfm_amt");
		allFieldMap.put("cfmFee", "cfm_fee");
		allFieldMap.put("cfmTax", "cfm_tax");
		allFieldMap.put("cfmTransferFee", "cfm_transfer_fee");
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
	 * 个股成交ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"simu_stk_cfm_id","simuStkCfmId","个股成交ID");
	public final TableField<Integer> simuStkCfmId = new TableFieldImpl<Integer>(this,"simu_stk_cfm_id","simuStkCfmId","个股成交ID");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 组合ID | int(11)
	 */
	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合ID");

	/**
	 * 个股委托ID | int(11)
	 */
	public final TableField<Integer> simuStkOrdId = new TableFieldImpl<Integer>(this,"simu_stk_ord_id","simuStkOrdId","个股委托ID");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> simuOrdSeq = new TableFieldImpl<String>(this,"simu_ord_seq","simuOrdSeq","");

	/**
	 *  | varchar(6)
	 */
	public final TableField<String> exchangeType = new TableFieldImpl<String>(this,"exchange_type","exchangeType","");

	/**
	 *  | varchar(12)
	 */
	public final TableField<String> stkCode = new TableFieldImpl<String>(this,"stk_code","stkCode","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> stkAcc = new TableFieldImpl<String>(this,"stk_acc","stkAcc","");

	/**
	 * 业务类别 | char(2)
	 */
	public final TableField<String> busType = new TableFieldImpl<String>(this,"bus_type","busType","业务类别");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> simuCfmSeq = new TableFieldImpl<String>(this,"simu_cfm_seq","simuCfmSeq","");

	/**
	 * 成交时间 | datetime
	 */
	public final DateTableField<Date> cfmTime = new DateTableFieldImpl<Date>(this,"cfm_time","cfmTime","成交时间");

	/**
	 * 成交日期 | date
	 */
	public final DateTableField<Date> cfmTrd = new DateTableFieldImpl<Date>(this,"cfm_trd","cfmTrd","成交日期");

	/**
	 * 成交价格 | decimal(10,4)
	 */
	public final TableField<Double> cfmPrc = new TableFieldImpl<Double>(this,"cfm_prc","cfmPrc","成交价格");

	/**
	 * 成交数量 | decimal(16,4)
	 */
	public final TableField<Double> cfmQty = new TableFieldImpl<Double>(this,"cfm_qty","cfmQty","成交数量");

	/**
	 * 成交金额 | decimal(16,4)
	 */
	public final TableField<Double> cfmAmt = new TableFieldImpl<Double>(this,"cfm_amt","cfmAmt","成交金额");

	/**
	 * 交易佣金 | decimal(16,4)
	 */
	public final TableField<Double> cfmFee = new TableFieldImpl<Double>(this,"cfm_fee","cfmFee","交易佣金");

	/**
	 * 印花税 | decimal(16,4)
	 */
	public final TableField<Double> cfmTax = new TableFieldImpl<Double>(this,"cfm_tax","cfmTax","印花税");

	/**
	 * 过户费 | decimal(16,4)
	 */
	public final TableField<Double> cfmTransferFee = new TableFieldImpl<Double>(this,"cfm_transfer_fee","cfmTransferFee","过户费");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {simuStkCfmId,userId,ptfId,simuStkOrdId,simuOrdSeq,exchangeType,stkCode,stkAcc,busType,simuCfmSeq,cfmTime,cfmTrd,cfmPrc,cfmQty,cfmAmt,cfmFee,cfmTax,cfmTransferFee,createTime,updateTime};

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
		return false;
	}

	public final boolean isLockVersion() {
		return false;
	}

	public String toString() {
		return "TSimuStkCfmHis[table=simu_stk_cfm_his]";
	}
}
