package com.minigod.api.jfbroker.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 10:57 2017/9/4
 * @Modified By:
 */
public class BrokerReqVo extends SNVersion{

    private static final long serialVersionUID = 8167625663691101224L;

    private String sessionId;

    private String requestSource;

    private BrokerInfoVo params;

    public BrokerInfoVo getParams() {
        return params;
    }

    public void setParams(BrokerInfoVo params) {
        this.params = params;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }
}
