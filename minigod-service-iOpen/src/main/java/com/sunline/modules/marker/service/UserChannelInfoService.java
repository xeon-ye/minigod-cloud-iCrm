package com.sunline.modules.marker.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.marker.entity.ChannelRoleEntity;
import com.sunline.modules.marker.entity.UserChannelInfoEntity;

import java.util.List;
import java.util.Map;
/**
 * 渠道信息表
 *
 * @author lcs
 * @email
 * @date 2018-04-25 09:31:43
 */
public interface UserChannelInfoService {
	
	UserChannelInfoEntity queryObject(String id);
	
	List<UserChannelInfoEntity> queryList(Map<String, Object> map);

	List<UserChannelInfoEntity> queryForExp(UserChannelInfoEntity entity);

	List<UserChannelInfoEntity> areaQueryList(Map<String, Object> map);

    List<UserChannelInfoEntity> queryListByBean(UserChannelInfoEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(UserChannelInfoEntity userChannelInfo);
	
	int update(UserChannelInfoEntity userChannelInfo);
	
	int delete(Integer id);
	
	int deleteBatch(String[] ids);

    /**
     * 添加渠道时 查询渠道的列表树
     * @return
     */
    List<UserChannelInfoEntity> queryNotButtonnList();

    /**
     * 弹出渠道列表
     * @return
     */
    List<UserChannelInfoEntity> queryButtonList(UserChannelInfoEntity entity);
    /**
     * 添加大区时 查询大区的列表树
     * @return
     */
    List<UserChannelInfoEntity> areaQueryNotButtonnList();

    /**
     * 渠道名称查询渠道
     * @param userChannelInfo
     * @return
     */
    int queryByChannelName(UserChannelInfoEntity userChannelInfo);

    /**
     * 渠道编号查询渠道
     * @param userChannelInfo
     * @return
     */
    int queryByChannelId(UserChannelInfoEntity userChannelInfo);

    /**
     * 分页查询
     * @param channelInfoEntity
     * @param pageNum
     * @return
     */
    Page<UserChannelInfoEntity> findPage(UserChannelInfoEntity channelInfoEntity, int pageNum);

    /**
     * 根据父节点查询子集
     * @return
     */
    List<String> queryByParent(String parentId);

    /**
     * 查询单个信息
     * @param channelInfoEntity
     * @return
     */
    UserChannelInfoEntity queryInfo(UserChannelInfoEntity channelInfoEntity);

    /**
     * 查询渠道心里列表
     */

    List<UserChannelInfoEntity>  queryByChannelList(UserChannelInfoEntity channelInfoEntity);

    /**
     * 根据渠道号查询 授权了该渠道的角色
     */
    List<String>  queryRoleIdsByChannelId(String channelId);

    /**
     * 授权新增渠道给指定角色
     */
    int saveChannelRole(ChannelRoleEntity entity);


}
