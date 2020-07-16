package com.sunline.modules.account.online.service;



import java.util.List;
import java.util.Map;

import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.entity.OpenAccountBlacklistEntity;
import com.sunline.modules.account.online.protocol.AccountOpenApplyCallBackProtocol;

/**
 * 黑名单信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-10-11 12:19:54
 */
public interface OpenAccountBlacklistService {
	
	OpenAccountBlacklistEntity queryObject(Long id);
	
	List<OpenAccountBlacklistEntity> queryList(Map<String, Object> map);

    List<OpenAccountBlacklistEntity> queryListByBean(OpenAccountBlacklistEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(OpenAccountBlacklistEntity openAccountBlacklist);
	
	int update(OpenAccountBlacklistEntity openAccountBlacklist);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);

    OpenAccountBlacklistEntity isExistedBlacklist(OpenAccountBlacklistEntity entity);
    /*
     * 通过账户表保存黑名单
     */
    int saveByCustomerAccountOpenInfo(OpenAccountBlacklistEntity openAccountBlacklist,CustomerAccountOpenInfoEntity customerAccountOpenInfo);

}
