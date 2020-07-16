package com.sunline.modules.market.helper;

import cn.hutool.core.date.DateUtil;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.market.entity.ClientMarketPackageInfoEntity;
import com.sunline.modules.market.protocol.MarketPackageProtocol;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 * @description: 行情套餐购买校验工具类
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-05-13 14:30:10
 */
public class ClientMarketPackageHelper {
    private static final Logger logger = LoggerFactory.getLogger(ClientMarketPackageHelper.class);

    /**
     * 行情套餐购买数据完整性校验
     *
     * @param protocol
     * @return
     */
    public static ResponseVO validateMarketPackageInfo(MarketPackageProtocol protocol) {
        ResponseVO responseVO = new ResponseVO();

        if (StringUtils.isBlank(protocol.getClientId())) {
            logger.error("【行情套餐购买数据完整性校验】：交易帐号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("交易帐号为空");
            return responseVO;
        }
        if (StringUtils.isBlank(protocol.getFundAccount())) {
            logger.error("【行情套餐购买数据完整性校验】：资金帐号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("资金帐号为空");
            return responseVO;
        }
        if (null == protocol.getPackageName()) {
            logger.error("【行情套餐购买数据完整性校验】：行情套餐为空");
            responseVO.setCode(-1);
            responseVO.setMessage("行情套餐为空");
            return responseVO;
        }
        if (StringUtils.isBlank(protocol.getValidityPeriod())) {
            logger.error("【行情套餐购买数据完整性校验】：套餐有效期为空");
            responseVO.setCode(-1);
            responseVO.setMessage("套餐有效期为空");
            return responseVO;
        }
        if (null == protocol.getPackagePrice()) {
            logger.error("【行情套餐购买数据完整性校验】：套餐单价为空");
            responseVO.setCode(-1);
            responseVO.setMessage("套餐单价为空");
            return responseVO;
        }
        if (null == protocol.getTotalCost()) {
            logger.error("【行情套餐购买数据完整性校验】：套餐总价为空");
            responseVO.setCode(-1);
            responseVO.setMessage("套餐总价为空");
            return responseVO;
        }
        if (null == protocol.getPackageType()) {
            logger.error("【行情套餐购买数据完整性校验】：行情类型为空");
            responseVO.setCode(-1);
            responseVO.setMessage("套餐总价为空");
            return responseVO;
        }
        if (null == protocol.getMoneyType()) {
            logger.error("【行情套餐购买数据完整性校验】：币种代码为空");
            responseVO.setCode(-1);
            responseVO.setMessage("套餐总价为空");
            return responseVO;
        }
        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        return responseVO;
    }

    /**
     * 行情套餐购买protocol to entity
     *
     * @param protocol
     * @return
     */
    public static ClientMarketPackageInfoEntity protocolToEntity(MarketPackageProtocol protocol) {
        ClientMarketPackageInfoEntity clientMarketPackageInfoEntity = new ClientMarketPackageInfoEntity();
        clientMarketPackageInfoEntity.setClientId(protocol.getClientId());
        clientMarketPackageInfoEntity.setValidityPeriod(protocol.getValidityPeriod());
        clientMarketPackageInfoEntity.setPackageType(protocol.getPackageType());
        clientMarketPackageInfoEntity.setPackageName(protocol.getPackageName());
        clientMarketPackageInfoEntity.setFundAccount(protocol.getFundAccount());
        clientMarketPackageInfoEntity.setPackagePrice(protocol.getPackagePrice());
        clientMarketPackageInfoEntity.setTotalCost(protocol.getTotalCost());
        clientMarketPackageInfoEntity.setMoneyType(protocol.getMoneyType());
        try {
            clientMarketPackageInfoEntity.setBuyDate(null == protocol.getBuyDate() ? new Date() : DateUtil.parse(protocol.getBuyDate()));
        }catch (Exception e){
            logger.info("DateUtil.parseDate Exception:",e);
            clientMarketPackageInfoEntity.setBuyDate(new Date());
        }
        return clientMarketPackageInfoEntity;
    }

}
