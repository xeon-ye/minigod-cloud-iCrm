package com.minigod.account.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beust.jcommander.internal.Maps;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.common.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: SZCA Http交互工具类
 * @author: Larry Lai
 * @date: 2019/12/29 14:41
 * @version: v1.0
 */

@Slf4j
public class JFSzcaHttpClient {

    private static Logger logger = LoggerFactory.getLogger(JFSzcaHttpClient.class);

    public static ResResult connectJFSzca(String server, Object json) {
        try {

            logger.info("请求 JF SZCA 传入参数：" + JSONUtil.toJson(json));
            String jsonStrRes = CommonUtil.httpPost(server, JSONUtil.toJson(json));
            logger.info("请求 JF SZCA 返回信息：" + jsonStrRes);

            if (StringUtils.isNotBlank(jsonStrRes)) {
                ResResult responseVO = JSONObject.parseObject(jsonStrRes, ResResult.class);
                return responseVO;
            } else {
                return ResResult.errorWithMessage(StaticType.MessageResource.REMOTE_REQUEST_ERROR);
            }
        } catch (Exception e) {
            logger.info("连接服务器异常！", e);
            return ResResult.errorWithMessage(StaticType.MessageResource.REMOTE_REQUEST_ERROR);
        }
    }

    public static String parseCertDN(String dn, String type) {
        type = type + "=";
        String[] split = dn.split(",");
        for (String x : split) {
            if (x.contains(type)) {
                x = x.trim();
                return x.substring(type.length());
            }
        }
        return null;
    }

    public static <T> T getResult(String server, Object data, Class<T> clazz) {
        try {
            ResResult responseResult = JFSzcaHttpClient.connectJFSzca(server, data);

            if (responseResult.getCode() == 0) {
                Object res = responseResult.getResult();
                logger.debug("JFszcaApiHelper回包解析：", res);
                if (res != null) {
                    T obj = JSON.parseObject(res.toString(), clazz);
                    if (null != obj) {
                        return obj;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("JFszcaApiHelper 接口异常：url = {}, data = {}", server, data);
        }

        return null;
    }

    public static <T> T getResultWrap(String server, Object data, Class<T> clazz) {

        Map<String, Object> req = new HashMap<String, Object>();

        req.put("version", "1.0");
        req.put("id", new Date().getTime());
        req.put("params", data);

        return getResult(server, req, clazz);

    }
}
