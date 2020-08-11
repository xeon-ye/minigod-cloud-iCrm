package com.sunline.modules.api.service.impl;

import com.sunline.modules.api.dao.SecuritiesUserInfoDao;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: lcs
 * @date: 2018/5/15 16:46
 */
@Service
public class SecuritiesUserInfoServiceImpl implements SecuritiesUserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(SecuritiesUserInfoServiceImpl.class);

    @Autowired
    private SecuritiesUserInfoDao securitiesUserInfoDao;

    /**
     * 新增客户信息
     *
     * @param request
     * @return
     */
    @Override
    public ResponseVO addSecuritiesUserInfo(SecuritiesUserModel request) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ResponseVO vo = new ResponseVO();
        if (request.getIdKind() == null || "".equals(request.getIdKind())) {
            vo.setCode(BpmCommonEnum.CodeType.PARAMETER_DISMATCH.getCode());
            vo.setMessage("证件类型不可为空！");
            return vo;
        }

        if (request.getIdNo() == null || "".equals(request.getIdNo())) {
            vo.setCode(BpmCommonEnum.CodeType.PARAMETER_DISMATCH.getCode());
            vo.setMessage("证件号码不可为空！");
            return vo;
        }

        if (request.getClientId() == null || "".equals(request.getClientId())) {
            vo.setCode(BpmCommonEnum.CodeType.PARAMETER_DISMATCH.getCode());
            vo.setMessage("交易帐号不可为空！");
            return vo;
        }

        /*if (request.getFundAccount() == null || "".equals(request.getFundAccount())) {
            vo.setCode(BpmCommonEnum.CodeType.PARAMETER_DISMATCH.getCode());
            vo.setMessage("资金帐号不可为空！");
            return vo;
        }*/

        List<SecuritiesUserModel> queryUserIdResult = securitiesUserInfoDao.queryClient(request);

        if (queryUserIdResult.size() > 0) {
            vo.setCode(BpmCommonEnum.CodeType.EXIST_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.EXIST_ERROR.getMessage());
            return vo;
        }

        try {

            int count = securitiesUserInfoDao.save(request);
            if (count > 0) {
                vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
                vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            }

        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("新增用户出现异常", e);
        }
        return vo;

    }

    /**
     * 修改客户信息
     *
     * @param request
     * @return
     */
    @Override
    public ResponseVO modifySecuritiesUserInfo(SecuritiesUserModel request) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        ResponseVO vo = new ResponseVO();
        if (request.getIdKind() == null) {
            vo.setCode(BpmCommonEnum.CodeType.PARAMETER_DISMATCH.getCode());
            vo.setMessage("证件类型不可为空！");
            return vo;
        }
        if (request.getIdNo() == null || "".equals(request.getIdNo())) {
            vo.setCode(BpmCommonEnum.CodeType.PARAMETER_DISMATCH.getCode());
            vo.setMessage("证件号码不可为空！");
            return vo;
        }
        if (request.getTradeAccount() == null || "".equals(request.getTradeAccount())) {
            vo.setCode(BpmCommonEnum.CodeType.PARAMETER_DISMATCH.getCode());
            vo.setMessage("交易帐号不可为空！");
            return vo;
        }
        if (request.getFundAccount() == null || "".equals(request.getFundAccount())) {
            vo.setCode(BpmCommonEnum.CodeType.PARAMETER_DISMATCH.getCode());
            vo.setMessage("资金帐号不可为空！");
            return vo;
        }

        SecuritiesUserModel userInfo = new SecuritiesUserModel();
        userInfo.setUserId(request.getUserId());
        userInfo.setTradeAccount(request.getTradeAccount());
        userInfo.setFundAccount(request.getFundAccount());
        SecuritiesUserModel queryUserIdResult = securitiesUserInfoDao.queryClientInfo(userInfo);

        if (queryUserIdResult == null) {
            vo.setCode(BpmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
            vo.setMessage("该用户不存在！");
            return vo;
        }

        try {
            request.setId(queryUserIdResult.getId());
            int count = securitiesUserInfoDao.update(request);
            if (count > 0) {
                vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
                vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            }
        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("修改客户信息异常", e);
        }
        return vo;

    }

    /**
     * 查询证券用户信息
     *
     * @param request
     * @return
     */
    @Override
    public ResponseVO querySecuritiesUserInfo(SecuritiesUserModel request) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ResponseVO vo = new ResponseVO();
        try {

            SecuritiesUserModel securitiesUserInfo = securitiesUserInfoDao.queryObject(request);
            vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            vo.setResult(securitiesUserInfo);

        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("查询证券用户信息异常", e);
        }
        return vo;
    }

    /**
     * 查询证券用户列表
     *
     * @param request
     * @return
     */
    @Override
    public ResponseVO querySecuritiesUserInfoList(SecuritiesUserModel request) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ResponseVO vo = new ResponseVO();
        try {

            List<SecuritiesUserModel> securitiesUserInfoList = securitiesUserInfoDao.queryList(request);
            vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            vo.setResult(securitiesUserInfoList);

        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("查询证券用户列表异常", e);
        }
        return vo;
    }

    /**
     * 查询客户列表（匹配记录数）
     *
     * @param request
     * @return
     */
    @Override
    public ResponseVO querySecuritiesUserInfoLimitList(SecuritiesUserModel request) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ResponseVO vo = new ResponseVO();
        try {

            List<SecuritiesUserModel> securitiesUserInfoList = securitiesUserInfoDao.queryLimitList(request);
            vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            vo.setResult(securitiesUserInfoList);

        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("查询证券用户列表异常", e);
        }
        return vo;
    }

    /**
     * 通过证件类型和证件号码查询客户是否已开户
     *
     * @param request
     * @return
     */
    @Override
    public ResponseVO isExistedOpenAccByIdCard(SecuritiesUserModel request) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ResponseVO vo = new ResponseVO();
        try {

            List<SecuritiesUserModel> securitiesUserInfoList = securitiesUserInfoDao.isExistedOpenAccByIdCard(request);
            vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            vo.setResult(securitiesUserInfoList);

        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("通过证件类型和证件号码查询客户是否已开户异常", e);
        }
        return vo;
    }

    /**
     * 验证客户帐号是否是受限开户账户
     *
     * @param model
     * @return
     */
    @Override
    public List<SecuritiesUserModel> verifyIsRestrictOpenAccount(SecuritiesUserModel model) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return securitiesUserInfoDao.verifyIsRestrictOpenAccount(model);
    }

    @Override
    public ResponseVO updateByApplicationId(SecuritiesUserModel request) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ResponseVO vo = new ResponseVO();

        try {

            int count = securitiesUserInfoDao.updateByApplicationId(request);
            if (count > 0) {
                vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
                vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            }

        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("新增用户出现异常", e);
        }
        return vo;
    }
}
