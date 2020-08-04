package com.sunline.modules.account.professional.helper;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.sunline.modules.account.professional.entity.ProfessionalInvestorApplicationEntity;
import com.sunline.modules.account.professional.protocol.ProfessionalApplyProtocol;
import com.sunline.modules.account.professional.protocol.ProfessionalQueryProtocol;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.vo.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @description: 专业投资者申请工具类
 * @author: jim
 * @date: 2019/12/07 14:34
 */

public class ProfessionalApplyHelper {
    private static final Logger logger = LoggerFactory.getLogger(ProfessionalApplyHelper.class);

    /**
     * 专业认定者申请申请数据完整性校验
     *
     * @param protocol
     * @return
     */
    public static ResponseVO validateProtocolInfo(ProfessionalApplyProtocol protocol) {
        ResponseVO responseVO = new ResponseVO();

        if (null == protocol.getUserId()) {
            logger.error("【专业投资者申请数据完整性校验】：小神号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("小神号为空");
            return responseVO;
        }

        if (StringUtils.isBlank(protocol.getClientId())) {
            logger.error("【专业投资者申请数据完整性校验】：交易帐号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("交易帐号为空");
            return responseVO;
        }

        if (StringUtils.isBlank(protocol.getFundAccount())) {
            logger.error("【专业投资者申请数据完整性校验】：资金帐号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("资金帐号为空");
            return responseVO;
        }

        if (StringUtils.isBlank(protocol.getPortfolios())) {
            logger.error("【专业投资者申请数据完整性校验】：资产组合为空");
            responseVO.setCode(-1);
            responseVO.setMessage("资产组合为空");
            return responseVO;
        }
        BigDecimal totalAssets = protocol.getTotalAssets();
        if (null == totalAssets) {
            totalAssets = new BigDecimal(0);
        }
        if (0 < new BigDecimal(8000000).subtract(totalAssets).intValue()) {
            if (CollectionUtil.isEmpty(protocol.getAssetsImgs())) {
                logger.error("【专业投资者申请数据完整性校验】：资产证明为空");
                responseVO.setCode(-1);
                responseVO.setMessage("资产证明为空");
                return responseVO;
            }
        }

        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        return responseVO;
    }

    /**
     * protocol to entry
     */
    public static ProfessionalInvestorApplicationEntity protocolToEntity(ProfessionalApplyProtocol protocol) {
        ProfessionalInvestorApplicationEntity entry = new ProfessionalInvestorApplicationEntity();
        entry.setUserId(protocol.getUserId());
        entry.setClientId(protocol.getClientId());
        entry.setFundAccount(protocol.getFundAccount());
        entry.setPortfolios(protocol.getPortfolios());
        entry.setTotalAssets(protocol.getTotalAssets());
        if (StringUtils.isNotBlank(protocol.getTotalAssetsDate())) {
            entry.setTotalAssetsDate(DateUtil.parse(protocol.getTotalAssetsDate()));
        }
        entry.setApplyTime(null == protocol.getApplicationTime() ? new Date() : DateUtil.parse(protocol.getApplicationTime()));
        return entry;
    }

    /**
     * 校验流程对象数据是否完整
     *
     * @param processTaskDto
     * @return
     */
    public static boolean validateProcessTaskDtoIsFull(ProcessTaskDto processTaskDto) {

        if (StringUtils.isEmpty(processTaskDto.getTaskId())) {
            throw new MyException("任务ID不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getDefId())) {
            throw new MyException("流程定义ID不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getInstanceId())) {
            throw new MyException("实例ID不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getBusId())) {
            throw new MyException("业务ID不能为空");
        }

        return true;
    }

    /**
     * 校验查询最大资产条件
     *
     * @param protocol
     * @return
     */
    public static ResponseVO validateQueryIsFull(ProfessionalQueryProtocol protocol) {

        ResponseVO responseVO = new ResponseVO();
        if (StringUtils.isEmpty(protocol.getClientId())) {
            logger.error("【最大资产查询数据完整性校验】：交易帐号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("交易帐号为空");
            return responseVO;
        }
//        if (StringUtils.isEmpty(protocol.getFundAccount())) {
//            logger.error("【最大资产查询数据完整性校验】：资金帐号为空");
//            responseVO.setCode(-1);
//            responseVO.setMessage("资金帐号为空");
//            return responseVO;
//        }
        if (StringUtils.isEmpty(protocol.getStDate())) {
            logger.error("【最大资产查询数据完整性校验】：开始日期为空");
            responseVO.setCode(-1);
            responseVO.setMessage("开始日期为空");
            return responseVO;
        }
        if (StringUtils.isEmpty(protocol.getEdDate())) {
            logger.error("【最大资产查询数据完整性校验】：结束日期为空");
            responseVO.setCode(-1);
            responseVO.setMessage("结束日期为空");
            return responseVO;
        }

        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        return responseVO;
    }
}
