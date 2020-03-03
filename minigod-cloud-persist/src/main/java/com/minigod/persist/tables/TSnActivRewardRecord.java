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

public class TSnActivRewardRecord extends AbstractTable {

	static {
		init();
	}

	private TSnActivRewardRecord(){
		super.tableName = "sn_activ_reward_record";
	}

	private TSnActivRewardRecord(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSnActivRewardRecord getInstance() {
		return new TSnActivRewardRecord();
	}

	public static final TSnActivRewardRecord getInstance(String aliasName) {
		return new TSnActivRewardRecord(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("nickname", "nickname");
		allFieldMap.put("inviter", "inviter");
		allFieldMap.put("activeType", "active_type");
		allFieldMap.put("snActivConfigId", "sn_activ_config_id");
		allFieldMap.put("activName", "activ_name");
		allFieldMap.put("snActivConfigItemId", "sn_activ_config_item_id");
		allFieldMap.put("activItemName", "activ_item_name");
		allFieldMap.put("openAccountId", "open_account_id");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("openAccountDatetime", "open_account_datetime");
		allFieldMap.put("depositId", "deposit_Id");
		allFieldMap.put("depositMoney", "deposit_money");
		allFieldMap.put("depositDatetime", "deposit_datetime");
		allFieldMap.put("transferStockId", "transfer_stock_id");
		allFieldMap.put("transferMoney", "transfer_money");
		allFieldMap.put("transferStockDateTime", "transfer_stock_dateTime");
		allFieldMap.put("rewardMoney", "reward_money");
		allFieldMap.put("commissionType", "commission_type");
		allFieldMap.put("commissionDay", "commission_day");
		allFieldMap.put("rewardType", "reward_type");
		allFieldMap.put("rewardStatus", "reward_status");
		allFieldMap.put("confirmEndDatetime", "confirm_end_datetime");
		allFieldMap.put("confirmDatetime", "confirm_datetime");
		allFieldMap.put("cashDrawId", "cash_draw_id");
		allFieldMap.put("useDatetime", "use_datetime");
		allFieldMap.put("STATUS", "STATUS");
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
	 * 主键 | bigint(20)
	 */
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"id","id","主键");
	public final TableField<Long> id = new TableFieldImpl<Long>(this,"id","id","主键");

	/**
	 * 用户id | bigint(20)
	 */
	public final TableField<Long> userId = new TableFieldImpl<Long>(this,"user_id","userId","用户id");

	/**
	 * 用户昵称 | varchar(50)
	 */
	public final TableField<String> nickname = new TableFieldImpl<String>(this,"nickname","nickname","用户昵称");

	/**
	 * 邀请人id | bigint(20)
	 */
	public final TableField<Long> inviter = new TableFieldImpl<Long>(this,"inviter","inviter","邀请人id");

	/**
	 * 活动类别(1 开户 2 入金 3 转仓 ) | tinyint(4)
	 */
	public final TableField<Integer> activeType = new TableFieldImpl<Integer>(this,"active_type","activeType","活动类别(1 开户 2 入金 3 转仓 )");

	/**
	 * 活动id | bigint(20)
	 */
	public final TableField<Long> snActivConfigId = new TableFieldImpl<Long>(this,"sn_activ_config_id","snActivConfigId","活动id");

	/**
	 * 活动名称 | varchar(50)
	 */
	public final TableField<String> activName = new TableFieldImpl<String>(this,"activ_name","activName","活动名称");

	/**
	 * 活动奖励明细id | bigint(20)
	 */
	public final TableField<Long> snActivConfigItemId = new TableFieldImpl<Long>(this,"sn_activ_config_item_id","snActivConfigItemId","活动奖励明细id");

	/**
	 * 活动配置项名称 | varchar(50)
	 */
	public final TableField<String> activItemName = new TableFieldImpl<String>(this,"activ_item_name","activItemName","活动配置项名称");

	/**
	 * 开户Id | bigint(20)
	 */
	public final TableField<Long> openAccountId = new TableFieldImpl<Long>(this,"open_account_id","openAccountId","开户Id");

	/**
	 * 开户交易号 | varchar(20)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","开户交易号");

	/**
	 * 开户时间 | datetime
	 */
	public final DateTableField<Date> openAccountDatetime = new DateTableFieldImpl<Date>(this,"open_account_datetime","openAccountDatetime","开户时间");

	/**
	 * 入金Id | bigint(20)
	 */
	public final TableField<Long> depositId = new TableFieldImpl<Long>(this,"deposit_Id","depositId","入金Id");

	/**
	 * 入金金额 | int(20)
	 */
	public final TableField<Integer> depositMoney = new TableFieldImpl<Integer>(this,"deposit_money","depositMoney","入金金额");

	/**
	 * 入金时间 | datetime
	 */
	public final DateTableField<Date> depositDatetime = new DateTableFieldImpl<Date>(this,"deposit_datetime","depositDatetime","入金时间");

	/**
	 * 转仓id | bigint(20)
	 */
	public final TableField<Long> transferStockId = new TableFieldImpl<Long>(this,"transfer_stock_id","transferStockId","转仓id");

	/**
	 * 转仓金额 | int(20)
	 */
	public final TableField<Integer> transferMoney = new TableFieldImpl<Integer>(this,"transfer_money","transferMoney","转仓金额");

	/**
	 * 转仓时间 | datetime
	 */
	public final DateTableField<Date> transferStockDateTime = new DateTableFieldImpl<Date>(this,"transfer_stock_dateTime","transferStockDateTime","转仓时间");

	/**
	 * 奖励金额 | int(20)
	 */
	public final TableField<Integer> rewardMoney = new TableFieldImpl<Integer>(this,"reward_money","rewardMoney","奖励金额");

	/**
	 * 免佣类型 | tinyint(4)
	 */
	public final TableField<Integer> commissionType = new TableFieldImpl<Integer>(this,"commission_type","commissionType","免佣类型");

	/**
	 * 奖励免用天数 | int(10)
	 */
	public final TableField<Integer> commissionDay = new TableFieldImpl<Integer>(this,"commission_day","commissionDay","奖励免用天数");

	/**
	 * 奖励类型（1 免佣 2 现金 3 行情） | tinyint(4)
	 */
	public final TableField<Integer> rewardType = new TableFieldImpl<Integer>(this,"reward_type","rewardType","奖励类型（1 免佣 2 现金 3 行情）");

	/**
	 * 奖励状态（0 未领取 1已领取 2 申请中 3 退回 4 使用中 5已完成 ） | tinyint(4)
	 */
	public final TableField<Integer> rewardStatus = new TableFieldImpl<Integer>(this,"reward_status","rewardStatus","奖励状态（0 未领取 1已领取 2 申请中 3 退回 4 使用中 5已完成 ）");

	/**
	 * 奖励领取截至时间 | datetime
	 */
	public final DateTableField<Date> confirmEndDatetime = new DateTableFieldImpl<Date>(this,"confirm_end_datetime","confirmEndDatetime","奖励领取截至时间");

	/**
	 * 领取奖励时间 | datetime
	 */
	public final DateTableField<Date> confirmDatetime = new DateTableFieldImpl<Date>(this,"confirm_datetime","confirmDatetime","领取奖励时间");

	/**
	 * 提现Id | bigint(20)
	 */
	public final TableField<Long> cashDrawId = new TableFieldImpl<Long>(this,"cash_draw_id","cashDrawId","提现Id");

	/**
	 * 奖励使用时间 | datetime
	 */
	public final DateTableField<Date> useDatetime = new DateTableFieldImpl<Date>(this,"use_datetime","useDatetime","奖励使用时间");

	/**
	 * 记录状态 0有效 1失效 | tinyint(4)
	 */
	public final TableField<Integer> STATUS = new TableFieldImpl<Integer>(this,"STATUS","STATUS","记录状态 0有效 1失效");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {id,userId,nickname,inviter,activeType,snActivConfigId,activName,snActivConfigItemId,activItemName,openAccountId,clientId,openAccountDatetime,depositId,depositMoney,depositDatetime,transferStockId,transferMoney,transferStockDateTime,rewardMoney,commissionType,commissionDay,rewardType,rewardStatus,confirmEndDatetime,confirmDatetime,cashDrawId,useDatetime,STATUS,createTime,updateTime};

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
		return "TSnActivRewardRecord[table=sn_activ_reward_record]";
	}
}
