package com.sunline.modules.hundsun.protocol.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description: 证券存入请求协议
 * @author: Larry Lai
 * @date: 2018/12/19 10:31
 * @version: v1.0
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class StockDepositRequest extends AbstractRequest {

    private static final long serialVersionUID = -5418355116992095666L;

    /**
     * 资金帐号
     */
    private String toFundAcct;

    /**
     * 证券市场[K-港交所 P-美国市场]
     */
    private String exchangeType;

    /**
     * 股票代码
     */
    private String stockCode;

    /**
     * 发生数量
     */
    private Integer occurAmount;

    /**
     * 活动编号/事件ID
     */
    private Integer eventId;

    /**
     * 业务流水号
     */
    private String businessNo;

    /**
     * 备注
     */
    private String remark;
}
