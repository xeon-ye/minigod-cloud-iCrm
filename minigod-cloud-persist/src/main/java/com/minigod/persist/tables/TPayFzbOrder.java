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

public class TPayFzbOrder extends AbstractTable {

	static {
		init();
	}

	private TPayFzbOrder(){
		super.tableName = "pay_fzb_order";
	}

	private TPayFzbOrder(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPayFzbOrder getInstance() {
		return new TPayFzbOrder();
	}

	public static final TPayFzbOrder getInstance(String aliasName) {
		return new TPayFzbOrder(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("fzbOrderId", "fzb_order_id");
		allFieldMap.put("srcSys", "src_sys");
		allFieldMap.put("srcBus", "src_bus");
		allFieldMap.put("srcTransId", "src_trans_id");
		allFieldMap.put("accountId", "account_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("feeType", "fee_type");
		allFieldMap.put("totalFee", "total_fee");
		allFieldMap.put("frzAmt", "frz_amt");
		allFieldMap.put("refundAmt", "refund_amt");
		allFieldMap.put("display", "display");
		allFieldMap.put("incomeOrExpense", "income_or_expense");
		allFieldMap.put("des", "des");
		allFieldMap.put("transactionId", "transaction_id");
		allFieldMap.put("detail", "detail");
		allFieldMap.put("finishStatus", "finish_status");
		allFieldMap.put("actStatus", "act_status");
		allFieldMap.put("payStatus", "pay_status");
		allFieldMap.put("cbStatus", "cb_status");
		allFieldMap.put("cbErrMsg", "cb_err_msg");
		allFieldMap.put("remark", "remark");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("lockVersion", "lock_version");
		allFieldMap.put("md5", "md5");
		allFieldMap.put("billCreateIp", "bill_create_ip");
		allFieldMap.put("timeStart", "time_start");
		allFieldMap.put("timeExpire", "time_expire");
		allFieldMap.put("tradeType", "trade_type");
		allFieldMap.put("cbMethod", "cb_method");
		allFieldMap.put("cbAttach", "cb_attach");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 富尊币支付订单ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"fzb_order_id","fzbOrderId","富尊币支付订单ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","富尊币支付订单ID");

	public final TableField<Integer> fzbOrderId = new TableFieldImpl<Integer>(this,"fzb_order_id","fzbOrderId","富尊币支付订单ID");

	/**
	 * 请求来源系统 | char(3)
	 */
	public final TableField<String> srcSys = new TableFieldImpl<String>(this,"src_sys","srcSys","请求来源系统");

	/**
	 * 请求来源业务 | char(6)
	 */
	public final TableField<String> srcBus = new TableFieldImpl<String>(this,"src_bus","srcBus","请求来源业务");

	/**
	 * 客户端交易ID | varchar(23)
	 */
	public final TableField<String> srcTransId = new TableFieldImpl<String>(this,"src_trans_id","srcTransId","客户端交易ID");

	/**
	 * 账户表ID | int(11)
	 */
	public final TableField<Integer> accountId = new TableFieldImpl<Integer>(this,"account_id","accountId","账户表ID");

	/**
	 * 用户id | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户id");

	/**
	 * 货币类型 | char(3)
	 */
	public final TableField<String> feeType = new TableFieldImpl<String>(this,"fee_type","feeType","货币类型");

	/**
	 * 支付金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> totalFee = new TableFieldImpl<BigDecimal>(this,"total_fee","totalFee","支付金额");

	/**
	 * 冻结的金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> frzAmt = new TableFieldImpl<BigDecimal>(this,"frz_amt","frzAmt","冻结的金额");

	/**
	 * 已申请退款金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> refundAmt = new TableFieldImpl<BigDecimal>(this,"refund_amt","refundAmt","已申请退款金额");

	/**
	 * 是否在钱包中显示 | char(1)
	 */
	public final TableField<String> display = new TableFieldImpl<String>(this,"display","display","是否在钱包中显示");

	/**
	 * 是否为收支项 | char(1)
	 */
	public final TableField<String> incomeOrExpense = new TableFieldImpl<String>(this,"income_or_expense","incomeOrExpense","是否为收支项");

	/**
	 * 订单描述 | varchar(32)
	 */
	public final TableField<String> des = new TableFieldImpl<String>(this,"des","des","订单描述");

	/**
	 * 支付对应的交易请求表ID | int(11)
	 */
	public final TableField<Integer> transactionId = new TableFieldImpl<Integer>(this,"transaction_id","transactionId","支付对应的交易请求表ID");

	/**
	 * 订单详细描述 | varchar(1024)
	 */
	public final TableField<String> detail = new TableFieldImpl<String>(this,"detail","detail","订单详细描述");

	/**
	 * 订单结束状态 | char(1)
	 */
	public final TableField<String> finishStatus = new TableFieldImpl<String>(this,"finish_status","finishStatus","订单结束状态");

	/**
	 * 是否已记账 | char(1)
	 */
	public final TableField<String> actStatus = new TableFieldImpl<String>(this,"act_status","actStatus","是否已记账");

	/**
	 * 订单状态 | char(1)
	 */
	public final TableField<String> payStatus = new TableFieldImpl<String>(this,"pay_status","payStatus","订单状态");

	/**
	 * 回调状态 | char(1)
	 */
	public final TableField<String> cbStatus = new TableFieldImpl<String>(this,"cb_status","cbStatus","回调状态");

	/**
	 * 回调的错误信息 | varchar(1024)
	 */
	public final TableField<String> cbErrMsg = new TableFieldImpl<String>(this,"cb_err_msg","cbErrMsg","回调的错误信息");

	/**
	 * 备注 | varchar(128)
	 */
	public final TableField<String> remark = new TableFieldImpl<String>(this,"remark","remark","备注");

	/**
	 * 记录状态 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态");

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

	/**
	 *  | char(32)
	 */
	public final TableField<String> md5 = new TableFieldImpl<String>(this,"md5","md5","");

	/**
	 *  | varchar(16)
	 */
	public final TableField<String> billCreateIp = new TableFieldImpl<String>(this,"bill_create_ip","billCreateIp","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> timeStart = new DateTableFieldImpl<Date>(this,"time_start","timeStart","");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> timeExpire = new DateTableFieldImpl<Date>(this,"time_expire","timeExpire","");

	/**
	 *  | varchar(16)
	 */
	public final TableField<String> tradeType = new TableFieldImpl<String>(this,"trade_type","tradeType","");

	/**
	 *  | varchar(50)
	 */
	public final TableField<String> cbMethod = new TableFieldImpl<String>(this,"cb_method","cbMethod","");

	/**
	 *  | varchar(1024)
	 */
	public final TableField<String> cbAttach = new TableFieldImpl<String>(this,"cb_attach","cbAttach","");

	private final TableField<?>[] allFields = new TableField<?>[] {fzbOrderId,srcSys,srcBus,srcTransId,accountId,userId,feeType,totalFee,frzAmt,refundAmt,display,incomeOrExpense,des,transactionId,detail,finishStatus,actStatus,payStatus,cbStatus,cbErrMsg,remark,isStatus,createTime,updateTime,lockVersion,md5,billCreateIp,timeStart,timeExpire,tradeType,cbMethod,cbAttach};

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
		return "TPayFzbOrder[table=pay_fzb_order]";
	}
}
