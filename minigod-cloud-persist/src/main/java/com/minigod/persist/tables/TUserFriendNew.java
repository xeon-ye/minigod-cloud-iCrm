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

public class TUserFriendNew extends AbstractTable {

	static {
		init();
	}

	private TUserFriendNew(){
		super.tableName = "user_friend_new";
	}

	private TUserFriendNew(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserFriendNew getInstance() {
		return new TUserFriendNew();
	}

	public static final TUserFriendNew getInstance(String aliasName) {
		return new TUserFriendNew(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("friendNewId", "friend_new_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("reqDirection", "req_direction");
		allFieldMap.put("reqStatus", "req_status");
		allFieldMap.put("targetUserId", "target_user_id");
		allFieldMap.put("rcmdUserId", "rcmd_user_id");
		allFieldMap.put("reqMemo", "req_memo");
		allFieldMap.put("reqSource", "req_source");
		allFieldMap.put("isNew", "is_new");
		allFieldMap.put("orderVersion", "order_version");
		allFieldMap.put("updVersion", "upd_version");
		allFieldMap.put("deviceId", "device_id");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("lockVersion", "lock_version");
		allFieldMap.put("relationType", "relation_type");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 新好友ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"friend_new_id","friendNewId","新好友ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","新好友ID");

	public final TableField<Integer> friendNewId = new TableFieldImpl<Integer>(this,"friend_new_id","friendNewId","新好友ID");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 请求方向：R 推荐（系统推荐或好友引荐，尚未发起请求）；I 我申请加对方；T 对方申请加我；M 纯消息通知（如某某和某某经我推荐成为了好友） | char(1)
	 */
	public final TableField<String> reqDirection = new TableFieldImpl<String>(this,"req_direction","reqDirection","请求方向：R 推荐（系统推荐或好友引荐，尚未发起请求）；I 我申请加对方；T 对方申请加我；M 纯消息通知（如某某和某某经我推荐成为了好友）");

	/**
	 * 请求状态： N-不需审核 W-待审核 Y-审核通过 | char(1)
	 */
	public final TableField<String> reqStatus = new TableFieldImpl<String>(this,"req_status","reqStatus","请求状态： N-不需审核 W-待审核 Y-审核通过");

	/**
	 * 对方用户ID   如果没有对方id，填0 | int(11)
	 */
	public final TableField<Integer> targetUserId = new TableFieldImpl<Integer>(this,"target_user_id","targetUserId","对方用户ID   如果没有对方id，填0");

	/**
	 * 引荐人ID，Recommend（引荐）若无引荐人，则填0 | int(11)
	 */
	public final TableField<Integer> rcmdUserId = new TableFieldImpl<Integer>(this,"rcmd_user_id","rcmdUserId","引荐人ID，Recommend（引荐）若无引荐人，则填0");

	/**
	 *  | varchar(200)
	 */
	public final TableField<String> reqMemo = new TableFieldImpl<String>(this,"req_memo","reqMemo","");

	/**
	 * 好友来源 ：用于统计，不做逻辑判断：C-通讯录匹配；S-主动搜索；W-微信邀请；R-朋友引荐；M-二度人脉 | char(1)
	 */
	public final TableField<String> reqSource = new TableFieldImpl<String>(this,"req_source","reqSource","好友来源 ：用于统计，不做逻辑判断：C-通讯录匹配；S-主动搜索；W-微信邀请；R-朋友引荐；M-二度人脉");

	/**
	 * 是否新消息：如果是我发起的请求，则对我而言不是新消息；如果是别人请求加我，或者我的请求被对方通过了等等需要通知到我的情况，则对我而言是新消息 | tinyint(1)
	 */
	public final TableField<Boolean> isNew = new TableFieldImpl<Boolean>(this,"is_new","isNew","是否新消息：如果是我发起的请求，则对我而言不是新消息；如果是别人请求加我，或者我的请求被对方通过了等等需要通知到我的情况，则对我而言是新消息");

	/**
	 * 排序版本号 | bigint(19)
	 */
	public final TableField<Long> orderVersion = new TableFieldImpl<Long>(this,"order_version","orderVersion","排序版本号");

	/**
	 * 修改版本号   用于客户端拉取更新 | bigint(19)
	 */
	public final TableField<Long> updVersion = new TableFieldImpl<Long>(this,"upd_version","updVersion","修改版本号   用于客户端拉取更新");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> deviceId = new TableFieldImpl<Integer>(this,"device_id","deviceId","");

	/**
	 * 记录状态(0-无效,1-有效) | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态(0-无效,1-有效)");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 最后修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","最后修改时间");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	/**
	 * 关系类型	C – 我的客户,A - 我的投顾,F – 我的好友 | char(1)
	 */
	public final TableField<String> relationType = new TableFieldImpl<String>(this,"relation_type","relationType","关系类型	C – 我的客户,A - 我的投顾,F – 我的好友");

	private final TableField<?>[] allFields = new TableField<?>[] {friendNewId,userId,reqDirection,reqStatus,targetUserId,rcmdUserId,reqMemo,reqSource,isNew,orderVersion,updVersion,deviceId,isStatus,createTime,updateTime,lockVersion,relationType};

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
		return "TUserFriendNew[table=user_friend_new]";
	}
}
