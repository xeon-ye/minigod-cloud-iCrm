package com.minigod.common.pojo.request;

import lombok.Data;

/**
 * 定义请求参数基本格式
 *
 * @param <T>
 */

@Data
public class BaseRequest<T extends BaseRequestParams> extends BaseRequestWrap {
    private static final long serialVersionUID = 1130168780595854934L;
    private T params;
}
