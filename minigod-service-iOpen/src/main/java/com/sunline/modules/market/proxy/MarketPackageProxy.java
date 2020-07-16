package com.sunline.modules.market.proxy;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.annotation.SystemLog;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.hundsun.protocol.request.FundCashFetchRequest;
import com.sunline.modules.hundsun.service.HsCommManageService;
import com.sunline.modules.market.entity.ClientMarketPackageInfoEntity;
import com.sunline.modules.market.helper.ClientMarketPackageHelper;
import com.sunline.modules.market.protocol.MarketPackageProtocol;
import com.sunline.modules.market.service.ClientMarketPackageInfoService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 行情套餐购买代理类
 *
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-05-13 11:30:10
 */
@RequestMapping(value = "proxy/marketPackage")
@Controller
public class MarketPackageProxy {

    private static final Logger logger = LoggerFactory.getLogger(MarketPackageProxy.class);

    /**
     * 金额格式化
     */
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00#");

    @Autowired
    private ClientMarketPackageInfoService clientMarketPackageInfoService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;
    @Autowired
    private SecUserInfoService secUserInfoService;

    /**
     * 行情购买提交接口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/buy", method = {RequestMethod.POST})
    @SystemLog(description = "提交行情购买申请")
    public
    @ResponseBody
    ResponseVO clientFundWithdrawApply(@RequestBody GenericSunlineRequest<MarketPackageProtocol> request) {

        logger.info("行情套餐购买：proxy/marketPackage/buy 参数：" + JSON.toJSONString(request));

        ResponseVO responseVO = new ResponseVO();

        MarketPackageProtocol marketPackage = request.getParams();

        // 交易数据完整性
        ResponseVO baseDataValidateResult = ClientMarketPackageHelper.validateMarketPackageInfo(marketPackage);
        if (CrmCommonEnum.CodeType.ERROR.getCode() == baseDataValidateResult.getCode()) {
            return baseDataValidateResult;
        }
        Map<String, Object> resultMap = Maps.newHashMap();
        ClientMarketPackageInfoEntity clientMarketPackageInfoEntity = ClientMarketPackageHelper.protocolToEntity(marketPackage);
        try {
            clientMarketPackageInfoEntity.setHsBankId(SysConfigUtil.getSysConfigValue("MARKET_PACKAGE_HS_BANK_ID", ""));
            clientMarketPackageInfoEntity.setHsBankAccount(SysConfigUtil.getSysConfigValue("MARKET_PACKAGE_HS_BANK", ""));
            clientMarketPackageInfoEntity = clientMarketPackageInfoService.commitMarketPackage(clientMarketPackageInfoEntity);
            resultMap.put("applicationId", clientMarketPackageInfoEntity.getApplicationId());

            //资金扣除
            CommonResponse response = fundCashFetch(clientMarketPackageInfoEntity);
            if (null != response && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(response.getCommonErrorCode().getErrorCode())) {
                logger.info("客户[" + clientMarketPackageInfoEntity.getClientId() + "]购买行情套餐" + clientMarketPackageInfoEntity.getPackageName() + "X"
                        + clientMarketPackageInfoEntity.getValidityPeriod() + "]已成功扣款" + clientMarketPackageInfoEntity.getTotalCost());
                clientMarketPackageInfoEntity.setDeductionStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
                resultMap.put("buyStatus", BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
                responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
                responseVO.setMessage("行情购买信息已成功接收");
                //扣款成功发送短信
                List<String> paramList = Lists.newArrayList();
                paramList.add(CodeUtils.getCodeName("MARKET_TYPE_FRONT", String.valueOf(clientMarketPackageInfoEntity.getPackageName())));
                //暂定只有港币交易
                paramList.add(String.valueOf(clientMarketPackageInfoEntity.getTotalCost()) + "HKD");
                generateSendSms(2010, clientMarketPackageInfoEntity.getPhoneNumber(), paramList);
                SecuritiesUserInfoEntity query = new SecuritiesUserInfoEntity();
                query.setTradeAccount(clientMarketPackageInfoEntity.getClientId());
                query.setFundAccount(clientMarketPackageInfoEntity.getFundAccount());
                SecuritiesUserInfoEntity userInfoEntity = secUserInfoService.queryObject(query);
                String customerName = "未知姓名";
                if (null != userInfoEntity) {
                    customerName = null == userInfoEntity.getClientName() ? userInfoEntity.getClientNameSpell() : userInfoEntity.getClientName();
                }
                generateSendEmail(customerName, clientMarketPackageInfoEntity.getClientId()
                        , CodeUtils.getCodeName("MARKET_TYPE_FRONT", String.valueOf(clientMarketPackageInfoEntity.getPackageName()))
                        , DECIMAL_FORMAT.format(clientMarketPackageInfoEntity.getTotalCost()));
            } else {
                responseVO.setCode(-1001);
                responseVO.setMessage(response.getCommonErrorCode().getErrorMsg());
                logger.info("行情套餐购买资金扣款失败：" + JSON.toJSONString(request));
                clientMarketPackageInfoEntity.setDeductionStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED_VALUE);
                resultMap.put("buyStatus", BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED_VALUE);
                clientMarketPackageInfoService.generateSendEmail(clientMarketPackageInfoEntity.getApplicationId(), response.getCommonErrorCode().getErrorMsg());
            }
        } catch (Exception e) {
            logger.error("行情套餐购买失败", e);
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            clientMarketPackageInfoEntity.setDeductionStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED_VALUE);
            clientMarketPackageInfoService.generateSendEmail(clientMarketPackageInfoEntity.getApplicationId(), e.getMessage());
        }
        responseVO.setResult(resultMap);
        clientMarketPackageInfoEntity.setUpdateTime(new Date());
        clientMarketPackageInfoService.update(clientMarketPackageInfoEntity);
        return responseVO;
    }

    /**
     * 资金取出
     *
     * @param packageInfo
     * @return
     */
    private CommonResponse fundCashFetch(ClientMarketPackageInfoEntity packageInfo) {
        FundCashFetchRequest fundCashFetchRequest = setRemark(packageInfo.getPackageName());
        fundCashFetchRequest.setActionIn(1);
        fundCashFetchRequest.setAuditAction("1");
        fundCashFetchRequest.setClientId(packageInfo.getClientId());
        fundCashFetchRequest.setFundAccount(Integer.parseInt(packageInfo.getFundAccount()));
        fundCashFetchRequest.setPassword("");
        fundCashFetchRequest.setMoneyType(packageInfo.getMoneyType());
        fundCashFetchRequest.setOccurbalance(packageInfo.getTotalCost());
        fundCashFetchRequest.setValueDate(Integer.valueOf(DateUtil.format(packageInfo.getBuyDate(), "yyyyMMdd")));
        fundCashFetchRequest.setFeeMoneyType(packageInfo.getMoneyType());
        fundCashFetchRequest.setPassword("");
        fundCashFetchRequest.setBusinessFlagReal(0);
        fundCashFetchRequest.setTheThird("0");
        fundCashFetchRequest.setExStatus("1");
        fundCashFetchRequest.setOverdraftForcedFlag("0");
        fundCashFetchRequest.setBankId(packageInfo.getHsBankId());
        fundCashFetchRequest.setBankAccount(packageInfo.getHsBankAccount());

        return HsCommManageService.send("hundsunProxyService/fundCashFetch.do", fundCashFetchRequest);
    }

