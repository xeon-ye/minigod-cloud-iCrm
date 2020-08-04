package com.sunline.modules.account.professional.dao;

import com.sunline.modules.account.professional.entity.ProfessionalInvestorApplicationEntity;
import com.sunline.modules.account.professional.model.query.ProfessionalAppQueryModel;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 专业投资者认定申请信息表
 * 
 * @author jim
 * @email jim@zszhizhu.com
 * @date 2019-12-04 11:31:49
 */
@Mapper
public interface ProfessionalInvestorApplicationDao extends BaseDao<ProfessionalInvestorApplicationEntity> {
    /**
     *根据流水号查询申请记录
     * @param applicationid
     */
    ProfessionalInvestorApplicationEntity queryByApplicationId(String applicationid);

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafter(ProfessionalInvestorApplicationEntity entity);

    /**
     * 查询审核记录
     * @param
     */
    List<ProfessionalInvestorApplicationEntity> queryCheckList(ProfessionalAppQueryModel query);

}
