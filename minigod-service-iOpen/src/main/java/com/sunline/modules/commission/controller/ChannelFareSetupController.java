package com.sunline.modules.commission.controller;

import java.util.List;
import java.util.Map;

import com.sunline.modules.commission.entity.ChannelFareSetupLogEntity;
import com.sunline.modules.commission.service.ChannelFareSetupLogService;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.UserUtils;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.common.utils.PageUtils;
import com.sunline.modules.common.utils.Query;
import com.sunline.modules.common.utils.Result;


/**
 * 渠道佣金套餐设置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 21:25:11
 */
@RestController
@RequestMapping("channelFareSetup")
public class ChannelFareSetupController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelFareSetupController.class);
	@Autowired
	private ChannelFareSetupService channelFareSetupService;
	@Autowired
	private ChannelFareSetupLogService channelFareSetupLogService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
//	@RequiresPermissions("channelfaresetup:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ChannelFareSetupEntity> channelFareSetupList = channelFareSetupService.queryList(query);
		int total = channelFareSetupService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(channelFareSetupList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
//	@RequiresPermissions("channelfaresetup:info")
	public Result info(@PathVariable("id") Integer id){
		ChannelFareSetupEntity channelFareSetup = channelFareSetupService.queryObject(id);
		
		return Result.ok().put("channelFareSetup", channelFareSetup);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
//	@RequiresPermissions("channelfaresetup:save")
	public Result save(@RequestBody ChannelFareSetupEntity channelFareSetup){
		channelFareSetupService.save(channelFareSetup);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("channelfaresetup:update")
	public Result update(@RequestBody ChannelFareSetupEntity channelFareSetup){
		channelFareSetupService.update(channelFareSetup);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("channelfaresetup:delete")
	public Result delete(@RequestBody Integer channelId){
	   try {
           ChannelFareSetupEntity channelFare = new ChannelFareSetupEntity();
           channelFare.setChannelId(channelId);
           channelFare.setChannelFareType("1");
           channelFare = channelFareSetupService.queryByParams(channelFare);
           int count = 0;
           if(null!=channelFare){
               count = channelFareSetupService.delete(channelFare.getId());
               ChannelFareSetupLogEntity  channelFareLog = new ChannelFareSetupLogEntity();
               channelFareLog.setOpFlag("2");
               channelFareLog.setChannelId(channelFare.getChannelId());
               channelFareLog.setLastFareKind(channelFare.getFareKind());
               channelFareLog.setFareKind(null);
               channelFareLog.setChannelFareType("1");
               channelFareLog.setBeginDate(channelFare.getBeginDate());
               channelFareLog.setEndDate(channelFare.getEndDate());
               channelFareLog.setIsFreeCommission(channelFare.getIsFreeCommission());
               channelFareLog.setFreeCommissionDays(channelFare.getFreeCommissionDays());
               channelFareLog.setCreateUser(UserUtils.getCurrentUser().getUserName());
               channelFareLog.setUpdateUser(UserUtils.getCurrentUser().getUserName());
               if(count>0){
                   count = channelFareSetupLogService.save(channelFareLog);
               }
           }
       }catch (Exception e){
           LOGGER.error("删除下一方案出错！");
           return Result.error("删除下一方案出错！");
       }
		return Result.ok();
	}

	@RequestMapping("/checkAuditStatus")
	public Result checkAuditStatus(@RequestBody Integer channelId){

	    ChannelFareSetupEntity entity = new ChannelFareSetupEntity();
	    entity.setChannelId(channelId);
	    entity.setAuditStatus(1);

	    List<ChannelFareSetupEntity> result = channelFareSetupService.checkAuditStatus(entity);

	    if(null == result || result.size()==0){
            return Result.ok();
        }
	    return Result.error("-2","渠道佣金方案尚未通过审核，暂时无法变更！");
    }

}
