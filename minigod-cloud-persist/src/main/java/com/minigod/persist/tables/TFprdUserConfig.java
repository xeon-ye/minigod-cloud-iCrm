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

public class TFprdUserConfig extends AbstractTable {

	static {
		init();
	}

	private TFprdUserConfig(){
		super.tableName = "fprd_user_config";
	}

	private TFprdUserConfig(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TFprdUserConfig getInstance() {
		return new TFprdUserConfig();
	}

	public static final TFprdUserConfig getInstance(String aliasName) {
		return new TFprdUserConfig(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("userConfigId", "user_config_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("currencyBaseInterestRate", "currency_base_interest_rate");
		allFieldMap.put("currencyOnceLowerLimit", "currency_once_lower_limit");
		allFieldMap.put("currencyRedeemLowerLimit", "currency_redeem_lower_limit");
		allFieldMap.put("currencyBuyQuota", "currency_buy_quota");
		allFieldMap.put("currencyUpperInterestRate", "currency_upper_interest_rate");
		allFieldMap.put("currencyFreeWithdrawCount", "currency_free_withdraw_count");
		allFieldMap.put("currencyDayWithdrawLimit", "currency_day_withdraw_limit");
		allFieldMap.put("currencyRefreshNotice", "currency_refresh_notice");
		allFieldMap.put("currencyWithdrawFee", "currency_withdraw_fee");
		allFieldMap.put("createBy", "create_by");
		allFieldMap.put("updateBy", "update_by");
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
	 * 用户配置ID,主键，自增长字段 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"user_config_id","userConfigId","用户配置ID,主键，自增长字段");
	public final TableField<Integer> userConfigId = new TableFieldImpl<Integer>(this,"user_config_id","userConfigId","用户配置ID,主键，自增长字段");

	/**
	 * 用户Id,用户id为0表示所有人的默认配置。 | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户Id,用户id为0表示所有人的默认配置。");

	/**
	 * 基准利率,0.01表示1%,默认0.07 | decimal(5,4)
	 */
	public final TableField<BigDecimal> currencyBaseInterestRate = new TableFieldImpl<BigDecimal>(this,"currency_base_interest_rate","currencyBaseInterestRate","基准利率,0.01表示1%,默认0.07");

	/**
	 * 用户单次购买下限,默认下限为1K | decimal(16,2)
	 */
	public final TableField<BigDecimal> currencyOnceLowerLimit = new TableFieldImpl<BigDecimal>(this,"currency_once_lower_limit","currencyOnceLowerLimit","用户单次购买下限,默认下限为1K");

	/**
	 * 单次提现下限 | decimal(16,2)
	 */
	public final TableField<BigDecimal> currencyRedeemLowerLimit = new TableFieldImpl<BigDecimal>(this,"currency_redeem_lower_limit","currencyRedeemLowerLimit","单次提现下限");

	/**
	 * 用户可购买总额度 | decimal(16,2)
	 */
	public final TableField<BigDecimal> currencyBuyQuota = new TableFieldImpl<BigDecimal>(this,"currency_buy_quota","currencyBuyQuota","用户可购买总额度");

	/**
	 * 用户最高年华利率,0.01表示1%,默认0.09 | decimal(5,4)
	 */
	public final TableField<BigDecimal> currencyUpperInterestRate = new TableFieldImpl<BigDecimal>(this,"currency_upper_interest_rate","currencyUpperInterestRate","用户最高年华利率,0.01表示1%,默认0.09");

	/**
	 * 月免费提现次数,默认2 | int(11)
	 */
	public final TableField<Integer> currencyFreeWithdrawCount = new TableFieldImpl<Integer>(this,"currency_free_withdraw_count","currencyFreeWithdrawCount","月免费提现次数,默认2");

	/**
	 * 日提现额度限制,默认5W | decimal(16,2)
	 */
	public final TableField<BigDecimal> currencyDayWithdrawLimit = new TableFieldImpl<BigDecimal>(this,"currency_day_withdraw_limit","currencyDayWithdrawLimit","日提现额度限制,默认5W");

	/**
	 * 是否接受额度更新通知,Y/N,默认N | char(1)
	 */
	public final TableField<String> currencyRefreshNotice = new TableFieldImpl<String>(this,"currency_refresh_notice","currencyRefreshNotice","是否接受额度更新通知,Y/N,默认N");

	/**
	 * 提现手续费 | decimal(16,2)
	 */
	public final TableField<BigDecimal> currencyWithdrawFee = new TableFieldImpl<BigDecimal>(this,"currency_withdraw_fee","currencyWithdrawFee","提现手续费");

	/**
	 * 由谁创建,OMS操作人ID | int(11)
	 */
	public final TableField<Integer> createBy = new TableFieldImpl<Integer>(this,"create_by","createBy","由谁创建,OMS操作人ID");

	/**
	 * 由谁更改,OMS操作人ID | int(11)
	 */
	public final TableField<Integer> updateBy = new TableFieldImpl<Integer>(this,"update_by","updateBy","由谁更改,OMS操作人ID");

	/**
	 * 记录创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","记录创建时间");

	/**
	 * 记录修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","记录修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {userConfigId,userId,currencyBaseInterestRate,currencyOnceLowerLimit,currencyRedeemLowerLimit,currencyBuyQuota,currencyUpperInterestRate,currencyFreeWithdrawCount,currencyDayWithdrawLimit,currencyRefreshNotice,currencyWithdrawFee,createBy,updateBy,createTime,updateTime};

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
		return "TFprdUserConfig[table=fprd_user_config]";
	}
}
