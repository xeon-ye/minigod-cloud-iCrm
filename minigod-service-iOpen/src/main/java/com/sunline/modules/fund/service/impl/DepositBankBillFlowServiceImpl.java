package com.sunline.modules.fund.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.fund.dao.DepositBankBillFlowDao;
import com.sunline.modules.fund.entity.DepositBankBillFlowEntity;
import com.sunline.modules.fund.service.DepositBankBillFlowService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 入金银行流水记录表
 *
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-05 13:24:54
 */

@Service("depositBankBillFlowService")
public class DepositBankBillFlowServiceImpl implements DepositBankBillFlowService {
    private static final Logger logger = LoggerFactory.getLogger(DepositBankBillFlowServiceImpl.class);
    @Autowired
    private DepositBankBillFlowDao depositBankBillFlowDao;

    @Override
    public DepositBankBillFlowEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return depositBankBillFlowDao.queryObject(id);
    }

    @Override
    public List<DepositBankBillFlowEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return depositBankBillFlowDao.queryList(map);
    }

    @Override
    public Page<DepositBankBillFlowEntity> queryPage(DepositBankBillFlowEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        depositBankBillFlowDao.queryList(entity);
        return PageHelper.endPage();
    }

    @Override
    public List<DepositBankBillFlowEntity> queryListByBean(DepositBankBillFlowEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return depositBankBillFlowDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return depositBankBillFlowDao.queryTotal(map);
    }

    @Override
    public int save(DepositBankBillFlowEntity depositBankBillFlow) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        depositBankBillFlow.setId(Utils.uuid());
        return depositBankBillFlowDao.save(depositBankBillFlow);
    }

    @Override
    public int saveOrUpdate(DepositBankBillFlowEntity depositBankBillFlow) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        DepositBankBillFlowEntity query = new DepositBankBillFlowEntity();
        query.setReferenceNo(depositBankBillFlow.getReferenceNo());
        query.setValueDate(depositBankBillFlow.getValueDate());
        query.setAccNo(depositBankBillFlow.getAccNo());
        query.setSubAccno(depositBankBillFlow.getSubAccno());
        query.setCurrency(depositBankBillFlow.getCurrency());
        query.setCreditAmount(depositBankBillFlow.getCreditAmount());
        List<DepositBankBillFlowEntity> entitys = depositBankBillFlowDao.queryRepeatBankBill(query);
        int i = -1;
        try {
            if (CollectionUtil.isNotEmpty(entitys)) {
                //重复流水忽略
                i=-2;
                logger.info("银行流水{}，{}被过滤",depositBankBillFlow.getReferenceNo(), DateUtil.format(depositBankBillFlow.getValueDate(),"yyyy-MM-dd"));
            } else {
                DepositBankBillFlowEntity entity = new DepositBankBillFlowEntity();
                BeanUtils.copyProperties(depositBankBillFlow, entity);
                entity.setFlowSource(0);
                entity.setCheckStatus(0);
                entity.setCreateTime(new Date());
                entity.setCreateUser(UserUtils.getCurrentUserId());
                entity.setUpdateTime(new Date());
                entity.setUpdateUser(UserUtils.getCurrentUserId());
                i = depositBankBillFlowDao.save(entity);
            }
            if (i > 0) {
                //更新重复记录
                List<DepositBankBillFlowEntity> bankBillFlowEntities = depositBankBillFlowDao.queryRepeatBankBill(query);
                if (CollectionUtil.isNotEmpty(bankBillFlowEntities) && bankBillFlowEntities.size() > 1) {
                    bankBillFlowEntities.forEach(bill -> depositBankBillFlowDao.updateRepeat(bill.getId(), 1));
                }
            }
        } catch (Exception e) {
            logger.info("银行流水{}，{}导入异常",depositBankBillFlow.getReferenceNo(), DateUtil.format(depositBankBillFlow.getValueDate(),"yyyy-MM-dd"));
            e.printStackTrace();
            return -1;
        }

        return i;
    }

    @Override
    public int update(DepositBankBillFlowEntity depositBankBillFlow) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return depositBankBillFlowDao.update(depositBankBillFlow);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return depositBankBillFlowDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return depositBankBillFlowDao.deleteBatch(ids);
    }

    @Override
    public List<DepositBankBillFlowEntity> queryListByIds(String ids) {
        return depositBankBillFlowDao.queryListByIds(ids);
    }

    @Override
    public boolean backBankFlow(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        DepositBankBillFlowEntity entity = new DepositBankBillFlowEntity();
        entity.setApplicationId(applicationId);
        try {
            List<DepositBankBillFlowEntity> bankBillFlowEntities = depositBankBillFlowDao.queryListByBean(entity);
            if (CollectionUtil.isNotEmpty(bankBillFlowEntities)) {
                entity = bankBillFlowEntities.get(0);
                entity.setApplicationId(null);
                entity.setCheckStatus(0);
                entity.setUpdateTime(new Date());
                entity.setUpdateUser(UserUtils.getCurrentUserId());
                depositBankBillFlowDao.update(entity);
                //释放银行流水领取用户
                entity.setAssignDrafter(null);
                depositBankBillFlowDao.updateAssignDrafter(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Map<String, Integer> saveOrUpdate(List<DepositBankBillFlowEntity> entityList) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        Map<String, Integer> isuss = new HashMap<String, Integer>();
        int fail = 0;
        int suss = 0;
        int repeat = 0;
        try {
            if (CollectionUtil.isNotEmpty(entityList)) {
                int i = -1;
                for (DepositBankBillFlowEntity flowEntity : entityList) {
                    i = saveOrUpdate(flowEntity);
                    if (i > 0) {
                        suss++;
                    } else if(i==-2) {
                        repeat++;
                    }else{
                        fail++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail++;
        }
        isuss.put("suss", suss);
        isuss.put("fail", fail);
        isuss.put("repeat", repeat);
        return isuss;
    }

    @Override
    public int updateRepeat(long id, int repeat) {
        return depositBankBillFlowDao.updateRepeat(id, repeat);
    }

    @Override
    public int updateAssignDrafter(DepositBankBillFlowEntity entity) {
        return depositBankBillFlowDao.updateAssignDrafter(entity);
    }

    @Override
    public int updateAREData(DepositBankBillFlowEntity entity) {
        return depositBankBillFlowDao.updateAREData(entity);
    }
}
