package com.sunline.modules.sys.controller;


import com.sunline.component.shiro.VelocityShiro;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.common.annotation.DataAuth;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.fund.service.ClientFundDepositApplicationService;
import com.sunline.modules.stock.service.DonatedStockApplicationInfoService;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.MenuService;
import com.sunline.modules.sys.service.NoticeService;
import com.sunline.modules.sys.service.UserRoleService;
import com.sunline.modules.sys.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 系统用户表
 *
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2017-05-03 09:41:38
 */
@RestController
@RequestMapping("sys/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ActModelerService actModelerService;
    @Autowired
    private CustomerAccOpenService customerAccountOpenService;
    @Autowired
    private DonatedStockApplicationInfoService donatedStockService;
    @Autowired
    private ClientFundDepositApplicationService clientFundDepositApplicationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    @SysLog("查看系统用户列表")
    @DataAuth(tableAlias = "s")
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        StringBuilder orderRoleName = new StringBuilder();
        List<UserEntity> userList = userService.queryList(query);
        for (UserEntity user : userList) {
            List<String> roleList = userService.queryRoleName(user.getId());
            for (String roleName : roleList) {
                orderRoleName.append(roleName).append("|");
            }
            user.setOrderRoleName(orderRoleName.length() > 0 ? orderRoleName.substring(0, orderRoleName.length() - 1) : orderRoleName.toString());
            orderRoleName.setLength(0);
        }
        int total = userService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }

    /**
     * 列表
     */
    @RequestMapping("/userList")
    public Result userList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query userQuery = new Query(params);
        StringBuilder orderRoleName = new StringBuilder();
        List<UserEntity> userList = userService.queryList(userQuery);
        for (UserEntity user : userList) {
            List<String> roleList = userService.queryRoleName(user.getId());
            for (String roleName : roleList) {
                orderRoleName.append(roleName).append("|");
            }
            user.setOrderRoleName(orderRoleName.length() > 0 ? orderRoleName.substring(0, orderRoleName.length() - 1) : orderRoleName.toString());
            orderRoleName.setLength(0);
        }
        int userTotal = userService.queryTotal(userQuery);

        PageUtils pageUtil = new PageUtils(userList, userTotal, userQuery.getLimit(), userQuery.getPage());

        return Result.ok().put("userPage", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:user:info")
    @SysLog("查看系统用户信息")
    public Result info(@PathVariable("id") String id) {
        UserEntity user = userService.queryObject(id);
        if (user != null) {
            user.setPassWord("");
            user.setRoleIdList(userRoleService.queryRoleIdList(user.getId()));
        }
        return Result.ok().put("user", user);
    }

    /**
     * 主页用户信息
     */
    @RequestMapping("/info")
    public Result info() throws Exception {
        UserEntity user = userService.queryObject(ShiroUtils.getUserId());

        VelocityShiro shiro = new VelocityShiro();
        // 开户申请权限控制
        boolean openAccountApplyFlag = shiro.hasPermission("sys:notice:openAccount");
        // 通知权限控制
        boolean noticeFlag = shiro.hasPermission("sys:notice:info");
        // 待办控制
        boolean myUpcomingFlag = shiro.hasPermission("sys:notice:myUpcoming");
        // 赠股
        boolean stockNoticeFlag = shiro.hasPermission("donatedStock:stockNotice");

        boolean fundDepositApply = false;

        // 超级管理员不做权限控制
        if (UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
            openAccountApplyFlag = true;
            noticeFlag = true;
            myUpcomingFlag = true;
//            stockNoticeFlag = true;
//            fundDepositApply = true;
        }

        //入金申请跳转url
//        String fundDepositUrl = "";
//        if (shiro.hasPermission("clientFundDeposit:checkList")) {
//            fundDepositUrl = "clientFundDeposit/checkList";
//            fundDepositApply = true;
//        } else if (shiro.hasPermission("depositBankBillFlow:bankCheck")) {
//            fundDepositUrl = "depositBankBillFlow/bankCheckList";
//            fundDepositApply = true;
//        } else if (shiro.hasPermission("clientFundDeposit:accEntryList")) {
//            fundDepositUrl = "clientFundDeposit/accEntryList";
//            fundDepositApply = true;
//        }

        // 待办条数
        int myUpcomingCount = actModelerService.myUpcomingCount();
        // 我的通知条数
        int myNoticeCount = noticeService.MyNoticeCount();
        // 开户申请
        int myOpenApplicationCount = customerAccountOpenService.myOpenApplicationCount();
        //赠股条数
        int myStockNoticeCount = donatedStockService.myStockNoticeCount();
        //入金申请
        int myFundDepositCount = clientFundDepositApplicationService.myFundDepositCount();


        return Result.ok().put("user", user).put("myUpcomingCount", myUpcomingCount).put("myNoticeCount", myNoticeCount).put("myOpenApplicationCount", myOpenApplicationCount)
                .put("openAccountApplyFlag", openAccountApplyFlag)
                .put("noticeFlag", noticeFlag)
                .put("myUpcomingFlag", myUpcomingFlag)
//                .put("stockNoticeFlag", stockNoticeFlag)
                .put("myStockNoticeCount", myStockNoticeCount)
//                .put("fundDepositApply", fundDepositApply)
                .put("myFundDepositCount", myFundDepositCount);
//                .put("fundDepositUrl", fundDepositUrl);
    }

    /**
     * 主页通知信息（条数）
     */
    @RequestMapping("/noticeInfo")
    public Result noticeInfo() {
        //我的通知条数
        int myNoticeCount = noticeService.MyNoticeCount();
        return Result.ok().put("myNoticeCount", myNoticeCount);

    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:update")
    @SysLog("新增系统用户")
    public Result save(@RequestBody UserEntity user) {
        Result result = Result.ok();
        try {

            if (!ReUtil.rexCheckPassword(user.getPassWord())) {
                return Result.error("密码必须包含大小写字母、数字、特殊字符中的至少3种，且长度大于8");
            }

            userService.save(user);
        } catch (Exception e) {
            result = Result.error();
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @RequiresPermissions("sys:user:update")
    @SysLog("修改系统用户")
    public Result update(@RequestBody UserEntity user) {
        user.setPassWord(null);
        userService.update(user);

        return Result.ok();
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @SysLog("用户修改密码")
    public Result updatePassword(UserEntity user) {

        try {

            String passWord = AesEncryptUtil.desEncrypt(user.getPassWord(), Constant.KEY, Constant.IV).trim();
            String newPassWord = AesEncryptUtil.desEncrypt(user.getNewPassWord(), Constant.KEY, Constant.IV).trim();

            if (!ReUtil.rexCheckPassword(newPassWord)) {
                return Result.error("密码必须包含大小写字母、数字、特殊字符中的至少3种，且长度大于8");
            }

            user.setPassWord(passWord);
            user.setNewPassWord(newPassWord);

            int i = userService.updatePassword(user);
            if (i < 1) {
                return Result.error("更改密码失败，请输入正确的原密码");
            }

        } catch (Exception e) {
            logger.error("修改密码异常", e);
            return Result.error("更改密码失败");
        }

        return Result.ok("更改密码成功");
    }

    /**
     * 禁用
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    @SysLog("禁用系统用户")
    public Result delete(@RequestBody String[] ids) {
        userService.updateBatchStatus(ids, Constant.ABLE_STATUS.NO.getValue());
        return Result.ok();
    }

    /**
     * 启用
     */
    @RequestMapping("/enabled")
    @RequiresPermissions("sys:user:enabled")
    @SysLog("启用系统用户")
    public Result enabled(@RequestBody String[] ids) {
        userService.updateBatchStatus(ids, Constant.ABLE_STATUS.YES.getValue());
        return Result.ok();
    }

    /**
     * 重置密码
     */
    @RequestMapping("/reset")
    @RequiresPermissions("sys:user:reset")
    @SysLog("重置密码")
    public Result reset(@RequestBody String[] ids) {
        userService.resetPassWord(ids);
        return Result.ok("重置密码成功，密码为：" + Constant.DEF_PASSWORD);
    }

    @RequestMapping("/queryByLoginName")
    public Result queryByLoginName(@RequestBody String loginName) {
        UserEntity user = userService.queryByLoginName(loginName);
        if (user != null) {
            return Result.error();
        } else {
            return Result.ok().put("user", user);
        }
    }

}
