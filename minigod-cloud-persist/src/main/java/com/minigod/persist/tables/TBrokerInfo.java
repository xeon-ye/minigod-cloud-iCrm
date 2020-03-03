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

public class TBrokerInfo extends AbstractTable {

	static {
		init();
	}

	private TBrokerInfo(){
		super.tableName = "broker_info";
	}

	private TBrokerInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TBrokerInfo getInstance() {
		return new TBrokerInfo();
	}

	public static final TBrokerInfo getInstance(String aliasName) {
		return new TBrokerInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("brokerId", "broker_id");
		allFieldMap.put("regionCode", "region_code");
		allFieldMap.put("brokerCode", "broker_code");
		allFieldMap.put("shortName", "short_name");
		allFieldMap.put("fullName", "full_name");
		allFieldMap.put("brokerIcon", "broker_icon");
		allFieldMap.put("channelId", "channel_id");
		allFieldMap.put("channelBrkCode", "channel_brk_code");
		allFieldMap.put("funcList", "func_list");
		allFieldMap.put("sptLoginAcc", "spt_login_acc");
		allFieldMap.put("isNeedOpenid", "is_need_openid");
		allFieldMap.put("isOrderServer", "is_order_server");
		allFieldMap.put("iosVer", "ios_ver");
		allFieldMap.put("androidVer", "android_ver");
		allFieldMap.put("iosOpenaccUrl", "ios_openacc_url");
		allFieldMap.put("androidOpenaccUrl", "android_openacc_url");
		allFieldMap.put("marketingName", "marketing_name");
		allFieldMap.put("marketingUrl", "marketing_url");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("appIosPackage", "app_ios_package");
		allFieldMap.put("appAndroidPackage", "app_android_package");
		allFieldMap.put("isRedirectTrade", "is_redirect_trade");
		allFieldMap.put("redirectIosAppUrl", "redirect_ios_app_url");
		allFieldMap.put("redirectIosStoreUrl", "redirect_ios_store_url");
		allFieldMap.put("redirectAndroidPackage", "redirect_android_package");
		allFieldMap.put("redirectAndroidActivity", "redirect_android_activity");
		allFieldMap.put("androidDownloadUrl", "android_download_url");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 券商ID;人工编制，非自增长字段;100041-大陆国信证券 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"broker_id","brokerId","券商ID;人工编制，非自增长字段;100041-大陆国信证券");
	public final TableField<Integer> brokerId = new TableFieldImpl<Integer>(this,"broker_id","brokerId","券商ID;人工编制，非自增长字段;100041-大陆国信证券");

	/**
	 *  | varchar(6)
	 */
	public final TableField<String> regionCode = new TableFieldImpl<String>(this,"region_code","regionCode","");

	/**
	 *  | varchar(10)
	 */
	public final TableField<String> brokerCode = new TableFieldImpl<String>(this,"broker_code","brokerCode","");

	/**
	 *  | varchar(10)
	 */
	public final TableField<String> shortName = new TableFieldImpl<String>(this,"short_name","shortName","");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> fullName = new TableFieldImpl<String>(this,"full_name","fullName","");

	/**
	 *  | varchar(200)
	 */
	public final TableField<String> brokerIcon = new TableFieldImpl<String>(this,"broker_icon","brokerIcon","");

	/**
	 * 交易渠道;该券商目前所用的渠道，如iTN、国信直连等 | int(11)
	 */
	public final TableField<Integer> channelId = new TableFieldImpl<Integer>(this,"channel_id","channelId","交易渠道;该券商目前所用的渠道，如iTN、国信直连等");

	/**
	 * 渠道券商编码 | varchar(10)
	 */
	public final TableField<String> channelBrkCode = new TableFieldImpl<String>(this,"channel_brk_code","channelBrkCode","渠道券商编码");

	/**
	 * 每一位都用Y/N表示是否开通：第1位：是否允许交易,第2位：是否允许跳转开户,第3位：当前是否有营销活动,第4位：是否允许通过服务器登录 | char(10)
	 */
	public final TableField<String> funcList = new TableFieldImpl<String>(this,"func_list","funcList","每一位都用Y/N表示是否开通：第1位：是否允许交易,第2位：是否允许跳转开户,第3位：当前是否有营销活动,第4位：是否允许通过服务器登录");

