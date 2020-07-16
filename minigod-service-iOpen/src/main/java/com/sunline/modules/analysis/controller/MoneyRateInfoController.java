package com.sunline.modules.analysis.controller;

import com.google.common.collect.Lists;
import com.sunline.modules.analysis.entity.MoneyRateInfoEntity;
import com.sunline.modules.analysis.model.MoneyRateInfoModel;
import com.sunline.modules.analysis.service.MoneyRateInfoService;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageData;
import com.sunline.modules.common.utils.*;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 汇率查询
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-03 13:15:29
 */
@Controller
@RequestMapping("moneyRateInfo")
public class MoneyRateInfoController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 文件上传路径
     */
    public static final String FILE_PATH_FILE = "template/upload/excel";

    @Autowired
    private MoneyRateInfoService moneyRateInfoService;

    /**
     * 汇率查询
     *
     * @param model
     * @param moneyRateInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/getMoneyRateInfoList")
    @RequiresPermissions("getMoneyRateInfoList:list")
    public String getMoneyRateInfoList(Model model, MoneyRateInfoEntity moneyRateInfoEntity, HttpServletRequest request) {

        // 默认查询港币兑换汇率
        if (null == moneyRateInfoEntity.getToMoneyType() || "".equals(moneyRateInfoEntity.getToMoneyType())) {
            moneyRateInfoEntity.setToMoneyType(CrmCommonEnum.SecMoneyType.SEC_MONEY_TYPE_HKD.getIndex());
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<MoneyRateInfoEntity> page = moneyRateInfoService.findPage(moneyRateInfoEntity, pageNum);

        // 把默认查询日期返回前端
        moneyRateInfoEntity.setInitDate(page.getResult().size() > 0 ? page.getResult().get(0).getInitDate() : moneyRateInfoEntity.getInitDate());

        model.addAttribute("page", page);
        model.addAttribute("params", moneyRateInfoEntity);
        return "analysis/moneyRateInfoList";
    }

    /**
     * 跳转上传页面
     *
     * @return
     */
    @RequestMapping("/goUploadExcel")
    public String goUploadExcel() {
        return "analysis/uploadExcel";
    }

    /**
     * 汇率查询导出Excel
     *
     * @param moneyRateInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/moneyRateListExpExcel")
    @RequiresPermissions("moneyRateListExpExcel:exp")
    public void moneyRateInfoListExpExcel(MoneyRateInfoEntity moneyRateInfoEntity, HttpServletRequest request,HttpServletResponse response) {
        try {

            List<MoneyRateInfoEntity> moneyRateInfoList = moneyRateInfoService.findMoneyRateListExcelList(moneyRateInfoEntity);

            List<MoneyRateInfoModel> modelList = Lists.newArrayList();
            for (int i = 0; i < moneyRateInfoList.size(); i++) {
                MoneyRateInfoModel model = new MoneyRateInfoModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setFromMoneyType(moneyRateInfoList.get(i).getFromMoneyType() != null ? CrmCommonEnum.SecMoneyType.getName(moneyRateInfoList.get(i).getFromMoneyType()) : "");
                model.setToMoneyType(moneyRateInfoList.get(i).getToMoneyType() != null ? CrmCommonEnum.SecMoneyType.getName(moneyRateInfoList.get(i).getToMoneyType()) :"");
                model.setExchangeRate(moneyRateInfoList.get(i).getExchangeRate().toString());
                model.setInitDate(moneyRateInfoList.get(i).getInitDate().toString());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, MoneyRateInfoModel.class);
        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 下载Excel模板
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/downExcel")
    public void downExcel(HttpServletResponse response) throws Exception {
        FileDownload.fileDownload(response, Thread.currentThread().getContextClassLoader().getResource("").getPath() + "template/excel/" + "test.xlsx", "Users.xlsx");
    }

    /**
     * 从Excel文件导入到数据库
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/moneyRateInfoListImpExcel")
    @RequiresPermissions("moneyRateListExpExcel:imp")
    @ResponseBody
    public String moneyRateInfoListImpExcel(@RequestParam(value = "excel", required = false) MultipartFile file, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        PageData pd = new PageData();
        // 记录成功上传条数
        int count = 0;

        try {
            if (null != file && !file.isEmpty()) {


                // 文件上传路径
                String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + File.separator + FILE_PATH_FILE;
                // 执行上传
                String fileName = FileUpload.fileUp(file, filePath, "Users");

//                // hutool工具包 TODO
//                ExcelReader reader = ExcelUtil.getReader(filePath+"\\"+fileName);
//                List<List<Object>> readAll = reader.read();

                // 执行读EXCEL操作
                List<PageData> listPd = (List) ObjectExcelRead.readExcel(file);

                // 读取数据
                for (int i = 0; i < listPd.size(); i++) {
//                userService.saveU(pd);
                    count++;
                }

                // 存入数据库操作

//                mv.addObject("msg", "success");
//                mv.addObject("info", "'成功导入" + count + "条记录，'+" + "'导入失败" + (listPd.size() - count) + "条记录！'");
            }

            return "ok";
        } catch (Exception e) {
            logger.error("导入Excel文件异常", e);
        }

        return "error";
    }
}
