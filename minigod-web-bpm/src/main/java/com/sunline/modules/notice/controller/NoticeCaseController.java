package com.sunline.modules.notice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.notice.entity.UserNoticeEntity;
import com.sunline.modules.notice.service.UserNoticeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunline.modules.notice.entity.NoticeCaseEntity;
import com.sunline.modules.notice.service.NoticeCaseService;


/**
 * 
 * 
 * @author lcs
 * @email ${email}
 * @date 2018-12-11 10:28:38
 */
@RestController
@RequestMapping("noticeCase")
public class NoticeCaseController extends BaseController{
	@Autowired
	private NoticeCaseService noticeCaseService;
	@Autowired
    private UserNoticeService userNoticeService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("noticeCase:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<NoticeCaseEntity> noticeCaseList = noticeCaseService.queryList(query);
		int total = noticeCaseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(noticeCaseList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{noticeCaseId}")
	@RequiresPermissions("noticeCase:info")
	public Result info(@PathVariable("noticeCaseId") String noticeCaseId){
		NoticeCaseEntity noticeCase = noticeCaseService.queryObject(noticeCaseId);

		//查出通知方案 关联的用户
		UserNoticeEntity userNotice = new  UserNoticeEntity();
        userNotice.setNoticeCaseId(noticeCaseId);
		List<UserNoticeEntity> userNoticeList = userNoticeService.queryListByBean(userNotice);

		List<String> userIds = Lists.newArrayList();
        for(UserNoticeEntity entity : userNoticeList){
            userIds.add(entity.getUserId());
        }
        noticeCase.setUserIds(userIds);

		return Result.ok().put("noticeCase", noticeCase);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("noticeCase:save")
    @Transactional(rollbackFor = Exception.class)
	public Result save(@RequestBody NoticeCaseEntity noticeCase){
	   try {
	       String noticeCaseId = Utils.uuid();
	       noticeCase.setNoticeCaseId(noticeCaseId);
           noticeCase.setCreateUser(UserUtils.getCurrentUser().getUserName());
           noticeCase.setCreateTime(new Date());
           noticeCaseService.save(noticeCase);

           if(noticeCase.getUserIds()!=null && noticeCase.getUserIds().size()>0){
               for(String userId:noticeCase.getUserIds()){
                   UserNoticeEntity userNotice = new UserNoticeEntity();
                   userNotice.setUserId(userId);
                   userNotice.setNoticeCaseId(noticeCaseId);
                   userNotice.setCreateUser(UserUtils.getCurrentUser().getUserName());
                   userNotice.setCreateTime(new Date());
                   userNoticeService.save(userNotice);
               }
           }

           return Result.ok();
       }catch (Exception e){
           TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
           logger.error("保存通知方案出错！",e);
           return Result.error("保存通知方案出错！");
       }
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("noticeCase:update")
    @Transactional(rollbackFor = Exception.class)
	public Result update(@RequestBody NoticeCaseEntity noticeCase){
	    try {
            noticeCase.setUpdateUser(UserUtils.getCurrentUser().getUserName());
            noticeCase.setUpdateTime(new Date());
            noticeCaseService.update(noticeCase);

            userNoticeService.deleteByNoticeId(noticeCase.getNoticeCaseId());

            if(noticeCase.getUserIds()!=null && noticeCase.getUserIds().size()>0){
                for(String userId:noticeCase.getUserIds()){
                    UserNoticeEntity userNotice = new UserNoticeEntity();
                    userNotice.setUserId(userId);
                    userNotice.setNoticeCaseId(noticeCase.getNoticeCaseId());
                    userNotice.setCreateUser(UserUtils.getCurrentUser().getUserName());
                    userNotice.setCreateTime(new Date());
                    userNoticeService.save(userNotice);
                }
            }
            return Result.ok();
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("修改通知方案出错！",e);
            return Result.error("修改通知方案出错");
        }
    }
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("noticeCase:delete")
	public Result delete(@RequestBody String[] noticeCaseIds){
		noticeCaseService.deleteBatch(noticeCaseIds);
		
		return Result.ok();
	}
	
}
