package com.sunline.modules.fund.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.fund.entity.DepositBankBillFlowEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 入金银行流水记录表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-05 13:24:54
 */
@Mapper
public interface DepositBankBillFlowDao extends BaseDao<DepositBankBillFlowEntity> {

    List<DepositBankBillFlowEntity> queryRepeatBankBill(DepositBankBillFlowEntity entity);

    int updateRepeat(@Param("id")long id,@Param("repeat")int repeat);

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafter(DepositBankBillFlowEntity entity);

    List<DepositBankBillFlowEntity> queryListByIds(@Param("ids") String ids);

    int updateAREData(DepositBankBillFlowEntity entity);
}
