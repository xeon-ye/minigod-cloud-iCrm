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

public class TCashAcc extends AbstractTable {

	static {
		init();
	}

	private TCashAcc(){
		super.tableName = "cash_acc";
	}

	private TCashAcc(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TCashAcc getInstance() {
		return new TCashAcc();
	}

	public static final TCashAcc getInstance(String aliasName) {
		return new TCashAcc(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("accountId", "account_id");
		allFieldMap.put("refIdType", "ref_id_type");
		allFieldMap.put("refIdNo", "ref_id_no");
		allFieldMap.put("name", "name");
		allFieldMap.put("subjectId", "subject_id");
		allFieldMap.put("direction", "direction");
		allFieldMap.put("ccy", "ccy");
		allFieldMap.put("dayInitDate", "day_init_date");
		allFieldMap.put("dayActSeq", "day_act_seq");
		allFieldMap.put("dayInitBal", "day_init_bal");
		allFieldMap.put("dayInitFrzBal", "day_init_frz_bal");
		allFieldMap.put("balance", "balance");
		allFieldMap.put("frzBalance", "frz_balance");
		allFieldMap.put("isStatus", "is_status");
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
	 * 账户ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"account_id","accountId","账户ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","账户ID");

	public final TableField<Integer> accountId = new TableFieldImpl<Integer>(this,"account_id","accountId","账户ID");

	/**
	 * 关联账户类型 | char(2)
	 */
	public final TableField<String> refIdType = new TableFieldImpl<String>(this,"ref_id_type","refIdType","关联账户类型");

	/**
	 * 关联账户 | varchar(100)
	 */
	public final TableField<String> refIdNo = new TableFieldImpl<String>(this,"ref_id_no","refIdNo","关联账户");

	/**
	 * 账户名称及描述 | varchar(50)
	 */
	public final TableField<String> name = new TableFieldImpl<String>(this,"name","name","账户名称及描述");

	/**
	 * 账户所属科目 | char(4)
	 */
	public final TableField<String> subjectId = new TableFieldImpl<String>(this,"subject_id","subjectId","账户所属科目");

	/**
	 * 余额方向 | char(1)
	 */
	public final TableField<String> direction = new TableFieldImpl<String>(this,"direction","direction","余额方向");

	/**
	 * 币种 | char(3)
	 */
	public final TableField<String> ccy = new TableFieldImpl<String>(this,"ccy","ccy","币种");

	/**
	 * 日初日期 | date
	 */
	public final DateTableField<Date> dayInitDate = new DateTableFieldImpl<Date>(this,"day_init_date","dayInitDate","日初日期");

	/**
	 * 日内账户交易流水号 | int(11)
	 */
	public final TableField<Integer> dayActSeq = new TableFieldImpl<Integer>(this,"day_act_seq","dayActSeq","日内账户交易流水号");

	/**
	 * 日初账户余额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> dayInitBal = new TableFieldImpl<BigDecimal>(this,"day_init_bal","dayInitBal","日初账户余额");

	/**
	 * 日初冻结余额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> dayInitFrzBal = new TableFieldImpl<BigDecimal>(this,"day_init_frz_bal","dayInitFrzBal","日初冻结余额");

	/**
	 * 账户余额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> balance = new TableFieldImpl<BigDecimal>(this,"balance","balance","账户余额");

	/**
	 * 冻结余额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> frzBalance = new TableFieldImpl<BigDecimal>(this,"frz_balance","frzBalance","冻结余额");

	/**
	 * 记录状态 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态");

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

	private final TableField<?>[] allFields = new TableField<?>[] {accountId,refIdType,refIdNo,name,subjectId,direction,ccy,dayInitDate,dayActSeq,dayInitBal,dayInitFrzBal,balance,frzBalance,isStatus,createTime,updateTime,lockVersion};

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
		return "TCashAcc[table=cash_acc]";
	}
}
