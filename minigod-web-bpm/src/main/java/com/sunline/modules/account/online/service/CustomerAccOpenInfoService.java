package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户开户详细资料表
 *
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-03-20 16:45:27
 */
public interface CustomerAccOpenInfoService {

    CustomerAccountOpenInfoEntity queryObject(String applicationId);

    /**
     * 根据流水查询唯一数据
     * @param applicationId
     * @return
     */
    CustomerAccountOpenInfoEntity queryByApplicationId(String applicationId);

    List<CustomerAccountOpenInfoEntity> queryList(Map<String, Object> map);

    List<CustomerAccountOpenInfoEntity> queryListByBean(CustomerAccountOpenInfoEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(CustomerAccountOpenInfoEntity customerAccountOpenInfo);

    int update(CustomerAccountOpenInfoEntity customerAccountOpenInfo);

    int updateNoProduct(CustomerAccountOpenInfoEntity customerAccountOpenInfo);


    int delete(String applicationId);

    int deleteBatch(String[] applicationIds);

    List<CustomerAccountOpenInfoEntity> selectDistinctChannel();

    /**
     * 验证交易帐号
     * @param entity
     * @return
     */
    int  validateTradeAccount(CustomerAccountOpenInfoEntity entity);

    /**
     * 通过证件类型和证件号码查询客户是否已提交开户
     * @param entity
     * @return
     */
    List<CustomerAccountOpenInfoEntity> isExistedOpenAccByIdCard(CustomerAccountOpenInfoEntity entity);

    CustomerAccountOpenInfoEntity findByClientId(String clientId);

    List<CustomerAccountOpenInfoEntity> queryListByApplicationId(String[] applicationIds);

    /**
     * 设置交易账号（证券交易账号、期货交易账号，。。。。。）
     * @param customerAccountOpenInfo
     * @return
     */
    int setTradeAccount(CustomerAccountOpenInfoEntity customerAccountOpenInfo);

    /**
     * 更新margin信息
     * @param customerAccountOpenInfo
     * @return
     */
    int updateMarginInfo(CustomerAccountOpenInfoEntity customerAccountOpenInfo);

    /**
     * 根据手机号查询
     * @param idCardNumber
     * @return
     */
    CustomerAccountOpenInfoEntity queryByIdCardNumber(String idCardNumber);

}
