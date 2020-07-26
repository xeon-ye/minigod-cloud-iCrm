package com.sunline.modules.account.online.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.converter.CustomerOpenAccountConverter;
import com.sunline.modules.account.online.dao.CustomerAccountOpenApplyDao;
import com.sunline.modules.account.online.entity.*;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.account.online.helper.CustomerAccountOpenHelper;
import com.sunline.modules.account.online.helper.OpenImgGraphicsGenerate;
import com.sunline.modules.account.online.manager.CustomerAccountOpenManager;
import com.sunline.modules.account.online.model.*;
import com.sunline.modules.account.online.model.query.AccountOpenApplyAllotQuery;
import com.sunline.modules.account.online.protocol.OpenAccountImageInfo;
import com.sunline.modules.account.online.service.*;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.service.ExtendActTasklogService;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.RRException;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.sys.entity.CodeEntity;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.CodeService;
import com.sunline.modules.sys.service.RoleService;
import com.sunline.modules.sys.service.UserService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 类的功能描述.
 * 开户申请
 *
 * @Auther LiYangFeng
 * @Date 2017/7/25
 */
@RequestMapping("customer")
@Controller
public class CustomerAccountOpenController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerAccountOpenController.class);
    @Autowired
    CustomerAccOpenService customerAccountOpenService;
    @Autowired
    CustomerAccOpenApplyService customerAccOpenApplyService;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    CustomerAccOpenImageService customerAccountOpenImageService;
    @Autowired
    CodeService codeService;
    @Autowired
    CustomerAccountOpenManager customerAccountOpenManager;
    @Autowired
    UserService userService;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    OpenAccountTaxationInfoService openAccountTaxationInfoService;
    @Autowired
    OpenAccountOtherDisclosureService openAccountOtherDisclosureService;
    @Autowired
    OpenAccountPropertyTypeService openAccountPropertyTypeService;
    @Autowired
    RoleService roleService;
    @Autowired
    OpenAccountAdditionalFileService openAccountAdditionalFileService;
    @Autowired
    OpenAccountBankVerityInfoService openAccountBankVerityInfoService;
    @Autowired
    OpenAccountBlacklistService openAccountBlacklistService;
    @Autowired
    OpenAccountProcessLogService openAccountProcessLogService;
    @Autowired
    ExtendActTasklogService tasklogService;
    @Autowired
    CustomerAccountOpenApplyDao customerAccountOpenApplyDao;
    @Autowired
    private TaskService taskService;
    @Autowired
    private OpenAccountOperatorLogService openAccountOperatorLogService;
    @Autowired
    private OpenAccountCaVerityInfoService caVerityInfoService;

    private final String CUSTOMER_ACCOUNT_OPEN_OFFLINE_FLOW_MODEL_KEY = "customerAccountOpenApplicationOffline";

    private final String CUSTOMER_ACCOUNT_OPEN_ONLINE_FLOW_MODEL_KEY = "customerAccountOpenApplication";

    /**
     * 开户记录列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("customer:list")
    public String list(Model model, AccountOpenApplyQuery queryCondition, HttpServletRequest request) {
        String applicationTimeStart = queryCondition.getApplicationTimeStart();
        String applicationTimeEnd = queryCondition.getApplicationTimeEnd();
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        if (StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(applicationTimeStart)), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(applicationTimeEnd)) {
            queryCondition.setApplicationTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(applicationTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
        }
        Page<AccountOpenApplyDetailInfo> page = customerAccountOpenService.findPage(queryCondition, pageNum);

        if (StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(applicationTimeStart);
        }
        if (queryCondition.getApplicationTimeEnd() != null && StringUtils.isNotBlank(queryCondition.getApplicationTimeEnd())) {
            queryCondition.setApplicationTimeEnd(applicationTimeEnd);
        }
        model.addAttribute("queryCondition", queryCondition);
        model.addAttribute("page", page);
        return "account/online/openAcctList";
    }

    /**
     * 待开户列表
     */
    @RequestMapping("/waitOpenList")
    @RequiresPermissions("customer:waitOpenList")
    public String waitOpenList(Model model, AccountOpenApplyQuery queryCondition, HttpServletRequest request) {
        String applicationTimeStart = queryCondition.getApplicationTimeStart();
        String applicationTimeEnd = queryCondition.getApplicationTimeEnd();
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        if (StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(applicationTimeStart)), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(applicationTimeEnd)) {
            queryCondition.setApplicationTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(applicationTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
        }

        queryCondition.setCurrentNode("开户");
        queryCondition.setIsExpExcel(0);
        Page<AccountOpenApplyDetailInfo> page = customerAccountOpenService.findPage(queryCondition, pageNum);

        if (StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(applicationTimeStart);
        }
        if (queryCondition.getApplicationTimeEnd() != null && StringUtils.isNotBlank(queryCondition.getApplicationTimeEnd())) {
            queryCondition.setApplicationTimeEnd(applicationTimeEnd);
        }
        model.addAttribute("queryCondition", queryCondition);
        model.addAttribute("page", page);
        return "account/online/waitOpenList";
    }

    /**
     * 待确认列表
     */
    @RequestMapping("/waitConfirmList")
    @RequiresPermissions("customer:waitConfirmList")
    public String waitConfirmList(Model model, AccountOpenApplyQuery queryCondition, HttpServletRequest request) {
        String applicationTimeStart = queryCondition.getApplicationTimeStart();
        String applicationTimeEnd = queryCondition.getApplicationTimeEnd();
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        if (StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(applicationTimeStart)), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(applicationTimeEnd)) {
            queryCondition.setApplicationTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(applicationTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
        }

        queryCondition.setCurrentNode("开户");
        queryCondition.setIsExpExcel(1);
        Page<AccountOpenApplyDetailInfo> page = customerAccountOpenService.findPage(queryCondition, pageNum);

        if (StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(applicationTimeStart);
        }
        if (queryCondition.getApplicationTimeEnd() != null && StringUtils.isNotBlank(queryCondition.getApplicationTimeEnd())) {
            queryCondition.setApplicationTimeEnd(applicationTimeEnd);
        }
        model.addAttribute("queryCondition", queryCondition);
        model.addAttribute("page", page);
        return "account/online/waitConfirmList";
    }

    /**
     * 开户审核列表
     */
    @RequestMapping("/checkList")
    @RequiresPermissions("customer:checkList")
    public String checkList(Model model, AccountOpenApplyQuery queryCondition, HttpServletRequest request) throws Exception {

        String applicationTimeStart = queryCondition.getApplicationTimeStart();
        String applicationTimeEnd = queryCondition.getApplicationTimeEnd();
        if (StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(applicationTimeStart)), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(applicationTimeEnd)) {
            queryCondition.setApplicationTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(applicationTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        queryCondition.setUpdateUser(UserUtils.getCurrentUserId());


        //根据当前角色所拥有权限进入 审核页面分别为（初审 复审 终审）
        List<String> currentNodes = new ArrayList<>();
        Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("ONLINE_OPEN_ACCOUNT_MODEL_ID", null));
        List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");
        for (String key : modelNodeRoleList.keySet()) {
            List<String> modelNodeRole = modelNodeRoleList.get(key);
            for (String aModelNodeRole : modelNodeRole) {
                for (RoleEntity role : roleList) {
                    if (role.getId().equals(aModelNodeRole)) {
                        currentNodes.add(key);
                    }
                }
            }
        }


        //开户类型设置互联网
        Integer openAccountType = queryCondition.getOpenAccountType();
        if (openAccountType == null) {
            queryCondition.setOpenAccountType(1);
        }

        //超级管理员  不做权限验证
        if (UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
            queryCondition.setCurrentNode(null);
        } else {
            queryCondition.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
        }

        queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
        Page<AccountOpenApplyDetailInfo> page = customerAccountOpenService.findPageCheck(queryCondition, pageNum);

        if (StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(applicationTimeStart);
        }
        if (queryCondition.getApplicationTimeEnd() != null && StringUtils.isNotBlank(queryCondition.getApplicationTimeEnd())) {
            queryCondition.setApplicationTimeEnd(applicationTimeEnd);
        }
        queryCondition.setOpenAccountType(openAccountType);
        model.addAttribute("page", page);
        model.addAttribute("queryCondition", queryCondition);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());

        return "account/online/openAcctCheckList";
    }


    /**
     * 客服节点列表
     */
    @RequestMapping("/serviceProcessList")
    @RequiresPermissions("act:model:all")
    public String serviceProcessList(Model model, AccountOpenApplyQuery queryCondition, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
//        queryCondition.setStatus("1");
        queryCondition.setCurrentNode("客服审核");
        if (null != queryCondition.getIsMyTask() && 1 == queryCondition.getIsMyTask()) {
            String currentUserLoginName = UserUtils.getCurrentUser().getLoginName();
            queryCondition.setAssignDrafter(currentUserLoginName);
        }
        Page<AccountOpenApplyDetailInfo> page = customerAccountOpenService.findPage(queryCondition, pageNum);

        model.addAttribute("page", page);
        model.addAttribute("queryCondition", queryCondition);
        return "accountOpen/customerAccountOpenServiceProcessList";
    }

    /**
     * 我的预约受理
     */
    @RequestMapping("/myProcessList")
    @RequiresPermissions("act:model:all")
    public String myProcessList(Model model, AccountOpenApplyQuery queryCondition, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        queryCondition.setStatus("1");
        String currentUserId = UserUtils.getCurrentUserId();
        queryCondition.setAssignDrafter(currentUserId);
        Page<AccountOpenApplyDetailInfo> page = customerAccountOpenService.findPage(queryCondition, pageNum);

        model.addAttribute("page", page);
        model.addAttribute("queryCondition", queryCondition);
        return "accountOpen/myAccountOpenServiceProcessList";
    }


    @RequestMapping("/approveInfo")
    @RequiresPermissions("act:model:all")
    public String approveInfo(Model model, String applicationId) {

        getCustomerAccountOpenInfo(model, applicationId);
        ProcessTaskDto processTaskDto = actModelerService.findProcessTaskByBusId(applicationId);
        // model.addAttribute("processTaskDto", processTaskDto);
        model.addAttribute("taskDto", processTaskDto);
        return "account/online/customerAccOpenInfoApprove";
        //return "accountOpen/customerAccountOpenInfoServiceApprove";
    }

    /**
     * 开户资料详情
     *
     * @param model
     * @param applicationId 开户申请ID
     * @return
     */
    @RequestMapping("/customerAccountOpenInfo")
    @RequiresPermissions("act:model:all")
    public String customerAccountOpenInfo(Model model, String applicationId, HttpServletRequest request) {

        getCustomerAccountOpenInfo(model, applicationId);
        model.addAttribute("flag", request.getParameter("flag"));
        return "account/online/customerAccOpenInfoView";
    }

    private void getCustomerAccountOpenInfo(Model model, String applicationId) {

        //开户信息表
        CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(applicationId);
        //申请表
        CustomerAccountOpenApplyEntity accountOpenApplicationEntity = customerAccOpenApplyService.queryObjectByApplicationId(applicationId);
        //税务
        List<OpenAccountTaxationInfoEntity> openAccountTaxationInfoEntity = openAccountTaxationInfoService.queryByApplicationId(applicationId);
        //其他信息表
        List<OpenAccountOtherDisclosureEntity> openAccountOtherDisclosureEntity = openAccountOtherDisclosureService.queryByApplicationId(applicationId);

        //把name和详情拼接为 张三丰,深圳市宝安区;李四,深圳市
        for (OpenAccountOtherDisclosureEntity entity : openAccountOtherDisclosureEntity) {
            boolean ischeck = false;
            Integer code = entity.getDisclosureCode();
            //1,2,3选择否,11,12,13,14,15选择是时需要添加详细信息
            if (entity.getDisclosureIsTrue() == 0 && (code == 1 || code == 2 || code == 3)) {
                ischeck = true;
            }
            if (entity.getDisclosureIsTrue() == 1 && (code > 10 && code < 16)) {
                ischeck = true;
            }
            if (ischeck) {
                // 详细资料展示页面  拼接展示
                StringBuffer nameJoinDetailStr = new StringBuffer();
                String disclosure1[] = {};
                String disclosure2[] = {};
                String disclosure3[] = {};
                String disclosure4[] = {};
                if (StringUtils.isNotBlank(entity.getDisclosure1())) {
                    disclosure1 = entity.getDisclosure1().split(",");
                }
                if (StringUtils.isNotBlank(entity.getDisclosure2())) {
                    disclosure2 = entity.getDisclosure2().split(",");
                }
                if (StringUtils.isNotBlank(entity.getDisclosure3())) {
                    disclosure3 = entity.getDisclosure3().split(",");
                }
                if (StringUtils.isNotBlank(entity.getDisclosure4())) {
                    disclosure4 = entity.getDisclosure4().split(",");
                }
                int maxLen = Math.max(Math.max(disclosure1.length, disclosure2.length), Math.max(disclosure3.length, disclosure4.length));
                //生成带填充的矩阵
                String disclo1[] = new String[maxLen];
                String disclo2[] = new String[maxLen];
                String disclo3[] = new String[maxLen];
                String disclo4[] = new String[maxLen];
                Arrays.fill(disclo1, "");
                Arrays.fill(disclo2, "");
                Arrays.fill(disclo3, "");
                Arrays.fill(disclo4, "");
                System.arraycopy(disclosure1, 0, disclo1, 0, disclosure1.length);
                System.arraycopy(disclosure2, 0, disclo2, 0, disclosure2.length);
                System.arraycopy(disclosure3, 0, disclo3, 0, disclosure3.length);
                System.arraycopy(disclosure4, 0, disclo4, 0, disclosure4.length);

                String disclosure[][] = {disclo1, disclo2, disclo3, disclo4};
                for (int j = 0; j < maxLen; j++) {
                    int col = 0;
                    while (col < disclosure.length) {
                        if (StringUtils.isNotBlank(disclosure[col][j])) {
                            nameJoinDetailStr.append(disclosure[col][j]).append(",");
                        }
                        col++;
                    }
                    nameJoinDetailStr.deleteCharAt(nameJoinDetailStr.length() - 1);
                    nameJoinDetailStr.append(";");
                }
                entity.setDisclosureNameJoinDetail(nameJoinDetailStr.toString());
            }
        }

        //财产类型表
        List<OpenAccountPropertyTypeEntity> openAccountPropertyTypeEntity = openAccountPropertyTypeService.queryByApplicationId(applicationId);
        StringBuffer propertyStr = new StringBuffer();
        for (OpenAccountPropertyTypeEntity property : openAccountPropertyTypeEntity) {
            propertyStr.append(property.getPropertyType()).append(",");
        }
        model.addAttribute("propertyStr", propertyStr);

        //补充资料
        OpenAccountAdditionalFileEntity additionalFileEntity = new OpenAccountAdditionalFileEntity();
        additionalFileEntity.setApplicationId(applicationId);
        List<OpenAccountAdditionalFileEntity> openAccountAdditionalFileList = openAccountAdditionalFileService.querySupFile(additionalFileEntity);

        CustomerAccOpenInfoModel customerAccountOpenInfoModel = CustomerOpenAccountConverter.entityToModel(customerAccountOpenInfo);
        //图片
        List<CustomerAccountOpenImgEntity> customerAccountOpenImages = customerAccountOpenImageService.queryByAccountOpenInfoId(customerAccountOpenInfo.getApplicationId());

        List<CustomerAccountOpenImgEntity> openImgs = filterOpenImages(customerAccountOpenImages, customerAccountOpenInfo);

        // 自定义排序
        customerAccountOpenImageService.sort(customerAccountOpenImages, customerAccountOpenInfo.getOpenAccountAccessWay(), customerAccountOpenInfo.getBankType(), customerAccountOpenInfo.getIdKind());

        try {
            int isCustomer = 0;
            //根据当前角色所拥有权限进入 审核页面分别为（初审 复审 终审）
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("ONLINE_OPEN_ACCOUNT_MODEL_ID", null));
            List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");
            for (String key : modelNodeRoleList.keySet()) {
                List<String> modelNodeRole = modelNodeRoleList.get(key);
                for (String aModelNodeRole : modelNodeRole) {
                    for (RoleEntity role : roleList) {
                        if (role.getId().equals(aModelNodeRole)) {
                            currentNodes.add(key);
                        }
                    }
                }
            }
            if (currentNodes.contains("初审")) {
                isCustomer = 1;
            }
            model.addAttribute("isCustomer", isCustomer);
        } catch (Exception e) {
            logger.error("详情查询异常!", e);
        }

        //四要素
        List<OpenAccountBankVerityInfoEntity> openAccountBankVerityInfoEntity = openAccountBankVerityInfoService.queryByApplicationId(applicationId);
        //AML文件list
        OpenAccountAdditionalFileEntity amlFileParams = new OpenAccountAdditionalFileEntity();
        amlFileParams.setApplicationId(applicationId);
        amlFileParams.setFileType(2);
        List<OpenAccountAdditionalFileEntity> amlFileList = openAccountAdditionalFileService.queryListByEntity(amlFileParams);

        //申请表
        model.addAttribute("accountOpenApplicationEntity", accountOpenApplicationEntity);

        if (customerAccountOpenInfoModel.getInvestTarget() != null) {
            String target = customerAccountOpenInfoModel.getInvestTarget().replace("[", "").replace("]", "");
            customerAccountOpenInfoModel.setInvestTarget(target);
        }
        if (customerAccountOpenInfoModel.getCapitalSource() != null) {
            String capitalSource = customerAccountOpenInfoModel.getCapitalSource().replace("[", "").replace("]", "");
            customerAccountOpenInfoModel.setCapitalSource(capitalSource);
        }
        //账户申请表
        model.addAttribute("customerAccountOpenInfoEntity", customerAccountOpenInfoModel);
        //图片
        model.addAttribute("customerAccountOpenImages", openImgs);
        //税务表
        model.addAttribute("taxInformationList", openAccountTaxationInfoEntity);
        //其他信息表
        model.addAttribute("openAccountOtherDisclosureList", openAccountOtherDisclosureEntity);
        //财产信息
        model.addAttribute("openAccountPropertyList", openAccountPropertyTypeEntity);
        //补充资料
        model.addAttribute("openAccountAdditionalFileList", openAccountAdditionalFileList);
        //四要素
        model.addAttribute("bankVerityInfoList", openAccountBankVerityInfoEntity);

        //AML文件list
        model.addAttribute("amlFileList", amlFileList);

        String accountOpenUserReportRootPath = CustomerAccOpenReportGenerate.getAccountOpenUserReportRootPath(customerAccountOpenInfoModel.getApplicationId());
        File[] files = new File[0];
        try {
            files = FileUtil.ls(accountOpenUserReportRootPath);
        } catch (Exception e) {
            logger.error("Not directory", e);
        }
        List<FileInfo> reportFiles = Lists.newArrayList();
        for (File file : files) {
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFileName(file.getName());
            fileInfo.setFileUri(file.getPath().replace("\\", "/"));
            if ("W8".equals(file.getName().replace(".pdf", ""))) {
                fileInfo.setDisplayName("下载《W8-ben表格》");
                reportFiles.add(fileInfo);
                fileInfo.setSort(3);
            }
            if ("开户表格".equals(file.getName().replace(".pdf", ""))) {
                fileInfo.setDisplayName("下载《开户表格》");
                reportFiles.add(fileInfo);
                fileInfo.setSort(1);
            }
            if ("自我证明表格-个人".equals(file.getName().replace(".pdf", ""))) {
                fileInfo.setDisplayName("下载《CRS表格》");
                reportFiles.add(fileInfo);
                fileInfo.setSort(2);
            }
            if ("有关美国公民身份证明书".equals(file.getName().replace(".pdf", ""))) {
                fileInfo.setDisplayName("下载《美国公民身份证明》");
                reportFiles.add(fileInfo);
                fileInfo.setSort(5);
            }
            if ("证券账户开户协议".equals(file.getName().replace(".pdf", ""))) {
                fileInfo.setDisplayName("下载《电子签署开户文件》");
                reportFiles.add(fileInfo);
                fileInfo.setSort(4);
            }
        }

        // 排序
        Collections.sort(reportFiles);

        model.addAttribute("reportFiles", reportFiles);

        OpenAccountAdditionalFileEntity supFile = new OpenAccountAdditionalFileEntity();
        supFile.setApplicationId(applicationId);
        supFile.setFileType(3);
        List<OpenAccountAdditionalFileEntity> proofFiles = openAccountAdditionalFileService.queryListByEntity(supFile);
        if (proofFiles != null && proofFiles.size() > 0) {
            model.addAttribute("proofFileList", proofFiles);
        }

        //凭证图片
        CustomerAccountOpenImgEntity imageParams = new CustomerAccountOpenImgEntity();
        imageParams.setApplicationId(customerAccountOpenInfo.getApplicationId());
        imageParams.setImageLocation(6);
        List<CustomerAccountOpenImgEntity> proofImageList = customerAccountOpenImageService.queryListByBean(imageParams);
        for (CustomerAccountOpenImgEntity image : proofImageList) {
            image.setStoragePath(image.getStoragePath().replace("D:", ""));
            model.addAttribute("proofImage_" + image.getImageLocationType(), image);
        }

        // CA申请记录
        OpenAccountCaVerityInfoEntity caVerityInfo = new OpenAccountCaVerityInfoEntity();
        caVerityInfo.setApplicationId(applicationId);
        OpenAccountCaVerityInfoEntity caVerityInfoResult = caVerityInfoService.queryRecentByApplicationId(caVerityInfo);
        if (caVerityInfoResult != null && caVerityInfoResult.getCaCertSn() != null) {
            model.addAttribute("caCertSn", caVerityInfoResult.getCaCertSn());
        } else {
            model.addAttribute("caCertSn", "无");
        }
    }


    /**
     * 影像资料修改
     *
     * @param model
     * @param gid   资料ID
     * @return
     */
    @RequestMapping("/modifyImageView")
    @RequiresPermissions("act:model:all")
    public String modifyImageView(Model model, String gid) {
        List<CustomerAccountOpenImgEntity> customerAccountOpenImages = customerAccountOpenImageService.queryByAccountOpenInfoId(gid);
        model.addAttribute("customerAccountOpenImages", customerAccountOpenImages);

        return "accountOpen/customerAccountOpenImageEdit";
    }

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    @RequiresPermissions("act:model:all")
    public @ResponseBody
    Result upload(@RequestParam("file") MultipartFile file, String gid) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }

        CustomerAccountOpenImgEntity customerAccountOpenImage = customerAccountOpenImageService.queryObject(gid);

        String fileSavePath = customerAccountOpenImage.getStoragePath() + customerAccountOpenImage.getFileStorageName() + "." + customerAccountOpenImage.getExtName();
        boolean b = FileOperaterUtil.fileUpload(fileSavePath, file);
        return Result.ok();
    }

    /**
     * 开户资料修改页面
     *
     * @param model
     * @param applicationId 流程id
     * @return
     */
    @RequestMapping("viewCustomerAccountInfo")
