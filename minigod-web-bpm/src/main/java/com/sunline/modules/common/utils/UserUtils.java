package com.sunline.modules.common.utils;


import com.sunline.modules.common.common.Constant;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.UserService;

import java.util.List;

import static com.sunline.modules.common.utils.ShiroUtils.getUserId;


/**
 * 类的功能描述.
 * 用户工具类
 * @Auther hxy
 * @Date 2017/5/10
 */

public class UserUtils {

    private static UserService userService = (UserService)SpringContextUtils.getBean("userService");



    /**
     * 获取系统管理员
     * @return
     */
    public static UserEntity getManagerUser(){
        UserEntity supperUser = userService.queryObject(Constant.SUPERR_USER);
        return supperUser;
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public static UserEntity getCurrentUser(){
        UserEntity user = ShiroUtils.getUserEntity();
        return user;
    }

    /**
     * 获取当前登录用户 待完善缓存
     * @return
     */
    public static String getCurrentUserId(){
        UserEntity user = ShiroUtils.getUserEntity();
        return user.getId();
    }


    /**
     * 获取机构部门数据权限
     * @param type 1=部门权限，2=机构权限，3=部门机构权限
     * @return
     */
    public static String getDateAuth(String type){
        UserEntity user = UserUtils.getCurrentUser();
        if (user ==null){
            return null;
        }
        if(Constant.DataAuth.BA_DATA.getValue().equals(type)){
            return user.getBaids();
        }
        if(Constant.DataAuth.BAP_DATA.getValue().equals(type)){
            return user.getBapids();
        }
        if(Constant.DataAuth.ALL_DATA.getValue().equals(type)){
            return user.getBaids()+user.getBapids();
        }
        return null;
    }

    /**
     * 获取授权渠道id
     * @param
     * @return
     */
    public static List<String> getChannelIds(){
        UserEntity user = UserUtils.getCurrentUser();
        List<String> channelIdList = userService.queryChannelIds(user);
        if(null==channelIdList||channelIdList.size()==0){
            channelIdList.add("0");
            return channelIdList;
        }else{
            return channelIdList;
        }
    }

    /**
     * 获取授权渠道id 对外接口专用
     * @param
     * @return
     */
    public static List<String> getChannelIds(UserEntity user){
        List<String> channelIdList = userService.queryChannelIds(user);
        if(null==channelIdList||channelIdList.size()==0){
            return null;
        }else{
            return channelIdList;
        }
    }

    /**
     * 获取后台工作流用户
     *
     * @return
     */
    public static UserEntity getBackgroundWorkflowUser() {
        UserEntity supperUser = userService.queryObject(Constant.BACKGROUND_WORKFLOW_USER);
        return supperUser;
    }

    /**
     * 获取用户是否属于敏感信息组
     * @return
     */
    public static boolean isSensitiveUser(){
        boolean shield = true;
        if(getUserId().equals(Constant.SUPERR_USER)) {
            shield = false;
        }else{
            List<String> roleNames = userService.queryRoleName(getUserId());
            for (String roleName : roleNames) {
                if ("敏感信息组".equals(roleName)) {
                    shield = false;
                }
            }
        }
        return shield;
    }
}
