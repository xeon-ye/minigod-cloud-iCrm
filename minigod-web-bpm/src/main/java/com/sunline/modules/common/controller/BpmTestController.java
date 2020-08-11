package com.sunline.modules.common.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.account.online.hundsun.UserInfo;
import com.sunline.modules.account.online.hundsun.UserStockAccount;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.account.online.service.impl.HundsunOpenAccountService;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.protocol.SecuritiesUserInfoProto;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.PdfboxUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.hundsun.protocol.request.ClientFareManageRequest;
import com.sunline.modules.hundsun.protocol.response.SysArgResponse;
import com.sunline.modules.hundsun.service.HsCommManageService;
import com.sunline.modules.hundsun.service.HsRestManageService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * @description: BPM辅助功能
 * @author: Larry Lai
 * @date: 2018/10/23 10:33
 * @version: v1.0
 */

@RequestMapping("/bpm_test")
@Controller
public class BpmTestController {

    private static final Logger logger = LoggerFactory.getLogger(BpmTestController.class);

    @Autowired
    ProcessEngine processEngine;
    @Autowired
    HistoryService historyService;
    @Autowired
    CustomerAccOpenReportGenerate customerAccOpenReportGenerate;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;
    @Autowired
    HundsunOpenAccountService hundsunOpenAccountService;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    CustomerAccOpenService customerAccountOpenService;
    @Autowired
    CustomerAccOpenService customerAccOpenService;
    @Autowired
    MessageSendInfoService messageSendInfoService;
    @Autowired
    private CustomerAccOpenInfoService customerAccOpenInfoService;
    @Autowired
    private SecUserInfoService secUserInfoService;

