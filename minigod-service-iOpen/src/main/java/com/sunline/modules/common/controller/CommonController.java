package com.sunline.modules.common.controller;

import com.sunline.modules.common.utils.FileDownload;
import com.sunline.modules.common.utils.FileUtil;
import com.sunline.modules.common.utils.ShiroUtils;
import com.sunline.modules.sys.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author LiYangFeng
 * @createDate 2018/4/26
 * @description
 * @email justbelyf@gmail.com
 */
@RequestMapping("common")
@Controller
public class CommonController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 文件下载
     *
     * @param request
     * @param response
     * @param fullFilePath
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, HttpServletResponse response, String fullFilePath) throws Exception {

        try {

            UserEntity user = ShiroUtils.getUserEntity();

            if (null != user) {

                File reportFile = new File(fullFilePath);
                if (!reportFile.exists()) {
                    return null;
                }

                String defaultDownloadName = new String(reportFile.getName().getBytes("gb2312"), "iso8859-1");

                FileDownload.fileDownload(response, fullFilePath, defaultDownloadName);
            } else {
                response.sendRedirect("/login");
            }

        } catch (Exception e) {
            logger.error("文件下载异常", e);
        }

        return null;
    }

    /**
     * 文件查看
     *
     * @param request
     * @param response
     * @param fullFilePath
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/showFile", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> showFile(HttpServletRequest request, HttpServletResponse response, String fullFilePath,String fileType) throws Exception {

        try {

            UserEntity user = ShiroUtils.getUserEntity();

            if (null != user) {

                File reportFile = new File(fullFilePath);
                if (!reportFile.exists()) {
                    return null;
                }

                byte[] data = FileUtil.toByteArray2(fullFilePath);
                response.reset();
                response.addHeader("Content-Length", "" + data.length);
                String fileName = new String(reportFile.getName().getBytes("gb2312"), "iso8859-1");
                //设置文件ContentType类型
                if("jpg,jepg,gif,png".contains(fileType)){//图片类型
                    response.setContentType("image/"+fileType);
                    response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");
                }else if("pdf".contains(fileType)){//pdf类型
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");
                } else{//下载文件
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                    response.setContentType("application/octet-stream;charset=UTF-8");
                }

                OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
                outputStream.write(data);
                outputStream.flush();
                outputStream.close();
                response.flushBuffer();

//                FileDownload.fileDownload(response, fullFilePath, defaultDownloadName);
            } else {
                response.sendRedirect("/login");
            }

        } catch (Exception e) {
            logger.error("文件下载异常", e);
        }

        return null;
    }
}
