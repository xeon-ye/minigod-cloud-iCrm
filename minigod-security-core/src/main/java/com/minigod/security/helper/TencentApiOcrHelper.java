package com.minigod.security.helper;

import com.alibaba.fastjson.JSON;
import com.minigod.common.utils.FileUtils;
import com.minigod.common.utils.ImageUtils;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.faceid.v20180301.FaceidClient;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TencentApiOcrHelper {
    private OcrClient OCR_CLIENT = null;

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
        httpProfile.setEndpoint("ocr.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        OCR_CLIENT = new OcrClient(cred, REGION, clientProfile);
    }

    public BankCardOCRResponse getBankCardOCR(String imageUrl) {
        try {
            Map<String, Object> data = new HashMap<>();

            data.put("ImageUrl", imageUrl);

            String params = JSON.toJSONString(data);
            BankCardOCRRequest req = BankCardOCRRequest.fromJsonString(params, BankCardOCRRequest.class);

            BankCardOCRResponse resp = OCR_CLIENT.BankCardOCR(req);
            return resp;

        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public PassportOCRResponse  getPassportOCR(String imageUrl, String passportType) {
        try {
            Map<String, Object> data = new HashMap<>();

            data.put("ImageUrl", imageUrl);
            data.put("Type", passportType);

            String params = JSON.toJSONString(data);
            PassportOCRRequest req = PassportOCRRequest.fromJsonString(params, PassportOCRRequest.class);
            PassportOCRResponse  resp = OCR_CLIENT.PassportOCR(req);
            return resp;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public PermitOCRResponse getPermitOCR(String imageUrl) {
        try {
            Map<String, Object> data = new HashMap<>();

            data.put("ImageUrl", imageUrl);

            String params = JSON.toJSONString(data);
            PermitOCRRequest req = PermitOCRRequest.fromJsonString(params, PermitOCRRequest.class);

            PermitOCRResponse resp = OCR_CLIENT.PermitOCR(req);
            return resp;

        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public IDCardOCRResponse getIdCardOCR(String imageUrl, String cardSide, Object config) {
        try {
            Map<String, Object> data = new HashMap<>();

            data.put("ImageUrl", imageUrl);
            data.put("CardSide", cardSide);

            if (config != null) {
                data.put("Config", JSON.toJSONString(config));
            }

            String params = JSON.toJSONString(data);
            IDCardOCRRequest req = IDCardOCRRequest.fromJsonString(params, IDCardOCRRequest.class);

            IDCardOCRResponse resp = OCR_CLIENT.IDCardOCR(req);
            System.out.println(IDCardOCRRequest.toJsonString(resp));
            return resp;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }

}
