package com.sunline.modules.activiti.dao;

import com.sunline.modules.activiti.entity.ExtendActNodeuserEntity;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.common.dao.BaseDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2017-08-04 11:46:48
 */
@Mapper
public interface ExtendActTasklogDao extends BaseDao<ExtendActTasklogEntity> {
    /**
     * 根据任务id 更改日志
     * @param extendActTasklogEntity
     * @return
     */
    int updateByTaskId(ExtendActTasklogEntity extendActTasklogEntity);

    /**
     * 转办任务时更新任务日志，有可能会存在多次转办，就会产生多条任务日志，所有这里用 taskId+appAction为空 作唯一
     * @param extendActTasklogEntity
     * @return
     */
    int updateByTaskIdOpinion(ExtendActTasklogEntity extendActTasklogEntity);
    
    List<ExtendActTasklogEntity> queryListProcessLog(ExtendActTasklogEntity extendActTasklogEntity);

    /*
 * 开户查看历史流程信息
 * @param extendActTasklogEntity
 */
    List<ExtendActTasklogEntity> queryListProcessLogHis(ExtendActTasklogEntity extendActTasklogEntity);

    /**
     * 获取客户开户申请审核信息
     * @param value
     * @return
     */
    List<ExtendActTasklogEntity> getOpenAccountAuditInfo(Object value);
}
