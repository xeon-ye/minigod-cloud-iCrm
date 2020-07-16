package com.sunline.modules.call.service.impl;

import com.sunline.modules.analysis.entity.ClientTradeFlowInfoEntity;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.TimeUtils;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.call.dao.CallRecordDao;
import com.sunline.modules.call.entity.CallRecordEntity;
import com.sunline.modules.call.service.CallRecordService;

/**
 * 通话记录表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-05 10:29:23
 */

@Service("callRecordService")
public class CallRecordServiceImpl implements CallRecordService {
	@Autowired
	private CallRecordDao callRecordDao;
	
	@Override
	public CallRecordEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return callRecordDao.queryObject(id);
	}
	
	@Override
	public List<CallRecordEntity> queryList(CallRecordEntity entity){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return callRecordDao.queryList(entity);
	}

    @Override
    public List<CallRecordEntity> queryListByBean(CallRecordEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return callRecordDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return callRecordDao.queryTotal(map);
	}
	
	@Override
	public int save(CallRecordEntity callRecord){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        callRecord.setId(Utils.uuid());
		return callRecordDao.save(callRecord);
	}
	
	@Override
	public int update(CallRecordEntity callRecord){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return callRecordDao.update(callRecord);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return callRecordDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return callRecordDao.deleteBatch(ids);
	}

    /**
     * 分頁查询通话记录
     * @param entity
     * @param pageNum
     * @return
     */
    @Override
    public Page<CallRecordEntity> findPage(CallRecordEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        List<CallRecordEntity> callRecordList = callRecordDao.queryList(entity);
        for(CallRecordEntity call : callRecordList){
            call.setCallTimeLength(TimeUtils.secondFormat(Integer.parseInt(call.getCallTimeLength())));
        }
        return PageHelper.endPage();
    }

    /**
     * 取消关联 (根据ID将相关字段置空)
     * @param entity
     * @return
     */
    @Override
    public int cancelConnect(CallRecordEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return callRecordDao.cancelConnect(entity);
    }
}
