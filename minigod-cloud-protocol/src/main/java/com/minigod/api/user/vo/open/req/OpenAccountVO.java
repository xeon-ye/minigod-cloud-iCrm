package com.minigod.api.user.vo.open.req;

import com.minigod.api.vo.BaseVO;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2017
 * @company:
 * @date 2017/3/22 10:55
 */
public class OpenAccountVO extends BaseVO {
    private String info;

    private Long step;
    
    private String email;
    
    private Long type;

    private String userName;

    private String infoSt;

    private Integer openAccountAccessWay; // 1:H5 2:APP
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

	public Long getStep() {
		return step;
	}

	public void setStep(Long step) {
		this.step = step;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInfoSt() {
		return infoSt;
	}

	public void setInfoSt(String infoSt) {
		this.infoSt = infoSt;
	}

	public Integer getOpenAccountAccessWay() {
		return openAccountAccessWay;
	}

	public void setOpenAccountAccessWay(Integer openAccountAccessWay) {
		this.openAccountAccessWay = openAccountAccessWay;
	}
}
