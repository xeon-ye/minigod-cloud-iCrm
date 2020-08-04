package com.sunline.modules.fund.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.fund.entity.HsCompanyBankEntity;

import java.util.List;
import java.util.Map;

/**
 * 恒生公司银行帐号信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-04-23 14:13:44
 */
public interface HsCompanyBankService {

    HsCompanyBankEntity queryObject(Long id);

    List<HsCompanyBankEntity> queryList(Map<String, Object> map);

    List<HsCompanyBankEntity> queryListByBean(HsCompanyBankEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(HsCompanyBankEntity hsCompanyBank);

    int update(HsCompanyBankEntity hsCompanyBank);

    int delete(Long id);

    int deleteBatch(Long[] ids);

    /**
     * 分页查询
     *
     * @param queryCondition
     * @param pageNum
     * @return
     */
    Page<HsCompanyBankEntity> findPage(HsCompanyBankEntity queryCondition, int pageNum);
}
