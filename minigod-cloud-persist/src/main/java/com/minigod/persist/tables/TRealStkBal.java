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

public class TRealStkBal extends AbstractTable {

	static {
		init();
	}

	private TRealStkBal(){
		super.tableName = "real_stk_bal";
	}

	private TRealStkBal(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TRealStkBal getInstance() {
		return new TRealStkBal();
	}

	public static final TRealStkBal getInstance(String aliasName) {
		return new TRealStkBal(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("realStkBalId", "real_stk_bal_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("brokerId", "broker_id");
		allFieldMap.put("brkCustid", "brk_custid");
		allFieldMap.put("assetId", "asset_id");
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("isCurrent", "is_current");
		allFieldMap.put("isConfirm", "is_confirm");
		allFieldMap.put("depositAcc", "deposit_acc");
		allFieldMap.put("exchangeType", "exchange_type");
		allFieldMap.put("stkCode", "stk_code");
		allFieldMap.put("stkAcc", "stk_acc");
		allFieldMap.put("syncTime", "sync_time");
		allFieldMap.put("totalBal", "total_bal");
		allFieldMap.put("avalBal", "aval_bal");
		allFieldMap.put("buyFrozen", "buy_frozen");
		allFieldMap.put("sellFrozen", "sell_frozen");
		allFieldMap.put("othFrozen", "oth_frozen");
		allFieldMap.put("brkHoldPrice", "brk_hold_price");
		allFieldMap.put("brkBuyPrice", "brk_buy_price");
		allFieldMap.put("ccyType", "ccy_type");
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
	 * 记录ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"real_stk_bal_id","realStkBalId","记录ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","记录ID");

	public final TableField<Integer> realStkBalId = new TableFieldImpl<Integer>(this,"real_stk_bal_id","realStkBalId","记录ID");

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
	 *  | varchar(20)
	 */
	public final TableField<String> assetId = new TableFieldImpl<String>(this,"asset_id","assetId","");

	/**
	 * 组合ID | int(11)
	 */
	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合ID");

	/**
	 * 是否当前持仓 | tinyint(1)
	 */
	public final TableField<Boolean> isCurrent = new TableFieldImpl<Boolean>(this,"is_current","isCurrent","是否当前持仓");

	/**
	 * 是否成交过 | tinyint(1)
	 */
	public final TableField<Boolean> isConfirm = new TableFieldImpl<Boolean>(this,"is_confirm","isConfirm","是否成交过");

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
	 * 同步时间 | datetime
	 */
	public final DateTableField<Date> syncTime = new DateTableFieldImpl<Date>(this,"sync_time","syncTime","同步时间");

	/**
	 * 总余额 | decimal(16,4)
	 */
	public final TableField<Double> totalBal = new TableFieldImpl<Double>(this,"total_bal","totalBal","总余额");

	/**
	 * 可用余额 | decimal(16,4)
	 */
	public final TableField<Double> avalBal = new TableFieldImpl<Double>(this,"aval_bal","avalBal","可用余额");

	/**
	 * 买入待交收 | decimal(16,4)
	 */
	public final TableField<Double> buyFrozen = new TableFieldImpl<Double>(this,"buy_frozen","buyFrozen","买入待交收");

	/**
	 * 卖出冻结 | decimal(16,4)
	 */
	public final TableField<Double> sellFrozen = new TableFieldImpl<Double>(this,"sell_frozen","sellFrozen","卖出冻结");

	/**
	 * 异常冻结 | decimal(16,4)
	 */
	public final TableField<Double> othFrozen = new TableFieldImpl<Double>(this,"oth_frozen","othFrozen","异常冻结");

	/**
	 * 券商端持仓成本价 | decimal(10,4)
	 */
	public final TableField<Double> brkHoldPrice = new TableFieldImpl<Double>(this,"brk_hold_price","brkHoldPrice","券商端持仓成本价");

	/**
	 * 券商端买入成本价 | decimal(10,4)
	 */
	public final TableField<Double> brkBuyPrice = new TableFieldImpl<Double>(this,"brk_buy_price","brkBuyPrice","券商端买入成本价");

	/**
	 * 币种 | char(3)
	 */
	public final TableField<String> ccyType = new TableFieldImpl<String>(this,"ccy_type","ccyType","币种");

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

	private final TableField<?>[] allFields = new TableField<?>[] {realStkBalId,userId,brokerId,brkCustid,assetId,ptfId,isCurrent,isConfirm,depositAcc,exchangeType,stkCode,stkAcc,syncTime,totalBal,avalBal,buyFrozen,sellFrozen,othFrozen,brkHoldPrice,brkBuyPrice,ccyType,createTime,updateTime,lockVersion};

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
		return "TRealStkBal[table=real_stk_bal]";
	}
}
