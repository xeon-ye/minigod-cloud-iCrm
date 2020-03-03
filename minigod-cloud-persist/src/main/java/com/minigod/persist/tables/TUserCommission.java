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

public class TUserCommission extends AbstractTable {

	static {
		init();
	}

	private TUserCommission(){
		super.tableName = "user_commission";
	}

	private TUserCommission(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserCommission getInstance() {
		return new TUserCommission();
	}

	public static final TUserCommission getInstance(String aliasName) {
		return new TUserCommission(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("fundAccount", "fund_account");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("fareDict", "fare_dict");
		allFieldMap.put("feeType", "fee_type");
		allFieldMap.put("feeCount", "fee_count");
		allFieldMap.put("fareType", "fare_type");
		allFieldMap.put("exchangeType", "exchange_type");
		allFieldMap.put("stockType", "stock_type");
		allFieldMap.put("stockCode", "stock_code");
		allFieldMap.put("entrustBs", "entrust_bs");
		allFieldMap.put("entrustWay", "entrust_way");
		allFieldMap.put("moneyType", "money_type");
		allFieldMap.put("minFare", "min_fare");
		allFieldMap.put("maxFare", "max_fare");
		allFieldMap.put("precisions", "precisions");
		allFieldMap.put("precisionFlag", "precision_flag");
		allFieldMap.put("feeCountFix", "fee_count_fix");
		allFieldMap.put("fareStr", "fare_str");
		allFieldMap.put("beginDate", "begin_date");
		allFieldMap.put("endDate", "end_date");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("status", "status");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 *  | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"id","id","");
	public final TableField<Integer> id = new TableFieldImpl<Integer>(this,"id","id","");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> fundAccount = new TableFieldImpl<String>(this,"fund_account","fundAccount","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> fareDict = new TableFieldImpl<String>(this,"fare_dict","fareDict","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> feeType = new TableFieldImpl<String>(this,"fee_type","feeType","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> fareType = new TableFieldImpl<String>(this,"fare_type","fareType","");
	
	/**
	 *  | char(2)
	 */
	public final TableField<String> feeCount = new TableFieldImpl<String>(this,"fee_count","feeCount","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> exchangeType = new TableFieldImpl<String>(this,"exchange_type","exchangeType","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> stockType = new TableFieldImpl<String>(this,"stock_type","stockType","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> stockCode = new TableFieldImpl<String>(this,"stock_code","stockCode","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> entrustBs = new TableFieldImpl<String>(this,"entrust_bs","entrustBs","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> entrustWay = new TableFieldImpl<String>(this,"entrust_way","entrustWay","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> moneyType = new TableFieldImpl<String>(this,"money_type","moneyType","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> minFare = new TableFieldImpl<String>(this,"min_fare","minFare","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> maxFare = new TableFieldImpl<String>(this,"max_fare","maxFare","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> precisions = new TableFieldImpl<String>(this,"precisions","precisions","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> precisionFlag = new TableFieldImpl<String>(this,"precision_flag","precisionFlag","");

	/**
	 *  | char(2)
	 */
	public final TableField<String> feeCountFix = new TableFieldImpl<String>(this,"fee_count_fix","feeCountFix","");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> fareStr = new TableFieldImpl<String>(this,"fare_str","fareStr","");
	
	/**
	 *  | varchar(10)
	 */
	public final TableField<String> beginDate = new TableFieldImpl<String>(this,"begin_date","beginDate","");

	/**
	 *  | varchar(10)
	 */
	public final TableFieldImpl<String> endDate = new TableFieldImpl<String>(this,"end_date","endDate","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","");

	/**
	 * 0 生效 1 失效 | tinyint(4)
	 */
	public final TableField<Integer> status = new TableFieldImpl<Integer>(this,"status","status","0 生效 1 失效");

	private final TableField<?>[] allFields = new TableField<?>[] {id,userId,fundAccount,clientId,fareDict,feeType,feeCount,fareType,exchangeType,stockType,stockCode,entrustBs,entrustWay,moneyType,minFare,maxFare,precisions,precisionFlag,feeCountFix,fareStr,beginDate,endDate,createTime,updateTime,status};

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
		return "TUserCommission[table=user_commission]";
	}
}
