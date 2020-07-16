package com.sunline.modules.account.online.manager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.account.online.converter.CustomerOpenAccountConverter;
import com.sunline.modules.account.online.dao.CustomerAccountOpenApplyDao;
import com.sunline.modules.account.online.entity.CustomerAccountOpenImgEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.model.ChannelInfo;
import com.sunline.modules.account.online.service.CustomerAccOpenApplyService;
import com.sunline.modules.account.online.service.CustomerAccOpenImageService;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.modules.sys.entity.CodeEntity;
import com.sunline.modules.sys.service.CodeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LiYangFeng
 * @createDate 2018/4/27
 * @description
 * @email justbelyf@gmail.com
 */
@Service("customerAccountOpenManager")
public class CustomerAccountOpenManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerAccountOpenManager.class);

    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    CustomerAccOpenImageService customerAccountOpenImageService;
    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;
    @Autowired
    CustomerAccountOpenApplyDao customerAccountOpenApplicationDao;
    @Autowired
    MessageSendInfoService messageSendInfoService;
    @Autowired
    CustomerAccOpenReportGenerate customerAccountOpenReportGenerate;
    @Autowired
    CustomerAccOpenApplyService customerAccountOpenApplicationService;
    @Autowired
    CodeService codeService;

    /**
     * 获取用户签名照
     *
     * @param customerAccountOpenInfoId
     * @return
     */
    public String getAccountOpenCustomerSignImage(String customerAccountOpenInfoId) {

        CustomerAccountOpenImgEntity accountOpenImageEntity = new CustomerAccountOpenImgEntity();
        accountOpenImageEntity.setApplicationId(customerAccountOpenInfoId);
        accountOpenImageEntity.setImageLocationType(301);
        List<CustomerAccountOpenImgEntity> customerAccountOpenImageEntityList = customerAccountOpenImageService.queryListByBean(accountOpenImageEntity);
        if (null != accountOpenImageEntity && customerAccountOpenImageEntityList.size() == 1) {
            return customerAccountOpenImageEntityList.get(0).getStoragePath() +
                    customerAccountOpenImageEntityList.get(0).getFileStorageName() + "." +
                    customerAccountOpenImageEntityList.get(0).getExtName();
        }

        return null;
    }


    /**
     * 是否已存在的证件号
     *
     * @param idCard
     * @return
     */
    public boolean isExistedIdCard(Integer idKind, String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return false;
        }
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = new CustomerAccountOpenInfoEntity();
        customerAccountOpenInfoEntity.setIdKind(idKind);
        customerAccountOpenInfoEntity.setIdNo(idCard);

        return accountOpenQualificationValidate(customerAccountOpenInfoEntity);
    }


    /**
     * 是否已存在的邮箱
     *
     * @param email
     * @return
     */
    public boolean isExistedEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return false;
        }
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = new CustomerAccountOpenInfoEntity();
        customerAccountOpenInfoEntity.setEmail(email);

        return accountOpenQualificationValidate(customerAccountOpenInfoEntity);
    }

    /**
     * 是否已存在的手机号码
     *
     * @param phoneNumber
     * @return
     */
    public boolean isExistedPhoneNumber(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber)) {
            return false;
        }
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = new CustomerAccountOpenInfoEntity();
        customerAccountOpenInfoEntity.setPhoneNumber(phoneNumber);

        return accountOpenQualificationValidate(customerAccountOpenInfoEntity);
    }


    /**
     * 用户开户申请资格校验
     *
     * @return
     */
    public boolean accountOpenQualificationValidate(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity) {
        SecuritiesUserModel securitiesUserModel = CustomerOpenAccountConverter.converterToSecuritiesUserInfo(customerAccountOpenInfoEntity);
        ResponseVO responseVO = securitiesUserInfoService.isExistedOpenAccByIdCard(securitiesUserModel);
        List<SecuritiesUserInfoEntity> clientInfoList = (List<SecuritiesUserInfoEntity>) responseVO.getResult();
        if (clientInfoList.size() > 0) {
            return true;
        }

        List<CustomerAccountOpenInfoEntity> existedAccountOpenInfo = customerAccountOpenInfoService.isExistedOpenAccByIdCard(customerAccountOpenInfoEntity);

        return existedAccountOpenInfo.size() > 0;
    }


    /**
     * 获取去重的渠道信息
     *
     * @param accountOpenApplicationDetailInfo
     * @return
     */
    public List<ChannelInfo> getDistinctChannel(List<AccountOpenApplyDetailInfo> accountOpenApplicationDetailInfo) {
        Map<String, String> channelMap = Maps.newHashMap();
        for (AccountOpenApplyDetailInfo openApplicationDetailInfo : accountOpenApplicationDetailInfo) {
            if (!channelMap.containsKey(openApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getSourceChannelId())) {
                channelMap.put(openApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getSourceChannelId(), openApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getSourceChannelName());
            }
        }

        List<ChannelInfo> channelsInfo = Lists.newArrayList();
        for (String channelId : channelMap.keySet()) {
            ChannelInfo channelInfo = new ChannelInfo();
            channelInfo.setChannelId(channelId);
            channelInfo.setChannelName(channelMap.get(channelId));

            channelsInfo.add(channelInfo);
        }

        return channelsInfo;
    }

    /**
     * 获取去重的渠道信息
     *
     * @return
     */
    public List<ChannelInfo> getDistinctChannel() {
        List<CustomerAccountOpenInfoEntity> customerAccountOpenInfoEntities = customerAccountOpenInfoService.selectDistinctChannel();

        List<ChannelInfo> channelsInfo = Lists.newArrayList();
        for (CustomerAccountOpenInfoEntity accountOpenInfoEntity : customerAccountOpenInfoEntities) {
            ChannelInfo channelInfo = new ChannelInfo();
            channelInfo.setChannelId(accountOpenInfoEntity.getSourceChannelId());
            channelInfo.setChannelName(accountOpenInfoEntity.getSourceChannelName());

            channelsInfo.add(channelInfo);
        }

        return channelsInfo;
    }

    /**
     * 是否集体户地址验证
     *
     * @return
     */
    public boolean collectivelyAccountValidate(String address) {
        List<CodeEntity> codeEntities = codeService.queryChildsByMark("AO_COLLECT_ACCOUNT_ADDRESS","1");
        for(CodeEntity code:codeEntities){
            if(address.equals(code.getName())){
                return true;
            }
        }
        return false;
    }

}
