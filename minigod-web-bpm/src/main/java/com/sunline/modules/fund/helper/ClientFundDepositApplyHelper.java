package com.sunline.modules.fund.helper;

import cn.hutool.core.date.DateUtil;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.utils.SpringContextUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientFundDepositApplicationEntity;
import com.sunline.modules.fund.protocol.ClientFundDepositApplyProto;
import com.sunline.modules.sys.entity.CodeEntity;
import com.sunline.modules.sys.service.CodeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * @description: 入金申请校验工具类
 * @author: jim
 * @date: 2019/6/2 10:01
 */

public class ClientFundDepositApplyHelper {

    private static final Logger logger = LoggerFactory.getLogger(ClientFundDepositApplyHelper.class);

    /**
     * 入金申请数据完整性校验
     *
     * @param protocol
     * @return
     */
    public static ResponseVO validateClientFundDepositInfo(ClientFundDepositApplyProto protocol) {
        ResponseVO responseVO = new ResponseVO();
//        if (null == protocol.getAppId()) {
//            logger.error("【入金申请数据完整性校验】：App主键码为空");
//            responseVO.setCode(-1);
//            responseVO.setMessage("主键码为空");
//            return responseVO;
//        }

        if (StringUtils.isBlank(protocol.getClientId())) {
            logger.error("【入金申请数据完整性校验】：交易帐号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("交易帐号为空");
            return responseVO;
        }

        if (StringUtils.isBlank(protocol.getFundAccount())) {
            logger.error("【入金申请数据完整性校验】：资金帐号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("资金帐号为空");
            return responseVO;
        }

        if (null == protocol.getDepositType()) {
            logger.error("【入金申请数据完整性校验】：入金方式为空");
            responseVO.setCode(-1);
            responseVO.setMessage("入金方式为空");
            return responseVO;
        }
        if (null == protocol.getRemittanceType()) {
            logger.error("【入金申请数据完整性校验】：汇款方式为空");
            responseVO.setCode(-1);
            responseVO.setMessage("汇款方式为空");
            return responseVO;
        }

        if (StringUtils.isBlank(protocol.getMoneyType())) {
            logger.error("【入金申请数据完整性校验】：币种代码为空");
            responseVO.setCode(-1);
            responseVO.setMessage("币种代码为空");
            return responseVO;
        }

        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        return responseVO;
    }


    public static ClientFundDepositApplicationEntity protocolToEntity(ClientFundDepositApplyProto protocol) {
        ClientFundDepositApplicationEntity entity = new ClientFundDepositApplicationEntity();
        entity.setClientId(protocol.getClientId());
        entity.setFundAccount(protocol.getFundAccount());
        entity.setMoneyType(protocol.getMoneyType());
        entity.setRemittanceType(protocol.getRemittanceType());
        entity.setMoneyType(protocol.getMoneyType());
        entity.setDepositBank(protocol.getDepositBank());
        entity.setDepositAccount(protocol.getDepositAccount());
        entity.setDepositNo(protocol.getDepositNo());
        entity.setDepositBankCode(protocol.getDepositBankCode());

        //根据benefitBankCode设置
        String benefitBankCode = protocol.getBenefitBankCode();
        if(StringUtils.isNotBlank(benefitBankCode)){
            benefitBankCode = benefitBankCode.trim();
        }else{
            benefitBankCode="";
        }
        String entBenefitCode="";
        CodeService codeService = (CodeService) SpringContextUtils.getBean("codeService");
        List<CodeEntity> codeEntities = codeService.queryChildsByMark("FUND_DEPOSIT_BANK_EN","1");
        for(CodeEntity code:codeEntities){
            if(benefitBankCode.equals(code.getName())){
                entBenefitCode = code.getValue();
                break;
            }
        }
        //这里benefitBank暂时取数值，如果需要保持国际化一致的话，可优化为用户传的值，以benefitCode来作为筛选条件
        entity.setBenefitBank(entBenefitCode);
        entity.setBenefitBankCode(entBenefitCode);
        entity.setBenefitAccount(protocol.getBenefitAccount());
        entity.setBenefitNo(protocol.getBenefitNo());
        entity.setDepositType(protocol.getDepositType());
        entity.setDepositBalance(protocol.getDepositBalance());
        if (StringUtils.isNotBlank(protocol.getSwiftCode())) {
            entity.setSwiftCode(protocol.getSwiftCode());
        }
        if (StringUtils.isNotBlank(protocol.getContactAddress())) {
            entity.setContactAddress(protocol.getContactAddress());
        }
        try {
            entity.setApplicationTime(null == protocol.getApplicationTime() ? new Date() : DateUtil.parse(protocol.getApplicationTime()));
        }catch (Exception e){
            entity.setApplicationTime(new Date());
        }

        return entity;

    }

    /**
     * 校验流程对象数据是否完整
     *
     * @param processTaskDto
     * @return
     */
    public static boolean validateProcessTaskDtoIsFull(ProcessTaskDto processTaskDto) {

        if (StringUtils.isEmpty(processTaskDto.getTaskId())) {
            logger.error("任务ID不能为空");
            return false;
        }
        if (StringUtils.isEmpty(processTaskDto.getDefId())) {
            logger.error("流程定义ID不能为空");
            return false;
        }
        if (StringUtils.isEmpty(processTaskDto.getInstanceId())) {
            logger.error("实例ID不能为空");
            return false;
        }
        if (StringUtils.isEmpty(processTaskDto.getBusId())) {
            logger.error("业务ID不能为空");
            return false;
        }

        return true;
    }


}
