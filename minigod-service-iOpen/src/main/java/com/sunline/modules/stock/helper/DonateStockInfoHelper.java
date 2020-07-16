package com.sunline.modules.stock.helper;

import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.stock.protocol.DonatedStockProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 赠股申请接口验证类
 *
 * @author lcs
 * @email
 * @date 2018-12-10 15:38:58
 */

public class DonateStockInfoHelper {

    private static final Logger logger = LoggerFactory.getLogger(DonateStockInfoHelper.class);

    /**
     * 赠股基本信息验证
     * @return
     */
    public static   ResponseVO stockInfoValidate(DonatedStockProtocol stockProtocol){
        ResponseVO responseVO = new ResponseVO();

        if (null == stockProtocol.getChannelId()) {
            logger.error("【赠股领取接口数据完整性校验】：渠道号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("渠道号为空");
            return responseVO;
        }
        if (null == stockProtocol.getUserId()) {
            logger.error("【赠股领取接口数据完整性校验】：小神号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("小神号为空");
            return responseVO;
        }
        if (null == stockProtocol.getClientId()) {
            logger.error("【赠股领取接口数据完整性校验】：客户号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("客户号为空");
            return responseVO;
        }
        if (null == stockProtocol.getClientName()) {
            logger.error("【赠股领取接口数据完整性校验】：客户名为空");
            responseVO.setCode(-1);
            responseVO.setMessage("客户名为空");
            return responseVO;
        }
        if (null == stockProtocol.getPhoneNumber()) {
            logger.error("【赠股领取接口数据完整性校验】：手机号为空");
            responseVO.setCode(-1);
            responseVO.setMessage("手机号为空");
            return responseVO;
        }
        if (null == stockProtocol.getStockCode()) {
            logger.error("【赠股领取接口数据完整性校验】：股票代码为空");
            responseVO.setCode(-1);
            responseVO.setMessage("股票代码为空");
            return responseVO;
        }
        if (null == stockProtocol.getStockName()) {
            logger.error("【赠股领取接口数据完整性校验】：股票名称为空");
            responseVO.setCode(-1);
            responseVO.setMessage("股票名称为空");
            return responseVO;
        }
        if (null == stockProtocol.getStockQuantity()) {
            logger.error("【赠股领取接口数据完整性校验】：股票数量为空");
            responseVO.setCode(-1);
            responseVO.setMessage("股票数量为空");
            return responseVO;
        }
        if (null == stockProtocol.getTotalCost()) {
            logger.error("【赠股领取接口数据完整性校验】：总成本为空");
            responseVO.setCode(-1);
            responseVO.setMessage("总成本为空");
            return responseVO;
        }
//        if (null == stockProtocol.getActivityId()) {
//            logger.error("【赠股领取接口数据完整性校验】：活动id为空");
//            responseVO.setCode(-1);
//            responseVO.setMessage("活动id为空");
//            return responseVO;
//        }
//        if (null == stockProtocol.getActivityName()) {
//            logger.error("【赠股领取接口数据完整性校验】：活动名称为空");
//            responseVO.setCode(-1);
//            responseVO.setMessage("活动名称为空");
//            return responseVO;
//        }
//        if (null == stockProtocol.getProgrammeId()) {
//            logger.error("【赠股领取接口数据完整性校验】：渠道礼包ID为空");
//            responseVO.setCode(-1);
//            responseVO.setMessage("渠道礼包ID为空");
//            return responseVO;
//        }
        if (null == stockProtocol.getReceiveTime()) {
            logger.error("【赠股领取接口数据完整性校验】：领取时间为空");
            responseVO.setCode(-1);
            responseVO.setMessage("领取时间为空");
            return responseVO;
        }
//        if (null == stockProtocol.getApplicationId()) {
//            logger.error("【赠股领取接口数据完整性校验】：流水号为空");
//            responseVO.setCode(-1);
//            responseVO.setMessage("流水号为空");
//            return responseVO;
//        }

        responseVO.setCode(0);
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        return responseVO;
    }

}
