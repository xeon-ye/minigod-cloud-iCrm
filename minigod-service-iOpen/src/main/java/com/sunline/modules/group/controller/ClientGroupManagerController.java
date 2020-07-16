package com.sunline.modules.group.controller;

import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.group.entity.ClientGroupManagerEntity;
import com.sunline.modules.group.service.ClientGroupManagerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 客户分组管理
 *
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Controller
@RequestMapping("clientGroupManager")
public class ClientGroupManagerController extends BaseController {
    @Autowired
    private ClientGroupManagerService clientGroupManagerService;

    /**
     * 分组列表
     *
     * @param model
     * @param clientGroupManagerEntity
     * @param request
     * @return
     */
    @RequestMapping("/groupList")
    @RequiresPermissions("clientGroupManager:groupList")
    public String groupList(Model model, ClientGroupManagerEntity clientGroupManagerEntity, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<ClientGroupManagerEntity> page = clientGroupManagerService.findPage(clientGroupManagerEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("info", clientGroupManagerEntity);
        return "group/customerGroupList";
    }

    /**
     * 新增分组页面
     *
     * @return
     */
    @RequestMapping("addGroup")
    public String addGroup() {
        return "group/addGroup";
    }

    /**
     * 保存
     *
     * @param
     * @param clientGroupManagerEntity
     * @param request
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public String save(ClientGroupManagerEntity clientGroupManagerEntity, HttpServletRequest request) {
        int count = clientGroupManagerService.save(clientGroupManagerEntity);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS","-1");
        }
    }

    /**
     * 修改分组
     *
     * @param model
     * @param clientGroupManagerEntity
     * @param request
     * @return
     */
    @RequestMapping("updateGroup")
    public String updateGroup(Model model, ClientGroupManagerEntity clientGroupManagerEntity, HttpServletRequest request) {
            clientGroupManagerEntity = clientGroupManagerService.queryObject(Integer.parseInt(request.getParameter("id")));
            model.addAttribute("info", clientGroupManagerEntity);
            return "group/updateGroup";
    }


    /**
     * 修改分组
     *
     * @param clientGroupManagerEntity
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public String update(ClientGroupManagerEntity clientGroupManagerEntity, HttpServletRequest request) {
        int count =  clientGroupManagerService.update(clientGroupManagerEntity);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS","-1");
        }
    }

    /**
     * 删除分组
     *
     * @param request
     * @return
     */
    @RequestMapping("deleteGroup")
    @ResponseBody
    public String deleteGroup(HttpServletRequest request) {
        String id = request.getParameter("id");
        int count  = clientGroupManagerService.delete(Integer.parseInt(id));if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS","-1");
        }
    }

    /**
     * 按分组编号查询是否已存在
     *
     * @param request
     * @param clientGroupManagerEntity
     * @return
     */
    @RequestMapping("queryByGroupNo")
    @ResponseBody
    public String queryByGroupNo(HttpServletRequest request, ClientGroupManagerEntity clientGroupManagerEntity) {
        clientGroupManagerEntity.setGroupNo(Integer.parseInt(request.getParameter("groupNo")));
        int count = clientGroupManagerService.queryByGroupNo(clientGroupManagerEntity);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","-2");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        }
    }

    /**
     * 按分组名称查询是否已存在
     *
     * @param request
     * @param clientGroupManagerEntity
     * @return
     */
    @RequestMapping("queryByGroupName")
    @ResponseBody
    public String queryByGroupName(HttpServletRequest request, ClientGroupManagerEntity clientGroupManagerEntity) {
        clientGroupManagerEntity.setGroupName(request.getParameter("groupName"));
        int count = clientGroupManagerService.queryByGroupName(clientGroupManagerEntity);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","-2");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        }
    }
}
