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

public class TOpenUserInfo extends AbstractTable {

	static {
		init();
	}

	private TOpenUserInfo(){
		super.tableName = "open_user_info";
	}

	private TOpenUserInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TOpenUserInfo getInstance() {
		return new TOpenUserInfo();
	}

	public static final TOpenUserInfo getInstance(String aliasName) {
		return new TOpenUserInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("id", "id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("inviter", "inviter");
		allFieldMap.put("info", "info");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("pushrecved", "pushrecved");
		allFieldMap.put("rtncode", "rtncode");
		allFieldMap.put("openaccountacceptid", "openaccountacceptid");
		allFieldMap.put("openstatus", "openstatus");
		allFieldMap.put("openDate", "open_date");
		allFieldMap.put("clientId", "client_id");
		allFieldMap.put("isReward", "is_reward");
		allFieldMap.put("errCnt", "err_cnt");
		allFieldMap.put("isSend", "is_send");
		allFieldMap.put("openaccountaccessway", "openaccountaccessway");
		allFieldMap.put("email", "email");
		allFieldMap.put("idNo", "id_no");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 自增主键 | bigint(20)
	 */
	public final TableField<Long>  pk = new TableFieldImpl<Long>(this,"id","id","自增主键");
	public final TableField<Long> id = new TableFieldImpl<Long>(this,"id","id","自增主键");

	/**
	 *  | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","");

	/**
	 *  | bigint(20)
	 */
	public final TableField<Long> inviter = new TableFieldImpl<Long>(this,"inviter","inviter","");

	/**
	 * 用户ID | varchar(4000)
	 */
	public final TableField<String> info = new TableFieldImpl<String>(this,"info","info","用户ID");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","更新时间");

	/**
	 * 推送是否接收正常 | varchar(2)
	 */
	public final TableField<String> pushrecved = new TableFieldImpl<String>(this,"pushrecved","pushrecved","推送是否接收正常");

	/**
	 * 推送返回码 | varchar(2)
	 */
	public final TableField<String> rtncode = new TableFieldImpl<String>(this,"rtncode","rtncode","推送返回码");

	/**
	 * 开户返回账户ID | varchar(20)
	 */
	public final TableField<String> openaccountacceptid = new TableFieldImpl<String>(this,"openaccountacceptid","openaccountacceptid","开户返回账户ID");

	/**
	 * 0:开户成功，1:开户中，2:开户失败,3:基本资料错误，4:影像资料错误，5:基本资料和影像资料错误 | varchar(2)
	 */
	public final TableField<String> openstatus = new TableFieldImpl<String>(this,"openstatus","openstatus","0:开户成功，1:开户中，2:开户失败,3:基本资料错误，4:影像资料错误，5:基本资料和影像资料错误");

	/**
	 * 开户日期 | datetime
	 */
	public final DateTableField<Date> openDate = new DateTableFieldImpl<Date>(this,"open_date","openDate","开户日期");

	/**
	 * 客户号（交易帐号） | varchar(20)
	 */
	public final TableField<String> clientId = new TableFieldImpl<String>(this,"client_id","clientId","客户号（交易帐号）");

	/**
	 * 是否领取奖励 | tinyint(4)
	 */
	public final TableField<Integer> isReward = new TableFieldImpl<Integer>(this,"is_reward","isReward","是否领取奖励");

	/**
	 * 失败次数 | int(2)
	 */
	public final TableField<Integer> errCnt = new TableFieldImpl<Integer>(this,"err_cnt","errCnt","失败次数");

	/**
	 * 是否发送消息 | tinyint(4)
	 */
	public final TableField<Integer> isSend = new TableFieldImpl<Integer>(this,"is_send","isSend","是否发送消息");

	/**
	 * 1:H5开户 2:APP开户 | int(2)
	 */
	public final TableField<Integer> openaccountaccessway = new TableFieldImpl<Integer>(this,"openaccountaccessway","openaccountaccessway","1:H5开户 2:APP开户");

	/**
	 * 邮箱 | varchar(50)
	 */
	public final TableField<String> email = new TableFieldImpl<String>(this,"email","email","邮箱");

	/**
	 * 身份证号码 | varchar(20)
	 */
	public final TableField<String> idNo = new TableFieldImpl<String>(this,"id_no","idNo","身份证号码");

	private final TableField<?>[] allFields = new TableField<?>[] {id,userId,inviter,info,createTime,updateTime,pushrecved,rtncode,openaccountacceptid,openstatus,openDate,clientId,isReward,errCnt,isSend,openaccountaccessway,email,idNo};

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
		return "TOpenUserInfo[table=open_user_info]";
	}
}
