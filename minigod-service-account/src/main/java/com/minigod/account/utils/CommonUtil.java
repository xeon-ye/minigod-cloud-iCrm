package com.minigod.account.utils;

import com.alibaba.fastjson.JSONObject;
import com.minigod.common.utils.HttpClientUtils;
import com.minigod.common.utils.JSONUtil;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommonUtil {

    public static String reaplaceJson(Object rt, Set<Long> sIds) {
        String jsonStr = JSONUtil.toJson(rt);
        // 遍历sIds，替换成"",前端不支持long18位，需替换为""
        for (Long sid : sIds) {
            //大于15位才替换
            if (sid > 100000000000000l) {
                jsonStr = jsonStr.replaceAll(":" + sid + "", ":\"" + sid + "\"");
            }
        }
        return jsonStr;
    }


    public static String getRequestJson(Map<String, Object> requestMap) {
        Map<String, Object> finalMap = new HashMap<>();
        finalMap.put("params", requestMap);
        return JSONUtil.toJson(finalMap);
    }

    public static String getRequestJson(Object requestMap) {
        Map<String, Object> finalMap = new HashMap<>();
        finalMap.put("params", requestMap);
        return JSONUtil.toJson(finalMap);
    }

    public static boolean valiedateCode(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        String code = jsonObject.get("code").toString();
        if (code.equals("0")) {
            return true;
        } else {
            return false;
        }
    }

    public static String httpPost(String url, String param) {
        return HttpClientUtils.postJson(url, param, Charset.forName("UTF-8"), true);
    }
}