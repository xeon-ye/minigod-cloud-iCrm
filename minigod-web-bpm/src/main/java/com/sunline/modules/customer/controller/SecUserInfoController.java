package com.sunline.modules.customer.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.account.online.entity.CustomerAccountOpenImgEntity;
import com.sunline.modules.account.online.entity.OpenAccountOtherDisclosureEntity;
import com.sunline.modules.account.online.entity.OpenAccountPropertyTypeEntity;
import com.sunline.modules.account.online.entity.OpenAccountTaxationInfoEntity;
import com.sunline.modules.account.online.service.CustomerAccOpenImageService;
import com.sunline.modules.account.online.service.OpenAccountOtherDisclosureService;
import com.sunline.modules.account.online.service.OpenAccountPropertyTypeService;
import com.sunline.modules.account.online.service.OpenAccountTaxationInfoService;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.customer.entity.ClientFareListEntity;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.entity.UserHqInfoEntity;
import com.sunline.modules.customer.enums.CustomerEnums;
import com.sunline.modules.customer.model.CustomerModel;
import com.sunline.modules.customer.model.CustomerSynModel;
import com.sunline.modules.customer.model.CustomerUserModel;
import com.sunline.modules.customer.service.ClientFareListService;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.customer.service.UserHqInfoService;
import com.sunline.modules.sys.service.UserService;
import com.sunline.security.SecurityKey;
import com.sunline.security.util.AESUtil;
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
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


