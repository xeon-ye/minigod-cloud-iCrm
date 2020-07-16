package com.sunline.modules.customer.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.customer.dao.SecUserInfoDao;
import com.sunline.modules.customer.entity.ActivityStatisticsEntity;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.enums.CustomerEnums;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import com.sunline.security.SecurityKey;
import com.sunline.security.util.AESUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客户管理
 *
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Service("securitiesUserInfoService")
public class SecUserInfoServiceImpl implements SecUserInfoService {
    @Autowired
    private SecUserInfoDao secUserInfoDao;

    /**
     * 综合查询详情
     *
     * @param entity
     * @return
     */
    @Override
    public SecuritiesUserInfoEntity queryById(SecuritiesUserInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        SecuritiesUserInfoEntity securitiesUserInfoEntity = secUserInfoDao.queryById(entity);
        String freeStatus = securitiesUserInfoEntity.getFreeStatus();
        if (freeStatus != null && !"".equals(freeStatus)) {
            //根据freeEndDate正负值 判断是否免佣
            if (Integer.parseInt(freeStatus) > 0) {
                securitiesUserInfoEntity.setFreeStatus("未免佣");
            } else if (Integer.parseInt(freeStatus) < 0) {
                securitiesUserInfoEntity.setFreeStatus("免佣中");
            }
        }else if(freeStatus == null ||"".equals(freeStatus)){
            securitiesUserInfoEntity.setFreeStatus("未免佣");
        }
        //根据hqEndTime 判断行情
        String hqEndTime = securitiesUserInfoEntity.getHqEndTime();
        if (hqEndTime != null && !"".equals(hqEndTime)) {
            if (hqEndTime == null || Integer.parseInt(hqEndTime) > 0) {
                securitiesUserInfoEntity.setHqStatus("无效");
            } else if (Integer.parseInt(hqEndTime) < 0) {
                securitiesUserInfoEntity.setHqStatus("有效");
            }
        }else if(hqEndTime == null || "".equals(hqEndTime)){
            securitiesUserInfoEntity.setHqStatus("无效");
        }
        return securitiesUserInfoEntity;
    }

    @Override
    public SecuritiesUserInfoEntity queryObject(SecuritiesUserInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return secUserInfoDao.queryObject(entity);
    }

    /**
     * 查询客户列表
     */

