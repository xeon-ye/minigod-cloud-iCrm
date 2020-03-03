package com.minigod.persist.tables;
import com.minigod.db4j.table.AllField;
import com.minigod.db4j.table.AbstractTable;
import com.minigod.db4j.table.TableField;
import com.minigod.db4j.table.TableFieldImpl;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.util.Date;
import com.minigod.db4j.table.DateTableField;
import com.minigod.db4j.table.DateTableFieldImpl;

public class TCouponInfo extends AbstractTable {

	static {
		init();
	}

	private TCouponInfo(){
		super.tableName = "coupon_info";
	}

	private TCouponInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TCouponInfo getInstance() {
		return new TCouponInfo();
	}

	public static final TCouponInfo getInstance(String aliasName) {
		return new TCouponInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("couponId", "coupon_id");
		allFieldMap.put("reqNo", "req_no");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("templateId", "template_id");
		allFieldMap.put("title", "title");
		allFieldMap.put("description", "description");
		allFieldMap.put("type", "type");
		allFieldMap.put("fromUserId", "from_user_id");
		allFieldMap.put("activityId", "activity_id");
		allFieldMap.put("sourceDescription", "source_description");
		allFieldMap.put("color", "color");
		allFieldMap.put("unit", "unit");
		allFieldMap.put("interestAddRate", "interest_add_rate");
		allFieldMap.put("interestAddDay", "interest_add_day");
		allFieldMap.put("couponStatus", "coupon_status");
		allFieldMap.put("expireDate", "expire_date");
		allFieldMap.put("useTime", "use_time");
		allFieldMap.put("verifyStatus", "verify_status");
		allFieldMap.put("updVersion", "upd_version");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("lockVersion", "lock_version");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 券ID,主键，自增长 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"coupon_id","couponId","券ID,主键，自增长");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","券ID,主键，自增长");

	public final TableField<Integer> couponId = new TableFieldImpl<Integer>(this,"coupon_id","couponId","券ID,主键，自增长");

	/**
	 * 请求发放卡券的ID | varchar(32)
	 */
	public final TableField<String> reqNo = new TableFieldImpl<String>(this,"req_no","reqNo","请求发放卡券的ID");

	/**
	 * 用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 卡券模板id | int(20)
	 */
	public final TableField<Integer> templateId = new TableFieldImpl<Integer>(this,"template_id","templateId","卡券模板id");

	/**
	 * 卡券的标题 | varchar(32)
	 */
	public final TableField<String> title = new TableFieldImpl<String>(this,"title","title","卡券的标题");

	/**
	 * 卡券的描述 | varchar(128)
	 */
	public final TableField<String> description = new TableFieldImpl<String>(this,"description","description","卡券的描述");

	/**
	 * 卡券类型,1:加息券 | int(11)
	 */
	public final TableField<Integer> type = new TableFieldImpl<Integer>(this,"type","type","卡券类型,1:加息券");

	/**
	 * 此卡券来自哪个用户的用户ID | int(11)
	 */
	public final TableField<Integer> fromUserId = new TableFieldImpl<Integer>(this,"from_user_id","fromUserId","此卡券来自哪个用户的用户ID");

	/**
	 * 卡券来源,REG:用户组成OMS:OMS发放 | int(11)
	 */
	public final TableField<Integer> activityId = new TableFieldImpl<Integer>(this,"activity_id","activityId","卡券来源,REG:用户组成OMS:OMS发放");

	/**
	 * 来源描述 | varchar(128)
	 */
	public final TableField<String> sourceDescription = new TableFieldImpl<String>(this,"source_description","sourceDescription","来源描述");

	/**
	 * 卡券的颜色 | char(9)
	 */
	public final TableField<String> color = new TableFieldImpl<String>(this,"color","color","卡券的颜色");

	/**
	 * 卡券的单位 | varchar(8)
	 */
	public final TableField<String> unit = new TableFieldImpl<String>(this,"unit","unit","卡券的单位");

	/**
	 * 加息利率 | decimal(5,4)
	 */
	public final TableField<BigDecimal> interestAddRate = new TableFieldImpl<BigDecimal>(this,"interest_add_rate","interestAddRate","加息利率");

	/**
	 * 加息天数 | int(11)
	 */
	public final TableField<Integer> interestAddDay = new TableFieldImpl<Integer>(this,"interest_add_day","interestAddDay","加息天数");

	/**
	 * 卡券状态N:正常U:已使用E:已过期D:已回收行基本信息 | char(1)
	 */
	public final TableField<String> couponStatus = new TableFieldImpl<String>(this,"coupon_status","couponStatus","卡券状态N:正常U:已使用E:已过期D:已回收行基本信息");

	/**
	 * 过期时间 | date
	 */
	public final DateTableField<Date> expireDate = new DateTableFieldImpl<Date>(this,"expire_date","expireDate","过期时间");

	/**
	 * 卡券使用的时间 | datetime
	 */
	public final DateTableField<Date> useTime = new DateTableFieldImpl<Date>(this,"use_time","useTime","卡券使用的时间");

	/**
	 * 审核状态： W - 未审核，P - 通过，N - 不通过 | char(1)
	 */
	public final TableField<String> verifyStatus = new TableFieldImpl<String>(this,"verify_status","verifyStatus","审核状态： W - 未审核，P - 通过，N - 不通过");

	/**
	 * 更新的版本号 | bigint(19)
	 */
	public final TableField<Long> updVersion = new TableFieldImpl<Long>(this,"upd_version","updVersion","更新的版本号");

	/**
	 * 记录创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","记录创建时间");

	/**
	 * 记录修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","记录修改时间");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	private final TableField<?>[] allFields = new TableField<?>[] {couponId,reqNo,userId,templateId,title,description,type,fromUserId,activityId,sourceDescription,color,unit,interestAddRate,interestAddDay,couponStatus,expireDate,useTime,verifyStatus,updVersion,createTime,updateTime,lockVersion};

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
		return "TCouponInfo[table=coupon_info]";
	}
}
