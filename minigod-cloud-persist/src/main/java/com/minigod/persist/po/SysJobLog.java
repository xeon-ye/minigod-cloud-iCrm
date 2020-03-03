package com.minigod.persist.po;
import com.minigod.persist.tables.TSysJobLog;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSysJobLog.class)
public class SysJobLog implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer jobLogId;//日志ID
	private String sysName;
	private String jobName;
	private Date jobDate;//业务日期
	private String jobStatus;//任务状态
	private Integer errCode;//错误码
	private String errMsg;
	private Date startTime;//错误时间
	private Date endTime;//结束时间

    public Integer getJobLogId () {
        return jobLogId;
    }

    public void setJobLogId (Integer jobLogId) {
        this.jobLogId = jobLogId;
    }

    public String getSysName () {
        return sysName;
    }

    public void setSysName (String sysName) {
        this.sysName = sysName;
    }

    public String getJobName () {
        return jobName;
    }

    public void setJobName (String jobName) {
        this.jobName = jobName;
    }

    public Date getJobDate () {
        return jobDate;
    }

    public void setJobDate (Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getJobStatus () {
        return jobStatus;
    }

    public void setJobStatus (String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Integer getErrCode () {
        return errCode;
    }

    public void setErrCode (Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg () {
        return errMsg;
    }

    public void setErrMsg (String errMsg) {
        this.errMsg = errMsg;
    }

    public Date getStartTime () {
        return startTime;
    }

    public void setStartTime (Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime () {
        return endTime;
    }

    public void setEndTime (Date endTime) {
        this.endTime = endTime;
    }
}