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

public class TGrmTrdEntrustRec extends AbstractTable {

	static {
		init();
	}

	private TGrmTrdEntrustRec(){
		super.tableName = "grm_trd_entrust_rec";
	}

	private TGrmTrdEntrustRec(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TGrmTrdEntrustRec getInstance() {
		return new TGrmTrdEntrustRec();
	}

	public static final TGrmTrdEntrustRec getInstance(String aliasName) {
		return new TGrmTrdEntrustRec(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("jourId", "jour_id");
		allFieldMap.put("initDate", "init_date");
		allFieldMap.put("entrustNo", "entrust_no");
		allFieldMap.put("currDate", "curr_date");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("market", "market");
		allFieldMap.put("assetId", "asset_id");
		allFieldMap.put("entrustBs", "entrust_bs");
		allFieldMap.put("entrustAmount", "entrust_amount");
		allFieldMap.put("entrustPrice", "entrust_price");
		allFieldMap.put("entrustType", "entrust_type");
		allFieldMap.put("businessAmount", "business_amount");
		allFieldMap.put("businessBalanceHkd", "business_balance_hkd");
		allFieldMap.put("businessBalance", "business_balance");
		allFieldMap.put("clearBalance", "clear_balance");
		allFieldMap.put("moneyType", "money_type");
		allFieldMap.put("entrustStatus", "entrust_status");
		allFieldMap.put("extPositionStr", "ext_position_str");
		allFieldMap.put("remark", "remark");
		allFieldMap.put("code", "code");
		allFieldMap.put("fundAccount", "fund_account");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 *  | bigint(20)
	 */
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"jour_id","jourId","");
	public final TableField<Long> jourId = new TableFieldImpl<Long>(this,"jour_id","jourId","");

	/**
	 *  | date
	 */
	public final DateTableField<Date> initDate = new DateTableFieldImpl<Date>(this,"init_date","initDate","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> entrustNo = new TableFieldImpl<Integer>(this,"entrust_no","entrustNo","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> currDate = new DateTableFieldImpl<Date>(this,"curr_date","currDate","");

	/**
	 *  | varchar(16)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","");

	/**
	 *  | varchar(8)
	 */
	public final TableField<String> market = new TableFieldImpl<String>(this,"market","market","");

	/**
	 *  | varchar(32)
	 */
	public final TableField<String> assetId = new TableFieldImpl<String>(this,"asset_id","assetId","");

	/**
	 *  | char(1)
	 */
	public final TableField<String> entrustBs = new TableFieldImpl<String>(this,"entrust_bs","entrustBs","");

	/**
	 *  | double
	 */
	public final TableField<Double> entrustAmount = new TableFieldImpl<Double>(this,"entrust_amount","entrustAmount","");

	/**
	 *  | double
	 */
	public final TableField<Double> entrustPrice = new TableFieldImpl<Double>(this,"entrust_price","entrustPrice","");

	/**
	 *  | char(1)
	 */
	public final TableField<String> entrustType = new TableFieldImpl<String>(this,"entrust_type","entrustType","");

	/**
	 *  | double
	 */
	public final TableField<Double> businessAmount = new TableFieldImpl<Double>(this,"business_amount","businessAmount","");

	/**
	 *  | double
	 */
	public final TableField<Double> businessBalanceHkd = new TableFieldImpl<Double>(this,"business_balance_hkd","businessBalanceHkd","");

	/**
	 *  | double
	 */
	public final TableField<Double> businessBalance = new TableFieldImpl<Double>(this,"business_balance","businessBalance","");

	/**
	 *  | double
	 */
	public final TableField<Double> clearBalance = new TableFieldImpl<Double>(this,"clear_balance","clearBalance","");

	/**
	 *  | varchar(8)
	 */
	public final TableField<String> moneyType = new TableFieldImpl<String>(this,"money_type","moneyType","");

	/**
	 *  | char(1)
	 */
	public final TableField<String> entrustStatus = new TableFieldImpl<String>(this,"entrust_status","entrustStatus","");

	/**
	 *  | varchar(32)
	 */
	public final TableField<String> extPositionStr = new TableFieldImpl<String>(this,"ext_position_str","extPositionStr","");

	/**
	 *  | varchar(255)
	 */
	public final TableField<String> remark = new TableFieldImpl<String>(this,"remark","remark","");

	/**
	 *  | varchar(32)
	 */
	public final TableField<String> code = new TableFieldImpl<String>(this,"code","code","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> fundAccount = new TableFieldImpl<Integer>(this,"fund_account","fundAccount","");

	private final TableField<?>[] allFields = new TableField<?>[] {jourId,initDate,entrustNo,currDate,clientId,market,assetId,entrustBs,entrustAmount,entrustPrice,entrustType,businessAmount,businessBalanceHkd,businessBalance,clearBalance,moneyType,entrustStatus,extPositionStr,remark,code,fundAccount};

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
		return "TGrmTrdEntrustRec[table=grm_trd_entrust_rec]";
	}
}
