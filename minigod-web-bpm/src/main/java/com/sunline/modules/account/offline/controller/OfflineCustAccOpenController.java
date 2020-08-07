package com.sunline.modules.account.offline.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.offline.service.CustAccOpenOfflineService;
import com.sunline.modules.account.offline.service.OfflineAccOpenApplyService;
import com.sunline.modules.account.online.converter.CustomerOpenAccountConverter;
import com.sunline.modules.account.online.dao.CustomerAccountOpenApplyDao;
import com.sunline.modules.account.online.entity.*;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.account.online.helper.CustomerAccountOpenHelper;
import com.sunline.modules.account.online.helper.IdCardHelper;
import com.sunline.modules.account.online.manager.CustomerAccountOpenManager;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.model.AccountOpenApplyQuery;
import com.sunline.modules.account.online.model.CustomerAccOpenInfoModel;
import com.sunline.modules.account.online.model.FileInfo;
import com.sunline.modules.account.online.service.*;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.utils.ActUtils;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.entity.NationalPhoneAreaCodeEntity;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.service.NationalPhoneAreaCodeService;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.service.CodeService;
import com.sunline.modules.sys.service.RoleService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 类的功能描述.
 * 线下开户
 *
 * @Auther LiYangFeng
 * @Date 2017/7/25
 */

@RequestMapping("offlineCustAccOpen")
@Controller
public class OfflineCustAccOpenController {
    private static final Logger logger = LoggerFactory.getLogger(OfflineCustAccOpenController.class);
    @Autowired
    CustomerAccOpenService customerAccountOpenService;
    @Autowired
    OfflineAccOpenApplyService offlineAccOpenApplyService;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    CustomerAccOpenImageService customerAccountOpenImageService;
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
    CustomerAccountOpenApplyDao customerAccountOpenApplyDao;
    @Autowired
    private TaskService taskService;
    @Autowired
    OpenAccountProcessLogService openAccountProcessLogService;
    @Autowired
    CustAccOpenOfflineService custAccOpenOfflineService;
    @Autowired
    CodeService codeService;
    @Autowired
    private OpenAccountOperatorLogService openAccountOperatorLogService;
    @Autowired
    CustomerAccOpenApplyService customerAccOpenApplyService;
    @Autowired
    NationalPhoneAreaCodeService nationalPhoneAreaCodeService;
    @Autowired
    CustomerAccountOpenManager customerAccountOpenManager;
    private final String CUSTOMER_ACCOUNT_OPEN_OFFLINE_FLOW_MODEL_KEY = "customerAccountOpenApplicationOffline";

