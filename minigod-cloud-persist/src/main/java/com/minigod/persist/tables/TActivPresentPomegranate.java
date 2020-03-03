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

public class TActivPresentPomegranate extends AbstractTable {

	static {
		init();
	}

	private TActivPresentPomegranate(){
		super.tableName = "activ_present_pomegranate";
	}

	private TActivPresentPomegranate(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TActivPresentPomegranate getInstance() {
		return new TActivPresentPomegranate();
	}

	public static final TActivPresentPomegranate getInstance(String aliasName) {
		return new TActivPresentPomegranate(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("userName", "user_name");
		allFieldMap.put("userPhonenum", "user_phonenum");
		allFieldMap.put("locationAddress", "location_address");
		allFieldMap.put("detailAddress", "detail_address");
		allFieldMap.put("inviteUsersNumber", "invite_users_number");
		allFieldMap.put("receiveNumber", "receive_number");
		allFieldMap.put("rewardType", "reward_type");
		allFieldMap.put("grantStatus", "grant_status");
		allFieldMap.put("createdTime", "created_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("createdBy", "created_by");
		allFieldMap.put("updateBy", "update_by");
		allFieldMap.put("recordStatus", "record_status");
		allFieldMap.put("rmk", "rmk");
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
	 * 客户id | int(10) unsigned
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","客户id");

	/**
	 * 客户名称 | varchar(30)
	 */
	public final TableField<String> userName = new TableFieldImpl<String>(this,"user_name","userName","客户名称");

	/**
	 * 客户手机号 | varchar(20)
	 */
	public final TableField<String> userPhonenum = new TableFieldImpl<String>(this,"user_phonenum","userPhonenum","客户手机号");

	/**
	 * 所在地区 | varchar(100)
	 */
	public final TableField<String> locationAddress = new TableFieldImpl<String>(this,"location_address","locationAddress","所在地区");

	/**
	 * 详细地址 | varchar(100)
	 */
	public final TableField<String> detailAddress = new TableFieldImpl<String>(this,"detail_address","detailAddress","详细地址");

	/**
	 * 邀请用户数 | int(5) unsigned
	 */
	public final TableField<Integer> inviteUsersNumber = new TableFieldImpl<Integer>(this,"invite_users_number","inviteUsersNumber","邀请用户数");

	/**
	 * 奖品领取箱数 | int(2) unsigned
	 */
	public final TableField<Integer> receiveNumber = new TableFieldImpl<Integer>(this,"receive_number","receiveNumber","奖品领取箱数");

	/**
	 * 记录状态:1:开户奖励,2:邀请注册奖励 | int(2) unsigned
	 */
	public final TableField<Integer> rewardType = new TableFieldImpl<Integer>(this,"reward_type","rewardType","记录状态:1:开户奖励,2:邀请注册奖励");

	/**
	 * 发放状态:1:未发放,2:已发放 | int(2) unsigned
	 */
	public final TableField<Integer> grantStatus = new TableFieldImpl<Integer>(this,"grant_status","grantStatus","发放状态:1:未发放,2:已发放");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createdTime = new DateTableFieldImpl<Date>(this,"created_time","createdTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	/**
	 * 创建人 | varchar(30)
	 */
	public final TableField<String> createdBy = new TableFieldImpl<String>(this,"created_by","createdBy","创建人");

	/**
	 * 修改人 | varchar(30)
	 */
	public final TableField<String> updateBy = new TableFieldImpl<String>(this,"update_by","updateBy","修改人");

	/**
	 * 记录状态:0:有效1:无效 | int(2) unsigned
	 */
	public final TableField<Integer> recordStatus = new TableFieldImpl<Integer>(this,"record_status","recordStatus","记录状态:0:有效1:无效");

	/**
	 * 备注 | varchar(300)
	 */
	public final TableField<String> rmk = new TableFieldImpl<String>(this,"rmk","rmk","备注");

	private final TableField<?>[] allFields = new TableField<?>[] {id,userId,userName,userPhonenum,locationAddress,detailAddress,inviteUsersNumber,receiveNumber,rewardType,grantStatus,createdTime,updateTime,createdBy,updateBy,recordStatus,rmk};

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
		return "TActivPresentPomegranate[table=activ_present_pomegranate]";
	}
}
