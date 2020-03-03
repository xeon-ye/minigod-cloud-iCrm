/**
 * @Title: DepositRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.enums.EBrkCurrencyType;
import com.minigod.api.broker.vo.req.SNRequest;

/**
 * @description 资金查询
 * 
 * @author Jimmy
 * @date 2015-3-13 下午2:56:57
 * @version v1.0
 */

public class DepositRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 币种
	private EBrkCurrencyType currency;

	public EBrkCurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(EBrkCurrencyType currency) {
		this.currency = currency;
	}
}
