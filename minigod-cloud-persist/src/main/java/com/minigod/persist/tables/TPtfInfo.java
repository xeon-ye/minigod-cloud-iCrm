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

public class TPtfInfo extends AbstractTable {

	static {
		init();
	}

	private TPtfInfo(){
		super.tableName = "ptf_info";
	}

	private TPtfInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPtfInfo getInstance() {
		return new TPtfInfo();
	}

	public static final TPtfInfo getInstance(String aliasName) {
		return new TPtfInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("ptfVersion", "ptf_version");
		allFieldMap.put("name", "name");
		allFieldMap.put("description", "description");
		allFieldMap.put("bchType", "bch_type");
		allFieldMap.put("bchId", "bch_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("authQry", "auth_qry");
		allFieldMap.put("authShare", "auth_share");
		allFieldMap.put("idxTime", "idx_time");
		allFieldMap.put("ptfIndex", "ptf_index");
		allFieldMap.put("volatility", "volatility");
		allFieldMap.put("isReal", "is_real");
		allFieldMap.put("isRealCfm", "is_real_cfm");
		allFieldMap.put("realTime", "real_time");
		allFieldMap.put("realBrokerId", "real_broker_id");
		allFieldMap.put("realBrkCustid", "real_brk_custid");
		allFieldMap.put("lastTransTime", "last_trans_time");
		allFieldMap.put("saleFlag", "sale_flag");
		allFieldMap.put("price", "price");
		allFieldMap.put("salesPrice", "sales_price");
		allFieldMap.put("vipPrice", "vip_price");
		allFieldMap.put("targetYield", "target_yield");
		allFieldMap.put("isStatus", "is_status");
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
	 * 组合id | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合id");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","组合id");

	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合id");

	/**
	 * 组合版本 | int(11)
	 */
	public final TableField<Integer> ptfVersion = new TableFieldImpl<Integer>(this,"ptf_version","ptfVersion","组合版本");

	/**
	 *  | varchar(90)
	 */
	public final TableField<String> name = new TableFieldImpl<String>(this,"name","name","");

	/**
	 *  | varchar(450)
	 */
	public final TableField<String> description = new TableFieldImpl<String>(this,"description","description","");

	/**
	 * 业绩基准类型 | tinyint(4)
	 */
	public final TableField<Integer> bchType = new TableFieldImpl<Integer>(this,"bch_type","bchType","业绩基准类型");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> bchId = new TableFieldImpl<String>(this,"bch_id","bchId","");

	/**
	 * 创建用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","创建用户ID");

	/**
	 * 查询权限。0私密；1部分好友；2所有好友 | tinyint(4)
	 */
	public final TableField<Integer> authQry = new TableFieldImpl<Integer>(this,"auth_qry","authQry","查询权限。0私密；1部分好友；2所有好友");

	/**
	 * 分享权限 | char(1)
	 */
	public final TableField<String> authShare = new TableFieldImpl<String>(this,"auth_share","authShare","分享权限");

	/**
	 * 指数时间 | datetime
	 */
	public final DateTableField<Date> idxTime = new DateTableFieldImpl<Date>(this,"idx_time","idxTime","指数时间");

	/**
	 * 指数 | decimal(10,4)
	 */
	public final TableField<Double> ptfIndex = new TableFieldImpl<Double>(this,"ptf_index","ptfIndex","指数");

	/**
	 * 组合波动率 | decimal(10,4)
	 */
	public final TableField<Double> volatility = new TableFieldImpl<Double>(this,"volatility","volatility","组合波动率");

	/**
	 * 是否实盘 | tinyint(1)
	 */
	public final TableField<Boolean> isReal = new TableFieldImpl<Boolean>(this,"is_real","isReal","是否实盘");

	/**
	 * 实盘是否成交 | tinyint(1)
	 */
	public final TableField<Boolean> isRealCfm = new TableFieldImpl<Boolean>(this,"is_real_cfm","isRealCfm","实盘是否成交");

	/**
	 * 实盘时间 | datetime
	 */
	public final DateTableField<Date> realTime = new DateTableFieldImpl<Date>(this,"real_time","realTime","实盘时间");

	/**
	 * 实盘券商ID | int(11)
	 */
	public final TableField<Integer> realBrokerId = new TableFieldImpl<Integer>(this,"real_broker_id","realBrokerId","实盘券商ID");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> realBrkCustid = new TableFieldImpl<String>(this,"real_brk_custid","realBrkCustid","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> lastTransTime = new DateTableFieldImpl<Date>(this,"last_trans_time","lastTransTime","");

	/**
	 * 是否付费可见 | char(1)
	 */
	public final TableField<String> saleFlag = new TableFieldImpl<String>(this,"sale_flag","saleFlag","是否付费可见");

	/**
	 * 组合收费单月费用 | decimal(16,2)
	 */
	public final TableField<BigDecimal> price = new TableFieldImpl<BigDecimal>(this,"price","price","组合收费单月费用");

	/**
	 * 优惠价格 | decimal(16,2)
	 */
	public final TableField<BigDecimal> salesPrice = new TableFieldImpl<BigDecimal>(this,"sales_price","salesPrice","优惠价格");

	/**
	 * vip价格 | decimal(16,2)
	 */
	public final TableField<BigDecimal> vipPrice = new TableFieldImpl<BigDecimal>(this,"vip_price","vipPrice","vip价格");

	/**
	 * 组合收费目标收益率 | decimal(10,4)
	 */
	public final TableField<BigDecimal> targetYield = new TableFieldImpl<BigDecimal>(this,"target_yield","targetYield","组合收费目标收益率");

	/**
	 * 记录是否有效 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录是否有效");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","更新时间");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	private final TableField<?>[] allFields = new TableField<?>[] {ptfId,ptfVersion,name,description,bchType,bchId,userId,authQry,authShare,idxTime,ptfIndex,volatility,isReal,isRealCfm,realTime,realBrokerId,realBrkCustid,lastTransTime,saleFlag,price,salesPrice,vipPrice,targetYield,isStatus,createTime,updateTime,lockVersion};

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
		return "TPtfInfo[table=ptf_info]";
	}
}
