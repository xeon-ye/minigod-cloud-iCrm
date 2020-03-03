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

public class TGrmClientFeeFree extends AbstractTable {

	static {
		init();
	}

	private TGrmClientFeeFree(){
		super.tableName = "grm_client_fee_free";
	}

	private TGrmClientFeeFree(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TGrmClientFeeFree getInstance() {
		return new TGrmClientFeeFree();
	}

	public static final TGrmClientFeeFree getInstance(String aliasName) {
		return new TGrmClientFeeFree(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("serialNo", "serial_no");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("fundAccount", "fund_account");
		allFieldMap.put("fareDict", "fare_dict");
		allFieldMap.put("fareType", "fare_type");
		allFieldMap.put("exchangeType", "exchange_type");
		allFieldMap.put("entrustWay", "entrust_way");
		allFieldMap.put("minFareInTrd", "min_fare_in_trd");
		allFieldMap.put("minFare", "min_fare");
		allFieldMap.put("feeCountInTrd", "fee_count_in_trd");
		allFieldMap.put("feeCount", "fee_count");
		allFieldMap.put("startDate", "start_date");
		allFieldMap.put("endDate", "end_date");
		allFieldMap.put("isSetFreeStart", "is_set_free_start");
		allFieldMap.put("isSetFreeEnd", "is_set_free_end");
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
	 * 主键，无实际业务意义 | int(19)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"id","id","主键，无实际业务意义");
	public final TableField<Integer> id = new TableFieldImpl<Integer>(this,"id","id","主键，无实际业务意义");

	/**
	 * 序号，标记一次免佣行为（客户可以多次免佣） | varchar(32)
	 */
	public final TableField<String> serialNo = new TableFieldImpl<String>(this,"serial_no","serialNo","序号，标记一次免佣行为（客户可以多次免佣）");

	/**
	 * 客户账号 | varchar(32)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","客户账号");

	/**
	 * 资产账户 | varchar(32)
	 */
	public final TableField<String> fundAccount = new TableFieldImpl<String>(this,"fund_account","fundAccount","资产账户");

	/**
	 * 费用类型字典(0:服务费 1：交易费) | varchar(16)
	 */
	public final TableField<String> fareDict = new TableFieldImpl<String>(this,"fare_dict","fareDict","费用类型字典(0:服务费 1：交易费)");

	/**
	 * 费用类别：0-佣金等 | varchar(16)
	 */
	public final TableField<String> fareType = new TableFieldImpl<String>(this,"fare_type","fareType","费用类别：0-佣金等");

	/**
	 * 交易类别(即市场）：K-港股，P-美股 | varchar(16)
	 */
	public final TableField<String> exchangeType = new TableFieldImpl<String>(this,"exchange_type","exchangeType","交易类别(即市场）：K-港股，P-美股");

	/**
	 * 委托方式：47ABCDEHI等 | varchar(32)
	 */
	public final TableField<String> entrustWay = new TableFieldImpl<String>(this,"entrust_way","entrustWay","委托方式：47ABCDEHI等");

	/**
	 * 最低佣金，保存交易系统返回来的值，未进行格式化。 | varchar(32)
	 */
	public final TableField<String> minFareInTrd = new TableFieldImpl<String>(this,"min_fare_in_trd","minFareInTrd","最低佣金，保存交易系统返回来的值，未进行格式化。");

	/**
	 * 最低佣金，格式化后的：小数，默认保留二位小数。 | varchar(32)
	 */
	public final TableField<String> minFare = new TableFieldImpl<String>(this,"min_fare","minFare","最低佣金，格式化后的：小数，默认保留二位小数。");

	/**
	 * 佣金率，保存交易系统返回来的值，未进行格式化。 | varchar(32)
	 */
	public final TableField<String> feeCountInTrd = new TableFieldImpl<String>(this,"fee_count_in_trd","feeCountInTrd","佣金率，保存交易系统返回来的值，未进行格式化。");

	/**
	 * 佣金率，格式化后的：百分比化的小数，即交易系统返回的数乘100。 | varchar(32)
	 */
	public final TableField<String> feeCount = new TableFieldImpl<String>(this,"fee_count","feeCount","佣金率，格式化后的：百分比化的小数，即交易系统返回的数乘100。");

	/**
	 * 免佣开始时间 | datetime
	 */
	public final DateTableField<Date> startDate = new DateTableFieldImpl<Date>(this,"start_date","startDate","免佣开始时间");

	/**
	 * 免佣结束时间 | datetime
	 */
	public final DateTableField<Date> endDate = new DateTableFieldImpl<Date>(this,"end_date","endDate","免佣结束时间");

	/**
	 * 是否已在交易系统中设置免佣开始(1-已设置,0-未设置) | tinyint(1)
	 */
	public final TableField<Boolean> isSetFreeStart = new TableFieldImpl<Boolean>(this,"is_set_free_start","isSetFreeStart","是否已在交易系统中设置免佣开始(1-已设置,0-未设置)");

	/**
	 * 是否已在交易系统中设置免佣结束(1-已设置,0-未设置) | tinyint(1)
	 */
	public final TableField<Boolean> isSetFreeEnd = new TableFieldImpl<Boolean>(this,"is_set_free_end","isSetFreeEnd","是否已在交易系统中设置免佣结束(1-已设置,0-未设置)");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 最后修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","最后修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {id,serialNo,clientId,fundAccount,fareDict,fareType,exchangeType,entrustWay,minFareInTrd,minFare,feeCountInTrd,feeCount,startDate,endDate,isSetFreeStart,isSetFreeEnd,createTime,updateTime};

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
		return "TGrmClientFeeFree[table=grm_client_fee_free]";
	}
}
