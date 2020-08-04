package com.sunline.modules.notice.controller;

import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.PageUtils;
import com.sunline.modules.common.utils.Query;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description: 消息发送日志
 * @author: Larry Lai
 * @date: 2018/9/29 15:17
 * @version: v1.0
 */

@RestController
@RequestMapping("messageSendInfo")
public class MessageSendInfoController extends BaseController {
    @Autowired
    private MessageSendInfoService messageSendInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("messageSendInfo:list")
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<MessageSendInfoEntity> messageSendInfoList = messageSendInfoService.queryList(query);
        int total = messageSendInfoService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(messageSendInfoList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("messageSendInfo:info")
    public Result info(@PathVariable("id") Integer id) {
        MessageSendInfoEntity messageSendInfo = messageSendInfoService.queryObject(id);

        return Result.ok().put("messageSendInfo", messageSendInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("messageSendInfo:save")
    public Result save(@RequestBody MessageSendInfoEntity messageSendInfo) {
        messageSendInfoService.save(messageSendInfo);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("messageSendInfo:update")
    public Result update(@RequestBody MessageSendInfoEntity messageSendInfo) {
        messageSendInfoService.update(messageSendInfo);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("messageSendInfo:delete")
    public Result delete(@RequestBody Integer[] ids) {
        messageSendInfoService.deleteBatch(ids);

        return Result.ok();
    }

}
