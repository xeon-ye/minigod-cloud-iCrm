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

public class TFriendAttribExtend extends AbstractTable {

	static {
		init();
	}

	private TFriendAttribExtend(){
		super.tableName = "friend_attrib_extend";
	}

	private TFriendAttribExtend(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TFriendAttribExtend getInstance() {
		return new TFriendAttribExtend();
	}

	public static final TFriendAttribExtend getInstance(String aliasName) {
		return new TFriendAttribExtend(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("attribExtendId", "attrib_extend_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("friendUserId", "friend_user_id");
		allFieldMap.put("profession", "profession");
		allFieldMap.put("investType", "invest_type");
		allFieldMap.put("ageRange", "age_range");
		allFieldMap.put("assetSize", "asset_size");
		allFieldMap.put("openType", "open_type");
		allFieldMap.put("listenHabits", "listen_habits");
		allFieldMap.put("gender", "gender");
		allFieldMap.put("isMarried", "is_married");
		allFieldMap.put("haveChild", "have_child");
		allFieldMap.put("jobHour", "job_hour");
		allFieldMap.put("houseType", "house_type");
		allFieldMap.put("carType", "car_type");
		allFieldMap.put("comment", "comment");
		allFieldMap.put("isStatus", "is_status");
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
	 * 属性扩展id | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"attrib_extend_id","attribExtendId","属性扩展id");
	public final TableField<Integer> attribExtendId = new TableFieldImpl<Integer>(this,"attrib_extend_id","attribExtendId","属性扩展id");

	/**
	 * 用户id | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户id");

	/**
	 * 好友用户ID | int(11)
	 */
	public final TableField<Integer> friendUserId = new TableFieldImpl<Integer>(this,"friend_user_id","friendUserId","好友用户ID");

	/**
	 * 职业 | varchar(15)
	 */
	public final TableField<String> profession = new TableFieldImpl<String>(this,"profession","profession","职业");

	/**
	 * 投资喜好 | varchar(15)
	 */
	public final TableField<String> investType = new TableFieldImpl<String>(this,"invest_type","investType","投资喜好");

	/**
	 * 年龄范围 | varchar(15)
	 */
	public final TableField<String> ageRange = new TableFieldImpl<String>(this,"age_range","ageRange","年龄范围");

	/**
	 * 资产规模 | varchar(15)
	 */
	public final TableField<String> assetSize = new TableFieldImpl<String>(this,"asset_size","assetSize","资产规模");

	/**
	 * 开户信息 | varchar(15)
	 */
	public final TableField<String> openType = new TableFieldImpl<String>(this,"open_type","openType","开户信息");

	/**
	 * 听消息习惯 | varchar(15)
	 */
	public final TableField<String> listenHabits = new TableFieldImpl<String>(this,"listen_habits","listenHabits","听消息习惯");

	/**
	 * 用户性别(1男，0女) | tinyint(1)
	 */
	public final TableField<Boolean> gender = new TableFieldImpl<Boolean>(this,"gender","gender","用户性别(1男，0女)");

	/**
	 * 婚否 | varchar(15)
	 */
	public final TableField<String> isMarried = new TableFieldImpl<String>(this,"is_married","isMarried","婚否");

	/**
	 * 有孩子否 | varchar(15)
	 */
	public final TableField<String> haveChild = new TableFieldImpl<String>(this,"have_child","haveChild","有孩子否");

	/**
	 * 工作时长 | varchar(15)
	 */
	public final TableField<String> jobHour = new TableFieldImpl<String>(this,"job_hour","jobHour","工作时长");

	/**
	 * 房子信息 | varchar(15)
	 */
	public final TableField<String> houseType = new TableFieldImpl<String>(this,"house_type","houseType","房子信息");

	/**
	 * 车子信息 | varchar(15)
	 */
	public final TableField<String> carType = new TableFieldImpl<String>(this,"car_type","carType","车子信息");

	/**
	 * 备注信息 | varchar(500)
	 */
	public final TableField<String> comment = new TableFieldImpl<String>(this,"comment","comment","备注信息");

	/**
	 * 状态 0-无效，默认1-有效 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","状态 0-无效，默认1-有效");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {attribExtendId,userId,friendUserId,profession,investType,ageRange,assetSize,openType,listenHabits,gender,isMarried,haveChild,jobHour,houseType,carType,comment,isStatus,createTime,updateTime};

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
		return "TFriendAttribExtend[table=friend_attrib_extend]";
	}
}
