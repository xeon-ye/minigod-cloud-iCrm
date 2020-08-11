package com.sunline.modules.api.dao;

import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户管理
 *
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Mapper
public interface SecuritiesUserInfoDao extends BaseDao<SecuritiesUserModel> {

    /**
     * 查询证券用户列表
     *
     * @param model
     * @return
     */
    List<SecuritiesUserModel> queryList(SecuritiesUserModel model);

    /**
     * 查询证券用户信息
     *
     * @param model
     * @return
     */
    SecuritiesUserModel queryObject(SecuritiesUserModel model);

    /**
     * 查询客户是否已存在
     *
     * @param model
     * @return
     */
    List<SecuritiesUserModel> queryClient(SecuritiesUserModel model);

    /**
     * 查询客户是否不存在
     *
     * @param model
     * @return
     */
    SecuritiesUserModel queryClientInfo(SecuritiesUserModel model);

    /**
     * 查询证券用户列表
     *
     * @param model
     * @return
     */
    List<SecuritiesUserModel> queryLimitList(SecuritiesUserModel model);

    /**
     * 通过证件类型和证件号码查询客户是否已开户
     * @param model
     * @return
     */
    List<SecuritiesUserModel> isExistedOpenAccByIdCard(SecuritiesUserModel model);

    /**
     * 验证客户帐号是否是受限开户账户
     *
     * @param model
     * @return
     */
    List<SecuritiesUserModel> verifyIsRestrictOpenAccount(SecuritiesUserModel model);

    int updateByApplicationId(SecuritiesUserModel model);
}
