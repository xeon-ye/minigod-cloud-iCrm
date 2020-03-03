package com.minigod.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

/**
 * @description: TODO
 * @author: Peng Feng
 * @date: 2018/8/3 9:45
 * @version: v1.0
 */

public class ImageUtils {

    private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);

    public static byte[] generateImage(String _imgStr) { // 对字节数组字符串进行Base64解码并生成图片
        String header = "data:image/jpeg;base64,";
        if (_imgStr == null || _imgStr.length() < header.length()) // 图像数据为空
            return null;
        String imgStr = _imgStr.substring(header.length());
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = null;
        try {
            // Base64解码
            b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }

        } catch (Exception e) {
            logger.error("base64转字节数组错误", e);
        }
        return b;
    }
}
