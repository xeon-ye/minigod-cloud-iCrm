package com.sunline.modules.common.utils;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.util.Map;

/**
 * @author LiYangFeng
 * @createDate 2017/3/6
 * @description
 * @email justbelyf@gmail.com
 */

public class PdfOperater {
    private final static int FIELD_TYPE_FIELD_TYPE_NONE = 0;
    private final static int FIELD_TYPE_BUTTON = 1;
    private final static int FIELD_TYPE_CHECK_BOX = 2;
    private final static int FIELD_TYPE_RADIO_BUTTON = 3;
    private final static int FIELD_TYPE_TEXT_FIELD = 4;
    private final static int FIELD_TYPE_LIST_BOX = 5;
    private final static int FIELD_TYPE_COMBO_BOX = 6;
    private final static int FIELD_TYPE_SIGNATURE = 7;

    static BaseFont defaultFont;

    static {
        try {
            defaultFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean fillFile(String pdfFilePath, String outputPath, Map<String, Object> data) {
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader(pdfFilePath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfStamper pdfStamper = new PdfStamper(pdfReader, bos);
            AcroFields fields = pdfStamper.getAcroFields();
            Map<String, AcroFields.Item> fieldsMap = fields.getFields();
            fields.addSubstitutionFont(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED));
            for (Map.Entry<String, AcroFields.Item> entry : fieldsMap.entrySet()) {
                if (null != fields.getField(entry.getKey()) && StringUtils.isNoneBlank(fields.getField(entry.getKey()))) {
                    continue;
                }

                if (null != data.get(entry.getKey()) && StringUtils.isNoneBlank(data.get(entry.getKey()).toString())) {
                    if (FIELD_TYPE_SIGNATURE == fields.getFieldType(entry.getKey())) {
                        signatureProcess(pdfStamper, entry.getKey(), data.get(entry.getKey()).toString());
                        continue;
                    }

                    fields.setField(entry.getKey(), data.get(entry.getKey()).toString(), true);
                }
            }

            pdfStamper.setFormFlattening(true);
            pdfStamper.close();
            pdfReader.close();
            if (!FileOperaterUtil.fileUpload(outputPath, bos.toByteArray())) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            if (pdfReader != null) {
                pdfReader.close();
            }
        }

        return true;
    }

    private static void signatureProcess(PdfStamper stamper, String fieldName, String value) throws Exception {
        AcroFields form = stamper.getAcroFields();

        // 通过域名获取所在页和坐标，左下角为起点
        AcroFields.FieldPosition fieldPosition = form.getFieldPositions(fieldName).get(0);

        // 读图片
        Image image = Image.getInstance(value);
        // 获取操作的页面
        PdfContentByte under = stamper.getOverContent(fieldPosition.page);
        // 根据域的大小缩放图片
        image.scaleToFit(fieldPosition.position.getWidth(), fieldPosition.position.getHeight());
        // 添加图片
        image.setAbsolutePosition(fieldPosition.position.getLeft(), fieldPosition.position.getBottom());
        under.addImage(image);

    }
}
