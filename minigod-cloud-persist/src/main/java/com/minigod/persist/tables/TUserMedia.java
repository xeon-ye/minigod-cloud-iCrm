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

public class TUserMedia extends AbstractTable {

	static {
		init();
	}

	private TUserMedia(){
		super.tableName = "user_media";
	}

	private TUserMedia(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserMedia getInstance() {
		return new TUserMedia();
	}

	public static final TUserMedia getInstance(String aliasName) {
		return new TUserMedia(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("friendId", "friend_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("friendUserId", "friend_user_id");
		allFieldMap.put("commentName", "comment_name");
		allFieldMap.put("authFlag", "auth_flag");
		allFieldMap.put("friendTime", "friend_time");
		allFieldMap.put("unfriendTime", "unfriend_time");
		allFieldMap.put("unfriendType", "unfriend_type");
		allFieldMap.put("creVersion", "cre_version");
		allFieldMap.put("updVersion", "upd_version");
		allFieldMap.put("groupId", "group_id");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("isInBlacklist", "is_in_blacklist");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("relationType", "relation_type");
		allFieldMap.put("clientTime", "client_time");
		allFieldMap.put("unclientTime", "unclient_time");
		allFieldMap.put("unclientType", "unclient_type");
		allFieldMap.put("isNodisturbing", "is_nodisturbing");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 好友关系ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"friend_id","friendId","好友关系ID");
	public final TableField<Integer> friendId = new TableFieldImpl<Integer>(this,"friend_id","friendId","好友关系ID");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 好友用户ID | int(11)
	 */
	public final TableField<Integer> friendUserId = new TableFieldImpl<Integer>(this,"friend_user_id","friendUserId","好友用户ID");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> commentName = new TableFieldImpl<String>(this,"comment_name","commentName","");

	/**
	 *  | varchar(10)
	 */
	public final TableField<String> authFlag = new TableFieldImpl<String>(this,"auth_flag","authFlag","");

	/**
	 * 成为好友时间 | datetime
	 */
	public final DateTableField<Date> friendTime = new DateTableFieldImpl<Date>(this,"friend_time","friendTime","成为好友时间");

	/**
	 * 解除好友时间 | datetime
	 */
	public final DateTableField<Date> unfriendTime = new DateTableFieldImpl<Date>(this,"unfriend_time","unfriendTime","解除好友时间");

	/**
	 * 解除好友类型(1-主动解除,0-对方解除,默认为空) | tinyint(1)
	 */
	public final TableField<Boolean> unfriendType = new TableFieldImpl<Boolean>(this,"unfriend_type","unfriendType","解除好友类型(1-主动解除,0-对方解除,默认为空)");

	/**
	 * 创建版本号 | bigint(19)
	 */
	public final TableField<Long> creVersion = new TableFieldImpl<Long>(this,"cre_version","creVersion","创建版本号");

	/**
	 * 修改版本号 | bigint(19)
	 */
	public final TableField<Long> updVersion = new TableFieldImpl<Long>(this,"upd_version","updVersion","修改版本号");

	/**
	 *  | int(11)
	 */
	public final TableField<Integer> groupId = new TableFieldImpl<Integer>(this,"group_id","groupId","");

	/**
	 * 记录状态(0-无效，1-有效) | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态(0-无效，1-有效)");

	/**
	 * 是否在黑名单上 0-不是 1-是 | tinyint(1)
	 */
	public final TableField<Boolean> isInBlacklist = new TableFieldImpl<Boolean>(this,"is_in_blacklist","isInBlacklist","是否在黑名单上 0-不是 1-是");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 最后修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","最后修改时间");

	/**
	 * 关系类型	C – 我的粉丝,A - 我关注的自媒体 | char(1)
	 */
	public final TableField<String> relationType = new TableFieldImpl<String>(this,"relation_type","relationType","关系类型	C – 我的粉丝,A - 我关注的自媒体");

	/**
	 * 成为客户时间 | datetime
	 */
	public final DateTableField<Date> clientTime = new DateTableFieldImpl<Date>(this,"client_time","clientTime","成为客户时间");

	/**
	 * 解除客户时间 | datetime
	 */
	public final DateTableField<Date> unclientTime = new DateTableFieldImpl<Date>(this,"unclient_time","unclientTime","解除客户时间");

	/**
	 * 解除客户类型(1-主动解除,0-对方解除,默认为空) | tinyint(1)
	 */
	public final TableField<Boolean> unclientType = new TableFieldImpl<Boolean>(this,"unclient_type","unclientType","解除客户类型(1-主动解除,0-对方解除,默认为空)");

	/**
	 * 是否免打扰,1是0否 | tinyint(1)
	 */
	public final TableField<Boolean> isNodisturbing = new TableFieldImpl<Boolean>(this,"is_nodisturbing","isNodisturbing","是否免打扰,1是0否");

	private final TableField<?>[] allFields = new TableField<?>[] {friendId,userId,friendUserId,commentName,authFlag,friendTime,unfriendTime,unfriendType,creVersion,updVersion,groupId,isStatus,isInBlacklist,createTime,updateTime,relationType,clientTime,unclientTime,unclientType,isNodisturbing};

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
		return "TUserMedia[table=user_media]";
	}
}
