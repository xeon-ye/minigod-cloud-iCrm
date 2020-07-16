package com.sunline.modules.common.utils;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: Pdfbox工具类
 * @author: Larry Lai
 * @date: 2019/1/10 17:05
 * @version: v1.0
 */

public class PdfboxUtils {

    private static final Logger logger = LoggerFactory.getLogger(PdfboxUtils.class);

    /**
     * 合并pdf文件
     *
     * @param files
     * @param destinationFileName
     * @return
     */
    public static boolean mergePdfFiles(String[] files, String destinationFileName) {


        PDFMergerUtility mergePdf = new PDFMergerUtility();
        try {

            for (String file : files) {

                mergePdf.addSource(file);
            }

            mergePdf.setDestinationFileName(destinationFileName);

            mergePdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

            return true;

        } catch (Exception e) {
            logger.error("合成PDF文件失败", e);
        }

        return false;
    }
}
