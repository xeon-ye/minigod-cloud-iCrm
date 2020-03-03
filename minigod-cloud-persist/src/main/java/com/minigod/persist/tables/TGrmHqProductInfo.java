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

public class TGrmHqProductInfo extends AbstractTable {

	static {
		init();
	}

	private TGrmHqProductInfo(){
		super.tableName = "grm_hq_product_info";
	}

	private TGrmHqProductInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TGrmHqProductInfo getInstance() {
		return new TGrmHqProductInfo();
	}

	public static final TGrmHqProductInfo getInstance(String aliasName) {
		return new TGrmHqProductInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("productId", "product_id");
		allFieldMap.put("productName", "product_name");
		allFieldMap.put("productDesc", "product_desc");
		allFieldMap.put("productPicUrl", "product_pic_url");
		allFieldMap.put("originalPrice", "original_price");
		allFieldMap.put("price", "price");
		allFieldMap.put("moneyType", "money_type");
		allFieldMap.put("totalQuantity", "total_quantity");
		allFieldMap.put("remainingQuantity", "remaining_quantity");
		allFieldMap.put("addDate", "add_date");
		allFieldMap.put("addOperator", "add_operator");
		allFieldMap.put("modifyDate", "modify_date");
		allFieldMap.put("modifyOperator", "modify_operator");
		allFieldMap.put("expiryDate", "expiry_date");
		allFieldMap.put("deleteDate", "delete_date");
		allFieldMap.put("deleteOperator", "delete_operator");
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
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"id","id","");
	public final TableField<Integer> id = new TableFieldImpl<Integer>(this,"id","id","");

	/**
	 * 产品唯一编码 | varchar(32)
	 */
	public final TableField<String> productId = new TableFieldImpl<String>(this,"product_id","productId","产品唯一编码");

	/**
	 * 产品名称 | varchar(32)
	 */
	public final TableField<String> productName = new TableFieldImpl<String>(this,"product_name","productName","产品名称");

	/**
	 * 产品描述 | varchar(256)
	 */
	public final TableField<String> productDesc = new TableFieldImpl<String>(this,"product_desc","productDesc","产品描述");

	/**
	 * 产品图片 | varchar(128)
	 */
	public final TableField<String> productPicUrl = new TableFieldImpl<String>(this,"product_pic_url","productPicUrl","产品图片");

	/**
	 * 原始价格 | double
	 */
	public final TableField<Double> originalPrice = new TableFieldImpl<Double>(this,"original_price","originalPrice","原始价格");

	/**
	 * 产品价格 | double
	 */
	public final TableField<Double> price = new TableFieldImpl<Double>(this,"price","price","产品价格");

	/**
	 * 计价币种 | int(11)
	 */
	public final TableField<Integer> moneyType = new TableFieldImpl<Integer>(this,"money_type","moneyType","计价币种");

	/**
	 * 产品总数 | mediumtext
	 */
	public final TableField<String> totalQuantity = new TableFieldImpl<String>(this,"total_quantity","totalQuantity","产品总数");

	/**
	 * 剩余数量 | mediumtext
	 */
	public final TableField<String> remainingQuantity = new TableFieldImpl<String>(this,"remaining_quantity","remainingQuantity","剩余数量");

	/**
	 * 添加日期 | datetime
	 */
	public final DateTableField<Date> addDate = new DateTableFieldImpl<Date>(this,"add_date","addDate","添加日期");

	/**
	 * 添加操作员 | varchar(128)
	 */
	public final TableField<String> addOperator = new TableFieldImpl<String>(this,"add_operator","addOperator","添加操作员");

	/**
	 * 最近一次修改日期 | datetime
	 */
	public final DateTableField<Date> modifyDate = new DateTableFieldImpl<Date>(this,"modify_date","modifyDate","最近一次修改日期");

	/**
	 * 最近一次修改操作员 | varchar(128)
	 */
	public final TableField<String> modifyOperator = new TableFieldImpl<String>(this,"modify_operator","modifyOperator","最近一次修改操作员");

	/**
	 * 截至时间 | datetime
	 */
	public final DateTableField<Date> expiryDate = new DateTableFieldImpl<Date>(this,"expiry_date","expiryDate","截至时间");

	/**
	 * 删除日期 | datetime
	 */
	public final DateTableField<Date> deleteDate = new DateTableFieldImpl<Date>(this,"delete_date","deleteDate","删除日期");

	/**
	 * 删除产品的操作员 | varchar(128)
	 */
	public final TableField<String> deleteOperator = new TableFieldImpl<String>(this,"delete_operator","deleteOperator","删除产品的操作员");

	private final TableField<?>[] allFields = new TableField<?>[] {id,productId,productName,productDesc,productPicUrl,originalPrice,price,moneyType,totalQuantity,remainingQuantity,addDate,addOperator,modifyDate,modifyOperator,expiryDate,deleteDate,deleteOperator};

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
		return "TGrmHqProductInfo[table=grm_hq_product_info]";
	}
}
