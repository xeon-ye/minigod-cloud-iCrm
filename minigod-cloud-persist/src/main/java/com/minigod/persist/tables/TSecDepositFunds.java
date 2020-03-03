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

public class TSecDepositFunds extends AbstractTable {

	static {
		init();
	}

	private TSecDepositFunds(){
		super.tableName = "sec_deposit_funds";
	}

	private TSecDepositFunds(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSecDepositFunds getInstance() {
		return new TSecDepositFunds();
	}

	public static final TSecDepositFunds getInstance(String aliasName) {
		return new TSecDepositFunds(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("currency", "currency");
		allFieldMap.put("bankType", "bank_type");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("bankName", "bank_name");
		allFieldMap.put("bankCode", "bank_code");
		allFieldMap.put("depositAccount", "deposit_account");
		allFieldMap.put("depositAccountName", "deposit_account_name");
		allFieldMap.put("depositMoney", "deposit_money");
		allFieldMap.put("inviter", "inviter");
		allFieldMap.put("remarks", "remarks");
		allFieldMap.put("state", "state");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("isFind", "is_find");
		allFieldMap.put("chargeMoney", "charge_money");
		allFieldMap.put("accImgId", "acc_img_id");
		allFieldMap.put("backPerson", "back_person");
		allFieldMap.put("backReason", "back_reason");
		allFieldMap.put("info", "info");
		allFieldMap.put("createdTime", "created_time");
		allFieldMap.put("modifyTime", "modify_time");
		allFieldMap.put("getAccount", "get_account");
		allFieldMap.put("getAccountName", "get_account_name");
		allFieldMap.put("getAddress", "get_address");
		allFieldMap.put("getBankNameCn", "get_bank_name_cn");
		allFieldMap.put("getBankNameEn", "get_bank_name_en");
		allFieldMap.put("getBankAddress", "get_bank_address");
		allFieldMap.put("swiftCode", "swift_code");
		allFieldMap.put("isReward", "is_reward");
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
	 * 币种 1港币 2 美元 | int(11)
	 */
	public final TableField<Integer> currency = new TableFieldImpl<Integer>(this,"currency","currency","币种 1港币 2 美元");

	/**
	 * 银行 1大陆 2香港 | int(11)
	 */
	public final TableField<Integer> bankType = new TableFieldImpl<Integer>(this,"bank_type","bankType","银行 1大陆 2香港");

	/**
	 * 交易账户 | varchar(20)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","交易账户");

	/**
	 * 银行名称 | varchar(20)
	 */
	public final TableField<String> bankName = new TableFieldImpl<String>(this,"bank_name","bankName","银行名称");

	/**
	 * 银行代码 | varchar(20)
	 */
	public final TableField<String> bankCode = new TableFieldImpl<String>(this,"bank_code","bankCode","银行代码");

	/**
	 * 存入账户 | varchar(50)
	 */
	public final TableField<String> depositAccount = new TableFieldImpl<String>(this,"deposit_account","depositAccount","存入账户");

	/**
	 * 存入账户名称 | varchar(20)
	 */
	public final TableField<String> depositAccountName = new TableFieldImpl<String>(this,"deposit_account_name","depositAccountName","存入账户名称");

	/**
	 * 存入金额 | decimal(16,2)
	 */
	public final TableField<Double> depositMoney = new TableFieldImpl<Double>(this,"deposit_money","depositMoney","存入金额");

	/**
	 * 邀请人 | int(11)
	 */
	public final TableField<Integer> inviter = new TableFieldImpl<Integer>(this,"inviter","inviter","邀请人");

	/**
	 * 备注信息 | varchar(200)
	 */
	public final TableField<String> remarks = new TableFieldImpl<String>(this,"remarks","remarks","备注信息");

	/**
	 * 状态 0已提交 1已受理 2已退回 3已完成 | int(11)
	 */
	public final TableField<Integer> state = new TableFieldImpl<Integer>(this,"state","state","状态 0已提交 1已受理 2已退回 3已完成");

	/**
	 * 用户ID | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 是否全部加载 0 否 1 是 | int(2)
	 */
	public final TableField<Integer> isFind = new TableFieldImpl<Integer>(this,"is_find","isFind","是否全部加载 0 否 1 是");

	/**
	 * 手续费 | decimal(16,2)
	 */
	public final TableField<Double> chargeMoney = new TableFieldImpl<Double>(this,"charge_money","chargeMoney","手续费");

	/**
	 * 上传凭证图片ID | bigint(20)
	 */
	public final TableField<Long> accImgId = new TableFieldImpl<Long>(this,"acc_img_id","accImgId","上传凭证图片ID");

	/**
	 * 操作人 | varchar(10)
	 */
	public final TableField<String> backPerson = new TableFieldImpl<String>(this,"back_person","backPerson","操作人");

	/**
	 * 退回理由 | varchar(50)
	 */
	public final TableField<String> backReason = new TableFieldImpl<String>(this,"back_reason","backReason","退回理由");

	/**
	 * 前端保存信息 | varchar(4000)
	 */
	public final TableField<String> info = new TableFieldImpl<String>(this,"info","info","前端保存信息");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createdTime = new DateTableFieldImpl<Date>(this,"created_time","createdTime","创建时间");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> modifyTime = new DateTableFieldImpl<Date>(this,"modify_time","modifyTime","更新时间");

	/**
	 * 收款账户号码 | varchar(50)
	 */
	public final TableField<String> getAccount = new TableFieldImpl<String>(this,"get_account","getAccount","收款账户号码");

	/**
	 * 收款人账户名 | varchar(50)
	 */
	public final TableField<String> getAccountName = new TableFieldImpl<String>(this,"get_account_name","getAccountName","收款人账户名");

	/**
	 * 收款人地址 | varchar(100)
	 */
	public final TableField<String> getAddress = new TableFieldImpl<String>(this,"get_address","getAddress","收款人地址");

	/**
	 * 收款银行中文名 | varchar(50)
	 */
	public final TableField<String> getBankNameCn = new TableFieldImpl<String>(this,"get_bank_name_cn","getBankNameCn","收款银行中文名");

	/**
	 * 收款银行英文名 | varchar(50)
	 */
	public final TableField<String> getBankNameEn = new TableFieldImpl<String>(this,"get_bank_name_en","getBankNameEn","收款银行英文名");

	/**
	 * 收款银行地址 | varchar(100)
	 */
	public final TableField<String> getBankAddress = new TableFieldImpl<String>(this,"get_bank_address","getBankAddress","收款银行地址");

	/**
	 * SWIFT代码 | varchar(50)
	 */
	public final TableField<String> swiftCode = new TableFieldImpl<String>(this,"swift_code","swiftCode","SWIFT代码");

	/**
	 * 是否发放奖励 | tinyint(4)
	 */
	public final TableField<Integer> isReward = new TableFieldImpl<Integer>(this,"is_reward","isReward","是否发放奖励");

	private final TableField<?>[] allFields = new TableField<?>[] {id,currency,bankType,clientId,bankName,bankCode,depositAccount,depositAccountName,depositMoney,inviter,remarks,state,userId,isFind,chargeMoney,accImgId,backPerson,backReason,info,createdTime,modifyTime,getAccount,getAccountName,getAddress,getBankNameCn,getBankNameEn,getBankAddress,swiftCode,isReward};

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
		return "TSecDepositFunds[table=sec_deposit_funds]";
	}
}
