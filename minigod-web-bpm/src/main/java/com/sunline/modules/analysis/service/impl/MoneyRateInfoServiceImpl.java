package com.sunline.modules.analysis.service.impl;

import cn.hutool.core.date.DateUtil;
import com.sunline.modules.analysis.dao.MoneyRateInfoDao;
import com.sunline.modules.analysis.entity.MoneyRateInfoEntity;
import com.sunline.modules.analysis.service.MoneyRateInfoService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service("moneyRateInfoService")
public class MoneyRateInfoServiceImpl implements MoneyRateInfoService {
    @Autowired
    private MoneyRateInfoDao moneyRateInfoDao;

    /**
     * 汇率查询
     *
     * @param moneyRateInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<MoneyRateInfoEntity> findPage(MoneyRateInfoEntity moneyRateInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        moneyRateInfoDao.queryList(moneyRateInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 汇率查询导出excel数据
     *
     * @param moneyRateInfoEntity
     * @return
     */
    @Override
    public List<MoneyRateInfoEntity> findMoneyRateListExcelList(MoneyRateInfoEntity moneyRateInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<MoneyRateInfoEntity> moneyRateInfoList = moneyRateInfoDao.queryList(moneyRateInfoEntity);
        return moneyRateInfoList;
    }

    @Override
    public MoneyRateInfoEntity queryObject(MoneyRateInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return moneyRateInfoDao.queryObject(entity);
    }

    /**
     * 换汇
     *
     * @param fromMoneyType
     * @param toMoneyType
     * @return
     */
    @Override
    public BigDecimal exchange(String fromMoneyType, String toMoneyType, BigDecimal amount) {
        MoneyRateInfoEntity moneyRateInfoEntity = new MoneyRateInfoEntity();
        moneyRateInfoEntity.setInitDate(DateUtil.format(new Date(), "yyyy-MM-dd"));
        moneyRateInfoEntity.setToMoneyType(toMoneyType);
        moneyRateInfoEntity.setFromMoneyType(fromMoneyType);
        MoneyRateInfoEntity moneyRateInfo = moneyRateInfoDao.queryObject(moneyRateInfoEntity);
        if (null != moneyRateInfo) {
            return amount.multiply(moneyRateInfo.getExchangeRate());
        } else {
            return new BigDecimal(0);
        }
    }


}
