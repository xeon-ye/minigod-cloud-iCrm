package com.sunline.modules.marker.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.common.CommonResultCode;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.marker.dao.UserChannelInfoDao;
import com.sunline.modules.marker.entity.ChannelParams;
import com.sunline.modules.marker.entity.ChannelRoleEntity;
import com.sunline.modules.marker.entity.UserChannelInfoEntity;
import com.sunline.modules.marker.service.UserChannelInfoService;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 渠道信息表
 *
 * @author lcs
 * @email
 * @date 2018-04-25 09:31:43
 */
@Service("userChannelInfoService")
public class UserChannelInfoServiceImpl implements UserChannelInfoService {
    @Autowired
    private UserChannelInfoDao userChannelInfoDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserChannelInfoEntity queryObject(String id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryObject(id);
    }

    @Override
    public List<UserChannelInfoEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryList(map);
    }

    @Override
    public List<UserChannelInfoEntity> queryForExp(UserChannelInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryChannelList(entity);
    }

    @Override
    public List<UserChannelInfoEntity> areaQueryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.areaQueryList(map);
    }

    @Override
    public List<UserChannelInfoEntity> queryListByBean(UserChannelInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryTotal(map);
    }

    @Override
    public int save(UserChannelInfoEntity userChannelInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        //设置创建人
        UserEntity currentUser = UserUtils.getCurrentUser();
        userChannelInfo.setCreateBy(currentUser.getUserName());
        if ("0".equals(userChannelInfo.getType())) {
            return userChannelInfoDao.saveArea(userChannelInfo);
        } else {
            int count = userChannelInfoDao.save(userChannelInfo);
            //修改成功 同步sns
          /*  if (count > 0) {
                ChannelParams channelParams = new ChannelParams();
                channelParams.setChannelId(userChannelInfo.getChannelId());
                channelParams.setChannelName(userChannelInfo.getChannelName());
                if (Integer.parseInt(channelParams.getChannelId()) > 0) {
                    CommonResultCode commonResultCode = addUserChannelInfo(channelParams);
                    CommonResultCode resultCode = addChannelInfo(channelParams);
                    //sns 同步失败  删除本地 将count置0
                    if (CommonResultCode.getDefaultFailed().getErrorCode() == commonResultCode.getErrorCode()||CommonResultCode.getDefaultFailed().getErrorCode()==resultCode.getErrorCode()) {
                        userChannelInfoDao.delete(userChannelInfo);
                        count = 0;
                    }
                }
            }*/
            return count;
        }
    }

    @Override
    public int update(UserChannelInfoEntity userChannelInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        int count = userChannelInfoDao.update(userChannelInfo);
        //修改成功 同步sns
       /* if (count > 0) {
            ChannelParams channelParams = new ChannelParams();
            channelParams.setChannelId(userChannelInfo.getChannelId());
            channelParams.setChannelName(userChannelInfo.getChannelName());
            if (Integer.parseInt(channelParams.getChannelId()) > 0) {
                CommonResultCode commonResultCode = updateUserChannelInfo(channelParams);
                CommonResultCode resultCode = modifyChannelInfo(channelParams);
                //sns 同步失败  删除本地 将count置0
                if (CommonResultCode.getDefaultFailed().getErrorCode() == commonResultCode.getErrorCode()||CommonResultCode.getDefaultFailed().getErrorCode()==resultCode.getErrorCode()) {
                    userChannelInfoDao.delete(userChannelInfo);
                    count = 0;
                }
            }
        }*/
        return count;
    }

    @Override
    public int delete(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.delete(id);
    }

    @Override
    public int deleteBatch(String[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.deleteBatch(ids);
    }

    /**
     * 上级渠道查询树数据
     *
     * @return
     */
    @Override
    public List<UserChannelInfoEntity> queryNotButtonnList() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        List<UserChannelInfoEntity> menuList = userChannelInfoDao.queryNotButtonnList(new String[]{Constant.MenuType.CATALOG.getValue(), Constant.MenuType.MENU.getValue()});
        return menuList;
    }

    @Override
    public List<UserChannelInfoEntity> queryButtonList(UserChannelInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        List<UserChannelInfoEntity> menuList = userChannelInfoDao.queryButtonList(entity);
        return menuList;
    }

    /**
     * 上级大区查询树数据
     *
     * @return
     */
    @Override
    public List<UserChannelInfoEntity> areaQueryNotButtonnList() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        List<UserChannelInfoEntity> menuList = userChannelInfoDao.areaQueryNotButtonnList(new String[]{Constant.MenuType.CATALOG.getValue(), Constant.MenuType.MENU.getValue()});
        return menuList;
    }

    /**
     * 根据渠道号  用于校验
     *
     * @param userChannelInfo
     * @return
     */
    @Override
    public int queryByChannelName(UserChannelInfoEntity userChannelInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryByChannelName(userChannelInfo);
    }

    /**
     * 根据渠道号  用于校验
     *
     * @param userChannelInfo
     * @return
     */
    @Override
    public int queryByChannelId(UserChannelInfoEntity userChannelInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryByChannelId(userChannelInfo);
    }

    /**
     * 分页查询
     * @param channelInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<UserChannelInfoEntity> findPage(UserChannelInfoEntity channelInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        userChannelInfoDao.queryChannelList(channelInfoEntity);
        return PageHelper.endPage();
    }

    @Override
    public List<String> queryByParent(String parentId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryByParent(parentId);
    }

    @Override
    public UserChannelInfoEntity queryInfo(UserChannelInfoEntity channelInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryInfo(channelInfoEntity);
    }

    /**
     * 查询渠道信息列表
     * @param channelInfoEntity
     * @return
     */
    @Override
    public List<UserChannelInfoEntity> queryByChannelList(UserChannelInfoEntity channelInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryChannelListByParent(channelInfoEntity);
    }

    /**
     * SNS新增渠道信息
     *
     * @param channelParams
     */
    public CommonResultCode addUserChannelInfo(ChannelParams channelParams) {
        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("params", channelParams);

            String response = HttpClientUtils.postJson(ConfigUtils.get("sns.add.user.channel.info"), JSON.toJSONString(paraMap));

            return JSON.parseObject(response, CommonResultCode.class);

        } catch (Exception e) {
            logger.error("SNS新增[" + channelParams.getChannelName() + "]渠道异常：", e);
        }
        return CommonResultCode.getDefaultFailed();
    }

    /**
     * SNS修改渠道信息
     *
     * @param channelParams
     */
    public CommonResultCode updateUserChannelInfo(ChannelParams channelParams) {
        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("params", channelParams);

            String response = HttpClientUtils.postJson(ConfigUtils.get("sns.update.user.channel.info"), JSON.toJSONString(paraMap));

            return JSON.parseObject(response, CommonResultCode.class);

        } catch (Exception e) {
            logger.error("SNS修改[" + channelParams.getChannelName() + "]渠道异常：", e);
        }
        return CommonResultCode.getDefaultFailed();
    }

    /**
     * BPM新增渠道信息同步
     *
     * @param channelParams
     */
    public CommonResultCode addChannelInfo(ChannelParams channelParams) {
        try {
//            JSONObject paraMap = new JSONObject();
//            paraMap.put("params", channelParams);
            String response = HttpClientUtils.postJson(ConfigUtils.get("bpm.add.channel.info"), JSON.toJSONString(channelParams));
            return JSON.parseObject(response, CommonResultCode.class);

        } catch (Exception e) {
            logger.error("BPM新增[" + channelParams.getChannelName() + "]渠道异常：", e);
        }
        return CommonResultCode.getDefaultFailed();
    }

    /**
     * BPM修改渠道信息同步
     *
     * @param channelParams
     */
    public CommonResultCode modifyChannelInfo(ChannelParams channelParams) {
        try {

//            JSONObject paraMap = new JSONObject();
//
//            paraMap.put("params", channelParams);

            String response = HttpClientUtils.postJson(ConfigUtils.get("bpm.modify.channel.info"), JSON.toJSONString(channelParams));

            return JSON.parseObject(response, CommonResultCode.class);

        } catch (Exception e) {
            logger.error("BPM修改[" + channelParams.getChannelName() + "]渠道异常：", e);
        }
        return CommonResultCode.getDefaultFailed();
    }

    /**
     * 根据渠道号查询 授权了该渠道的角色
     */
    @Override
    public List<String> queryRoleIdsByChannelId(String channelId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.queryRoleIdsByChannelId(channelId);
    }

    @Override
    public int saveChannelRole(ChannelRoleEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userChannelInfoDao.saveChannelRole(entity);
    }
}
