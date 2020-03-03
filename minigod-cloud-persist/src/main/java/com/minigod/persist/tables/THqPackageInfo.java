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

public class THqPackageInfo extends AbstractTable {

	static {
		init();
	}

	private THqPackageInfo(){
		super.tableName = "hq_package_info";
	}

	private THqPackageInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final THqPackageInfo getInstance() {
		return new THqPackageInfo();
	}

	public static final THqPackageInfo getInstance(String aliasName) {
		return new THqPackageInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("packageId", "package_id");
		allFieldMap.put("packageName", "package_name");
		allFieldMap.put("packageCode", "package_code");
		allFieldMap.put("packageDesc", "package_desc");
		allFieldMap.put("picUrl", "pic_url");
		allFieldMap.put("oldPrice", "old_price");
		allFieldMap.put("newPrice", "new_price");
		allFieldMap.put("ccyType", "ccy_type");
		allFieldMap.put("totalNum", "total_num");
		allFieldMap.put("restNum", "rest_num");
		allFieldMap.put("expiryDate", "expiry_date");
		allFieldMap.put("createUser", "create_user");
		allFieldMap.put("updateUser", "update_user");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("discount", "discount");
		allFieldMap.put("marketId", "market_id");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 *  | bigint(20)
	 */
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"package_id","packageId","");
	public final TableField<Long> packageId = new TableFieldImpl<Long>(this,"package_id","packageId","");

	/**
	 * 套餐名称 | varchar(60)
	 */
	public final TableField<String> packageName = new TableFieldImpl<String>(this,"package_name","packageName","套餐名称");

	/**
	 *  | varchar(20)
	 */
	public final TableField<String> packageCode = new TableFieldImpl<String>(this,"package_code","packageCode","");

	/**
	 * 描述 | varchar(255)
	 */
	public final TableField<String> packageDesc = new TableFieldImpl<String>(this,"package_desc","packageDesc","描述");

	/**
	 * 图片地址 | varchar(60)
	 */
	public final TableField<String> picUrl = new TableFieldImpl<String>(this,"pic_url","picUrl","图片地址");

	/**
	 * 原价格 | decimal(12,4)
	 */
	public final TableField<Double> oldPrice = new TableFieldImpl<Double>(this,"old_price","oldPrice","原价格");

	/**
	 * 最新价格 | decimal(12,4)
	 */
	public final TableField<Double> newPrice = new TableFieldImpl<Double>(this,"new_price","newPrice","最新价格");

	/**
	 * CNY-人民币，USD-美元，HKD-港币 | char(3)
	 */
	public final TableField<String> ccyType = new TableFieldImpl<String>(this,"ccy_type","ccyType","CNY-人民币，USD-美元，HKD-港币");

	/**
	 * 套餐总数 | int(11)
	 */
	public final TableField<Integer> totalNum = new TableFieldImpl<Integer>(this,"total_num","totalNum","套餐总数");

	/**
	 * 剩余数量 | int(11)
	 */
	public final TableField<Integer> restNum = new TableFieldImpl<Integer>(this,"rest_num","restNum","剩余数量");

	/**
	 * 截至日期 | datetime
	 */
	public final DateTableField<Date> expiryDate = new DateTableFieldImpl<Date>(this,"expiry_date","expiryDate","截至日期");

	/**
	 *  | bigint(20)
	 */
	public final TableField<Long> createUser = new TableFieldImpl<Long>(this,"create_user","createUser","");

	/**
	 *  | bigint(20)
	 */
	public final TableField<Long> updateUser = new TableFieldImpl<Long>(this,"update_user","updateUser","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","");

	/**
	 * 0-无效，1-有效 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","0-无效，1-有效");

	/**
	 * 优惠率 | decimal(8,2)
	 */
	public final TableField<Double> discount = new TableFieldImpl<Double>(this,"discount","discount","优惠率");

	/**
	 *  | bigint(20)
	 */
	public final TableField<Long> marketId = new TableFieldImpl<Long>(this,"market_id","marketId","");

	private final TableField<?>[] allFields = new TableField<?>[] {packageId,packageName,packageCode,packageDesc,picUrl,oldPrice,newPrice,ccyType,totalNum,restNum,expiryDate,createUser,updateUser,createTime,updateTime,isStatus,discount,marketId};

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
		return "THqPackageInfo[table=hq_package_info]";
	}
}
