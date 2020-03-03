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

public class TSecTransferredStockM extends AbstractTable {

	static {
		init();
	}

	private TSecTransferredStockM(){
		super.tableName = "sec_transferred_stock_m";
	}

	private TSecTransferredStockM(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSecTransferredStockM getInstance() {
		return new TSecTransferredStockM();
	}

	public static final TSecTransferredStockM getInstance(String aliasName) {
		return new TSecTransferredStockM(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("secName", "sec_name");
		allFieldMap.put("accountName", "account_name");
		allFieldMap.put("accountNumber", "account_number");
		allFieldMap.put("receiveSec", "receive_sec");
		allFieldMap.put("receiveAccount", "receive_account");
		allFieldMap.put("inviter", "inviter");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("isShares", "is_shares");
		allFieldMap.put("ccass", "ccass");
		allFieldMap.put("state", "state");
		allFieldMap.put("isFind", "is_find");
		allFieldMap.put("transferState", "transfer_state");
		allFieldMap.put("createdTime", "created_time");
		allFieldMap.put("modifyTime", "modify_time");
		allFieldMap.put("backPerson", "back_person");
		allFieldMap.put("backReason", "back_reason");
		allFieldMap.put("info", "info");
		allFieldMap.put("accImgId", "acc_img_id");
		allFieldMap.put("intoTwo", "into_two");
		allFieldMap.put("isReward", "is_reward");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("rolloutContacts", "rollout_contacts");
		allFieldMap.put("contactsPhoneNum", "contacts_phoneNum");
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
	 * 劵商名称 | varchar(100)
	 */
	public final TableField<String> secName = new TableFieldImpl<String>(this,"sec_name","secName","劵商名称");

	/**
	 * 账户姓名 | varchar(100)
	 */
	public final TableField<String> accountName = new TableFieldImpl<String>(this,"account_name","accountName","账户姓名");

	/**
	 * 账户号码 | varchar(50)
	 */
	public final TableField<String> accountNumber = new TableFieldImpl<String>(this,"account_number","accountNumber","账户号码");

	/**
	 * 接收劵商 | varchar(50)
	 */
	public final TableField<String> receiveSec = new TableFieldImpl<String>(this,"receive_sec","receiveSec","接收劵商");

	/**
	 * 接收账户 | varchar(50)
	 */
	public final TableField<String> receiveAccount = new TableFieldImpl<String>(this,"receive_account","receiveAccount","接收账户");

	/**
	 * 邀请人 | varchar(50)
	 */
	public final TableField<String> inviter = new TableFieldImpl<String>(this,"inviter","inviter","邀请人");

	/**
	 * 用户id | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户id");

	/**
	 * 转入股票  1港股 2美股 | int(11)
	 */
	public final TableField<Integer> isShares = new TableFieldImpl<Integer>(this,"is_shares","isShares","转入股票  1港股 2美股");

	/**
	 * CCASS代码 | varchar(50)
	 */
	public final TableField<String> ccass = new TableFieldImpl<String>(this,"ccass","ccass","CCASS代码");

	/**
	 * 状态 0 已保存 1已提交 2已受理 3 已退回 4已完成 | int(11)
	 */
	public final TableField<Integer> state = new TableFieldImpl<Integer>(this,"state","state","状态 0 已保存 1已提交 2已受理 3 已退回 4已完成");

	/**
	 * 是否全部加载 0 否 1 是 | tinyint(4)
	 */
	public final TableField<Integer> isFind = new TableFieldImpl<Integer>(this,"is_find","isFind","是否全部加载 0 否 1 是");

	/**
	 * 转入状态 0未转入 1已转入 | tinyint(4)
	 */
	public final TableField<Integer> transferState = new TableFieldImpl<Integer>(this,"transfer_state","transferState","转入状态 0未转入 1已转入");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createdTime = new DateTableFieldImpl<Date>(this,"created_time","createdTime","创建时间");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> modifyTime = new DateTableFieldImpl<Date>(this,"modify_time","modifyTime","更新时间");

	/**
	 * 退回操作人 | varchar(50)
	 */
	public final TableField<String> backPerson = new TableFieldImpl<String>(this,"back_person","backPerson","退回操作人");

	/**
	 * 退回理由 | varchar(50)
	 */
	public final TableField<String> backReason = new TableFieldImpl<String>(this,"back_reason","backReason","退回理由");

	/**
	 * 前端保存参数 | varchar(4000)
	 */
	public final TableField<String> info = new TableFieldImpl<String>(this,"info","info","前端保存参数");

	/**
	 * 转入凭证图片ID | bigint(20)
	 */
	public final TableField<Long> accImgId = new TableFieldImpl<Long>(this,"acc_img_id","accImgId","转入凭证图片ID");

	/**
	 * 前端保存第二部数据 | varchar(4000)
	 */
	public final TableField<String> intoTwo = new TableFieldImpl<String>(this,"into_two","intoTwo","前端保存第二部数据");

	/**
	 * 是否发放补贴 | tinyint(4)
	 */
	public final TableField<Integer> isReward = new TableFieldImpl<Integer>(this,"is_reward","isReward","是否发放补贴");

	/**
	 * 交易账号 | varchar(20)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","交易账号");

	/**
	 * 转出券商的联系人 | varchar(50)
	 */
	public final TableField<String> rolloutContacts = new TableFieldImpl<String>(this,"rollout_contacts","rolloutContacts","转出券商的联系人");

	/**
	 * 转出券商的联系人电话 | varchar(20)
	 */
	public final TableField<String> contactsPhoneNum = new TableFieldImpl<String>(this,"contacts_phoneNum","contactsPhoneNum","转出券商的联系人电话");

	private final TableField<?>[] allFields = new TableField<?>[] {id,secName,accountName,accountNumber,receiveSec,receiveAccount,inviter,userId,isShares,ccass,state,isFind,transferState,createdTime,modifyTime,backPerson,backReason,info,accImgId,intoTwo,isReward,clientId,rolloutContacts,contactsPhoneNum};

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
		return "TSecTransferredStockM[table=sec_transferred_stock_m]";
	}
}
