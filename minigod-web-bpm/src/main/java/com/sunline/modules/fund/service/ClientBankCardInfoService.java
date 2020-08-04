package com.sunline.modules.fund.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.fund.entity.ClientBankCardInfoEntity;

import java.util.List;
import java.util.Map;

;

/**
 * 银行卡管理记录表
 *
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */
public interface ClientBankCardInfoService {

    ClientBankCardInfoEntity queryObject(Long id);

    List<ClientBankCardInfoEntity> queryList(Map<String, Object> map);

    List<ClientBankCardInfoEntity> queryListByBean(ClientBankCardInfoEntity entity);

    Page<ClientBankCardInfoEntity> findPage(ClientBankCardInfoEntity entity, int pageNum);

    int queryTotal(Map<String, Object> map);

    int save(ClientBankCardInfoEntity clientBankCardInfo);

    int update(ClientBankCardInfoEntity clientBankCardInfo);

    int delete(Long id);

    int deleteBatch(Long[] ids);
}
