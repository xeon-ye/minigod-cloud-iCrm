package com.sunline.modules.api.dao;

import com.sunline.modules.api.entity.ChannelQueryModel;
import com.sunline.modules.api.entity.CrmExternalCommonModel;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author jim
 * @email
 * @date 2018-07-26
 */
@Mapper
public interface UserApiDao extends BaseDao<ChannelQueryModel> {

    List<CrmExternalCommonModel> queryUserStatus (CrmExternalCommonModel model);

    /**
     * 获取客户转仓信息
     *
     * @param model
     * @return
     */
    List<CrmExternalCommonModel> getFirstTrsTotal(CrmExternalCommonModel model);
}
