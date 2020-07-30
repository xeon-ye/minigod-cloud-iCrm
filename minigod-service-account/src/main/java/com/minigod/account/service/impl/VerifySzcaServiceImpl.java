package com.minigod.account.service.impl;

import com.minigod.account.helper.FileStorageHelper;
import com.minigod.account.service.VerifySzcaService;
import com.minigod.account.utils.SzcaHttpClient;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.verify.utils.VerifyUtil;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.persist.account.mapper.*;
import com.minigod.protocol.account.enums.VerifyAuthCaStatusEnum;
import com.minigod.protocol.account.model.VerifyAuthCa;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.minigod.protocol.account.szca.request.*;
import com.minigod.protocol.account.szca.response.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.Date;

@Slf4j
@RestController
public class VerifySzcaServiceImpl extends BaseBeanFactory implements VerifySzcaService {

    @Autowired
    VerifyAuthCaMapper verifyAuthCaMapper;
    @Autowired
    FileStorageHelper fileStorageHelper;

    @Value("${minigod.szca.orgName}")
    private String SZCA_ORG_NAME;

    @Value("${minigod.szca.orgCode}")
    private String SZCA_ORG_CORD;

    @Value("${minigod.szca.applyType}")
    private String SZCA_ORG_APPLY_TYPE;

    @Value("${minigod.szca.tokenType}")
    private String SZCA_ORG_TOKEN_TYPE;

    @Value("${minigod.szca.url}")
    private String SZCA_API_URL;

    @Value("${minigod.szca.getToken}")
    private String API_GET_TOKEN;

    @Value("${minigod.szca.getCert}")
    private String API_GET_CERT;

    @Value("${minigod.szca.getCertApplyP10}")
    private String API_GET_CERT_APPLY_P10;

    @Value("${minigod.szca.getSignP7ForPdf}")
    private String API_GET_SIGN_P7_FOR_PDF;

    @Value("${minigod.szca.getPDFInfoForSign}")
    private String API_GET_PDF_INFO_FOR_SIGN;


//    private String API_GET_SEAL_PDF = "/SecuritiesAccount/service/reqGetSealPDFFile";

    private String URL_GET_TOKEN = "";
    private String URL_GET_CERT = "";
    private String URL_GET_CERT_APPLY_P10 = "";
    private String URL_GET_SIGN_P7_FOR_PDF = "";
    private String URL_GET_PDF_INFO_FOR_SIGN = "";
//    private String URL_GET_SEAL_PDF = "";

    @PostConstruct
    private void init() {
        URL_GET_TOKEN = SZCA_API_URL + API_GET_TOKEN;
        URL_GET_CERT = SZCA_API_URL + API_GET_CERT;
        URL_GET_CERT_APPLY_P10 = SZCA_API_URL + API_GET_CERT_APPLY_P10;
        URL_GET_SIGN_P7_FOR_PDF = SZCA_API_URL + API_GET_SIGN_P7_FOR_PDF;
        URL_GET_PDF_INFO_FOR_SIGN = SZCA_API_URL + API_GET_PDF_INFO_FOR_SIGN;
//        URL_GET_SEAL_PDF = SZCA_API_URL + API_GET_SEAL_PDF;
    }

    @Override
    public VerifySzcaPojo getTokenBySzca() {
        SzcaTokenReqVo reqVo = new SzcaTokenReqVo();

        reqVo.setOrgCode(SZCA_ORG_CORD);
        reqVo.setOrgName(SZCA_ORG_NAME);
        reqVo.setApplyType(SZCA_ORG_APPLY_TYPE);
        reqVo.setTokenType(SZCA_ORG_TOKEN_TYPE);

        SzcaTokenResVo szcaTokenResVo = SzcaHttpClient.getResult(URL_GET_TOKEN, "token", reqVo, SzcaTokenResVo.class);
        VerifySzcaPojo resVo = new VerifySzcaPojo();

        // CA 已经存在用户认证信息
        if (szcaTokenResVo.getRetCode().equals("0")) {
            resVo.setToken(szcaTokenResVo.getToken());
        }

        return resVo;
    }

