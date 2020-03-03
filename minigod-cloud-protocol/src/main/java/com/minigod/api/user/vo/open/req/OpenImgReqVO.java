package com.minigod.api.user.vo.open.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2017
 * @company:
 * @date 2017/3/22 11:24
 */
public class OpenImgReqVO extends SNVersion {
    private static final long serialVersionUID = 1L;
    private OpenImgVO params;

    private String requestSrc;//交易来源：ios，Android，H5

    public String getRequestSrc() {
		return requestSrc;
	}

	public void setRequestSrc(String requestSrc) {
		this.requestSrc = requestSrc;
	}
    
    public OpenImgVO getParams() {
        return params;
    }

    public void setParams(OpenImgVO params) {
        this.params = params;
    }
}
