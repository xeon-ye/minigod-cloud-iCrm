package com.sunline.modules.market.service.impl;

import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.OrderUtil;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.market.dao.ClientMarketPackageInfoDao;
import com.sunline.modules.market.entity.ClientMarketPackageInfoEntity;
import com.sunline.modules.market.service.ClientMarketPackageInfoService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 行情套餐购买信息表
 *
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-05-13 11:07:10
 */

@Service("clientMarketPackageInfoService")
public class ClientMarketPackageInfoServiceImpl implements ClientMarketPackageInfoService {
    private static final Logger logger = LoggerFactory.getLogger(ClientMarketPackageInfoServiceImpl.class);

	@Autowired
	private ClientMarketPackageInfoDao clientMarketPackageInfoDao;
    @Autowired
    private MessageSendInfoService messageSendInfoService;

	@Override
	public ClientMarketPackageInfoEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientMarketPackageInfoDao.queryObject(id);
	}
	
	@Override
	public List<ClientMarketPackageInfoEntity> queryList(ClientMarketPackageInfoEntity entity){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientMarketPackageInfoDao.queryList(entity);
	}

    @Override
    public List<ClientMarketPackageInfoEntity> queryListByBean(ClientMarketPackageInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientMarketPackageInfoDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return clientMarketPackageInfoDao.queryTotal(map);
	}
	
	@Override
	public int save(ClientMarketPackageInfoEntity clientMarketPackageInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        clientMarketPackageInfo.setApplicationId(Utils.uuid());
		return clientMarketPackageInfoDao.save(clientMarketPackageInfo);
	}
	
	@Override
	public int update(ClientMarketPackageInfoEntity clientMarketPackageInfo){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientMarketPackageInfoDao.update(clientMarketPackageInfo);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientMarketPackageInfoDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientMarketPackageInfoDao.deleteBatch(ids);
	}

    @Override
    public ClientMarketPackageInfoEntity commitMarketPackage(ClientMarketPackageInfoEntity clientMarketPackageInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
           // 检验预约流水号的唯一性
           String applicationId = OrderUtil.getOrderNoByAtomic(5);
           ClientMarketPackageInfoEntity isExistedInfo = clientMarketPackageInfoDao.queryByApplicationId(applicationId);
           while (null != isExistedInfo) {
                 applicationId = OrderUtil.getOrderNoByAtomic(5);
                 isExistedInfo = clientMarketPackageInfoDao.queryByApplicationId(applicationId);
           }
            clientMarketPackageInfo.setApplicationId(applicationId);
            clientMarketPackageInfo.setCreateTime(new Date());
            clientMarketPackageInfo.setUpdateTime(new Date());

            int count = clientMarketPackageInfoDao.save(clientMarketPackageInfo);
            if (count > 0) {
                return clientMarketPackageInfoDao.queryByApplicationId(applicationId);
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return null;
            }
    }

    @Override
    public void generateSendEmail(String applicationId, String message) {
        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(SysConfigUtil.getSysConfigValue("SYSTEM_NOTICE_EMAIL_GROUP", "it@zszhizhu.com;laijieqiang@zszhizhu.com"));
        messageSendInfoEntity.setMessageTitle("【系统异常】行情套餐购买业务");
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent("预约流水号：" + applicationId + " 扣款失败，失败原因：" + message);
        messageSendInfoEntity.setContentType(0);

        messageSendInfoService.save(messageSendInfoEntity);
    }

    @Override
    public Page<ClientMarketPackageInfoEntity> findPage(ClientMarketPackageInfoEntity clientMarketPackageInfo, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientMarketPackageInfoDao.queryList(clientMarketPackageInfo);
        return PageHelper.endPage();
    }
}