    /**
     * 手动生成开户pdf文件
     *
     * @param request
     * @return reportType-类型 applicationId-预约号
     */
    @RequestMapping("/generateReport")
    @ResponseBody
    public ResponseVO generateReport(HttpServletRequest request, HttpServletResponse response) {

        ResponseVO responseVO = new ResponseVO();

        try {

            BpmCommonEnum.AccountOpenReport reportType = null;
            String applicationId = request.getParameter("applicationId");

            if ("1".equals(request.getParameter("reportType"))) {
                reportType = BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_FORM_REPORT;
            } else if ("2".equals(request.getParameter("reportType"))) {
                reportType = BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_W8_REPORT;
            } else if ("3".equals(request.getParameter("reportType"))) {
                reportType = BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT;
            } else if ("4".equals(request.getParameter("reportType"))) {
                reportType = BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT;
            }

            customerAccOpenReportGenerate.generateReport(applicationId, reportType);

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("手动生成开户pdf文件异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }

    /**
     * 手动恒生后台开户
     *
     * @param request  applicationId-预约号
     * @param response
     * @return
     */
    @RequestMapping(value = "/hundsundOpenAccount")
    public
    @ResponseBody
    ResponseVO hundsundOpenAccount(HttpServletRequest request, HttpServletResponse response) {
        ResponseVO responseVO = new ResponseVO();

        try {

            hundsunOpenAccountService.doOpenAccount(request.getParameter("applicationId"));

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("手动恒生后台开户异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }

    /**
     * 手动驱动工作流下一步
     *
     * @param request  applicationId-预约号 instanceId-流程ID
     * @param response
     * @return
     */
    @RequestMapping(value = "/doNextFlow")
    public
    @ResponseBody
    ResponseVO doNextFlow(HttpServletRequest request, HttpServletResponse response) {
        ResponseVO responseVO = new ResponseVO();

        try {

            actModelerService.doNextFlow(request.getParameter("applicationId"), request.getParameter("instanceId"), "");

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("手动驱动工作流下一步异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }

    /**
     * 手动备份开户资料
     *
     * @param request  applicationId-预约号 clientId-客户号
     * @param response
     * @return
     */
    @RequestMapping(value = "/openAccountBackup")
    public
    @ResponseBody
    ResponseVO openAccountBackup(HttpServletRequest request, HttpServletResponse response) {
        ResponseVO responseVO = new ResponseVO();

        try {

            customerAccountOpenService.backupAccountOpenImage(request.getParameter("clientId"), request.getParameter("applicationId"));
            customerAccountOpenService.backupAccountOpenReport(request.getParameter("clientId"), request.getParameter("applicationId"));

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("手动备份开户资料异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }


    /**
     * 手动生成开户pdf文件
     *
     * @param request
     * @return reportType-类型 applicationId-预约号
     * 一次生成10个一样的
     */
    @RequestMapping("/generateReports")
    @ResponseBody
    public ResponseVO generateReports(HttpServletRequest request, HttpServletResponse response) {

        ResponseVO responseVO = new ResponseVO();

        try {

            BpmCommonEnum.AccountOpenReport reportType = null;
            String applicationId = request.getParameter("applicationId");

            if ("1".equals(request.getParameter("reportType"))) {
                reportType = BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_FORM_REPORT;
            } else if ("2".equals(request.getParameter("reportType"))) {
                reportType = BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_W8_REPORT;
            } else if ("3".equals(request.getParameter("reportType"))) {
                reportType = BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT;
            } else if ("4".equals(request.getParameter("reportType"))) {
                reportType = BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT;
            }

            customerAccOpenReportGenerate.generateReport(applicationId, reportType);

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("手动生成开户pdf文件异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }

    /**
     * 合并pdf文件
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/mergePdf")
    @ResponseBody
    public ResponseVO mergePdf(HttpServletRequest request, HttpServletResponse response) {

        ResponseVO responseVO = new ResponseVO();

        try {

            String applicationId = request.getParameter("applicationId");
            String accountOpenUserReportRootPath = CustomerAccOpenReportGenerate.getAccountOpenUserReportRootPath(applicationId);
            File[] files = new File[0];

            String pdfMergePath = ConfigUtils.get("openAccount.user.report.userForm") + applicationId + "/" + ConfigUtils.get("ca.open.account.file.url") + ".pdf";

            if (FileUtil.exist(pdfMergePath)) {
                FileUtil.del(new File(pdfMergePath));
            }

            try {
                files = FileUtil.ls(accountOpenUserReportRootPath);
            } catch (Exception e) {
                logger.error("Not directory", e);
            }

            List<String> pdfPaths = Lists.newArrayList();

            if (!files[0].getPath().contains("开户表格")) {
                for (File file : files) {
                    if (file.getPath().contains("开户表格")) {
                        pdfPaths.add(file.getPath().replace("\\", "/"));
                    }
                }
                for (File file : files) {
                    if (!file.getPath().contains("开户表格")) {
                        pdfPaths.add(file.getPath().replace("\\", "/"));
                    }
                }
            } else {
                for (File file : files) {
                    pdfPaths.add(file.getPath().replace("\\", "/"));
                }
            }

            PdfboxUtils.mergePdfFiles(pdfPaths.toArray(new String[pdfPaths.size()]), pdfMergePath);

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("合并pdf文件异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }

    /**
     * 开户邮件/短信
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/openEmailSend")
    public
    @ResponseBody
    ResponseVO openEmailSend(HttpServletRequest request, HttpServletResponse response) {
        ResponseVO responseVO = new ResponseVO();

        try {

            String applicationIdStr = "2019033110000047,2019041110000335,2019041610000322,2019041710000378,2019041610000330,2019041610000311,2019041210000031,2019041610000318,2019041610000325,2019041610000337,2019041610000331,2019041610000321,2019041410000134,2019041610000338,2019041610000339,2019041710000350,2019041710000355,2019041710000370,2019041710000365,2019041610000340,2019041710000351,2019041810000009,2019041710000392,2019041710000348,2019041710000352,2019041710000366,2019041710000345,2019041710000380,2019041610000320,2019041610000309,2019041710000386,2019041710000396,2019041710000353,2019041710000368,2019041710000395,2019041810000002,2019041810000004,2019041810000005,2019041710000358,2019041710000360,2019041710000349,2019041710000367,2019041710000371,2019041710000372,2019041710000384,2019041710000385,2019041710000001,2019041710000391,2019041810000003,2019041710000381,2019041710000390,2019041810000001,2019041610000335,2019041710000387,2019041710000393,2019041710000389,2019041810000013,2019041810000008,2019041710000388,2019041710000363,2019041610000324,2019041810000021,2019041510000215,2019041610000333,2019041610000342";
            String[] applicationIds = applicationIdStr.split(",");

            for (String applicationId : applicationIds) {

                AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo = customerAccOpenService.findByApplicationId(applicationId);

                List<String> paramList = Lists.newArrayList();

                // 生成开户成功短信/邮件通知
                if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_SUCCESS_VALUE == accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getApplicationStatus()
                        || BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_OPEN_ACCOUNT_VALUE == accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getApplicationStatus()) {
                    // 发送邮件通知
                    customerAccOpenService.sendAccountOpenEmail(accountOpenApplicationDetailInfo);

                    paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() != null && !"".equals(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName()) ?
                            accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() : accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientNameSpell());
                    paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientId());
                    paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getInitialAccountPassword());

                    generateOpenAccRetSendSms(1105, accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getPhoneNumber(), paramList);
                }
            }

            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("开户邮件/短信补发异常", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        return responseVO;
    }

    /**
     * 生成短信发送数据
     *
     * @param phoneNumber
     * @param paramList
     * @param templateCode
     * @return
     */
    private boolean generateOpenAccRetSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {

        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("userType", 1);
            paraMap.put("sendType", 0);
            paraMap.put("phone", phoneNumber);
            paraMap.put("params", paramList);
            paraMap.put("templateCode", templateCode);

            MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS_VALUE);
            messageSendInfoEntity.setRecipients(ConfigUtils.get("message.center.sms.url"));
            messageSendInfoEntity.setMessageTitle("宝新证券账户开户申请");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);

            // 开户文件
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("开户短信发送异常", e);
        }

        return false;
    }

    /**
     * 开通港股/美股帐户
     *
     * @param request
     * @return
     */
    @RequestMapping("/createStockAccount")
    public
    @ResponseBody
    ResponseVO createStockAccount(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {

        ResponseVO responseVO = new ResponseVO();

        try {

            FileReader fileReader = new FileReader("client_ids.txt");

            List<String> result = fileReader.readLines();

            for (String clientId : result) {

                CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccOpenInfoService.findByClientId(clientId);

                UserStockAccount.UserStockAccountCreateRequest userStockAccountCreateRequest = new UserStockAccount.UserStockAccountCreateRequest();

                if (null != customerAccountOpenInfo) {
                    userStockAccountCreateRequest.setClientID(customerAccountOpenInfo.getClientId());
                    userStockAccountCreateRequest.setFundAccount(Integer.valueOf(customerAccountOpenInfo.getFundAccount()));
                    userStockAccountCreateRequest.setHolderName(customerAccountOpenInfo.getClientName());
                    userStockAccountCreateRequest.setStockAccount(customerAccountOpenInfo.getFundAccount());
                    userStockAccountCreateRequest.setIdKind(customerAccountOpenInfo.getIdKind().toString());
                    userStockAccountCreateRequest.setIdNo(customerAccountOpenInfo.getIdNo());
                    userStockAccountCreateRequest.setExchangeType(CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_US.getIndex());
                } else {
                    SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();
                    securitiesUserModel.setTradeAccount(clientId);
                    ResponseVO vo = securitiesUserInfoService.querySecuritiesUserInfo(securitiesUserModel);
                    SecuritiesUserModel securitiesUserInfo = (SecuritiesUserModel) vo.getResult();

                    userStockAccountCreateRequest.setClientID(securitiesUserInfo.getTradeAccount());
                    userStockAccountCreateRequest.setFundAccount(Integer.valueOf(securitiesUserInfo.getFundAccount()));
                    userStockAccountCreateRequest.setHolderName(securitiesUserInfo.getClientName());
                    userStockAccountCreateRequest.setStockAccount(securitiesUserInfo.getFundAccount());
                    userStockAccountCreateRequest.setIdKind(securitiesUserInfo.getIdKind().toString());
                    userStockAccountCreateRequest.setIdNo(securitiesUserInfo.getIdNo());
                    userStockAccountCreateRequest.setExchangeType(CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_US.getIndex());
                }

                CommonResponse response = HsCommManageService.send("hundsunProxyService/createStockAccount.do", userStockAccountCreateRequest);

                if (null != response && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(response.getCommonErrorCode().getErrorCode())) {
                    logger.info("客户[" + clientId + "]美股交易权限已成功开通");
                } else {
                    logger.info("客户[" + clientId + "]美股交易权限开通失败，原因：" + JSON.toJSONString(response));
                }
            }

            responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

            return responseVO;

        } catch (Exception e) {
            logger.error("[bpm_api]开通港股/美股帐户异常", e);
        }

        return responseVO;
    }


    /**
     * 更新恒生柜台客户资料
     *
     * @param request
     * @return
     */
    @RequestMapping("/updateHsClientInfo")
    public
    @ResponseBody
    ResponseVO updateHsClientInfo(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {

        ResponseVO responseVO = new ResponseVO();

        try {

            FileReader fileReader = new FileReader("client_ids.txt");

            List<String> clientList = fileReader.readLines();

            for (String clientId : clientList) {

                SecuritiesUserInfoEntity query = new SecuritiesUserInfoEntity();
                query.setTradeAccount(clientId);
                SecuritiesUserInfoEntity userInfoEntity = secUserInfoService.queryObject(query);
                if (null == userInfoEntity) {
                    responseVO.setMessage("该用户不存在，tradeAccount：" + query.getTradeAccount());
                } else {
                    ResponseVO sysArg = HsRestManageService.getSysArg(new GenericHsRequest<ClientFareManageRequest>());
                    if (null != sysArg && CrmCommonEnum.CodeType.OK.getCode() == sysArg.getCode()) {
                        SysArgResponse result = JSON.parseObject(JSON.toJSONString(sysArg.getResult()), SysArgResponse.class);
                        if ("6".equals(result.getSysStatus()) || "0".equals(result.getBankStatus())) {
                            responseVO.setMessage("清算时间段内，无法使用该功能");
                        } else {
                            //修改柜台资料
                            UserInfo.AddressOperateRequest updateRequest = new UserInfo.AddressOperateRequest();
                            updateRequest.setActionIn(1);
                            updateRequest.setAddressID(userInfoEntity.getAddressId());
                            updateRequest.setClientID(userInfoEntity.getTradeAccount());
                            updateRequest.setEmail(userInfoEntity.getEmail());

                            updateRequest.setAddressee(userInfoEntity.getClientName());
                            updateRequest.setShortName(userInfoEntity.getContactAddress());
                            updateRequest.setMobile(userInfoEntity.getPhoneNumber());
                            updateRequest.setPhone(userInfoEntity.getPhoneNumber());
                            updateRequest.setLocaleName(userInfoEntity.getClientName());
                            updateRequest.setLocaleAddress1(userInfoEntity.getContactProvinceName());
                            updateRequest.setLocaleAddress2(userInfoEntity.getContactCityName());
                            updateRequest.setLocaleAddress3(userInfoEntity.getContactCountyName());
                            updateRequest.setLocaleAddress4(userInfoEntity.getContactDetailAddress());

                            CommonResponse hsResponse = HsCommManageService.send("hundsunProxyService/manageAddress.do", updateRequest);

                            if (null != hsResponse && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(hsResponse.getCommonErrorCode().getErrorCode())) {
                                responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
                                responseVO.setMessage("修改成功");
                            }
                        }
                    }
                }
            }

            return responseVO;

        } catch (Exception e) {
            logger.error("[bpm_api]更新恒生柜台客户资料异常", e);
        }

        return responseVO;
    }

}
