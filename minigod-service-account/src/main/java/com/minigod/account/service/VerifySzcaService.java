package com.minigod.account.service;

import com.minigod.protocol.account.model.VerifyAuthCa;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.minigod.protocol.account.szca.request.SzcaCertApplyP10ReqVo;
import com.minigod.protocol.account.szca.request.SzcaCertDnReqVo;
import com.minigod.protocol.account.szca.request.SzcaPdfInfoForSignReqVo;
import com.minigod.protocol.account.szca.request.SzcaSignP7ForPdfReqVo;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.InputStream;

//@FeignClient(value = "minigod-account-service")
public interface VerifySzcaService {
     // 获取操作标示（SZCA）
    public VerifySzcaPojo getTokenBySzca();

    // 获取证书主题
    public VerifyAuthCa getCertDnBySzca(SzcaCertDnReqVo reqVo);

    // 申请证书
    public VerifyAuthCa getCertApplyP10BySzca(SzcaCertApplyP10ReqVo reqVo);

    // 备案记录合成生成PDF
    public VerifyAuthCa getSignP7ForPdfBySzca(SzcaSignP7ForPdfReqVo reqVo);

    // 针对 PDF 文件生成签名域接口-推送 pdf
    public VerifyAuthCa getPdfInfoForSignBySzca(SzcaPdfInfoForSignReqVo reqVo, InputStream fileInput);

    public void clearLocalVerifyCa(String idCard);

//    public SzcaSealPdfResVo getSealPdfBySzca(Integer userId);
}
