package com.sunline.modules.marker.dao;

import com.sunline.modules.api.entity.ChannelModel;
import com.sunline.modules.marker.entity.ChannelRoleEntity;
import com.sunline.modules.marker.entity.UserChannelInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 渠道信息表
 *
 * @author lcs
 * @email
 * @date 2018-04-25 09:31:43
 */
@Mapper
public interface UserChannelInfoDao extends BaseDao<UserChannelInfoEntity> {
    /**
     * 查询所有不包括按钮 的菜单
     * @return
     */
    List<UserChannelInfoEntity> areaQueryList(Map<String, Object> map);


    List<UserChannelInfoEntity> queryChannelList(UserChannelInfoEntity userChannelInfoEntity);

    List<UserChannelInfoEntity> queryChannelListByParent(UserChannelInfoEntity userChannelInfoEntity);

    /**
     * 上级渠道查询树数据
     * @return
     */
    List<UserChannelInfoEntity> queryNotButtonnList(String[] types);
    /**
     * 渠道弹出列表
     * @return
     */
    List<UserChannelInfoEntity> queryButtonList(UserChannelInfoEntity entity);

    /**
     * 上级大区查询树数据
     * @return
     */
    List<UserChannelInfoEntity> areaQueryNotButtonnList(String[] types);


    /**
     * 根据渠道名字查询  用于校验
     * @param userChannelInfoEntity
     * @return
     */
    int queryByChannelName(UserChannelInfoEntity userChannelInfoEntity);
    /**
     * 根据渠道号  用于校验
     * @param userChannelInfoEntity
     * @return
     */
    int queryByChannelId(UserChannelInfoEntity userChannelInfoEntity);

    /**
     * 大区新增
     * @param userChannelInfoEntity
     * @return
     */
    int saveArea(UserChannelInfoEntity userChannelInfoEntity);

    /**
     * 根据父节点查子集
     * @param parentId
     * @return
     */
    List<String> queryByParent(@Param("parentId") String parentId);

    /**
     * 查询单个信息
     * @param userChannelInfoEntity
     * @return
     */
    UserChannelInfoEntity queryInfo(UserChannelInfoEntity userChannelInfoEntity);

    /**
     * 查询授权渠道
     * @param channelIds
     * @return
     */
    List<ChannelModel> queryByChannelIds(@Param("channelIds") List<String> channelIds);

    /**
     * 根据渠道号查询 授权了该渠道的角色
     */
    List<String>  queryRoleIdsByChannelId(String channelId);

    /**
     * 授权新增渠道给指定角色
     */
    int saveChannelRole(ChannelRoleEntity entity);
}
