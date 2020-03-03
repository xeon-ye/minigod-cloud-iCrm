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

public class TAdviserVerifyInfo extends AbstractTable {

	static {
		init();
	}

	private TAdviserVerifyInfo(){
		super.tableName = "adviser_verify_info";
	}

	private TAdviserVerifyInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TAdviserVerifyInfo getInstance() {
		return new TAdviserVerifyInfo();
	}

	public static final TAdviserVerifyInfo getInstance(String aliasName) {
		return new TAdviserVerifyInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("adviserVerId", "adviser_ver_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("nickName", "nick_name");
		allFieldMap.put("realName", "real_name");
		allFieldMap.put("idType", "id_type");
		allFieldMap.put("idNumber", "id_number");
		allFieldMap.put("adviserType", "adviser_type");
		allFieldMap.put("licenceCode", "licence_code");
		allFieldMap.put("cityId", "city_id");
		allFieldMap.put("adviserOrgId", "adviser_org_id");
		allFieldMap.put("dept", "dept");
		allFieldMap.put("description", "description");
		allFieldMap.put("verifyImgs", "verify_imgs");
		allFieldMap.put("certUrls", "cert_urls");
		allFieldMap.put("certText", "cert_text");
		allFieldMap.put("jobStartYear", "job_start_year");
		allFieldMap.put("adeptField", "adept_field");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("auditOpr", "audit_opr");
		allFieldMap.put("verifyTime", "verify_time");
		allFieldMap.put("lockVersion", "lock_version");
		allFieldMap.put("switchVal", "switch_val");
		allFieldMap.put("bdAttributed", "bd_attributed");
		allFieldMap.put("reqSrc", "req_src");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("spellingAbbr", "spelling_abbr");
		allFieldMap.put("presentation", "presentation");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 *  | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"adviser_ver_id","adviserVerId","");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","");

	public final TableField<Integer> adviserVerId = new TableFieldImpl<Integer>(this,"adviser_ver_id","adviserVerId","");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 认证昵称 | varchar(100)
	 */
	public final TableField<String> nickName = new TableFieldImpl<String>(this,"nick_name","nickName","认证昵称");

	/**
	 * 真实姓名 | varchar(100)
	 */
	public final TableField<String> realName = new TableFieldImpl<String>(this,"real_name","realName","真实姓名");

	/**
	 * 证件类型(0-身份证) | tinyint(4)
	 */
	public final TableField<Integer> idType = new TableFieldImpl<Integer>(this,"id_type","idType","证件类型(0-身份证)");

	/**
	 * 证件号码 | varchar(50)
	 */
	public final TableField<String> idNumber = new TableFieldImpl<String>(this,"id_number","idNumber","证件号码");

	/**
	 * 投顾类型(1-投资顾问,2-分析师,3-投资达人,4-投资达人基金执业资格,5-投资达人一般证券业务,6-投资达人证券经纪人,7-投资达人证券 经纪业务营销,8-投资达人证券投资咨询业务) | tinyint(4)
	 */
	public final TableField<Integer> adviserType = new TableFieldImpl<Integer>(this,"adviser_type","adviserType","投顾类型(1-投资顾问,2-分析师,3-投资达人,4-投资达人基金执业资格,5-投资达人一般证券业务,6-投资达人证券经纪人,7-投资达人证券 经纪业务营销,8-投资达人证券投资咨询业务)");

	/**
	 * 执业编号 | varchar(255)
	 */
	public final TableField<String> licenceCode = new TableFieldImpl<String>(this,"licence_code","licenceCode","执业编号");

	/**
	 * 所属城市ID | int(11)
	 */
	public final TableField<Integer> cityId = new TableFieldImpl<Integer>(this,"city_id","cityId","所属城市ID");

	/**
	 * 所属投顾机构ID | int(11)
	 */
	public final TableField<Integer> adviserOrgId = new TableFieldImpl<Integer>(this,"adviser_org_id","adviserOrgId","所属投顾机构ID");

	/**
	 * 所属营业部 | varchar(100)
	 */
	public final TableField<String> dept = new TableFieldImpl<String>(this,"dept","dept","所属营业部");

	/**
	 * 简介 | varchar(300)
	 */
	public final TableField<String> description = new TableFieldImpl<String>(this,"description","description","简介");

	/**
	 * 认证图片 | varchar(500)
	 */
	public final TableField<String> verifyImgs = new TableFieldImpl<String>(this,"verify_imgs","verifyImgs","认证图片");

	/**
	 * 资质证明照片 | varchar(500)
	 */
	public final TableField<String> certUrls = new TableFieldImpl<String>(this,"cert_urls","certUrls","资质证明照片");

	/**
	 * 资质证明资料 | varchar(500)
	 */
	public final TableField<String> certText = new TableFieldImpl<String>(this,"cert_text","certText","资质证明资料");

	/**
	 * 从业开始年份 | int(11)
	 */
	public final TableField<Integer> jobStartYear = new TableFieldImpl<Integer>(this,"job_start_year","jobStartYear","从业开始年份");

	/**
	 * 擅长领域 | varchar(100)
	 */
	public final TableField<String> adeptField = new TableFieldImpl<String>(this,"adept_field","adeptField","擅长领域");

	/**
	 * 审核状态(0：认证取消;1：认证通过) | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","审核状态(0：认证取消;1：认证通过)");

	/**
	 * 审核人id | int(11)
	 */
	public final TableField<Integer> auditOpr = new TableFieldImpl<Integer>(this,"audit_opr","auditOpr","审核人id");

	/**
	 * 首次审核通过时间 | datetime
	 */
	public final DateTableField<Date> verifyTime = new DateTableFieldImpl<Date>(this,"verify_time","verifyTime","首次审核通过时间");

	/**
	 * 乐观锁 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁");

	/**
	 * 开关设置  每一位都用Y/N表示是否开通：第1位：是否开启开户服务 默认值N ，第2位：是否开启问答 默认值Y | char(10)
	 */
	public final TableField<String> switchVal = new TableFieldImpl<String>(this,"switch_val","switchVal","开关设置  每一位都用Y/N表示是否开通：第1位：是否开启开户服务 默认值N ，第2位：是否开启问答 默认值Y");

	/**
	 * 引荐人姓名 | varchar(100)
	 */
	public final TableField<String> bdAttributed = new TableFieldImpl<String>(this,"bd_attributed","bdAttributed","引荐人姓名");

	/**
	 * GA为投顾大赛 | varchar(10)
	 */
	public final TableField<String> reqSrc = new TableFieldImpl<String>(this,"req_src","reqSrc","GA为投顾大赛");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	/**
	 * 拼音简称 | varchar(200)
	 */
	public final TableField<String> spellingAbbr = new TableFieldImpl<String>(this,"spelling_abbr","spellingAbbr","拼音简称");

	/**
	 * 一句话介绍 | varchar(200)
	 */
	public final TableField<String> presentation = new TableFieldImpl<String>(this,"presentation","presentation","一句话介绍");

	private final TableField<?>[] allFields = new TableField<?>[] {adviserVerId,userId,nickName,realName,idType,idNumber,adviserType,licenceCode,cityId,adviserOrgId,dept,description,verifyImgs,certUrls,certText,jobStartYear,adeptField,isStatus,auditOpr,verifyTime,lockVersion,switchVal,bdAttributed,reqSrc,createTime,updateTime,spellingAbbr,presentation};

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
		return "TAdviserVerifyInfo[table=adviser_verify_info]";
	}
}
