package com.sunline.modules.fund.controller;

import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.fund.entity.DbsIccDepositConfigEntity;
import com.sunline.modules.fund.service.DbsIccDepositConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * DBS入金参数配置
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-03-04 16:45:18
 */
@Controller
@RequestMapping("dbsIccDepositConfig")
public class DbsIccDepositConfigController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DbsIccDepositConfigController.class);

    @Autowired
    private DbsIccDepositConfigService dbsIccDepositConfigService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dbsIccDepositConfig:list")
    public String list(Model model, DbsIccDepositConfigEntity queryCondition, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        Page<DbsIccDepositConfigEntity> page = dbsIccDepositConfigService.findPage(queryCondition, pageNum);

        model.addAttribute("page", page);
        model.addAttribute("params", queryCondition);

        return "fund/deposit/dbs/iccDepositConfigList";
    }

    /**
     * 跳转新增页面
     *
     * @return
     */
    @RequestMapping(value = "/toAddView")
    public String toAddView() {
        return "fund/deposit/dbs/addDbsDepConfigTab";
    }


    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("dbsIccDepositConfig:save")
    public Result save(DbsIccDepositConfigEntity formData) {

        DbsIccDepositConfigEntity queryCondition = new DbsIccDepositConfigEntity();
        queryCondition.setCcy(formData.getCcy());
        queryCondition.setIsInvalid(0);
        List<DbsIccDepositConfigEntity> dbsIccDepositConfigList = dbsIccDepositConfigService.queryListByBean(queryCondition);

        if (null != dbsIccDepositConfigList && dbsIccDepositConfigList.size() > 0) {
            throw new MyException("已存在该币种的有效设置信息，请检查！");
        }

        try {
            formData.setIsInvalid(0);
            formData.setCreateUser(UserUtils.getCurrentUserId());
            formData.setUpdateUser(UserUtils.getCurrentUserId());
            formData.setCreateTime(new Date());
            formData.setUpdateTime(new Date());
            dbsIccDepositConfigService.save(formData);

            return Result.ok("新增成功");
        } catch (Exception e) {
            logger.info("新增失败：", e);
            return Result.error("新增失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(DbsIccDepositConfigEntity formData) {
        try {
            formData.setUpdateUser(UserUtils.getCurrentUserId());
            formData.setCreateTime(new Date());
            formData.setUpdateTime(new Date());
            if (formData.getIsInvalid() == 1) {
                formData.setInvalidTime(new Date());
            }
            dbsIccDepositConfigService.update(formData);

            return Result.ok();
        } catch (Exception e) {
            logger.info("修改失败：", e);
            return Result.error("终止失败");
        }
    }

    /**
     * 跳转修改页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/toEditView")
    public String toEditView(Model model, Long id) {

        DbsIccDepositConfigEntity entity = dbsIccDepositConfigService.queryObject(id);
        model.addAttribute("info", entity);

        return "fund/deposit/dbs/editDbsDepConfigTab";
    }

    /**
     * 修改并保存历史
     */
    @RequestMapping("/updateSaveHis")
    @ResponseBody
    public Result updateSaveHis(DbsIccDepositConfigEntity formData) {
        try {
            // 记录为历史记录
            DbsIccDepositConfigEntity hisData = dbsIccDepositConfigService.queryObject(formData.getId());
            hisData.setIsInvalid(1);
            hisData.setUpdateUser(UserUtils.getCurrentUserId());
            hisData.setUpdateTime(new Date());
            hisData.setInvalidTime(new Date());
            dbsIccDepositConfigService.update(hisData);

            DbsIccDepositConfigEntity addData = new DbsIccDepositConfigEntity();
            addData.setMaxAmount(formData.getMaxAmount());
            addData.setValidTime(formData.getValidTime());
            addData.setIsInvalid(0);
            addData.setCcy(hisData.getCcy());
            addData.setCreateUser(UserUtils.getCurrentUserId());
            addData.setUpdateUser(UserUtils.getCurrentUserId());
            addData.setCreateTime(new Date());
            addData.setUpdateTime(new Date());
            dbsIccDepositConfigService.save(addData);

            return Result.ok();
        } catch (Exception e) {
            logger.info("修改失败：", e);
            return Result.error("修改失败");
        }
    }
}
