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

public class TUserUninvited extends AbstractTable {

	static {
		init();
	}

	private TUserUninvited(){
		super.tableName = "user_uninvited";
	}

	private TUserUninvited(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserUninvited getInstance() {
		return new TUserUninvited();
	}

	public static final TUserUninvited getInstance(String aliasName) {
		return new TUserUninvited(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("uninvitedId", "uninvited_id");
		allFieldMap.put("certType", "cert_type");
		allFieldMap.put("certCode", "cert_code");
		allFieldMap.put("ip", "ip");
		allFieldMap.put("imageUrl", "image_url");
		allFieldMap.put("nickName", "nick_name");
		allFieldMap.put("gender", "gender");
		allFieldMap.put("deviceType", "device_type");
		allFieldMap.put("deviceModel", "device_model");
		allFieldMap.put("osType", "os_type");
		allFieldMap.put("osVersoin", "os_versoin");
		allFieldMap.put("appVersion", "app_version");
		allFieldMap.put("channel", "channel");
		allFieldMap.put("lastAttempt", "last_attempt");
		allFieldMap.put("failedTimes", "failed_times");
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
	 * 登陆失败ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"uninvited_id","uninvitedId","登陆失败ID");
	public final TableField<Integer> uninvitedId = new TableFieldImpl<Integer>(this,"uninvited_id","uninvitedId","登陆失败ID");

	/**
	 * 登陆凭证类型 | tinyint(4)
	 */
	public final TableField<Integer> certType = new TableFieldImpl<Integer>(this,"cert_type","certType","登陆凭证类型");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> certCode = new TableFieldImpl<String>(this,"cert_code","certCode","");

	/**
	 *  | varchar(15)
	 */
	public final TableField<String> ip = new TableFieldImpl<String>(this,"ip","ip","");

	/**
	 *  | varchar(200)
	 */
	public final TableField<String> imageUrl = new TableFieldImpl<String>(this,"image_url","imageUrl","");

	/**
	 *  | varchar(80)
	 */
	public final TableField<String> nickName = new TableFieldImpl<String>(this,"nick_name","nickName","");

	/**
	 * 用户性别 | tinyint(4)
	 */
	public final TableField<Integer> gender = new TableFieldImpl<Integer>(this,"gender","gender","用户性别");

	/**
	 * 设备类型 | tinyint(4)
	 */
	public final TableField<Integer> deviceType = new TableFieldImpl<Integer>(this,"device_type","deviceType","设备类型");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> deviceModel = new TableFieldImpl<String>(this,"device_model","deviceModel","");

	/**
	 * 操作系统类型 | tinyint(4)
	 */
	public final TableField<Integer> osType = new TableFieldImpl<Integer>(this,"os_type","osType","操作系统类型");

	/**
	 *  | varchar(30)
	 */
	public final TableField<String> osVersoin = new TableFieldImpl<String>(this,"os_versoin","osVersoin","");

	/**
	 *  | varchar(30)
	 */
	public final TableField<String> appVersion = new TableFieldImpl<String>(this,"app_version","appVersion","");

	/**
	 *  | varchar(30)
	 */
	public final TableField<String> channel = new TableFieldImpl<String>(this,"channel","channel","");

	/**
	 * 最后一次登陆失败时间 | datetime
	 */
	public final DateTableField<Date> lastAttempt = new DateTableFieldImpl<Date>(this,"last_attempt","lastAttempt","最后一次登陆失败时间");

	/**
	 * 登陆失败尝试次数 | int(11)
	 */
	public final TableField<Integer> failedTimes = new TableFieldImpl<Integer>(this,"failed_times","failedTimes","登陆失败尝试次数");

	/**
	 * 记录状态 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 最后修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","最后修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {uninvitedId,certType,certCode,ip,imageUrl,nickName,gender,deviceType,deviceModel,osType,osVersoin,appVersion,channel,lastAttempt,failedTimes,isStatus,createTime,updateTime};

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
		return "TUserUninvited[table=user_uninvited]";
	}
}
