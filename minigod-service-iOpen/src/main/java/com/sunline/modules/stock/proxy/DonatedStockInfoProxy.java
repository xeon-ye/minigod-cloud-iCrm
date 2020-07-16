package com.sunline.modules.stock.proxy;


import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Maps;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.utils.ActUtils;
import com.sunline.modules.common.annotation.SystemLog;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.stock.entity.DonatedStockApplicationInfoEntity;
import com.sunline.modules.stock.helper.DonateStockInfoHelper;
import com.sunline.modules.stock.protocol.DonatedStockProtocol;
import com.sunline.modules.stock.service.DonatedStockApplicationInfoService;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 赠股申请接口
 *
 * @author lcs
 * @email
 * @date 2018-12-10 15:38:58
 */

@Controller
@RequestMapping(value = "proxy/donatedStockInfo")
public class DonatedStockInfoProxy {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DonatedStockApplicationInfoService donatedStockInfoService;

    @Autowired
    ActModelerService actModelerService;

    private final String DONATED_STOCK_FLOW_MODEL_KEY = "donatedStock";

    /**
     * 赠股申请接口
     *
     * @param request
     * @return
     */
    @RequestMapping("/saveDonatedStockInfo")
    @SystemLog(description = "提交赠股申请")
    @Transactional(rollbackFor = Exception.class)
    public
    @ResponseBody
    ResponseVO saveDonatedStockInfo(@RequestBody(required = false) GenericSunlineRequest<DonatedStockProtocol> request) {

        ResponseVO responseVO = new ResponseVO();
        DonatedStockProtocol protocol = request.getParams();
        ResponseVO validateResultVo = DonateStockInfoHelper.stockInfoValidate(protocol);

        if (CrmCommonEnum.CodeType.ERROR.getCode() == validateResultVo.getCode()) {
            return validateResultVo;
        }

        DonatedStockApplicationInfoEntity params = new DonatedStockApplicationInfoEntity();

        try {

            params.setUserId(protocol.getUserId());
            params.setApplicationId(protocol.getApplicationId());
            params.setChannelId(protocol.getChannelId());
            params.setClientId(protocol.getClientId());
            params.setClientName(protocol.getClientName());
            params.setPhoneNumber(protocol.getPhoneNumber());
            params.setStockCode(protocol.getStockCode());
            params.setStockName(protocol.getStockName());
            params.setStockQuantity(protocol.getStockQuantity());
            params.setTotalCost(protocol.getTotalCost());
            params.setActivityId(protocol.getActivityId());
            params.setActivityName(protocol.getActivityName());
            params.setProgrammeId(protocol.getProgrammeId());
            params.setReceiveTime(DateUtil.parse(protocol.getReceiveTime()));
            params.setCurrentNode("提交");
            params.setActivType(protocol.getActivType());

            int count = donatedStockInfoService.save(params);

            if (count > 0) {
                //启动工作审批流
                ProcessDefinition customerAccountOpenProcessDefinition = ActUtils.getlastProcessDefinition(DONATED_STOCK_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(customerAccountOpenProcessDefinition.getId());
                processTaskDto.setBusId(params.getApplicationId());
                processTaskDto.setActKey(customerAccountOpenProcessDefinition.getKey());
                processTaskDto.setNodeType("2");

                actModelerService.startFlow(processTaskDto);

                Map<String, Object> resultMap = Maps.newHashMap();
                resultMap.put("applicationId", params.getApplicationId());

                responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
                responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
                responseVO.setResult(resultMap);

                return responseVO;
            }

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("赠股信息保存失败", e);
            responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(e.getMessage());
            return responseVO;
        }

        responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
        return responseVO;
    }
}