	/**
	 * 可用登录账号类型,表示该券商支持的类型，包含则支持，如12和21都表示支持客户号和资金账号登录：1：支持客户号登录,2：支持资金账号登录,3：支持深A股东账号登录,4：支持沪A股东账号登录,5：支持深B股东账号登录,6：支持沪B股东账号登录 | char(10)
	 */
	public final TableField<String> sptLoginAcc = new TableFieldImpl<String>(this,"spt_login_acc","sptLoginAcc","可用登录账号类型,表示该券商支持的类型，包含则支持，如12和21都表示支持客户号和资金账号登录：1：支持客户号登录,2：支持资金账号登录,3：支持深A股东账号登录,4：支持沪A股东账号登录,5：支持深B股东账号登录,6：支持沪B股东账号登录");

	/**
	 * 0-不需要，1-需要(默认) | tinyint(1)
	 */
	public final TableField<Boolean> isNeedOpenid = new TableFieldImpl<Boolean>(this,"is_need_openid","isNeedOpenid","0-不需要，1-需要(默认)");

	/**
	 * 0-不需要(默认)，1-需要 | tinyint(1)
	 */
	public final TableField<Boolean> isOrderServer = new TableFieldImpl<Boolean>(this,"is_order_server","isOrderServer","0-不需要(默认)，1-需要");

	/**
	 *  | varchar(30)
	 */
	public final TableField<String> iosVer = new TableFieldImpl<String>(this,"ios_ver","iosVer","");

	/**
	 *  | varchar(30)
	 */
	public final TableField<String> androidVer = new TableFieldImpl<String>(this,"android_ver","androidVer","");

	/**
	 *  | varchar(200)
	 */
	public final TableField<String> iosOpenaccUrl = new TableFieldImpl<String>(this,"ios_openacc_url","iosOpenaccUrl","");

	/**
	 *  | varchar(200)
	 */
	public final TableField<String> androidOpenaccUrl = new TableFieldImpl<String>(this,"android_openacc_url","androidOpenaccUrl","");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> marketingName = new TableFieldImpl<String>(this,"marketing_name","marketingName","");

	/**
	 *  | varchar(200)
	 */
	public final TableField<String> marketingUrl = new TableFieldImpl<String>(this,"marketing_url","marketingUrl","");

	/**
	 * 状态;0停用，1正常使用 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","状态;0停用，1正常使用");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 最后修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","最后修改时间");

	/**
	 *  | varchar(250)
	 */
	public final TableField<String> appIosPackage = new TableFieldImpl<String>(this,"app_ios_package","appIosPackage","");

	/**
	 *  | varchar(250)
	 */
	public final TableField<String> appAndroidPackage = new TableFieldImpl<String>(this,"app_android_package","appAndroidPackage","");

	/**
	 *  | tinyint(4)
	 */
	public final TableField<Integer> isRedirectTrade = new TableFieldImpl<Integer>(this,"is_redirect_trade","isRedirectTrade","");

	/**
	 *  | varchar(250)
	 */
	public final TableField<String> redirectIosAppUrl = new TableFieldImpl<String>(this,"redirect_ios_app_url","redirectIosAppUrl","");

	/**
	 *  | varchar(250)
	 */
	public final TableField<String> redirectIosStoreUrl = new TableFieldImpl<String>(this,"redirect_ios_store_url","redirectIosStoreUrl","");

	/**
	 *  | varchar(250)
	 */
	public final TableField<String> redirectAndroidPackage = new TableFieldImpl<String>(this,"redirect_android_package","redirectAndroidPackage","");

	/**
	 *  | varchar(250)
	 */
	public final TableField<String> redirectAndroidActivity = new TableFieldImpl<String>(this,"redirect_android_activity","redirectAndroidActivity","");

	/**
	 *  | varchar(250)
	 */
	public final TableField<String> androidDownloadUrl = new TableFieldImpl<String>(this,"android_download_url","androidDownloadUrl","");

	private final TableField<?>[] allFields = new TableField<?>[] {brokerId,regionCode,brokerCode,shortName,fullName,brokerIcon,channelId,channelBrkCode,funcList,sptLoginAcc,isNeedOpenid,isOrderServer,iosVer,androidVer,iosOpenaccUrl,androidOpenaccUrl,marketingName,marketingUrl,isStatus,createTime,updateTime,appIosPackage,appAndroidPackage,isRedirectTrade,redirectIosAppUrl,redirectIosStoreUrl,redirectAndroidPackage,redirectAndroidActivity,androidDownloadUrl};

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
		return false;
	}

	public final boolean isLockVersion() {
		return false;
	}

	public String toString() {
		return "TBrokerInfo[table=broker_info]";
	}
}
