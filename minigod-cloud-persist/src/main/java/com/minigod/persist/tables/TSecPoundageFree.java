package com.minigod.persist.tables;
import com.minigod.db4j.table.AllField;
import com.minigod.db4j.table.AbstractTable;
import com.minigod.db4j.table.TableField;
import com.minigod.db4j.table.TableFieldImpl;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.util.Date;
import com.minigod.db4j.table.DateTableField;
import com.minigod.db4j.table.DateTableFieldImpl;

public class TSecPoundageFree extends AbstractTable {

	static {
		init();
	}

	private TSecPoundageFree(){
		super.tableName = "sec_poundage_free";
	}

	private TSecPoundageFree(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSecPoundageFree getInstance() {
		return new TSecPoundageFree();
	}

	public static final TSecPoundageFree getInstance(String aliasName) {
		return new TSecPoundageFree(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("userName", "user_name");
		allFieldMap.put("userPhoneNum", "user_phoneNum");
		allFieldMap.put("transactId", "transact_id");
		allFieldMap.put("transAccount", "trans_account");
		allFieldMap.put("capitalAccount", "capital_account");
		allFieldMap.put("depositAccountType", "deposit_account_type");
		allFieldMap.put("currency", "currency");
		allFieldMap.put("depositAccount", "deposit_account");
		allFieldMap.put("depositBank", "deposit_bank");
		allFieldMap.put("applicationTime", "application_time");
		allFieldMap.put("depositMoney", "deposit_money");
		allFieldMap.put("poundageMoney", "poundage_money");
		allFieldMap.put("status", "status");
		allFieldMap.put("createdTime", "created_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("refuseReasons", "refuse_reasons");
		allFieldMap.put("createdBy", "created_by");
		allFieldMap.put("updateBy", "update_by");
		allFieldMap.put("recordStatus", "record_status");
		allFieldMap.put("rmk", "rmk");
		allFieldMap.put("activiTimes", "activi_times");
		allFieldMap.put("activiDate", "activi_date");
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
	 * 客户id | int(10) unsigned
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","客户id");

	/**
	 * 客户名称 | varchar(30)
	 */
	public final TableField<String> userName = new TableFieldImpl<String>(this,"user_name","userName","客户名称");

	/**
	 * 客户手机号 | varchar(20)
	 */
	public final TableField<String> userPhoneNum = new TableFieldImpl<String>(this,"user_phoneNum","userPhoneNum","客户手机号");

	/**
	 * 对应交易流水号 | bigint(20) unsigned
	 */
	public final TableField<Long> transactId = new TableFieldImpl<Long>(this,"transact_id","transactId","对应交易流水号");

	/**
	 * 交易账号 | varchar(30)
	 */
	public final TableField<String> transAccount = new TableFieldImpl<String>(this,"trans_account","transAccount","交易账号");

	/**
	 * 资金账号 | varchar(30)
	 */
	public final TableField<String> capitalAccount = new TableFieldImpl<String>(this,"capital_account","capitalAccount","资金账号");

	/**
	 * 存入方式:1:大陆银行卡2:香港银行卡 | varchar(2)
	 */
	public final TableField<String> depositAccountType = new TableFieldImpl<String>(this,"deposit_account_type","depositAccountType","存入方式:1:大陆银行卡2:香港银行卡");

	/**
	 * 币种 1港币 2 美元 | varchar(2)
	 */
	public final TableField<String> currency = new TableFieldImpl<String>(this,"currency","currency","币种 1港币 2 美元");

	/**
	 * 存入账户 | varchar(50)
	 */
	public final TableField<String> depositAccount = new TableFieldImpl<String>(this,"deposit_account","depositAccount","存入账户");

	/**
	 * 存入银行 | varchar(50)
	 */
	public final TableField<String> depositBank = new TableFieldImpl<String>(this,"deposit_bank","depositBank","存入银行");

	/**
	 * 申请时间 | datetime
	 */
	public final DateTableField<Date> applicationTime = new DateTableFieldImpl<Date>(this,"application_time","applicationTime","申请时间");

	/**
	 * 存入金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> depositMoney = new TableFieldImpl<BigDecimal>(this,"deposit_money","depositMoney","存入金额");

	/**
	 * 入金手续费 | decimal(16,2)
	 */
	public final TableField<BigDecimal> poundageMoney = new TableFieldImpl<BigDecimal>(this,"poundage_money","poundageMoney","入金手续费");

	/**
	 * 申请免手续费状态 | int(5)
	 */
	public final TableField<Integer> status = new TableFieldImpl<Integer>(this,"status","status","申请免手续费状态");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createdTime = new DateTableFieldImpl<Date>(this,"created_time","createdTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	/**
	 * 拒绝原因 | varchar(200)
	 */
	public final TableField<String> refuseReasons = new TableFieldImpl<String>(this,"refuse_reasons","refuseReasons","拒绝原因");

	/**
	 * 创建人 | varchar(30)
	 */
	public final TableField<String> createdBy = new TableFieldImpl<String>(this,"created_by","createdBy","创建人");

	/**
	 * 修改人 | varchar(30)
	 */
	public final TableField<String> updateBy = new TableFieldImpl<String>(this,"update_by","updateBy","修改人");

	/**
	 * 记录状态:0:有效1:无效 | int(2) unsigned
	 */
	public final TableField<Integer> recordStatus = new TableFieldImpl<Integer>(this,"record_status","recordStatus","记录状态:0:有效1:无效");

	/**
	 * 备注 | varchar(300)
	 */
	public final TableField<String> rmk = new TableFieldImpl<String>(this,"rmk","rmk","备注");

	/**
	 * 活动次数 | varchar(30)
	 */
	public final TableField<String> activiTimes = new TableFieldImpl<String>(this,"activi_times","activiTimes","活动次数");

	/**
	 * 活动时间 | varchar(30)
	 */
	public final TableField<String> activiDate = new TableFieldImpl<String>(this,"activi_date","activiDate","活动时间");

	private final TableField<?>[] allFields = new TableField<?>[] {id,userId,userName,userPhoneNum,transactId,transAccount,capitalAccount,depositAccountType,currency,depositAccount,depositBank,applicationTime,depositMoney,poundageMoney,status,createdTime,updateTime,refuseReasons,createdBy,updateBy,recordStatus,rmk,activiTimes,activiDate};

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
		return "TSecPoundageFree[table=sec_poundage_free]";
	}
}
