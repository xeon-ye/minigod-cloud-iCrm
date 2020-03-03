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

public class TUserBroker extends AbstractTable {

	static {
		init();
	}

	private TUserBroker(){
		super.tableName = "user_broker";
	}

	private TUserBroker(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TUserBroker getInstance() {
		return new TUserBroker();
	}

	public static final TUserBroker getInstance(String aliasName) {
		return new TUserBroker(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("userBrokerId", "user_broker_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("brokerId", "broker_id");
		allFieldMap.put("brkCustid", "brk_custid");
		allFieldMap.put("custName", "cust_name");
		allFieldMap.put("isCurrent", "is_current");
		allFieldMap.put("tradeNode", "trade_node");
		allFieldMap.put("branchNo", "branch_no");
		allFieldMap.put("depositAcc", "deposit_acc");
		allFieldMap.put("ext", "ext");
		allFieldMap.put("syncInterval", "sync_interval");
		allFieldMap.put("syncBeginTime", "sync_begin_time");
		allFieldMap.put("firstLogin", "first_login");
		allFieldMap.put("lastLogin", "last_login");
		allFieldMap.put("loginCount", "login_count");
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
	 * 用户使用券商ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"user_broker_id","userBrokerId","用户使用券商ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","用户使用券商ID");

	public final TableField<Integer> userBrokerId = new TableFieldImpl<Integer>(this,"user_broker_id","userBrokerId","用户使用券商ID");

	/**
	 * 用户id | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户id");

	/**
	 * 券商id | int(11)
	 */
	public final TableField<Integer> brokerId = new TableFieldImpl<Integer>(this,"broker_id","brokerId","券商id");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> brkCustid = new TableFieldImpl<String>(this,"brk_custid","brkCustid","");

	/**
	 *  | varchar(80)
	 */
	public final TableField<String> custName = new TableFieldImpl<String>(this,"cust_name","custName","");

	/**
	 * 当前是否使用 | tinyint(1)
	 */
	public final TableField<Boolean> isCurrent = new TableFieldImpl<Boolean>(this,"is_current","isCurrent","当前是否使用");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> tradeNode = new TableFieldImpl<String>(this,"trade_node","tradeNode","");

	/**
	 *  | varchar(30)
	 */
	public final TableField<String> branchNo = new TableFieldImpl<String>(this,"branch_no","branchNo","");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> depositAcc = new TableFieldImpl<String>(this,"deposit_acc","depositAcc","");

	/**
	 *  | varchar(200)
	 */
	public final TableField<String> ext = new TableFieldImpl<String>(this,"ext","ext","");

	/**
	 * 上次同步间隔 | int(11)
	 */
	public final TableField<Integer> syncInterval = new TableFieldImpl<Integer>(this,"sync_interval","syncInterval","上次同步间隔");

	/**
	 * 下次同步开始时间 | datetime
	 */
	public final DateTableField<Date> syncBeginTime = new DateTableFieldImpl<Date>(this,"sync_begin_time","syncBeginTime","下次同步开始时间");

	/**
	 * 第一次登陆时间 | datetime
	 */
	public final DateTableField<Date> firstLogin = new DateTableFieldImpl<Date>(this,"first_login","firstLogin","第一次登陆时间");

	/**
	 * 最后一次登录时间 | datetime
	 */
	public final DateTableField<Date> lastLogin = new DateTableFieldImpl<Date>(this,"last_login","lastLogin","最后一次登录时间");

	/**
	 * 登录次数 | int(11)
	 */
	public final TableField<Integer> loginCount = new TableFieldImpl<Integer>(this,"login_count","loginCount","登录次数");

	/**
	 * 记录创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","记录创建时间");

	/**
	 * 记录更新时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","记录更新时间");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	private final TableField<?>[] allFields = new TableField<?>[] {userBrokerId,userId,brokerId,brkCustid,custName,isCurrent,tradeNode,branchNo,depositAcc,ext,syncInterval,syncBeginTime,firstLogin,lastLogin,loginCount,createTime,updateTime,lockVersion};

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
		return "TUserBroker[table=user_broker]";
	}
}
