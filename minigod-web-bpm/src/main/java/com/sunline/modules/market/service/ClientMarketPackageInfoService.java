package com.sunline.modules.market.service;


import com.sunline.modules.common.page.Page;
import com.sunline.modules.market.entity.ClientMarketPackageInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 行情套餐购买信息
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-05-13 11:07:10
 */
public interface ClientMarketPackageInfoService {

    ClientMarketPackageInfoEntity queryObject(Long id);
	
	List<ClientMarketPackageInfoEntity> queryList(ClientMarketPackageInfoEntity entity);

    List<ClientMarketPackageInfoEntity> queryListByBean(ClientMarketPackageInfoEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientMarketPackageInfoEntity clientMarketPackageInfo);
	
	int update(ClientMarketPackageInfoEntity clientMarketPackageInfo);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);

    /**
     * 行情购买
     * @param clientMarketPackageInfo
     * @return
     */
    ClientMarketPackageInfoEntity commitMarketPackage(ClientMarketPackageInfoEntity clientMarketPackageInfo);

    /**
     * 发送邮件
     * @param applicationId
     * @param message
     * @return
     */
    void generateSendEmail(String applicationId, String message);

    /**
     * 分页查询出金记录
     *
     * @param clientMarketPackageInfo
     * @param pageNum
     * @return
     */
    public Page<ClientMarketPackageInfoEntity> findPage(ClientMarketPackageInfoEntity clientMarketPackageInfo, int pageNum);
}
