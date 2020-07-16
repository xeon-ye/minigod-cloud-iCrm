package com.sunline.modules.hundsun.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.hundsun.protocol.request.ClientFareManageRequest;
import com.sunline.modules.hundsun.protocol.request.ClientTradeFareRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @description: 恒生REST服务管理器
 * @author: Larry Lai
 * @date: 2018/8/21 15:30
 * @version: v1.0
 */

public class HsRestManageService {

    private static final Logger logger = LoggerFactory.getLogger(HsRestManageService.class);

    /**
     * 新增客户佣金套餐
     *
     * @param genericRequest
     */
    public static ResponseVO addClientFareInfo(GenericHsRequest<ClientFareManageRequest> genericRequest) {

        try {

            logger.info("新增客户免佣套餐参数：" + JSON.toJSONString(genericRequest));

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.springclound.service.api") + "customer/fare/add", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("新增[" + genericRequest.getParams().getClientId() + "]客户佣金套餐异常", e);
        }
        return null;
    }

    /**
     * 修改客户佣金套餐
     *
     * @param genericRequest
     */
    public static ResponseVO updClientFareInfo(GenericHsRequest<ClientFareManageRequest> genericRequest) {

        try {

            logger.info("修改客户免佣套餐参数：" + JSON.toJSONString(genericRequest));

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.springclound.service.api") + "customer/fare/modify", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("修改[" + genericRequest.getParams().getClientId() + "]客户佣金套餐异常", e);
        }
        return null;
    }

    /**
     * 删除客户佣金套餐
     *
     * @param genericRequest
     */
    public static ResponseVO delClientFareInfo(GenericHsRequest<ClientFareManageRequest> genericRequest) {

        try {

            logger.info("删除客户免佣套餐参数：" + JSON.toJSONString(genericRequest));

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.springclound.service.api") + "customer/fare/delete", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("删除[" + genericRequest.getParams().getClientId() + "]客户佣金套餐异常", e);
        }
        return null;
    }

    /**
     * 查询客户佣金套餐
     *
     * @param genericRequest
     */
    public static ResponseVO qryClientFareInfo(GenericHsRequest<ClientFareManageRequest> genericRequest) {

        try {

            logger.info("查询客户佣金套餐参数：" + JSON.toJSONString(genericRequest));

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.springclound.service.api") + "customer/fare/list", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("查询[" + genericRequest.getParams().getClientId() + "]客户佣金套餐异常", e);
        }
        return null;
    }

    /**
     * 设置客户交易费率，支持批量操作
     *
     * @param genericRequest
     */
    public static ResponseVO setupTradeFare(List<ClientTradeFareRequest> genericRequest) {

        try {

            JSONObject paraMap = new JSONObject();
            JSONObject params = new JSONObject();

            params.put("batchTradeFareList", genericRequest);
            paraMap.put("params", params);

            logger.info("设置客户交易费率参数：" + JSON.toJSONString(paraMap));

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.springclound.service.api") + "customer/fare/setupTradeFare", JSON.toJSONString(paraMap));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("设置交易费率异常", e);
        }
        return null;
    }

    /**
     * 查询客户交易费率（若未设置则查默认）
     *
     * @param genericRequest
     */
    public static ResponseVO qryExtClientFareInfo(GenericHsRequest<ClientFareManageRequest> genericRequest) {

        try {

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.springclound.service.api") + "customer/fare/queryConfig", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("查询[" + genericRequest.getParams().getClientId() + "]客户交易费率异常", e);
        }
        return null;
    }

    /**
     * 获取恒生柜台系统参数
     *
     * @return
     */
    public static ResponseVO getSysArg(GenericHsRequest<ClientFareManageRequest> genericRequest) {

        try {

            String response = HttpClientUtils.postJson(ConfigUtils.get("hundsun.springclound.service.api") + "sys/getSysArg", JSON.toJSONString(genericRequest));

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("获取恒生柜台系统参数异常", e);
        }
        return null;
    }
}