    @Override
    public VerifyAuthCa getCertDnBySzca(SzcaCertDnReqVo reqVo) {
        // 参数校验
        if (reqVo == null) {
            log.error("SZCA_获取主题参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String token = reqVo.getToken();
        String idCard = reqVo.getIdNo();
        String userName = reqVo.getUserName();

        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(idCard) || StringUtils.isEmpty(userName) || !VerifyUtil.isIDNo(idCard)) {
            log.error("SZCA_获取主题参数错误， reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }


        VerifyAuthCa localAuthCa = verifyAuthCaMapper.selectOneByIdCard(idCard);

        if (localAuthCa == null) {
            localAuthCa = new VerifyAuthCa();
            localAuthCa.setIdCard(idCard);
            localAuthCa.setUserName(userName);
            localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_KNOW.getCode());
            localAuthCa.setCreateTime(new Date());
            localAuthCa.setUpdateTime(new Date());

            verifyAuthCaMapper.insertSelective(localAuthCa);
        }


        // 本地记录未校验，进行SZCA远程校验
        if (localAuthCa.getStatus() == null || !VerifyAuthCaStatusEnum.isFlag(localAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_P10)) {
            SzcaCertDnResVo szcaCertDnResVo = SzcaHttpClient.getResult(URL_GET_CERT, "getCertDN", reqVo, SzcaCertDnResVo.class);

            if (szcaCertDnResVo.getRetCode().equals("0")) {
                String resState = szcaCertDnResVo.getState();
                String resCertDn = szcaCertDnResVo.getCertDN();
                String resCertSn = szcaCertDnResVo.getCertSn();


                // CA 已经存在用户认证信息
                if (resState.equals("loseCert") && StringUtils.isNotEmpty(resCertSn)) {
                    localAuthCa.setCertSn(resCertSn);
                    localAuthCa.setStatus(VerifyAuthCaStatusEnum.CA_P10.getCode());
                } else {
                    localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_START.getCode());
                }

                localAuthCa.setIdCard(idCard);
                localAuthCa.setUserName(userName);
                localAuthCa.setCertDn(resCertDn);
                localAuthCa.setUpdateTime(new Date());

                verifyAuthCaMapper.updateByPrimaryKeySelective(localAuthCa);
            }
        }

        return localAuthCa;

    }

    @Override
    public VerifyAuthCa getCertApplyP10BySzca(SzcaCertApplyP10ReqVo reqVo) {
        // 参数校验
        if (reqVo == null) {
            log.error("SZCA_申请证书参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String idCard = reqVo.getIdNo();
        String userName = reqVo.getUserName();
        String certDn = reqVo.getCertDn();

        if (StringUtils.isEmpty(idCard) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(certDn) || !VerifyUtil.isIDNo(idCard)) {
            log.error("SZCA_申请证书参数错误， reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        VerifyAuthCa localAuthCa = verifyAuthCaMapper.selectOneByIdCard(idCard);

        if (localAuthCa == null || !certDn.equals(localAuthCa.getCertDn()) || !userName.equals(localAuthCa.getUserName())) {
            // 数据异常
            log.error("SZCA_申请证书参数错误， reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        // 本地记录未校验，进行SZCA远程校验
        if (localAuthCa.getStatus() == null || !VerifyAuthCaStatusEnum.isFlag(localAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_P10)) {

            SzcaCertApplyP10ResVo szcaCertApplyP10ResVo = SzcaHttpClient.getResult(URL_GET_SIGN_P7_FOR_PDF, "apply", reqVo, SzcaCertApplyP10ResVo.class);

            if (szcaCertApplyP10ResVo.getRetCode().equals("0")) {
                localAuthCa.setCertSn(szcaCertApplyP10ResVo.getCertSn());
                localAuthCa.setStatus(VerifyAuthCaStatusEnum.CA_P10.getCode());
                localAuthCa.setUpdateTime(new Date());

                verifyAuthCaMapper.updateByPrimaryKeySelective(localAuthCa);
            }
        }

        return localAuthCa;
    }

    @Override
    public VerifyAuthCa getSignP7ForPdfBySzca(SzcaSignP7ForPdfReqVo reqVo) {
        // 参数校验
        if (reqVo == null) {
            log.error("SZCA_合成pdv参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String certDn = reqVo.getCertDn();
        String certSn = reqVo.getCertSn();
        String fileId = reqVo.getFileID();

        if (StringUtils.isEmpty(certDn)) {
            log.error("SZCA_合成pdv参数错误， reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        VerifyAuthCa localAuthCa = verifyAuthCaMapper.selectOneByCertDn(certDn);

        if (localAuthCa == null || !certDn.equals(localAuthCa.getCertDn()) || !certSn.equals(localAuthCa.getCertSn()) || !fileId.equals(localAuthCa.getFileId())) {
            log.error("SZCA_合成pdf参数错误：reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        // 本地记录未校验，进行SZCA远程校验
        if (localAuthCa.getStatus() == null || !VerifyAuthCaStatusEnum.isFlag(localAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_P7_PDF)) {
            SzcaSignP7ForPdfResVo szcaSignP7ForPdfResVo = SzcaHttpClient.getResult(URL_GET_SIGN_P7_FOR_PDF, "sign", reqVo, SzcaSignP7ForPdfResVo.class);

            if (szcaSignP7ForPdfResVo.getRetCode().equals("0")) {
                // 上传文件
                String fileName = fileId + "_" + System.currentTimeMillis() + ".pdf";
                String fileUrl = fileStorageHelper.uploadPdf(fileName, szcaSignP7ForPdfResVo.getFile());
                localAuthCa.setFilePdfUrl(fileUrl);
                localAuthCa.setStatus(VerifyAuthCaStatusEnum.CA_P7_PDF.getCode());
                localAuthCa.setUpdateTime(new Date());

                verifyAuthCaMapper.updateByPrimaryKeySelective(localAuthCa);
            }
        }

        return localAuthCa;
    }

    @Override
    public VerifyAuthCa getPdfInfoForSignBySzca(SzcaPdfInfoForSignReqVo reqVo, InputStream fileInput) {
        // 参数校验
        if (reqVo == null || fileInput == null) {
            log.error("SZCA_针对 PDF 文件生成签名域参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }


        String idCard = reqVo.getIdCode();
        String certDn = reqVo.getCertDn();
        String certSn = reqVo.getCertSn();

        if (StringUtils.isEmpty(idCard) || StringUtils.isEmpty(certDn) || StringUtils.isEmpty(certSn) || !VerifyUtil.isIDNo(idCard)) {
            log.error("SZCA_针对 PDF 文件生成签名域错误：reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        try {
            VerifyAuthCa localAuthCa = verifyAuthCaMapper.selectOneByIdCard(idCard);

            if (localAuthCa == null || !certDn.equals(localAuthCa.getCertDn()) || !certSn.equals(localAuthCa.getCertSn())) {
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
            }

            // 本地记录未校验，进行SZCA远程校验
            if (localAuthCa.getStatus() == null || !VerifyAuthCaStatusEnum.isFlag(localAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_SIGN)) {


                SzcaPdfInfoForSignResVo szcaPdfInfoForSignResVo = SzcaHttpClient.getResult(URL_GET_PDF_INFO_FOR_SIGN, "getPdf", reqVo, fileInput, SzcaPdfInfoForSignResVo.class);

                if (szcaPdfInfoForSignResVo.getRetCode().equals("0")) {

                    localAuthCa.setFileHash(szcaPdfInfoForSignResVo.getFileHash());
                    localAuthCa.setFileId(szcaPdfInfoForSignResVo.getFileID());
                    localAuthCa.setStatus(VerifyAuthCaStatusEnum.CA_SIGN.getCode());
                    localAuthCa.setUpdateTime(new Date());

                    verifyAuthCaMapper.updateByPrimaryKeySelective(localAuthCa);
                }
            }

            return localAuthCa;


        } catch (Exception e) {
        }


        return null;
    }

    @Override
    public void clearLocalVerifyCa(String idCard) {
        // 参数校验
        if (StringUtils.isEmpty(idCard)) {
            log.error("清理本地ca认证数据参数错误, idCard = ", idCard);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        verifyAuthCaMapper.deleteByIdCardAndStatusLessThan(idCard, VerifyAuthCaStatusEnum.CA_P7_PDF.getCode());
    }
}
