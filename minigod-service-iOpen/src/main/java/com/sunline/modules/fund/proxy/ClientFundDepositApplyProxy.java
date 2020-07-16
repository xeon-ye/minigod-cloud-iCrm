package com.sunline.modules.fund.proxy;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.common.annotation.SystemLog;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientBankCardInfoEntity;
import com.sunline.modules.fund.entity.ClientFundDepositApplicationEntity;
import com.sunline.modules.fund.helper.ClientFundDepositApplyHelper;
import com.sunline.modules.fund.protocol.ClientFundDepositApplyProto;
import com.sunline.modules.fund.service.ClientBankCardInfoService;
import com.sunline.modules.fund.service.ClientFundDepositApplicationService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 入金申请代理类
 * @author: jim
 * @date: 2019/6/2 16:57
 */

@RequestMapping(value = "proxy/fund")
@Controller
public class ClientFundDepositApplyProxy {

    private static final Logger logger = LoggerFactory.getLogger(ClientFundDepositApplyProxy.class);

    @Autowired
    private ClientFundDepositApplicationService fundDepositApplicationService;
    @Autowired
    private ClientBankCardInfoService clientBankCardInfoService;
    @Autowired
    ActModelerService actModelerService;

    /**
     * 客户入金申请提交接口
     *
     * @param request
     * @return
     */
    @RequestMapping("/clientFundDepositApply")
    @SystemLog(description = "提交入金申请")
    public
    @ResponseBody
    ResponseVO clientFundDepositApply(@RequestBody GenericSunlineRequest<ClientFundDepositApplyProto> request) {

        ResponseVO responseVO = new ResponseVO();
        ClientFundDepositApplyProto depositFundInfo = request.getParams();
        ResponseVO baseDataValidateResult = ClientFundDepositApplyHelper.validateClientFundDepositInfo(depositFundInfo);
        if (CrmCommonEnum.CodeType.ERROR.getCode() == baseDataValidateResult.getCode()) {
            return baseDataValidateResult;
        }
        ClientFundDepositApplicationEntity funDepositEntity = ClientFundDepositApplyHelper.protocolToEntity(depositFundInfo);

        String applicationId = fundDepositApplicationService.commitFundDepositApply(funDepositEntity,depositFundInfo.getDepositImage());
        if(StringUtils.isNotEmpty(applicationId)){
            logger.info("已成功接收用户"+funDepositEntity.getClientId()+"的入金申请，流水号："+applicationId);
            responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

            Map<String, Object> resultMap = Maps.newHashMap();
            resultMap.put("applicationId", applicationId);

            responseVO.setResult(resultMap);
            //星展银行跳过凭证处理
            fundDepositApplicationService.skipFundDepositImages(applicationId);
        }else {
            responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
        }
    return responseVO;
    }

    /**
     * 查询客户绑定银行卡数
     * */
    @RequestMapping("/queryBankCards")
    @SystemLog(description = "查询客户绑定银行卡数")
    public
    @ResponseBody
    ResponseVO queryBankCard(@RequestBody GenericSunlineRequest<ClientFundDepositApplyProto> request) {
        ResponseVO responseVO = new ResponseVO();

        ClientFundDepositApplyProto depositFundInfo = request.getParams();
        if(StringUtils.isEmpty(depositFundInfo.getClientId()) || StringUtils.isEmpty(depositFundInfo.getFundAccount())){
            responseVO.setCode(-1);
            responseVO.setMessage("参数缺失");
            return responseVO;
        }
        ClientBankCardInfoEntity query = new ClientBankCardInfoEntity();
        query.setClientId(depositFundInfo.getClientId());
        query.setFundAccount(depositFundInfo.getFundAccount());
        query.setStatus(1);
        query.setBankType(depositFundInfo.getDepositType());
        List<ClientBankCardInfoEntity> bankCards = clientBankCardInfoService.queryListByBean(query);
        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        responseVO.setResult(bankCards);
        return responseVO;
    }

    /**
     * 解绑银行卡
     * */
    @RequestMapping("/untieBankCard")
    @SystemLog(description = "解绑银行卡")
    public
    @ResponseBody
    ResponseVO untieBankCard(@RequestBody GenericSunlineRequest<ClientFundDepositApplyProto> request) {
        ResponseVO responseVO = new ResponseVO();

        ClientFundDepositApplyProto depositFundInfo = request.getParams();
        if(StringUtils.isEmpty(depositFundInfo.getDepositBank()) || StringUtils.isEmpty(depositFundInfo.getDepositAccount())
                || StringUtils.isEmpty(depositFundInfo.getDepositNo())){
            responseVO.setCode(-1);
            responseVO.setMessage("参数缺失");
            return responseVO;
        }
        ClientBankCardInfoEntity query = new ClientBankCardInfoEntity();
        //因为国际化的关系，优先使用depositBankCode，但不能解决国际化中文匹配问题
        if(StringUtils.isNotBlank(depositFundInfo.getDepositBankCode())){
            query.setBankCode(depositFundInfo.getDepositBankCode());
        }else{
            //query.setBankName(depositFundInfo.getDepositBank());
            query.setBankAccount(depositFundInfo.getDepositAccount());
        }
        query.setBankNo(depositFundInfo.getDepositNo());
        query.setStatus(1);
        query.setBankType(depositFundInfo.getDepositType());
        List<ClientBankCardInfoEntity> bankCards = clientBankCardInfoService.queryListByBean(query);
        if(CollectionUtil.isNotEmpty(bankCards)){
            ClientBankCardInfoEntity clientBankCardInfo = bankCards.get(0);
            clientBankCardInfo.setStatus(0);
            clientBankCardInfo.setUpdateTime(new Date());
            clientBankCardInfo.setUntiedTime(new Date());
            clientBankCardInfoService.update(clientBankCardInfo);

            responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        }else{
            responseVO.setCode(CrmCommonEnum.CodeType.ERROR.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.NONE_DATA.getMessage());
            responseVO.setResult("银行卡不存在或已解绑");
        }

        return responseVO;
    }

}
