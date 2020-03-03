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

public class TOpenAccountSt extends AbstractTable {

	static {
		init();
	}

	private TOpenAccountSt(){
		super.tableName = "open_account_st";
	}

	private TOpenAccountSt(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TOpenAccountSt getInstance() {
		return new TOpenAccountSt();
	}

	public static final TOpenAccountSt getInstance(String aliasName) {
		return new TOpenAccountSt(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("idCardName", "id_card_name");
		allFieldMap.put("idCardSex", "id_card_sex");
		allFieldMap.put("idCardNation", "id_card_nation");
		allFieldMap.put("idCardDate", "id_card_date");
		allFieldMap.put("idCardAddress", "id_card_address");
		allFieldMap.put("idCardId", "id_card_id");
		allFieldMap.put("idCardAuthority", "id_card_authority");
		allFieldMap.put("idCardValidity", "id_card_validity");
		allFieldMap.put("bankCardNumber", "bank_card_number");
		allFieldMap.put("bankName", "bank_name");
		allFieldMap.put("bankCardId", "bank_card_id");
		allFieldMap.put("bankCardType", "bank_card_type");
		allFieldMap.put("bankCardName", "bank_card_name");
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
	 * 主键 | bigint(20)
	 */
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"id","id","主键");
	public final TableField<Long> id = new TableFieldImpl<Long>(this,"id","id","主键");

	/**
	 * 用户ID | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户ID");

	/**
	 * 姓名 | varchar(20)
	 */
	public final TableField<String> idCardName = new TableFieldImpl<String>(this,"id_card_name","idCardName","姓名");

	/**
	 * 性别 | varchar(20)
	 */
	public final TableField<String> idCardSex = new TableFieldImpl<String>(this,"id_card_sex","idCardSex","性别");

	/**
	 * 名族 | varchar(20)
	 */
	public final TableField<String> idCardNation = new TableFieldImpl<String>(this,"id_card_nation","idCardNation","名族");

	/**
	 * 出生日期 | varchar(20)
	 */
	public final TableField<String> idCardDate = new TableFieldImpl<String>(this,"id_card_date","idCardDate","出生日期");

	/**
	 * 住址 | varchar(100)
	 */
	public final TableField<String> idCardAddress = new TableFieldImpl<String>(this,"id_card_address","idCardAddress","住址");

	/**
	 * 公民身份证号 | varchar(20)
	 */
	public final TableField<String> idCardId = new TableFieldImpl<String>(this,"id_card_id","idCardId","公民身份证号");

	/**
	 * 签发机关 | varchar(20)
	 */
	public final TableField<String> idCardAuthority = new TableFieldImpl<String>(this,"id_card_authority","idCardAuthority","签发机关");

	/**
	 * 有效期 | varchar(40)
	 */
	public final TableField<String> idCardValidity = new TableFieldImpl<String>(this,"id_card_validity","idCardValidity","有效期");

	/**
	 * 银行卡号 | varchar(20)
	 */
	public final TableField<String> bankCardNumber = new TableFieldImpl<String>(this,"bank_card_number","bankCardNumber","银行卡号");

	/**
	 * 发卡行名称 | varchar(20)
	 */
	public final TableField<String> bankName = new TableFieldImpl<String>(this,"bank_name","bankName","发卡行名称");

	/**
	 * 发卡行标识代码 | varchar(20)
	 */
	public final TableField<String> bankCardId = new TableFieldImpl<String>(this,"bank_card_id","bankCardId","发卡行标识代码");

	/**
	 * 卡片类型 | varchar(10)
	 */
	public final TableField<String> bankCardType = new TableFieldImpl<String>(this,"bank_card_type","bankCardType","卡片类型");

	/**
	 * 卡片名称 | varchar(100)
	 */
	public final TableField<String> bankCardName = new TableFieldImpl<String>(this,"bank_card_name","bankCardName","卡片名称");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","修改时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {id,userId,idCardName,idCardSex,idCardNation,idCardDate,idCardAddress,idCardId,idCardAuthority,idCardValidity,bankCardNumber,bankName,bankCardId,bankCardType,bankCardName,createTime,updateTime};

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
		return "TOpenAccountSt[table=open_account_st]";
	}
}