    private boolean generateSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {
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
            messageSendInfoEntity.setMessageTitle("购买行情扣费成功通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("购买行情扣费成功通知异常", e);
        }

        return false;
    }

    private void generateSendEmail(String name, String clientId, String packageType, String amount) {
        try {
            MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
            messageSendInfoEntity.setRecipients(SysConfigUtil.getSysConfigValue("SETTL_DEPART_GROUP", "michellelau@zszhizhu.com;settl_dept@zszhizhu.com"));
            messageSendInfoEntity.setMessageTitle("行情购买通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            StringBuffer content = new StringBuffer();
            content.append("客户").append(name)
                    .append("，客户号").append(clientId)
                    .append("，于").append(DateUtil.today())
                    .append("购买").append(packageType)
                    .append("，扣款").append(amount)
                    .append("HKD，请知悉。");
            messageSendInfoEntity.setMessageContent(content.toString());
            messageSendInfoEntity.setContentType(0);

            messageSendInfoService.save(messageSendInfoEntity);
        } catch (Exception e) {
            logger.error("购买行情扣费成功电邮通知异常", e);
        }

    }

    private FundCashFetchRequest setRemark(int packageType) {
        FundCashFetchRequest fundCashFetchRequest = new FundCashFetchRequest();
        switch (packageType) {
            case 1:
                fundCashFetchRequest.setRemark("OMD-Standard");
                fundCashFetchRequest.setLocaleRemark("国际标准版");
                break;
            case 2:
                fundCashFetchRequest.setRemark("OMD-Mainland mobile");
                fundCashFetchRequest.setLocaleRemark("内地优惠手机版");
                break;
            case 3:
                fundCashFetchRequest.setRemark("OMD-Mainland plus");
                fundCashFetchRequest.setLocaleRemark("内地优惠升级版");
                break;
            default:
        }
        return fundCashFetchRequest;
    }

}
