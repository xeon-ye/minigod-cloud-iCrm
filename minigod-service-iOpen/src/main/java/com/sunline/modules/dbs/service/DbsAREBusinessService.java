package com.sunline.modules.dbs.service;

import com.sunline.modules.fund.entity.DbsIccBankFlowEntity;
import com.sunline.modules.fund.entity.DepositBankBillFlowEntity;

public interface DbsAREBusinessService {
    /**
     * 请求查询icc相关手续费
     * @param dbsIccBankFlowEntity
     * @param createBy
     */
    boolean sendICCARE(DbsIccBankFlowEntity dbsIccBankFlowEntity, String createBy);
}
