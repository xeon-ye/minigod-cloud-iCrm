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

public class TUserDevice extends AbstractTable {

	static {
		init();
	}

	private TUserDevice(){
		super.tableName = "user_device";
	}

	private TUserDevice(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserDevice getInstance() {
		return new TUserDevice();
	}

	public static final TUserDevice getInstance(String aliasName) {
		return new TUserDevice(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("deviceId", "device_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("guestFlag", "guest_flag");
		allFieldMap.put("deviceType", "device_type");
		allFieldMap.put("deviceModel", "device_model");
		allFieldMap.put("osType", "os_type");
		allFieldMap.put("osVersoin", "os_versoin");
		allFieldMap.put("appVersion", "app_version");
		allFieldMap.put("deviceName", "device_name");
		allFieldMap.put("deviceCode", "device_code");
		allFieldMap.put("openToken", "open_token");
		allFieldMap.put("openCode", "open_code");
		allFieldMap.put("regChannel", "reg_channel");
		allFieldMap.put("channel", "channel");
		allFieldMap.put("authFlag", "auth_flag");
		allFieldMap.put("pushConfig", "push_config");
		allFieldMap.put("configUpdateTime", "config_update_time");
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
	 * 设备ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"device_id","deviceId","设备ID");
	public final TableField<Integer> deviceId = new TableFieldImpl<Integer>(this,"device_id","deviceId","设备ID");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 当为游客时值为0，转为正式用户时值为user_id，已经是正式用户绑定新设备时直接存user_id。 | int(11)
	 */
	public final TableField<Integer> guestFlag = new TableFieldImpl<Integer>(this,"guest_flag","guestFlag","当为游客时值为0，转为正式用户时值为user_id，已经是正式用户绑定新设备时直接存user_id。");

	/**
	 * 设备类型(0PC;1手机;2平板) | tinyint(4)
	 */
	public final TableField<Integer> deviceType = new TableFieldImpl<Integer>(this,"device_type","deviceType","设备类型(0PC;1手机;2平板)");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> deviceModel = new TableFieldImpl<String>(this,"device_model","deviceModel","");

	/**
	 * 操作系统类型(0安卓，1苹果，2WP) | tinyint(4)
	 */
	public final TableField<Integer> osType = new TableFieldImpl<Integer>(this,"os_type","osType","操作系统类型(0安卓，1苹果，2WP)");

	/**
	 *  | varchar(30)
	 */
	public final TableField<String> osVersoin = new TableFieldImpl<String>(this,"os_versoin","osVersoin","");

	/**
	 *  | varchar(30)
	 */
	public final TableField<String> appVersion = new TableFieldImpl<String>(this,"app_version","appVersion","");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> deviceName = new TableFieldImpl<String>(this,"device_name","deviceName","");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> deviceCode = new TableFieldImpl<String>(this,"device_code","deviceCode","");

	/**
	 *  | varchar(200)
	 */
	public final TableField<String> openToken = new TableFieldImpl<String>(this,"open_token","openToken","");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> openCode = new TableFieldImpl<String>(this,"open_code","openCode","");

	/**
	 * 注册的渠道 | varchar(30)
	 */
	public final TableField<String> regChannel = new TableFieldImpl<String>(this,"reg_channel","regChannel","注册的渠道");

	/**
	 * 当前使用的渠道 | varchar(30)
	 */
	public final TableField<String> channel = new TableFieldImpl<String>(this,"channel","channel","当前使用的渠道");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> authFlag = new TableFieldImpl<String>(this,"auth_flag","authFlag","");

	/**
	 * 0表示关闭了通知，1(1<<0)表示开启了应用图标提醒，2(1<<1)表示开启声音提醒，4(1<<2)表示开启弹窗提醒 8(1<<3)不用管。复选的时候数字简单相加。默认为-1，表示未知。 | tinyint(4)
	 */
	public final TableField<Integer> pushConfig = new TableFieldImpl<Integer>(this,"push_config","pushConfig","0表示关闭了通知，1(1<<0)表示开启了应用图标提醒，2(1<<1)表示开启声音提醒，4(1<<2)表示开启弹窗提醒 8(1<<3)不用管。复选的时候数字简单相加。默认为-1，表示未知。");

	/**
	 * APP端系统推送设置信息更新时间。默认为空，push_config字段更新时更新 | datetime
	 */
	public final DateTableField<Date> configUpdateTime = new DateTableFieldImpl<Date>(this,"config_update_time","configUpdateTime","APP端系统推送设置信息更新时间。默认为空，push_config字段更新时更新");

	/**
	 * 状态(手机丢失后，用户可以禁用该设备,1正常使用，0禁用) | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","状态(手机丢失后，用户可以禁用该设备,1正常使用，0禁用)");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 最后修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","最后修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {deviceId,userId,guestFlag,deviceType,deviceModel,osType,osVersoin,appVersion,deviceName,deviceCode,openToken,openCode,regChannel,channel,authFlag,pushConfig,configUpdateTime,isStatus,createTime,updateTime};

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
		return "TUserDevice[table=user_device]";
	}
}
