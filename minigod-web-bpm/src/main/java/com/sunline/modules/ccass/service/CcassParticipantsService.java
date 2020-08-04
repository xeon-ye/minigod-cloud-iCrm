package com.sunline.modules.ccass.service;

import com.sunline.modules.ccass.entity.CcassParticipantsEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;
import java.util.Map;

/**
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-17 16:05:58
 */
public interface CcassParticipantsService {

    CcassParticipantsEntity queryObject(CcassParticipantsEntity entity);

    List<CcassParticipantsEntity> queryList(Map<String, Object> map);

    List<CcassParticipantsEntity> queryListByBean(CcassParticipantsEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(CcassParticipantsEntity ccassParticipants);

    int saveBatch(List<CcassParticipantsEntity> ccassParticipantsEntityList);

    int update(CcassParticipantsEntity ccassParticipants);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);

    /**
     * 获取CCASS参与者信息列表
     *
     * @param ccassParticipantsEntity
     * @param pageNum
     * @return
     */
    Page<CcassParticipantsEntity> findPage(CcassParticipantsEntity ccassParticipantsEntity, int pageNum);

    /**
     * CCASS参与者信息列表导出列表
     *
     * @param ccassParticipantsEntity
     * @return
     */
    List<CcassParticipantsEntity> findCcassParticiInfoExcelList(CcassParticipantsEntity ccassParticipantsEntity);
}
