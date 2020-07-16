package com.sunline.modules.common.service;

import com.sunline.modules.common.entity.StkTrdCaleEntity;

/**
 * 
 * 
 * @author lcs
 * @email 
 * @date 2018-05-25 13:50:28
 */
public interface StkTrdCaleService {

    /**
     * 通过自然日查(不同市场)上一个或下一个交易日
     * @param
     * @return
     */
     StkTrdCaleEntity getLastNextDay(String normalDate, String regionCode);
    /**
     * 通过自然日查(不同市场)周首个交易日或周最后交易日
     * @param normalDate
     * @param regionCode
     * @return normalDate,  regionCode
     */
     StkTrdCaleEntity getWkFstLstTrdDay(String normalDate, String regionCode);

    /**
     * 通过自然日查(不同市场)月首个交易日或月最后交易日
     * @param normalDate
     * @param regionCode
     * @return
     */
     StkTrdCaleEntity getMtFstLstTrdDay(String normalDate, String regionCode);
    /**
     * 通过自然日查(不同市场)年首个交易日或年最后交易日
     * @param normalDate
     * @param regionCode
     * @return
     */
     StkTrdCaleEntity getYearFstLstTrdDay(String normalDate, String regionCode);
    /**
     * 通过自然日查(不同市场)的交易日历信息
     * @param normalDate
     * @param regionCode
     * @return
     */
     StkTrdCaleEntity getTrdCale(String normalDate, String regionCode);

    /**
     * 获取交易时间段内属于交易日的天数
     * @param trdBeginDate
     * @param trdEndDate
     * @return
     */
    Integer getTrdDayNumByTrdDate(String trdBeginDate, String trdEndDate);

}
