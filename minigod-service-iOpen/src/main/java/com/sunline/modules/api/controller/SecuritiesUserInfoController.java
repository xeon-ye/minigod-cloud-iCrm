package com.sunline.modules.api.controller;


import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.protocol.SecuritiesUserInfoProto;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 统一用户中心代理类
 * @author: Larry Lai
 * @date: 2018/9/29 15:17
 * @version: v1.0
 */

@Controller
@RequestMapping("/securitiesUserInfo")
public class SecuritiesUserInfoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecuritiesUserInfoService securitiesUserService;

    /**
     * 新增客户信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/addSecuritiesUserInfo")
    public
    @ResponseBody
    ResponseVO addSecuritiesUserInfo(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {

        logger.info("统一用户中心新增客户信息接口接收参数：" + JSON.toJSONString(request));

        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();

        BeanUtil.copyProperties(request.getParams(), securitiesUserModel);

        return securitiesUserService.addSecuritiesUserInfo(securitiesUserModel);
    }

    /**
     * 修改客户信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/modifySecuritiesUserInfo")
    public
    @ResponseBody
    ResponseVO modifySecuritiesUserInfo(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {

        logger.info("统一用户中心修改客户信息接口接收参数：" + JSON.toJSONString(request.getParams()));

        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();

        BeanUtil.copyProperties(request.getParams(), securitiesUserModel);

        return securitiesUserService.modifySecuritiesUserInfo(securitiesUserModel);
    }

    /**
     * 查询客户信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/querySecuritiesUserInfo")
    public
    @ResponseBody
    ResponseVO querySecuritiesUserInfo(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {

//        logger.info("统一用户中心查询客户信息接口接收参数：" + JSON.toJSONString(request.getParams()));

        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();

        BeanUtil.copyProperties(request.getParams(), securitiesUserModel);

        return securitiesUserService.querySecuritiesUserInfo(securitiesUserModel);
    }

    /**
     * 查询客户列表
     *
     * @param request
     * @return
     */
    @RequestMapping("/querySecuritiesUserInfoList")
    public
    @ResponseBody
    ResponseVO querySecuritiesUserInfoList(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {

//        logger.info("统一用户中心查询客户列表接口接收参数：" + JSON.toJSONString(request.getParams()));

        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();

        BeanUtil.copyProperties(request.getParams(), securitiesUserModel);

        return securitiesUserService.querySecuritiesUserInfoList(securitiesUserModel);
    }

    /**
     * 查询客户列表（匹配记录数）
     *
     * @param request
     * @return
     */
    @RequestMapping("/querySecuritiesUserInfoLimitList")
    public
    @ResponseBody
    ResponseVO querySecuritiesUserInfoLimitList(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {

        if (null == request.getParams().getCount()) {

            ResponseVO responseVO = new ResponseVO();

            responseVO.setCode(BpmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
            responseVO.setMessage(BpmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());

            return responseVO;
        }

        if (null == request.getParams().getOpenAccountTime() || !"".equals(request.getParams().getOpenAccountTime())) {

            request.getParams().setOpenAccountTime(null);
        }

//        logger.info("统一用户中心查询客户列表接口接收参数：" + JSON.toJSONString(request.getParams()));

        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();

        BeanUtil.copyProperties(request.getParams(), securitiesUserModel);

        return securitiesUserService.querySecuritiesUserInfoLimitList(securitiesUserModel);
    }


}
