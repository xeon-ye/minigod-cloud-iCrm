package com.sunline.modules.customer.controller;

import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageData;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.customer.entity.TmkCustomerEntity;
import com.sunline.modules.customer.service.TmkCustomerService;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


/**
 * 电销客户管理信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-11-23 10:17:43
 */
@Controller
@RequestMapping("/tmkCustomer")
public class TmkCustomerController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TmkCustomerService tmkCustomerService;
    @Autowired
    RoleService roleService;

    private static final String FILE_PATH_FILE = "template/upload/excel";

    /**
     * 获取电销客户信息列表
     *
     * @param model
     * @param tmkCustomerEntity
     * @param request
     * @return
     */
    @RequestMapping("/getTmkCustomerList")
    @RequiresPermissions("tmkCustomer:list")
    public String groupList(Model model, TmkCustomerEntity tmkCustomerEntity, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");

        boolean flag = false;

        for (RoleEntity role : roleList) {
            if ("客服主管".equals(role.getName())) {
                flag = true;
            }
        }

        if (UserUtils.getCurrentUserId().equals(UserUtils.getManagerUser().getId())) {
            flag = true;
        }

        if (!flag) {
            tmkCustomerEntity.setOperator(UserUtils.getCurrentUser().getLoginName());
        }

        Page<TmkCustomerEntity> page = tmkCustomerService.findPage(tmkCustomerEntity, pageNum);

        tmkCustomerEntity.setOperator(null);

        model.addAttribute("page", page);
        model.addAttribute("params", tmkCustomerEntity);
        return "customer/tmkCustomerList";
    }

    /**
     * 条状登记页面
     *
     * @return
     */
    @RequestMapping("/toRegisterPage")
    public String toRegisterPage(Model model, TmkCustomerEntity tmkCustomerEntity, HttpServletRequest request) {

        TmkCustomerEntity tmkCustomerInfo = tmkCustomerService.queryObject(tmkCustomerEntity.getId());

        model.addAttribute("info", tmkCustomerInfo);

        return "customer/registerCustomerInfo";
    }

    /**
     * 登记
     *
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(Model model, TmkCustomerEntity tmkCustomerEntity, HttpServletRequest request) {

        tmkCustomerEntity.setUpdateTime(new Date());

        int count = tmkCustomerService.update(tmkCustomerEntity);

        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS", "1");
        }
        return CodeUtils.getCodeName("COMMON_STATUS", "-1");
    }

    /**
     * 跳转上传页面
     *
     * @return
     */
    @RequestMapping("/toUploadExcel")
    public String toUploadExcel(HttpServletRequest request) {
        return "customer/uploadExcel";
    }

    /**
     * 下载Excel模板
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/downExcel")
    public void downExcel(HttpServletResponse response) throws Exception {
        FileDownload.fileDownload(response, Thread.currentThread().getContextClassLoader().getResource("").getPath() + "template/excel/" + "telemarketing_customer_template.xls", "telemarketing_customer_template.xls");
    }

    /**
     * 从Excel文件导入到数据库
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/importExcle")
    @RequiresPermissions("tmkCustomer:imp")
    @ResponseBody
    public String importExcle(@RequestParam(value = "excel", required = false) MultipartFile file, HttpServletRequest request) {
        //存入数据库条数
        int count = 0;
        Object excleModel = null;
        try {
            if (null != file && !file.isEmpty()) {
                // 文件上传路径
                String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + File.separator + FILE_PATH_FILE;
                // 执行上传
                String fileName = FileUpload.fileUp(file, filePath, "telemarketing_customer_template" + System.currentTimeMillis());
                // 执行读EXCEL操作
                List<PageData> listPd = (List) ObjectExcelRead.readExcel(file);
                List<TmkCustomerEntity> tmkCustomerEntityList = new ArrayList<>();
                // 读取数据
                for (int i = 0; i < listPd.size(); i++) {
                    TmkCustomerEntity tmkCustomerEntity = new TmkCustomerEntity();

                    excleModel = listPd.get(i);
                    String[] excle = (String[]) excleModel;

//                    if (0 < excle.length) {
//                        tmkCustomerEntity.setDistributionDate(excle[0] != null ? excle[0].toString() : "");
//                    }

                    if (1 < excle.length) {
                        tmkCustomerEntity.setPhoneNumber(excle[1] != null ? excle[1].toString() : "");
                    }

                    if (2 < excle.length) {
                        tmkCustomerEntity.setIsOpenWechat(excle[2] != null ? excle[2].toString() : "");
                    }

                    if (3 < excle.length) {
                        tmkCustomerEntity.setSex(excle[3] != null ? excle[3].toString() : "");
                    }
                    if (4 < excle.length) {
                        tmkCustomerEntity.setStockExperience(excle[4] != null ? excle[4].toString() : "");
                    }
                    if (5 < excle.length) {
                        tmkCustomerEntity.setAssetLevel(excle[5] != null ? excle[5].toString() : "");
                    }
                    if (6 < excle.length) {
                        tmkCustomerEntity.setRemark(excle[6] != null ? excle[6].toString() : "");
                    }

                    if (7 < excle.length) {
                        tmkCustomerEntity.setOperator(excle[7] != null ? excle[7].toString() : "");
                    }

                    tmkCustomerEntity.setCreateTime(new Date());
                    tmkCustomerEntity.setUpdateTime(new Date());
                    tmkCustomerEntityList.add(tmkCustomerEntity);
                }

                for (TmkCustomerEntity tmkCustomer : tmkCustomerEntityList) {
                    count += tmkCustomerService.save(tmkCustomer);
                }

                if (count == tmkCustomerEntityList.size()) {
                    return "导入成功！";
                }
            }
        } catch (Exception e) {
            logger.error("导入Excel文件异常", e);
        }
        return "导入Excel文件异常";
    }

}
