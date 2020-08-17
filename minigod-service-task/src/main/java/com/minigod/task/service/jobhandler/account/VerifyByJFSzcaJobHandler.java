package com.minigod.task.service.jobhandler.account;

import com.minigod.account.service.OpenAccountOnlineService;
import com.minigod.account.service.VerifyAuthCaService;
import com.minigod.account.service.VerifyJFSzcaService;
import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
import com.minigod.persist.account.mapper.CustomOpenHkImgMapper;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.persist.account.mapper.VerifyBankCardMapper;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.enums.VerifyAuthCaStatusEnum;
import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.model.VerifyAuthCa;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * JF_CA认证
 */
@JobHandler(value = "verifyByJFSZCAJobHandler")
@Component
@Slf4j
public class VerifyByJFSzcaJobHandler extends IJobHandler {
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    CustomOpenHkImgMapper customOpenHkImgMapper;
    @Autowired
    VerifyBankCardMapper verifyBankCardMapper;
    @Autowired
    VerifyJFSzcaService verifySzcaService;
    @Autowired
    VerifyAuthCaService verifyAuthCaService;
    @Autowired
    OpenAccountOnlineService openAccountOnlineService;

    private final Integer CA_STATUS_NEED_VERIFY = CustomOpenAccountEnum.CaStatus.IS_NEED_VERIFY.getCode();


    @Value("${minigod.openAccount.isVerifyWithCa}")
    private Boolean IS_VERIFY_WITH_CA;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnT<String> execute(String param) throws Exception {
        log.info("执行【JF_CA认证】调度任务");

        //查询开户信息
        List<CustomOpenInfo> openInfoList = customOpenInfoMapper.selectByCaStatus(CA_STATUS_NEED_VERIFY);
        if (null == openInfoList || openInfoList.size() <= 0) {
            log.info("*********************【JF_CA认证】为空**************************");
            return SUCCESS;
        }

        VerifySzcaPojo verifySzcaPojo = null;

        if (IS_VERIFY_WITH_CA) {
            // step1 授权登录、获取token
            try {
                verifySzcaPojo = verifySzcaService.login();
                verifySzcaPojo = verifySzcaService.getTokenBySzca(verifySzcaPojo);
            } catch (Exception e) {
                log.error("*********************【JF_CA认证】获取token异常**************************", e);
                return FAIL;
            }

            if (verifySzcaPojo == null || StringUtils.isEmpty(verifySzcaPojo.getToken())) {
                log.error("*********************【JF_CA认证】获取token失败**************************");
                return FAIL;
            }
        }


        // TODO: CA认证多次失败逻辑处理
        for (CustomOpenInfo customOpenInfo : openInfoList) {
            Integer userId = customOpenInfo.getUserId();
            CustomOpenInfo localCustomOpenInfo = new CustomOpenInfo();

            try {
                if (IS_VERIFY_WITH_CA) {
                    List<VerifyAuthCa> verifyErrorAuthCaList = verifyAuthCaService.getErrorVerifyAuthCa(customOpenInfo.getIdCard());
                    if (verifyErrorAuthCaList.size() > 2) {
                        log.error("*********************【JF_CA认证】用户获取次数过多**************************, userId = {}", userId);
                    } else {
                        // step2 获取主题
                        verifySzcaPojo = verifySzcaService.getCertDnBySzca(verifySzcaPojo, customOpenInfo);
                        if (StringUtils.isEmpty(verifySzcaPojo.getCertDn())) {
                            log.error("*********************【JF_CA认证】获取主题失败**************************, userId = {}", userId);
                            continue;
                        }

                        // step3 申请证书(先判断否已申请证书)
                        if (!VerifyAuthCaStatusEnum.isFlag(verifySzcaPojo.getStatus(), VerifyAuthCaStatusEnum.CA_P10) || StringUtils.isEmpty(verifySzcaPojo.getCertSn())) {
                            verifySzcaPojo = verifySzcaService.getCertApplyP10BySzca(verifySzcaPojo, customOpenInfo);
                        }

                        if (StringUtils.isEmpty(verifySzcaPojo.getCertSn())) {
                            log.error("*********************【JF_CA认证】申请证书失败**************************, userId = {}", userId);
                            continue;
                        }

                        // step4 签名pdf文件
                        verifySzcaPojo = verifySzcaService.getPdfInfoForSignBySzca(verifySzcaPojo, customOpenInfo);

                        if (StringUtils.isEmpty(verifySzcaPojo.getFileId()) || StringUtils.isEmpty(verifySzcaPojo.getFileHash())) {
                            log.error("*********************【JF_CA认证】签名pdf文件失败**************************, userId = {}", userId);
                            continue;
                        }

                        // step5 备案记录合成生成 PDF 接口
                        verifySzcaPojo = verifySzcaService.getSignP7ForPdfBySzca(verifySzcaPojo, customOpenInfo);
                        if (verifySzcaPojo.getId() == null || StringUtils.isEmpty(verifySzcaPojo.getFileUrl())) {
                            log.error("*********************【JF_CA认证】备案记录合成生成PDF失败**************************, userId = {}", userId);
                            continue;
                        }
                        localCustomOpenInfo.setCaValidId(verifySzcaPojo.getId());
                    }
                }

                // 更新用户数据
                localCustomOpenInfo.setId(customOpenInfo.getId());
                localCustomOpenInfo.setCaStatus(CustomOpenAccountEnum.CaStatus.IS_NEED_PUSH.getCode());
                localCustomOpenInfo.setUpdateTime(new Date());
                customOpenInfoMapper.updateByPrimaryKeySelective(localCustomOpenInfo);

            } catch (Exception e) {
                log.error("*********************【JF_CA认证】异常**************************, userId = {}", userId);
                continue;
            }
        }

        log.info("完成【JF_CA认证】调度任务");
        return SUCCESS;

    }
}
