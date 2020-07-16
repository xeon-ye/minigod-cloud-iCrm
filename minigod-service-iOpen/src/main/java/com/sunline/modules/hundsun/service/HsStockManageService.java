package com.sunline.modules.hundsun.service;

import com.alibaba.fastjson.JSON;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.hundsun.protocol.request.FundRequest;
import com.sunline.modules.hundsun.protocol.request.GenericBodyRequest;
import com.sunline.modules.hundsun.protocol.request.GenericStkDepositRequest;
import com.sunline.modules.hundsun.protocol.request.StockDepositRequest;
import com.sunline.modules.hundsun.protocol.response.StockDepositResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 恒生股份业务服务管理器
 * @author: Larry Lai
 * @date: 2018/12/19 13:38
 * @version: v1.0
 */

public class HsStockManageService {

    private static final Logger logger = LoggerFactory.getLogger(HsStockManageService.class);

    private static final String SID = "2937abd404fb93d7f270742eb9c71832";
    private static final String SOURCE_MODULE = "cubp";

    /**
     * 证券存入
     *
     * @param stockDepositRequest
     * @return
     */
    public static StockDepositResponse stockDeposit(StockDepositRequest stockDepositRequest) {

        try {

            GenericStkDepositRequest<StockDepositRequest> genericStkDepositRequest = new GenericStkDepositRequest<>();
            genericStkDepositRequest.setSid(SID);
            genericStkDepositRequest.setSourceModule(SOURCE_MODULE);
            genericStkDepositRequest.setParams(stockDepositRequest);

            GenericBodyRequest<GenericStkDepositRequest> genericBodyRequest = new GenericBodyRequest<>();
            genericBodyRequest.setBody(genericStkDepositRequest);

            logger.info("证券存入接口调用参数：" + JSON.toJSONString(genericBodyRequest));

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.stock.service.api") + "trade_api/stock_reward", JSON.toJSONString(genericBodyRequest));

            logger.info("证券存入接口返回结果：" + JSON.toJSONString(response));

            return JSON.parseObject(response, StockDepositResponse.class);

        } catch (Exception e) {
            logger.error("证券存入接口调用异常：", e);
        }
        return null;
    }

    /**
     * 查询客户持仓
     *
     * @param genericRequest
     * @return
     */
    public static ResponseVO getStockInfo(GenericHsRequest<FundRequest> genericRequest) {
        try {

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.trade.service.api") + "trade/customer/getStockInfo", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("查询客户持仓异常：", e);
        }
        return null;
    }
}
