package com.minigod.persist.po;
import com.minigod.persist.tables.TDivAllotReservation;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 分红配股拐点预订表
 */
@Entity(table=TDivAllotReservation.class)
public class DivAllotReservation implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer resvId;//预订ID
	private Date taskDate;//任务日期
	private Integer ptfId;//组合ID
	private String finishStatus;//结束状态
	private Date finishTime;//结束时间
	private String errMsg;

    public Integer getResvId () {
        return resvId;
    }

    public void setResvId (Integer resvId) {
        this.resvId = resvId;
    }

    public Date getTaskDate () {
        return taskDate;
    }

    public void setTaskDate (Date taskDate) {
        this.taskDate = taskDate;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public String getFinishStatus () {
        return finishStatus;
    }

    public void setFinishStatus (String finishStatus) {
        this.finishStatus = finishStatus;
    }

    public Date getFinishTime () {
        return finishTime;
    }

    public void setFinishTime (Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getErrMsg () {
        return errMsg;
    }

    public void setErrMsg (String errMsg) {
        this.errMsg = errMsg;
    }
}