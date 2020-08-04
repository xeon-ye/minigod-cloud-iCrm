package com.sunline.modules.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.URL;

/**
 * @author LiYangFeng
 * @createDate 2017/2/14
 * @description
 * @email justbelyf@gmail.com
 */
public class FileOperaterUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileOperaterUtil.class);

    public static String downloadFileByPath(String filePath) {
        String fileData = null;
        try {
            File imageFile = new File(filePath);
            if (imageFile.exists() && imageFile.isFile()) {
                FileInputStream imageFileRead = new FileInputStream(imageFile);
                int fileSize = imageFileRead.available();
                byte[] fileBytes = new byte[fileSize];

                int iHasRead = 0;
                int iOneRead = 0;
                while (iHasRead < fileSize) {
                    iOneRead = imageFileRead.read(fileBytes, iHasRead, fileSize - iHasRead);
                    if (iOneRead < 0) { //已读取的字节数和要读的字节数相等或者已读取完成（=-1），则跳出
                        break;
                    }

                    iHasRead += iOneRead;
                }

                //注意：BASE64Encoder加密时，每76个字符就会加上回车换车符\r\n，
                //但BASE64Decoder解密时会自动处理，故如果成对使用他们，则不需要处理回车换行符
                fileData = new BASE64Encoder().encodeBuffer(fileBytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileData;

    }

    public static String downloadFileByUrl(String fileUrl, String outPutPath) {
        try {
            String fileSuffixName = getFileExtendName(fileUrl);
            URL url = new URL(fileUrl);
            String fileName = "";
            if (null != fileUrl && fileUrl.indexOf("/") != -1) {
                fileName = url.getFile().substring(url.getFile().lastIndexOf("/") + 1, url.getFile().length() - (url.getFile().substring(url.getFile().lastIndexOf(".") + 1).length() + 1));
            }
            fileUpload(fileName + "." + fileSuffixName, outPutPath, url.openConnection().getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean downloadFileByUrl(String fileUrl, String outPutPath, String fileName) {
        try {
            String fileSuffixName = getFileExtendName(fileUrl);
            URL url = new URL(fileUrl);
            return fileUpload(fileName + "." + fileSuffixName, outPutPath, url.openConnection().getInputStream());
        } catch (Exception e) {
            logger.error("上传图片[" + fileUrl + "]异常", e);
            return false;
        }
    }


    public static boolean fileUpload(String fileSavePath, byte[] fileDataByte) {
        File fileDir = new File(fileSavePath);
        if (!fileDir.getParentFile().exists()) {
            fileDir.getParentFile().mkdirs();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileSavePath);
            fos.write(fileDataByte);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean fileUpload(String fileName, String fileSavePath, InputStream stream) {
        File fileDir = new File(fileSavePath);

        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        FileOutputStream fos = null;
        try {
            String outFileSavePath = fileDir.getPath() + "/" + fileName;
            fos = new FileOutputStream(outFileSavePath);
            int n = 0;// 每次读取的字节长度
            byte[] bb = new byte[1024];// 存储每次读取的内容
            while ((n = stream.read(bb)) != -1) {
                fos.write(bb, 0, n);// 将读取的内容，写入到输出流当中
            }
            fos.close();// 关闭输入输出流
            stream.close();
        } catch (Exception e) {
            logger.error("上传文件异常", e);
            return false;
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (Exception e) {
                    logger.error("关闭流异常", e);
                }
            }
        }

        return true;
    }

    public static boolean fileUpload(String fileSavePath, String filePath) {
//        File fileDir = new File(fileSavePath);
//        if (!fileDir.exists()) {
//            fileDir.mkdirs();
//        }
//
//        try {
//            multipartFile.transferTo(fileDir);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }

        return true;
    }

    public static boolean fileUpload(String fileSavePath, MultipartFile multipartFile) {
        File fileDir = new File(fileSavePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {
            multipartFile.transferTo(fileDir);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean deleteFile(String fileSavePath) {
        File fileDir = new File(fileSavePath);
        if (fileDir.exists()) {
            return fileDir.delete();
        }
        return true;
    }

    public static String getFileExtendName(String fileFullName) {
        String extendName = "";
        if (null != fileFullName && fileFullName.indexOf(".") != -1) {
            extendName = fileFullName.substring(fileFullName.lastIndexOf(".") + 1);
        }

        return extendName;
    }


    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();

        return bos.toByteArray();
    }
}
