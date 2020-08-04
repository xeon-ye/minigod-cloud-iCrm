package com.sunline.modules.common.controller;


import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.sys.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 类的功能描述.
 * 公共的控件器，可在类中实现一些共同的方法和属性 持续更新中
 * @Auther hxy
 * @Date 2017/4/28
 */
public class BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取当前登录用户
     * @return
     */
    public UserEntity getUser(){
        return UserUtils.getCurrentUser();
    }

    /**
     * 获取当前登录用户Id
     * @return
     */
    public String getUserId(){
        UserEntity user = getUser();
        if(null != user && null !=user.getId()){
            return user.getId();
        }
        return "";
    }

    /**
     * 获取当前登录用户授权渠道
     * @return
     */
    public List<String> getChannelIds(){
        return UserUtils.getChannelIds();
    }


}
