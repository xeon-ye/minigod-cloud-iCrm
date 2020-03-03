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

public class TPayBankTransfer extends AbstractTable {

	static {
		init();
	}

	private TPayBankTransfer(){
		super.tableName = "pay_bank_transfer";
	}

	private TPayBankTransfer(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPayBankTransfer getInstance() {
		return new TPayBankTransfer();
	}

	public static final TPayBankTransfer getInstance(String aliasName) {
		return new TPayBankTransfer(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("bankTransferId", "bank_transfer_id");
		allFieldMap.put("bankCellPhone", "bank_cell_phone");
		allFieldMap.put("bankNo", "bank_no");
		allFieldMap.put("bankName", "bank_name");
		allFieldMap.put("srcSys", "src_sys");
		allFieldMap.put("srcBus", "src_bus");
		allFieldMap.put("srcTransId", "src_trans_id");
		allFieldMap.put("md5", "md5");
		allFieldMap.put("clientReqId", "client_req_id");
		allFieldMap.put("accountId", "account_id");
		allFieldMap.put("totalFee", "total_fee");
		allFieldMap.put("poundage", "poundage");
		allFieldMap.put("unFrzAmt", "unFrz_amt");
		allFieldMap.put("unFrzRelaTrx", "unFrz_rela_trx");
		allFieldMap.put("sendStatus", "send_status");
		allFieldMap.put("transactionId", "transaction_id");
		allFieldMap.put("rvsTrxId", "rvs_trx_id");
		allFieldMap.put("display", "display");
		allFieldMap.put("incomeOrExpense", "income_or_expense");
		allFieldMap.put("description", "description");
		allFieldMap.put("checkName", "check_name");
		allFieldMap.put("reName", "re_name");
		allFieldMap.put("mchId", "mch_id");
		allFieldMap.put("bankErrMsg", "bank_err_msg");
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
	 * 银行卡转账表ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"bank_transfer_id","bankTransferId","银行卡转账表ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","银行卡转账表ID");

	public final TableField<Integer> bankTransferId = new TableFieldImpl<Integer>(this,"bank_transfer_id","bankTransferId","银行卡转账表ID");

	/**
	 * 银行预留手机号 | varchar(20)
	 */
	public final TableField<String> bankCellPhone = new TableFieldImpl<String>(this,"bank_cell_phone","bankCellPhone","银行预留手机号");

	/**
	 * 银行卡号 | varchar(50)
	 */
	public final TableField<String> bankNo = new TableFieldImpl<String>(this,"bank_no","bankNo","银行卡号");

	/**
	 * 银行名称 | varchar(100)
	 */
	public final TableField<String> bankName = new TableFieldImpl<String>(this,"bank_name","bankName","银行名称");

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
	 * 请求数据摘要 | char(32)
	 */
	public final TableField<String> md5 = new TableFieldImpl<String>(this,"md5","md5","请求数据摘要");

	/**
	 * 客户端请求ID | varchar(50)
	 */
	public final TableField<String> clientReqId = new TableFieldImpl<String>(this,"client_req_id","clientReqId","客户端请求ID");

	/**
	 * 业务中的转出账号 | int(11)
	 */
	public final TableField<Integer> accountId = new TableFieldImpl<Integer>(this,"account_id","accountId","业务中的转出账号");

	/**
	 * 转账金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> totalFee = new TableFieldImpl<BigDecimal>(this,"total_fee","totalFee","转账金额");

	/**
	 * 收取的手续费 | decimal(16,2)
	 */
	public final TableField<BigDecimal> poundage = new TableFieldImpl<BigDecimal>(this,"poundage","poundage","收取的手续费");

	/**
	 * 解冻金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> unFrzAmt = new TableFieldImpl<BigDecimal>(this,"unFrz_amt","unFrzAmt","解冻金额");

	/**
	 * 解冻关联的交易 | int(11)
	 */
	public final TableField<Integer> unFrzRelaTrx = new TableFieldImpl<Integer>(this,"unFrz_rela_trx","unFrzRelaTrx","解冻关联的交易");

	/**
	 * 发送状态 | char(1)
	 */
	public final TableField<String> sendStatus = new TableFieldImpl<String>(this,"send_status","sendStatus","发送状态");

	/**
	 * 支付对应的交易请求表ID | int(1)
	 */
	public final TableField<Integer> transactionId = new TableFieldImpl<Integer>(this,"transaction_id","transactionId","支付对应的交易请求表ID");

	/**
	 * 冲账交易的交易请求表ID | int(11)
	 */
	public final TableField<Integer> rvsTrxId = new TableFieldImpl<Integer>(this,"rvs_trx_id","rvsTrxId","冲账交易的交易请求表ID");

	/**
	 * 是否在钱包中显示 | char(1)
	 */
	public final TableField<String> display = new TableFieldImpl<String>(this,"display","display","是否在钱包中显示");

	/**
	 * 是否为收支项 | char(1)
	 */
	public final TableField<String> incomeOrExpense = new TableFieldImpl<String>(this,"income_or_expense","incomeOrExpense","是否为收支项");

	/**
	 * 提现描述 | varchar(256)
	 */
	public final TableField<String> description = new TableFieldImpl<String>(this,"description","description","提现描述");

	/**
	 * 是否校验真实姓名 | char(1)
	 */
	public final TableField<String> checkName = new TableFieldImpl<String>(this,"check_name","checkName","是否校验真实姓名");

	/**
	 * 客户真实姓名 | varchar(256)
	 */
	public final TableField<String> reName = new TableFieldImpl<String>(this,"re_name","reName","客户真实姓名");

	/**
	 * 商户号 | varchar(32)
	 */
	public final TableField<String> mchId = new TableFieldImpl<String>(this,"mch_id","mchId","商户号");

	/**
	 * 转账失败信息 | varchar(128)
	 */
	public final TableField<String> bankErrMsg = new TableFieldImpl<String>(this,"bank_err_msg","bankErrMsg","转账失败信息");

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

	private final TableField<?>[] allFields = new TableField<?>[] {bankTransferId,bankCellPhone,bankNo,bankName,srcSys,srcBus,srcTransId,md5,clientReqId,accountId,totalFee,poundage,unFrzAmt,unFrzRelaTrx,sendStatus,transactionId,rvsTrxId,display,incomeOrExpense,description,checkName,reName,mchId,bankErrMsg,isStatus,createTime,updateTime,lockVersion};

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
		return "TPayBankTransfer[table=pay_bank_transfer]";
	}
}