//    @RequiresPermissions("act:model:all")
    public String viewCustomerAccountInfo(Model model, String applicationId) {

        getCustomerAccountOpenInfo(model, applicationId);

        ProcessTaskDto processTaskDto = actModelerService.findProcessTaskByBusId(applicationId);

        model.addAttribute("taskDto", processTaskDto);

        return "account/online/customerAccOpenEditView";
    }


    /**
     * 修改客户资料
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/editCustomerAccountOpenInfo")
//    @RequiresPermissions("act:model:all")
//    @Transactional(rollbackFor = Exception.class)
    public @ResponseBody
    Result editCustomerAccountOpenInfo(@RequestBody CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity, HttpServletRequest request) {
        try {

            //验证交易帐号（靓号）是否已被申请
            if (customerAccountOpenInfoEntity.getClientId() != null && !"".equals(customerAccountOpenInfoEntity.getClientId())) {
                int tradeAccountNumber = customerAccountOpenInfoService.validateTradeAccount(customerAccountOpenInfoEntity);
                if (tradeAccountNumber > 0) {
                    return Result.error("该客户帐号已被申请!");
                }
            }
            String propertyInfo = customerAccountOpenInfoEntity.getPropertyInfo();
            customerAccountOpenInfoEntity.setPropertyTypeList(JSONArray.parseArray(propertyInfo, OpenAccountPropertyTypeEntity.class));
            String taxInfo = customerAccountOpenInfoEntity.getTaxInfo();
            customerAccountOpenInfoEntity.setTaxationInfoList(JSONArray.parseArray(taxInfo, OpenAccountTaxationInfoEntity.class));
            String otherInfo = customerAccountOpenInfoEntity.getOtherInfo();
            customerAccountOpenInfoEntity.setOtherDisclosureList(JSONArray.parseArray(otherInfo, OpenAccountOtherDisclosureEntity.class));

            CustomerAccOpenInfoModel customerAccountOpenInfoModel = CustomerOpenAccountConverter.entityToModel(customerAccountOpenInfoEntity);
            ResponseVO commonResultCode = CustomerAccountOpenHelper.validateUpdateAccOpenInfo(customerAccountOpenInfoModel);
            if (-1 == commonResultCode.getCode()) {
                return new Result(String.valueOf(commonResultCode.getCode()), commonResultCode.getMessage());
            }
            customerAccountOpenInfoEntity.setCapitalSource("[" + customerAccountOpenInfoEntity.getCapitalSource() + "]");
            customerAccountOpenInfoEntity.setInvestTarget("[" + customerAccountOpenInfoEntity.getInvestTarget() + "]");
            if (!customerAccountOpenInfoEntity.getInvestTarget().contains("4")) {
                customerAccountOpenInfoEntity.setInvestTargetOther("");
            }
            if (0 == customerAccountOpenInfoEntity.getIsKnowDerivativeProducts()) {
                customerAccountOpenInfoService.updateNoProduct(customerAccountOpenInfoEntity);
            }
            customerAccountOpenInfoService.update(customerAccountOpenInfoEntity);

            //财产种类
            List<OpenAccountPropertyTypeEntity> propertyInfoList = JSONArray.parseArray(propertyInfo, OpenAccountPropertyTypeEntity.class);
            customerAccountOpenInfoEntity.setPropertyTypeList(propertyInfoList);
            openAccountPropertyTypeService.deleteByApplicationId(customerAccountOpenInfoEntity.getApplicationId());
            if (customerAccountOpenInfoEntity.getPropertyTypeList() != null && customerAccountOpenInfoEntity.getPropertyTypeList().size() > 0) {
                for (OpenAccountPropertyTypeEntity propertyType : propertyInfoList) {
                    propertyType.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
                    propertyType.setCreateTime(new Date());
                    propertyType.setUpdateTime(new Date());
                }
                openAccountPropertyTypeService.saveBatch(customerAccountOpenInfoEntity.getPropertyTypeList());
            }

            //税务信息
            List<OpenAccountTaxationInfoEntity> taxInfoList = JSONArray.parseArray(taxInfo, OpenAccountTaxationInfoEntity.class);
            customerAccountOpenInfoEntity.setTaxationInfoList(taxInfoList);
            openAccountTaxationInfoService.deleteByApplicationId(customerAccountOpenInfoEntity.getApplicationId());
            if (customerAccountOpenInfoEntity.getTaxationInfoList() != null && taxInfoList.size() > 0) {
                for (OpenAccountTaxationInfoEntity taxationInfo : customerAccountOpenInfoEntity.getTaxationInfoList()) {
                    taxationInfo.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
                    taxationInfo.setCreateTime(new Date());
                    taxationInfo.setUpdateTime(new Date());
                }
                openAccountTaxationInfoService.saveBatch(customerAccountOpenInfoEntity.getTaxationInfoList());

            }


            //其他信息披露
            List<OpenAccountOtherDisclosureEntity> otherInfoList = JSONArray.parseArray(otherInfo, OpenAccountOtherDisclosureEntity.class);
            customerAccountOpenInfoEntity.setOtherDisclosureList(otherInfoList);
            openAccountOtherDisclosureService.deleteByApplicationId(customerAccountOpenInfoEntity.getApplicationId());
            if (customerAccountOpenInfoEntity.getOtherDisclosureList() != null && otherInfoList.size() > 0) {
                for (OpenAccountOtherDisclosureEntity otherDisclosure : customerAccountOpenInfoEntity.getOtherDisclosureList()) {
                    otherDisclosure.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
                    otherDisclosure.setCreateTime(new Date());
                    otherDisclosure.setUpdateTime(new Date());
                }
                openAccountOtherDisclosureService.saveBatch(customerAccountOpenInfoEntity.getOtherDisclosureList());
            }

            CustomerAccountOpenApplyEntity cusAccOpenApplication = new CustomerAccountOpenApplyEntity();
            cusAccOpenApplication.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
            cusAccOpenApplication.setUpdateUser(UserUtils.getCurrentUserId());
            customerAccOpenApplyService.updateByApplicationId(cusAccOpenApplication);

            //置空图片修改人
            customerAccountOpenImageService.resetUpdateUser(customerAccountOpenInfoEntity.getApplicationId());
            //置空资料修改证明图片 修改人
            openAccountAdditionalFileService.resetUpdateUser(customerAccountOpenInfoEntity.getApplicationId());

            if (1 != customerAccountOpenInfoEntity.getIsRecheck()) {
                //需要更新日志
                customerAccountOpenService.updateOpenAccountProcessLog(cusAccOpenApplication.getApplicationId(), BpmCommonEnum.YesNo.YES.getIndex(), BpmCommonEnum.YesNo.NO.getIndex());

                // 更新客户开户业务操作员日志表
                CustomerAccountOpenApplyEntity customerAccountOpenApplyInfo = customerAccOpenApplyService.queryObjectByApplicationId(cusAccOpenApplication.getApplicationId());

                OpenAccountOperatorLogEntity openAccountOperatorLogEntity = new OpenAccountOperatorLogEntity();
                openAccountOperatorLogEntity.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
                openAccountOperatorLogEntity.setCurrentNode(customerAccountOpenApplyInfo.getCurrentNode());
                openAccountOperatorLogEntity.setOperateType(1);
                openAccountOperatorLogEntity.setCreateUser(UserUtils.getCurrentUserId());
                openAccountOperatorLogEntity.setCreateTime(new Date());

                openAccountOperatorLogService.save(openAccountOperatorLogEntity);
            }

            // 重新生成签名信息照
            CustomerAccountOpenImgEntity customerAccountOpenImgEntity = new CustomerAccountOpenImgEntity();
            customerAccountOpenImgEntity.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
            customerAccountOpenImgEntity.setImageLocationType(301);
            List<CustomerAccountOpenImgEntity> customerAccountOpenImgSign = customerAccountOpenImageService.queryListByBean(customerAccountOpenImgEntity);

            customerAccountOpenImgEntity.setImageLocationType(302);
            List<CustomerAccountOpenImgEntity> customerAccountOpenImgSignInfo = customerAccountOpenImageService.queryListByBean(customerAccountOpenImgEntity);

            if (customerAccountOpenImgSign.size() > 0 && customerAccountOpenImgSignInfo.size() > 0) {
                OpenImgGraphicsGenerate cg = new OpenImgGraphicsGenerate();
                cg.graphicsGenerate(customerAccountOpenImgSign.get(0).getStoragePath() + customerAccountOpenImgSign.get(0).getFileStorageName() + "." + customerAccountOpenImgSign.get(0).getExtName()
                        , customerAccountOpenImgSignInfo.get(0).getStoragePath() + customerAccountOpenImgSignInfo.get(0).getFileStorageName() + "." + customerAccountOpenImgSignInfo.get(0).getExtName()
                        , customerAccountOpenInfoEntity);
            }

//            if (1 == customerAccountOpenInfoEntity.getIsRecheck()) {
//                Map<String, String[]> parameterMap = request.getParameterMap();
//                Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
//                for (String key : parameterMap.keySet()) {
//                    params.put(key, parameterMap.get(key)[0]);
//                }
//
//                ProcessTaskDto processTaskDto = actModelerService.findProcessTaskByBusId(customerAccountOpenInfoEntity.getApplicationId());
//                processTaskDto.setRemark(customerAccountOpenInfoEntity.getRemark());
//                actModelerService.doActTask(processTaskDto, params);
//            }

            return Result.ok();

        } catch (Exception e) {
            logger.error("修改开户资料失败", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("修改开户资料失败！");
        }
    }


    /**
     * 终止流程页面
     *
     * @param model
     * @param applicationId 开户申请ID
     * @return
     */
    @RequestMapping("viewReject")
    public String viewReject(Model model, String applicationId, ProcessTaskDto processTaskDto) {
        CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(applicationId);

        List<CustomerAccountOpenImgEntity> customerAccountOpenImages = customerAccountOpenImageService.queryByAccountOpenInfoId(customerAccountOpenInfo.getApplicationId());

        List<CodeEntity> customerAccountOpenContentTypes = codeService.queryChildsByMark("AO_CONTENT_ERROR_TYPE");
        // 错误类型
        model.addAttribute("customerAccountOpenImages", customerAccountOpenImages);
        model.addAttribute("customerAccountOpenContentTypes", customerAccountOpenContentTypes);
        model.addAttribute("applicationId", applicationId);
        model.addAttribute("customerAccountOpenInfoEntity", customerAccountOpenInfo);

        model.addAttribute("processTaskDto", processTaskDto);

        return "accountOpen/customerAccountOpenApplicationReject";
    }


    /**
     * 流程终止操作
     *
     * @param approvalOpinion 审批意见
     * @return
     */
    @RequestMapping("doRejectTermination")
    public
    @ResponseBody
    Result doRejectTermination(String approvalOpinion, String busId, String taskId, String defId, String instanceId, String actKey) {
        Result result = null;
        ProcessTaskDto processTaskDto = new ProcessTaskDto();
        processTaskDto.setBusId(busId);
        processTaskDto.setTaskId(taskId);
        processTaskDto.setDefId(defId);
        processTaskDto.setActKey(actKey);
        processTaskDto.setInstanceId(instanceId);
        processTaskDto.setRemark(approvalOpinion);

        CustomerAccountOpenApplyEntity customerAccountOpenApply = customerAccOpenApplyService.queryObjectByApplicationId(busId);

        customerAccountOpenApply.setApprovalOpinion(approvalOpinion);
        customerAccountOpenApply.setLastApprovalUser(UserUtils.getCurrentUserId());

        customerAccountOpenService.terminateAccountOpenApplication(customerAccountOpenApply, processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_TERMINATION_VALUE);

        try {

            actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.TERMINATION.getValue());
            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
        } catch (Exception e) {
            logger.error("终止失败", e);
            result = Result.error("操作失败");
        }

        //更新开户业务流程日志记录
        OpenAccountProcessLogEntity openAccountProcessLog = new OpenAccountProcessLogEntity();
        openAccountProcessLog.setTaskId(Integer.valueOf(processTaskDto.getTaskId()));
        openAccountProcessLog.setIsBackApp(BpmCommonEnum.YesNo.YES.getIndex());
        openAccountProcessLogService.updateByTaskId(openAccountProcessLog);

        return result;
    }

    /**
     * 流程终止操作（旧的，现在没用到）
     *
     * @param errorImages             错误图片
     * @param approvalOpinion         审批意见
     * @param applicationId           开户申请ID
     * @param errorContentTypesErrors 错误资料
     * @return
     */
    @RequestMapping("rejectApplication")
    public
    @ResponseBody
    Result doRejectAccountOpenApplication(String[] errorImages, String approvalOpinion, String applicationId, String[] errorContentTypesErrors
            , String busId, String taskId, String defId, String instanceId) {
        Result result = null;
        ProcessTaskDto processTaskDto = new ProcessTaskDto();
        processTaskDto.setBusId(busId);
        processTaskDto.setTaskId(taskId);
        processTaskDto.setDefId(defId);
        processTaskDto.setInstanceId(instanceId);
        processTaskDto.setRemark(approvalOpinion);

        CustomerAccountOpenApplyEntity applicationInfo = customerAccOpenApplyService.queryObject(applicationId);

        List<OpenAccountImageInfo> openAccountImages = Lists.newArrayList();
        if (null != errorImages && errorImages.length > 0) {
            for (String errorImage : errorImages) {
                String[] imageInfo = errorImage.split("-");
                OpenAccountImageInfo openAccountImageInfo = new OpenAccountImageInfo();
                openAccountImageInfo.setImageLocation(Integer.valueOf(imageInfo[0]));
                openAccountImageInfo.setImageLocationType(Integer.valueOf(imageInfo[1]));
                openAccountImages.add(openAccountImageInfo);
            }
            applicationInfo.setErrorImages(JSON.toJSONString(openAccountImages));
        }

        if (null != errorContentTypesErrors && errorContentTypesErrors.length > 0) {
            applicationInfo.setErrorContentTypes(JSON.toJSONString(errorContentTypesErrors));
        }

        applicationInfo.setApprovalOpinion(approvalOpinion);
        applicationInfo.setLastApprovalUser(UserUtils.getCurrentUserId());


        customerAccountOpenService.terminateAccountOpenApplication(applicationInfo, processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_TERMINATION_VALUE);

        try {

            actModelerService.terminationFlow(processTaskDto);
            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "终止成功");

        } catch (Exception e) {

            e.printStackTrace();
            result = Result.error("终止失败");

        }

        //更新开户业务流程日志记录
        OpenAccountProcessLogEntity openAccountProcessLog = new OpenAccountProcessLogEntity();
        openAccountProcessLog.setTaskId(Integer.valueOf(processTaskDto.getTaskId()));
        openAccountProcessLog.setIsBackWorkflow(BpmCommonEnum.YesNo.YES.getIndex());
        openAccountProcessLogService.updateByTaskId(openAccountProcessLog);


        return result;
    }

    /**
     * 流程拒绝
     *
     * @param approvalOpinion 审批意见
     * @return
     */
    @RequestMapping("doReject")
    public
    @ResponseBody
    Result doReject(String approvalOpinion, String busId, String taskId, String defId, String instanceId, String actKey) {
        Result result = null;
        ProcessTaskDto processTaskDto = new ProcessTaskDto();
        processTaskDto.setBusId(busId);
        processTaskDto.setTaskId(taskId);
        processTaskDto.setDefId(defId);
        processTaskDto.setActKey(actKey);
        processTaskDto.setInstanceId(instanceId);
        processTaskDto.setRemark(approvalOpinion);

        CustomerAccountOpenApplyEntity applicationInfo = customerAccOpenApplyService.queryObjectByApplicationId(busId);

        applicationInfo.setApprovalOpinion(approvalOpinion);
        applicationInfo.setLastApprovalUser(UserUtils.getCurrentUserId());

        customerAccountOpenService.terminateAccountOpenApplication(applicationInfo, processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_REJECT_VALUE);

        try {

            actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.REJECT.getValue());
            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
        } catch (Exception e) {
            logger.error("拒绝失败", e);
            result = Result.error("操作失败");
        }

        //更新开户业务流程日志记录
        OpenAccountProcessLogEntity openAccountProcessLog = new OpenAccountProcessLogEntity();
        openAccountProcessLog.setTaskId(Integer.valueOf(processTaskDto.getTaskId()));
        openAccountProcessLog.setIsReject(BpmCommonEnum.YesNo.YES.getIndex());
        openAccountProcessLogService.updateByTaskId(openAccountProcessLog);

        return result;
    }


    /**
     * 流程拒绝并加入黑名单
     *
     * @param approvalOpinion 审批意见
     * @return
     */
    @RequestMapping("doRejectBlackList")
    public
    @ResponseBody
    Result doRejectBlackList(String approvalOpinion, String busId, String taskId, String defId, String instanceId, String actKey) {
        Result result = null;
        ProcessTaskDto processTaskDto = new ProcessTaskDto();
        processTaskDto.setBusId(busId);
        processTaskDto.setTaskId(taskId);
        processTaskDto.setDefId(defId);
        processTaskDto.setActKey(actKey);
        processTaskDto.setInstanceId(instanceId);
        processTaskDto.setRemark(approvalOpinion);

        CustomerAccountOpenApplyEntity applicationInfo = customerAccOpenApplyService.queryObjectByApplicationId(busId);
        CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(applicationInfo.getApplicationId());

        applicationInfo.setApprovalOpinion(approvalOpinion);
        applicationInfo.setLastApprovalUser(UserUtils.getCurrentUserId());

        customerAccountOpenService.terminateAccountOpenApplication(applicationInfo, processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_REJECT_BLACKLIST_VALUE);

        try {

            actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.REJECT.getValue());
            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
        } catch (Exception e) {
            logger.error("拒绝并放入黑名单失败", e);
            result = Result.error("操作失败");
        }

        //加入黑名单
        OpenAccountBlacklistEntity openAccountBlacklist = new OpenAccountBlacklistEntity();
        openAccountBlacklist.setApplicationId(applicationInfo.getApplicationId());
        openAccountBlacklistService.saveByCustomerAccountOpenInfo(openAccountBlacklist, customerAccountOpenInfo);


        //更新开户业务流程日志记录
        OpenAccountProcessLogEntity openAccountProcessLog = new OpenAccountProcessLogEntity();
        openAccountProcessLog.setTaskId(Integer.valueOf(processTaskDto.getTaskId()));
        openAccountProcessLog.setIsRejectBlacklist(BpmCommonEnum.YesNo.YES.getIndex());
        openAccountProcessLogService.updateByTaskId(openAccountProcessLog);

        return result;
    }


    /**
     * 开户审批提交
     *
     * @param processTaskDto
     * @param model
     * @param flag
     * @return
     */
    @RequestMapping(value = "customerAccountOpenInfoApprove", method = RequestMethod.POST)
    public String customerAccountOpenInfoApprove(ProcessTaskDto processTaskDto, Model model, String flag) {

        //验证开户图片是否修改
        CustomerAccountOpenImgEntity customerAccountOpenImgEntity = new CustomerAccountOpenImgEntity();
        customerAccountOpenImgEntity.setUpdateUser(UserUtils.getCurrentUserId());
        customerAccountOpenImgEntity.setApplicationId(processTaskDto.getBusId());
        List<CustomerAccountOpenImgEntity> openImgList = customerAccountOpenImageService.queryListByBean(customerAccountOpenImgEntity);
        if (openImgList != null && openImgList.size() > 0) {
            model.addAttribute("openImgModified", 1);
        } else {
            model.addAttribute("openImgModified", 0);
        }

        //修改资料 意见
        OpenAccountAdditionalFileEntity addFileParams = new OpenAccountAdditionalFileEntity();
        addFileParams.setApplicationId(processTaskDto.getBusId());
        addFileParams.setAdditionalId(processTaskDto.getBusId());
        List<OpenAccountAdditionalFileEntity> addFileList = openAccountAdditionalFileService.queryDetail(addFileParams);
        model.addAttribute("addFileList", addFileList);

        //验证补充资料图片是否修改
        OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity = new OpenAccountAdditionalFileEntity();
        openAccountAdditionalFileEntity.setUpdateUser(UserUtils.getCurrentUserId());
        openAccountAdditionalFileEntity.setApplicationId(processTaskDto.getBusId());
        List<OpenAccountAdditionalFileEntity> supImgList = openAccountAdditionalFileService.queryListByBean(openAccountAdditionalFileEntity);
        if (supImgList != null && supImgList.size() > 0) {
            model.addAttribute("supImgModified", 1);
        } else {
            model.addAttribute("supImgModified", 0);
        }

//        CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(processTaskDto.getBusId());
        getCustomerAccountOpenInfo(model, processTaskDto.getBusId());
//        List<CustomerAccountOpenImgEntity> customerAccountOpenImages = customerAccountOpenImageService.queryByAccountOpenInfoId(customerAccountOpenInfo.getApplicationId());

        // 获取工作流运行时任务ID
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).list();
        processTaskDto.setTaskId(tasks.size() > 0 ? tasks.get(0).getId() : null);


