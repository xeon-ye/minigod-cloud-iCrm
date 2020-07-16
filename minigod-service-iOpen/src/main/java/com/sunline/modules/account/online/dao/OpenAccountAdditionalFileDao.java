package com.sunline.modules.account.online.dao;


import com.sunline.modules.account.online.entity.OpenAccountAdditionalFileEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 补充资料文件上传表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-09-28 11:39:54
 */
@Mapper
public interface OpenAccountAdditionalFileDao extends BaseDao<OpenAccountAdditionalFileEntity> {
    List<OpenAccountAdditionalFileEntity> queryDetail(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity);

    List<String> querySupUsers(String applicationId);

    int saveRecord(OpenAccountAdditionalFileEntity entity);

    OpenAccountAdditionalFileEntity queryInfo(OpenAccountAdditionalFileEntity entity);

    List<String > queryAdditionalIds(String applicationId);

    int updateRecord(OpenAccountAdditionalFileEntity entity);

    int resetUpdateUser(String applicationId);

    //查询补充资料文件 （出去aml文件）
    List<OpenAccountAdditionalFileEntity> querySupFile(OpenAccountAdditionalFileEntity supOpenAccountInfo);

    int deleteFile(OpenAccountAdditionalFileEntity supOpenAccountInfo);

    List<OpenAccountAdditionalFileEntity> queryListByEntity(OpenAccountAdditionalFileEntity entity);

}
