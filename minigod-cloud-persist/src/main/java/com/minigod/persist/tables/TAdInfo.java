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

public class TAdInfo extends AbstractTable {

	static {
		init();
	}

	private TAdInfo(){
		super.tableName = "ad_info";
	}

	private TAdInfo(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TAdInfo getInstance() {
		return new TAdInfo();
	}

	public static final TAdInfo getInstance(String aliasName) {
		return new TAdInfo(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("adId", "ad_id");
		allFieldMap.put("positionCode", "position_code");
		allFieldMap.put("adCode", "ad_code");
		allFieldMap.put("groupId", "group_id");
		allFieldMap.put("adFlag", "ad_flag");
		allFieldMap.put("img", "img");
		allFieldMap.put("url", "url");
		allFieldMap.put("linkType", "link_type");
		allFieldMap.put("adDesc", "ad_desc");
		allFieldMap.put("startTime", "start_time");
		allFieldMap.put("endTime", "end_time");
		allFieldMap.put("priority", "priority");
		allFieldMap.put("activityNum", "activity_num");
		allFieldMap.put("createOpr", "create_opr");
		allFieldMap.put("updateOpr", "update_opr");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("bananerImg", "bananer_img");
		allFieldMap.put("maskChannel", "mask_channel");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 广告ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"ad_id","adId","广告ID");
	public final TableField<Integer> adId = new TableFieldImpl<Integer>(this,"ad_id","adId","广告ID");

	/**
	 * 广告位 | int(11)
	 */
	public final TableField<Integer> positionCode = new TableFieldImpl<Integer>(this,"position_code","positionCode","广告位");

	/**
	 * 活动标志码 | varchar(50)
	 */
	public final TableField<String> adCode = new TableFieldImpl<String>(this,"ad_code","adCode","活动标志码");

	/**
	 * 广告用户群分组 | int(11)
	 */
	public final TableField<Integer> groupId = new TableFieldImpl<Integer>(this,"group_id","groupId","广告用户群分组");

	/**
	 * 广告展示的判断条件 | int(11)
	 */
	public final TableField<Integer> adFlag = new TableFieldImpl<Integer>(this,"ad_flag","adFlag","广告展示的判断条件");

	/**
	 * 广告图片地址 | varchar(100)
	 */
	public final TableField<String> img = new TableFieldImpl<String>(this,"img","img","广告图片地址");

	/**
	 *  | varchar(500)
	 */
	public final TableField<String> url = new TableFieldImpl<String>(this,"url","url","");

	/**
	 * 广告的调转类型(V-观点详情,P-组合详情,A-广告详情页) | char(3)
	 */
	public final TableField<String> linkType = new TableFieldImpl<String>(this,"link_type","linkType","广告的调转类型(V-观点详情,P-组合详情,A-广告详情页)");

	/**
	 *  | varchar(100)
	 */
	public final TableField<String> adDesc = new TableFieldImpl<String>(this,"ad_desc","adDesc","");

	/**
	 * 广告开始时间 | datetime
	 */
	public final DateTableField<Date> startTime = new DateTableFieldImpl<Date>(this,"start_time","startTime","广告开始时间");

	/**
	 * 广告结束时间 | datetime
	 */
	public final DateTableField<Date> endTime = new DateTableFieldImpl<Date>(this,"end_time","endTime","广告结束时间");

	/**
	 * 数字越小优先级越高，同个用户群有多个广告时展示优先级最高的 | int(11)
	 */
	public final TableField<Integer> priority = new TableFieldImpl<Integer>(this,"priority","priority","数字越小优先级越高，同个用户群有多个广告时展示优先级最高的");

	/**
	 * 活动参与人数 | int(11)
	 */
	public final TableField<Integer> activityNum = new TableFieldImpl<Integer>(this,"activity_num","activityNum","活动参与人数");

	/**
	 * 创建人id | int(11)
	 */
	public final TableField<Integer> createOpr = new TableFieldImpl<Integer>(this,"create_opr","createOpr","创建人id");

	/**
	 * 更新人id | int(11)
	 */
	public final TableField<Integer> updateOpr = new TableFieldImpl<Integer>(this,"update_opr","updateOpr","更新人id");

	/**
	 * 是否上架(0-未上架,1-上架) | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","是否上架(0-未上架,1-上架)");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 更新时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","更新时间");

	/**
	 * 活动专栏banner图 | varchar(100)
	 */
	public final TableField<String> bananerImg = new TableFieldImpl<String>(this,"bananer_img","bananerImg","活动专栏banner图");

	/**
	 * 屏蔽渠道 | varchar(500)
	 */
	public final TableField<String> maskChannel = new TableFieldImpl<String>(this,"mask_channel","maskChannel","屏蔽渠道");

	private final TableField<?>[] allFields = new TableField<?>[] {adId,positionCode,adCode,groupId,adFlag,img,url,linkType,adDesc,startTime,endTime,priority,activityNum,createOpr,updateOpr,isStatus,createTime,updateTime,bananerImg,maskChannel};

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
		return "TAdInfo[table=ad_info]";
	}
}
