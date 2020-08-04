package com.sunline.modules.marker.controller;

import com.google.common.collect.Lists;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageData;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.ObjectExcelView;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.customer.model.CustomerSynModel;
import com.sunline.modules.marker.entity.CompBusiPersonEntity;
import com.sunline.modules.marker.model.CompBusiPersonModel;
import com.sunline.modules.marker.service.CompBusiPersonService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 公司业务人员管理
 *
 * @author jim
 * @email
 * @date 2018-04-27 17:19:01
 */
@Controller
@RequestMapping("companyBusinessPersonnel")
public class CompBusiPersonController extends BaseController {
    @Autowired
    private CompBusiPersonService compBusiPersonService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 业务人员管理列表
     *
     * @param model
     * @param request
     * @param compBusiPersonEntity
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, CompBusiPersonEntity compBusiPersonEntity) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<CompBusiPersonEntity> page = compBusiPersonService.findPage(compBusiPersonEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("model", compBusiPersonEntity);
        return "marker/companyBusPersonnelList";
    }

    /**
     * 修改 新增 页面
     *
     * @param model
     * @param request
     * @param compBusiPersonEntity
     * @return
     */
    @RequestMapping("/info")
    public String info(Model model, HttpServletRequest request, CompBusiPersonEntity compBusiPersonEntity) {
        String id = request.getParameter("id");
        String flag = request.getParameter("flag");
        // 新增 修改进入同一页面  修改根据ID查询结果 进行返回
        if (id != "" && id != null) {
            compBusiPersonEntity = compBusiPersonService.queryObject(Integer.parseInt(id));
            model.addAttribute("info", compBusiPersonEntity);
            //根据flag进入不同页面
            if(flag!=""&&flag!=null){
                model.addAttribute("flag", flag);
                return "marker/companyBusPersonnelShowInfo";

            }else{
                return "marker/companyBusUpdate";
            }
        }else{
            return "marker/companyBusSave";
        }
    }

    /**
     * 修改操作
     *
     * @param
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public String update(CompBusiPersonEntity compBusiPersonEntity, HttpServletRequest request) {
        int count = compBusiPersonService.update(compBusiPersonEntity);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS","-1");
        }
    }

    /**
     * 新增
     * @param
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(CompBusiPersonEntity compBusiPersonEntity, HttpServletRequest request) {
        int count = compBusiPersonService.save(compBusiPersonEntity);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS","-1");
        }
    }

    /**
     * 删除操作
     * @param request
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public String delete(HttpServletRequest request) {
        String person_ids = request.getParameter("ids");
        String[] id = person_ids.split(",");
        Integer[] ids = new Integer[id.length];
        for (int i = 0; i < id.length; i++) {
            ids[i] = Integer.parseInt(id[i]);
        }
        int count = compBusiPersonService.deleteBatch(ids);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS","-1");
        }
    }

    /**
     * 营销人员管理导出Excel
     *
     * @param compBusiPersonEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/comBusExpExcel")
    @RequiresPermissions("companyBusinessPersonnel:exp")
    @SysLog("营销人员管理导出")
    public void comBusExpExcel(CompBusiPersonEntity compBusiPersonEntity, HttpServletRequest request, HttpServletResponse response) {

        try {
            List<CompBusiPersonEntity> compBusiPerList = compBusiPersonService.comBusPerListExcelList(compBusiPersonEntity);

            List<CompBusiPersonModel> compBusiPersonModels = Lists.newArrayList();

            for(int i=0;i<compBusiPerList.size();i++){
                CompBusiPersonModel compBusiPersonModel = new CompBusiPersonModel();
                compBusiPersonModel.setId(i+1);
                compBusiPersonModel.setPersonnelName(compBusiPerList.get(i).getPersonnelName());
                compBusiPersonModel.setPersonnelRole(CodeUtils.getCodeName("SEC_PERSONNEL_ROLE",compBusiPerList.get(i).getPersonnelRole()));
                compBusiPersonModel.setSex(CodeUtils.getCodeName("COMMON_SEX",compBusiPerList.get(i).getSex()));
                compBusiPersonModel.setEducationType(CodeUtils.getCodeName("SEC_EDUCATION_TYPE",compBusiPerList.get(i).getEducationType()));
                compBusiPersonModel.setPersonnelStatus(CodeUtils.getCodeName("SEC_PERSONNEL_STATUS",compBusiPerList.get(i).getPersonnelStatus()));
                compBusiPersonModel.setBirthdayDate(compBusiPerList.get(i).getBirthdayDate()!=null ?compBusiPerList.get(i).getBirthdayDate():"" );
                compBusiPersonModel.setIdType(CodeUtils.getCodeName("SEC_ID_TYPE",compBusiPerList.get(i).getIdType()));
                compBusiPersonModel.setIdNo(compBusiPerList.get(i).getIdNo()!=null ? compBusiPerList.get(i).getIdNo().toString():"");
                compBusiPersonModel.setJobPosition(compBusiPerList.get(i).getJobPosition() != null ? compBusiPerList.get(i).getJobPosition().toString():"");
                compBusiPersonModel.setSacNo(compBusiPerList.get(i).getSacNo() != null ? compBusiPerList.get(i).getSacNo().toString() : "");
                compBusiPersonModel.setWitnessNo(compBusiPerList.get(i).getWitnessNo() !=null ? compBusiPerList.get(i).getWitnessNo().toString() : "");
                compBusiPersonModel.setOfficePhone(compBusiPerList.get(i).getOfficePhone() !=null ? compBusiPerList.get(i).getOfficePhone().toString() :"");
                compBusiPersonModel.setMobilePhone(compBusiPerList.get(i).getMobilePhone()!=null ? compBusiPerList.get(i).getMobilePhone().toString():"");
                compBusiPersonModel.setHomePhone(compBusiPerList.get(i).getHomePhone()!=null ? compBusiPerList.get(i).getHomePhone().toString():"");
                compBusiPersonModel.setFaxPhone(compBusiPerList.get(i).getFaxPhone()!=null ? compBusiPerList.get(i).getFaxPhone().toString():"");
                compBusiPersonModel.setContactAddress(compBusiPerList.get(i).getContactAddress()!=null ? compBusiPerList.get(i).getContactAddress():"");
                compBusiPersonModel.setPostCode(compBusiPerList.get(i).getPostCode()!=null ?compBusiPerList.get(i).getPostCode().toString() :"");
                compBusiPersonModel.setEmail(compBusiPerList.get(i).getEmail()!=null ? compBusiPerList.get(i).getEmail():"");
                compBusiPersonModel.setAeCode(compBusiPerList.get(i).getAeCode().toString());
                compBusiPersonModel.setCreateUser(compBusiPerList.get(i).getCreateUser());
                compBusiPersonModel.setCreateTime(compBusiPerList.get(i).getCreateTime());
                compBusiPersonModel.setMobilePhone(compBusiPerList.get(i).getModifyUser()!=null ? compBusiPerList.get(i).getModifyUser():"");
                compBusiPersonModel.setUpdateTime(compBusiPerList.get(i).getUpdateTime()!=null ? compBusiPerList.get(i).getUpdateTime():"");
                compBusiPersonModels.add(compBusiPersonModel);
            }

            EasyExcelUtils.exportXlsxFile(compBusiPersonModels, response,CompBusiPersonModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }

    }
}
