package com.sunline.modules.quotation.service;

import com.alibaba.fastjson.JSON;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.quotation.protocol.request.StockQuotRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 股票行情服务
 * @author: Larry Lai
 * @date: 2019/2/22 16:25
 * @version: v1.0
 */

public class StockQuotService {

    private static final Logger logger = LoggerFactory.getLogger(StockQuotService.class);

    /**
     * 查询股票实时行情
     *
     * @param genericRequest
     * @return
     */
    public static ResponseVO getStockQuot(GenericHsRequest<StockQuotRequest> genericRequest) {
        try {

            String response = HttpClientUtils.postJson(ConfigUtils.get("sunline.service.url") + "quot/findQuotNoSession", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("查询股票实时行情异常：", e);
        }
        return null;
    }
}
