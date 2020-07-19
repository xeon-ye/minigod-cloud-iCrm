package com.sunline.modules.api.service.impl;

import com.sunline.modules.api.dao.ChannelApiDao;
import com.sunline.modules.api.entity.ChannelModel;
import com.sunline.modules.api.entity.ChannelQueryModel;
import com.sunline.modules.api.service.ChannelApiService;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.marker.dao.UserChannelInfoDao;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author: lcs
 * @date: 2018/5/15 16:46
 */
@Service
public class ChannelServiceImpl implements ChannelApiService {

    private static final Logger logger = LoggerFactory.getLogger(ChannelServiceImpl.class);

    @Autowired
    private ChannelApiDao channelApiDao;
    @Autowired
    private UserChannelInfoDao channelInfoDao;

    @Override
    public ResponseVO queryInfo(List<String> channelIds,String channelId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ResponseVO vo = new ResponseVO();
        try {
            JSONObject result = new JSONObject();
            if(channelIds!=null){
                List<ChannelModel> channelList =channelInfoDao.queryByChannelIds(channelIds);
                result.put("channelList",channelList);
                if(channelId!=null && !"".equals(channelId)){
                    channelIds = new ArrayList<>();
                    channelIds.add(channelId);
                }
                ChannelQueryModel lastChannelInfo = channelApiDao.queryLastInfo(channelIds);
                result.put("lastChannelInfo",lastChannelInfo);
                ChannelQueryModel totalChannelInfo = channelApiDao.queryTotalInfo(channelIds);
                result.put("totalChannelInfo",totalChannelInfo);
                vo.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
            }else{
                vo.setMessage("暂无已授权渠道！");
            }
            vo.setCode(CrmCommonEnum.CodeType.OK.getCode());
            vo.setResult(result);
        }catch (Exception e){
            logger.error("渠道查询出现异常",e);
            vo.setCode(CrmCommonEnum.CodeType.WEB_ERROR.getCode());
            vo.setMessage("渠道查询出现异常");
            return vo;
        }
        return vo;
    }


}
