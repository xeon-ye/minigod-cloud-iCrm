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

public class TUserInfo extends AbstractTable {

	static {
		init();
	}

	private TUserInfo(){
		super.tableName = "user_info";
	}

	private TUserInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserInfo getInstance() {
		return new TUserInfo();
	}

	public static final TUserInfo getInstance(String aliasName) {
		return new TUserInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("nickName", "nick_name");
		allFieldMap.put("signature", "signature");
		allFieldMap.put("gender", "gender");
		allFieldMap.put("userIcon", "user_icon");
		allFieldMap.put("userSourceChannelId", "user_source_channel_id");
		allFieldMap.put("invUserId", "inv_user_id");
		allFieldMap.put("vocationId", "vocation_id");
		allFieldMap.put("userType", "user_type");
		allFieldMap.put("adviserType", "adviser_type");
		allFieldMap.put("userStatus", "user_status");
		allFieldMap.put("password", "password");
		allFieldMap.put("privacy", "privacy");
		allFieldMap.put("friendLimit", "friend_limit");
		allFieldMap.put("adviserLimit", "adviser_limit");
		allFieldMap.put("ptfFavLimit", "ptf_fav_limit");
		allFieldMap.put("groupLimit", "group_limit");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("lastLoginTime", "last_login_time");
		allFieldMap.put("lastLoginIp", "last_login_ip");
		allFieldMap.put("lastCityId", "last_city_id");
		allFieldMap.put("loginCount", "login_count");
		allFieldMap.put("imId", "im_id");
		allFieldMap.put("imPwd", "im_pwd");
		allFieldMap.put("pwdErrorCount", "pwd_error_count");
		allFieldMap.put("lockTime", "lock_time");
		allFieldMap.put("lockVersion", "lock_version");
		allFieldMap.put("tradePwd", "trade_pwd");
		allFieldMap.put("tradePwdErrCount", "trade_pwd_err_count");
		allFieldMap.put("cellPhone", "cell_phone");
		allFieldMap.put("areaCode", "area_code");
		allFieldMap.put("jfGroup", "jf_group");
		allFieldMap.put("gesturePwd", "gesture_pwd");
		allFieldMap.put("getstureShowTime", "getsture_show_time");
		allFieldMap.put("regSourceType", "reg_source_type");
		allFieldMap.put("regSource", "reg_source");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 用户ID | int(20)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","用户ID");

	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 *  | varchar(90)
	 */
	public final TableField<String> nickName = new TableFieldImpl<String>(this,"nick_name","nickName","");

	/**
	 *  | varchar(500)
	 */
	public final TableField<String> signature = new TableFieldImpl<String>(this,"signature","signature","");

	/**
	 * 用户性别(1男，0女) | tinyint(1)
	 */
	public final TableField<Boolean> gender = new TableFieldImpl<Boolean>(this,"gender","gender","用户性别(1男，0女)");

	/**
	 * 用户图像 | char(200)
	 */
	public final TableField<String> userIcon = new TableFieldImpl<String>(this,"user_icon","userIcon","用户图像");

	/**
	 * 渠道id | varchar(10)
	 */
	public final TableField<String> userSourceChannelId = new TableFieldImpl<String>(this,"user_source_channel_id","userSourceChannelId","渠道id");

	/**
	 * 推荐人ID,邀请该用户的用户ID | int(20)
	 */
	public final TableField<Integer> invUserId = new TableFieldImpl<Integer>(this,"inv_user_id","invUserId","推荐人ID,邀请该用户的用户ID");

	/**
	 * 职业 | int(11)
	 */
	public final TableField<Integer> vocationId = new TableFieldImpl<Integer>(this,"vocation_id","vocationId","职业");

	/**
	 * 用户类型(默认所有用户均为1类型;0：游客用户；1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；3:官方账号；) | tinyint(4)
	 */
	public final TableField<Integer> userType = new TableFieldImpl<Integer>(this,"user_type","userType","用户类型(默认所有用户均为1类型;0：游客用户；1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；3:官方账号；)");

	/**
	 * 投顾类型 | tinyint(4)
	 */
	public final TableField<Integer> adviserType = new TableFieldImpl<Integer>(this,"adviser_type","adviserType","投顾类型");

	/**
	 * 用户状态 0-停用,1-正常,2-锁定 | tinyint(4)
	 */
	public final TableField<Integer> userStatus = new TableFieldImpl<Integer>(this,"user_status","userStatus","用户状态 0-停用,1-正常,2-锁定");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> password = new TableFieldImpl<String>(this,"password","password","");

	/**
	 * 隐私开关设置  每一位都用Y/N表示是否开通：第1位：是否允许将我引荐给别人 第2位：是否允许通过手机号搜索到我（控制手机号搜索、通讯录匹配）  第3位：是否接收资讯推送 第4位：加我为联系人时需要验证 第5位:是否开启自选股排序 | char(10)
	 */
	public final TableField<String> privacy = new TableFieldImpl<String>(this,"privacy","privacy","隐私开关设置  每一位都用Y/N表示是否开通：第1位：是否允许将我引荐给别人 第2位：是否允许通过手机号搜索到我（控制手机号搜索、通讯录匹配）  第3位：是否接收资讯推送 第4位：加我为联系人时需要验证 第5位:是否开启自选股排序");

	/**
	 * 好友数量上限默认5000个 | int(11)
	 */
	public final TableField<Integer> friendLimit = new TableFieldImpl<Integer>(this,"friend_limit","friendLimit","好友数量上限默认5000个");

	/**
	 * 投顾数量上限默认5个 | int(11)
	 */
	public final TableField<Integer> adviserLimit = new TableFieldImpl<Integer>(this,"adviser_limit","adviserLimit","投顾数量上限默认5个");

	/**
	 * 关注组合上限 | int(11)
	 */
	public final TableField<Integer> ptfFavLimit = new TableFieldImpl<Integer>(this,"ptf_fav_limit","ptfFavLimit","关注组合上限");

	/**
	 * 群组的上限 | int(11)
	 */
	public final TableField<Integer> groupLimit = new TableFieldImpl<Integer>(this,"group_limit","groupLimit","群组的上限");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 最后修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","最后修改时间");

	/**
	 * 最后登录时间 | datetime
	 */
	public final DateTableField<Date> lastLoginTime = new DateTableFieldImpl<Date>(this,"last_login_time","lastLoginTime","最后登录时间");

	/**
	 *  | varchar(15)
	 */
	public final TableField<String> lastLoginIp = new TableFieldImpl<String>(this,"last_login_ip","lastLoginIp","");

	/**
	 * 最后登录的城市ID | int(11)
	 */
	public final TableField<Integer> lastCityId = new TableFieldImpl<Integer>(this,"last_city_id","lastCityId","最后登录的城市ID");

	/**
	 * 总登录次数 | bigint(20)
	 */
	public final TableField<Long> loginCount = new TableFieldImpl<Long>(this,"login_count","loginCount","总登录次数");

	/**
	 * 第三方IM平台的ID | varchar(32)
	 */
	public final TableField<String> imId = new TableFieldImpl<String>(this,"im_id","imId","第三方IM平台的ID");

	/**
	 * 第三方IM平台的密码 | varchar(32)
	 */
	public final TableField<String> imPwd = new TableFieldImpl<String>(this,"im_pwd","imPwd","第三方IM平台的密码");

	/**
	 * 密码错误次数 | tinyint(4)
	 */
	public final TableField<Integer> pwdErrorCount = new TableFieldImpl<Integer>(this,"pwd_error_count","pwdErrorCount","密码错误次数");

	/**
	 * 用户密码锁定的时间 | datetime
	 */
	public final DateTableField<Date> lockTime = new DateTableFieldImpl<Date>(this,"lock_time","lockTime","用户密码锁定的时间");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	/**
	 * 支付交易密码 | varchar(32)
	 */
	public final TableField<String> tradePwd = new TableFieldImpl<String>(this,"trade_pwd","tradePwd","支付交易密码");

	/**
	 * 支付密码错误次数 | tinyint(4)
	 */
	public final TableField<Integer> tradePwdErrCount = new TableFieldImpl<Integer>(this,"trade_pwd_err_count","tradePwdErrCount","支付密码错误次数");

	/**
	 * 手机号 | varchar(100)
	 */
	public final TableField<String> cellPhone = new TableFieldImpl<String>(this,"cell_phone","cellPhone","手机号");

	/**
	 * 国际区号 | varchar(20)
	 */
	public final TableField<String> areaCode = new TableFieldImpl<String>(this,"area_code","areaCode","国际区号");

	/**
	 * 玖富集团用户 | tinyint(1)
	 */
	public final TableField<Boolean> jfGroup = new TableFieldImpl<Boolean>(this,"jf_group","jfGroup","玖富集团用户");

	/**
	 * 手势密码 | varchar(32)
	 */
	public final TableField<String> gesturePwd = new TableFieldImpl<String>(this,"gesture_pwd","gesturePwd","手势密码");

	/**
	 * 从后台切换到前台需要输入手势密码的时长限制 | int(3)
	 */
	public final TableField<Integer> getstureShowTime = new TableFieldImpl<Integer>(this,"getsture_show_time","getstureShowTime","从后台切换到前台需要输入手势密码的时长限制");

	/**
	 * 注册来源 | varchar(50)
	 */
	public final TableField<String> regSourceType = new TableFieldImpl<String>(this,"reg_source_type","regSourceType","注册来源");

	/**
	 * 渠道 | varchar(50)
	 */
	public final TableField<String> regSource = new TableFieldImpl<String>(this,"reg_source","regSource","渠道");

	private final TableField<?>[] allFields = new TableField<?>[] {userId,nickName,signature,gender,userIcon,userSourceChannelId,invUserId,vocationId,userType,adviserType,userStatus,password,privacy,friendLimit,adviserLimit,ptfFavLimit,groupLimit,createTime,updateTime,lastLoginTime,lastLoginIp,lastCityId,loginCount,imId,imPwd,pwdErrorCount,lockTime,lockVersion,tradePwd,tradePwdErrCount,cellPhone,areaCode,jfGroup,gesturePwd,getstureShowTime,regSourceType,regSource};

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
		return "TUserInfo[table=user_info]";
	}
}
