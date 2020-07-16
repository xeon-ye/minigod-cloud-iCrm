package com.sunline.modules.api.service;


import com.sunline.modules.api.entity.CrmExternalCommonModel;
import com.sunline.modules.common.vo.ResponseVO;

import java.util.List;

/**
 *
 * @author: lcs
 * @date: 2018/8/12
 */
public interface UserApiService {

    /**
     * 客户状态查询
     * @param model
     * @return
     */
    ResponseVO queryUserStatus(CrmExternalCommonModel model);

    /**
     * 获取客户转仓信息
     *
     * @param model
     * @return
     */
    List<CrmExternalCommonModel> getFirstTrsTotal(CrmExternalCommonModel model);
}
