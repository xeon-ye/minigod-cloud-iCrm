package com.minigod.account.service;

import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.model.VerifyAuthCa;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.minigod.protocol.account.szca.jfrequest.*;
//import org.springframework.cloud.netflix.feign.FeignClient;

import java.io.InputStream;

//@FeignClient(value = "minigod-account-service")
public interface VerifyJFSzcaService {
    // 授权登录
    public VerifySzcaPojo login();

    // 获取操作标示（SZCA）
    public VerifySzcaPojo getTokenBySzca(VerifySzcaPojo reqVo);

    // 获取证书主题
    public VerifySzcaPojo getCertDnBySzca(VerifySzcaPojo reqVo, CustomOpenInfo customOpenInfo);

    // 申请证书
    public VerifySzcaPojo getCertApplyP10BySzca(VerifySzcaPojo verifySzcaPojo, CustomOpenInfo customOpenInfo);

    // 针对 PDF 文件生成签名域接口-推送 pdf
    public VerifySzcaPojo getPdfInfoForSignBySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo customOpenInfo);

    // 备案记录合成生成PDF
    public VerifySzcaPojo getSignP7ForPdfBySzca(VerifySzcaPojo verifySzcaPojo, CustomOpenInfo customOpenInfo);


//    public SzcaSealPdfResVo getSealPdfBySzca(Integer userId);
}