    /**
     * 开户审核列表
     */
    @RequestMapping("/checkList")
    @RequiresPermissions("offlineCustAccOpen:checkList")
    public String checkList(Model model, AccountOpenApplyQuery queryCondition, HttpServletRequest request) throws Exception {

        String applicationTimeStart = queryCondition.getApplicationTimeStart();
        String applicationTimeEnd = queryCondition.getApplicationTimeEnd();
        if (applicationTimeStart != null && StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(applicationTimeStart)), "yyyy-MM-dd HH:mm:ss"));
        }
        if (applicationTimeEnd != null && StringUtils.isNotBlank(applicationTimeEnd)) {
            queryCondition.setApplicationTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(applicationTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        queryCondition.setUpdateUser(UserUtils.getCurrentUserId());

        //根据当前角色所拥有权限进入 审核页面分别为（初审 复审 终审）
        List<String> currentNodes = new ArrayList<>();
        Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("ONLINE_OPEN_ACCOUNT_OFFLINE_MODEL_ID", null));
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

        //开户类型设置线下开户
        queryCondition.setOpenAccountType(2);

        //超级管理员  不做权限验证
        if (UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
            queryCondition.setCurrentNode(null);
        } else {
            queryCondition.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
        }

        queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
        Page<AccountOpenApplyDetailInfo> page = customerAccountOpenService.findPageCheck(queryCondition, pageNum);

        if (applicationTimeStart != null && StringUtils.isNotBlank(applicationTimeStart)) {
            queryCondition.setApplicationTimeStart(applicationTimeStart);
        }
        if (queryCondition.getApplicationTimeEnd() != null && StringUtils.isNotBlank(queryCondition.getApplicationTimeEnd())) {
            queryCondition.setApplicationTimeEnd(applicationTimeEnd);
        }
        model.addAttribute("page", page);
        model.addAttribute("queryCondition", queryCondition);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());

        return "account/offline/openAcctCheckList";
    }

    /**
     * 线下开户 开户资料详情
     *
     * @param processTaskDto
     * @param model
     * @param flag
     * @return
     */
    @RequestMapping(value = "custAccOpenInfoApprove", method = RequestMethod.POST)
    public String custAccOpenInfoApprove(ProcessTaskDto processTaskDto, Model model, String flag) {

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


        getCustAccOpenInfo(model, processTaskDto.getBusId());


        // 获取工作流运行时任务ID
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).list();
        processTaskDto.setTaskId(tasks.size() > 0 ? tasks.get(0).getId() : null);


        model.addAttribute("taskDto", processTaskDto);
        model.addAttribute("flag", flag);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());

        return "/account/offline/custAccOpenInfoApprove";
    }


    /**
     * 线下开户资料修改页面
     *
     * @param model
     * @param applicationId 流程id
     * @return
     */
    @RequestMapping("custAccOpenEdit")
    public String custAccOpenEdit(Model model, String applicationId) {

        getCustAccOpenInfo(model, applicationId);

        return "account/offline/custAccOpenEdit";
    }

    private void getCustAccOpenInfo(Model model, String applicationId) {

        //开户信息表
        CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(applicationId);
        //申请表
        CustomerAccountOpenApplyEntity accountOpenApplicationEntity = offlineAccOpenApplyService.queryObjectByApplicationId(applicationId);
        //税务
        List<OpenAccountTaxationInfoEntity> openAccountTaxationInfoEntity = openAccountTaxationInfoService.queryByApplicationId(applicationId);
        //其他信息表
        List<OpenAccountOtherDisclosureEntity> openAccountOtherDisclosureEntity = openAccountOtherDisclosureService.queryByApplicationId(applicationId);

        //把name和详情拼接为 张三丰,深圳市宝安区;李四,深圳市
        for (OpenAccountOtherDisclosureEntity entity : openAccountOtherDisclosureEntity) {
            boolean ischeck = false;
            Integer code = entity.getDisclosureCode();
            //1,2,3选择否,11,12,13,14,15选择是时需要添加详细信息
            if (entity.getDisclosureIsTrue() == 0 && (code <= 20)) {
                ischeck = true;
            }
            if (entity.getDisclosureIsTrue() == 1 && (code > 20 && code <= 40)) {
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

        //见证人证书
        additionalFileEntity.setFileType(4);
        List<OpenAccountAdditionalFileEntity> witnessesFileList = openAccountAdditionalFileService.queryListByEntity(additionalFileEntity);

        CustomerAccOpenInfoModel customerAccountOpenInfoModel = CustomerOpenAccountConverter.entityToModel(customerAccountOpenInfo);
        //图片
        List<CustomerAccountOpenImgEntity> customerAccountOpenImages = customerAccountOpenImageService.queryByAccountOpenInfoId(customerAccountOpenInfo.getApplicationId());
        //图片展示时  不展示APP活体照片
        List<CustomerAccountOpenImgEntity> openImgs = Lists.newArrayList();
        for (CustomerAccountOpenImgEntity openImg : customerAccountOpenImages) {
            if (!CustomerAccountOpenHelper.isLivingPhoto(openImg.getImageLocationType())) {
                openImgs.add(openImg);
            }
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

        //见证人证书list
        model.addAttribute("witnessesFileList",witnessesFileList);

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
            if ("W8".equals(file.getName().replace(".pdf", ""))) {
                fileInfo.setDisplayName("下载《W8-ben表格》");
            }
            if ("开户表格".equals(file.getName().replace(".pdf", ""))) {
                fileInfo.setDisplayName("下载《开户表格》");
            }
            if ("自我证明表格-个人".equals(file.getName().replace(".pdf", ""))) {
                fileInfo.setDisplayName("下载《CRS表格》");
            }
            if ("有关美国公民身份证明书".equals(file.getName().replace(".pdf", ""))) {
                fileInfo.setDisplayName("下载《美国公民身份证明》");
            }
            fileInfo.setFileUri(file.getPath().replace("\\", "/"));
            reportFiles.add(fileInfo);
        }

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

    }


    @RequestMapping(value = "cusAccOpenEntering")
    public String cusAccOpenEntering(Model model) {
        // 检验预约流水号的唯一性
        String applicationId = OrderUtil.getOrderNoByAtomic(1);
        CustomerAccountOpenApplyEntity customerAccoOpenApplyInfo = customerAccountOpenApplyDao.queryObjectByApplicationId(applicationId);
        while (null != customerAccoOpenApplyInfo) {
            applicationId = OrderUtil.getOrderNoByAtomic(1);
            customerAccoOpenApplyInfo = customerAccountOpenApplyDao.queryObjectByApplicationId(applicationId);
        }

        //AML文件list
        OpenAccountAdditionalFileEntity amlFileParams = new OpenAccountAdditionalFileEntity();
        amlFileParams.setApplicationId(applicationId);
        amlFileParams.setFileType(2);
        List<OpenAccountAdditionalFileEntity> amlFileList = openAccountAdditionalFileService.queryListByEntity(amlFileParams);

        amlFileParams.setFileType(4);
        List<OpenAccountAdditionalFileEntity> witnessesFileList = openAccountAdditionalFileService.queryListByEntity(amlFileParams);

        List<NationalPhoneAreaCodeEntity> phoneAreaCodeList = nationalPhoneAreaCodeService.queryList(new NationalPhoneAreaCodeEntity());

        model.addAttribute("applicationId", applicationId);
        model.addAttribute("amlFileList", amlFileList);
        model.addAttribute("witnessesFileList", witnessesFileList);
        model.addAttribute("phoneAreaCodeList", JSONArray.toJSONString(phoneAreaCodeList));
        return "account/offline/custAccOpenEntering";
    }

    /**
     * 线下开户 提交开户
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/doCusAccOpenEntering")
    @Transactional(rollbackFor = Exception.class)
    public @ResponseBody
    Result doCusAccOpenEntering(@RequestBody CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity, HttpServletRequest request) {
        try {

            if (customerAccountOpenInfoEntity.getIdKind() != null && customerAccountOpenInfoEntity.getIdNo() != null) {
                OpenAccountBlacklistEntity entity = new OpenAccountBlacklistEntity();
                entity.setIdKind(customerAccountOpenInfoEntity.getIdKind());
                entity.setIdNo(customerAccountOpenInfoEntity.getIdNo());
                if (null != openAccountBlacklistService.isExistedBlacklist(entity)) {
                    return Result.error("证件号码已被纳入黑名单");
                }
            }
            //验证交易帐号（靓号）是否已被申请
            if (customerAccountOpenInfoEntity.getClientId() != null && customerAccountOpenInfoEntity.getClientId() != "") {
                int tradeAccountNumber = customerAccountOpenInfoService.validateTradeAccount(customerAccountOpenInfoEntity);
                if (tradeAccountNumber > 0) {
                    return Result.error("该客户帐号已被申请!");
                }
            }

            //财产种类
            String propertyInfo = customerAccountOpenInfoEntity.getPropertyInfo();
            List<OpenAccountPropertyTypeEntity> propertyInfoList = JSONArray.parseArray(propertyInfo, OpenAccountPropertyTypeEntity.class);
            customerAccountOpenInfoEntity.setPropertyTypeList(propertyInfoList);
            //税务信息
            String taxInfo = customerAccountOpenInfoEntity.getTaxInfo();
            List<OpenAccountTaxationInfoEntity> taxInfoList = JSONArray.parseArray(taxInfo, OpenAccountTaxationInfoEntity.class);
            customerAccountOpenInfoEntity.setTaxationInfoList(taxInfoList);
            //其他信息披露
            String otherInfo = customerAccountOpenInfoEntity.getOtherInfo();
            List<OpenAccountOtherDisclosureEntity> otherInfoList = JSONArray.parseArray(otherInfo, OpenAccountOtherDisclosureEntity.class);
            customerAccountOpenInfoEntity.setOtherDisclosureList(otherInfoList);

            //数据验证
            ResponseVO commonResultCode = CustomerAccountOpenHelper.openAccEnteringValidate(customerAccountOpenInfoEntity);
            if (-1 == commonResultCode.getCode()) {
                return new Result(String.valueOf(commonResultCode.getCode()), commonResultCode.getMessage());
            }

            boolean existedIdCard = customerAccountOpenManager.isExistedIdCard(customerAccountOpenInfoEntity.getIdKind(), customerAccountOpenInfoEntity.getIdNo());
            if (existedIdCard) {
                return Result.error("该证件号已存在!");
            }

            boolean existedEmail = customerAccountOpenManager.isExistedEmail(customerAccountOpenInfoEntity.getEmail());
            if (existedEmail) {
                return Result.error("该邮件已存在!");
            }

            boolean existedPhoneNumber = customerAccountOpenManager.isExistedPhoneNumber(customerAccountOpenInfoEntity.getPhoneNumber());
            if (existedPhoneNumber) {
                return Result.error("该手机号码已存在!");
            }

            //application表
            CustomerAccountOpenApplyEntity customerAccountOpenApplicationEntity = new CustomerAccountOpenApplyEntity();
            customerAccountOpenApplicationEntity.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
            customerAccountOpenApplicationEntity.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            customerAccountOpenApplicationEntity.setAccountOpenResultStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            customerAccountOpenApplicationEntity.setApplicationTitle("BPM线下开户申请[" + customerAccountOpenInfoEntity.getClientName() + "]");
            customerAccountOpenApplicationEntity.setCurrentNode("复审");
            customerAccountOpenApplicationEntity.setWitnessUser(customerAccountOpenInfoEntity.getWitnessUser());
            customerAccountOpenApplicationEntity.setWitnessesType(customerAccountOpenInfoEntity.getWitnessesType());
            customerAccountOpenApplicationEntity.setLicenseNumber(customerAccountOpenInfoEntity.getLicenseNumber());
            customerAccountOpenApplicationEntity.setSubmitApprovalUser(customerAccountOpenInfoEntity.getSubmitApprovalUser());
            offlineAccOpenApplyService.save(customerAccountOpenApplicationEntity);

            //info表
            customerAccountOpenInfoEntity.setCapitalSource("[" + customerAccountOpenInfoEntity.getCapitalSource() + "]");
            customerAccountOpenInfoEntity.setInvestTarget("[" + customerAccountOpenInfoEntity.getInvestTarget() + "]");
            if (!customerAccountOpenInfoEntity.getInvestTarget().contains("4")) {
                customerAccountOpenInfoEntity.setInvestTargetOther("");
            }

            customerAccountOpenInfoEntity.setApplicationTime(new Date());
            customerAccountOpenInfoEntity.setOpenAccountType(2);
            //线下开户银行卡类型未知
            customerAccountOpenInfoEntity.setBankType(2);
            customerAccountOpenInfoEntity.setOpenAccountAccessWay(3);
            if (customerAccountOpenInfoEntity.getClientName() != null && StringUtils.isNotBlank(customerAccountOpenInfoEntity.getClientName())) {
                customerAccountOpenInfoEntity.setFamilyName(IdCardHelper.getFamilyName(customerAccountOpenInfoEntity.getClientName()));
                customerAccountOpenInfoEntity.setGivenName(IdCardHelper.getGivenName(customerAccountOpenInfoEntity.getClientName()));
            }

            if(StringUtils.isEmpty(customerAccountOpenInfoEntity.getContactProvinceName())&&StringUtils.isEmpty(customerAccountOpenInfoEntity.getContactProvinceName())
            &&StringUtils.isEmpty(customerAccountOpenInfoEntity.getContactProvinceName())&&StringUtils.isEmpty(customerAccountOpenInfoEntity.getContactProvinceName())){
                customerAccountOpenInfoEntity.setContactProvinceName(IdCardHelper.getProvinceName(customerAccountOpenInfoEntity.getContactAddress()));
                customerAccountOpenInfoEntity.setContactCityName(IdCardHelper.getCityName(customerAccountOpenInfoEntity.getContactAddress()));
                customerAccountOpenInfoEntity.setContactCountyName(IdCardHelper.getCountyName(customerAccountOpenInfoEntity.getContactAddress()));
                customerAccountOpenInfoEntity.setContactDetailAddress(IdCardHelper.getAddressDetailName(customerAccountOpenInfoEntity.getContactAddress()));
            }

            customerAccountOpenInfoService.save(customerAccountOpenInfoEntity);

            //财产种类
            if (customerAccountOpenInfoEntity.getPropertyTypeList() != null && customerAccountOpenInfoEntity.getPropertyTypeList().size() > 0) {
                for (OpenAccountPropertyTypeEntity propertyType : propertyInfoList) {
                    propertyType.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
                    propertyType.setCreateTime(new Date());
                    propertyType.setUpdateTime(new Date());
                }
                openAccountPropertyTypeService.saveBatch(customerAccountOpenInfoEntity.getPropertyTypeList());
            }

            //税务信息
//            openAccountTaxationInfoService.deleteByApplicationId(customerAccountOpenInfoEntity.getApplicationId());
            if (customerAccountOpenInfoEntity.getTaxationInfoList() != null && taxInfoList.size() > 0) {
                for (OpenAccountTaxationInfoEntity taxationInfo : customerAccountOpenInfoEntity.getTaxationInfoList()) {
                    taxationInfo.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
                    taxationInfo.setCreateTime(new Date());
                    taxationInfo.setUpdateTime(new Date());
                }
                openAccountTaxationInfoService.saveBatch(customerAccountOpenInfoEntity.getTaxationInfoList());

            }

            //其他信息披露
//            openAccountOtherDisclosureService.deleteByApplicationId(customerAccountOpenInfoEntity.getApplicationId());
            if (customerAccountOpenInfoEntity.getOtherDisclosureList() != null && otherInfoList.size() > 0) {
                for (OpenAccountOtherDisclosureEntity otherDisclosure : customerAccountOpenInfoEntity.getOtherDisclosureList()) {
                    otherDisclosure.setApplicationId(customerAccountOpenInfoEntity.getApplicationId());
                    otherDisclosure.setCreateTime(new Date());
                    otherDisclosure.setUpdateTime(new Date());
                }
                openAccountOtherDisclosureService.saveBatch(customerAccountOpenInfoEntity.getOtherDisclosureList());
            }

            //启动流程
            ProcessDefinition customerAccountOpenProcessDefinition = ActUtils.getlastProcessDefinition(CUSTOMER_ACCOUNT_OPEN_OFFLINE_FLOW_MODEL_KEY);
            ProcessTaskDto processTaskDto = new ProcessTaskDto();
            processTaskDto.setDefId(customerAccountOpenProcessDefinition.getId());
            processTaskDto.setBusId(customerAccountOpenInfoEntity.getApplicationId());
            processTaskDto.setActKey(customerAccountOpenProcessDefinition.getKey());
            processTaskDto.setNodeType("2");
            actModelerService.startFlow(processTaskDto);
            return Result.ok();
        } catch (Exception e) {
            logger.error("线下开户提交失败", e);
            return Result.error("线下开户提交失败！");
        }
    }

    /**
     * 上传凭证文件
     */
    @RequestMapping(value = "/proofUpload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseVO proofUpload(@RequestParam("file") MultipartFile file, CustomerAccountOpenImgEntity customerAccountOpenImgEntity, HttpServletRequest request) throws Exception {
        ResponseVO responseVO = new ResponseVO();
        if (file.isEmpty()) {
            responseVO.setCode(999);
            responseVO.setMessage("文件不能为空！");
            return responseVO;
        }

        customerAccountOpenImgEntity.setStoragePath(ConfigUtils.get("openAccount.userImage.savePath") + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/");
        customerAccountOpenImgEntity.setFileStorageName(UUID.randomUUID().toString());
        customerAccountOpenImgEntity.setExtName(FileOperaterUtil.getFileExtendName(file.getOriginalFilename()));
        customerAccountOpenImgEntity.setCreateUser(UserUtils.getCurrentUserId());
        customerAccountOpenImgEntity.setUpdateUser(UserUtils.getCurrentUserId());
        customerAccountOpenImgEntity.setCreateTime(new Date());
        customerAccountOpenImgEntity.setUpdateTime(new Date());
        customerAccountOpenImgEntity.setFileName(CustomerAccountOpenHelper.getImageName(customerAccountOpenImgEntity.getImageLocationType()));

        Boolean isSuccess = FileUpload.fileUpload(file, customerAccountOpenImgEntity.getStoragePath(), customerAccountOpenImgEntity.getFileStorageName());
        if (isSuccess) {
            customerAccountOpenImageService.deleteByApplicationId(customerAccountOpenImgEntity);
            customerAccountOpenImageService.save(customerAccountOpenImgEntity);

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
     * 上传补充资料文件
     */
    @RequestMapping(value = "/supUpload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseVO supUpload(@RequestParam("file") MultipartFile file, OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity, HttpServletRequest request) throws Exception {
        ResponseVO responseVO = new ResponseVO();
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
        if ("png,jpg,bmp,jpeg".contains(openAccountAdditionalFileEntity.getFileExtName())) {
            openAccountAdditionalFileEntity.setFileType(0);
            openAccountAdditionalFileEntity.setFileName("图片");
        } else {
            openAccountAdditionalFileEntity.setFileType(1);
            openAccountAdditionalFileEntity.setFileName("音/视频");
        }

        Boolean isSuccess = FileUpload.fileUpload(file, openAccountAdditionalFileEntity.getFilePath(), openAccountAdditionalFileEntity.getFileStorageName());
        if (isSuccess) {
            openAccountAdditionalFileService.save(openAccountAdditionalFileEntity);

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
     * 线下开户 编辑资料提交
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/custAccOpenEditSubmit")
    @Transactional(rollbackFor = Exception.class)
    public @ResponseBody
    Result custAccOpenEditSubmit(@RequestBody CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity, HttpServletRequest request) {
        try {

            //验证交易帐号（靓号）是否已被申请
            if (customerAccountOpenInfoEntity.getClientId() != null && customerAccountOpenInfoEntity.getClientId() != "") {
                int tradeAccountNumber = customerAccountOpenInfoService.validateTradeAccount(customerAccountOpenInfoEntity);
                if (tradeAccountNumber > 0) {
                    return Result.error("该客户帐号已被申请!");
                }
            }

            //财产种类
            String propertyInfo = customerAccountOpenInfoEntity.getPropertyInfo();
            List<OpenAccountPropertyTypeEntity> propertyInfoList = JSONArray.parseArray(propertyInfo, OpenAccountPropertyTypeEntity.class);
            customerAccountOpenInfoEntity.setPropertyTypeList(propertyInfoList);
            //税务信息
            String taxInfo = customerAccountOpenInfoEntity.getTaxInfo();
            List<OpenAccountTaxationInfoEntity> taxInfoList = JSONArray.parseArray(taxInfo, OpenAccountTaxationInfoEntity.class);
            customerAccountOpenInfoEntity.setTaxationInfoList(taxInfoList);
            //其他信息披露
            String otherInfo = customerAccountOpenInfoEntity.getOtherInfo();
            List<OpenAccountOtherDisclosureEntity> otherInfoList = JSONArray.parseArray(otherInfo, OpenAccountOtherDisclosureEntity.class);
            customerAccountOpenInfoEntity.setOtherDisclosureList(otherInfoList);

            //数据验证
            ResponseVO commonResultCode = CustomerAccountOpenHelper.openAccEnteringValidate(customerAccountOpenInfoEntity);
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
            cusAccOpenApplication.setWitnessUser(customerAccountOpenInfoEntity.getWitnessUser());
            cusAccOpenApplication.setWitnessesType(customerAccountOpenInfoEntity.getWitnessesType());
            cusAccOpenApplication.setLicenseNumber(customerAccountOpenInfoEntity.getLicenseNumber());
            cusAccOpenApplication.setSubmitApprovalUser(customerAccountOpenInfoEntity.getSubmitApprovalUser());
            offlineAccOpenApplyService.updateByApplicationId(cusAccOpenApplication);

            //置空图片修改人
            customerAccountOpenImageService.resetUpdateUser(customerAccountOpenInfoEntity.getApplicationId());
            //置空资料修改证明图片 修改人
            openAccountAdditionalFileService.resetUpdateUser(customerAccountOpenInfoEntity.getApplicationId());

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

            return Result.ok();
        } catch (Exception e) {
            logger.error("修改线下开户资料失败", e);
            return Result.error("修改线下开户资料失败！");
        }
    }


    /**
     * 流程终止操作
     *
     * @param processTaskDto 办理流程任务dto
     * @return
     */
    @RequestMapping("doRejectTermination")
    public
    @ResponseBody
    Result doRejectTermination(ProcessTaskDto processTaskDto) {
        Result result = null;
        if (StringUtils.isEmpty(processTaskDto.getTaskId())) {
            throw new MyException("任务id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getDefId())) {
            throw new MyException("流程定义id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getInstanceId())) {
            throw new MyException("实例id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getBusId())) {
            throw new MyException("业务id不能为空");
        }

        CustomerAccountOpenApplyEntity customerAccountOpenApply = offlineAccOpenApplyService.queryObjectByApplicationId(processTaskDto.getBusId());

        customerAccountOpenApply.setApprovalOpinion(processTaskDto.getRemark());
        customerAccountOpenApply.setLastApprovalUser(UserUtils.getCurrentUserId());

        custAccOpenOfflineService.terminateAccountOpenApplication(customerAccountOpenApply, processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_TERMINATION_VALUE);

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
     * 流程拒绝
     *
     * @param processTaskDto 办理流程任务dto
     * @return
     */
    @RequestMapping("doReject")
    public
    @ResponseBody
    Result doReject(ProcessTaskDto processTaskDto) {
        Result result = null;
        if (StringUtils.isEmpty(processTaskDto.getTaskId())) {
            throw new MyException("任务id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getDefId())) {
            throw new MyException("流程定义id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getInstanceId())) {
            throw new MyException("实例id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getBusId())) {
            throw new MyException("业务id不能为空");
        }
        CustomerAccountOpenApplyEntity applicationInfo = offlineAccOpenApplyService.queryObjectByApplicationId(processTaskDto.getBusId());

        applicationInfo.setApprovalOpinion(processTaskDto.getRemark());
        applicationInfo.setLastApprovalUser(UserUtils.getCurrentUserId());

        custAccOpenOfflineService.terminateAccountOpenApplication(applicationInfo, processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_REJECT_VALUE);

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
     * @param processTaskDto 办理流程任务dto
     * @return
     */
    @RequestMapping("doRejectBlackList")
    public
    @ResponseBody
    Result doRejectBlackList(ProcessTaskDto processTaskDto) {
        Result result = null;
        if (StringUtils.isEmpty(processTaskDto.getTaskId())) {
            throw new MyException("任务id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getDefId())) {
            throw new MyException("流程定义id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getInstanceId())) {
            throw new MyException("实例id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getBusId())) {
            throw new MyException("业务id不能为空");
        }
        CustomerAccountOpenApplyEntity applicationInfo = offlineAccOpenApplyService.queryObjectByApplicationId(processTaskDto.getBusId());
        CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(applicationInfo.getApplicationId());

        applicationInfo.setApprovalOpinion(processTaskDto.getRemark());
        applicationInfo.setLastApprovalUser(UserUtils.getCurrentUserId());

        custAccOpenOfflineService.terminateAccountOpenApplication(applicationInfo, processTaskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_REJECT_BLACKLIST_VALUE);

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
     * 删除衍生品凭证照片
     *
     * @param customerAccountOpenImgEntity
     * @return
     */
    @RequestMapping(value = "delImg")
    public @ResponseBody
    Result delImg(CustomerAccountOpenImgEntity customerAccountOpenImgEntity) {

        int count = customerAccountOpenImageService.deleteByApplicationId(customerAccountOpenImgEntity);

        if (count > 0) {
            return Result.ok();
        } else {
            return Result.error("删除凭证出错！");
        }

    }

    /**
     * 局部见证人证书模块
     *
     * @param model
     * @param applicationId 流程id
     * @return
     */
    @RequestMapping(value = "witnessesRefresh")
    public String amlRefresh(Model model, String applicationId) {

        //见证人文件list
        OpenAccountAdditionalFileEntity witnessesFile = new OpenAccountAdditionalFileEntity();
        witnessesFile.setApplicationId(applicationId);
        witnessesFile.setFileType(4);
        List<OpenAccountAdditionalFileEntity> witnessesFileList = openAccountAdditionalFileService.queryListByEntity(witnessesFile);

        model.addAttribute("witnessesFileList", witnessesFileList);
        model.addAttribute("applicationId", applicationId);
        return "account/offline/wirtnessRefresh";
    }

    /**
     * 上传文件/资料修改凭证
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
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
            } else if (openAccountAdditionalFileEntity.getFileType() == 4) {
                openAccountAdditionalFileEntity.setFileName("见证人证书");
            }
            Boolean isSuccess = FileUpload.fileUpload(file, openAccountAdditionalFileEntity.getFilePath(), openAccountAdditionalFileEntity.getFileStorageName());
            if (isSuccess) {
                openAccountAdditionalFileService.saveFile(openAccountAdditionalFileEntity);

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
     * 删除文件信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delFileInfo")
    public
    @ResponseBody
    Result delAmlInfo(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity) {

        int isSucceed = openAccountAdditionalFileService.deleteFile(openAccountAdditionalFileEntity);
        if (isSucceed > 0) {
            return Result.ok();
        } else {
            return Result.error("操作失败");
        }
    }

}
