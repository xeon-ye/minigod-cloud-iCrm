package com.sunline.modules.call.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 通话记录表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-05 14:32:55
 */
public class CallRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//小神号
	private Integer userId;
	//客户号
	private Integer clientId;
	//本条通话记录的唯一ID
	private String callSheetId;
	//主叫号码
	private String callNo;
	//被叫号码
	private String calledNo;
	//通话ID
	private String callId;
	//通话开始时间（只有已接听状态的才有值）
	private String beginTime;
	//结束时间
	private String endTime;
	//呼叫类型[normal-普通来电 dialout-外呼去电 transfer-来电转接 dialTransfer-外呼转接]
	private String connectType;
	//处理状态[dealing-已接听 notDeal-振铃未接听 queueLeak-排队放弃 voicemail-已留言 leak-IVR放弃 blackList-黑名单]
	private String status;
	//处理座席工号
	private String exten;
	//处理座席ID（历史原因创建的字段，如无用处可无视）
	private String disposalAgent;
	//呼叫发起时间
	private String offeringTime;
	//录音文件名
	private String recordFileName;
	//本地录音文件目录
	private String localFilePath;
	//定位客户名称
	private String customerName;
	//转接类型通话，此字段记录之前一通通话记录的ID
	private String refCallSheetId;
	//通话产生所在PBX的ID
	private String pbx;
	//技能组名称
	private String queueName;
	//录音服务器地址
	private String fileServer;
	//省
	private String province;
	//市
	private String district;
	//城市区号
	private String districtCode;
	//是否标记
	private String keyTag;
	//通话时长（未接通为0）
	private String callTimeLength;
	//满意度调查
	private String investigate;
	//该值为调用外呼接口时，传的ActionID
	private String actionId;
	//备注
	private String remark;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//归属地
    private  Integer extenAttach;
    //坐席姓名
    private String extenName;
    //关联状态
    private Integer relationState;

    //不带盘符的地址
    private String path;

    // 通讯分组名
    private String name;

	/**
	 * 设置：自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：小神号
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：小神号
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：客户号
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	/**
	 * 获取：客户号
	 */
	public Integer getClientId() {
		return clientId;
	}
	/**
	 * 设置：本条通话记录的唯一ID
	 */
	public void setCallSheetId(String callSheetId) {
		this.callSheetId = callSheetId;
	}
	/**
	 * 获取：本条通话记录的唯一ID
	 */
	public String getCallSheetId() {
		return callSheetId;
	}
	/**
	 * 设置：主叫号码
	 */
	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}
	/**
	 * 获取：主叫号码
	 */
	public String getCallNo() {
		return callNo;
	}
	/**
	 * 设置：被叫号码
	 */
	public void setCalledNo(String calledNo) {
		this.calledNo = calledNo;
	}
	/**
	 * 获取：被叫号码
	 */
	public String getCalledNo() {
		return calledNo;
	}
	/**
	 * 设置：通话ID
	 */
	public void setCallId(String callId) {
		this.callId = callId;
	}
	/**
	 * 获取：通话ID
	 */
	public String getCallId() {
		return callId;
	}
	/**
	 * 设置：通话开始时间（只有已接听状态的才有值）
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	/**
	 * 获取：通话开始时间（只有已接听状态的才有值）
	 */
	public String getBeginTime() {
		return beginTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：呼叫类型[normal-普通来电 dialout-外呼去电 transfer-来电转接 dialTransfer-外呼转接]
	 */
	public void setConnectType(String connectType) {
		this.connectType = connectType;
	}
	/**
	 * 获取：呼叫类型[normal-普通来电 dialout-外呼去电 transfer-来电转接 dialTransfer-外呼转接]
	 */
	public String getConnectType() {
		return connectType;
	}
	/**
	 * 设置：处理状态[dealing-已接听 notDeal-振铃未接听 queueLeak-排队放弃 voicemail-已留言 leak-IVR放弃 blackList-黑名单]
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：处理状态[dealing-已接听 notDeal-振铃未接听 queueLeak-排队放弃 voicemail-已留言 leak-IVR放弃 blackList-黑名单]
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：处理座席工号
	 */
	public void setExten(String exten) {
		this.exten = exten;
	}
	/**
	 * 获取：处理座席工号
	 */
	public String getExten() {
		return exten;
	}
	/**
	 * 设置：处理座席ID（历史原因创建的字段，如无用处可无视）
	 */
	public void setDisposalAgent(String disposalAgent) {
		this.disposalAgent = disposalAgent;
	}
	/**
	 * 获取：处理座席ID（历史原因创建的字段，如无用处可无视）
	 */
	public String getDisposalAgent() {
		return disposalAgent;
	}
	/**
	 * 设置：呼叫发起时间
	 */
	public void setOfferingTime(String offeringTime) {
		this.offeringTime = offeringTime;
	}
	/**
	 * 获取：呼叫发起时间
	 */
	public String getOfferingTime() {
		return offeringTime;
	}
	/**
	 * 设置：录音文件名
	 */
	public void setRecordFileName(String recordFileName) {
		this.recordFileName = recordFileName;
	}
	/**
	 * 获取：录音文件名
	 */
	public String getRecordFileName() {
		return recordFileName;
	}
	/**
	 * 设置：本地录音文件目录
	 */
	public void setLocalFilePath(String localFilePath) {
		this.localFilePath = localFilePath;
	}
	/**
	 * 获取：本地录音文件目录
	 */
	public String getLocalFilePath() {
		return localFilePath;
	}
	/**
	 * 设置：定位客户名称
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 获取：定位客户名称
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 设置：转接类型通话，此字段记录之前一通通话记录的ID
	 */
	public void setRefCallSheetId(String refCallSheetId) {
		this.refCallSheetId = refCallSheetId;
	}
	/**
	 * 获取：转接类型通话，此字段记录之前一通通话记录的ID
	 */
	public String getRefCallSheetId() {
		return refCallSheetId;
	}
	/**
	 * 设置：通话产生所在PBX的ID
	 */
	public void setPbx(String pbx) {
		this.pbx = pbx;
	}
	/**
	 * 获取：通话产生所在PBX的ID
	 */
	public String getPbx() {
		return pbx;
	}
	/**
	 * 设置：技能组名称
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	/**
	 * 获取：技能组名称
	 */
	public String getQueueName() {
		return queueName;
	}
	/**
	 * 设置：录音服务器地址
	 */
	public void setFileServer(String fileServer) {
		this.fileServer = fileServer;
	}
	/**
	 * 获取：录音服务器地址
	 */
	public String getFileServer() {
		return fileServer;
	}
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：市
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：市
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * 设置：城市区号
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	/**
	 * 获取：城市区号
	 */
	public String getDistrictCode() {
		return districtCode;
	}
	/**
	 * 设置：是否标记
	 */
	public void setKeyTag(String keyTag) {
		this.keyTag = keyTag;
	}
	/**
	 * 获取：是否标记
	 */
	public String getKeyTag() {
		return keyTag;
	}
	/**
	 * 设置：通话时长（未接通为0）
	 */
	public void setCallTimeLength(String callTimeLength) {
		this.callTimeLength = callTimeLength;
	}
	/**
	 * 获取：通话时长（未接通为0）
	 */
	public String getCallTimeLength() {
		return callTimeLength;
	}
	/**
	 * 设置：满意度调查
	 */
	public void setInvestigate(String investigate) {
		this.investigate = investigate;
	}
	/**
	 * 获取：满意度调查
	 */
	public String getInvestigate() {
		return investigate;
	}
	/**
	 * 设置：该值为调用外呼接口时，传的ActionID
	 */
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	/**
	 * 获取：该值为调用外呼接口时，传的ActionID
	 */
	public String getActionId() {
		return actionId;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

    public Integer getExtenAttach() {
        return extenAttach;
    }

    public void setExtenAttach(Integer extenAttach) {
        this.extenAttach = extenAttach;
    }

    public String getExtenName() {
        return extenName;
    }

    public void setExtenName(String extenName) {
        this.extenName = extenName;
    }

    public Integer getRelationState() {
        return relationState;
    }

    public void setRelationState(Integer relationState) {
        this.relationState = relationState;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
