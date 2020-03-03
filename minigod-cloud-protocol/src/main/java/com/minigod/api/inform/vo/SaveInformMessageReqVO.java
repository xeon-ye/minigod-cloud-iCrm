package com.minigod.api.inform.vo;

import java.io.Serializable;
import java.util.*;


public class SaveInformMessageReqVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Integer> lstToUserId;//用户ID(列表)
	private int fromUserId;//发送人
	private int displayGroup;//一级分类
	private int msgCode;//二级分类

	private String title;//列表页标题
	private String msgContent;//列表页内容

	private List<String> tplAndroid;//安卓系统通知栏内容
	private List<String> tplIos;//IOS系统通知栏内容
	
	private Integer sendWay;//推送方式(0-即时 1-定时)
	private Date sendTime;//推送时间,推送方式为定时时,不为空
	private Integer sendStatus ;//推送状态(0-未发送，1-已发送 2-发送失败)
	
	private String msgGroup ;//消息分组(P-个人，A-全站，L-标签用户，T-用户分组)
	
	private Integer clientType;//客户端类型(0-全部终端 1-Android 2-IOS)

	private Integer templateCode; // 模板代码

	private boolean autoPreventResent = false;;
	private int reSentPreventSeconds = 60 * 60 *24;

	private Map<String , Object> paramMap = new HashMap<String , Object>();
	private List<String> params = new ArrayList<String>();
	private String extend; // 扩展字段
    private String relaText;
    private boolean isControlV = false; //是否控制版本
    private String version; // 版本号

	public Integer getSendWay() {
		return sendWay;
	}

	public void setSendWay(Integer sendWay) {
		this.sendWay = sendWay;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getMsgGroup() {
		return msgGroup;
	}

	public void setMsgGroup(String msgGroup) {
		this.msgGroup = msgGroup;
	}

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public List<Integer> getLstToUserId() {
		return lstToUserId;
	}

	public void setLstToUserId(List<Integer> lstToUserId) {
		this.lstToUserId = lstToUserId;
	}

	public int getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}

	public int getDisplayGroup() {
		return displayGroup;
	}

	public void setDisplayGroup(int displayGroup) {
		this.displayGroup = displayGroup;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public int getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(int msgCode) {
		this.msgCode = msgCode;
	}

	public List<String> getTplAndroid() {
		return tplAndroid;
	}

	public void setTplAndroid(List<String> tplAndroid) {
		this.tplAndroid = tplAndroid;
	}

	public List<String> getTplIos() {
		return tplIos;
	}

	public void setTplIos(List<String> tplIos) {
		this.tplIos = tplIos;
	}

	public Integer getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(Integer templateCode) {
		this.templateCode = templateCode;
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	public boolean isAutoPreventResent() {
		return autoPreventResent;
	}

	public void setAutoPreventResent(boolean autoPreventResent) {
		this.autoPreventResent = autoPreventResent;
	}

	public int getReSentPreventSeconds() {
		return reSentPreventSeconds;
	}

	public void setReSentPreventSeconds(int reSentPreventSeconds) {
		this.reSentPreventSeconds = reSentPreventSeconds;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getRelaText() {
        return relaText;
    }

    public void setRelaText(String relaText) {
        this.relaText = relaText;
    }

    public boolean isControlV() {
        return isControlV;
    }

    public void setControlV(boolean controlV) {
        isControlV = controlV;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}