package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.CustomerAccountOpenImgEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户开户申请图片
 *
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-03-20 16:45:27
 */
public interface CustomerAccOpenImageService {

    CustomerAccountOpenImgEntity queryObject(String gid);

    List<CustomerAccountOpenImgEntity> queryList(Map<String, Object> map);

    List<CustomerAccountOpenImgEntity> queryListByBean(CustomerAccountOpenImgEntity entity);

    public List<CustomerAccountOpenImgEntity> queryByAccountOpenInfoId(String customerAccountOpenInfoId);

    int queryTotal(Map<String, Object> map);

    int save(CustomerAccountOpenImgEntity customerAccountOpenImage);

    int update(CustomerAccountOpenImgEntity customerAccountOpenImage);

    int delete(String gid);

    int deleteBatch(String[] gids);

    /**
     * 重置修改人
     *
     * @param applicationId
     * @return
     */
    int resetUpdateUser(String applicationId);

    /**
     * 按流水号删除图片
     *
     * @param customerAccountOpenImgEntity
     * @return
     */
    int deleteByApplicationId(CustomerAccountOpenImgEntity customerAccountOpenImgEntity);

    /**
     * 排序
     *
     * @param customerAccountOpenImgList
     * @param openAccountAccessWay
     * @param bankType
     * @param idKind
     * @return
     */
    List<CustomerAccountOpenImgEntity> sort(List<CustomerAccountOpenImgEntity> customerAccountOpenImgList, Integer openAccountAccessWay, Integer bankType, Integer idKind);
}