    @Override
    public List<SecuritiesUserInfoEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return secUserInfoDao.queryList(map);
    }

    @Override
    public List<SecuritiesUserInfoEntity> queryListByBean(SecuritiesUserInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return secUserInfoDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return secUserInfoDao.queryTotal(map);
    }


    @Override
    public int save(SecuritiesUserInfoEntity securitiesUserInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        UserEntity user = UserUtils.getCurrentUser();
        securitiesUserInfo.setCreateUser(user.getUserName());
        securitiesUserInfo.setModifyUser(user.getUserName());
        securitiesUserInfo.setClientType(CustomerEnums.ClientType.CLIENT_TYPE_NOR.getIndex());
        securitiesUserInfo.setCreateTime(new Date());
        securitiesUserInfo.setUpdateTime(new Date());
        return secUserInfoDao.save(securitiesUserInfo);
    }

    @Override
    public int update(SecuritiesUserInfoEntity securitiesUserInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return secUserInfoDao.update(securitiesUserInfo);
    }

    @Override
    public int delete(String gid) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return secUserInfoDao.delete(gid);
    }

    @Override
    public int deleteBatch(String[] gids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return secUserInfoDao.deleteBatch(gids);
    }

    /**
     * 基本查询分页
     *
     * @param securitiesUserInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<SecuritiesUserInfoEntity> findPage(SecuritiesUserInfoEntity securitiesUserInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        secUserInfoDao.queryList(securitiesUserInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 综合查询分页
     *
     * @param securitiesUserInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<SecuritiesUserInfoEntity> queryPage(SecuritiesUserInfoEntity securitiesUserInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        secUserInfoDao.querySynList(securitiesUserInfoEntity);
        return PageHelper.endPage();
    }

    @Override
    public List<SecuritiesUserInfoEntity> queryListFilter(SecuritiesUserInfoEntity securitiesUserInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return secUserInfoDao.queryListFilter(securitiesUserInfoEntity);
    }

    /**
     * 分组不存在用户的分页查询
     *
     * @param securitiesUserInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<SecuritiesUserInfoEntity> findPageFilter(SecuritiesUserInfoEntity securitiesUserInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        secUserInfoDao.queryListFilter(securitiesUserInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 小神用户分页查询
     *
     * @param securitiesUserInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<SecuritiesUserInfoEntity> userPageList(SecuritiesUserInfoEntity securitiesUserInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        List<SecuritiesUserInfoEntity> securitiesUserInfoEntitys = secUserInfoDao.queryUserList(securitiesUserInfoEntity);
        for (SecuritiesUserInfoEntity s : securitiesUserInfoEntitys) {
            String phoneNumber = s.getPhoneNumber();
            //手机号解密
            if (!(phoneNumber == null || "".equalsIgnoreCase(phoneNumber))) {
                phoneNumber = AESUtil.decrypt(phoneNumber, SecurityKey.MOBILE_PHONE_KEY);
                s.setPhoneNumber(phoneNumber);
            }
        }
        return PageHelper.endPage();
    }

    /**
     * 按userId查询
     *
     * @param userInfo
     * @return
     */
    @Override
    public SecuritiesUserInfoEntity queryByUserId(SecuritiesUserInfoEntity userInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return secUserInfoDao.queryByUserId(userInfo);
    }


    /**
     * 按交易账户查询
     *
     * @param userInfo
     * @return
     */
    @Override
    public int queryByTradeAcc(SecuritiesUserInfoEntity userInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return secUserInfoDao.queryByTradeAcc(userInfo);
    }

    /**
     * 客户基本查询 excel导出
     *
     * @param userInfo
     * @return
     */
    @Override
    public List<SecuritiesUserInfoEntity> customerListExcelList(SecuritiesUserInfoEntity userInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<SecuritiesUserInfoEntity> list = secUserInfoDao.queryList(userInfo);
        return list;
    }

    /**
     * 客户综合查询 excel导出
     *
     * @param userInfo
     * @return
     */
    @Override
    public List<SecuritiesUserInfoEntity> cusSynListExcelList(SecuritiesUserInfoEntity userInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return secUserInfoDao.querySynList(userInfo);
    }

    /**
     * 小神用户查询 excel导出
     *
     * @param userInfo
     * @return
     */
    @Override
    public List<SecuritiesUserInfoEntity> cusUserListExcelList(SecuritiesUserInfoEntity userInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<SecuritiesUserInfoEntity> securitiesUserInfoEntitys = secUserInfoDao.queryUserList(userInfo);
        for (SecuritiesUserInfoEntity s : securitiesUserInfoEntitys) {
            String phoneNumber = s.getPhoneNumber();
            //手机号解密
            if (!(phoneNumber == null || "".equalsIgnoreCase(phoneNumber))) {
                phoneNumber = AESUtil.decrypt(phoneNumber, SecurityKey.MOBILE_PHONE_KEY);
                s.setPhoneNumber(phoneNumber);
            }
        }
        return securitiesUserInfoEntitys;
    }

    @Override
    public SecuritiesUserInfoEntity getUserInfo(String userId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return secUserInfoDao.getUserInfo(userId);
    }

    @Override
    public int updateUserInfo(SecuritiesUserInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return secUserInfoDao.updateUserInfo(entity);
    }

    /**
     * 查询活动统计
     *
     * @param queryCondition
     * @param pageNum
     */
    @Override
    public Page<ActivityStatisticsEntity> queryActivityStatistics(ActivityStatisticsEntity queryCondition, int pageNum) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);

        PageHelper.startPage(pageNum, Constant.pageSize);
        secUserInfoDao.queryActivityStatistics(queryCondition);

//        for (ActivityStatisticsEntity info: activityStatisticsList) {
//            String phoneNumber = info.getRegPhoneNumber();
            // 手机号解密
//            if (StringUtils.isNotBlank(phoneNumber)) {
//                phoneNumber = AESUtil.decrypt(phoneNumber, SecurityKey.MOBILE_PHONE_KEY);
//                info.setRegPhoneNumber(phoneNumber);
//            }
//        }
        return PageHelper.endPage();
    }

    /**
     * 活动统计
     *
     * @param queryCondition
     * @return
     */
    @Override
    public List<ActivityStatisticsEntity> queryActivityStatistics(ActivityStatisticsEntity queryCondition) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);

        List<ActivityStatisticsEntity> activityStatisticsList=secUserInfoDao.queryActivityStatistics(queryCondition);

//        for (ActivityStatisticsEntity info: activityStatisticsList) {
//            String phoneNumber = info.getRegPhoneNumber();
//            // 手机号解密
//            if (StringUtils.isNotBlank(phoneNumber)) {
//                phoneNumber = AESUtil.decrypt(phoneNumber, SecurityKey.MOBILE_PHONE_KEY);
//                info.setRegPhoneNumber(phoneNumber);
//            }
//        }

        return activityStatisticsList;
    }
}
