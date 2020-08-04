package com.sunline.modules.account.online.controller;

import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.OpenAccountAdditionalFileEntity;
import com.sunline.modules.account.online.entity.OpenAccountOperatorLogEntity;
import com.sunline.modules.account.online.service.CustomerAccOpenApplyService;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.account.online.service.OpenAccountAdditionalFileService;
import com.sunline.modules.account.online.service.OpenAccountOperatorLogService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.FileOperaterUtil;
import com.sunline.modules.common.utils.FileUpload;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author lsc
 * @decription 上传文件
 * @date 2017/07/28
 */
@Controller
@RequestMapping("/supOpenAccountInfo")
@Transactional
public class SupOpenAccountInfoController {
    private static final Logger logger = LoggerFactory.getLogger(SupOpenAccountInfoController.class);

    @Autowired
    private OpenAccountAdditionalFileService openAccountAdditionalFileService;
    @Autowired
    CustomerAccOpenService customerAccountOpenService;
    @Autowired
    CustomerAccOpenApplyService customerAccOpenApplyService;
    @Autowired
    private OpenAccountOperatorLogService openAccountOperatorLogService;

    /**
     * 补充资料上传文件
     * @param httpServletRequest
     * @param supOpenAccountInfo
     * @return
     */
    @RequestMapping(value = "/supOpenAccountInfo")
    public String supOpenAccountinfo(HttpServletRequest httpServletRequest,OpenAccountAdditionalFileEntity supOpenAccountInfo){
        String applicationId = supOpenAccountInfo.getApplicationId();
//        String additionalId = supOpenAccountInfo.getAdditionalId();
//        if(additionalId==null || "".equals(additionalId)){
//            additionalId = Utils.uuid();
//            supOpenAccountInfo.setAdditionalId(additionalId);
//        }
//        supOpenAccountInfo.setCreateUser(UserUtils.getCurrentUserId());
        supOpenAccountInfo.setFileType(1);
        List<OpenAccountAdditionalFileEntity> videoPathList = openAccountAdditionalFileService.queryListByEntity(supOpenAccountInfo);
        supOpenAccountInfo.setFileType(0);
        List<OpenAccountAdditionalFileEntity> photoPathList = openAccountAdditionalFileService.queryListByEntity(supOpenAccountInfo);
        httpServletRequest.setAttribute("applicationId",applicationId);
//        httpServletRequest.setAttribute("additionalId",additionalId==null? Utils.uuid():additionalId);
        httpServletRequest.setAttribute("videoPathList",videoPathList);
        httpServletRequest.setAttribute("photoPathList",photoPathList);
        List<OpenAccountAdditionalFileEntity> remarkEntityList = openAccountAdditionalFileService.queryDetail(supOpenAccountInfo);
        if(remarkEntityList.size()>0){
            httpServletRequest.setAttribute("remark",remarkEntityList.get(0).getRemark());
        }
        if(videoPathList.size()==0&&photoPathList.size()==0){
            List<OpenAccountAdditionalFileEntity>  detailList = openAccountAdditionalFileService.queryDetail(supOpenAccountInfo);
            if(detailList.size()>0){
                httpServletRequest.setAttribute("remark",detailList.get(0).getRemark());
            }
        }
        return "account/online/supOpenAccountInfo";
    }


