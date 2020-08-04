package com.sunline.modules.marker.controller;

import com.google.common.collect.Lists;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageData;
import com.sunline.modules.common.utils.ChannelUtil;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.ObjectExcelView;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.marker.entity.UserChannelInfoEntity;
import com.sunline.modules.marker.model.UserChannelInfoModel;
import com.sunline.modules.marker.service.UserChannelInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 渠道查询controller
 * @author jim
 * @email
 * @date 2018-07-18
 */
@Controller
@RequestMapping("channelInfo")
public class channelController extends BaseController {
    @Autowired
    private UserChannelInfoService userChannelInfoService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("channelListInfo")
    @RequiresPermissions("channelInfo:list")
    public String channelList(Model model, HttpServletRequest request,UserChannelInfoEntity channelInfo){
        if(getUserId().equals(Constant.SUPERR_USER)){
            channelInfo.setChannelIds(null);
        }else{
            channelInfo.setChannelIds(getChannelIds());
        }
        if(channelInfo.getCheckedChannelId()!=null&&!"".equals(channelInfo.getCheckedChannelId())){
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(channelInfo.getCheckedChannelId());
            if(checkedChannelIds!=null && checkedChannelIds.size()>0){
                channelInfo.setCheckedChannelIds(checkedChannelIds);
            }
        }
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<UserChannelInfoEntity> page = userChannelInfoService.findPage(channelInfo,pageNum);
        model.addAttribute("page",page);
        model.addAttribute("model",channelInfo);
        return "marker/channelList";
    }

    /**
     * 渠道信息查询excle 导出
     *
     * @param userChannelInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/channelExp")
    @RequiresPermissions("channelInfo:exp")
    @SysLog("渠道信息查询导出")
    public void comBusExpExcel(UserChannelInfoEntity userChannelInfoEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if(getUserId().equals(Constant.SUPERR_USER)){
                userChannelInfoEntity.setChannelIds(null);
            }else{
                userChannelInfoEntity.setChannelIds(getChannelIds());
            }
            if(userChannelInfoEntity.getCheckedChannelId()!=null&&!"".equals(userChannelInfoEntity.getCheckedChannelId())){
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(userChannelInfoEntity.getCheckedChannelId());
                if(checkedChannelIds!=null && checkedChannelIds.size()>0){
                    userChannelInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            List<UserChannelInfoEntity> channelList = userChannelInfoService.queryForExp(userChannelInfoEntity);

            List<UserChannelInfoModel> userChannelInfoModels = Lists.newArrayList();

            for(int i = 0; i < channelList.size(); i++){
                UserChannelInfoModel model = new UserChannelInfoModel();
                model.setId(i+1);
                model.setChannelId(channelList.get(i).getChannelId()!=null?channelList.get(i).getChannelId():"");
                model.setChannelName(channelList.get(i).getChannelName()!=null?channelList.get(i).getChannelName():"");
                model.setParentName(channelList.get(i).getParentName()!=null?channelList.get(i).getParentName():"");
                model.setCreateBy(channelList.get(i).getCreateBy()!=null?channelList.get(i).getCreateBy():"");
                model.setUpdateBy(channelList.get(i).getUpdateBy()!=null?channelList.get(i).getUpdateBy():"");
                model.setCreateTime(channelList.get(i).getCreateTime()!=null?channelList.get(i).getCreateTime():"");
                model.setUpdateTime(channelList.get(i).getUpdateTime()!=null?channelList.get(i).getUpdateTime():"");
                userChannelInfoModels.add(model);
            }

            EasyExcelUtils.exportXlsxFile(userChannelInfoModels,response,UserChannelInfoModel.class);
        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }
}
