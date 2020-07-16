package com.sunline.modules.group.controller;

import com.google.common.collect.Maps;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageData;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.group.entity.ClientGroupManagerEntity;
import com.sunline.modules.group.entity.ClientGroupMemberInfoEntity;
import com.sunline.modules.group.service.ClientGroupManagerService;
import com.sunline.modules.group.service.ClientGroupMemberInfoService;
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
import java.util.regex.Pattern;


/**
 * 客户分组管理
 *
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Controller
@RequestMapping("clientGroupMemberInfo")
public class ClientGroupMemberInfoController extends BaseController {
    //文件上传路径
    public static final String FILE_PATH_FILE = "template/upload/excel";

    @Autowired
    private ClientGroupMemberInfoService clientGroupMemberInfoService;
    @Autowired
    private SecUserInfoService secUserInfoService;
    @Autowired
    private ClientGroupManagerService clientGroupManagerService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 分组成员列表
     *
     * @param model
     * @param clientGroupMemberInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("list")
    public String groupList(Model model, ClientGroupMemberInfoEntity clientGroupMemberInfoEntity, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        String groupNo = request.getParameter("groupNo");
        request.setAttribute("groupNo", groupNo);
        String groupType = request.getParameter("groupType");
        request.setAttribute("groupType", groupType);
        if (clientGroupMemberInfoEntity.getGroupNo() == null || "".equals(clientGroupMemberInfoEntity.getGroupNo())) {
            clientGroupMemberInfoEntity.setGroupNo(Integer.parseInt(groupNo));
        }
        if (1 == Integer.parseInt(request.getParameter("groupType"))) {
            Page<ClientGroupMemberInfoEntity> page = clientGroupMemberInfoService.findPage(clientGroupMemberInfoEntity, pageNum);
            model.addAttribute("page", page);
            model.addAttribute("ClientGroupMemberInfoEntity", clientGroupMemberInfoEntity);
            return "group/groupMemberListNoCrm";
        } else {
            if(getUserId().equals(Constant.SUPERR_USER)){
                clientGroupMemberInfoEntity.setChannelIds(null);
            }else{
                clientGroupMemberInfoEntity.setChannelIds(getChannelIds());
            }

            if(clientGroupMemberInfoEntity.getCheckedChannelId()!=null&&!"".equals(clientGroupMemberInfoEntity.getCheckedChannelId())){
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientGroupMemberInfoEntity.getCheckedChannelId());
                if(checkedChannelIds!=null && checkedChannelIds.size()>0){
                    clientGroupMemberInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            Page<ClientGroupMemberInfoEntity> page = clientGroupMemberInfoService.groupListPage(clientGroupMemberInfoEntity, pageNum);
            model.addAttribute("page", page);
            model.addAttribute("ClientGroupMemberInfoEntity", clientGroupMemberInfoEntity);
            return "group/groupMemberList";
        }
    }

    /**
     * 分组成员新增
     *
     * @param model
     * @param securitiesUserInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("addCustomerList")
    public String list(Model model, SecuritiesUserInfoEntity securitiesUserInfoEntity, HttpServletRequest request) {
        String groupNo = request.getParameter("groupNo");
        request.setAttribute("groupNo", groupNo);
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        securitiesUserInfoEntity.setGroupNo(groupNo);
        if(getUserId().equals(Constant.SUPERR_USER)){
            securitiesUserInfoEntity.setChannelIds(null);
        }else{
            securitiesUserInfoEntity.setChannelIds(getChannelIds());
        }
        Page<SecuritiesUserInfoEntity> page = secUserInfoService.findPageFilter(securitiesUserInfoEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("model", securitiesUserInfoEntity);
        return "group/addCustomerList";
    }

    /**
     * 变更成员组列表
     *
     * @param model
     * @param clientGroupManagerEntity
     * @param request
     * @return
     */
    @RequestMapping("/updateInit")
    public String updateInit(Model model, ClientGroupManagerEntity clientGroupManagerEntity, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        clientGroupManagerEntity.setGroupType("0");
        Page<ClientGroupManagerEntity> page = clientGroupManagerService.findPage(clientGroupManagerEntity, pageNum);
        String tradeAccounts = request.getParameter("tradeAccounts");
        model.addAttribute("page", page);
        model.addAttribute("clientGroupManagerEntity", clientGroupManagerEntity);
        model.addAttribute("tradeAccounts", tradeAccounts);
        return "group/updateInitList";
    }

    /**
     * 批量变更成员 所在组
     *
     * @param request
     * @param clientGroupMemberInfoEntity
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public String update(HttpServletRequest request, ClientGroupMemberInfoEntity clientGroupMemberInfoEntity) {
        String groupNo = request.getParameter("groupNo");
        String[] tradeAccounts = request.getParameter("tradeAccounts").split(",");
        for (String tradeAccount : tradeAccounts) {
            clientGroupMemberInfoEntity.setGroupNo(Integer.parseInt(groupNo));
            clientGroupMemberInfoEntity.setClientId(Integer.parseInt(tradeAccount));
            clientGroupMemberInfoService.updateGroup(clientGroupMemberInfoEntity);
        }
        List<ClientGroupMemberInfoEntity> list = clientGroupMemberInfoService.selectRepeat();
        Integer[] ids = new Integer[list.size()];
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ids[i] = Integer.parseInt(list.get(i).getId());
            }
            clientGroupMemberInfoService.deleteBatch(ids);
        }
        return CodeUtils.getCodeName("COMMON_STATUS","1");
    }


    /**
     * 新增成员
     *
     * @param clientGroupMemberInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public String add(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity, HttpServletRequest request) {
        String tradeAccount_s = request.getParameter("tradeAccounts");
        String[] tradeAccounts = tradeAccount_s.split(",");
        String groupNo = request.getParameter("groupNo");
        int count = 0;
        for (int i = 0; i < tradeAccounts.length; i++) {
            clientGroupMemberInfoEntity.setClientId(Integer.parseInt(tradeAccounts[i]));
            clientGroupMemberInfoEntity.setGroupNo(Integer.parseInt(groupNo));
            clientGroupMemberInfoEntity.setRemark("");
            count += clientGroupMemberInfoService.save(clientGroupMemberInfoEntity);
        }
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        }
        return CodeUtils.getCodeName("COMMON_STATUS","-1");
    }

    /**
     * 删除成员
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
        int count = clientGroupMemberInfoService.deleteBatch(ids);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        }
        return CodeUtils.getCodeName("COMMON_STATUS","-1");
    }

    /**
     * 添加所有
     *
     * @param request
     * @param clientGroupMemberInfoEntity
     * @return
     */
    @RequestMapping("addAll")
    @ResponseBody
    public String addAll(HttpServletRequest request, ClientGroupMemberInfoEntity clientGroupMemberInfoEntity) {
        String groupNo = request.getParameter("groupNo");
        SecuritiesUserInfoEntity userInfo = new SecuritiesUserInfoEntity();
        userInfo.setGroupNo(groupNo);
        if(getUserId().equals(Constant.SUPERR_USER)){
            userInfo.setChannelIds(null);
        }else{
            userInfo.setChannelIds(getChannelIds());
        }
        List<SecuritiesUserInfoEntity> queryList = secUserInfoService.queryListFilter(userInfo);
        for (SecuritiesUserInfoEntity s : queryList) {
            clientGroupMemberInfoEntity.setClientId(Integer.parseInt(s.getTradeAccount()));
            clientGroupMemberInfoEntity.setGroupNo(Integer.parseInt(groupNo));
            clientGroupMemberInfoEntity.setRemark("");
            clientGroupMemberInfoService.save(clientGroupMemberInfoEntity);
        }
        return CodeUtils.getCodeName("COMMON_STATUS","1");
    }

    /**
     * 删除所有成员
     *
     * @param request
     * @return
     */
    @RequestMapping("deleteAll")
    @ResponseBody
    public String deleteAll(HttpServletRequest request) {
        String groupNo = request.getParameter("groupNo");
        int count = clientGroupMemberInfoService.deleteAll(Integer.parseInt(groupNo));
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS","1");
        }
        return CodeUtils.getCodeName("COMMON_STATUS","-1");
    }

    /**
     * CRM成员Excle导出
     *
     * @param clientGroupMemberInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/clientGroupExpExcel")
    @RequiresPermissions("securitiesUserInfo:crmExp")
    @SysLog("非CRM成员导出")
    public ModelAndView clientGroupExpExcel(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String groupNo = request.getParameter("groupNo");
        clientGroupMemberInfoEntity.setGroupNo(Integer.parseInt(groupNo));
        try {
            if(getUserId().equals(Constant.SUPERR_USER)){
                clientGroupMemberInfoEntity.setChannelIds(null);
            }else{
                clientGroupMemberInfoEntity.setChannelIds(getChannelIds());
            }
            if(clientGroupMemberInfoEntity.getCheckedChannelId()!=null&&!"".equals(clientGroupMemberInfoEntity.getCheckedChannelId())){
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientGroupMemberInfoEntity.getCheckedChannelId());
                if(checkedChannelIds!=null && checkedChannelIds.size()>0){
                    clientGroupMemberInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            List<ClientGroupMemberInfoEntity> clientList = clientGroupMemberInfoService.clientGroupExpExcelList(clientGroupMemberInfoEntity);
            Map<String, Object> dataMap = Maps.newHashMap();
            List<String> titles = new ArrayList<String>();
            // 定义表头
            titles.add("序号");
            titles.add("客户编号");
            titles.add("客户姓名");
            titles.add("客户类型");
            titles.add("客户状态");
            titles.add("开户日期");
            titles.add("出生日期");
            titles.add("性别");

            dataMap.put("titles", titles);
            List<PageData> varList = new ArrayList<PageData>();
            for (int i = 0; i < clientList.size(); i++) {
                PageData vpd = new PageData();
                // 填充数据
                vpd.put("var1", String.valueOf(i + 1));
                vpd.put("var2", clientList.get(i).getGid() != null ? clientList.get(i).getGid().toString() : "");
                vpd.put("var3", clientList.get(i).getClientName()!=null?clientList.get(i).getClientName().toString():"");
                vpd.put("var4", CodeUtils.getCodeName("SEC_CLIENT_TYPE",clientList.get(i).getClientType()));
                vpd.put("var5", CodeUtils.getCodeName("SEC_CLIENT_STATUS",clientList.get(i).getClientStatus()));
                vpd.put("var6", clientList.get(i).getOpenAccountTime()!=null?clientList.get(i).getOpenAccountTime().toString():"");
                vpd.put("var7", clientList.get(i).getBirthday()!=null?clientList.get(i).getBirthday().toString():"");
                vpd.put("var8", CodeUtils.getCodeName("COMMON_SEX",clientList.get(i).getSex()));
                varList.add(vpd);
            }
            dataMap.put("varList", varList);
            // 执行excel操作
            ObjectExcelView erv = new ObjectExcelView();
            mv = new ModelAndView(erv, dataMap);
        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
        return mv;
    }


    /**
     * CRM成员Excle导出
     *
     * @param clientGroupMemberInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/clientGroupNocrmExpExcel")
    @RequiresPermissions("securitiesUserInfo:notCrmExp")
    @SysLog("非CRM成员导出")
    public ModelAndView clientGroupNocrmExpExcel(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String groupNo = request.getParameter("groupNo");
        clientGroupMemberInfoEntity.setGroupNo(Integer.parseInt(groupNo));
        try {
            if(getUserId().equals(Constant.SUPERR_USER)){
                clientGroupMemberInfoEntity.setChannelIds(null);
            }else{
                clientGroupMemberInfoEntity.setChannelIds(getChannelIds());
            }
            List<ClientGroupMemberInfoEntity> clientList = clientGroupMemberInfoService.query(clientGroupMemberInfoEntity);
            Map<String, Object> dataMap = Maps.newHashMap();
            List<String> titles = new ArrayList<String>();
            // 定义表头
            titles.add("序号");
            titles.add("客户姓名");
            titles.add("手机号");
            titles.add("电子邮箱");
            titles.add("备注");

            dataMap.put("titles", titles);
            List<PageData> varList = new ArrayList<PageData>();
            for (int i = 0; i < clientList.size(); i++) {
                PageData vpd = new PageData();
                // 填充数据
                vpd.put("var1", String.valueOf(i + 1));
                vpd.put("var2", clientList.get(i).getClientName());
                vpd.put("var3", clientList.get(i).getPhoneNumber().toString());
                vpd.put("var4", clientList.get(i).getEmail());
                vpd.put("var5", clientList.get(i).getRemark());

                varList.add(vpd);
            }
            dataMap.put("varList", varList);
            // 执行excel操作
            ObjectExcelView erv = new ObjectExcelView();
            mv = new ModelAndView(erv, dataMap);
        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
        return mv;
    }


    /**
     * 跳转上传页面
     *
     * @return
     */
    @RequestMapping("/goUploadExcel")
    public String goUploadExcel(HttpServletRequest request) {
        String groupNo = request.getParameter("groupNo");
        request.setAttribute("groupNo",groupNo);
        return "group/uploadExcel";
    }

    /**
     * 下载Excel模板
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/downExcel")
    public void downExcel(HttpServletResponse response) throws Exception {
        FileDownload.fileDownload(response, Thread.currentThread().getContextClassLoader().getResource("").getPath() + "template/excel/" + "clientMould.xlsx", "client.xlsx");
    }

    /**
     * 从Excel文件导入到数据库
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/clientImportExcle")
    @RequiresPermissions("clientGroupMemberInfo:imp")
    @ResponseBody
    public String clientImportExcle(@RequestParam(value = "excel", required = false) MultipartFile file, HttpServletRequest request) {
        //存入数据库条数
        int count = 0;
        Object excleModel = null;
        String groupNo = request.getParameter("groupNo");
        try {
            if (null != file && !file.isEmpty()) {
                // 文件上传路径
                String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+File.separator + FILE_PATH_FILE;
                // 执行上传
                String fileName = FileUpload.fileUp(file, filePath, "client" + System.currentTimeMillis());
                // 执行读EXCEL操作
                List<PageData> listPd = (List) ObjectExcelRead.readExcel(file);
                List<ClientGroupMemberInfoEntity> clientList = new ArrayList<>();
                // 读取数据
                for (int i = 0; i < listPd.size(); i++) {
                    ClientGroupMemberInfoEntity client = new ClientGroupMemberInfoEntity();
                    //验证手机号格式
                    String phone = "^1[345789]\\d{9}$";
                    Pattern pattern = Pattern.compile(phone);
                    excleModel = listPd.get(i);
                    String[] excle = (String[]) excleModel;
                    if(excle[2]!=null&&!"".equals(excle[2])){
                        if (!pattern.matcher(excle[2].toString()).matches()) {
                            return CodeUtils.getCodeName("COMMON_STATUS","-1");
                        }else{
                            client.setPhoneNumber(excle[2].toString());
                        }
                    }else{
                        client.setPhoneNumber("");
                    }
                    //验证邮箱
                    String email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                    pattern = Pattern.compile(email);
                    String s = excle[3];
                    if(excle[3]!=null&&!"".equals(excle[3])){
                        if(!pattern.matcher(excle[3].toString()).matches()){
                            return CodeUtils.getCodeName("COMMON_STATUS","-1");
                        }else{
                            client.setEmail(excle[3].toString());
                        }
                    }else{
                        client.setEmail("");
                    }
                    client.setClientName(excle[1]!=null?excle[1].toString():"");
                    client.setRemark(excle[4]!=null?excle[4].toString():"");
                    client.setGroupNo(Integer.parseInt(groupNo));
                    client.setClientId(0);
                    clientList.add(client);
                }

                for (ClientGroupMemberInfoEntity c: clientList) {
                    count+=clientGroupMemberInfoService.save(c);
                }
                if(count == clientList.size()){
                    return "导入成功！";
                }
            }
        } catch (Exception e) {
            logger.error("导入Excel文件异常", e);
        }
        return "导入Excel文件异常";
    }
}
