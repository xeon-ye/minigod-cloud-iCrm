package com.sunline.modules.common.utils;

import com.sunline.modules.common.common.CrmCommonEnum;
import org.apache.commons.lang.StringUtils;

/**
 * @description: 股票代码工具类
 * @author: Larry Lai
 * @date: 2018/12/14 17:08
 * @version: v1.0
 */

public class StockCodeUtils {
    /**
     * 返回length位股票代码，不足length位在前面补0
     *
     * @param securityCode
     * @return
     */
    public static String securityCode2String(String securityCode, int length) {
        if (securityCode.length() < length) {
            securityCode = StringUtils.leftPad(securityCode, length, '0');
        }
        return securityCode;
    }

    /**
     * 返回系统标准股票资产编号，如700 -> 00700.HK（港股）| 700 -> 000700.SZ（A股）
     *
     * @param securityCode
     * @return
     */
    public static String securityCode2AssetId(String securityCode, String exchangeType) {
        String prefix = "";
        if (CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_SEHK.getIndex().equals(exchangeType)) {
            prefix = securityCode2String(securityCode, 5);
        } else {
            prefix = securityCode;
        }

        String assetId = prefix + "." + CrmCommonEnum.SecStockTransfer.getName(exchangeType);
        return assetId;
    }
}
