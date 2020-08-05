package com.sunline.modules.account.online.dao;

import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 客户开户详细资料表
 *
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-03-20 16:45:27
 */
@Mapper
public interface CustomerAccountOpenInfoDao extends BaseDao<CustomerAccountOpenInfoEntity> {

    CustomerAccountOpenInfoEntity queryByApplicationId(String applicationId);

    List<CustomerAccountOpenInfoEntity> selectSelective(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity);

    List<CustomerAccountOpenInfoEntity> selectDistinctChannel();

    int updateNoProduct(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity);

    /**
     * 验证交易帐号
     * @param entity
     * @return
     */
   int validateTradeAccount(CustomerAccountOpenInfoEntity entity);

    /**
     * 通过证件类型和证件号码查询客户是否已提交开户
     * @param entity
     * @return
     */
    List<CustomerAccountOpenInfoEntity> isExistedOpenAccByIdCard(CustomerAccountOpenInfoEntity entity);

    CustomerAccountOpenInfoEntity findByClientId(String clientId);

    List<CustomerAccountOpenInfoEntity> queryListByApplicationId(Map<String, Object> map);

    int setTradeAccount(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity);

    int updateMarginInfo(CustomerAccountOpenInfoEntity customerAccountOpenInfo);
}
