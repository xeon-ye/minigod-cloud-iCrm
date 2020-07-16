package com.sunline.modules.app.controller;


import com.google.common.collect.Maps;
import com.sunline.modules.app.service.ApiUserService;
import com.sunline.modules.app.utils.JwtUtils;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.sys.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 类ApiLoginController的功能描述:
 * APP登录授权
 * @auther hxy
 * @date 2017-10-16 14:15:39
 */
@Controller
@RequestMapping("/app")
public class ApiLoginController {
    @Autowired
    private ApiUserService userApiService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(UserEntity userEntity){
        //用户登录
        String userId = userApiService.login(userEntity);

        //生成token
        String token = jwtUtils.generateToken(userId);

        Map<String, Object> map = Maps.newHashMap();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return Result.ok(map);
    }

}
