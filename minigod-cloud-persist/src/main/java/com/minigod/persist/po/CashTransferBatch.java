package com.minigod.persist.po;
import com.minigod.persist.tables.TCashTransferBatch;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TCashTransferBatch.class)
public class CashTransferBatch implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer cashBatchId;//批次id，自增长字段，主键
	private String userBatchId;//用户提交请求中的批次ID,日期+批次类别+两位日内序号,EX:20150126A01
	private String batchOrder;//客户提交的批次信息
	private String status;//整体执行状态，W:准备执行P:执行中E:错误中断，待人工介入S:已结束，处理完毕
	private String orderMd5;//数据批次信息摘要
	private String parseStatus;//转换状态，W:待解析S:解析成功E:解析错误
	private String parseError;//解析失败原因
	private String batchType;//批次类型，A:批量发钱
	private String description;//批次描述
	private String executeStatus;//处理状态，W:等待处理P:部分已处理S:全部处理成功
	private Integer executeLine;//批次执行到哪里，为传入批次命令的转账请求序号
	private String currentError;//当前执行行错误信息
	private String submitRealName;//提交的用户的真实姓名
	private Boolean isStatus;//状态，0停用,默认1正常使用
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getCashBatchId () {
        return cashBatchId;
    }

    public void setCashBatchId (Integer cashBatchId) {
        this.cashBatchId = cashBatchId;
    }

    public String getUserBatchId () {
        return userBatchId;
    }

    public void setUserBatchId (String userBatchId) {
        this.userBatchId = userBatchId;
    }

    public String getBatchOrder () {
        return batchOrder;
    }

    public void setBatchOrder (String batchOrder) {
        this.batchOrder = batchOrder;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getOrderMd5 () {
        return orderMd5;
    }

    public void setOrderMd5 (String orderMd5) {
        this.orderMd5 = orderMd5;
    }

    public String getParseStatus () {
        return parseStatus;
    }

    public void setParseStatus (String parseStatus) {
        this.parseStatus = parseStatus;
    }

    public String getParseError () {
        return parseError;
    }

    public void setParseError (String parseError) {
        this.parseError = parseError;
    }

    public String getBatchType () {
        return batchType;
    }

    public void setBatchType (String batchType) {
        this.batchType = batchType;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getExecuteStatus () {
        return executeStatus;
    }

    public void setExecuteStatus (String executeStatus) {
        this.executeStatus = executeStatus;
    }

    public Integer getExecuteLine () {
        return executeLine;
    }

    public void setExecuteLine (Integer executeLine) {
        this.executeLine = executeLine;
    }

    public String getCurrentError () {
        return currentError;
    }

    public void setCurrentError (String currentError) {
        this.currentError = currentError;
    }

    public String getSubmitRealName () {
        return submitRealName;
    }

    public void setSubmitRealName (String submitRealName) {
        this.submitRealName = submitRealName;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }
}