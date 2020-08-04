package com.sunline.modules.customer.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.customer.entity.TmkCustomerEntity;
import com.sunline.modules.group.entity.ClientGroupMemberInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 电销客户管理信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-11-23 10:17:43
 */
public interface TmkCustomerService {

    TmkCustomerEntity queryObject(Long id);

    List<TmkCustomerEntity> queryList(Map<String, Object> map);

    List<TmkCustomerEntity> queryListByBean(TmkCustomerEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(TmkCustomerEntity telemarketingCustomerManageInfo);

    int update(TmkCustomerEntity telemarketingCustomerManageInfo);

    int delete(Long id);

    int deleteBatch(Long[] ids);

    Page<TmkCustomerEntity> findPage(TmkCustomerEntity tmkCustomerEntity, int pageNum);
}
