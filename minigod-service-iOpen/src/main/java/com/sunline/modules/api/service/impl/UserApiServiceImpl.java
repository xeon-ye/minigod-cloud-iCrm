package com.sunline.modules.api.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.api.dao.UserApiDao;
import com.sunline.modules.api.entity.CrmExternalCommonModel;
import com.sunline.modules.api.service.UserApiService;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


/**
 * 查询客户状态
 * @author: lcs
 * @date: 2018/8/12 16:46
 */
@Service
public class UserApiServiceImpl implements UserApiService {

    private static final Logger logger = LoggerFactory.getLogger(UserApiServiceImpl.class);

    @Autowired
    private UserApiDao userApiDao;

    @Override
    public ResponseVO queryUserStatus(CrmExternalCommonModel model) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ResponseVO vo = new ResponseVO();
        try {
            vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
            if (model.getBatchTradeAccountList() != null && model.getBatchTradeAccountList().size() > 0) {
                List<CrmExternalCommonModel> userList = userApiDao.queryUserStatus(model);
                HashMap<String, Object> resultMap ;
                List<Object> resultList = Lists.newArrayList();
                List<String> hasResultParams = Lists.newArrayList();
                for (CrmExternalCommonModel user : userList) {
                    hasResultParams.add(user.getTradeAccount());
                    resultMap = Maps.newHashMap();
                    resultMap.put("tradeAccount", user.getTradeAccount());
                    resultMap.put("userRegStatus", user.getUserRegStatus());
                    resultMap.put("openAccountStatus", user.getOpenAccountStatus());
                    resultMap.put("depositStatus", user.getDepositStatus());
                    resultMap.put("withdrawalStatus", user.getWithdrawalStatus());
                    resultMap.put("transferStatus", user.getTransferStatus());
                    resultMap.put("tradeStatus", user.getTradeStatus());
                    resultList.add(resultMap);
                }

                //参数列表 除去有结果的参数 剩下的全置0
                List<String> allParams = model.getBatchTradeAccountList();
                allParams.removeAll(hasResultParams);
                for (String tradeAccount : allParams) {
                    resultMap = Maps.newHashMap();
                    resultMap.put("tradeAccount", tradeAccount);
                    resultMap.put("userRegStatus", "0");
                    resultMap.put("openAccountStatus", "0");
                    resultMap.put("depositStatus", "0");
                    resultMap.put("withdrawalStatus", "0");
                    resultMap.put("transferStatus", "0");
                    resultMap.put("tradeStatus", "0");
                    resultList.add(resultMap);
                }


                if (resultList != null && resultList.size() > 0) {
                    vo.setResult(resultList);
                    vo.setCode(CrmCommonEnum.CodeType.OK.getCode());
                    vo.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
                } else {
                    vo.setCode(CrmCommonEnum.CodeType.NONE_DATA.getCode());
                    vo.setMessage(CrmCommonEnum.CodeType.NONE_DATA.getMessage());
                }
            }
        } catch (Exception e) {
            logger.error("[crm_api]查询用户状态出现异常", e);
        }
        return vo;
    }

    @Override
    public List<CrmExternalCommonModel> getFirstTrsTotal(CrmExternalCommonModel model) {
        return userApiDao.getFirstTrsTotal(model);
    }
}
