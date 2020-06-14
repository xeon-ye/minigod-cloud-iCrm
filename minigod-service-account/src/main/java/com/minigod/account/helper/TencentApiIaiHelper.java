package com.minigod.account.helper;

import com.alibaba.fastjson.JSON;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TencentApiIaiHelper {
    private IaiClient IAI_CLIENT  = null;

    @Value("${minigod.tencentApi.secretId}")
    private String SECRET_ID;
    @Value("${minigod.tencentApi.secretKey}")
    private String SECRET_KEY;
    @Value("${minigod.tencentApi.region}")
    private String REGION;

    @PostConstruct
    private void init() {
        Credential cred = new Credential(SECRET_ID, SECRET_KEY);

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("iai.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        IAI_CLIENT = new IaiClient(cred, REGION, clientProfile);
    }

    // 人脸比对
    public CompareFaceResponse compareFace(String url1, String url2) {
        try {

            Map<String, Object> data = new HashMap<>();

            data.put("UrlA", url1);
            data.put("UrlB", url2);
            data.put("FaceModelVersion", "3.0");
            data.put("NeedRotateDetection", 1);

            String params = JSON.toJSONString(data);
            CompareFaceRequest req = CompareFaceRequest.fromJsonString(params, CompareFaceRequest.class);

            CompareFaceResponse resp = IAI_CLIENT.CompareFace(req);
            return resp;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    // 人脸静态活体检验
    // TODO: 照片建议宽高比请接近 3:4，需要处理
    public DetectLiveFaceResponse detectLiveFace(String url) {
        try {

            Map<String, Object> data = new HashMap<>();

            data.put("Url", url);
            data.put("FaceModelVersion", "3.0");

            String params = JSON.toJSONString(data);
            DetectLiveFaceRequest req = CompareFaceRequest.fromJsonString(params, DetectLiveFaceRequest.class);

            DetectLiveFaceResponse resp = IAI_CLIENT.DetectLiveFace(req);
            return resp;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }


}
