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

public class TPayXfTransfer extends AbstractTable {

	static {
		init();
	}

	private TPayXfTransfer(){
		super.tableName = "pay_xf_transfer";
	}

	private TPayXfTransfer(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPayXfTransfer getInstance() {
		return new TPayXfTransfer();
	}

	public static final TPayXfTransfer getInstance(String aliasName) {
		return new TPayXfTransfer(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("xfTransferId", "xf_transfer_id");
		allFieldMap.put("srcSys", "src_sys");
		allFieldMap.put("srcBus", "src_bus");
		allFieldMap.put("srcTransId", "src_trans_id");
		allFieldMap.put("md5", "md5");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("amount", "amount");
		allFieldMap.put("sendStatus", "send_status");
		allFieldMap.put("xfTradeNo", "xf_trade_no");
		allFieldMap.put("tradeTime", "trade_time");
		allFieldMap.put("callbackTime", "callback_time");
		allFieldMap.put("remoteStatus", "remote_status");
		allFieldMap.put("xfErrMsg", "xf_err_msg");
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
	 * 先锋转账表ID,主键，自增长字段 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"xf_transfer_id","xfTransferId","先锋转账表ID,主键，自增长字段");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","先锋转账表ID,主键，自增长字段");

	public final TableField<Integer> xfTransferId = new TableFieldImpl<Integer>(this,"xf_transfer_id","xfTransferId","先锋转账表ID,主键，自增长字段");

	/**
	 * 请求来源系统,齐牛内部业务系统登记到账务系统的代号如:OMS发送给微信服务器的客户订单号为32个字符，由src_sys,src_bus,c_trans_id组成。 | char(3)
	 */
	public final TableField<String> srcSys = new TableFieldImpl<String>(this,"src_sys","srcSys","请求来源系统,齐牛内部业务系统登记到账务系统的代号如:OMS发送给微信服务器的客户订单号为32个字符，由src_sys,src_bus,c_trans_id组成。");

	/**
	 * 请求来源业务,齐牛内部业务系统功能登记到账务系统的代号 | char(6)
	 */
	public final TableField<String> srcBus = new TableFieldImpl<String>(this,"src_bus","srcBus","请求来源业务,齐牛内部业务系统功能登记到账务系统的代号");

	/**
	 * 客户端交易ID,调用者传入的业务内不重复的字符串建议编码规则：yyyyMMddHHmmss+9位随机数。 | varchar(23)
	 */
	public final TableField<String> srcTransId = new TableFieldImpl<String>(this,"src_trans_id","srcTransId","客户端交易ID,调用者传入的业务内不重复的字符串建议编码规则：yyyyMMddHHmmss+9位随机数。");

	/**
	 * 请求数据摘要,用于判断同一业务具有相同客户端交易ID的请求是否相等。 | char(32)
	 */
	public final TableField<String> md5 = new TableFieldImpl<String>(this,"md5","md5","请求数据摘要,用于判断同一业务具有相同客户端交易ID的请求是否相等。");

	/**
	 * 提现的用户 | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","提现的用户");

	/**
	 * 提现金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> amount = new TableFieldImpl<BigDecimal>(this,"amount","amount","提现金额");

	/**
	 * 发送状态	A:客户申请提现，等待OMS批准,W:等待发送(正常情况只会极短瞬间出现，否则，程序必然发生了异常),U:未知状态（不确定是否提现成功）,S:发送成功,E:失败。 | char(1)
	 */
	public final TableField<String> sendStatus = new TableFieldImpl<String>(this,"send_status","sendStatus","发送状态	A:客户申请提现，等待OMS批准,W:等待发送(正常情况只会极短瞬间出现，否则，程序必然发生了异常),U:未知状态（不确定是否提现成功）,S:发送成功,E:失败。");

	/**
	 * 先锋远程交易ID | varchar(32)
	 */
	public final TableField<String> xfTradeNo = new TableFieldImpl<String>(this,"xf_trade_no","xfTradeNo","先锋远程交易ID");

	/**
	 * 交易时间 | datetime
	 */
	public final DateTableField<Date> tradeTime = new DateTableFieldImpl<Date>(this,"trade_time","tradeTime","交易时间");

	/**
	 * 回调时间 | datetime
	 */
	public final DateTableField<Date> callbackTime = new DateTableFieldImpl<Date>(this,"callback_time","callbackTime","回调时间");

	/**
	 * 订单状态,成功S，失败F，处理中I | char(1)
	 */
	public final TableField<String> remoteStatus = new TableFieldImpl<String>(this,"remote_status","remoteStatus","订单状态,成功S，失败F，处理中I");

	/**
	 * 转账失败信息 | varchar(128)
	 */
	public final TableField<String> xfErrMsg = new TableFieldImpl<String>(this,"xf_err_msg","xfErrMsg","转账失败信息");

	/**
	 * 记录状态,1-有效，0-无效（删除） | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态,1-有效，0-无效（删除）");

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

	private final TableField<?>[] allFields = new TableField<?>[] {xfTransferId,srcSys,srcBus,srcTransId,md5,userId,amount,sendStatus,xfTradeNo,tradeTime,callbackTime,remoteStatus,xfErrMsg,isStatus,createTime,updateTime,lockVersion};

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
		return "TPayXfTransfer[table=pay_xf_transfer]";
	}
}
