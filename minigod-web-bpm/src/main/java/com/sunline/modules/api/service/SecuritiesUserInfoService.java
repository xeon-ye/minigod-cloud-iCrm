package com.sunline.modules.api.service;


import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.common.vo.ResponseVO;

import java.util.List;

/**
 *
 * @author: lcs
 * @date: 2018/5/15 16:46
 */
public interface SecuritiesUserInfoService {
    /**
     * 新增客户
     * @param request
     * @return
     */
    ResponseVO addSecuritiesUserInfo(SecuritiesUserModel request);

    /**
     * 修改客户
     * @param request
     * @return
     */
    ResponseVO modifySecuritiesUserInfo(SecuritiesUserModel request);

    /**
     * 查询客户信息
     * @param request
     * @return
     */
    ResponseVO querySecuritiesUserInfo(SecuritiesUserModel request);

    /**
     * 查询客户列表
     * @param request
     * @return
     */
    ResponseVO querySecuritiesUserInfoList(SecuritiesUserModel request);

    /**
     * 查询客户列表（匹配记录数）
     * @param request
     * @return
     */
    ResponseVO querySecuritiesUserInfoLimitList(SecuritiesUserModel request);

    /**
     * 通过证件类型和证件号码查询客户是否已开户
     * @param request
     * @return
     */
    ResponseVO isExistedOpenAccByIdCard(SecuritiesUserModel request);

    /**
     * 验证客户帐号是否是受限开户账户
     *
     * @param model
     * @return
     */
    List<SecuritiesUserModel> verifyIsRestrictOpenAccount(SecuritiesUserModel model);

    /**
     * 更新
     * @param request
     * @return
     */
    ResponseVO updateByApplicationId(SecuritiesUserModel request);
}
