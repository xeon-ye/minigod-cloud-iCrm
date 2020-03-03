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

public class TRealStkCfmHis extends AbstractTable {

	static {
		init();
	}

	private TRealStkCfmHis(){
		super.tableName = "real_stk_cfm_his";
	}

	private TRealStkCfmHis(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TRealStkCfmHis getInstance() {
		return new TRealStkCfmHis();
	}

	public static final TRealStkCfmHis getInstance(String aliasName) {
		return new TRealStkCfmHis(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("realStkCfmId", "real_stk_cfm_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("brokerId", "broker_id");
		allFieldMap.put("brkCustid", "brk_custid");
		allFieldMap.put("brkOrdSeq", "brk_ord_seq");
		allFieldMap.put("depositAcc", "deposit_acc");
		allFieldMap.put("exchangeType", "exchange_type");
		allFieldMap.put("stkCode", "stk_code");
		allFieldMap.put("stkAcc", "stk_acc");
		allFieldMap.put("busType", "bus_type");
		allFieldMap.put("cfmStatus", "cfm_status");
		allFieldMap.put("brkCfmSeq", "brk_cfm_seq");
		allFieldMap.put("cfmTime", "cfm_time");
		allFieldMap.put("cfmTrd", "cfm_trd");
		allFieldMap.put("cfmPrc", "cfm_prc");
		allFieldMap.put("cfmQty", "cfm_qty");
		allFieldMap.put("cfmAmt", "cfm_amt");
		allFieldMap.put("cfmFee", "cfm_fee");
		allFieldMap.put("cfmTax", "cfm_tax");
		allFieldMap.put("cfmTransferFee", "cfm_transfer_fee");
		allFieldMap.put("cfmClearFee", "cfm_clear_fee");
		allFieldMap.put("cfmRegularFee", "cfm_regular_fee");
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
	 * 个股成交ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"real_stk_cfm_id","realStkCfmId","个股成交ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","个股成交ID");

	public final TableField<Integer> realStkCfmId = new TableFieldImpl<Integer>(this,"real_stk_cfm_id","realStkCfmId","个股成交ID");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 券商ID | int(11)
	 */
	public final TableField<Integer> brokerId = new TableFieldImpl<Integer>(this,"broker_id","brokerId","券商ID");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> brkCustid = new TableFieldImpl<String>(this,"brk_custid","brkCustid","");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> brkOrdSeq = new TableFieldImpl<String>(this,"brk_ord_seq","brkOrdSeq","");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> depositAcc = new TableFieldImpl<String>(this,"deposit_acc","depositAcc","");

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
	 * 业务类别(B-买入,S-卖出,W-撤单) | char(2)
	 */
	public final TableField<String> busType = new TableFieldImpl<String>(this,"bus_type","busType","业务类别(B-买入,S-卖出,W-撤单)");

	/**
	 * 成交状态 | char(1)
	 */
	public final TableField<String> cfmStatus = new TableFieldImpl<String>(this,"cfm_status","cfmStatus","成交状态");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> brkCfmSeq = new TableFieldImpl<String>(this,"brk_cfm_seq","brkCfmSeq","");

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
	 * 手续费 | decimal(16,4)
	 */
	public final TableField<Double> cfmFee = new TableFieldImpl<Double>(this,"cfm_fee","cfmFee","手续费");

	/**
	 * 印花税 | decimal(16,4)
	 */
	public final TableField<Double> cfmTax = new TableFieldImpl<Double>(this,"cfm_tax","cfmTax","印花税");

	/**
	 * 过户费 | decimal(16,4)
	 */
	public final TableField<Double> cfmTransferFee = new TableFieldImpl<Double>(this,"cfm_transfer_fee","cfmTransferFee","过户费");

	/**
	 * 清算费 | decimal(16,4)
	 */
	public final TableField<Double> cfmClearFee = new TableFieldImpl<Double>(this,"cfm_clear_fee","cfmClearFee","清算费");

	/**
	 * 交易规费 | decimal(16,4)
	 */
	public final TableField<Double> cfmRegularFee = new TableFieldImpl<Double>(this,"cfm_regular_fee","cfmRegularFee","交易规费");

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

	private final TableField<?>[] allFields = new TableField<?>[] {realStkCfmId,userId,brokerId,brkCustid,brkOrdSeq,depositAcc,exchangeType,stkCode,stkAcc,busType,cfmStatus,brkCfmSeq,cfmTime,cfmTrd,cfmPrc,cfmQty,cfmAmt,cfmFee,cfmTax,cfmTransferFee,cfmClearFee,cfmRegularFee,createTime,updateTime,lockVersion};

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
		return false;
	}

	public final boolean isLockVersion() {
		return true;
	}

	public String toString() {
		return "TRealStkCfmHis[table=real_stk_cfm_his]";
	}
}
