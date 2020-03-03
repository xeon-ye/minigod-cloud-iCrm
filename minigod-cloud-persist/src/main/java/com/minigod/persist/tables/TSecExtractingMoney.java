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

public class TSecExtractingMoney extends AbstractTable {

	static {
		init();
	}

	private TSecExtractingMoney(){
		super.tableName = "sec_extracting_money";
	}

	private TSecExtractingMoney(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSecExtractingMoney getInstance() {
		return new TSecExtractingMoney();
	}

	public static final TSecExtractingMoney getInstance(String aliasName) {
		return new TSecExtractingMoney(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("extAccount", "ext_account");
		allFieldMap.put("extAccountName", "ext_account_name");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("extMethod", "ext_method");
		allFieldMap.put("bankName", "bank_name");
		allFieldMap.put("bankCode", "bank_code");
		allFieldMap.put("swiftCode", "swift_code");
		allFieldMap.put("payee", "payee");
		allFieldMap.put("address", "address");
		allFieldMap.put("bankAccount", "bank_account");
		allFieldMap.put("availableAmount", "available_amount");
		allFieldMap.put("extractionAmount", "extraction_amount");
		allFieldMap.put("remarks", "remarks");
		allFieldMap.put("state", "state");
		allFieldMap.put("currency", "currency");
		allFieldMap.put("chargeMoney", "charge_money");
		allFieldMap.put("backPerson", "back_person");
		allFieldMap.put("backReason", "back_reason");
		allFieldMap.put("isFind", "is_find");
		allFieldMap.put("createdTime", "created_time");
		allFieldMap.put("modifyTime", "modify_time");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 提取资金表id | bigint(20)
	 */
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"id","id","提取资金表id");
	public final TableField<Long> id = new TableFieldImpl<Long>(this,"id","id","提取资金表id");

	/**
	 * 用户id | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户id");

	/**
	 * 提取账户 | varchar(20)
	 */
	public final TableField<String> extAccount = new TableFieldImpl<String>(this,"ext_account","extAccount","提取账户");

	/**
	 * 提取账户名称 | varchar(20)
	 */
	public final TableField<String> extAccountName = new TableFieldImpl<String>(this,"ext_account_name","extAccountName","提取账户名称");

	/**
	 * 交易账户 | varchar(20)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","交易账户");

	/**
	 * 提取方式 1大陆银行 2香港银行 | int(11)
	 */
	public final TableField<Integer> extMethod = new TableFieldImpl<Integer>(this,"ext_method","extMethod","提取方式 1大陆银行 2香港银行");

	/**
	 * 收款银行名称 | varchar(20)
	 */
	public final TableField<String> bankName = new TableFieldImpl<String>(this,"bank_name","bankName","收款银行名称");

	/**
	 * 收款银行代码 | varchar(10)
	 */
	public final TableField<String> bankCode = new TableFieldImpl<String>(this,"bank_code","bankCode","收款银行代码");
	
	/**
	 * 电讯码 | varchar(20)
	 */
	public final TableField<String> swiftCode = new TableFieldImpl<String>(this,"swift_code","swiftCode","电讯码");

	/**
	 * 收款人 | varchar(20)
	 */
	public final TableField<String> payee = new TableFieldImpl<String>(this,"payee","payee","收款人");
	
	/**
	 * 联系地址 | varchar(100)
	 */
	public final TableField<String> address = new TableFieldImpl<String>(this,"address","address","联系地址");

	/**
	 * 银行账号 | varchar(32)
	 */
	public final TableField<String> bankAccount = new TableFieldImpl<String>(this,"bank_account","bankAccount","银行账号");

	/**
	 * 可提金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> availableAmount = new TableFieldImpl<BigDecimal>(this,"available_amount","availableAmount","可提金额");

	/**
	 * 提取金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> extractionAmount = new TableFieldImpl<BigDecimal>(this,"extraction_amount","extractionAmount","提取金额");

	/**
	 * 备注信息 | varchar(200)
	 */
	public final TableField<String> remarks = new TableFieldImpl<String>(this,"remarks","remarks","备注信息");

	/**
	 * 状态 0已提交 1已受理 2已退回 3已完成 | int(11)
	 */
	public final TableField<Integer> state = new TableFieldImpl<Integer>(this,"state","state","状态 0已提交 1已受理 2已退回 3已完成");

	/**
	 * 币种 1港币 2美元 | int(11)
	 */
	public final TableField<Integer> currency = new TableFieldImpl<Integer>(this,"currency","currency","币种 1港币 2美元");

	/**
	 * 手续费 | decimal(16,2)
	 */
	public final TableField<BigDecimal> chargeMoney = new TableFieldImpl<BigDecimal>(this,"charge_money","chargeMoney","手续费");

	/**
	 * 操作人 | varchar(20)
	 */
	public final TableField<String> backPerson = new TableFieldImpl<String>(this,"back_person","backPerson","操作人");

	/**
	 * 退回理由 | varchar(20)
	 */
	public final TableField<String> backReason = new TableFieldImpl<String>(this,"back_reason","backReason","退回理由");

	/**
	 * 是否全部加载 0 否 1 是 | int(2)
	 */
	public final TableField<Integer> isFind = new TableFieldImpl<Integer>(this,"is_find","isFind","是否全部加载 0 否 1 是");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createdTime = new DateTableFieldImpl<Date>(this,"created_time","createdTime","创建时间");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> modifyTime = new DateTableFieldImpl<Date>(this,"modify_time","modifyTime","更新时间");

	private final TableField<?>[] allFields = new TableField<?>[] {id,userId,extAccount,extAccountName,clientId,extMethod,bankName,bankCode,swiftCode,payee,address,bankAccount,availableAmount,extractionAmount,remarks,state,currency,chargeMoney,backPerson,backReason,isFind,createdTime,modifyTime};

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
		return "TSecExtractingMoney[table=sec_extracting_money]";
	}
}
