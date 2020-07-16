package com.sunline.modules.fund.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.fund.dao.HsCompanyBankDao;
import com.sunline.modules.fund.entity.HsCompanyBankEntity;
import com.sunline.modules.fund.service.HsCompanyBankService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 恒生公司银行帐号信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-04-23 14:13:44
 */

@Service("hsCompanyBankService")
public class HsCompanyBankServiceImpl implements HsCompanyBankService {
    @Autowired
    private HsCompanyBankDao hsCompanyBankDao;

    @Override
    public HsCompanyBankEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return hsCompanyBankDao.queryObject(id);
    }

    @Override
    public List<HsCompanyBankEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return hsCompanyBankDao.queryList(map);
    }

    @Override
    public List<HsCompanyBankEntity> queryListByBean(HsCompanyBankEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return hsCompanyBankDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return hsCompanyBankDao.queryTotal(map);
    }

    @Override
    public int save(HsCompanyBankEntity hsCompanyBank) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        hsCompanyBank.setId(Utils.uuid());
        return hsCompanyBankDao.save(hsCompanyBank);
    }

    @Override
    public int update(HsCompanyBankEntity hsCompanyBank) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return hsCompanyBankDao.update(hsCompanyBank);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return hsCompanyBankDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return hsCompanyBankDao.deleteBatch(ids);
    }

    /**
     * 分页查询
     *
     * @param queryCondition
     * @param pageNum
     * @return
     */
    @Override
    public Page<HsCompanyBankEntity> findPage(HsCompanyBankEntity queryCondition, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        hsCompanyBankDao.queryList(queryCondition);
        return PageHelper.endPage();
    }

}
