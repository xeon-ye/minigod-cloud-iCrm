package com.sunline.modules.account.online.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.account.online.entity.CustomerAccountOpenImgEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户开户申请图片
 *
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-03-20 16:45:27
 */
@Mapper
public interface CustomerAccountOpenImageDao extends BaseDao<CustomerAccountOpenImgEntity> {

    /**
     * 重置修改人
     * @param applicationId
     * @return
     */
    int resetUpdateUser(String applicationId);

    /**
     * 按流水号删除图片
     * @param customerAccountOpenImgEntity
     * @return
     */
    int deleteByApplicationId(CustomerAccountOpenImgEntity customerAccountOpenImgEntity);
}
