package com.sunline.modules.fund.proxy;

import com.sunline.modules.common.annotation.SystemLog;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.protocol.DbsApiProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: DBS API服务代理
 * @author: Larry Lai
 * @date: 2020/3/2 13:29
 * @version: v1.0
 */


@RequestMapping(value = "proxy/dbs")
@Controller
public class DbsApiProxy {

    private static final Logger logger = LoggerFactory.getLogger(DbsApiProxy.class);

    /**
     * 接收星展银行流水推送
     *
     * @param request
     * @return
     */
    @RequestMapping("/icc")
    @SystemLog(description = "接收星展银行流水推送")
    public
    @ResponseBody
//    ResponseVO icc(HttpServletRequest request, HttpServletResponse response) {
    ResponseVO icc(@RequestBody GenericSunlineRequest<DbsApiProtocol> request) {

        ResponseVO responseVO = new ResponseVO();
        DbsApiProtocol protocol = request.getParams();

        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

        return responseVO;
    }

}

