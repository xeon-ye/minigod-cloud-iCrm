package com.sunline.modules.common.dao;

import com.sunline.modules.common.entity.StkTrdCaleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author lcs
 * @email 
 * @date 2018-05-25 13:50:28
 */
@Mapper
public interface StkTrdCaleDao extends BaseDao<StkTrdCaleEntity> {

    StkTrdCaleEntity queryByDateAndCode(@Param("normalDate")String normalDate,@Param("regionCode")String regionCode);

    Integer getTrdDayNumByTrdDate(@Param("trdBeginDate")String trdBeginDate, @Param("trdEndDate")String trdEndDate);
}
