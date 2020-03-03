/*
 * FileName: BaseReqVO.java
 * Copyright: Copyright 2014-10-23 MiniGod Tech. Co. Ltd.All right reserved.
 * Description:
 *
 */
package com.minigod.common.pojo.request;

import lombok.Data;

import java.io.Serializable;

/**
 * <code>BaseReqVO<code>请求基础实体类。
 */
@Data
public class BaseRequestParams implements Serializable {
    private static final long serialVersionUID = -5486921710717030131L;
    private String sessionId;
    private Integer userId; //通过会话找到的用户ID
    private String langKey;
}