    /**
     * 上传文件
     */
    @RequestMapping(value="/upload",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseVO upload(@RequestParam("file") MultipartFile file, OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity, HttpServletRequest request) throws Exception {
        ResponseVO responseVO = new  ResponseVO();
        if (file.isEmpty()) {
            responseVO.setCode(999);
            responseVO.setMessage("文件不能为空！");
            return responseVO;
        }


        openAccountAdditionalFileEntity.setFilePath(ConfigUtils.get("supOpenAccount.file.savePath")+new SimpleDateFormat("yyyyMMdd").format(new Date())+"/");
        openAccountAdditionalFileEntity.setFileStorageName(UUID.randomUUID().toString());
        openAccountAdditionalFileEntity.setFileExtName(FileOperaterUtil.getFileExtendName(file.getOriginalFilename()));
        openAccountAdditionalFileEntity.setCreateUser(UserUtils.getCurrentUserId());
        openAccountAdditionalFileEntity.setUpdateUser(UserUtils.getCurrentUserId());
        openAccountAdditionalFileEntity.setCreateTime(new Date());
        openAccountAdditionalFileEntity.setUpdateTime(new Date());
        if(1==openAccountAdditionalFileEntity.getFileType()){
            openAccountAdditionalFileEntity.setFileName("音/视频");
        }else{
            openAccountAdditionalFileEntity.setFileName("图片");
        }
        Boolean isSuccess =  FileUpload.fileUpload(file,openAccountAdditionalFileEntity.getFilePath(),openAccountAdditionalFileEntity.getFileStorageName());
        if (isSuccess){
            openAccountAdditionalFileService.saveFile(openAccountAdditionalFileEntity);

            //需要更新日志

            responseVO.setCode(0);
            responseVO.setMessage("ok");
            return responseVO;
        }else{
            responseVO.setCode(999);
            responseVO.setMessage("文件保存失败!");
            return responseVO;
        }
    }

    /**
     * 重新上传文件
     */
    @RequestMapping("/reUpload")
    public @ResponseBody
    ResponseVO reUpload(@RequestParam("file") MultipartFile file,OpenAccountAdditionalFileEntity supOpenAccountInfo) throws Exception {
        ResponseVO responseVO = new ResponseVO();
        if (file.isEmpty()) {
            throw new Exception("上传文件不能为空");
        }
        OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity = openAccountAdditionalFileService.queryInfo(supOpenAccountInfo);
        openAccountAdditionalFileEntity.setFileExtName(FileOperaterUtil.getFileExtendName(file.getOriginalFilename()));
        openAccountAdditionalFileEntity.setUpdateUser(UserUtils.getCurrentUserId());
        Boolean isSuccess =  FileUpload.fileUpload(file,openAccountAdditionalFileEntity.getFilePath(),openAccountAdditionalFileEntity.getFileStorageName());
        if (isSuccess){
            openAccountAdditionalFileService.update(openAccountAdditionalFileEntity);
            //需要更新日志

            responseVO.setCode(0);
            responseVO.setMessage("ok");
            return responseVO;
        }else{
            responseVO.setCode(999);
            responseVO.setMessage("文件保存失败!");
            return responseVO;
        }
    }

    /**
     * 保存备注
     */
    @RequestMapping("/saveComment")
    public @ResponseBody
    String saveComment(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity,HttpServletRequest request) throws Exception {
        openAccountAdditionalFileEntity.setCreateUser(UserUtils.getCurrentUserId());
        openAccountAdditionalFileEntity.setCreateTime(new Date());
        openAccountAdditionalFileEntity.setUpdateTime(new Date());
        List<OpenAccountAdditionalFileEntity> list =  openAccountAdditionalFileService.queryDetail(openAccountAdditionalFileEntity);
        int count = 0;
        if(list.size()==0){
            if(openAccountAdditionalFileEntity.getRemark()==null){
                openAccountAdditionalFileEntity.setRemark("");
            }
            count = openAccountAdditionalFileService.saveRecord(openAccountAdditionalFileEntity);
        }
        else{
            count = openAccountAdditionalFileService.updateRecord(openAccountAdditionalFileEntity);
        }
        if(count>0)
        {
            openAccountAdditionalFileService.resetUpdateUser(openAccountAdditionalFileEntity.getApplicationId());

            //需要更新日志
            customerAccountOpenService.updateOpenAccountProcessLog(openAccountAdditionalFileEntity.getApplicationId(), BpmCommonEnum.YesNo.NO.getIndex(), BpmCommonEnum.YesNo.YES.getIndex());
            // 更新客户开户业务操作员日志表
            CustomerAccountOpenApplyEntity customerAccountOpenApplyInfo=customerAccOpenApplyService.queryObjectByApplicationId(openAccountAdditionalFileEntity.getApplicationId());

            OpenAccountOperatorLogEntity openAccountOperatorLogEntity=new OpenAccountOperatorLogEntity();
            openAccountOperatorLogEntity.setApplicationId(openAccountAdditionalFileEntity.getApplicationId());
            openAccountOperatorLogEntity.setCurrentNode(customerAccountOpenApplyInfo.getCurrentNode());
            openAccountOperatorLogEntity.setOperateType(2);
            openAccountOperatorLogEntity.setCreateUser(UserUtils.getCurrentUserId());
            openAccountOperatorLogEntity.setCreateTime(new Date());

            openAccountOperatorLogService.save(openAccountOperatorLogEntity);

            return "ok";
        }else{
            return "error";
        }
    }

    /**
     * 删除文件
     */
    @RequestMapping("/deleteFile")
    public @ResponseBody
    String deleteFile(OpenAccountAdditionalFileEntity openAccountAdditionalFileEntity,HttpServletRequest request) throws Exception {
        int count = openAccountAdditionalFileService.deleteFile(openAccountAdditionalFileEntity);
        if(count>0)
        {
            return "ok";
        }else{
            return "error";
        }
    }

    /**
     * 局部补充资料刷新
     *
     * @param model
     * @param supOpenAccountInfo 流程id
     * @return
     */
    @RequestMapping(value = "supFileRefresh")
    public String supFileRefresh(Model model, OpenAccountAdditionalFileEntity supOpenAccountInfo) {

        String applicationId = supOpenAccountInfo.getApplicationId();
        supOpenAccountInfo.setFileType(1);
        List<OpenAccountAdditionalFileEntity> videoPathList = openAccountAdditionalFileService.queryListByEntity(supOpenAccountInfo);
        supOpenAccountInfo.setFileType(0);
        List<OpenAccountAdditionalFileEntity> photoPathList = openAccountAdditionalFileService.queryListByEntity(supOpenAccountInfo);
        model.addAttribute("applicationId",applicationId);
        model.addAttribute("videoPathList",videoPathList);
        model.addAttribute("photoPathList",photoPathList);
        List<OpenAccountAdditionalFileEntity> remarkEntityList = openAccountAdditionalFileService.queryDetail(supOpenAccountInfo);
        if(remarkEntityList.size()>0){
            model.addAttribute("remark",remarkEntityList.get(0).getRemark());
        }
        if(videoPathList.size()==0&&photoPathList.size()==0){
            List<OpenAccountAdditionalFileEntity>  detailList = openAccountAdditionalFileService.queryDetail(supOpenAccountInfo);
            if(detailList.size()>0){
                model.addAttribute("remark",detailList.get(0).getRemark());
            }
        }
        return "account/online/supRefresh";
    }
}
