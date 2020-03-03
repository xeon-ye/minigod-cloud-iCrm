package com.minigod.common.pojo.request;

/**
 * 定义请求参数基本格式
 * 
 * @param <T>
 */
public class BaseRequest<T extends BaseRequestParams> extends BaseRequestWrap {
	private static final long serialVersionUID = 1130168780595854934L;
	
	private T params;
	//
	public T getParams() {
		return params;
	}
	public void setParams(T params) {
		this.params = params;
	}

}
