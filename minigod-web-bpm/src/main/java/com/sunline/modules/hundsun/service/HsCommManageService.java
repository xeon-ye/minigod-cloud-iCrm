package com.sunline.modules.hundsun.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.common.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @description: 恒生通用业务服务管理器
 * @author: Larry Lai
 * @date: 2019/4/17 14:47
 * @version: v1.0
 */

public class HsCommManageService {

    private static final Logger logger = LoggerFactory.getLogger(HsCommManageService.class);

    /**
     * 通用请求发送
     *
     * @param request
     * @return
     */
    public static CommonResponse send(String url, Object request) {

        Map<String, Object> parameterMap = Maps.newHashMap();
        parameterMap.put("requestParametersData", JSON.toJSONString(request));

        String result = null;

        try {

            logger.info("HundSun Interface Request Url：" + ConfigUtils.get("hundsun.interface.service.url") + url);
            logger.info("HundSun Interface Request Info：" + JSON.toJSONString(parameterMap));

            result = HttpUtil.post(ConfigUtils.get("hundsun.interface.service.url") + url, parameterMap);

            logger.info("HundSun Interface Response Info：" + result);

            return JSON.parseObject(result, CommonResponse.class);

        } catch (Exception e) {
            logger.error("调用恒生接口异常", e);
        }

        return null;
    }

}
