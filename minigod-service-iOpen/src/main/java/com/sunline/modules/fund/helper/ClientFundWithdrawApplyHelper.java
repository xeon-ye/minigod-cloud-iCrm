package com.sunline.modules.fund.helper;

import com.sunline.modules.account.online.helper.CustomerAccountOpenHelper;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import com.sunline.modules.fund.protocol.ClientFundWithdrawApplyProto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 出金申请校验工具类
 * @author: Larry Lai
 * @date: 2019/4/2 10:01
 * @version: v1.0
 */

public class ClientFundWithdrawApplyHelper {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAccountOpenHelper.class);

    /**
     * 出金申请数据完整性校验
     *
     * @param protocol
     * @return
     */
    public static ResponseVO validateClientFundWithdrawInfo(ClientFundWithdrawApplyProto protocol) {
        ResponseVO responseVO = new ResponseVO();

        if (StringUtils.isBlank(protocol.getClientId())) {
            logger.error("【出金申请数据完整性校验】：交易帐号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("客户号为空");
            return responseVO;
        }

        if (StringUtils.isBlank(protocol.getFundAccount())) {
            logger.error("【出金申请数据完整性校验】：资金帐号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("收款人名称为空");
            return responseVO;
        }

        if (StringUtils.isBlank(protocol.getClientNameSpell())) {
            logger.error("【出金申请数据完整性校验】：收款人名称为空");
            responseVO.setCode(-1);
            responseVO.setMessage("收款人名称为空");
            return responseVO;
        }

        if (null == protocol.getWithdrawType()) {
            logger.error("【出金申请数据完整性校验】：提取方式为空");
            responseVO.setCode(-1);
            responseVO.setMessage("提取方式为空");
            return responseVO;
        }

        if (StringUtils.isBlank(protocol.getBankName())) {
            logger.error("【出金申请数据完整性校验】：收款银行名称为空");
            responseVO.setCode(-1);
            responseVO.setMessage("收款银行名称为空");
            return responseVO;
        }

        if (StringUtils.isBlank(protocol.getBankNo())) {
            logger.error("【出金申请数据完整性校验】：收款银行帐户为空");
            responseVO.setCode(-1);
            responseVO.setMessage("收款银行帐户为空");
            return responseVO;
        }

        if (null == protocol.getOccurBalance() || protocol.getOccurBalance().equals(BigDecimal.ZERO)) {
            logger.error("【出金申请数据完整性校验】：提取金额为空或为0");
            responseVO.setCode(-1);
            responseVO.setMessage("提取金额为空或为0");
            return responseVO;
        }

        if (null == protocol.getFrozenBalance() || protocol.getFrozenBalance().equals(BigDecimal.ZERO)) {
            logger.error("【出金申请数据完整性校验】：提取金额为空或为0");
            responseVO.setCode(-1);
            responseVO.setMessage("提取金额为空或为0");
            return responseVO;
        }

        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        return responseVO;
    }


    public static ClientFundWithdrawApplyEntity protocolToEntity(ClientFundWithdrawApplyProto protocol) {

        ClientFundWithdrawApplyEntity entity = new ClientFundWithdrawApplyEntity();
        entity.setClientId(protocol.getClientId());
        entity.setFundAccount(protocol.getFundAccount());
        entity.setClientNameSpell(protocol.getClientNameSpell());
        entity.setWithdrawType(protocol.getWithdrawType());
        entity.setBankName(protocol.getBankName());
        entity.setBankNo(protocol.getBankNo());
        entity.setBankCode(protocol.getBankCode());
        if (StringUtils.isNotBlank(protocol.getSwiftCode())) {
            entity.setSwiftCode(protocol.getSwiftCode());
        }

        if (StringUtils.isNotBlank(protocol.getContactAddress())) {
            entity.setContactAddress(protocol.getContactAddress());
        }

        entity.setMoneyType(protocol.getMoneyType());
        entity.setOccurBalance(protocol.getOccurBalance());
        BigDecimal chargeMoney = new BigDecimal(0);
        if(protocol.getChargeMoney()!=null  && protocol.getChargeMoney().compareTo(chargeMoney)>0){
            chargeMoney = protocol.getChargeMoney();
        }
        entity.setChargeMoney(chargeMoney);
        entity.setActualBalance(protocol.getOccurBalance().subtract(chargeMoney));
        entity.setFrozenBalance(protocol.getFrozenBalance());

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
     * 按文件名排序
     *
     * @param filePath
     * @return
     */
    public static File[] orderByName(String filePath) {
        File file = new File(filePath);
        File[] files = file.listFiles();
        List fileList = Arrays.asList(files);
        fileList.sort((Comparator<File>) (o1, o2) -> {
            if (o1.isDirectory() && o2.isFile()) {
                return -1;
            } else if (o1.isFile() && o2.isDirectory()) {
                return 1;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return files;
    }
}
