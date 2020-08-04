package com.sunline.modules.fund.controller;

import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.fund.entity.DbsIccBankFlowEntity;
import com.sunline.modules.fund.entity.DepositBankBillFlowEntity;
import com.sunline.modules.fund.service.DbsIccBankFlowService;
import com.sunline.modules.fund.service.DepositBankBillFlowService;
import org.apache.commons.lang3.StringUtils;
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


/**
 * DBS银行流水推送
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-03-05 13:28:58
 */
@Controller
@RequestMapping("dbsIccBankFlow")
public class DbsIccBankFlowController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DbsIccBankFlowController.class);

    @Autowired
    private DbsIccBankFlowService dbsIccBankFlowService;
    @Autowired
    private DepositBankBillFlowService depositBankBillFlowService;

    /**
     * 核对列表
     *
     * @param model
     * @param request
     * @param queryCondition
     * @return
     */
    @RequestMapping(value = "/iccBankCheckList")
    @RequiresPermissions("dbsIccBankFlow:check")
    public String toBankCheckPage(Model model, HttpServletRequest request, DepositBankBillFlowEntity queryCondition) {
        try {
            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            //查询未核对的流水
            queryCondition.setFlowSource(1);
            queryCondition.setCheckStatus(0);
            queryCondition.setAssignDrafter(getUserId());
            Page<DepositBankBillFlowEntity> page = depositBankBillFlowService.queryPage(queryCondition, pageNum);
            model.addAttribute("page", page);
            model.addAttribute("params", queryCondition);
            model.addAttribute("currentUserId", getUserId());
        } catch (Exception e) {
            logger.error("跳转dbs银行流水列表异常", e);
        }
        return "fund/deposit/dbs/iccBankCheckList";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(DbsIccBankFlowEntity formData) {
        try {

            formData.setCreateTime(new Date());
            formData.setUpdateTime(new Date());
            dbsIccBankFlowService.update(formData);

            return Result.ok();
        } catch (Exception e) {
            logger.info("修改失败：", e);
            return Result.error("修改失败");
        }
    }

    /**
     * 批量修改
     */
    @RequestMapping("/updateBatch")
    @ResponseBody
    public Result updateBatch(String ids, Integer isApply, String assignDrafter) {

        try {

            if (StringUtils.isEmpty(ids)) {
                throw new MyException("没有勾选需要记录");
            }

            String[] idArray = ids.split(",");

            for (String id : idArray) {
                DbsIccBankFlowEntity entity = new DbsIccBankFlowEntity();
                entity.setId(Long.valueOf(id));
                entity.setIsApply(isApply);
                if (StringUtils.isNotBlank(assignDrafter)) {
                    entity.setAssignDrafter(assignDrafter);
                }
                entity.setCreateTime(new Date());
                entity.setUpdateTime(new Date());
                int count = dbsIccBankFlowService.update(entity);

                if (count > 0 && StringUtils.isBlank(assignDrafter)) {
                    DbsIccBankFlowEntity dbsIccBankFlowEntity = new DbsIccBankFlowEntity();
                    dbsIccBankFlowEntity.setId(Long.valueOf(id));
                    dbsIccBankFlowEntity.setIsApply(isApply);
                    dbsIccBankFlowEntity.setAssignDrafter(null);
                    dbsIccBankFlowEntity.setUpdateTime(new Date());
                    dbsIccBankFlowService.updateAssignDrafterById(dbsIccBankFlowEntity);
                }
            }

            return Result.ok();
        } catch (Exception e) {
            logger.info("修改失败：", e);
            return Result.error("修改失败");
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(Long id) {
        DbsIccBankFlowEntity dbsIccBankFlowEntity = dbsIccBankFlowService.queryObject(id);
        if (StringUtils.isNotBlank(dbsIccBankFlowEntity.getApplicationId())) {
            return Result.error("该条记录已绑定入金申请:" + dbsIccBankFlowEntity.getApplicationId());
        } else {
            dbsIccBankFlowService.delete(id);

            return Result.ok("删除成功");
        }
    }

}
