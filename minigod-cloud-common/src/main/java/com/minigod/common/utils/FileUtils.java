package com.minigod.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.UUID;

@Slf4j
public class FileUtils {

    public static final InputStream getInputStreamFromClassPath(String file) {
        return PropUtil.class.getClassLoader().getResourceAsStream(file);
    }

    private static final int BUFFER = 1024;

    private static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    public static String generateKey(String originalFilename) {
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);
        String uuid32 = getUUID();

        String fileName = uuid32 + suffix;

        return fileName;
    }

    /**
     * @return 如果成功true;否则false
     * @Title:功 能: 拷贝文件(只能拷贝文件)
     * @param: strSourceFileName 指定的文件全路径名
     * @param: strDestDir 拷贝到指定的文件夹
     */
    public boolean copyTo(String strSourceFileName, String strDestDir) {
        if (strSourceFileName.equals(strDestDir)) {//源文件和目标文件相同　
            return false;
        }
        File fileSource = new File(strSourceFileName);
        File fileDest = new File(strDestDir);
        // 如果源文件不存或源文件是文件夹
        if (!fileSource.exists() || !fileSource.isFile()) {
            return false;
        }
        // 如果目标文件夹不存在
        if (!fileDest.isDirectory() || !fileDest.exists()) {
            if (!fileDest.mkdirs()) {
                return false;
            }
        }
        FileInputStream fileInput = null;
        FileOutputStream fileOutput = null;
        try {
            String strAbsFilename = strDestDir + File.separator + fileSource.getName();
            fileInput = new FileInputStream(strSourceFileName);
            fileOutput = new FileOutputStream(strAbsFilename);
            int count = -1;
            byte[] data = new byte[BUFFER];
            while (-1 != (count = fileInput.read(data, 0, BUFFER))) {
                fileOutput.write(data, 0, count);
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (fileInput != null) {
                    fileInput.close();
                }
                if (fileOutput != null) {
                    fileOutput.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Title:删除指定的文件
     * @param: strFileName 指定绝对路径的文件名
     * @return: 如果删除成功true否则false
     */
    public static boolean delete(String strFileName) {
        File fileDelete = new File(strFileName);
        if (!fileDelete.exists() || !fileDelete.isFile()) {
            return false;
        }
        return fileDelete.delete();
    }

    /**
     * @return 如果成功true; 否则false
     * @Title:移动文件(只能移动文件)
     * @param: strSourceFileName 是指定的文件全路径名
     * @param: strDestDir 移动到指定的文件夹中
     */
    public boolean moveFile(String strSourceFileName, String strDestDir) {
        if (copyTo(strSourceFileName, strDestDir))
            return FileUtils.delete(strSourceFileName);
        else
            return false;
    }

    /**
     * @return 如果成功true;否则false
     * @Title:创建文件夹
     * @param: strDir 要创建的文件夹名称
     */
    public static boolean makedir(String strDir) {
        File fileNew = new File(strDir);
        if (!fileNew.exists()) {
            return fileNew.mkdirs();
        } else {
            return true;
        }
    }

    /**
     * @return 如果成功true;否则false
     * @Title:删除文件夹
     * @param: strDir 要删除的文件夹名称
     */
    public boolean rmdir(String strDir) {
        File rmDir = new File(strDir);
        if (rmDir.isDirectory() && rmDir.exists()) {
            String[] fileList = rmDir.list();
            for (int i = 0; i < fileList.length; i++) {
                String subFile = strDir + File.separator + fileList[i];
                File tmp = new File(subFile);
                if (tmp.isFile()) {
                    tmp.delete();
                } else if (tmp.isDirectory()) {
                    rmdir(subFile);
                }

            }
            return rmDir.delete();
        } else {
            return false;
        }
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
            log.error("上传文件异常", e);
            return false;
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (Exception e) {
                    log.error("关闭流异常", e);
                }
            }
        }

        return true;
    }

    /**
     * @param in
     * @throws IOException
     * @Title:写文件到本地
     * @param: filePath 上传文件的路径
     */
    public static void uploadFile(InputStream in, String filePath) throws IOException {
        // 如果不存在，就创建文件夹
        if (makedir(filePath)) {
            FileOutputStream fs = null;//
            try {
                fs = new FileOutputStream(filePath);
                byte[] buffer = new byte[1024 * 1024];
                int byteread = 0;
                while ((byteread = in.read(buffer)) != -1) {
                    fs.write(buffer, 0, byteread);
                    fs.flush();
                }
            } finally {
                fs.close();
                in.close();
            }
        }
    }

    private static final double KB_SIZE = 1024;
    private static final double MB_SIZE = KB_SIZE * 1024;
    private static final double GB_SIZE = MB_SIZE * 1024;
    private static final String B = "B";
    private static final String KB = "KB";
    private static final String MB = "MB";
    private static final String GB = "GB";

    /**
     * 获取文件长度描述
     *
     * @param size
     * @return
     */
    public static String getFileSizeStr(long size) {
        if (size >= GB_SIZE) {
            return NumberUtils.formatDouble(size / GB_SIZE, 2) + GB;
        }
        if (size >= MB_SIZE) {
            return NumberUtils.formatDouble(size / MB_SIZE, 2) + MB;
        }
        if (size >= KB_SIZE) {
            return NumberUtils.formatDouble(size / KB_SIZE, 2) + KB;
        }
        return size + B;
    }

    public static byte[] Base64ToByte(String str) {
        byte[] b = null;
        try {
            b = org.apache.commons.codec.binary.Base64.decodeBase64(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;

    }
}