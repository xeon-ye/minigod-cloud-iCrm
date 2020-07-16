package com.sunline.modules.account.online.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.account.online.dao.OpenAccountAdditionalFileDao;
import com.sunline.modules.account.online.entity.OpenAccountAdditionalFileEntity;
import com.sunline.modules.account.online.service.OpenAccountAdditionalFileService;
import com.sunline.modules.common.utils.Utils;

/**
 * 补充资料文件上传表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-09-28 11:39:54
 */

@Service("openAccountAdditionalFileService")
public class OpenAccountAdditionalFileServiceImpl implements OpenAccountAdditionalFileService {
	@Autowired
	private OpenAccountAdditionalFileDao openAccountAdditionalFileDao;
	
	@Override
	public OpenAccountAdditionalFileEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountAdditionalFileDao.queryObject(id);
	}
	
	@Override
	public List<OpenAccountAdditionalFileEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountAdditionalFileDao.queryList(map);
	}

    @Override
    public List<OpenAccountAdditionalFileEntity> queryListByBean(OpenAccountAdditionalFileEntity openAccountAdditionalFile) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.queryListByBean(openAccountAdditionalFile);
    }

    @Override
    public List<OpenAccountAdditionalFileEntity> queryListByEntity(OpenAccountAdditionalFileEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.queryListByEntity(entity);
    }

    @Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountAdditionalFileDao.queryTotal(map);
	}
	
	@Override
	public int save(OpenAccountAdditionalFileEntity openAccountAdditionalFile){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        openAccountAdditionalFile.setId(Utils.uuid());                
        
        if("1".equals(openAccountAdditionalFile.getFileType())){
        	openAccountAdditionalFile.setFileName("音/视频");
        }else{
        	openAccountAdditionalFile.setFileName("图片");
        }
		return openAccountAdditionalFileDao.save(openAccountAdditionalFile);
	}
	
	@Override
	public int update(OpenAccountAdditionalFileEntity openAccountAdditionalFile){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.update(openAccountAdditionalFile);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.deleteBatch(ids);
	}

	
	@Override
	public int deleteFile(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountAdditionalFileDao.deleteFile(openAccountAdditionalFileEntity);
	}

	@Override
	public int updateRecord(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return openAccountAdditionalFileDao.updateRecord(openAccountAdditionalFileEntity);
	}

	@Override
	public List<OpenAccountAdditionalFileEntity> queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		OpenAccountAdditionalFileEntity queryCondition = new OpenAccountAdditionalFileEntity();
		queryCondition.setApplicationId(applicationId);
		return openAccountAdditionalFileDao.queryListByBean(queryCondition);
	}

    @Override
    public List<OpenAccountAdditionalFileEntity> queryFileInfo(OpenAccountAdditionalFileEntity openAccountAdditionalFile) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.queryListByBean(openAccountAdditionalFile);
    }

    @Override
    public List<OpenAccountAdditionalFileEntity> queryDetail(OpenAccountAdditionalFileEntity openAccountAdditionalFile) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.queryDetail(openAccountAdditionalFile);
    }

    @Override
    public List<String> querySupUsers(String openAccountAcceptId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.querySupUsers(openAccountAcceptId);
    }

    @Override
    public int saveFile(OpenAccountAdditionalFileEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.save(entity);
    }

    @Override
    public int saveRecord(OpenAccountAdditionalFileEntity supOpenAccountInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.saveRecord(supOpenAccountInfo);
    }

    @Override
    public OpenAccountAdditionalFileEntity queryInfo(OpenAccountAdditionalFileEntity supOpenAccountInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.queryInfo(supOpenAccountInfo);
    }

    @Override
    public List<String> queryAdditionalIds(String application) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.queryAdditionalIds(application);
    }

    @Override
    public int resetUpdateUser(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.resetUpdateUser(applicationId);
    }

    @Override
    public List<OpenAccountAdditionalFileEntity> querySupFile(OpenAccountAdditionalFileEntity supOpenAccountInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountAdditionalFileDao.querySupFile(supOpenAccountInfo);
    }
}
