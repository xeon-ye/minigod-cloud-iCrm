package com.sunline.modules.commission.dao;

import com.sunline.modules.commission.entity.ClientFareSetupLogEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * 客户佣金套餐设置日志表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-23 17:34:01
 */
@Mapper
public interface ClientFareSetupLogDao extends BaseDao<ClientFareSetupLogEntity> {

	List<ClientFareSetupLogEntity> queryAcceptList(ClientFareSetupLogEntity entity);

    ClientFareSetupLogEntity queryClientFareInfo(ClientFareSetupLogEntity entity);

    int updateByBusId(ClientFareSetupLogEntity entity);
}
