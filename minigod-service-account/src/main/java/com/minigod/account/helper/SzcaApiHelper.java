//package com.minigod.account.helper;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.beust.jcommander.internal.Maps;
//import com.google.common.collect.Lists;
//import com.minigod.account.utils.SzcaHttpClient;
//import com.minigod.common.utils.ImageUtils;
//import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
//import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
//import com.minigod.protocol.account.bpm.request.BpmOpenAccountAppointmentReqVo;
//import com.minigod.protocol.account.bpm.request.BpmOpenAccountImageInfoReqVo;
//import com.minigod.protocol.account.model.CustomOpenCnImg;
//import com.minigod.protocol.account.model.CustomOpenInfo;
//import com.minigod.protocol.account.szca.request.*;
//import com.minigod.protocol.account.szca.response.*;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.bouncycastle.asn1.x500.X500Name;
//import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
//import org.bouncycastle.operator.ContentSigner;
//import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
//import org.bouncycastle.pkcs.PKCS10CertificationRequest;
//import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
//import org.bouncycastle.util.encoders.Base64;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@Service
//public class SzcaApiHelper {
//    @Resource
//    CustomOpenInfoMapper customOpenInfoMapper;
//    @Resource
//    CustomOpenCnImgMapper customOpenCnImgMapper;
//
//    @Value("${minigod.szca.isRemote}")
//    private Boolean isRemote;
//
//    @Value("${minigod.szca.orgName}")
//    private String SZCA_ORG_NAME;
//
//    @Value("${minigod.szca.orgCode}")
//    private String SZCA_ORG_CORD;
//
//    @Value("${minigod.szca.applyType}")
//    private String SZCA_ORG_APPLY_TYPE;
//
//    @Value("${minigod.szca.tokenType}")
//    private String SZCA_ORG_TOKEN_TYPE;
//
//    @Value("${minigod.szca.url}")
//    private String SZCA_API_URL;
//
//    @Value("${minigod.szca.getToken}")
//    private String API_GET_TOKEN;
//
//    @Value("${minigod.szca.getCert}")
//    private String API_GET_CERT;
//
//    @Value("${minigod.szca.getCertApplyP10}")
//    private String API_GET_CERT_APPLY_P10;
//
//    @Value("${minigod.szca.getSignP7ForPdf}")
//    private String API_GET_SIGN_P7_FOR_PDF;
//
//    @Value("${minigod.szca.getPDFInfoForSign}")
//    private String API_GET_PDF_INFO_FOR_SIGN;
//
//    private String API_GET_SEAL_PDF = "/SecuritiesAccount/service/reqGetSealPDFFile";
//
//    private String URL_GET_TOKEN = "";
//    private String URL_GET_CERT = "";
//    private String URL_GET_CERT_APPLY_P10 = "";
//    private String URL_GET_SIGN_P7_FOR_PDF = "";
//    private String URL_GET_PDF_INFO_FOR_SIGN = "";
//    private String URL_GET_SEAL_PDF = "";
//
//
//    @PostConstruct
//    private void init() {
//        URL_GET_TOKEN = SZCA_API_URL + API_GET_TOKEN;
//        URL_GET_CERT = SZCA_API_URL + API_GET_CERT;
//        URL_GET_CERT_APPLY_P10 = SZCA_API_URL + API_GET_CERT_APPLY_P10;
//        URL_GET_SIGN_P7_FOR_PDF = SZCA_API_URL + API_GET_SIGN_P7_FOR_PDF;
//        URL_GET_PDF_INFO_FOR_SIGN = SZCA_API_URL + API_GET_PDF_INFO_FOR_SIGN;
//        URL_GET_SEAL_PDF = SZCA_API_URL + API_GET_SEAL_PDF;
//    }
//
//    private <T> T getResult(String server, String key, Object data, Class<T> clazz) {
//        try {
//            Map<String, Object> reqParams = Maps.newHashMap();
//            Map<String, Object> typeParams = Maps.newHashMap();
//            typeParams.put(key, data);
//            reqParams.put("request", typeParams);
//
//            String responseResult = SzcaHttpClient.postByCharset(server, key, JSON.toJSONString(reqParams));
//
//            log.info(responseResult);
//            if (StringUtils.isNotBlank(responseResult)) {
//                return JSON.parseObject(responseResult, clazz);
//            }
//        } catch (Exception e) {
//            log.error("szcaApiHelper 接口异常：url = {}, data = {}", server, data);
//        }
//
//
//        return null;
//    }
//
//    private <T> T getResult(String server, String key, Object data, InputStream file, Class<T> clazz) {
//        try {
//            Map<String, Object> reqParams = Maps.newHashMap();
//            Map<String, Object> typeParams = Maps.newHashMap();
//            typeParams.put(key, data);
//            reqParams.put("request", typeParams);
//
//            String responseResult = SzcaHttpClient.postWithFile(server, key, JSON.toJSONString(reqParams), file);
//
//
//            if (StringUtils.isNotBlank(responseResult)) {
//                return JSON.parseObject(responseResult, clazz);
//            }
//        } catch (Exception e) {
//            log.error("szcaApiHelper 接口异常：url = {}, data = {}", server, data);
//        }
//
//        return null;
//    }
//
//    /**
//     * 获取操作标示（SZCA）
//     *
//     * @return SzcaTokenResVo
//     */
//    public SzcaTokenResVo getToken() {
//        SzcaTokenReqVo reqVo = new SzcaTokenReqVo();
//
//        reqVo.setOrgCode(SZCA_ORG_CORD);
//        reqVo.setOrgName(SZCA_ORG_NAME);
//        reqVo.setApplyType(SZCA_ORG_APPLY_TYPE);
//        reqVo.setTokenType(SZCA_ORG_TOKEN_TYPE);
//        return getResult(URL_GET_TOKEN, "token", reqVo, SzcaTokenResVo.class);
//    }
//
//    /**
//     * 获取证书主题（SZCA）
//     *
//     * @param params
//     * @return SzcaCertDnResVo
//     */
//    public SzcaCertDnResVo getCertDn(SzcaCertDnReqVo params) {
//        return getResult(URL_GET_CERT, "getCertDN", params, SzcaCertDnResVo.class);
//    }
//
//    /**
//     * 申请证书（SZCA）
//     *
//     * @param params
//     * @return SzcaCertApplyP10ResVo
//     */
//    public SzcaCertApplyP10ResVo getCertApplyP10(SzcaCertApplyP10ReqVo params) {
//        return getResult(URL_GET_CERT_APPLY_P10, "apply", params, SzcaCertApplyP10ResVo.class);
//    }
//
//    /**
//     * 备案记录合成生成PDF（SZCA）
//     *
//     * @param params
//     * @return SzcaSignP7ForPdfResVo
//     */
//    public SzcaSignP7ForPdfResVo getSignP7ForPdf(SzcaSignP7ForPdfReqVo params) {
//        return getResult(URL_GET_SIGN_P7_FOR_PDF, "sign", params, SzcaSignP7ForPdfResVo.class);
//    }
//
//    /**
//     * 针对 PDF 文件生成签名域接口-推送 pdf
//     *
//     * @param params
//     * @return SzcaPdfInfoForSignResVo
//     */
//    public SzcaPdfInfoForSignResVo getPdfInfoForSign(SzcaPdfInfoForSignReqVo params, InputStream fileInput) {
//        return getResult(URL_GET_PDF_INFO_FOR_SIGN, "getPdf", params, fileInput, SzcaPdfInfoForSignResVo.class);
//    }
//
//    /**
//     * 拉取服务器签署文件（SZCA）
//     *
//     * @param params
//     * @return SzcaSealPdfResVo
//     */
//    public SzcaSealPdfResVo getSealPdf(SzcaSealPdfReqVo params) {
//        return getResult(URL_GET_SEAL_PDF, "getPdf", params, SzcaSealPdfResVo.class);
//    }
//
//    public String parseCertDN(String dn, String type) {
//        type = type + "=";
//        String[] split = dn.split(",");
//        for (String x : split) {
//            if (x.contains(type)) {
//                x = x.trim();
//                return x.substring(type.length());
//            }
//        }
//        return null;
//    }
//
//
//    public static void main(String[] args) {
//        try {
////            {"orgName": "深圳 CA","orgCode": "723038758","tokenType": "0","applyType": "1"}
////            String URL_GET_TOKEN = "http://218.17.161.11:18008/SecuritiesAccount/service/reqGetToKenService";
////            String URL_GET_CERT = "http://218.17.161.11:18008/SecuritiesAccount/service/reqGetCertDN";
////            String URL_GET_CERT = "http://218.17.161.11:18008/SecuritiesAccount/service/reqGetCertDN";
////
////            SzcaTokenReqVo szcaTokenReqVo = new SzcaTokenReqVo();
////            szcaTokenReqVo.setOrgName("深圳 CA");
////            szcaTokenReqVo.setOrgCode("723038758");
////            szcaTokenReqVo.setTokenType("0");
////            szcaTokenReqVo.setApplyType("1");
////
////            SzcaCertDnReqVo certDnReqVo = new SzcaCertDnReqVo();
////            certDnReqVo.setToken("SDK_0_1_723038758_20200326160949949317100");
////            certDnReqVo.setIdNo("430381199312285013");
////            certDnReqVo.setUserName("周文晋");
////            certDnReqVo.setType("get");
////            certDnReqVo.setCarrier("0");
//
//
////            SzcaTokenResVo resToken = new SzcaApiHelper().getResult(URL_GET_TOKEN, "token", szcaTokenReqVo, SzcaTokenResVo.class);
////            SzcaCertDnResVo resCertDn = new SzcaApiHelper().getResult(URL_GET_CERT, "getCertDN", certDnReqVo, SzcaCertDnResVo.class);
////            SzcaCertApplyP10ResVo resApply = new SzcaApiHelper().getCertApplyP10(applyReqVo);
//
////            log.info(resToken.toString());
////            log.info(resCertDn.toString());
////            log.info(resApply.toString());
//
//        } catch (Exception e) {
//            log.error("error = ", e);
//        }
//    }
//
//}
