package com.sunline.modules.account.online.service;


import java.util.List;
import java.util.Map;

import com.sunline.modules.account.online.entity.OpenAccountAdditionalFileEntity;
import com.sunline.modules.account.online.entity.OpenAccountPropertyTypeEntity;



/**
 * 补充资料文件上传表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-09-28 11:39:54
 */
public interface OpenAccountAdditionalFileService {
	
	
	int deleteFile(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity);
    int updateRecord(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity); 
	
	OpenAccountAdditionalFileEntity queryObject(Long id);
	
	List<OpenAccountAdditionalFileEntity> queryList(Map<String, Object> map);

    List<OpenAccountAdditionalFileEntity> queryListByBean(OpenAccountAdditionalFileEntity entity);
    List<OpenAccountAdditionalFileEntity> queryListByEntity(OpenAccountAdditionalFileEntity entity);

	int queryTotal(Map<String, Object> map);
	
	int save(OpenAccountAdditionalFileEntity openAccountAdditionalFile);
	
	int update(OpenAccountAdditionalFileEntity openAccountAdditionalFile);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);
	
    List<OpenAccountAdditionalFileEntity> queryByApplicationId(String applicationId);



    /**
     * 查询文件list
     * @param openAccountAdditionalFile
     * @return
     */
    List<OpenAccountAdditionalFileEntity>   queryFileInfo(OpenAccountAdditionalFileEntity openAccountAdditionalFile);

    /**
     * 查询文件对应的理由
     * @param openAccountAdditionalFile
     * @return
     */
    List<OpenAccountAdditionalFileEntity>   queryDetail(OpenAccountAdditionalFileEntity openAccountAdditionalFile);

    List<String> querySupUsers(String openAccountAcceptId);

    int saveFile(OpenAccountAdditionalFileEntity entity);

    int saveRecord(OpenAccountAdditionalFileEntity supOpenAccountInfo);

    OpenAccountAdditionalFileEntity queryInfo(OpenAccountAdditionalFileEntity supOpenAccountInfo);

    List<String>  queryAdditionalIds(String application);

    int resetUpdateUser(String applicationId);

    List<OpenAccountAdditionalFileEntity> querySupFile(OpenAccountAdditionalFileEntity supOpenAccountInfo);
}
