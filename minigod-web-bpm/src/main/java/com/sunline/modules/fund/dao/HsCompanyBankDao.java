package com.sunline.modules.fund.dao;

import com.sunline.modules.fund.entity.HsCompanyBankEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 恒生公司银行帐号信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-04-23 14:13:44
 */
@Mapper
public interface HsCompanyBankDao extends BaseDao<HsCompanyBankEntity> {
	
}
