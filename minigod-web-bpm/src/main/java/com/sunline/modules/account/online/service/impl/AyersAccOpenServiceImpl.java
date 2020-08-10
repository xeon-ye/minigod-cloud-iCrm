package com.sunline.modules.account.online.service.impl;

import com.sunline.modules.account.online.dao.AyersClientAccDao;
import com.sunline.modules.account.online.dao.AyersClientInfoDao;
import com.sunline.modules.account.online.entity.AyersClientAccEntity;
import com.sunline.modules.account.online.entity.AyersClientInfoEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.service.AyersAccOpenService;
import com.sunline.modules.account.online.utils.DateTimeUtils;
import com.sunline.modules.common.utils.DateUtils;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service("ayersAccOpenService")
public class AyersAccOpenServiceImpl implements AyersAccOpenService {

    @Autowired
    private AyersClientAccDao clientAccDao;

    @Autowired
    private AyersClientInfoDao clientInfoDao;

    @Override
    public int saveClientInfo(AyersClientInfoEntity infoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
        return clientInfoDao.save(infoEntity);
    }

    @Override
    public int saveClineAcc(AyersClientAccEntity accEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
        return clientAccDao.save(accEntity);
    }

    @Override
    public AyersClientInfoEntity createClientInfoEntity(CustomerAccountOpenInfoEntity accInfoEntity) {
        AyersClientInfoEntity clientInfoEntity = new AyersClientInfoEntity();
        //必须字段
        if (accInfoEntity.getFundAccountType() != null){
            if (accInfoEntity.getFundAccountType() == 1){
                clientInfoEntity.setClientId("C"+accInfoEntity.getClientId());
            }else if (accInfoEntity.getFundAccountType() == 2){
                clientInfoEntity.setClientId("M"+accInfoEntity.getClientId());
            }
        }
        clientInfoEntity.setCreateUser("bx");
        clientInfoEntity.setCreateTime(new Date());

        //其它字段
        clientInfoEntity.setName(accInfoEntity.getGivenNameSpell());
        //clientInfoEntity.setBig5Names(accInfoEntity.getClientName());
        clientInfoEntity.setGbNames(accInfoEntity.getClientName());
        clientInfoEntity.setEngNames(accInfoEntity.getGivenNameSpell());
        //证件类型[0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]
        if (accInfoEntity.getIdKind() == 1){
            clientInfoEntity.setIdType("IDCN");
        }else if (accInfoEntity.getIdKind() == 2){
            clientInfoEntity.setIdType("IDHK");
        }else if (accInfoEntity.getIdKind() == 3){
            clientInfoEntity.setIdType("PPCN");
        }
        clientInfoEntity.setIdCode(accInfoEntity.getIdNo());
        clientInfoEntity.setAeCode("C0201W");
        clientInfoEntity.setEmail(accInfoEntity.getEmail());
        clientInfoEntity.setPhone(accInfoEntity.getPhoneNumber());
        clientInfoEntity.setOtherPhone(accInfoEntity.getFamilyPhone());
        clientInfoEntity.setAddr_1(accInfoEntity.getIdCardAddress());
        clientInfoEntity.setAddr_2(accInfoEntity.getCompanyAddress());
        clientInfoEntity.setAddr_3(accInfoEntity.getContactAddress());
        clientInfoEntity.setAddr_4(accInfoEntity.getFamilyAddress());
        //性别[0=男 1=女 2=其它]
        if (accInfoEntity.getSex() == 0){
            clientInfoEntity.setGender("Mr");
        }else if (accInfoEntity.getSex() == 1){
            clientInfoEntity.setGender("Miss");
        }else {
            clientInfoEntity.setGender("N/A");
        }
        clientInfoEntity.setDateOfBirth(DateTimeUtils.stringToDate(accInfoEntity.getBirthday(),"yyyy-MM-dd"));
        //clientInfoEntity.setClientGroupCode("001");
        //clientInfoEntity.setClientType("LR");
        //语言[0=未知 1=英文 2=繁体中文 3=简体中文]
        if (accInfoEntity.getLan() == 1){
            clientInfoEntity.setStatementLang("eng");
        }else if (accInfoEntity.getLan() == 2){
            clientInfoEntity.setStatementLang("big5");
        }else if (accInfoEntity.getLan() == 3){
            clientInfoEntity.setStatementLang("gb");
        }
        //clientInfoEntity.setNationality("");
        clientInfoEntity.setStmtEmail("N");
        clientInfoEntity.setStmtEmailMonthly("N");
        clientInfoEntity.setStmtMail("N");
        clientInfoEntity.setStmtMailMonthly("N");
        //clientInfoEntity.setFax("");
        //clientInfoEntity.setContactPerson("");
        clientInfoEntity.setEmploymentName(accInfoEntity.getCompanyName());
        clientInfoEntity.setPayeeBankAcc(accInfoEntity.getBankNo());
        clientInfoEntity.setPayeeBankCode(accInfoEntity.getBankId());
        clientInfoEntity.setOccupation(accInfoEntity.getIndustryRange());
        //clientInfoEntity.setStmtFax("")
        return clientInfoEntity;
    }

    @Override
    public AyersClientAccEntity createClientAccEntity(CustomerAccountOpenInfoEntity accInfoEntity) {
        AyersClientAccEntity clientAccEntity = new AyersClientAccEntity();
        //必须字段
        if (accInfoEntity.getFundAccountType() != null){
            String clientAcc = null;
            if (accInfoEntity.getFundAccountType() == 1){
                clientAcc = "C"+accInfoEntity.getClientId();
                clientAccEntity.setAccType("C");
            }else if (accInfoEntity.getFundAccountType() == 2){
                clientAcc = "M"+accInfoEntity.getClientId();
                clientAccEntity.setAccType("M");
            }
            clientAccEntity.setClientId(clientAcc);
            clientAccEntity.setClientAccId(clientAcc);
        }
        clientAccEntity.setCreateUser("bx");
        clientAccEntity.setCreateTime(new Date());

        //其它字段
        //clientAccEntity.setAccCode("A12345M");
        clientAccEntity.setAeCode("C0201W");
        clientAccEntity.setOpenDate(new Date());
        //clientAccEntity.setCloseDate(new Date());
        clientAccEntity.setStatus("A");
        //期货适用
        //clientAccEntity.setClearingAccType("");
        clientAccEntity.setLoanLimit(new BigDecimal(5000000.00));
        //不填
        //clientAccEntity.setLoanExpiryDate(new Date());
        clientAccEntity.setTradingLimit(new BigDecimal(0.00));
        //待确认
        if (accInfoEntity.getFundAccountType() == 2){
            //clientAccEntity.setBillPayNo("");
        }
        clientAccEntity.setInternetTrading("Y");
        clientAccEntity.setIvrsTrading("Y");
        clientAccEntity.setMangoTrading("Y");
        clientAccEntity.setMobileTrading("Y");
        return clientAccEntity;
    }
}

