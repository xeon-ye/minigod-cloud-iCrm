package com.sunline.modules.user.service;

import com.sunline.modules.user.entity.UserCertEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户登录凭证表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-22 13:26:40
 */
public interface UserCertService {
	
	UserCertEntity queryObject(UserCertEntity entity);
	
	List<UserCertEntity> queryList(Map<String, Object> map);

    List<UserCertEntity> queryListByBean(UserCertEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(UserCertEntity userCert);
	
	int update(UserCertEntity userCert);
	
	int delete(Integer certId);
	
	int deleteBatch(Integer[] certIds);
}
