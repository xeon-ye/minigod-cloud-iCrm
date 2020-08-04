package com.sunline.modules.account.online.service.impl;

import com.google.common.collect.Lists;
import com.sunline.modules.account.online.dao.CustomerAccountOpenImageDao;
import com.sunline.modules.account.online.entity.CustomerAccountOpenImgEntity;
import com.sunline.modules.account.online.service.CustomerAccOpenImageService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("customerAccountOpenImageService")
public class CustomerAccOpenImageServiceImpl implements CustomerAccOpenImageService {
    @Autowired
    private CustomerAccountOpenImageDao customerAccountOpenImageDao;

    @Override
    public CustomerAccountOpenImgEntity queryObject(String gid) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.queryObject(gid);
    }

    @Override
    public List<CustomerAccountOpenImgEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.queryList(map);
    }

    @Override
    public List<CustomerAccountOpenImgEntity> queryListByBean(CustomerAccountOpenImgEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.queryListByBean(entity);
    }

    @Override
    public List<CustomerAccountOpenImgEntity> queryByAccountOpenInfoId(String customerAccountOpenInfoId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        CustomerAccountOpenImgEntity queryCondition = new CustomerAccountOpenImgEntity();
        queryCondition.setApplicationId(customerAccountOpenInfoId);
        return customerAccountOpenImageDao.queryListByBean(queryCondition);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.queryTotal(map);
    }

    @Override
    public int save(CustomerAccountOpenImgEntity customerAccountOpenImage) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.save(customerAccountOpenImage);
    }

    @Override
    public int update(CustomerAccountOpenImgEntity customerAccountOpenImage) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.update(customerAccountOpenImage);
    }

    @Override
    public int delete(String gid) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.delete(gid);
    }

    @Override
    public int deleteBatch(String[] gids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.deleteBatch(gids);
    }

    /**
     * 重置修改人
     *
     * @param applicationId
     * @return
     */
    @Override
    public int resetUpdateUser(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.resetUpdateUser(applicationId);
    }

    @Override
    public int deleteByApplicationId(CustomerAccountOpenImgEntity customerAccountOpenImgEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenImageDao.deleteByApplicationId(customerAccountOpenImgEntity);
    }

    /**
     * 排序
     *
     * @param customerAccountOpenImgList
     * @param openAccountAccessWay
     * @param bankType
     * @param idKind
     * @return
     */
    @Override
    public List<CustomerAccountOpenImgEntity> sort(List<CustomerAccountOpenImgEntity> customerAccountOpenImgList, Integer openAccountAccessWay, Integer bankType, Integer idKind) {

        List<CustomerAccountOpenImgEntity> openImgRegulationOrder = Lists.newArrayList();

        // 大陆卡大陆身份证APP开户图片排序
        if (bankType == 1 && idKind == 1 && openAccountAccessWay == 2) {
            openImgRegulationOrder.clear();
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(101, "身份证正面"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(102, "身份证反面"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(201, "银行卡"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(401, "手持身份证正面照"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(301, "签名"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(302, "签名信息"));

            customerAccountOpenImgList.sort((o1, o2) -> {
                int io1 = openImgRegulationOrder.indexOf(o1);
                int io2 = openImgRegulationOrder.indexOf(o2);
                return io1 - io2;
            });
        }

        // 大陆卡大陆身份证H5开户图片排序
        if (bankType == 1 && idKind == 1 && openAccountAccessWay == 1) {
            openImgRegulationOrder.clear();
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(101, "身份证正面"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(102, "身份证反面"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(201, "银行卡"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(401, "手持身份证正面照"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(301, "签名"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(402, "正面照"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(501, "1根手指"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(502, "2根手指"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(503, "3根手指"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(504, "4根手指"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(505, "5根手指"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(302, "签名信息"));

            customerAccountOpenImgList.sort((o1, o2) -> {
                int io1 = openImgRegulationOrder.indexOf(o1);
                int io2 = openImgRegulationOrder.indexOf(o2);
                return io1 - io2;
            });
        }

        // 香港卡大陆身份证开户图片排序
        if (bankType == 0 && idKind == 1) {
            openImgRegulationOrder.clear();
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(101, "身份证正面"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(102, "身份证反面"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(201, "银行卡"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(301, "签名"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(302, "签名信息"));

            customerAccountOpenImgList.sort((o1, o2) -> {
                int io1 = openImgRegulationOrder.indexOf(o1);
                int io2 = openImgRegulationOrder.indexOf(o2);
                return io1 - io2;
            });
        }

        // 香港卡香港身份证开户图片排序
        if (bankType == 0 && idKind == 2) {
            openImgRegulationOrder.clear();
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(103, "香港身份证"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(201, "银行卡"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(301, "签名"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(302, "签名信息"));

            customerAccountOpenImgList.sort((o1, o2) -> {
                int io1 = openImgRegulationOrder.indexOf(o1);
                int io2 = openImgRegulationOrder.indexOf(o2);
                return io1 - io2;
            });
        }

        // 香港卡护照开户图片排序
        if (bankType == 0 && idKind == 3) {
            openImgRegulationOrder.clear();
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(104, "护照"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(201, "银行卡"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(301, "签名"));
            openImgRegulationOrder.add(new CustomerAccountOpenImgEntity(302, "签名信息"));

            customerAccountOpenImgList.sort((o1, o2) -> {
                int io1 = openImgRegulationOrder.indexOf(o1);
                int io2 = openImgRegulationOrder.indexOf(o2);
                return io1 - io2;
            });
        }

        return customerAccountOpenImgList;
    }

}
