package com.sunline.modules.call.controller;

import java.util.List;

import com.google.common.collect.Lists;
import com.sunline.modules.call.model.CallRecordModel;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sunline.modules.call.entity.CallRecordEntity;
import com.sunline.modules.call.service.CallRecordService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 通话记录表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-05 10:29:23
 */
@Controller
@RequestMapping("callrecord")
public class CallRecordController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CallRecordController.class);

    @Autowired
    private CallRecordService callRecordService;
    @Autowired
    private SecUserInfoService secUserInfoService;


    /**
     * HK列表
     */
    @RequestMapping("/callListHk")
    public String callListHk(CallRecordEntity entity, HttpServletRequest request, Model model) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        entity.setExtenAttach(0);
        entity.setName("香港通讯组");
        //查询列表数据
        Page page = callRecordService.findPage(entity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("call", entity);
        return "call/callListHk";
    }

    /**
     * SZ列表
     */
    @RequestMapping("/callListSz")
    public String callListSz(CallRecordEntity entity, HttpServletRequest request, Model model) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        entity.setExtenAttach(1);
        entity.setName("深圳通讯组");
        //查询列表数据
        Page page = callRecordService.findPage(entity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("call", entity);
        return "call/callListSz";
    }

    /**
     * 关联页面
     */
    @RequestMapping("/callConnInit")
    public String callConnInit(CallRecordEntity entity, HttpServletRequest request, Model model) {

        model.addAttribute("id", entity.getId());

        return "call/callRecordConn";
    }

    /**
     * 关联账号
     */
    @RequestMapping("/connectAccount")
    @RequiresPermissions("callrecord:connectAccount")
    public @ResponseBody
    Result connectAccount(CallRecordEntity callRecord) {

        callRecord.setRelationState(1);

        SecuritiesUserInfoEntity userParams = new SecuritiesUserInfoEntity();
        userParams.setUserId(callRecord.getUserId()!=null?callRecord.getUserId():null);
        userParams.setTradeAccount(callRecord.getClientId()!=null?String.valueOf(callRecord.getClientId()):null);
        SecuritiesUserInfoEntity userInfo = secUserInfoService.queryObject(userParams);

        if(userInfo!=null){
            callRecord.setClientId(Integer.parseInt(userInfo.getTradeAccount()));
            callRecord.setUserId(userInfo.getUserId());
        }

        int count = callRecordService.update(callRecord);

        if (count > 0) {
            return Result.ok("关联成功");
        } else {
            return Result.ok("关联失败");
        }

    }

    /**
     * 取消关联
     */
    @RequestMapping("/cancelConnect")
    @RequiresPermissions("callrecord:cancelConnect")
    public @ResponseBody
    Result cancelConnect(CallRecordEntity callRecord) {

        int count = callRecordService.cancelConnect(callRecord);

        if (count > 0) {
            return Result.ok();
        } else {
            return Result.error("取消失败！");
        }

    }


    /**
     * 通话记录导出excel
     */
    @RequestMapping(value = "/callListExcel")
    @RequiresPermissions("callRecord:exp")
    @SysLog("通话记录导出excel")
    public void callListExcel(CallRecordEntity entity, HttpServletRequest request, HttpServletResponse response) {
        try {

            if (entity.getExtenAttach() == 0) {
                entity.setName("香港通讯组");
            } else if (entity.getExtenAttach() == 1) {
                entity.setName("深圳通讯组");
            }
            List<CallRecordEntity> callList = callRecordService.queryList(entity);

            List<CallRecordModel> modelList = Lists.newArrayList();
            int i = 1;
            for (CallRecordEntity callRecord : callList) {
                CallRecordModel model = new CallRecordModel();
                model.setId(String.valueOf(i));
                model.setExten(callRecord.getExten());
                model.setExtenName(callRecord.getExtenName());
                model.setCallId(callRecord.getCallId());
                model.setBeginTime(callRecord.getBeginTime());
                model.setEndTime(callRecord.getEndTime());
                model.setOfferingTime(callRecord.getOfferingTime());
                model.setCallTimeLength(TimeUtils.secondFormat(Integer.parseInt(callRecord.getCallTimeLength())));
                model.setConnectType(CodeUtils.getCodeName("CALL_CONNECT_TYPE", callRecord.getConnectType()));
                model.setCallNo(callRecord.getCallNo());
                model.setCalledNo(callRecord.getCalledNo());
                model.setStatus(CodeUtils.getCodeName("CALL_DEAL_STATUS", callRecord.getStatus()));
                model.setUserId(callRecord.getUserId() != null ? String.valueOf(callRecord.getUserId()) : "");
                model.setClientId(callRecord.getClientId() != null ? String.valueOf(callRecord.getClientId()) : "");
                model.setRemark(callRecord.getRemark() == null ? "" : callRecord.getRemark());

                i++;
                modelList.add(model);
            }

            // 执行excel操作
            EasyExcelUtils.exportXlsxFile(modelList, response, CallRecordModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("callrecord:info")
    public Result info(@PathVariable("id") Long id) {
        CallRecordEntity callRecord = callRecordService.queryObject(id);

        return Result.ok().put("callRecord", callRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("callrecord:save")
    public Result save(@RequestBody CallRecordEntity callRecord) {
        callRecordService.save(callRecord);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("callrecord:update")
    public Result update(@RequestBody CallRecordEntity callRecord) {
        callRecordService.update(callRecord);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("callrecord:delete")
    public Result delete(@RequestBody Long[] ids) {
        callRecordService.deleteBatch(ids);

        return Result.ok();
    }

}
