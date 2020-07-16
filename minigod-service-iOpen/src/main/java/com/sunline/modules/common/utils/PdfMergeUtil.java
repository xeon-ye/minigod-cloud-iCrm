package com.sunline.modules.common.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;

public class PdfMergeUtil {

    private static final Logger logger = LoggerFactory.getLogger(PdfMergeUtil.class);

    public static boolean mergePdfFiles(String[] files, String newfile) {
        boolean retValue = false;
        Document document = null;
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader(files[0]);
            document = new Document(pdfReader.getPageSize(1));
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));
            document.open();
            for (int i = 0; i < files.length; i++) {
                PdfReader reader = new PdfReader(files[i]);
                int n = reader.getNumberOfPages();
                for (int j = 1; j <= n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
                reader.close();
            }
            retValue = true;
        } catch (Exception e) {
            logger.error("合成PDF文件失败", e);
        } finally {
            if (null != pdfReader) {
                pdfReader.close();
            }
            if (null != document) {
                document.close();
            }
        }
        return retValue;
    }
}
