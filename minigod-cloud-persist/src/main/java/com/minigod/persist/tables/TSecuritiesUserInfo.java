package com.minigod.persist.tables;
import com.minigod.db4j.table.AllField;
import com.minigod.db4j.table.AbstractTable;
import com.minigod.db4j.table.TableField;
import com.minigod.db4j.table.TableFieldImpl;
import java.util.HashMap;
import java.util.Map;

public class TSecuritiesUserInfo extends AbstractTable {

	static {
		init();
	}

	private TSecuritiesUserInfo(){
		super.tableName = "securities_user_info";
	}

	private TSecuritiesUserInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSecuritiesUserInfo getInstance() {
		return new TSecuritiesUserInfo();
	}

	public static final TSecuritiesUserInfo getInstance(String aliasName) {
		return new TSecuritiesUserInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("gid", "gid");
		allFieldMap.put("openAccountType", "open_account_type");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("clientName", "client_name");
		allFieldMap.put("familyName", "family_name");
		allFieldMap.put("givenName", "given_name");
		allFieldMap.put("clientNameSpell", "client_name_spell");
		allFieldMap.put("idKind", "id_kind");
		allFieldMap.put("idNo", "id_no");
		allFieldMap.put("idCardAddress", "id_card_address");
		allFieldMap.put("birthday", "birthday");
		allFieldMap.put("sex", "sex");
		allFieldMap.put("bankId", "bank_id");
		allFieldMap.put("bankNo", "bank_no");
		allFieldMap.put("nationality", "nationality");
		allFieldMap.put("isAmericanGreenCardHolder", "is_american_green_card_holder");
		allFieldMap.put("contactProvinceName", "contact_province_name");
		allFieldMap.put("contactCityName", "contact_city_name");
		allFieldMap.put("contactCountyName", "contact_county_name");
		allFieldMap.put("contactDetailAddress", "contact_detail_address");
		allFieldMap.put("email", "email");
		allFieldMap.put("phoneNumber", "phone_number");
		allFieldMap.put("professionCode", "profession_code");
		allFieldMap.put("otherProfession", "other_profession");
		allFieldMap.put("companyName", "company_name");
		allFieldMap.put("companyPhoneNumber", "company_phone_number");
		allFieldMap.put("jobPosition", "job_position");
		allFieldMap.put("industryRange", "industry_range");
		allFieldMap.put("income", "income");
		allFieldMap.put("netCapital", "net_capital");
		allFieldMap.put("investTarget", "invest_target");
		allFieldMap.put("investTargetOther", "invest_target_other");
		allFieldMap.put("stocksInvestmentExperienceType", "stocks_investment_experience_type");
		allFieldMap.put("warrantsInvestmentExperienceType", "warrants_investment_experience_type");
		allFieldMap.put("futuresInvestmentExperienceType", "futures_investment_experience_type");
		allFieldMap.put("isKnowDerivativeProducts", "is_know_derivative_products");
		allFieldMap.put("derivativeProductsStudyType", "derivative_products_study_type");
		allFieldMap.put("derivativeProductsStudyTypeOther", "derivative_products_study_type_other");
		allFieldMap.put("financingInstitutionWorkExperienceType", "financing_institution_work_experience_type");
		allFieldMap.put("financingInstitutionWorkExperienceTypeOther", "financing_institution_work_experience_type_other");
		allFieldMap.put("isTradedDerivativeProducts", "is_traded_derivative_products");
		allFieldMap.put("ownerOfAccountType", "owner_of_account_type");
		allFieldMap.put("ownerOfAccountsDetail", "owner_of_accounts_detail");
		allFieldMap.put("isSfcEmployee", "is_sfc_employee");
		allFieldMap.put("registeredPersonName", "registered_person_name");
		allFieldMap.put("isClerkRelation", "is_clerk_relation");
		allFieldMap.put("clerkRelationInfo", "clerk_relation_info");
		allFieldMap.put("relatedClerkName", "related_clerk_name");
		allFieldMap.put("hasOtherAccount", "has_other_account");
		allFieldMap.put("otherAccountsDetailInfo", "other_accounts_detail_info");
		allFieldMap.put("inviterId", "inviter_id");
		allFieldMap.put("sourceChannelId", "source_channel_id");
		allFieldMap.put("sourceChannelName", "source_channel_name");
		allFieldMap.put("isOpenUsaStockMarket", "is_open_usa_stock_market");
		allFieldMap.put("isOpenHkStockMarket", "is_open_hk_stock_market");
		allFieldMap.put("isAllowDerivativesTransaction", "is_allow_derivatives_transaction");
		allFieldMap.put("tradeAccount", "trade_account");
		allFieldMap.put("fundAccount", "fund_account");
		allFieldMap.put("recordStatus", "record_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("openAccountTime", "open_account_time");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * gid | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"gid","gid","gid");
	public final TableField<Integer> gid = new TableFieldImpl<Integer>(this,"gid","gid","gid");

	/**
	 * 开户类型[互联网、见证宝、BPM] | int(11)
	 */
	public final TableField<Integer> openAccountType = new TableFieldImpl<Integer>(this,"open_account_type","openAccountType","开户类型[互联网、见证宝、BPM]");

	/**
	 * 客户号 | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","客户号");

	/**
	 * 客户中文名 | varchar(50)
	 */
	public final TableField<String> clientName = new TableFieldImpl<String>(this,"client_name","clientName","客户中文名");

	/**
	 * 姓氏 | varchar(50)
	 */
	public final TableField<String> familyName = new TableFieldImpl<String>(this,"family_name","familyName","姓氏");

	/**
	 * 名字 | varchar(50)
	 */
	public final TableField<String> givenName = new TableFieldImpl<String>(this,"given_name","givenName","名字");

	/**
	 * 中文名拼音 | varchar(50)
	 */
	public final TableField<String> clientNameSpell = new TableFieldImpl<String>(this,"client_name_spell","clientNameSpell","中文名拼音");

	/**
	 * 证件类型 [0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证] | int(11)
	 */
	public final TableField<Integer> idKind = new TableFieldImpl<Integer>(this,"id_kind","idKind","证件类型 [0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]");

	/**
	 * 证件号码 | varchar(50)
	 */
	public final TableField<String> idNo = new TableFieldImpl<String>(this,"id_no","idNo","证件号码");

	/**
	 * 身份证地址 | varchar(500)
	 */
	public final TableField<String> idCardAddress = new TableFieldImpl<String>(this,"id_card_address","idCardAddress","身份证地址");

	/**
	 * 生日 | varchar(20)
	 */
	public final TableField<String> birthday = new TableFieldImpl<String>(this,"birthday","birthday","生日");

	/**
	 * 性别[0=男 1=女 2=其它] | int(11)
	 */
	public final TableField<Integer> sex = new TableFieldImpl<Integer>(this,"sex","sex","性别[0=男 1=女 2=其它]");

	/**
	 * 银行编号 | int(11)
	 */
	public final TableField<Integer> bankId = new TableFieldImpl<Integer>(this,"bank_id","bankId","银行编号");

	/**
	 * 银行卡号 | varchar(20)
	 */
	public final TableField<String> bankNo = new TableFieldImpl<String>(this,"bank_no","bankNo","银行卡号");

	/**
	 * 国籍 | varchar(50)
	 */
	public final TableField<String> nationality = new TableFieldImpl<String>(this,"nationality","nationality","国籍");

	/**
	 * 是否美国绿卡持有人[0=否 1=是] | int(11)
	 */
	public final TableField<Integer> isAmericanGreenCardHolder = new TableFieldImpl<Integer>(this,"is_american_green_card_holder","isAmericanGreenCardHolder","是否美国绿卡持有人[0=否 1=是]");

	/**
	 * 联系地址的省份 | varchar(50)
	 */
	public final TableField<String> contactProvinceName = new TableFieldImpl<String>(this,"contact_province_name","contactProvinceName","联系地址的省份");

	/**
	 * 联系地址的城市 | varchar(50)
	 */
	public final TableField<String> contactCityName = new TableFieldImpl<String>(this,"contact_city_name","contactCityName","联系地址的城市");

	/**
	 * 联系地址的区域 | varchar(50)
	 */
	public final TableField<String> contactCountyName = new TableFieldImpl<String>(this,"contact_county_name","contactCountyName","联系地址的区域");

	/**
	 * 联系地址的详细地址 | varchar(500)
	 */
	public final TableField<String> contactDetailAddress = new TableFieldImpl<String>(this,"contact_detail_address","contactDetailAddress","联系地址的详细地址");

	/**
	 * 电子邮箱 | varchar(50)
	 */
	public final TableField<String> email = new TableFieldImpl<String>(this,"email","email","电子邮箱");

	/**
	 * 手机号 | varchar(50)
	 */
	public final TableField<String> phoneNumber = new TableFieldImpl<String>(this,"phone_number","phoneNumber","手机号");

	/**
	 * 就业情况类型 [1=受雇 2=自营 3=退休 4=学生 5=其他 6 =务农 7=待业 8=自由职业者] | int(11)
	 */
	public final TableField<Integer> professionCode = new TableFieldImpl<Integer>(this,"profession_code","professionCode","就业情况类型 [1=受雇 2=自营 3=退休 4=学生 5=其他 6 =务农 7=待业 8=自由职业者]");

	/**
	 * 就业情况其它说明 | varchar(50)
	 */
	public final TableField<String> otherProfession = new TableFieldImpl<String>(this,"other_profession","otherProfession","就业情况其它说明");

	/**
	 * 公司名称 | varchar(50)
	 */
	public final TableField<String> companyName = new TableFieldImpl<String>(this,"company_name","companyName","公司名称");

	/**
	 * 公司电话 | varchar(50)
	 */
	public final TableField<String> companyPhoneNumber = new TableFieldImpl<String>(this,"company_phone_number","companyPhoneNumber","公司电话");

	/**
	 * 职位 | varchar(50)
	 */
	public final TableField<String> jobPosition = new TableFieldImpl<String>(this,"job_position","jobPosition","职位");

	/**
	 * 公司业务性质或行业类型 | varchar(50)
	 */
	public final TableField<String> industryRange = new TableFieldImpl<String>(this,"industry_range","industryRange","公司业务性质或行业类型");

	/**
	 * 年收入范围类型  [1=<20万 2=20万-50万 3=50万-100万 4=100万-500万 5=>500万] | int(11)
	 */
	public final TableField<Integer> income = new TableFieldImpl<Integer>(this,"income","income","年收入范围类型  [1=<20万 2=20万-50万 3=50万-100万 4=100万-500万 5=>500万]");

	/**
	 * 净资产范围类型   [1=<50万 2=50万-250万 3=250万-500万 4=>500万] | int(11)
	 */
	public final TableField<Integer> netCapital = new TableFieldImpl<Integer>(this,"net_capital","netCapital","净资产范围类型   [1=<50万 2=50万-250万 3=250万-500万 4=>500万]");

	/**
	 * 投资目标类型 [1=股息收入 2=短期投资 3=长期投资 4=其他] | text
	 */
	public final TableField<String> investTarget = new TableFieldImpl<String>(this,"invest_target","investTarget","投资目标类型 [1=股息收入 2=短期投资 3=长期投资 4=其他]");

	/**
	 * 投资目标其它类型说明 | varchar(50)
	 */
	public final TableField<String> investTargetOther = new TableFieldImpl<String>(this,"invest_target_other","investTargetOther","投资目标其它类型说明");

	/**
	 * 股票投资经验类型 [0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上] | int(11)
	 */
	public final TableField<Integer> stocksInvestmentExperienceType = new TableFieldImpl<Integer>(this,"stocks_investment_experience_type","stocksInvestmentExperienceType","股票投资经验类型 [0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]");

	/**
	 * 认证股权投资经验类型 [0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上] | int(11)
	 */
	public final TableField<Integer> warrantsInvestmentExperienceType = new TableFieldImpl<Integer>(this,"warrants_investment_experience_type","warrantsInvestmentExperienceType","认证股权投资经验类型 [0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]");

	/**
	 * 期货投资经验类型 [0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上] | int(11)
	 */
	public final TableField<Integer> futuresInvestmentExperienceType = new TableFieldImpl<Integer>(this,"futures_investment_experience_type","futuresInvestmentExperienceType","期货投资经验类型 [0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]");

	/**
	 * 是否了解衍生产品 [0=否 1=是] | int(11)
	 */
	public final TableField<Integer> isKnowDerivativeProducts = new TableFieldImpl<Integer>(this,"is_know_derivative_products","isKnowDerivativeProducts","是否了解衍生产品 [0=否 1=是]");

	/**
	 * 衍生产品学习途径 [0=未知 1=金融机构 2=监管机构 3=交易所 4=大专院校 5=进修学院 6=线上课程 7=其它] | int(11)
	 */
	public final TableField<Integer> derivativeProductsStudyType = new TableFieldImpl<Integer>(this,"derivative_products_study_type","derivativeProductsStudyType","衍生产品学习途径 [0=未知 1=金融机构 2=监管机构 3=交易所 4=大专院校 5=进修学院 6=线上课程 7=其它]");

	/**
	 * 衍生产品其他学习途径 | varchar(50)
	 */
	public final TableField<String> derivativeProductsStudyTypeOther = new TableFieldImpl<String>(this,"derivative_products_study_type_other","derivativeProductsStudyTypeOther","衍生产品其他学习途径");

	/**
	 * 在金融机构工作经验类型 [0=未知 1=受监管持牌人士 2=与衍生工具相关后勤 3=管理层 4=其它] | int(11)
	 */
	public final TableField<Integer> financingInstitutionWorkExperienceType = new TableFieldImpl<Integer>(this,"financing_institution_work_experience_type","financingInstitutionWorkExperienceType","在金融机构工作经验类型 [0=未知 1=受监管持牌人士 2=与衍生工具相关后勤 3=管理层 4=其它]");

	/**
	 * 在金融机构其它工作经验类型 | varchar(50)
	 */
	public final TableField<String> financingInstitutionWorkExperienceTypeOther = new TableFieldImpl<String>(this,"financing_institution_work_experience_type_other","financingInstitutionWorkExperienceTypeOther","在金融机构其它工作经验类型");

	/**
	 * 是否在过去三年曾买卖过至少五次任何衍生产品的交易 [0=否 1=是] | int(11)
	 */
	public final TableField<Integer> isTradedDerivativeProducts = new TableFieldImpl<Integer>(this,"is_traded_derivative_products","isTradedDerivativeProducts","是否在过去三年曾买卖过至少五次任何衍生产品的交易 [0=否 1=是]");

	/**
	 * 账户受益人类型[0=自己 1=其他] | int(11)
	 */
	public final TableField<Integer> ownerOfAccountType = new TableFieldImpl<Integer>(this,"owner_of_account_type","ownerOfAccountType","账户受益人类型[0=自己 1=其他]");

	/**
	 * 账户其他受益人详细信息，json[{ownName:xxx, ownAddress:xxx},{ownName:xxx, ownAddress:xxx}] | text
	 */
	public final TableField<String> ownerOfAccountsDetail = new TableFieldImpl<String>(this,"owner_of_accounts_detail","ownerOfAccountsDetail","账户其他受益人详细信息，json[{ownName:xxx, ownAddress:xxx},{ownName:xxx, ownAddress:xxx}]");

	/**
	 * 是否证券及期货事务监察委员会之注册公司雇员或注册人 [0=否 1=是] | int(11)
	 */
	public final TableField<Integer> isSfcEmployee = new TableFieldImpl<Integer>(this,"is_sfc_employee","isSfcEmployee","是否证券及期货事务监察委员会之注册公司雇员或注册人 [0=否 1=是]");

	/**
	 * 注册人名称 | varchar(50)
	 */
	public final TableField<String> registeredPersonName = new TableFieldImpl<String>(this,"registered_person_name","registeredPersonName","注册人名称");

	/**
	 * 是否与玖富集团之任何董事、职员或代表有亲属关系 [0=否 1=是] | int(11)
	 */
	public final TableField<Integer> isClerkRelation = new TableFieldImpl<Integer>(this,"is_clerk_relation","isClerkRelation","是否与玖富集团之任何董事、职员或代表有亲属关系 [0=否 1=是]");

	/**
	 * 董事、职员或代表的亲属关系信息 | varchar(50)
	 */
	public final TableField<String> clerkRelationInfo = new TableFieldImpl<String>(this,"clerk_relation_info","clerkRelationInfo","董事、职员或代表的亲属关系信息");


	/**
	 * 关联关系的人员姓名 | varchar(500)
	 */
	public final TableField<String> relatedClerkName = new TableFieldImpl<String>(this,"related_clerk_name","relatedClerkName","关联关系的人员姓名");

	/**
	 * 是否有其他股票行或银行的股票户口资料[0=否 1=是] | int(11)
	 */
	public final TableField<Integer> hasOtherAccount = new TableFieldImpl<Integer>(this,"has_other_account","hasOtherAccount","是否有其他股票行或银行的股票户口资料[0=否 1=是]");

	/**
	 * 其它账号详细信息,json[{bankName:xxx, accountNumber:xxx},{bankName:xxx, accountNumber:xxx}] | text
	 */
	public final TableField<String> otherAccountsDetailInfo = new TableFieldImpl<String>(this,"other_accounts_detail_info","otherAccountsDetailInfo","其它账号详细信息,json[{bankName:xxx, accountNumber:xxx},{bankName:xxx, accountNumber:xxx}]");

	/**
	 * 开户邀请人的userId | varchar(50)
	 */
	public final TableField<String> inviterId = new TableFieldImpl<String>(this,"inviter_id","inviterId","开户邀请人的userId");

	/**
	 * 开户客户来源渠道ID[dataRef t_crm_channel] | varchar(50)
	 */
	public final TableField<String> sourceChannelId = new TableFieldImpl<String>(this,"source_channel_id","sourceChannelId","开户客户来源渠道ID[dataRef t_crm_channel]");

	/**
	 * 开户客户来源渠道名称[dataRef t_crm_channel] | varchar(50)
	 */
	public final TableField<String> sourceChannelName = new TableFieldImpl<String>(this,"source_channel_name","sourceChannelName","开户客户来源渠道名称[dataRef t_crm_channel]");

	/**
	 * 是否开通美股市场 | int(11)
	 */
	public final TableField<Integer> isOpenUsaStockMarket = new TableFieldImpl<Integer>(this,"is_open_usa_stock_market","isOpenUsaStockMarket","是否开通美股市场");

	/**
	 * 是否开通港股市场 | int(11)
	 */
	public final TableField<Integer> isOpenHkStockMarket = new TableFieldImpl<Integer>(this,"is_open_hk_stock_market","isOpenHkStockMarket","是否开通港股市场");

	/**
	 * 是否允许衍生品交易 | int(11)
	 */
	public final TableField<Integer> isAllowDerivativesTransaction = new TableFieldImpl<Integer>(this,"is_allow_derivatives_transaction","isAllowDerivativesTransaction","是否允许衍生品交易");

	/**
	 * 交易账号 | varchar(50)
	 */
	public final TableField<String> tradeAccount = new TableFieldImpl<String>(this,"trade_account","tradeAccount","交易账号");

	/**
	 * 资金账号 | varchar(50)
	 */
	public final TableField<String> fundAccount = new TableFieldImpl<String>(this,"fund_account","fundAccount","资金账号");

	/**
	 * 记录状态[enums CommonRecordStatus] | int(11)
	 */
	public final TableField<Integer> recordStatus = new TableFieldImpl<Integer>(this,"record_status","recordStatus","记录状态[enums CommonRecordStatus]");

	/**
	 * 创建时间 | bigint(20)
	 */
	public final TableField<Long> createTime = new TableFieldImpl<Long>(this,"create_time","createTime","创建时间");

	/**
	 * 更新时间 | bigint(20)
	 */
	public final TableField<Long> updateTime = new TableFieldImpl<Long>(this,"update_time","updateTime","更新时间");

	/**
	 * 开户时间 | bigint(20)
	 */
	public final TableField<Long> openAccountTime = new TableFieldImpl<Long>(this,"open_account_time","openAccountTime","开户时间");

	private final TableField<?>[] allFields = new TableField<?>[] {gid,openAccountType,userId,clientName,familyName,givenName,clientNameSpell,idKind,idNo,idCardAddress,birthday,sex,bankId,bankNo,nationality,isAmericanGreenCardHolder,contactProvinceName,contactCityName,contactCountyName,contactDetailAddress,email,phoneNumber,professionCode,otherProfession,companyName,companyPhoneNumber,jobPosition,industryRange,income,netCapital,investTarget,investTargetOther,stocksInvestmentExperienceType,warrantsInvestmentExperienceType,futuresInvestmentExperienceType,isKnowDerivativeProducts,derivativeProductsStudyType,derivativeProductsStudyTypeOther,financingInstitutionWorkExperienceType,financingInstitutionWorkExperienceTypeOther,isTradedDerivativeProducts,ownerOfAccountType,ownerOfAccountsDetail,isSfcEmployee,registeredPersonName,isClerkRelation,clerkRelationInfo,hasOtherAccount,otherAccountsDetailInfo,inviterId,sourceChannelId,sourceChannelName,isOpenUsaStockMarket,isOpenHkStockMarket,isAllowDerivativesTransaction,tradeAccount,fundAccount,recordStatus,createTime,updateTime,openAccountTime};

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
		return "TSecuritiesUserInfo[table=securities_user_info]";
	}
}
