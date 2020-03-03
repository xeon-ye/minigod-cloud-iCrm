package com.minigod.security.helper;

import com.alibaba.fastjson.JSONObject;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.security.utils.CommonUtil;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


@Slf4j
@Service
public class SZCAApiHelper {
    @Value("${minigod.szca.host}")
    private String HOST;
    @Value("${minigod.szca.getToken}")
    private String GET_TOKEN;
    @Value("${minigod.szca.getCert}")
    private String GET_CERT;
    @Value("${minigod.szca.getPDFInfoForSign}")
    private String GET_PDF_INFO;

    private ResResult connectSZCA(String server, Object json) {
        return null;
    }



}
