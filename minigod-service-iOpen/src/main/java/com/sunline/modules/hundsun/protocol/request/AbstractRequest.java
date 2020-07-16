package com.sunline.modules.hundsun.protocol.request;

import com.sunline.modules.common.pojo.rest.BaseParameter;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: 抽象请求协议
 * @author: Larry Lai
 * @date: 2018/12/19 11:07
 * @version: v1.0
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class AbstractRequest extends BaseParameter {
	private static final long serialVersionUID = -6823122211626463690L;

	private Object body;
}
