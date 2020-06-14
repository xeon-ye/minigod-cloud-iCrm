package com.minigod.account.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.minigod.account.utils.CommonUtil;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.common.security.SignUtil;
import com.minigod.common.utils.JSONUtil;
import com.minigod.protocol.account.other.response.MinigodUserInfoResVo;
import com.minigod.protocol.account.other.response.OtherUserInfoResVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class RestProxyHelper {
    @Value("${minigod.proxy.isSyncOpen}")
    private Boolean isSyncOpen;

    @Value("${minigod.proxy.host}")
    private String PROXY_API_HOST;
    @Value("${minigod.proxy.checkUser}")
    private String INTERFACE_CHECK_USER;
    @Value("${minigod.proxy.syncData}")
    private String INTERFACE_SYNC_DATA;

    private String CHECK_USER = "";
    private String SYNC_DATA = "";


    @PostConstruct
    private void init() {
        CHECK_USER = PROXY_API_HOST + INTERFACE_CHECK_USER;
        SYNC_DATA = PROXY_API_HOST + INTERFACE_SYNC_DATA;
    }

    private ResResult connectProxy(String server, Object json) {
        try {
            log.info("请求外部系统传入参数：" + JSONUtil.toJson(json));
            String jsonStrRes = CommonUtil.httpPost(server, JSONUtil.toJson(json));
            log.info("请求外部系统返回信息：" + jsonStrRes);

            if (StringUtils.isNotBlank(jsonStrRes)) {
                ResResult responseVO = JSONObject.parseObject(jsonStrRes, ResResult.class);
                return responseVO;
            } else {
                return ResResult.errorWithMessage(StaticType.MessageResource.REMOTE_REQUEST_ERROR);
            }
        } catch (Exception e) {
            log.info("连接服务器异常！", e);
            return ResResult.errorWithMessage(StaticType.MessageResource.REMOTE_REQUEST_ERROR);
        }
    }

    private <T> T getResult(String server, Object json, Class<T> clazz) {
        ResResult responseResult = connectProxy(server, json);

        // 构建回包
        if (responseResult.getCode() == 0) {
            Object res = responseResult.getResult();
            log.debug("RestProxyHelper回包解析：", res);
            if (res != null) {
                T obj = JSON.parseObject(res.toString(), clazz);
                if (null != obj) {
                    return obj;
                }
            }
        }
        return null;
    }

    private Boolean getResult(String server, Object json) {
        ResResult responseResult = connectProxy(server, json);
        return responseResult.getCode() == 0;
    }

    public OtherUserInfoResVo checkUser(String account, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("account", account);
        map.put("password", password);
        Map<String, Object> req = new HashMap<String, Object>();

        req.put("params", map);

        return getResult(CHECK_USER, map, OtherUserInfoResVo.class);
    }

    public OtherUserInfoResVo checkUser(String session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", 1);
        map.put("sessionId", session);

        String paramsStr = SignUtil.getParams(JSONUtil.toJson(map));
        String sign = SignUtil.sign(paramsStr, session);

        Map<String, Object> req = new HashMap<String, Object>();

        req.put("version", "1.0");
        req.put("src", "h5");
        req.put("id", "1571799293451000509");
        req.put("sign", sign);
        req.put("params", map);

        MinigodUserInfoResVo res = getResult(CHECK_USER, req, MinigodUserInfoResVo.class);
        OtherUserInfoResVo realRes = new OtherUserInfoResVo();
        if (res.getUserCode() != null && res.getUserCode() > 0) {
            realRes.setThirdCode(res.getUserCode());
        }
        if (StringUtils.isNotEmpty(res.getPhoneNum())) {
            realRes.setPhoneNumber(res.getPhoneNum());
            realRes.setIsRealUser(true);
        } else {
            realRes.setIsRealUser(false);
        }
        return realRes;
    }
}