//        model.addAttribute("customerAccountOpenImages", customerAccountOpenImages);

        model.addAttribute("taskDto", processTaskDto);
        model.addAttribute("flag", flag);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());

        // return "/accountOpen/customerAccountOpenInfoApprove";
        return "/account/online/customerAccOpenInfoApprove";
    }

    /**
     * 开户申请任务待分配列表
     *
     * @param queryCondition
     * @return
     */
    @RequestMapping(value = "/viewOpenAccountApplyDistribute")
    public String viewTaskDistribute(HttpServletRequest request, AccountOpenApplyAllotQuery queryCondition, ModelMap modelMap) {
//        queryCondition.setStatus("1");
//        queryCondition.setApproveResult(Enum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        queryCondition.setCurrentNode("客服审核");
        List<String> channelIds = Lists.newArrayList();
        if (null != queryCondition.getChannelIds()) {
            for (String channelId : queryCondition.getChannelIds()) {
                if (StringUtils.isNotBlank(channelId)) {
                    channelIds.add(channelId);
                }
                queryCondition.setChannelIds(channelIds);
            }
        }

        // 默认查询未分配记录
        if (null != queryCondition.getDistributeType()) {
            queryCondition.setDistributeType(queryCondition.getDistributeType());
        } else {
            queryCondition.setDistributeType(2);
        }

        List<AccountOpenApplyDetailInfo> records = customerAccountOpenService.findDistributeList(queryCondition);
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<AccountOpenApplyDetailInfo> page = customerAccountOpenService.findDistributePage(queryCondition, pageNum);

        List<ChannelInfo> distinctChannels = customerAccountOpenManager.getDistinctChannel();
        List<UserEntity> users = userService.queryByRoleId("695a97ae34b94d57899833a3ebcd656a");

        List<String> applicationIds = Lists.newArrayList();
        for (AccountOpenApplyDetailInfo record : records) {
            applicationIds.add(record.getCustomerAccountOpenApplyEntity().getApplicationId());
        }
        modelMap.put("distinctChannels", distinctChannels);
        modelMap.put("customerServices", users);
        modelMap.put("applicationIds", JSON.toJSONString(applicationIds).replace("\"", "-"));
        modelMap.addAttribute("page", page);

        modelMap.addAttribute("queryConditions", queryCondition);

        return "accountOpen/distributer/accountOpenApplyDistributeList";
    }


    /**
     * 获取任务分配人员
     *
     * @return
     */
    @RequestMapping(value = "/getDistributeServiceCustomer")
    public String getDistributeServiceCustomer(ModelMap modelMap, String applicationIds) {
        List<UserEntity> users = userService.queryByRoleId("695a97ae34b94d57899833a3ebcd656a");
        modelMap.put("customerServices", users);
        modelMap.put("applicationIds", applicationIds);

        return "accountOpen/distributer/distributeServiceCustomerList";
    }


    /**
     * 分配开户申请审核任务
     *
     * @param applicationIds
     * @return
     */
    @RequestMapping(value = "/distributeTask")
    public
    @ResponseBody
    Result distributeTask(String[] userIds, String applicationIds) {
        if (null == userIds || userIds.length < 1) {
            return Result.error("-1", "请选择客服人员");
        }

        List<String> accountOpenApplicationIds = JSON.parseArray(applicationIds.replace("-", "\""), String.class);
        List<String> users = Lists.newArrayList(userIds);

        boolean isSucceed = customerAccountOpenService.distributeTask(accountOpenApplicationIds, users);

        if (isSucceed) {
            return Result.ok();
        }

        return Result.error();
    }

    /**
     * 批量申请办理任务
     *
     * @param
     * @return
     */
    @RequestMapping(value = "applyTaskHandleBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result applyTaskHandleBatch(String applicationIds, String toUserId, String actKey, HttpServletRequest request) throws Exception {
        Result result = null;
        if (StringUtils.isEmpty(applicationIds)) {
            throw new MyException("没有勾选需要记录");
        }

        StringBuffer currentNodes = new StringBuffer();

        Map<String, List<String>> modelNodeRoleList = Maps.newHashMap();

        //根据当前角色所拥有权限,
        if (actKey.equals(CUSTOMER_ACCOUNT_OPEN_ONLINE_FLOW_MODEL_KEY)) {
            modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("ONLINE_OPEN_ACCOUNT_MODEL_ID", null));
        } else if (actKey.equals(CUSTOMER_ACCOUNT_OPEN_OFFLINE_FLOW_MODEL_KEY)) {
            modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("ONLINE_OPEN_ACCOUNT_OFFLINE_MODEL_ID", null));
        }

        List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");
        for (String key : modelNodeRoleList.keySet()) {
            List<String> modelNodeRole = modelNodeRoleList.get(key);
            for (String aModelNodeRole : modelNodeRole) {
                for (RoleEntity role : roleList) {
                    if (role.getId().equals(aModelNodeRole)) {
                        currentNodes.append(key).append(",");
                    }
                }
            }
        }

        StringBuffer errorMsg = new StringBuffer();
        List<ProcessTaskDto> processTaskDtoList = actModelerService.findByBusIds(applicationIds);
        try {
            for (int i = 0; i < processTaskDtoList.size(); i++) {
                CustomerAccountOpenApplyEntity applicationInfo = customerAccOpenApplyService.queryObjectByApplicationId(processTaskDtoList.get(i).getBusId());

                // 超级管理员不做权限验证 ，判断操作人员是否拥有初审 、复审、终审权限
                if (!currentNodes.toString().contains(applicationInfo.getCurrentNode()) && !UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
                    errorMsg.append(processTaskDtoList.get(i).getBusId()).append(",");
                    continue;
                }

                // 校验任务是否已被申领
                if (StringUtils.isNotBlank(applicationInfo.getAssignDrafter())) {
                    errorMsg.append(processTaskDtoList.get(i).getBusId()).append(",");
                    continue;
                }

                result = actModelerService.applyTaskHandle(processTaskDtoList.get(i), UserUtils.getCurrentUserId());
                if ("0".equals(result.get("code"))) {
                    //更新申请表指定处理人
                    applicationInfo.setAssignDrafter(UserUtils.getCurrentUserId());
                    customerAccountOpenApplyDao.updateAssignDrafter(applicationInfo);
                } else {
                    errorMsg.append(processTaskDtoList.get(i).getBusId()).append(",");
                }
            }
            if (!StringUtils.isEmpty(errorMsg)) {
                errorMsg.append("任务已被申请办理");
                return Result.error(errorMsg.toString());
            }
        } catch (Exception e) {
            logger.error("批量申请办理任务异常", e);
            return Result.error("申请办理任务失败");
        }
        return result;
    }

    /**
     * 批量释放办理任务
     *
     * @param
     * @return
     */
    @RequestMapping(value = "deliverApplyTask", method = RequestMethod.POST)
    @ResponseBody
    public Result deliverApplyTask(String applicationIds, HttpServletRequest request) {
        Result result = null;
        if (StringUtils.isEmpty(applicationIds)) {
            throw new MyException("未勾选已申领任务！");
        }

        List<ProcessTaskDto> processTaskDtoList = actModelerService.findByBusIds(applicationIds);
        for (int i = 0; i < processTaskDtoList.size(); i++) {
            try {
                result = actModelerService.deliverTaskHandle(processTaskDtoList.get(i));

                //更新申请表指定处理人
                CustomerAccountOpenApplyEntity applicationInfo = customerAccOpenApplyService.queryObjectByApplicationId(processTaskDtoList.get(i).getBusId());
                applicationInfo.setAssignDrafter(null);
                customerAccountOpenApplyDao.updateAssignDrafter(applicationInfo);

            } catch (Exception e) {
                logger.error("批量释放办理任务异常", e);
                result = Result.error("释放失败");
            }
        }
        return result;
    }

    /**
     * 取消已分配的开户申请审核任务
     *
     * @param applicationIds
     * @return
     */
    @RequestMapping(value = "/cancelTaskDistribute")
    public
    @ResponseBody
    Result cancelTaskDistribute(String applicationIds) {
        if (StringUtils.isBlank(applicationIds)) {
            return Result.ok();
        }
        List<String> accountOpenApplicationIds = JSON.parseArray(applicationIds.replace("-", "\""), String.class);
        customerAccountOpenService.cancelDistributeTask(accountOpenApplicationIds);
        boolean isSucceed = true;
        if (isSucceed) {
            return Result.ok();
        }

        return Result.error();
    }


    /**
     * 跳转到退回页面
     *
     * @param
     * @return
     */
    @RequestMapping("doTaskBackView")
    public String doTaskBackView(String busId, String taskId, String defId, String instanceId, String remark, Model model) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(busId);
        CustomerAccountOpenApplyEntity customerAccountOpenApply = customerAccOpenApplyService.queryObjectByApplicationId(busId);

        List<CustomerAccountOpenImgEntity> customerAccountOpenImages = customerAccountOpenImageService.queryByAccountOpenInfoId(busId);
        List<CodeEntity> customerAccountOpenContentTypes = codeService.queryChildsByMark("AO_CONTENT_ERROR_TYPE");

        //图片展示时  不展示APP活体照片(香港开户 区分身份证展示)
        List<CustomerAccountOpenImgEntity> openImgs = filterOpenImages(customerAccountOpenImages, customerAccountOpenInfo);
        // 错误类型
        model.addAttribute("customerAccountOpenImages", openImgs);
        model.addAttribute("customerAccountOpenContentTypes", customerAccountOpenContentTypes);


        model.addAttribute("taskDto", taskDto);
        model.addAttribute("customerAccountOpenInfo", customerAccountOpenInfo);
        model.addAttribute("customerAccountOpenApply", customerAccountOpenApply);
        return "account/online/doTaskBackView";
    }

    /**
     * 退回
     *
     * @param processTaskDto
     * @param backFlag       退回节点 1-退回至客服  2-回至持牌代表 3或者空 退回至客户
     * @return
     */
    @RequestMapping(value = "doBack", method = RequestMethod.POST)
    @ResponseBody
    public Result doBack(ProcessTaskDto processTaskDto, String backFlag, String backReasonType, String[] errorImages, String errorContentTypes, String otherReasons, HttpServletRequest request) {
        Result result = null;
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
            for (String key : parameterMap.keySet()) {
                params.put(key, parameterMap.get(key)[0]);
            }

            CustomerAccountOpenApplyEntity customerAccountOpen = customerAccOpenApplyService.queryObjectByApplicationId(processTaskDto.getBusId());
            if (customerAccountOpen == null) {
                logger.error("[退回操作]查询申请表失败");
                result = Result.error("操作失败");
            }
            CustomerAccountOpenApplyEntity customerAccountOpenApply = new CustomerAccountOpenApplyEntity();
            customerAccountOpenApply.setId(customerAccountOpen.getId());
            customerAccountOpenApply.setApplicationId(customerAccountOpen.getApplicationId());
            customerAccountOpenApply.setIsBack(BpmCommonEnum.YesNo.YES.getIndex());
            customerAccountOpenApply.setApprovalOpinion(processTaskDto.getRemark());
            customerAccountOpenApply.setLastApprovalUser(UserUtils.getCurrentUserId());

            customerAccountOpenApply.setOtherReasons(otherReasons);

            //保存错误图片
            List<OpenAccountImageInfo> openAccountImages = Lists.newArrayList();

            if (null != errorImages && errorImages.length > 0) {
                for (String errorImage : errorImages) {
                    String[] imageInfo = errorImage.split("-");
                    OpenAccountImageInfo openAccountImageInfo = new OpenAccountImageInfo();
                    openAccountImageInfo.setImageLocation(Integer.valueOf(imageInfo[0]));
                    openAccountImageInfo.setImageLocationType(Integer.valueOf(imageInfo[1]));
                    openAccountImages.add(openAccountImageInfo);
                }
                customerAccountOpenApply.setErrorImages(JSON.toJSONString(openAccountImages));
            }

            //拼接填写内容到其它理由后面
            if (null != backReasonType && backReasonType.contains("17")) {
                StringBuilder errorContent = new StringBuilder(backReasonType);
                if (StringUtils.isNotBlank(otherReasons)) {
                    errorContent.insert(errorContent.indexOf("17") + 2, ",\"" + otherReasons + "\"");
                    backReasonType = errorContent.toString();
                }
            }

            customerAccountOpenApply.setErrorContentTypes(errorContentTypes);

            //更新开户业务流程日志记录
            OpenAccountProcessLogEntity openAccountProcessLog = new OpenAccountProcessLogEntity();

            //退回至客服  相当于退回到流程发起人
            if ("1".equals(backFlag)) {
                actModelerService.endFailFolw(processTaskDto, params);
                customerAccountOpenService.backInitialUpdateAccOpenApply(processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_INITIAL_AUDIT_VALUE);

                openAccountProcessLog.setIsBackWorkflow(BpmCommonEnum.YesNo.YES.getIndex());
            }
            //退回至持牌代表
            if ("2".equals(backFlag)) {
                actModelerService.backPreviousNode(processTaskDto);
                customerAccountOpenService.backInitialUpdateAccOpenApply(processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_RECHECK_AUDIT_VALUE);

                openAccountProcessLog.setIsBackWorkflow(BpmCommonEnum.YesNo.YES.getIndex());
            }
            //退回至客户  即流程终止
            if ("3".equals(backFlag) || Utils.isEmpty(backFlag)) {

                customerAccountOpenService.terminateAccountOpenApplication(customerAccountOpenApply, processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_RETURN_BACK_VALUE);
                actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.TURN_BACK.getValue());

                openAccountProcessLog.setIsBackApp(BpmCommonEnum.YesNo.YES.getIndex());
            }
            //清空AssignDrafter
            customerAccountOpenApply.setAssignDrafter(null);
            customerAccountOpenApplyDao.updateAssignDrafter(customerAccountOpenApply);

            openAccountProcessLog.setTaskId(Integer.valueOf(processTaskDto.getTaskId()));
            openAccountProcessLog.setBackReasonType(backReasonType);
            openAccountProcessLogService.updateByTaskId(openAccountProcessLog);

            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
        } catch (Exception e) {
            logger.error("退回操作失败", e);
            result = Result.error("操作失败");
        }
        return result;
    }


    /**
     * 流程信息详情
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "tasLogImgAcct", method = RequestMethod.POST)
    public String tasLogImgAcct(Model model, HttpServletRequest request, String busId, String instanceId) {

        // 通过证件类型，证件号码查询历史流程信息
        CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(busId);

        ExtendActTasklogEntity extendActTasklogEntity = new ExtendActTasklogEntity();
        extendActTasklogEntity.setBusId(busId);
        List<ExtendActTasklogEntity> tasklogList = tasklogService.queryListProcessLog(extendActTasklogEntity);

        // 香港银行卡开户不显示CA证书节点流程信息
        if (customerAccountOpenInfo.getBankType() == 0) {
            for (ExtendActTasklogEntity tasklog : tasklogList) {
                if (tasklog.getTaskName().equals(CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "8"))) {
                    tasklogList.remove(tasklog);
                    break;
                }
            }
        }

        customerAccountOpenService.joinBackReasonType(tasklogList);
        model.addAttribute("taskLogs", tasklogList);

        CustomerAccountOpenInfoEntity entity = new CustomerAccountOpenInfoEntity();
        entity.setIdNo(customerAccountOpenInfo.getIdNo());
        entity.setIdKind(customerAccountOpenInfo.getIdKind());
        List<CustomerAccountOpenInfoEntity> customerAccountOpenInfoList = customerAccountOpenInfoService.queryListByBean(entity);

        //查询历史流程信息
        List<String> busIds = new ArrayList<>();
        for (CustomerAccountOpenInfoEntity customerAcc : customerAccountOpenInfoList) {
            if (!busId.equals(customerAcc.getApplicationId())) {
                busIds.add(customerAcc.getApplicationId());
            }
        }

        if (busIds.size() > 0) {
            ExtendActTasklogEntity extendActTasklogHis = new ExtendActTasklogEntity();
            extendActTasklogHis.setBusId(busId);
            extendActTasklogHis.setBusIds(busIds);
            List<ExtendActTasklogEntity> tasklogListHis = tasklogService.queryListProcessLogHis(extendActTasklogHis);
            customerAccountOpenService.joinBackReasonType(tasklogListHis);
            model.addAttribute("taskLogsHis", tasklogListHis);
        }

        model.addAttribute("instanceId", instanceId);

        return "account/online/taskLogImgAcct";
    }

    /**
     * 获取操作记录
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/getOperatorLogInfo", method = RequestMethod.POST)
    public String getOperatorLogInfo(Model model, HttpServletRequest request, String busId, String instanceId) {

        OpenAccountOperatorLogEntity entity = new OpenAccountOperatorLogEntity();
        entity.setApplicationId(busId);

        List<OpenAccountOperatorLogEntity> openAcctOperatorLogList = openAccountOperatorLogService.queryListByBean(entity);

        model.addAttribute("openAcctOperatorLogInfo", openAcctOperatorLogList);

        return "account/online/openAcctOperatorLog";
    }

    /**
     * 重新上传文件
     */
    @RequestMapping("/reUpload")
    public @ResponseBody
    ResponseVO reUpload(@RequestParam("file") MultipartFile file, CustomerAccountOpenImgEntity customerAccountOpenImgEntity) throws Exception {
        ResponseVO responseVO = new ResponseVO();
        if (file.isEmpty()) {
            throw new Exception("上传文件不能为空");
        }
        customerAccountOpenImgEntity = customerAccountOpenImageService.queryObject(customerAccountOpenImgEntity.getId().toString());
        customerAccountOpenImgEntity.setExtName(FileOperaterUtil.getFileExtendName(file.getOriginalFilename()));
        customerAccountOpenImgEntity.setUpdateUser(UserUtils.getCurrentUserId());
        Boolean isSuccess = FileUpload.fileUpload(file, customerAccountOpenImgEntity.getStoragePath(), customerAccountOpenImgEntity.getFileStorageName());

        if (isSuccess) {
            customerAccountOpenImageService.update(customerAccountOpenImgEntity);

            // 身份证照片 同步中台修改
//            if (customerAccountOpenImgEntity.getImageLocationType() == 101 || customerAccountOpenImgEntity.getImageLocationType() == 102 || customerAccountOpenImgEntity.getImageLocation() == 5) {

            String fileSavePath = customerAccountOpenImgEntity.getStoragePath().substring(customerAccountOpenImgEntity.getStoragePath().indexOf(":") + 1, customerAccountOpenImgEntity.getStoragePath().length()) + customerAccountOpenImgEntity.getFileStorageName() + "." + customerAccountOpenImgEntity.getExtName();
            CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(customerAccountOpenImgEntity.getApplicationId());

            Map<String, Object> params = Maps.newHashMap();
            params.put("userId", customerAccountOpenInfo.getUserId());
            params.put("location", customerAccountOpenImgEntity.getImageLocation());
            params.put("type", customerAccountOpenImgEntity.getImageLocationType());
            params.put("imagePath", ConfigUtils.get("cubp.extranet.file.url") + fileSavePath);

            JSONObject paraMap = new JSONObject();
            paraMap.put("params", params);

            logger.info("修改开户图片接口参数：" + JSON.toJSONString(paraMap));
            String url = ConfigUtils.get("sunline.service.url") + "open_api/openaccount_img_update";
            String response = HttpClientUtils.postJson(url, JSON.toJSONString(paraMap));

            logger.info("修改开户图片接扣接收结果：" + response);

//            }

            //需要更新日志
//            customerAccountOpenService.updateOpenAccountProcessLog(customerAccountOpenImgEntity.getApplicationId(), BpmCommonEnum.YesNo.YES.getIndex(), BpmCommonEnum.YesNo.NO.getIndex());

            responseVO.setCode(0);
            responseVO.setMessage("ok");
            return responseVO;
        } else {
            responseVO.setCode(999);
            responseVO.setMessage("文件保存失败!");
            return responseVO;
        }

    }

    /**
     * 上传AML文件/资料修改凭证
     */
    @RequestMapping(value = "/uploadAml", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @Transactional(rollbackFor = Exception.class)
    public @ResponseBody
    ResponseVO uploadAml(@RequestParam("file") MultipartFile file, OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity, HttpServletRequest request) throws Exception {
        ResponseVO responseVO = new ResponseVO();
        try {
            if (file.isEmpty()) {
                responseVO.setCode(999);
                responseVO.setMessage("文件不能为空！");
                return responseVO;
            }

            openAccountAdditionalFileEntity.setFilePath(ConfigUtils.get("supOpenAccount.file.savePath") + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/");
            openAccountAdditionalFileEntity.setFileStorageName(UUID.randomUUID().toString());
            openAccountAdditionalFileEntity.setFileExtName(FileOperaterUtil.getFileExtendName(file.getOriginalFilename()));
            openAccountAdditionalFileEntity.setCreateUser(UserUtils.getCurrentUserId());
            openAccountAdditionalFileEntity.setCreateTime(new Date());
            openAccountAdditionalFileEntity.setUpdateTime(new Date());
            //type 为2 时  为aml文件上传
            if (openAccountAdditionalFileEntity.getFileType() == 2) {
                openAccountAdditionalFileEntity.setFileName("AML文件");
            } else if (openAccountAdditionalFileEntity.getFileType() == 3) {
                //type 为3 时 为修改凭证文件上传 需要传uuid与备注表
                openAccountAdditionalFileEntity.setFileName("资料修改凭证");
                openAccountAdditionalFileEntity.setUpdateUser(UserUtils.getCurrentUserId());
                openAccountAdditionalFileEntity.setAdditionalId(openAccountAdditionalFileEntity.getApplicationId());
            }
            Boolean isSuccess = FileUpload.fileUpload(file, openAccountAdditionalFileEntity.getFilePath(), openAccountAdditionalFileEntity.getFileStorageName());
            if (isSuccess) {
                openAccountAdditionalFileService.saveFile(openAccountAdditionalFileEntity);
                //更新是否有aml可以 状态

                if (openAccountAdditionalFileEntity.getFileType() == 2) {
                    // 更新客户开户业务操作员日志表
                    CustomerAccountOpenApplyEntity customerAccountOpenApplyInfo = customerAccOpenApplyService.queryObjectByApplicationId(openAccountAdditionalFileEntity.getApplicationId());

                    OpenAccountOperatorLogEntity openAccountOperatorLogEntity = new OpenAccountOperatorLogEntity();
                    openAccountOperatorLogEntity.setApplicationId(openAccountAdditionalFileEntity.getApplicationId());
                    openAccountOperatorLogEntity.setCurrentNode(customerAccountOpenApplyInfo.getCurrentNode());
                    openAccountOperatorLogEntity.setOperateType(3);
                    openAccountOperatorLogEntity.setCreateUser(UserUtils.getCurrentUserId());
                    openAccountOperatorLogEntity.setCreateTime(new Date());

                    openAccountOperatorLogService.save(openAccountOperatorLogEntity);
                }

                responseVO.setCode(0);
                responseVO.setMessage("ok");
                return responseVO;
            } else {
                responseVO.setCode(999);
                responseVO.setMessage("文件保存失败!");
                return responseVO;
            }
        } catch (Exception e) {
            responseVO.setCode(999);
            responseVO.setMessage("文件保存失败!");
            return responseVO;
        }
    }


    /**
     * 保存aml文件信息
     *
     * @param customerAccountOpenInfoEntity
     * @return
     */
    @RequestMapping(value = "/editAmlInfo")
    public
    @ResponseBody
    Result editAmlInfo(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity) {

        if (StringUtils.isBlank(customerAccountOpenInfoEntity.getApplicationId())) {
            return Result.ok();
        }

        customerAccountOpenInfoService.update(customerAccountOpenInfoEntity);
        boolean isSucceed = true;
        if (isSucceed) {
            return Result.ok();
        }

        return Result.error();
    }

    /**
     * 删除aml文件信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delAmlInfo")
    public
    @ResponseBody
    Result delAmlInfo(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity) {

        int isSucceed = openAccountAdditionalFileService.deleteFile(openAccountAdditionalFileEntity);
        if (isSucceed > 0) {
            // 更新客户开户业务操作员日志表
            CustomerAccountOpenApplyEntity customerAccountOpenApplyInfo = customerAccOpenApplyService.queryObjectByApplicationId(openAccountAdditionalFileEntity.getApplicationId());

            OpenAccountOperatorLogEntity openAccountOperatorLogEntity = new OpenAccountOperatorLogEntity();
            openAccountOperatorLogEntity.setApplicationId(openAccountAdditionalFileEntity.getApplicationId());
            openAccountOperatorLogEntity.setCurrentNode(customerAccountOpenApplyInfo.getCurrentNode());
            openAccountOperatorLogEntity.setOperateType(4);
            openAccountOperatorLogEntity.setCreateUser(UserUtils.getCurrentUserId());
            openAccountOperatorLogEntity.setCreateTime(new Date());

            openAccountOperatorLogService.save(openAccountOperatorLogEntity);
            return Result.ok();
        }
        return Result.error();
    }


    @RequestMapping(value = "proofFiles")
    public String proofFiles(HttpServletRequest request, Model model) {

        OpenAccountAdditionalFileEntity supFile = new OpenAccountAdditionalFileEntity();
        supFile.setApplicationId(request.getParameter("applicationId"));
        supFile.setFileType(3);
        supFile.setUpdateUser(UserUtils.getCurrentUserId());
        List<OpenAccountAdditionalFileEntity> proofFiles = openAccountAdditionalFileService.queryListByEntity(supFile);
        model.addAttribute("proofFiles", proofFiles);
        model.addAttribute("supFile", supFile);
        return "account/online/proofFiles";
    }

    @RequestMapping(value = "getProofFileData")
    public @ResponseBody
    Result getProofFileData(HttpServletRequest request, Model model) {

        OpenAccountAdditionalFileEntity supFile = new OpenAccountAdditionalFileEntity();
        supFile.setApplicationId(request.getParameter("applicationId"));
        supFile.setFileType(3);
        supFile.setUpdateUser(UserUtils.getCurrentUserId());
        List<OpenAccountAdditionalFileEntity> proofFiles = openAccountAdditionalFileService.queryListByEntity(supFile);
        return Result.ok().put("result", proofFiles);
    }


    /**
     * 加急处理
     *
     * @param
     * @return
     */
    @RequestMapping(value = "fireAidTask", method = RequestMethod.POST)
    @ResponseBody
    public Result fireAidTask(String applicationIds, HttpServletRequest request) {
        if (StringUtils.isEmpty(applicationIds)) {
            throw new MyException("未勾选复审或终审中业务！");
        }
        try {
            customerAccOpenApplyService.updateBatchByApplicationIds(applicationIds);
        } catch (Exception e) {
            logger.error("加急任务异常!", e);
            return Result.error("加急任务异常!");
        }
        return Result.ok();
    }

    /**
     * 局部刷新影像资料
     *
     * @param model
     * @param applicationId 流程id
     * @return
     */
    @RequestMapping(value = "pictureRefresh")
    public String pictureRefresh(Model model, String applicationId) {
        //开户信息表
        CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(applicationId);
        //图片
        List<CustomerAccountOpenImgEntity> customerAccountOpenImages = customerAccountOpenImageService.queryByAccountOpenInfoId(applicationId);
        //图片展示时  不展示APP活体照片(香港开户 区分身份证展示)
        List<CustomerAccountOpenImgEntity> openImgs = filterOpenImages(customerAccountOpenImages, customerAccountOpenInfo);

        model.addAttribute("customerAccountOpenImages", openImgs);
        model.addAttribute("applicationId", applicationId);

        return "account/online/pictureRefresh";
    }

    /**
     * 局部AML模块
     *
     * @param model
     * @param applicationId 流程id
     * @return
     */
    @RequestMapping(value = "amlRefresh")
    public String amlRefresh(Model model, String applicationId) {

        //AML文件list
        OpenAccountAdditionalFileEntity amlFileParams = new OpenAccountAdditionalFileEntity();
        amlFileParams.setApplicationId(applicationId);
        amlFileParams.setFileType(2);
        List<OpenAccountAdditionalFileEntity> amlFileList = openAccountAdditionalFileService.queryListByEntity(amlFileParams);

        model.addAttribute("amlFileList", amlFileList);
        model.addAttribute("applicationId", applicationId);
        return "account/online/amlRefresh";
    }

    /**
     * 保存备注
     */
    @RequestMapping("/saveComment")
    public @ResponseBody
    ResponseVO saveComment(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity, HttpServletRequest request) throws Exception {
        ResponseVO vo = new ResponseVO();
        int count = 0;
        openAccountAdditionalFileEntity.setCreateUser(UserUtils.getCurrentUserId());
        openAccountAdditionalFileEntity.setCreateTime(new Date());
        openAccountAdditionalFileEntity.setUpdateTime(new Date());
        openAccountAdditionalFileEntity.setAdditionalId(openAccountAdditionalFileEntity.getApplicationId());
        count = openAccountAdditionalFileService.saveRecord(openAccountAdditionalFileEntity);
        openAccountAdditionalFileService.resetUpdateUser(openAccountAdditionalFileEntity.getApplicationId());

        if (count > 0) {
            vo.setCode(0);
            vo.setMessage("保存成功！");
            return vo;
        } else {
            vo.setCode(-1);
            vo.setMessage("保存意见失败！");
            return vo;
        }
    }

    /**
     * 开户记录导出Excel
     *
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping(value = "/openAcctListExp")
    @RequiresPermissions("customerAcc:exp")
    @SysLog("开户记录导出Excel")
    public void dealAccountExcel(AccountOpenApplyQuery queryCondition, HttpServletRequest request, HttpServletResponse response) {
        try {

            String applicationTimeStart = queryCondition.getApplicationTimeStart();
            String applicationTimeEnd = queryCondition.getApplicationTimeEnd();
            if (StringUtils.isNotBlank(applicationTimeStart)) {
                queryCondition.setApplicationTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(applicationTimeStart)), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(applicationTimeEnd)) {
                queryCondition.setApplicationTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(applicationTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
            }

            List<AccountOpenApplyDetailInfo> openAcctList = customerAccountOpenService.findList(queryCondition);

            List<OpenAcctListModel> modelList = Lists.newArrayList();

            for (int i = 0; i < openAcctList.size(); i++) {
                OpenAcctListModel model = new OpenAcctListModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setApplicationId(openAcctList.get(i).getCustomerAccountOpenInfoEntity().getApplicationId());
                model.setApplicationTime(DateUtil.formatDateTime(openAcctList.get(i).getCustomerAccountOpenInfoEntity().getApplicationTime()));
                if (openAcctList.get(i).getCustomerAccountOpenInfoEntity().getOpenAccountType() == 0) {
                    model.setOpenAccountType("未知");
                } else if (openAcctList.get(i).getCustomerAccountOpenInfoEntity().getOpenAccountType() == 1 &&
                        openAcctList.get(i).getCustomerAccountOpenInfoEntity().getBankType() == 0) {
                    model.setOpenAccountType("香港银行卡");
                } else if (openAcctList.get(i).getCustomerAccountOpenInfoEntity().getOpenAccountType() == 1 &&
                        openAcctList.get(i).getCustomerAccountOpenInfoEntity().getBankType() == 1) {
                    model.setOpenAccountType("大陆银行卡");
                } else if (openAcctList.get(i).getCustomerAccountOpenInfoEntity().getOpenAccountType() == 6) {
                    model.setOpenAccountType("SZCA电子证书");
                } else if (openAcctList.get(i).getCustomerAccountOpenInfoEntity().getOpenAccountType() == 2) {
                    model.setOpenAccountType("线下开户");
                }

                model.setUserId(openAcctList.get(i).getCustomerAccountOpenInfoEntity().getUserId() == null ? "" : openAcctList.get(i).getCustomerAccountOpenInfoEntity().getUserId().toString());
                model.setClientName(openAcctList.get(i).getCustomerAccountOpenInfoEntity().getClientName());
                model.setIdKind(CodeUtils.getCodeName("AO_ID_KIND", String.valueOf(openAcctList.get(i).getCustomerAccountOpenInfoEntity().getIdKind())));
//                model.setIdNo(openAcctList.get(i).getCustomerAccountOpenInfoEntity().getIdNo());
                model.setChannelId(openAcctList.get(i).getCustomerAccountOpenInfoEntity().getSourceChannelId());
                model.setApplicationStatus(CodeUtils.getCodeName("AO_OPEN_ACCOUNT_STATUS", String.valueOf(openAcctList.get(i).getCustomerAccountOpenApplyEntity().getApplicationStatus())));
                model.setAccountLevel(CodeUtils.getCodeName("AO_OPEN_ACCOUNT_LEVEL", String.valueOf(openAcctList.get(i).getCustomerAccountOpenInfoEntity().getAccountLevel())));
                //add phoneNo by lidh on 20190513
                model.setPhoneNo(openAcctList.get(i).getCustomerAccountOpenInfoEntity().getPhoneNumber());
                // 通过证件类型，证件号码查询历史流程信息
                CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(openAcctList.get(i).getCustomerAccountOpenApplyEntity().getApplicationId());
                ExtendActTasklogEntity extendActTasklogEntity = new ExtendActTasklogEntity();
                extendActTasklogEntity.setBusId(openAcctList.get(i).getCustomerAccountOpenApplyEntity().getApplicationId());
                List<ExtendActTasklogEntity> tasklogList = tasklogService.queryListProcessLog(extendActTasklogEntity);
                customerAccountOpenService.joinBackReasonType(tasklogList);

                StringBuffer backReason = new StringBuffer();
                if (tasklogList != null) {
                    for (ExtendActTasklogEntity log : tasklogList) {
                        if (log.getBackReasonType() != null && !"".equals(log.getBackReasonType())) {
                            backReason.append(log.getBackReasonType()).append(";");
                        }
                    }
                }

                model.setBackReason(backReason.toString());

                modelList.add(model);
            }

            // 执行excel操作
            EasyExcelUtils.exportXlsxFile(modelList, response, OpenAcctListModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 待开户导出Excel
     *
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping(value = "/waitOpenAcctListExp")
    @RequiresPermissions("waitOpenAcc:exp")
    @SysLog("待开户导出Excel")
    public void waitOpenAcctListExp(AccountOpenApplyQuery queryCondition, HttpServletRequest request, HttpServletResponse response) {
        try {

            String applicationTimeStart = queryCondition.getApplicationTimeStart();
            String applicationTimeEnd = queryCondition.getApplicationTimeEnd();
            if (StringUtils.isNotBlank(applicationTimeStart)) {
                queryCondition.setApplicationTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(applicationTimeStart)), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(applicationTimeEnd)) {
                queryCondition.setApplicationTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(applicationTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
            }

            queryCondition.setCurrentNode("开户");
            queryCondition.setIsExpExcel(0);
            List<AccountOpenApplyDetailInfo> openAcctList = customerAccountOpenService.findList(queryCondition);

            List<WaitOpenAccExcelModel> modelList = Lists.newArrayList();

            String[] applicationIds = new String[openAcctList.size()];

            for (int i = 0; i < openAcctList.size(); i++) {
                applicationIds[i] = openAcctList.get(i).getCustomerAccountOpenInfoEntity().getApplicationId();

                WaitOpenAccExcelModel model = new WaitOpenAccExcelModel();
                // 填充数据
                model.setId(String.valueOf(i + 1));
                // 通过证件类型，证件号码查询历史流程信息
                ExtendActTasklogEntity extendActTasklogEntity = new ExtendActTasklogEntity();
                extendActTasklogEntity.setBusId(openAcctList.get(i).getCustomerAccountOpenApplyEntity().getApplicationId());
                List<ExtendActTasklogEntity> tasklogList = tasklogService.queryListProcessLog(extendActTasklogEntity);
                customerAccountOpenService.joinBackReasonType(tasklogList);

                StringBuffer backReason = new StringBuffer();
                if (tasklogList != null) {
                    for (ExtendActTasklogEntity log : tasklogList) {
                        if (log.getBackReasonType() != null && !"".equals(log.getBackReasonType())) {
                            backReason.append(log.getBackReasonType()).append(";");
                        }
                    }
                }

                modelList.add(model);
            }

            // 执行excel操作
            EasyExcelUtils.exportXlsxFile(modelList, response, WaitOpenAccExcelModel.class);

            //导出后更新导出状态
            customerAccOpenApplyService.updateBatchExpExcelStatus(applicationIds);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 开户确认(批量)
     *
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping(value = "/batchConfirmOpenAcct")
    @RequiresPermissions("customer:waitConfirm")
    @SysLog("开户确认")
    public void batchConfirmOpenAcct(AccountOpenApplyQuery queryCondition, HttpServletRequest request, HttpServletResponse response) {
        String applicationTimeStart = queryCondition.getApplicationTimeStart();
        String applicationTimeEnd = queryCondition.getApplicationTimeEnd();
        if (StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(applicationTimeStart)), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(applicationTimeEnd)) {
            queryCondition.setApplicationTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(applicationTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
        }

        queryCondition.setCurrentNode("开户");
        queryCondition.setIsExpExcel(1);
        List<AccountOpenApplyDetailInfo> openAcctList = customerAccountOpenService.findList(queryCondition);
        doConfirmOpenAcc(openAcctList);
    }

    /**
     * 开户确认
     *
     * @param applicationId
     * @param request
     * @return
     */
    @RequestMapping(value = "/confirmOpenAcct")
    @RequiresPermissions("customer:waitConfirm")
    @SysLog("开户确认")
    public void confirmOpenAcct(String applicationId, HttpServletRequest request, HttpServletResponse response) {
        if (applicationId == null || StringUtils.isBlank(applicationId)){
            return;
        }

        AccountOpenApplyQuery queryCondition = new AccountOpenApplyQuery();
        queryCondition.setApplicationId(applicationId);
        List<AccountOpenApplyDetailInfo> openAcctList = customerAccountOpenService.findList(queryCondition);
        doConfirmOpenAcc(openAcctList);
    }

    /**
     * 转入复审
     *
     * @param busId
     * @return
     */
    @RequestMapping("/doTurnToRecheck")
    public
    @ResponseBody
    Result doTurnToRecheck(String busId) {

        Result result = null;

        try {

            ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(busId);

            CustomerAccountOpenApplyEntity customerAccountOpenApply = customerAccOpenApplyService.queryObjectByApplicationId(busId);


        } catch (Exception e) {
            logger.error("操作失败", e);
            result = Result.error("办理任务失败");
        }

        return result;
    }

    /**
     * 过滤开户图片展示
     */
    private List<CustomerAccountOpenImgEntity> filterOpenImages(List<CustomerAccountOpenImgEntity> customerAccountOpenImages, CustomerAccountOpenInfoEntity customerAccountOpenInfo) {
        //图片展示时  不展示APP活体照片(香港开户 区分身份证展示)
        List<CustomerAccountOpenImgEntity> openImgs = Lists.newArrayList();
        //中华人民共和国居民身份证
        if (1 == customerAccountOpenInfo.getIdKind()) {
            for (CustomerAccountOpenImgEntity openImg : customerAccountOpenImages) {
                if (!CustomerAccountOpenHelper.isLivingPhoto(openImg.getImageLocationType())) {
                    if (openImg.getImageLocationType() != 103 && openImg.getImageLocationType() != 104 && openImg.getImageLocationType() != 105) {
                        openImgs.add(openImg);
                    }
                }
            }

            //香港永久性居民身份证
        } else if (2 == customerAccountOpenInfo.getIdKind()) {
            for (CustomerAccountOpenImgEntity openImg : customerAccountOpenImages) {
                if (!CustomerAccountOpenHelper.isLivingPhoto(openImg.getImageLocationType())) {
                    if (openImg.getImageLocationType() != 101 && openImg.getImageLocationType() != 102 && openImg.getImageLocationType() != 104
                            && openImg.getImageLocationType() != 105) {
                        openImgs.add(openImg);
                    }
                }
            }

            //香港居民身份证与签证身份书
        } else if (4 == customerAccountOpenInfo.getIdKind()) {
            for (CustomerAccountOpenImgEntity openImg : customerAccountOpenImages) {
                if (!CustomerAccountOpenHelper.isLivingPhoto(openImg.getImageLocationType())) {
                    if (openImg.getImageLocationType() != 101 && openImg.getImageLocationType() != 102 && openImg.getImageLocationType() != 104) {
                        openImgs.add(openImg);
                    }
                }
            }

            //护照
        } else if (3 == customerAccountOpenInfo.getIdKind()) {
            for (CustomerAccountOpenImgEntity openImg : customerAccountOpenImages) {
                if (!CustomerAccountOpenHelper.isLivingPhoto(openImg.getImageLocationType())) {
                    if (openImg.getImageLocationType() != 101 && openImg.getImageLocationType() != 102 && openImg.getImageLocationType() != 103
                            && openImg.getImageLocationType() != 105) {
                        openImgs.add(openImg);
                    }
                }
            }
        }
        return openImgs;
    }

    /**
     * 数据归档
     *
     * @param openAcctList
     */
    private void doConfirmOpenAcc(List<AccountOpenApplyDetailInfo> openAcctList) {
        for (AccountOpenApplyDetailInfo openApplyDetailInfo : openAcctList) {
            CustomerAccountOpenApplyEntity openApplicationEntity = openApplyDetailInfo.getCustomerAccountOpenApplyEntity();

            // 数据归档
            CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = openApplyDetailInfo.getCustomerAccountOpenInfoEntity();

            // 驱动流程下一步
            actModelerService.doNextFlow(openApplicationEntity.getApplicationId(), openApplicationEntity.getInstanceId(), "");

            // 互联网开户需要备份影像资料
            if (1 == customerAccountOpenInfoEntity.getOpenAccountType()) {
                customerAccountOpenService.backupAccountOpenImage(customerAccountOpenInfoEntity.getClientId(), customerAccountOpenInfoEntity.getApplicationId());
                customerAccountOpenService.backupAccountOpenReport(customerAccountOpenInfoEntity.getClientId(), customerAccountOpenInfoEntity.getApplicationId());
            }

            // 备份AML文件
            customerAccountOpenService.backupAccountOpenAml(customerAccountOpenInfoEntity.getClientId(), customerAccountOpenInfoEntity.getApplicationId());

            // 归档节点程序自动审核
            CustomerAccountOpenApplyEntity customerAccountOpenApplyEntity = customerAccOpenApplyService.queryObjectByApplicationId(openApplicationEntity.getApplicationId());
            CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(openApplicationEntity.getApplicationId());

            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "5").equals(customerAccountOpenApplyEntity.getCurrentNode())) {

                // CA认证更新开户状态为已开户，帐户等级为标准帐户
                //线下开户等级为标准账户
                if (1 == customerAccountOpenInfo.getBankType() || 2 == customerAccountOpenInfo.getOpenAccountType()) {
                    // 更新预约申请表相关信息
                    CustomerAccountOpenApplyEntity customerAccOpenApply = new CustomerAccountOpenApplyEntity();
                    customerAccOpenApply.setApplicationId(customerAccountOpenApplyEntity.getApplicationId());
                    customerAccOpenApply.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_OPEN_ACCOUNT_VALUE);

                    customerAccOpenApplyService.updateByApplicationId(customerAccOpenApply);

                    // 更新账户等级
                    CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity1 = new CustomerAccountOpenInfoEntity();
                    customerAccountOpenInfoEntity1.setApplicationId(customerAccountOpenApplyEntity.getApplicationId());
                    customerAccountOpenInfoEntity1.setAccountLevel(3);
                    customerAccountOpenInfoService.update(customerAccountOpenInfoEntity1);
                } else {
                    // 更新账户等级为预批帐户
                    CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity2 = new CustomerAccountOpenInfoEntity();
                    customerAccountOpenInfoEntity2.setApplicationId(customerAccountOpenApplyEntity.getApplicationId());
                    customerAccountOpenInfoEntity2.setAccountLevel(1);
                    customerAccountOpenInfoService.update(customerAccountOpenInfoEntity2);
                }

                actModelerService.doNextFlow(openApplicationEntity.getApplicationId(), openApplicationEntity.getInstanceId(), "");
            }
        }
    }
}
