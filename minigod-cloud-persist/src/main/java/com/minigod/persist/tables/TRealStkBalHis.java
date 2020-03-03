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

public class TRealStkBalHis extends AbstractTable {

	static {
		init();
	}

	private TRealStkBalHis(){
		super.tableName = "real_stk_bal_his";
	}

	private TRealStkBalHis(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TRealStkBalHis getInstance() {
		return new TRealStkBalHis();
	}

	public static final TRealStkBalHis getInstance(String aliasName) {
		return new TRealStkBalHis(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("realStkBalHisId", "real_stk_bal_his_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("brokerId", "broker_id");
		allFieldMap.put("brkCustid", "brk_custid");
		allFieldMap.put("assetId", "asset_id");
		allFieldMap.put("effectiveFrom", "effective_from");
		allFieldMap.put("effectiveTo", "effective_to");
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("isCurrent", "is_current");
		allFieldMap.put("totalBal", "total_bal");
		allFieldMap.put("avalBal", "aval_bal");
		allFieldMap.put("brkHoldPrice", "brk_hold_price");
		allFieldMap.put("brkBuyPrice", "brk_buy_price");
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
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"real_stk_bal_his_id","realStkBalHisId","记录ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","记录ID");

	public final TableField<Integer> realStkBalHisId = new TableFieldImpl<Integer>(this,"real_stk_bal_his_id","realStkBalHisId","记录ID");

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
	 * 有效起始时间 | datetime
	 */
	public final DateTableField<Date> effectiveFrom = new DateTableFieldImpl<Date>(this,"effective_from","effectiveFrom","有效起始时间");

	/**
	 * 有效截止时间 | datetime
	 */
	public final DateTableField<Date> effectiveTo = new DateTableFieldImpl<Date>(this,"effective_to","effectiveTo","有效截止时间");

	/**
	 * 组合ID | int(11)
	 */
	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合ID");

	/**
	 * 是否当前持仓 | tinyint(1)
	 */
	public final TableField<Boolean> isCurrent = new TableFieldImpl<Boolean>(this,"is_current","isCurrent","是否当前持仓");

	/**
	 * 总余额 | decimal(16,4)
	 */
	public final TableField<Double> totalBal = new TableFieldImpl<Double>(this,"total_bal","totalBal","总余额");

	/**
	 * 可用余额 | decimal(16,4)
	 */
	public final TableField<Double> avalBal = new TableFieldImpl<Double>(this,"aval_bal","avalBal","可用余额");

	/**
	 * 券商端持仓成本价 | decimal(10,4)
	 */
	public final TableField<Double> brkHoldPrice = new TableFieldImpl<Double>(this,"brk_hold_price","brkHoldPrice","券商端持仓成本价");

	/**
	 * 券商端买入成本价 | decimal(10,4)
	 */
	public final TableField<Double> brkBuyPrice = new TableFieldImpl<Double>(this,"brk_buy_price","brkBuyPrice","券商端买入成本价");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	/**
	 * 观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","观锁版本号");

	private final TableField<?>[] allFields = new TableField<?>[] {realStkBalHisId,userId,brokerId,brkCustid,assetId,effectiveFrom,effectiveTo,ptfId,isCurrent,totalBal,avalBal,brkHoldPrice,brkBuyPrice,createTime,updateTime,lockVersion};

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
		return "TRealStkBalHis[table=real_stk_bal_his]";
	}
}
