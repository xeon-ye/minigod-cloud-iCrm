package com.sunline.modules.report.controller;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.report.entity.UserDefinedSqlEntity;
import com.sunline.modules.report.service.UserDefinedSqlService;
import com.sunline.modules.sys.entity.UserWindowDto;
import com.sunline.modules.sys.service.OrganService;
import com.sunline.modules.sys.service.RoleService;
import com.sunline.modules.sys.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 自定义报表
 *
 * @author fuyy
 * @email
 * @date 2018-11-30 11:15:29
 */
@Controller
@RequestMapping("/userDefinedReport")
public class UserDefinedController extends BaseController {

    @Autowired
    private UserDefinedSqlService userDefinedSqlService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    OrganService organService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 自定义报表列表查询
     */
    @RequestMapping("/list")
    @RequiresPermissions("userDefinedReport:list")
    public String list(Model model, HttpServletRequest request, UserDefinedSqlEntity userDefinedSql) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        if (!UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
            userDefinedSql.setAuthUserList(UserUtils.getCurrentUserId());
        }
        Page<UserDefinedSqlEntity> page = userDefinedSqlService.findPage(userDefinedSql, pageNum);

        model.addAttribute("info", userDefinedSql);
        model.addAttribute("page", page);
        return "report/userDefinedReport";
    }

    /**
     * 自定义报表跳转到新增页面
     */
    @RequestMapping("/addUserDefinedReoprt")
    @RequiresPermissions("userDefinedReport:add")
    public String addUserDefinedReoprt(Model model) {
        UserDefinedSqlEntity userDefinedSql = new UserDefinedSqlEntity();
        userDefinedSql.setIsStatus(1);
        model.addAttribute("info", userDefinedSql);
        return "report/addUserDefinedReoprt";
    }

    /**
     * 保存
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public String save(Model model, UserDefinedSqlEntity userDefinedSql, HttpServletRequest request) {
        String defSql = userDefinedSql.getDefSql();
        if (defSql.toLowerCase().contains("insert") || defSql.toLowerCase().contains("update") || defSql.toLowerCase().contains("delete")) {
            return "SQL语句不能包含insert或者update或delete";
        }


        int count = userDefinedSqlService.save(userDefinedSql);
        model.addAttribute("id", count);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS", "1");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS", "-1");
        }
    }

    /**
     * 跳转到修改页面
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/updateUserDefinedReport")
    public String updateUserDefinedReport(Model model, HttpServletRequest request, Integer type) {
        UserDefinedSqlEntity userDefinedSql = userDefinedSqlService.queryObject(Integer.parseInt(request.getParameter("id")));
        model.addAttribute("info", userDefinedSql);
        model.addAttribute("type", type);
        return "report/updateUserDefinedReport";
    }

    /**
     * 修改
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public String update(UserDefinedSqlEntity userDefinedSql, HttpServletRequest request) {
        String defSql = userDefinedSql.getDefSql();
        if (defSql.toLowerCase().contains("insert") || defSql.toLowerCase().contains("update") || defSql.toLowerCase().contains("delete")) {
            return "SQL语句不能包含insert或者update或delete";
        }

        int count = userDefinedSqlService.update(userDefinedSql);

        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS", "1");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS", "-1");
        }

    }

    /**
     * 删除
     *
     * @param request
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public String delete(HttpServletRequest request) {
        String item_ids = request.getParameter("ids");
        String[] id = item_ids.split(",");
        Integer[] ids = new Integer[id.length];
        for (int i = 0; i < id.length; i++) {
            ids[i] = Integer.parseInt(id[i]);
        }
        int count = userDefinedSqlService.deleteBatch(ids);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS", "1");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS", "-1");
        }
    }

    /**
     * 运行
     *
     * @param request
     * @return
     */
    @RequestMapping("/runUserDefinedSQL")
    public String runUserDefinedSQL(Model model, HttpServletRequest request, UserDefinedSqlEntity userDefinedSql, String flag) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        String defSql = userDefinedSql.getDefSql();
        if (defSql.toLowerCase().contains("insert") || defSql.toLowerCase().contains("update") || defSql.toLowerCase().contains("delete")) {
            return "SQL语句不能包含insert或者update或delete";
        }

        Map<String, Object> map = Maps.newHashMap();

        if (StringUtils.isNotBlank(userDefinedSql.getParams())) {

            if (userDefinedSql.getParams().contains("|")) {
                String[] paramsArray = userDefinedSql.getParams().split("\\|");

                for (int i = 0; i < paramsArray.length; i++) {
                    if (defSql.contains("${1}")) {
                        defSql = userDefinedSql.getDefSql().replace("${1}", paramsArray[i]);
                    } else {
                        map.put(String.valueOf(i + 1), paramsArray[i]);
                    }
                }
            } else {
                map.put("1", userDefinedSql.getParams());
            }
        }

        map.put("defSql", defSql);

        Page<Object> page = userDefinedSqlService.findPageUserDefined(map, pageNum);

        if (userDefinedSql.getDefTitle() != null && !"".equals(userDefinedSql.getDefTitle())) {
            String[] fileTitleList = userDefinedSql.getDefTitle().split("\\|");
            model.addAttribute("fileTiltList", fileTitleList);
        }

        model.addAttribute("flag", flag);
        model.addAttribute("info", userDefinedSql);
        model.addAttribute("page", page);
        if ("1".equals(flag)) {
            return "report/addUserDefinedReoprt";
        } else {
            return "report/updateUserDefinedReport";
        }
    }


    /**
     * 导出Excel
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/userDefinedExpExcel")
    public void userDefinedExpExcel(UserDefinedSqlEntity userDefinedSql, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {

            Map<String, Object> map = Maps.newHashMap();
            String defSql = userDefinedSql.getDefSql();

            if (StringUtils.isNotBlank(userDefinedSql.getParams())) {

                if (userDefinedSql.getParams().contains("|")) {
                    String[] paramsArray = userDefinedSql.getParams().split("\\|");

                    for (int i = 0; i < paramsArray.length; i++) {
                        if (defSql.contains("${1}")) {
                            defSql = userDefinedSql.getDefSql().replace("${1}", paramsArray[i]);
                        } else {
                            map.put(String.valueOf(i + 1), paramsArray[i]);
                        }
                    }
                } else {
                    map.put("1", userDefinedSql.getParams());
                }
            }

            map.put("defSql", defSql);

            // 自定义表头
            String definedHeaders = userDefinedSql.getDefTitle();

            String[] headerArray = definedHeaders.split("\\|");
            List<LinkedHashMap<String, Object>> resultList = userDefinedSqlService.getUserDefinedExecl(map);

            List<List<String>> headers = Lists.newArrayList();
            for (int i = 0; i < headerArray.length; i++) {
                List<String> headColumn = Lists.newArrayList();
                headColumn.add(headerArray[i]);
                headers.add(headColumn);
            }

            // 数据集
            List<String> info;
            List<List<String>> list = Lists.newArrayList();

            for (int i = 0; i < resultList.size(); i++) {
                info = Lists.newArrayList();
                Iterator iter = resultList.get(i).entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    Object key = entry.getKey();
                    Object val = entry.getValue();

                    info.add(val != null ? val.toString() : "");
                }
                list.add(info);
            }
            //导出
            EasyExcelUtils.expDefinedHeaderXlsxFile(list, headers, response);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 跳转授权页面
     *
     * @param model
     * @param request
     * @param sqlId
     * @return
     */
    @RequestMapping("/toAuthTab")
    @RequiresPermissions("userDefinedReport:toAuthTab")
    public String toAuthTab(Model model, HttpServletRequest request, Integer sqlId, UserWindowDto userWindowDto, String type) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<UserWindowDto> page = null;
        if (StringUtils.isEmpty(type)) {
            //默认审批类型为用户级别的
            type = Constant.ExamineType.USER.getValue();
        }
        //类型为用户
        if (Constant.ExamineType.USER.getValue().equals(type)) {
            page = userService.findPage(userWindowDto, pageNum);
        } else if (Constant.ExamineType.ROLE.getValue().equals(type)) {
            //角色
            page = roleService.queryPageByDto(userWindowDto, pageNum);
        } else {
            //组织
            page = organService.queryPageByDto(userWindowDto, pageNum);
        }

        model.addAttribute("page", page);
        model.addAttribute("sqlId", sqlId);
        model.addAttribute("type", type);
        return "report/authTab";
    }

    /**
     * 授权
     *
     * @param userIds
     * @param sqlId
     * @return
     */
    @RequestMapping("/auth")
    @ResponseBody
    public Result auth(String userIds, Integer sqlId) {

        UserDefinedSqlEntity userDefinedSqlEntity = userDefinedSqlService.queryObject(sqlId);
        StringBuilder authUserStr = new StringBuilder();
        String authUserList = "";

        if (null != userDefinedSqlEntity.getAuthUserList() && userIds.contains("|")) {
            String[] userIdArray = userIds.split("\\|");
            for (String s : userIdArray) {
                if (!userDefinedSqlEntity.getAuthUserList().contains(s)) {
                    authUserStr.append(s).append("|");
                }
            }
            authUserList = authUserStr + userDefinedSqlEntity.getAuthUserList();
        } else {
            authUserList = userIds;
        }

//        authUserList.substring(0, authUserList.length() - 1);

        UserDefinedSqlEntity userDefinedSql = new UserDefinedSqlEntity();
        userDefinedSql.setId(sqlId);
        userDefinedSql.setAuthUserList(authUserList);
        int count = userDefinedSqlService.update(userDefinedSql);

        if (count > 0) {
            return Result.ok();
        } else {
            return Result.error("授权失败");
        }

    }
}
