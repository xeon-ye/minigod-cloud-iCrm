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

public class TSnUserProgress extends AbstractTable {

	static {
		init();
	}

	private TSnUserProgress(){
		super.tableName = "sn_user_progress";
	}

	private TSnUserProgress(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TSnUserProgress getInstance() {
		return new TSnUserProgress();
	}

	public static final TSnUserProgress getInstance(String aliasName) {
		return new TSnUserProgress(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("userProgressId", "user_progress_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("taskId", "task_id");
		allFieldMap.put("featId", "feat_id");
		allFieldMap.put("taskName", "task_name");
		allFieldMap.put("realDes", "real_des");
		allFieldMap.put("targetNum", "target_num");
		allFieldMap.put("curNum", "cur_num");
		allFieldMap.put("progressRate", "progress_rate");
		allFieldMap.put("gmtFinish", "gmt_finish");
		allFieldMap.put("receiveStatus", "receive_status");
		allFieldMap.put("taskStatus", "task_status");
		allFieldMap.put("finishStatus", "finish_status");
		allFieldMap.put("effectiveDay", "effective_day");
		allFieldMap.put("eventCode", "event_code");
		allFieldMap.put("taskType", "task_type");
		allFieldMap.put("showIdx", "show_idx");
		allFieldMap.put("coin", "coin");
		allFieldMap.put("experience", "experience");
		allFieldMap.put("isDeleted", "is_deleted");
		allFieldMap.put("creator", "creator");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("modifier", "modifier");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("calType", "cal_type");
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
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"user_progress_id","userProgressId","");
	public final TableField<Integer> userProgressId = new TableFieldImpl<Integer>(this,"user_progress_id","userProgressId","");

	/**
	 * 用户id | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","用户id");

	/**
	 * 任务id | bigint(11)
	 */
	public final TableField<Long> taskId = new TableFieldImpl<Long>(this,"task_id","taskId","任务id");

	/**
	 * 功勋id,如果有的话 | int(11)
	 */
	public final TableField<Integer> featId = new TableFieldImpl<Integer>(this,"feat_id","featId","功勋id,如果有的话");

	/**
	 * 任务名称 | varchar(128)
	 */
	public final TableField<String> taskName = new TableFieldImpl<String>(this,"task_name","taskName","任务名称");

	/**
	 * 任务的真正名称 | varchar(128)
	 */
	public final TableField<String> realDes = new TableFieldImpl<String>(this,"real_des","realDes","任务的真正名称");

	/**
	 * 目标数字 | int(11)
	 */
	public final TableField<Integer> targetNum = new TableFieldImpl<Integer>(this,"target_num","targetNum","目标数字");

	/**
	 * 当前进展 | int(11)
	 */
	public final TableField<Integer> curNum = new TableFieldImpl<Integer>(this,"cur_num","curNum","当前进展");

	/**
	 * 进度比率 | decimal(11,3)
	 */
	public final TableField<BigDecimal> progressRate = new TableFieldImpl<BigDecimal>(this,"progress_rate","progressRate","进度比率");

	/**
	 * 完成时间(任务达到100%的时间) | datetime
	 */
	public final DateTableField<Date> gmtFinish = new DateTableFieldImpl<Date>(this,"gmt_finish","gmtFinish","完成时间(任务达到100%的时间)");

	/**
	 * 领取奖励的状态(0:不可领取, 1:可以领取,但尚未领取, 2:可以领取,且已经领取) | int(11)
	 */
	public final TableField<Integer> receiveStatus = new TableFieldImpl<Integer>(this,"receive_status","receiveStatus","领取奖励的状态(0:不可领取, 1:可以领取,但尚未领取, 2:可以领取,且已经领取)");

	/**
	 * 任务对于当前角色 所处的状态(nostart:没开始; over:已关闭; in_progress: 进行中,包括进度100%的可以继续做) | varchar(45)
	 */
	public final TableField<String> taskStatus = new TableFieldImpl<String>(this,"task_status","taskStatus","任务对于当前角色 所处的状态(nostart:没开始; over:已关闭; in_progress: 进行中,包括进度100%的可以继续做)");

	/**
	 * 是否成功(in_progress, fail, success) | varchar(45)
	 */
	public final TableField<String> finishStatus = new TableFieldImpl<String>(this,"finish_status","finishStatus","是否成功(in_progress, fail, success)");

	/**
	 * 生效日期 | int(11)
	 */
	public final TableField<Integer> effectiveDay = new TableFieldImpl<Integer>(this,"effective_day","effectiveDay","生效日期");

	/**
	 * 任务所属的事件类型 | varchar(45)
	 */
	public final TableField<String> eventCode = new TableFieldImpl<String>(this,"event_code","eventCode","任务所属的事件类型");

	/**
	 * 任务的任务类型 | varchar(45)
	 */
	public final TableField<String> taskType = new TableFieldImpl<String>(this,"task_type","taskType","任务的任务类型");

	/**
	 * 显示的顺序 | int(11)
	 */
	public final TableField<Integer> showIdx = new TableFieldImpl<Integer>(this,"show_idx","showIdx","显示的顺序");

	/**
	 * 任务完成可以领取的金币值 | int(11)
	 */
	public final TableField<Integer> coin = new TableFieldImpl<Integer>(this,"coin","coin","任务完成可以领取的金币值");

	/**
	 * 任务完成可以领取的经验值 | int(11)
	 */
	public final TableField<Integer> experience = new TableFieldImpl<Integer>(this,"experience","experience","任务完成可以领取的经验值");

	/**
	 * 是否删除 | tinyint(1)
	 */
	public final TableField<Boolean> isDeleted = new TableFieldImpl<Boolean>(this,"is_deleted","isDeleted","是否删除");

	/**
	 * 创建者 | varchar(45)
	 */
	public final TableField<String> creator = new TableFieldImpl<String>(this,"creator","creator","创建者");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改者 | varchar(45)
	 */
	public final TableField<String> modifier = new TableFieldImpl<String>(this,"modifier","modifier","修改者");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	/**
	 * 任务的计算类型, (暂定)一次性:onetime, 连续性:continuity, 每个:everyone, 每次: everytime | varchar(45)
	 */
	public final TableField<String> calType = new TableFieldImpl<String>(this,"cal_type","calType","任务的计算类型, (暂定)一次性:onetime, 连续性:continuity, 每个:everyone, 每次: everytime");

	private final TableField<?>[] allFields = new TableField<?>[] {userProgressId,userId,taskId,featId,taskName,realDes,targetNum,curNum,progressRate,gmtFinish,receiveStatus,taskStatus,finishStatus,effectiveDay,eventCode,taskType,showIdx,coin,experience,isDeleted,creator,createTime,modifier,updateTime,calType};

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
		return "TSnUserProgress[table=sn_user_progress]";
	}
}
