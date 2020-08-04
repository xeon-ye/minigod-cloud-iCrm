package com.sunline.modules.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class AttachUtil {
    private final static Logger logger = LoggerFactory.getLogger(AttachUtil.class);

    private AttachUtil() {
    }





    /**
     * 获取根目录
     * @return String
     */
    public static String getContextRoot() {
        ClassLoader classLoader = AttachUtil.class.getClassLoader();
        URL url = classLoader.getResource("ApplicationResources.properties");
        String t = null;
        t = url.getPath();
        logger.debug("资源目录：" + t);

        //window------>file:/D:/bea/../applications/km.war/WEB-INF/classes/ApplicationResources.properties
        //linux------->/opt/bea/../applications/km.war/WEB-INF/classes/ApplicationResources.properties
        if (t.indexOf("file:") != -1) {
            t = t.substring(5, t.length());
        }
        if (t.indexOf("WEB-INF") != -1) {
            t = t.substring(0, t.indexOf("WEB-INF"));
        }
        logger.debug("根目录：" + t);
        return t;
    }



    public static void main(String[] args) {
//        String sourcePath = "d:\\\\test\\\\\\ttt\\\\\\\\yy\\hhh///aa//bb"
//                            + AttachConstant.FILE_SEPARATOR + "kk" + AttachConstant.FILE_SEPARATOR + null;
//        System.out.println(sourcePath);
//        System.out.println(adaptPath4OS(sourcePath));
//        System.out.println(sourcePath);
//        System.out.println(parseAutoPath(null));
//        getArray("::123456::22346::323456::", "::");
    }


}
