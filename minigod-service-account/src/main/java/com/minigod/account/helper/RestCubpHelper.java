package com.minigod.account.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountUserInfoReqVo;
import com.minigod.protocol.account.cubp.response.CubpOpenAccountUserInfoResVo;
import com.minigod.account.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RestCubpHelper {
    @Value("${minigod.cubp.isRemote}")
    private Boolean isRemote;

    @Value("${minigod.cubp.url}")
    private String CUBP_API_URL;

    private String VERIFY_EMAIL = "";
    private String VERIFY_PHONE = "";
    private String VERIFY_ID_CARD = "";
    private String QUERY_USERINFO_OBJ = "";
    private String FIND_DATA_DICTIONARY_BY_MARK = "";

    @PostConstruct
    private void init() {
        VERIFY_EMAIL = CUBP_API_URL + "/proxy/customer/openAccountEmailValidate";
        VERIFY_PHONE = CUBP_API_URL + "/proxy/customer/openAccountPhoneValidate";
        VERIFY_ID_CARD = CUBP_API_URL + "/proxy/customer/openAccountIdCardValidate";
        QUERY_USERINFO_OBJ = CUBP_API_URL + "/securitiesUserInfo/querySecuritiesUserInfo";
        FIND_DATA_DICTIONARY_BY_MARK = CUBP_API_URL + "/crm_api/findDataDictionaryByMark";
    }

    private ResResult connectCubp(String server, Object json) {
        if (!isRemote) {
            return ResResult.success();
        }
        try {
            String jsonStrReq = CommonUtil.getRequestJson(json);
            log.info("请求cubp传入参数：" + jsonStrReq);
            String jsonStrRes = CommonUtil.httpPost(server, jsonStrReq);
            log.info("请求cubp返回信息：" + jsonStrRes);

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
        ResResult responseResult = connectCubp(server, json);

        if (responseResult.getCode() == 0) {
            Object res = responseResult.getResult();
            log.debug("RestCubpHelper回包解析：", res);
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
        ResResult responseResult = connectCubp(server, json);
        return responseResult.getCode() == 0;
    }


    public Boolean verifyEmail(String email) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);
        return getResult(VERIFY_EMAIL, map);
    }

    public Boolean verifyPhone(String phone) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone", phone);
        return getResult(VERIFY_PHONE, map);
    }

    public Boolean verifyIdCard(String idCard) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("idNo", idCard);
        return getResult(VERIFY_ID_CARD, map);
    }

    public CubpOpenAccountUserInfoResVo selectSecuritiesUserInfo(CubpOpenAccountUserInfoReqVo reqVo) {
        return getResult(QUERY_USERINFO_OBJ, reqVo, CubpOpenAccountUserInfoResVo.class);
    }

    public List findDictionaryData(String mark) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mark", mark);
        return getResult(FIND_DATA_DICTIONARY_BY_MARK, map, List.class);
    }
}
