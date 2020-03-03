package com.minigod.api.user.vo.open.req;

import com.minigod.api.vo.BaseVO;

import java.util.Date;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2017
 * @company:
 * @date 2017/4/1 20:45
 */
public class OpenUserInfoVO extends BaseVO {

    public Integer userId;
    public String clientId;
    public Date openDate;
    public String openStatus;
    private String message;
    private String errorInfo;
    private String errorImages;

    private String requestSrc;//请求来源：ios，Android，H5

    private Integer openAccountAccessWay; // 1:H5 2:APP

   	public String getRequestSrc() {
   		return requestSrc;
   	}

   	public void setRequestSrc(String requestSrc) {
   		this.requestSrc = requestSrc;
   	}
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getErrorImages() {
		return errorImages;
	}

	public void setErrorImages(String errorImages) {
		this.errorImages = errorImages;
	}

    public Integer getOpenAccountAccessWay() {
        return openAccountAccessWay;
    }

    public void setOpenAccountAccessWay(Integer openAccountAccessWay) {
        this.openAccountAccessWay = openAccountAccessWay;
    }
}
