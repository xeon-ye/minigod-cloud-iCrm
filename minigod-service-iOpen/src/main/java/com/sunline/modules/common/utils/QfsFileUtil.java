package com.sunline.modules.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.common.BpmCommonEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Map;

/**
 * @author PENGFENG
 * @decription 上传文件工具类
 * @date 2017/07/27
 */
public class QfsFileUtil {
    private static Logger logger = LoggerFactory.getLogger(QfsFileUtil.class);

    /**
     * 文件上传
     * @param content  文件内容
     * @param fileName 文件名称
     * @return
     */
    public static String uploadFile(String content, String fileName) {
        try {
//            String url = Global.getConfig("file.upload.url");
            String url = ConfigUtils.get("file.upload.url");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fileName" , fileName);
            jsonObject.put("content" , content);
            Map<String ,Object> map  = Maps.newHashMap();
            map.put("params" , jsonObject);
            map.put("version" , "1.0");
            String result = HttpClientUtils.postJson(url, JSONObject.toJSONString(map));
            String code = JSONObject.parseObject(result).get("code").toString();
            if (code.equals("5000")) {
                String filePath = JSONObject.parseObject(result).get("result").toString();
                return filePath;
            }
            return null;
        }catch (Exception e) {
            logger.error("调用sunline图片上传接口失败" , e);
        }
        return null;
    }

    /**
     * 根据文件后缀名判断文件类型
     * @param fileName  文件名称
     * @return
     */
    public static Map<String,Object> checkFileType(String fileName) {
        Map<String,Object> map = Maps.newHashMap();
        if (StringUtils.isNotBlank(fileName)) {
            String extendName = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()).toLowerCase();
            int fileType = returnType(extendName);
            map.put("extendName" , extendName);
            map.put("fileType" , fileType);
            return map;
        }
        return null;
    }

    public static String getFileName(String filePath) throws Exception {
        File file = new File(filePath);
        return file.getName();
    }

    public static String getBase64(String filePath) throws Exception {
        File file = new File(filePath);
        FileInputStream inputStream;
        inputStream = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputStream.read(buffer);
        inputStream.close();
        String base64 = new BASE64Encoder().encode(buffer);
        return base64;
    }

    /**
     * 根据文件名后缀判断文件类型
     * @param extendName
     * @return
     */
    private static Integer returnType(String extendName){
        switch (extendName) {
            case "jpg" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_IMAGE.getNumber();
            case "png" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_IMAGE.getNumber();
            case "gif" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_IMAGE.getNumber();
            case "bmp" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_IMAGE.getNumber();
            case "ico" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_IMAGE.getNumber();
            case "webp" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_IMAGE.getNumber();
            case "pdf" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_PDF.getNumber();
            case "txt" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_TEXT.getNumber();
            case "xls" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_XLSX.getNumber();
            case "xlsx" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_XLSX.getNumber();
            case "doc" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_DOC.getNumber();
            case "docx" :
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_DOC.getNumber();
            default:
                return BpmCommonEnum.FileStorageType.FILE_STORAGE_TYPE_UNKNOW.getNumber();
        }
    }

    /**
     * 上传文件到本地服务器
     * @param filePath  文件路径
     * @param savePath  文件保存路径
     * @return
     */
    public static Map<String,Object> savePic(String filePath, String savePath) {
        InputStream inputStream = null;
        OutputStream os = null;
        Map<String,Object> resultMap = Maps.newHashMap();
        try {
            File file = new File(filePath);
            String fileName = file.getName();
            resultMap = checkFileType(fileName);
            resultMap.put("fileName" , fileName);
            inputStream = new FileInputStream(file);
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(savePath);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

            resultMap.put("filePath" , savePath);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }

    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\test.docx";
        File file = new File(filePath);
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputStream.read(buffer);
            inputStream.close();
            String base65 = new BASE64Encoder().encode(buffer);
            String fileName = file.getName();
            QfsFileUtil.uploadFile(base65,fileName);
        }catch (Exception e) {

        }
    }
}