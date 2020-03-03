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

public class TPayXfOrder extends AbstractTable {

	static {
		init();
	}

	private TPayXfOrder(){
		super.tableName = "pay_xf_order";
	}

	private TPayXfOrder(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPayXfOrder getInstance() {
		return new TPayXfOrder();
	}

	public static final TPayXfOrder getInstance(String aliasName) {
		return new TPayXfOrder(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("xfOrderId", "xf_order_id");
		allFieldMap.put("srcSys", "src_sys");
		allFieldMap.put("srcBus", "src_bus");
		allFieldMap.put("srcTransId", "src_trans_id");
		allFieldMap.put("md5", "md5");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("totalFee", "total_fee");
		allFieldMap.put("description", "description");
		allFieldMap.put("finishStatus", "finish_status");
		allFieldMap.put("payStatus", "pay_status");
		allFieldMap.put("cbStatus", "cb_status");
		allFieldMap.put("xfTradeNo", "xf_trade_no");
		allFieldMap.put("callbackTime", "callback_time");
		allFieldMap.put("bankCardNo", "bank_card_no");
		allFieldMap.put("bankId", "bank_id");
		allFieldMap.put("bankName", "bank_name");
		allFieldMap.put("xfOrderStatus", "xf_order_status");
		allFieldMap.put("xfPayTime", "xf_pay_time");
		allFieldMap.put("xfCbRespId", "xf_cb_resp_id");
		allFieldMap.put("xfCbMd5", "xf_cb_md5");
		allFieldMap.put("authStatus", "auth_status");
		allFieldMap.put("checkCount", "check_count");
		allFieldMap.put("checkTime", "check_time");
		allFieldMap.put("cbMethod", "cb_method");
		allFieldMap.put("cbErrMsg", "cb_err_msg");
		allFieldMap.put("remark", "remark");
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
	 * 先锋支付订单ID,主键，自增长 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"xf_order_id","xfOrderId","先锋支付订单ID,主键，自增长");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","先锋支付订单ID,主键，自增长");

	public final TableField<Integer> xfOrderId = new TableFieldImpl<Integer>(this,"xf_order_id","xfOrderId","先锋支付订单ID,主键，自增长");

	/**
	 * 请求来源系统,齐牛内部业务系统登记到账务系统的代号如:OMS | char(3)
	 */
	public final TableField<String> srcSys = new TableFieldImpl<String>(this,"src_sys","srcSys","请求来源系统,齐牛内部业务系统登记到账务系统的代号如:OMS");

	/**
	 * 请求来源业务,齐牛内部业务系统功能登记到账务系统的代号 | char(6)
	 */
	public final TableField<String> srcBus = new TableFieldImpl<String>(this,"src_bus","srcBus","请求来源业务,齐牛内部业务系统功能登记到账务系统的代号");

	/**
	 * 客户端交易ID,调用者传入的业务内不重复的字符串 | varchar(23)
	 */
	public final TableField<String> srcTransId = new TableFieldImpl<String>(this,"src_trans_id","srcTransId","客户端交易ID,调用者传入的业务内不重复的字符串");

	/**
	 * 请求数据摘要,用于判断同一业务具有相同客户端交易ID的请求是否相等。 | char(32)
	 */
	public final TableField<String> md5 = new TableFieldImpl<String>(this,"md5","md5","请求数据摘要,用于判断同一业务具有相同客户端交易ID的请求是否相等。");

	/**
	 * 关联的齐牛账户号 | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","关联的齐牛账户号");

	/**
	 * ,支付金额,我们定义的最小额度为厘,后一位小数，微信支付最小的支付额度为分。 | decimal(16,2)
	 */
	public final TableField<BigDecimal> totalFee = new TableFieldImpl<BigDecimal>(this,"total_fee","totalFee",",支付金额,我们定义的最小额度为厘,后一位小数，微信支付最小的支付额度为分。");

	/**
	 * 订单描述,商品或者支付的简要描述 | varchar(32)
	 */
	public final TableField<String> description = new TableFieldImpl<String>(this,"description","description","订单描述,商品或者支付的简要描述");

	/**
	 * 订单结束状态Y:结束N:未结束E：异常(异常数据不进行后续处理，等待人工干预) | char(1)
	 */
	public final TableField<String> finishStatus = new TableFieldImpl<String>(this,"finish_status","finishStatus","订单结束状态Y:结束N:未结束E：异常(异常数据不进行后续处理，等待人工干预)");

	/**
	 * 订单状态U:订单等待创建F:订单创建失败W:等待付款S:已付款 | char(1)
	 */
	public final TableField<String> payStatus = new TableFieldImpl<String>(this,"pay_status","payStatus","订单状态U:订单等待创建F:订单创建失败W:等待付款S:已付款");

	/**
	 * 回调状态A:等待支付W:等待回调S:回调成功会有单独的线程扫描本表中回调状态为W的记录，并进行回调操作。 | char(1)
	 */
	public final TableField<String> cbStatus = new TableFieldImpl<String>(this,"cb_status","cbStatus","回调状态A:等待支付W:等待回调S:回调成功会有单独的线程扫描本表中回调状态为W的记录，并进行回调操作。");

	/**
	 * 先锋交易流水号,创建订单时返回 | varchar(32)
	 */
	public final TableField<String> xfTradeNo = new TableFieldImpl<String>(this,"xf_trade_no","xfTradeNo","先锋交易流水号,创建订单时返回");

	/**
	 * 回调接收的时间 | datetime
	 */
	public final DateTableField<Date> callbackTime = new DateTableFieldImpl<Date>(this,"callback_time","callbackTime","回调接收的时间");

	/**
	 * 用户绑定卡号 | varchar(25)
	 */
	public final TableField<String> bankCardNo = new TableFieldImpl<String>(this,"bank_card_no","bankCardNo","用户绑定卡号");

	/**
	 * 绑定银行 | varchar(10)
	 */
	public final TableField<String> bankId = new TableFieldImpl<String>(this,"bank_id","bankId","绑定银行");

	/**
	 * 银行名称 | varchar(64)
	 */
	public final TableField<String> bankName = new TableFieldImpl<String>(this,"bank_name","bankName","银行名称");

	/**
	 * 远程支付状态,等待支付W,成功S,失败E | char(1)
	 */
	public final TableField<String> xfOrderStatus = new TableFieldImpl<String>(this,"xf_order_status","xfOrderStatus","远程支付状态,等待支付W,成功S,失败E");

	/**
	 * 先锋支付时间 | datetime
	 */
	public final DateTableField<Date> xfPayTime = new DateTableFieldImpl<Date>(this,"xf_pay_time","xfPayTime","先锋支付时间");

	/**
	 * 先锋回调的传入参数 | int(11)
	 */
	public final TableField<Integer> xfCbRespId = new TableFieldImpl<Integer>(this,"xf_cb_resp_id","xfCbRespId","先锋回调的传入参数");

	/**
	 * 先锋回调数据摘要 | varchar(32)
	 */
	public final TableField<String> xfCbMd5 = new TableFieldImpl<String>(this,"xf_cb_md5","xfCbMd5","先锋回调数据摘要");

	/**
	 * 认证绑卡结果“00”成功，其他失败 | char(2)
	 */
	public final TableField<String> authStatus = new TableFieldImpl<String>(this,"auth_status","authStatus","认证绑卡结果“00”成功，其他失败");

	/**
	 * 已检测支付次数 | int(11)
	 */
	public final TableField<Integer> checkCount = new TableFieldImpl<Integer>(this,"check_count","checkCount","已检测支付次数");

	/**
	 * 检测的时间 | datetime
	 */
	public final DateTableField<Date> checkTime = new DateTableFieldImpl<Date>(this,"check_time","checkTime","检测的时间");

	/**
	 * 回调的方法识别标志当回调状态为P/W/S时，必须有值 | varchar(50)
	 */
	public final TableField<String> cbMethod = new TableFieldImpl<String>(this,"cb_method","cbMethod","回调的方法识别标志当回调状态为P/W/S时，必须有值");

	/**
	 * 回调的错误信息 | varchar(1024)
	 */
	public final TableField<String> cbErrMsg = new TableFieldImpl<String>(this,"cb_err_msg","cbErrMsg","回调的错误信息");

	/**
	 * 备注信息 | varchar(128)
	 */
	public final TableField<String> remark = new TableFieldImpl<String>(this,"remark","remark","备注信息");

	/**
	 * 记录状态1-有效，0-无效（删除） | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态1-有效，0-无效（删除）");

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

	private final TableField<?>[] allFields = new TableField<?>[] {xfOrderId,srcSys,srcBus,srcTransId,md5,userId,totalFee,description,finishStatus,payStatus,cbStatus,xfTradeNo,callbackTime,bankCardNo,bankId,bankName,xfOrderStatus,xfPayTime,xfCbRespId,xfCbMd5,authStatus,checkCount,checkTime,cbMethod,cbErrMsg,remark,isStatus,createTime,updateTime,lockVersion};

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
		return "TPayXfOrder[table=pay_xf_order]";
	}
}
