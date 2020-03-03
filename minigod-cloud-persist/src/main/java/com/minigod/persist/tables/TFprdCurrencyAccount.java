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

public class TFprdCurrencyAccount extends AbstractTable {

	static {
		init();
	}

	private TFprdCurrencyAccount(){
		super.tableName = "fprd_currency_account";
	}

	private TFprdCurrencyAccount(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TFprdCurrencyAccount getInstance() {
		return new TFprdCurrencyAccount();
	}

	public static final TFprdCurrencyAccount getInstance(String aliasName) {
		return new TFprdCurrencyAccount(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("hqBalance", "hq_balance");
		allFieldMap.put("hqYesterdayProfit", "hq_yesterday_profit");
		allFieldMap.put("hqTotalProfit", "hq_total_profit");
		allFieldMap.put("hqTransitCash", "hq_transit_cash");
		allFieldMap.put("hqInterestRate", "hq_interest_rate");
		allFieldMap.put("totalMoney", "total_money");
		allFieldMap.put("canOutMoney", "can_out_money");
		allFieldMap.put("canBuyMoney", "can_buy_money");
		allFieldMap.put("couponReqNo", "coupon_req_no");
		allFieldMap.put("grantUserId", "grant_user_id");
		allFieldMap.put("grantStatus", "grant_status");
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
	 * 用户配置ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"user_id","userId","用户配置ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","用户配置ID");

	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户配置ID");

	/**
	 * 活期资产 | decimal(16,2)
	 */
	public final TableField<BigDecimal> hqBalance = new TableFieldImpl<BigDecimal>(this,"hq_balance","hqBalance","活期资产");

	/**
	 * 昨日收益 | decimal(18,4)
	 */
	public final TableField<BigDecimal> hqYesterdayProfit = new TableFieldImpl<BigDecimal>(this,"hq_yesterday_profit","hqYesterdayProfit","昨日收益");

	/**
	 * 累计收益 | decimal(18,4)
	 */
	public final TableField<BigDecimal> hqTotalProfit = new TableFieldImpl<BigDecimal>(this,"hq_total_profit","hqTotalProfit","累计收益");

	/**
	 * 在途资金 | decimal(16,2)
	 */
	public final TableField<BigDecimal> hqTransitCash = new TableFieldImpl<BigDecimal>(this,"hq_transit_cash","hqTransitCash","在途资金");

	/**
	 * 当前利率 | decimal(5,4)
	 */
	public final TableField<BigDecimal> hqInterestRate = new TableFieldImpl<BigDecimal>(this,"hq_interest_rate","hqInterestRate","当前利率");

	/**
	 *  | decimal(16,2)
	 */
	public final TableField<BigDecimal> totalMoney = new TableFieldImpl<BigDecimal>(this,"total_money","totalMoney","");

	/**
	 *  | decimal(16,2)
	 */
	public final TableField<BigDecimal> canOutMoney = new TableFieldImpl<BigDecimal>(this,"can_out_money","canOutMoney","");

	/**
	 * 可以购买的金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> canBuyMoney = new TableFieldImpl<BigDecimal>(this,"can_buy_money","canBuyMoney","可以购买的金额");

	/**
	 * 请求发放卡券的ID | varchar(32)
	 */
	public final TableField<String> couponReqNo = new TableFieldImpl<String>(this,"coupon_req_no","couponReqNo","请求发放卡券的ID");

	/**
	 * 邀请人 | int(11)
	 */
	public final TableField<Integer> grantUserId = new TableFieldImpl<Integer>(this,"grant_user_id","grantUserId","邀请人");

	/**
	 * 卡券发放状态: W:等待发放 S:发放成功F:发放失败 | char(1)
	 */
	public final TableField<String> grantStatus = new TableFieldImpl<String>(this,"grant_status","grantStatus","卡券发放状态: W:等待发放 S:发放成功F:发放失败");

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

	private final TableField<?>[] allFields = new TableField<?>[] {userId,hqBalance,hqYesterdayProfit,hqTotalProfit,hqTransitCash,hqInterestRate,totalMoney,canOutMoney,canBuyMoney,couponReqNo,grantUserId,grantStatus,createTime,updateTime,lockVersion};

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
		return "TFprdCurrencyAccount[table=fprd_currency_account]";
	}
}
