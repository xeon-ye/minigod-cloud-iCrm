package com.minigod.account.helper;

import com.minigod.common.pojo.response.ResResult;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


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
