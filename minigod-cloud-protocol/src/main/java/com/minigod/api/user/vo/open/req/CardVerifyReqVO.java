package com.minigod.api.user.vo.open.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2017
 * @company:
 * @date 2017/3/23 21:29
 */
public class CardVerifyReqVO extends SNVersion {
    private static final long serialVersionUID = 2811392079991544488L;

    private CardVerifyVO params;
    
    private String requestSrc;//请求来源：ios，Android，H5
    
    public String getRequestSrc() {
		return requestSrc;
	}

	public void setRequestSrc(String requestSrc) {
		this.requestSrc = requestSrc;
	}

    public CardVerifyVO getParams() {
        return params;
    }

    public void setParams(CardVerifyVO params) {
        this.params = params;
    }
}
