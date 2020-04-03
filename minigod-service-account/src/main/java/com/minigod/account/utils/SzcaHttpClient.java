package com.minigod.account.utils;

import com.alibaba.fastjson.JSON;
import com.beust.jcommander.internal.Maps;
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
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @description: SZCA Http交互工具类
 * @author: Larry Lai
 * @date: 2019/12/29 14:41
 * @version: v1.0
 */

@Slf4j
public class SzcaHttpClient {

    private static Logger logger = LoggerFactory.getLogger(SzcaHttpClient.class);

    private static final String BOUNDARY_VALUE = "----WebKitFormBoundarygcGV4Lxb9RAMOsVq";

    /**
     * post请求，指定UTF-8编码方式
     *
     * @param url
     * @param key
     * @param params
     * @return
     */
    public static String postByCharset(String url, String key, String params) {
        try {


            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.setCharset(Charset.forName("UTF-8"));
            builder.setBoundary(BOUNDARY_VALUE);

            builder.addTextBody(key, params, ContentType.create("multipart/form-data", Charset.forName("UTF-8")));
            HttpPost request = new HttpPost(url);
            request.addHeader("Content-Type", "multipart/form-data; boundary=" + BOUNDARY_VALUE);

            HttpEntity multipart = builder.build();
            request.setEntity(multipart);

            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity, "UTF-8");

        } catch (Exception e) {
            logger.error("SZCA Post请求异常", e);
        }

        return null;
    }

    /**
     * post请求，指定UTF-8编码方式
     *
     * @param url
     * @param key
     * @param params
     * @return
     */
    public static String postWithFile(String url, String key, String params, InputStream fileInput) {
        try {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setBoundary(BOUNDARY_VALUE);
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.setCharset(Charset.forName("UTF-8"));

            builder.addTextBody(key, params, ContentType.create("multipart/form-data", Charset.forName("UTF-8")));
            builder.addBinaryBody("file", fileInput, ContentType.APPLICATION_OCTET_STREAM, "pdfupload");

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(url);
            request.addHeader("Content-Type", "multipart/form-data; boundary=" + BOUNDARY_VALUE);

            HttpEntity multipart = builder.build();
            request.setEntity(multipart);

            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity, "UTF-8");

        } catch (Exception e) {
            logger.error("SZCA Post请求异常", e);
        }

        return null;
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

    public static <T> T getResult(String server, String key, Object data, Class<T> clazz) {
        try {
            Map<String, Object> reqParams = Maps.newHashMap();
            Map<String, Object> typeParams = Maps.newHashMap();
            typeParams.put(key, data);
            reqParams.put("request", typeParams);

            String responseResult = SzcaHttpClient.postByCharset(server, key, JSON.toJSONString(reqParams));

            log.info(responseResult);
            if (StringUtils.isNotBlank(responseResult)) {
                return JSON.parseObject(responseResult, clazz);
            }
        } catch (Exception e) {
            log.error("szcaApiHelper 接口异常：url = {}, data = {}", server, data);
        }


        return null;
    }

    public static <T> T getResult(String server, String key, Object data, InputStream file, Class<T> clazz) {
        try {
            Map<String, Object> reqParams = Maps.newHashMap();
            Map<String, Object> typeParams = Maps.newHashMap();
            typeParams.put(key, data);
            reqParams.put("request", typeParams);

            String responseResult = SzcaHttpClient.postWithFile(server, key, JSON.toJSONString(reqParams), file);


            if (StringUtils.isNotBlank(responseResult)) {
                return JSON.parseObject(responseResult, clazz);
            }
        } catch (Exception e) {
            log.error("szcaApiHelper 接口异常：url = {}, data = {}", server, data);
        }

        return null;
    }
}