/**
 * 客户管理
 *
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Controller
@RequestMapping("/secUserInfo")
public class SecUserInfoController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 日期格式化
     */
    private final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat DATE_FORMAT_YYYYMM = new SimpleDateFormat("yyyyMM");

    @Autowired
    private SecUserInfoService secUserInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    OpenAccountTaxationInfoService openAccountTaxationInfoService;
    @Autowired
    OpenAccountPropertyTypeService openAccountPropertyTypeService;
    @Autowired
    UserHqInfoService userHqInfoService;
    @Autowired
    ClientFareListService clientFareListService;
    @Autowired
    CustomerAccOpenImageService customerAccountOpenImageService;
    @Autowired
    OpenAccountOtherDisclosureService openAccountOtherDisclosureService;

    /**
     * 客户基本查询列表
     *
     * @param model
     * @param securitiesUserInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/customerList")
    @RequiresPermissions("securitiesUserInfo:list")
    public String list(Model model, SecuritiesUserInfoEntity securitiesUserInfoEntity, HttpServletRequest request) {
        //回传参数的entity
        if (getUserId().equals(Constant.SUPERR_USER)) {
            securitiesUserInfoEntity.setChannelIds(null);
        } else {
            securitiesUserInfoEntity.setChannelIds(getChannelIds());
        }

        if (securitiesUserInfoEntity.getCheckedChannelId() != null && !"".equals(securitiesUserInfoEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(securitiesUserInfoEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                securitiesUserInfoEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }

        String openAccountStartTime = securitiesUserInfoEntity.getOpenAccountStartTime();
        String openAccountEndTime = securitiesUserInfoEntity.getOpenAccountEndTime();
        if (null != openAccountStartTime && !"".equals(openAccountStartTime)) {
            securitiesUserInfoEntity.setOpenAccountStartTime(DATETIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.parse(openAccountStartTime))));
        }
        if (null != openAccountEndTime && !"".equals(openAccountEndTime)) {
            securitiesUserInfoEntity.setOpenAccountEndTime(DATETIME_FORMAT.format(DateUtil.endOfDay(DateUtil.parse(openAccountEndTime))));
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<SecuritiesUserInfoEntity> page = secUserInfoService.findPage(securitiesUserInfoEntity, pageNum);
        securitiesUserInfoEntity.setOpenAccountStartTime(openAccountStartTime);
        securitiesUserInfoEntity.setOpenAccountEndTime(openAccountEndTime);
        //是否为敏感信息组
        model.addAttribute("shield", UserUtils.isSensitiveUser());
        model.addAttribute("page", page);
        model.addAttribute("model", securitiesUserInfoEntity);
        return "customer/customerList";
    }

    /**
     * 潜在客户录入跳转页面
     *
     * @return
     */
    @RequestMapping("/potentialUserSave")
    @RequiresPermissions("securitiesUserInfo:potentialUserSave")
    public String potentialUserSave() {
        return "customer/potentialUserSave";
    }

    /**
     * 潜在客户录入执行方法
     *
     * @param request
     * @param securitiesUserInfoEntity
     * @return
     */
    @RequestMapping("/doPotentialUserSave")
    @ResponseBody
    public String doPotentialUserSave(HttpServletRequest request, SecuritiesUserInfoEntity securitiesUserInfoEntity) {
        securitiesUserInfoEntity.setClientType(CustomerEnums.ClientType.CLIENT_TYPE_POT.getIndex());
        int count = secUserInfoService.save(securitiesUserInfoEntity);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS", "1");
        }
        return CodeUtils.getCodeName("COMMON_STATUS", "-1");
    }


    /**
     * 修改客户信息
     * 传入gid
     */
    @RequestMapping("/updateCustomer")
    @ResponseBody
    public String updateCustomer(SecuritiesUserInfoEntity userInfo, HttpServletRequest request) {
        // 客户补录  客户状态默认为正常
        userInfo.setClientType(CustomerEnums.ClientType.CLIENT_TYPE_NOR.getIndex());
        userInfo.setInvestTarget("[" + userInfo.getInvestTarget() + "]");
        int count;
        if (userInfo.getId() == null || "".equals(userInfo.getId())) {
            count = secUserInfoService.save(userInfo);
        } else {
            count = secUserInfoService.update(userInfo);
        }

        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS", "1");
        }
        return CodeUtils.getCodeName("COMMON_STATUS", "-1");
    }

    /**
     * 客户补录
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/addCustomerInit")
    public String addCustomerInit(Model model, HttpServletRequest request) {
        model.addAttribute("tab", "insert");
        return "customer/cusSaveOrUpdate";
    }


    /**
     * 客户基本信息详情
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/customerInfo")
    public String customerInfo(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        SecuritiesUserInfoEntity entity = new SecuritiesUserInfoEntity();
        entity.setId(Integer.parseInt(id));
        //证券信息
        SecuritiesUserInfoEntity securitiesUserInfo = secUserInfoService.queryObject(entity);
        if (!"".equals(securitiesUserInfo.getApplicationId()) && null != securitiesUserInfo.getApplicationId()) {
            //税务信息
            List<OpenAccountTaxationInfoEntity> openAccountTaxationInfoEntity = openAccountTaxationInfoService.queryByApplicationId(securitiesUserInfo.getApplicationId());
            //财产类型表
            List<OpenAccountPropertyTypeEntity> openAccountPropertyTypeEntity = openAccountPropertyTypeService.queryByApplicationId(securitiesUserInfo.getApplicationId());

            if (securitiesUserInfo.getInvestTarget() != null) {
                String target = securitiesUserInfo.getInvestTarget().replace("[", "").replace("]", "");
                securitiesUserInfo.setInvestTarget(target);
            }
            if (securitiesUserInfo.getCapitalSource() != null) {
                String capitalSource = securitiesUserInfo.getCapitalSource().replace("[", "").replace("]", "");
                securitiesUserInfo.setCapitalSource(capitalSource);
            }
            //凭证图片
            CustomerAccountOpenImgEntity imageParams = new CustomerAccountOpenImgEntity();
            imageParams.setApplicationId(securitiesUserInfo.getApplicationId());
            imageParams.setImageLocation(6);
            List<CustomerAccountOpenImgEntity> proofImageList = customerAccountOpenImageService.queryListByBean(imageParams);
            for (CustomerAccountOpenImgEntity image : proofImageList) {
                image.setStoragePath(image.getStoragePath().replace("D:", ""));
                model.addAttribute("proofImage_" + image.getImageLocationType(), image);
            }

            //其他信息表
            List<OpenAccountOtherDisclosureEntity> openAccountOtherDisclosureEntity = openAccountOtherDisclosureService.queryByApplicationId(securitiesUserInfo.getApplicationId());

            //把name和详情拼接为 张三丰,深圳市宝安区;李四,深圳市
            for (OpenAccountOtherDisclosureEntity entity1 : openAccountOtherDisclosureEntity) {
                boolean ischeck = false;
                Integer code = entity1.getDisclosureCode();
                //1,2,3选择否,11,12,13,14,15选择是时需要添加详细信息
                if (entity1.getDisclosureIsTrue() == 0 && (code <= 20)) {
                    ischeck = true;
                }
                if (entity1.getDisclosureIsTrue() == 1 && (code > 20 && code <= 40)) {
                    ischeck = true;
                }
                if (ischeck) {
                    // 详细资料展示页面  拼接展示
                    StringBuffer nameJoinDetailStr = new StringBuffer();
                    String disclosure1[] = {};
                    String disclosure2[] = {};
                    String disclosure3[] = {};
                    String disclosure4[] = {};
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(entity1.getDisclosure1())) {
                        disclosure1 = entity1.getDisclosure1().split(",");
                    }
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(entity1.getDisclosure2())) {
                        disclosure2 = entity1.getDisclosure2().split(",");
                    }
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(entity1.getDisclosure3())) {
                        disclosure3 = entity1.getDisclosure3().split(",");
                    }
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(entity1.getDisclosure4())) {
                        disclosure4 = entity1.getDisclosure4().split(",");
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
                            if (org.apache.commons.lang3.StringUtils.isNotBlank(disclosure[col][j])) {
                                nameJoinDetailStr.append(disclosure[col][j]).append(",");
                            }
                            col++;
                        }
                        nameJoinDetailStr.deleteCharAt(nameJoinDetailStr.length() - 1);
                        nameJoinDetailStr.append(";");
                    }
                    entity1.setDisclosureNameJoinDetail(nameJoinDetailStr.toString());
                }
            }
            //税务表
            model.addAttribute("taxInformationList", openAccountTaxationInfoEntity);
            //财产信息
            model.addAttribute("openAccountPropertyList", openAccountPropertyTypeEntity);
            //其他信息表
            model.addAttribute("openAccountOtherDisclosureList", openAccountOtherDisclosureEntity);
        }
        //是否为敏感信息组
        model.addAttribute("shield", UserUtils.isSensitiveUser());
        //证券客户资料
        model.addAttribute("securitiesUserInfo", securitiesUserInfo);

        return "customer/customerInfo";
    }

    /**
     * 客户综合查询列表
     *
     * @param model
     * @param securitiesUserInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/synList")
//    @RequiresPermissions("securitiesUserInfo:list")
    public String synList(Model model, SecuritiesUserInfoEntity securitiesUserInfoEntity, HttpServletRequest request) {
        if (getUserId().equals(Constant.SUPERR_USER)) {
            securitiesUserInfoEntity.setChannelIds(null);
        } else {
            securitiesUserInfoEntity.setChannelIds(getChannelIds());
        }

        if (securitiesUserInfoEntity.getCheckedChannelId() != null && !"".equals(securitiesUserInfoEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(securitiesUserInfoEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                securitiesUserInfoEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }

        String openAccountStartTime = securitiesUserInfoEntity.getOpenAccountStartTime();
        String openAccountEndTime = securitiesUserInfoEntity.getOpenAccountEndTime();
        if (null != openAccountStartTime && !"".equals(openAccountStartTime)) {
            securitiesUserInfoEntity.setOpenAccountStartTime(DATETIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.parse(openAccountStartTime))));
        }
        if (null != openAccountEndTime && !"".equals(openAccountEndTime)) {
            securitiesUserInfoEntity.setOpenAccountEndTime(DATETIME_FORMAT.format(DateUtil.endOfDay(DateUtil.parse(openAccountEndTime))));
        }
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        // 生成表名
        StringBuffer tableName = new StringBuffer();
        tableName.append("client_asset_flow_info_").append(DATE_FORMAT_YYYYMM.format(DateUtil.yesterday()));
        securitiesUserInfoEntity.setTableName(tableName.toString());

        Page<SecuritiesUserInfoEntity> page = secUserInfoService.queryPage(securitiesUserInfoEntity, pageNum);
        securitiesUserInfoEntity.setOpenAccountStartTime(openAccountStartTime);
        securitiesUserInfoEntity.setOpenAccountEndTime(openAccountEndTime);

        //是否为敏感信息组
        model.addAttribute("shield", UserUtils.isSensitiveUser());
        model.addAttribute("page", page);
        model.addAttribute("model", securitiesUserInfoEntity);
        return "customer/customerSynList";
    }

    /**
     * 客户综合信息详情
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/customerSynInfo")
    public String customerSynInfo(Model model, HttpServletRequest request) {
        SecuritiesUserInfoEntity securitiesUserInfoEntity = new SecuritiesUserInfoEntity();
        securitiesUserInfoEntity.setId(Integer.parseInt(request.getParameter("id")));
        // 生成表名
        StringBuffer tableName = new StringBuffer();
        tableName.append("client_asset_flow_info_").append(DATE_FORMAT_YYYYMM.format(DateUtil.yesterday()));
        securitiesUserInfoEntity.setTableName(tableName.toString());
        //客户信息
        SecuritiesUserInfoEntity customerInfo = secUserInfoService.queryById(securitiesUserInfoEntity);

        if (customerInfo.getInvestTarget() != null) {
            String target = customerInfo.getInvestTarget().replace("[", "").replace("]", "");
            customerInfo.setInvestTarget(target);
        }
        if (customerInfo.getCapitalSource() != null) {
            String capitalSource = customerInfo.getCapitalSource().replace("[", "").replace("]", "");
            customerInfo.setCapitalSource(capitalSource);
        }

        if (customerInfo.getApplicationId() != null && !StringUtils.isEmpty(customerInfo.getApplicationId())) {
            //财产信息
            List<OpenAccountPropertyTypeEntity> propertyTypeList = openAccountPropertyTypeService.queryByApplicationId(customerInfo.getApplicationId());
            model.addAttribute("propertyTypeList", propertyTypeList);
        }

        if (null != customerInfo.getUserId()) {
            //行情信息
            UserHqInfoEntity userHqInfo = new UserHqInfoEntity();
            userHqInfo.setUserId(customerInfo.getUserId());
            //港股
            userHqInfo.setMarketType(1);
            List<UserHqInfoEntity> hkUserHqInfoList = userHqInfoService.getUserHqInfo(userHqInfo);
            if (hkUserHqInfoList != null && hkUserHqInfoList.size() > 0) {
                model.addAttribute("hkUserHqInfo", hkUserHqInfoList.get(0));
            }
            userHqInfo.setMarketType(2);
            List<UserHqInfoEntity> usaUserHqInfoList = userHqInfoService.getUserHqInfo(userHqInfo);
            if (usaUserHqInfoList != null && usaUserHqInfoList.size() > 0) {
                model.addAttribute("usaUserHqInfo", usaUserHqInfoList.get(0));
            }
        }

        if (customerInfo.getTradeAccount() != null && !"".equals(customerInfo.getTradeAccount())) {
            ClientFareListEntity clientFareList = new ClientFareListEntity();
            clientFareList.setClientId(Integer.parseInt(customerInfo.getTradeAccount()));
            List<ClientFareListEntity> fareList = clientFareListService.queryListByBean(clientFareList);
            StringBuffer fareCase = new StringBuffer();
            for (ClientFareListEntity entity : fareList) {
                if ("0".equals(entity.getFeeType())) {
                    fareCase.append(Double.parseDouble(entity.getFeeCount()) * 100).append("%,min").append(entity.getMinFare()).append("HKD;");
                } else if ("1".equals(entity.getFeeType())) {
                    fareCase.append(Double.parseDouble(entity.getFeeCountFix())).append("USD/笔,min").append(entity.getMinFare()).append("USD");
                } else if ("5".equals(entity.getFeeType())) {
                    fareCase.append(Double.parseDouble(entity.getFeeCountFix())).append("USD/股,min").append(entity.getMinFare()).append("USD");
                }
            }
            model.addAttribute("fareCase", fareCase);
        }

        //是否为敏感信息组
        model.addAttribute("shield", UserUtils.isSensitiveUser());
        model.addAttribute("customer", customerInfo);
        return "customer/customerSynInfo";
    }

    /**
     * 小神用户信息列表
     *
     * @param model
     * @param securitiesUserInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("securitiesUserInfo:userList")
    public String userList(Model model, SecuritiesUserInfoEntity securitiesUserInfoEntity, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        //手机号解码
        String phoneNumber = securitiesUserInfoEntity.getPhoneNumber();
        if (phoneNumber != null && !"".equalsIgnoreCase(phoneNumber)) {
            String phoneNumberNew = AESUtil.encrypt(securitiesUserInfoEntity.getPhoneNumber(), SecurityKey.MOBILE_PHONE_KEY);
            securitiesUserInfoEntity.setPhoneNumber(phoneNumberNew);
        }
        if (getUserId().equals(Constant.SUPERR_USER)) {
            securitiesUserInfoEntity.setChannelIds(null);
        } else {
            securitiesUserInfoEntity.setChannelIds(getChannelIds());
        }
        if (securitiesUserInfoEntity.getCheckedChannelId() != null && !"".equals(securitiesUserInfoEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(securitiesUserInfoEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                securitiesUserInfoEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }

        String registerStartTime = securitiesUserInfoEntity.getRegisterStartTime();
        String registerEndTime = securitiesUserInfoEntity.getRegisterEndTime();
        if (null != registerStartTime && !"".equals(registerStartTime)) {
            securitiesUserInfoEntity.setRegisterStartTime(DATETIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.parse(registerStartTime))));
        } else {
            securitiesUserInfoEntity.setRegisterStartTime(DATETIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.lastWeek())));
//            securitiesUserInfoEntity.setRegisterStartTime(DATE_FORMAT.format(DateUtil.lastMonth()));
        }
        if (null != registerEndTime && !"".equals(registerEndTime)) {
            securitiesUserInfoEntity.setRegisterEndTime(DATETIME_FORMAT.format(DateUtil.endOfDay(DateUtil.parse(registerEndTime))));
        } else {
            securitiesUserInfoEntity.setRegisterEndTime(DATETIME_FORMAT.format(DateUtil.endOfDay(DateUtil.parse(DateUtil.today()))));
//            securitiesUserInfoEntity.setRegisterEndTime(DateUtil.today());
        }

        long between = DateUtil.between(DateUtil.parseDate(securitiesUserInfoEntity.getRegisterStartTime()),
                DateUtil.parseDate(securitiesUserInfoEntity.getRegisterEndTime()), DateUnit.DAY);
        boolean checkDate = true;
        Page<SecuritiesUserInfoEntity> page = new Page<SecuritiesUserInfoEntity>(null,0,10,1);
        if(between>186){
            checkDate = false;
        }else {
            page = secUserInfoService.userPageList(securitiesUserInfoEntity, pageNum);
        }
        if (null != registerStartTime && !"".equals(registerStartTime)) {
            securitiesUserInfoEntity.setRegisterStartTime(registerStartTime);
        } else {
            securitiesUserInfoEntity.setRegisterStartTime(DATE_FORMAT.format(DateUtil.lastWeek()));
        }
        if (null != registerEndTime && !"".equals(registerEndTime)) {
            securitiesUserInfoEntity.setRegisterEndTime(registerEndTime);
        } else {
            securitiesUserInfoEntity.setRegisterEndTime(DateUtil.today());
        }
        securitiesUserInfoEntity.setPhoneNumber(phoneNumber);

        model.addAttribute("page", page);
        model.addAttribute("checkDate", checkDate);
        model.addAttribute("info", securitiesUserInfoEntity);
        return "customer/customerUserList";
    }

    /**
     * 客户分组管理
     *
     * @param model
     * @param securitiesUserInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/customerGroupManage")
    @RequiresPermissions("securitiesUserInfo:customerGroupManage")
    public String customerGroupManage(Model model, SecuritiesUserInfoEntity securitiesUserInfoEntity, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        //手机号解码
        if (securitiesUserInfoEntity.getPhoneNumber() != null && !"".equalsIgnoreCase(securitiesUserInfoEntity.getPhoneNumber())) {
            String phoneNumber = AESUtil.encrypt(securitiesUserInfoEntity.getPhoneNumber(), SecurityKey.MOBILE_PHONE_KEY);
            securitiesUserInfoEntity.setPhoneNumber(phoneNumber);
        }
        Page<SecuritiesUserInfoEntity> page = secUserInfoService.userPageList(securitiesUserInfoEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("model", securitiesUserInfoEntity);
        return "customer/customerUserList";
    }

    /**
     * 检查userId是否已存在
     *
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping("/checkUserId")
    @ResponseBody
    public String checkUserId(HttpServletRequest request, SecuritiesUserInfoEntity userInfo) {
        userInfo.setUserId(Integer.parseInt(request.getParameter("userId")));
        userInfo = secUserInfoService.queryByUserId(userInfo);
        if (userInfo != null) {
            return CodeUtils.getCodeName("COMMON_STATUS", "-2");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS", "1");
        }
    }

    /**
     * 检查 tradeAccount 是否已存在
     *
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping("/checkTradeAccount")
    @ResponseBody
    public String checkTradeAccount(HttpServletRequest request, SecuritiesUserInfoEntity userInfo) {
        userInfo.setTradeAccount(request.getParameter("tradeAccount"));
        int count = secUserInfoService.queryByTradeAcc(userInfo);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS", "-2");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS", "1");
        }
    }


    /**
     * 小神用户详情
     *
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping("/userListInfo")
    public String userListInfo(Model model, HttpServletRequest request, SecuritiesUserInfoEntity userInfo) {
        //点击修改按钮进来是 回传入一个getType的参数
        String getType = request.getParameter("getType");

        SecuritiesUserInfoEntity resultInfo = secUserInfoService.getUserInfo(userInfo.getUserId().toString());
        //手机号解密
        if (!(resultInfo.getPhoneNumber() == null || "".equalsIgnoreCase(resultInfo.getPhoneNumber()))) {
            resultInfo.setPhoneNumber(AESUtil.decrypt(resultInfo.getPhoneNumber(), SecurityKey.MOBILE_PHONE_KEY));
        }
        model.addAttribute("resultInfo", resultInfo);
        model.addAttribute("info", userInfo);
        if (getType != null || !"".equals(getType)) {
            model.addAttribute("getType", getType);
        }
        return "customer/userInfo";
    }

    /**
     * 修改小神客户信息
     * 传入userId
     */
    @RequestMapping("/updateUserInfo")
    @RequiresPermissions("securitiesUserInfo:updateUser")
    @ResponseBody
    public String updateUserInfo(SecuritiesUserInfoEntity userInfo, HttpServletRequest request) {
        if (userInfo.getCheckedChannelId() != null && !"".equals(userInfo.getCheckedChannelId())) {
            userInfo.setSourceChannelId(userInfo.getCheckedChannelId());
        }
        int count = secUserInfoService.updateUserInfo(userInfo);
        if (count > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS", "1");
        }
        return CodeUtils.getCodeName("COMMON_STATUS", "-1");
    }


    /**
     * 客户基本查询导出Excel
     *
     * @param userInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/customerExpExcel")
    @RequiresPermissions("securitiesUserInfo:exp")
    @SysLog("客户基本查询导出")
    public void customerExpExcel(SecuritiesUserInfoEntity userInfo, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                userInfo.setChannelIds(null);
            } else {
                userInfo.setChannelIds(getChannelIds());
            }
            //是否为敏感信息组
            boolean shield = UserUtils.isSensitiveUser();

            if (userInfo.getCheckedChannelId() != null && !"".equals(userInfo.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(userInfo.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    userInfo.setCheckedChannelIds(checkedChannelIds);
                }
            }

            String openAccountStartTime = userInfo.getOpenAccountStartTime();
            String openAccountEndTime = userInfo.getOpenAccountEndTime();
            if (null != openAccountStartTime && !"".equals(openAccountStartTime)) {
                userInfo.setOpenAccountStartTime(DATETIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.parse(openAccountStartTime))));
            }
            if (null != openAccountEndTime && !"".equals(openAccountEndTime)) {
                userInfo.setOpenAccountEndTime(DATETIME_FORMAT.format(DateUtil.endOfDay(DateUtil.parse(openAccountEndTime))));
            }

            List<SecuritiesUserInfoEntity> userList = secUserInfoService.customerListExcelList(userInfo);

            List<CustomerModel> modelList = Lists.newArrayList();

            for (int i = 0; i < userList.size(); i++) {
                CustomerModel model = new CustomerModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setApplicationId(userList.get(i).getApplicationId());
                model.setOpenAccountTime(userList.get(i).getOpenAccountTime() != null ? DATETIME_FORMAT.format(userList.get(i).getOpenAccountTime()) : "");
                if (userList.get(i).getOpenAccountType() != null) {
                    StringBuffer openAccountType = new StringBuffer();
                    if (userList.get(i).getOpenAccountType() == 0) {
                        openAccountType.append("未知");
                    } else if (userList.get(i).getOpenAccountType() == 2) {
                        openAccountType.append("线下开户");
                    } else if (userList.get(i).getOpenAccountType() == 3) {
                        openAccountType.append("BPM");
                    } else if (userList.get(i).getOpenAccountType() == 1 && (userInfo.getOpenAccountType() == null || userInfo.getOpenAccountType() == 1)) {
                        openAccountType.append("互联网开户");
                    } else if (userList.get(i).getOpenAccountType() == 1 && userList.get(i).getBankType() != null && userList.get(i).getBankType() == 0 && userInfo.getOpenAccountType() == 4) {
                        openAccountType.append("香港银行卡");
                    } else if (userList.get(i).getOpenAccountType() == 1 && userList.get(i).getBankType() != null && userList.get(i).getBankType() == 1 && userInfo.getOpenAccountType() == 5) {
                        openAccountType.append("大陆银行卡");
                    }
                    model.setOpenAccountType(openAccountType.toString());
                }
                model.setUserId(userList.get(i).getUserId() != null ? userList.get(i).getUserId().toString() : "");
                model.setTradeAccount(userList.get(i).getTradeAccount());
                model.setClientName(userList.get(i).getClientName());
                model.setClientNameSpell(userList.get(i).getClientNameSpell());
                model.setIdKind(userList.get(i).getIdKind() != null ? CodeUtils.getCodeName("AO_ID_KIND", userList.get(i).getIdKind().toString()) : "");
                if (shield == false) {
//                    model.setIdNo(userList.get(i).getIdNo());
                    model.setPhoneNumber(userList.get(i).getPhoneNumber());
                } else if (shield == true) {
//                    model.setIdNo("**************");
                    model.setPhoneNumber("******");
                }
                model.setSourceChannelId(userList.get(i).getSourceChannelId());
                model.setInviterId(userList.get(i).getInviterId());
                model.setInviterName(userList.get(i).getInviterName());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, CustomerModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 客户综合查询导出Excel
     *
     * @param userInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/cusSynExpExcel")
    @RequiresPermissions("securitiesUserInfo:synExp")
    @SysLog("客户综合查询导出")
    public void cusSynExpExcel(SecuritiesUserInfoEntity userInfo, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                userInfo.setChannelIds(null);
            } else {
                userInfo.setChannelIds(getChannelIds());
            }
            if (userInfo.getCheckedChannelId() != null && !"".equals(userInfo.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(userInfo.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    userInfo.setCheckedChannelIds(checkedChannelIds);
                }
            }

            String openAccountStartTime = userInfo.getOpenAccountStartTime();
            String openAccountEndTime = userInfo.getOpenAccountEndTime();

            if (null != openAccountStartTime && !"".equals(openAccountStartTime)) {
                userInfo.setOpenAccountStartTime(DATETIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.parse(openAccountStartTime))));
            }
            if (null != openAccountEndTime && !"".equals(openAccountEndTime)) {
                userInfo.setOpenAccountEndTime(DATETIME_FORMAT.format(DateUtil.endOfDay(DateUtil.parse(openAccountEndTime))));
            }

            //是否为敏感信息组
            boolean shield = UserUtils.isSensitiveUser();

            // 生成表名
            StringBuffer tableName = new StringBuffer();
            tableName.append("client_asset_flow_info_").append(DATE_FORMAT_YYYYMM.format(DateUtil.yesterday()));
            userInfo.setTableName(tableName.toString());

            List<SecuritiesUserInfoEntity> userList = secUserInfoService.cusSynListExcelList(userInfo);

            List<CustomerSynModel> customerSynModels = Lists.newArrayList();
            int i = 1;
            for (SecuritiesUserInfoEntity securitiesUserInfo : userList) {
                CustomerSynModel customerSyn = new CustomerSynModel();
                customerSyn.setId(i);
                customerSyn.setOpenAccountTime(securitiesUserInfo.getOpenAccountTime() != null ? DATETIME_FORMAT.format(securitiesUserInfo.getOpenAccountTime()) : "");
                customerSyn.setClientName(securitiesUserInfo.getClientName());
                customerSyn.setTradeAccount(securitiesUserInfo.getTradeAccount());
                customerSyn.setUserId(securitiesUserInfo.getUserId() != null ? securitiesUserInfo.getUserId().toString() : "");
                customerSyn.setPhoneNuber(securitiesUserInfo.getPhoneNumber());
                customerSyn.setRegSourceType(securitiesUserInfo.getRegSourceType());
                customerSyn.setRegSource(securitiesUserInfo.getRegSource());
                customerSyn.setSourceChannelId(securitiesUserInfo.getSourceChannelId());
                customerSyn.setAnnualIncome(CodeUtils.getCodeName("AO_INCOME", securitiesUserInfo.getAnnualIncome() != null ? securitiesUserInfo.getAnnualIncome().toString() : ""));
                customerSyn.setDepositInCount(securitiesUserInfo.getDepositInCount());
                customerSyn.setDepositOutCount(securitiesUserInfo.getDepositOutCount());
                customerSyn.setTotalAssets(securitiesUserInfo.getTotalAssets());
                customerSyn.setTradeCount(securitiesUserInfo.getTradeCount());
                customerSyn.setIpoCount(securitiesUserInfo.getIpoCount());
                i++;
                customerSynModels.add(customerSyn);
            }

            EasyExcelUtils.exportXlsxFile(customerSynModels, response, CustomerSynModel.class);
        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 小神用户查询导出Excel
     *
     * @param userInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/cusUserExpExcel")
    @RequiresPermissions("securitiesUserInfo:userExp")
    @SysLog("小神用户查询导出")
    public void cusUserExpExcel(SecuritiesUserInfoEntity userInfo, HttpServletRequest request, HttpServletResponse response) {
        try {
            //手机号解码
            if (userInfo.getPhoneNumber() != null && !"".equalsIgnoreCase(userInfo.getPhoneNumber())) {
                String phoneNumber = AESUtil.encrypt(userInfo.getPhoneNumber(), SecurityKey.MOBILE_PHONE_KEY);
                userInfo.setPhoneNumber(phoneNumber);
            }
            if (getUserId().equals(Constant.SUPERR_USER)) {
                userInfo.setChannelIds(null);
            } else {
                userInfo.setChannelIds(getChannelIds());
            }
            if (userInfo.getCheckedChannelId() != null && !"".equals(userInfo.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(userInfo.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    userInfo.setCheckedChannelIds(checkedChannelIds);
                }
            }
            String registerStartTime = userInfo.getRegisterStartTime();
            String registerEndTime = userInfo.getRegisterEndTime();
            if (null != registerStartTime && !"".equals(registerStartTime)) {
                userInfo.setRegisterStartTime(DATETIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.parse(registerStartTime))));
            }
            if (null != registerEndTime && !"".equals(registerEndTime)) {
                userInfo.setRegisterEndTime(DATETIME_FORMAT.format(DateUtil.endOfDay(DateUtil.parse(registerEndTime))));
            }

            List<SecuritiesUserInfoEntity> userList = secUserInfoService.cusUserListExcelList(userInfo);

            List<CustomerUserModel> modelList = Lists.newArrayList();

            for (int i = 0; i < userList.size(); i++) {
                CustomerUserModel model = new CustomerUserModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setRegisterTime(userList.get(i).getRegisterTime());
                model.setLastLoginTime(userList.get(i).getLastLoginTime());
                model.setUserId(userList.get(i).getUserId().toString());
                model.setPhoneNumber(userList.get(i).getPhoneNumber());
                model.setRegSourceType(userList.get(i).getRegSourceType());
                model.setRegSource(userList.get(i).getRegSource());
                model.setSourceChannelId(userList.get(i).getSourceChannelId());
                model.setUserStatus(userList.get(i).getUserStatus());

                modelList.add(model);
            }

            // 执行excel操作
            EasyExcelUtils.exportXlsxFile(modelList, response, CustomerUserModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

}
