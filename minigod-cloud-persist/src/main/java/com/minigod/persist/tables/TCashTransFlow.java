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

public class TCashTransFlow extends AbstractTable {

	static {
		init();
	}

	private TCashTransFlow(){
		super.tableName = "cash_trans_flow";
	}

	private TCashTransFlow(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TCashTransFlow getInstance() {
		return new TCashTransFlow();
	}

	public static final TCashTransFlow getInstance(String aliasName) {
		return new TCashTransFlow(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("flowId", "flow_id");
		allFieldMap.put("transactionId", "transaction_id");
		allFieldMap.put("accountId", "account_id");
		allFieldMap.put("accountDate", "account_date");
		allFieldMap.put("accountSeq", "account_seq");
		allFieldMap.put("direction", "direction");
		allFieldMap.put("amount", "amount");
		allFieldMap.put("frzAmount", "frz_amount");
		allFieldMap.put("balance", "balance");
		allFieldMap.put("frzBalance", "frz_balance");
		allFieldMap.put("unfrzRelTrx", "unfrz_rel_trx");
		allFieldMap.put("display", "display");
		allFieldMap.put("incomeOrExpense", "income_or_expense");
		allFieldMap.put("actTitle", "act_title");
		allFieldMap.put("actDesc", "act_desc");
		allFieldMap.put("accountTime", "account_time");
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
	 * 交易流水id | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"flow_id","flowId","交易流水id");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","交易流水id");

	public final TableField<Integer> flowId = new TableFieldImpl<Integer>(this,"flow_id","flowId","交易流水id");

	/**
	 * 交易请求表ID | int(11)
	 */
	public final TableField<Integer> transactionId = new TableFieldImpl<Integer>(this,"transaction_id","transactionId","交易请求表ID");

	/**
	 * 账户ID | int(11)
	 */
	public final TableField<Integer> accountId = new TableFieldImpl<Integer>(this,"account_id","accountId","账户ID");

	/**
	 * 记账日期 | date
	 */
	public final DateTableField<Date> accountDate = new DateTableFieldImpl<Date>(this,"account_date","accountDate","记账日期");

	/**
	 * 账户日内流水号 | int(11)
	 */
	public final TableField<Integer> accountSeq = new TableFieldImpl<Integer>(this,"account_seq","accountSeq","账户日内流水号");

	/**
	 * 记账方向 | char(1)
	 */
	public final TableField<String> direction = new TableFieldImpl<String>(this,"direction","direction","记账方向");

	/**
	 * 本次交易金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> amount = new TableFieldImpl<BigDecimal>(this,"amount","amount","本次交易金额");

	/**
	 * 本次冻结金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> frzAmount = new TableFieldImpl<BigDecimal>(this,"frz_amount","frzAmount","本次冻结金额");

	/**
	 * 交易后账户余额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> balance = new TableFieldImpl<BigDecimal>(this,"balance","balance","交易后账户余额");

	/**
	 * 交易后冻结余额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> frzBalance = new TableFieldImpl<BigDecimal>(this,"frz_balance","frzBalance","交易后冻结余额");

	/**
	 * 解冻对应的冻结事务Id | int(11)
	 */
	public final TableField<Integer> unfrzRelTrx = new TableFieldImpl<Integer>(this,"unfrz_rel_trx","unfrzRelTrx","解冻对应的冻结事务Id");

	/**
	 * 是否在钱包中显示 | char(1)
	 */
	public final TableField<String> display = new TableFieldImpl<String>(this,"display","display","是否在钱包中显示");

	/**
	 * 是否为收支项 | char(1)
	 */
	public final TableField<String> incomeOrExpense = new TableFieldImpl<String>(this,"income_or_expense","incomeOrExpense","是否为收支项");

	/**
	 * 记账标题 | varchar(32)
	 */
	public final TableField<String> actTitle = new TableFieldImpl<String>(this,"act_title","actTitle","记账标题");

	/**
	 * 对本次记账的简要描述 | varchar(256)
	 */
	public final TableField<String> actDesc = new TableFieldImpl<String>(this,"act_desc","actDesc","对本次记账的简要描述");

	/**
	 * 记账时间 | datetime
	 */
	public final DateTableField<Date> accountTime = new DateTableFieldImpl<Date>(this,"account_time","accountTime","记账时间");

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

	private final TableField<?>[] allFields = new TableField<?>[] {flowId,transactionId,accountId,accountDate,accountSeq,direction,amount,frzAmount,balance,frzBalance,unfrzRelTrx,display,incomeOrExpense,actTitle,actDesc,accountTime,createTime,updateTime,lockVersion};

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
		return "TCashTransFlow[table=cash_trans_flow]";
	}
}
