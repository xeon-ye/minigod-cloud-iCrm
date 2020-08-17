//package com.minigod.account.helper;
//
//import com.minigod.account.helper.FileStorageHelper;
//import com.minigod.account.service.VerifyJFSzcaService;
//import com.minigod.account.utils.JFSzcaHttpClient;
//import com.minigod.common.exception.InternalApiException;
//import com.minigod.common.pojo.StaticType;
//import com.minigod.common.verify.utils.VerifyUtil;
//import com.minigod.helper.bean.BaseBeanFactory;
//import com.minigod.persist.account.mapper.VerifyAuthCaMapper;
//import com.minigod.protocol.account.enums.VerifyAuthCaStatusEnum;
//import com.minigod.protocol.account.model.VerifyAuthCa;
//import com.minigod.protocol.account.pojo.VerifySzcaPojo;
//import com.minigod.protocol.account.szca.jfrequest.*;
//import com.minigod.protocol.account.szca.jfresponse.*;
//import com.minigod.protocol.account.szca.request.*;
//import com.minigod.protocol.account.szca.response.*;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.PostConstruct;
//import java.io.InputStream;
//import java.util.Date;
//
//@Slf4j
//@RestController
//public class SzcaJFApiHelper {
//
//    @Autowired
//    VerifyAuthCaMapper verifyAuthCaMapper;
//    @Autowired
//    FileStorageHelper fileStorageHelper;
//
//    @Value("${minigod.jfszca.userName}")
//    private String JF_JFSZCA_USER_NAME;
//
//    @Value("${minigod.jfszca.userPwd}")
//    private String JF_JFSZCA_USER_PWD;
//
//    @Value("${minigod.jfszca.url}")
//    private String JF_JFSZCA_API_URL;
//
//    @Value("${minigod.jfszca.login}")
//    private String API_LOGIN;
//
//    @Value("${minigod.jfszca.getToken}")
//    private String API_GET_TOKEN;
//
//    @Value("${minigod.jfszca.getCert}")
//    private String API_GET_CERT;
//
//    @Value("${minigod.jfszca.getCertApplyP10}")
//    private String API_GET_CERT_APPLY_P10;
//
//    @Value("${minigod.jfszca.getSignP7ForPdf}")
//    private String API_GET_SIGN_P7_FOR_PDF;
//
//    @Value("${minigod.jfszca.getPDFInfoForSign}")
//    private String API_GET_PDF_INFO_FOR_SIGN;
//
//
//    private String URL_LOGIN = "";
//    private String URL_GET_TOKEN = "";
//    private String URL_GET_CERT = "";
//    private String URL_GET_CERT_APPLY_P10 = "";
//    private String URL_GET_SIGN_P7_FOR_PDF = "";
//    private String URL_GET_PDF_INFO_FOR_SIGN = "";
//
//    @PostConstruct
//    private void init() {
//        URL_LOGIN = JF_JFSZCA_API_URL + API_LOGIN;
//        URL_GET_TOKEN = JF_JFSZCA_API_URL + API_GET_TOKEN;
//        URL_GET_CERT = JF_JFSZCA_API_URL + API_GET_CERT;
//        URL_GET_CERT_APPLY_P10 = JF_JFSZCA_API_URL + API_GET_CERT_APPLY_P10;
//        URL_GET_SIGN_P7_FOR_PDF = JF_JFSZCA_API_URL + API_GET_SIGN_P7_FOR_PDF;
//        URL_GET_PDF_INFO_FOR_SIGN = JF_JFSZCA_API_URL + API_GET_PDF_INFO_FOR_SIGN;
//    }
//
//    public VerifySzcaPojo login() {
//        JFSzcaLoginReqVo reqVo = new JFSzcaLoginReqVo();
//
//        reqVo.setUserAccount(JF_JFSZCA_USER_NAME);
//        reqVo.setUserPwd(JF_JFSZCA_USER_PWD);
//
//        JFSzcaLoginResVo jfSzcaLoginResVo = JFSzcaHttpClient.getResult(URL_LOGIN, reqVo, JFSzcaLoginResVo.class);
//        VerifySzcaPojo resVo = new VerifySzcaPojo();
//
//        if (StringUtils.isNotEmpty(jfSzcaLoginResVo.getUtoken())) {
//            resVo.setUtoken(jfSzcaLoginResVo.getUtoken());
//        }
//        // CA 已经存在用户认证信息
//
//        return resVo;
//    }
//
//    public VerifySzcaPojo getTokenBySzca(VerifySzcaPojo verifySzcaPojo) {
//        // 参数校验
//        if (verifySzcaPojo == null || StringUtils.isEmpty(verifySzcaPojo.getUtoken())) {
//            log.error("JFSZCA_获取操作标示参数错误");
//            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
//        }
//
//        JFSzcaTokenReqVo reqVo = new JFSzcaTokenReqVo();
//        reqVo.setUtoken(verifySzcaPojo.getUtoken());
//        SzcaTokenResVo szcaTokenResVo = JFSzcaHttpClient.getResultWrap(URL_GET_TOKEN, reqVo, SzcaTokenResVo.class);
//
//        // CA 已经存在用户认证信息
//        if (szcaTokenResVo.getRetCode().equals("0")) {
//            verifySzcaPojo.setToken(szcaTokenResVo.getToken());
//        }
//
//        return verifySzcaPojo;
//    }
//
//    public SzcaCertDnResVo getCertDnBySzca(JFSzcaCertDnReqVo reqVo) {
//        // 参数校验
//        if (reqVo == null) {
//            log.error("JFSZCA_获取主题参数错误");
//            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
//        }
//
//        String token = reqVo.getToken();
//        String idCard = reqVo.getIdNo();
//        String userName = reqVo.getUserName();
//
//        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(idCard) || StringUtils.isEmpty(userName) || !VerifyUtil.isIDNo(idCard)) {
//            log.error("JFSZCA_获取主题参数错误， reqVo = {}", reqVo);
//            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
//        }
//
//        // 本地记录未校验，进行SZCA远程校验
//        SzcaCertDnResVo szcaCertDnResVo = JFSzcaHttpClient.getResultWrap(URL_GET_CERT, reqVo, SzcaCertDnResVo.class);
//
//        if (szcaCertDnResVo.getRetCode().equals("0")) {
//            return szcaCertDnResVo;
//        }
//
//        return null;
//
//    }
//
//    public SzcaCertApplyP10ResVo getCertApplyP10BySzca(JFSzcaCertApplyP10ReqVo reqVo) {
//        // 参数校验
//        if (reqVo == null) {
//            log.error("JFSZCA_申请证书参数错误");
//            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
//        }
//
//        String idCard = reqVo.getIdNo();
//        String userName = reqVo.getUserName();
//        String certDn = reqVo.getCertDn();
//
//        if (StringUtils.isEmpty(idCard) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(certDn) || !VerifyUtil.isIDNo(idCard)) {
//            log.error("JFSZCA_申请证书参数错误， reqVo = {}", reqVo);
//            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
//        }
//
//        SzcaCertApplyP10ResVo szcaCertApplyP10ResVo = JFSzcaHttpClient.getResultWrap(URL_GET_CERT_APPLY_P10, reqVo, SzcaCertApplyP10ResVo.class);
//
//        if (szcaCertApplyP10ResVo.getRetCode().equals("0")) {
//            return szcaCertApplyP10ResVo;
//        }
//
//        return null;
//    }
//
//    public SzcaSignP7ForPdfResVo getSignP7ForPdfBySzca(JFSzcaSignP7ForPdfReqVo reqVo) {
//        // 参数校验
//        if (reqVo == null) {
//            log.error("JFSZCA_合成pdv参数错误");
//            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
//        }
//
//        String certDn = reqVo.getCertDn();
//
//        if (StringUtils.isEmpty(certDn)) {
//            log.error("JFSZCA_合成pdv参数错误， reqVo = {}", reqVo);
//            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
//        }
//
//        SzcaSignP7ForPdfResVo szcaSignP7ForPdfResVo = JFSzcaHttpClient.getResultWrap(URL_GET_SIGN_P7_FOR_PDF, reqVo, SzcaSignP7ForPdfResVo.class);
//
//        if (szcaSignP7ForPdfResVo.getRetCode().equals("0")) {
//            // 上传文件
//            return szcaSignP7ForPdfResVo;
//        }
//        return null;
//
//    }
//
//    public SzcaPdfInfoForSignResVo getPdfInfoForSignBySzca(JFSzcaPdfInfoForSignReqVo reqVo) {
//        // 参数校验
//        if (reqVo == null) {
//            log.error("JFSZCA_针对 PDF 文件生成签名域参数错误");
//            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
//        }
//
//        String idCard = reqVo.getIdNo();
//        String certDn = reqVo.getCertDn();
//        String certSn = reqVo.getCertSn();
//
//        if (StringUtils.isEmpty(idCard) || StringUtils.isEmpty(certDn) || StringUtils.isEmpty(certSn) || !VerifyUtil.isIDNo(idCard)) {
//            log.error("JFSZCA_针对 PDF 文件生成签名域错误：reqVo = {}", reqVo);
//            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
//        }
//
//        try {
//
//            SzcaPdfInfoForSignResVo szcaPdfInfoForSignResVo = JFSzcaHttpClient.getResultWrap(URL_GET_PDF_INFO_FOR_SIGN, reqVo, SzcaPdfInfoForSignResVo.class);
//
////                if (szcaPdfInfoForSignResVo.getRetCode().equals("0")) {
//            if (szcaPdfInfoForSignResVo != null) {
//                return szcaPdfInfoForSignResVo;
//            }
//
//            return null;
//
//
//        } catch (Exception e) {
//        }
//
//
//        return null;
//    }
//}
