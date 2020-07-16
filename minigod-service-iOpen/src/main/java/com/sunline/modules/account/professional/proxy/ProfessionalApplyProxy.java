package com.sunline.modules.account.professional.proxy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sunline.modules.account.professional.entity.ProfessionalInvestorApplicationEntity;
import com.sunline.modules.account.professional.helper.ProfessionalApplyHelper;
import com.sunline.modules.account.professional.protocol.ProfessionalApplyProtocol;
import com.sunline.modules.account.professional.protocol.ProfessionalQueryProtocol;
import com.sunline.modules.account.professional.service.ProfessionalInvestorApplicationService;
import com.sunline.modules.analysis.entity.ClientFundCountEntity;
import com.sunline.modules.common.annotation.SystemLog;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.xxl.job.core.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@RequestMapping("proxy/professional")
@Controller
public class ProfessionalApplyProxy {
    private static final Logger logger = LoggerFactory.getLogger(ProfessionalApplyProxy.class);

    @Autowired
    ProfessionalInvestorApplicationService professionalInvestorApplicationService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;

    /**
     * 客户入金申请提交接口
     *
     * @param request
     * @return
     */
    @RequestMapping("/professionalApply")
    @SystemLog(description = "提交专业投资者申请")
    public
    @ResponseBody
    ResponseVO clientFundDepositApply(@RequestBody GenericSunlineRequest<ProfessionalApplyProtocol> request) {
        ResponseVO responseVO = new ResponseVO();
        //校验参数
        ProfessionalApplyProtocol protocol = request.getParams();
        responseVO = ProfessionalApplyHelper.validateProtocolInfo(protocol);
        if (CrmCommonEnum.CodeType.ERROR.getCode() == responseVO.getCode()) {
            return responseVO;
        }
        //protocol转entity
        ProfessionalInvestorApplicationEntity entity = ProfessionalApplyHelper.protocolToEntity(protocol);
        //保存申请信息并开启工作流
        String applicationId = professionalInvestorApplicationService.commitApply(entity, protocol.getAssetsImgs(), protocol.getAddImgs());
        if (StringUtils.isNotEmpty(applicationId)) {
            logger.info("已成功接收用户{}的专业投资者认定申请，流水号：{}", entity.getClientId(), applicationId);
            responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

            Map<String, Object> resultMap = Maps.newHashMap();
            resultMap.put("applicationId", applicationId);
            String msg = "您有新的专业投资者申请待处理，小神号:"+protocol.getUserId()+";客户账号:"+protocol.getClientId();
            professionalInvestorApplicationService.generateSendEmail("【审核通知】CUBP专业投资者",msg,SysConfigUtil.getSysConfigValue("DEALING_EMAIL_GROUP", "dealing@zszhizhu.com"));
            responseVO.setResult(resultMap);
        } else {
            responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
        }

        return responseVO;
    }


    /**
     * 查询时间段内资产最大值
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryMaxTotalAsset")
    @SystemLog(description = "查询时间段内最近资产大于800万")
    public
    @ResponseBody
    ResponseVO queryMaxTotalAsset(@RequestBody GenericSunlineRequest<ProfessionalQueryProtocol> request) {
        ProfessionalQueryProtocol params = request.getParams();
        ResponseVO responseVO = new ResponseVO();
        responseVO = ProfessionalApplyHelper.validateQueryIsFull(params);

        ClientFundCountEntity query = new ClientFundCountEntity();
        query.setClientId(params.getClientId());
//        query.setFundAccount(params.getFundAccount());
        query.setStDate(params.getStDate());
        query.setEdDate(params.getEdDate());
        ClientFundCountEntity max = professionalInvestorApplicationService.queryTotalAssetByDate(query);
        if (null != max) {
            Map<String, Object> resultMap = Maps.newHashMap();
            resultMap.put("clientId", params.getClientId());
//            resultMap.put("fundAccount", params.getFundAccount());
            resultMap.put("totalAssetsDate", max.getTradeDate());
            resultMap.put("totalAssets", max.getTotalAssets());
            responseVO.setResult(resultMap);
        }
        return responseVO;
    }

}
