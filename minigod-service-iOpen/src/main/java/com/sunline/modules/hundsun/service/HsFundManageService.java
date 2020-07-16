package com.sunline.modules.hundsun.service;

import com.alibaba.fastjson.JSON;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.hundsun.protocol.request.FundRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 恒生资金业务服务管理器
 * @author: Larry Lai
 * @date: 2018/12/13 13:57
 * @version: v1.0
 */

public class HsFundManageService {

    private static final Logger logger = LoggerFactory.getLogger(HsFundManageService.class);

    /**
     * 查询客户资金汇总
     *
     * @param genericRequest
     * @return
     */
    public static ResponseVO getFundTotal(GenericHsRequest<FundRequest> genericRequest) {
        try {

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.trade.service.api") + "trade/customer/getFundTotal", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("查询客户资金汇总异常：", e);
        }
        return null;
    }

    /**
     * 查询客户资金明细
     *
     * @param genericRequest
     * @return
     */
    public static ResponseVO getFundInfo(GenericHsRequest<FundRequest> genericRequest) {
        try {

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.trade.service.api") + "trade/customer/getFundInfo", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("查询客户资金明细异常：", e);
        }
        return null;
    }
}
