package com.sunline.modules.fund.helper;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 支票打印
 * @author: Larry Lai
 * @date: 2019/6/13 15:22
 * @version: v1.0
 */

public class DrawChequeGenerate {

    private static final Logger logger = LoggerFactory.getLogger(DrawChequeGenerate.class);

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###,##0.00#");

    private static Double dpiPerCm = 100 / 2.54;
    private static Double width = 15.8 * dpiPerCm;
    private static Double height = 8.2 * dpiPerCm;

    /**
     * 描绘图片
     *
     * @param list
     * @param params
     * @return
     */
    public static String draw(List<ClientFundWithdrawApplyEntity> list, Map<String, String> params) {

        String filePath = ConfigUtils.get("crm.file.path") + "fund/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + Utils.uuid() + "/";

        try {
            File targetOutPath = new File(filePath);
            if (!targetOutPath.exists()) {
                targetOutPath.mkdirs();
            }

            int i = 1;

            for (ClientFundWithdrawApplyEntity data : list) {

                BufferedImage image = new BufferedImage(width.intValue(), height.intValue(), BufferedImage.TYPE_INT_RGB);

                Graphics g = image.getGraphics();
                Color color = g.getColor();
                g.setColor(Color.white);
                g.fillRect(0, 0, width.intValue(), height.intValue());
                g.setColor(Color.black);

                // 画姓名
                if ("0".equals(params.get("nameType"))) {
                    g.setFont(chooseFontSize(g, "宋体", Font.PLAIN, 20, data.getClientNameSpell(), Double.valueOf(10 * dpiPerCm).intValue()));
                    g.drawString(data.getClientNameSpell(), new Double(2.2 * dpiPerCm).intValue(), new Double(2.8 * dpiPerCm).intValue());
                } else {
                    g.setFont(chooseFontSize(g, "宋体", Font.PLAIN, 20, data.getClientName(), Double.valueOf(10 * dpiPerCm).intValue()));
                    g.drawString(data.getClientName(), new Double(2.2 * dpiPerCm).intValue(), new Double(2.8 * dpiPerCm).intValue());
                }

                Font font = new Font("宋体", Font.PLAIN, 20);
                g.setFont(font);
                // 画左边的金额
                g.drawString(DECIMAL_FORMAT.format(data.getActualBalance()), new Double(2.7 * dpiPerCm).intValue(), new Double(3.8 * dpiPerCm).intValue());
                // 画右边的金额
                g.drawString(DECIMAL_FORMAT.format(data.getActualBalance()), new Double(12 * dpiPerCm).intValue(), new Double(4.1 * dpiPerCm).intValue());

                // 画日期
                if ("1".equals(params.get("chequeType"))) {
                    g.drawString(params.get("day"), new Double(12.2 * dpiPerCm).intValue(), new Double(2.2 * dpiPerCm).intValue());
                    g.drawString(params.get("month"), new Double(13.2 * dpiPerCm).intValue(), new Double(2.2 * dpiPerCm).intValue());
                    g.drawString(params.get("year"), new Double(14.2 * dpiPerCm).intValue(), new Double(2.2 * dpiPerCm).intValue());
                } else if ("2".equals(params.get("chequeType"))) {
                    g.drawString(params.get("day"), new Double(10.7 * dpiPerCm).intValue(), new Double(1.6 * dpiPerCm).intValue());
                    g.drawString(params.get("month"), new Double(12.2 * dpiPerCm).intValue(), new Double(1.6 * dpiPerCm).intValue());
                    g.drawString(params.get("year"), new Double(13.7 * dpiPerCm).intValue(), new Double(1.6 * dpiPerCm).intValue());
                }


                // 90度翻转图片
//                int w = image.getWidth();
//                int h = image.getHeight();
//                int type = image.getColorModel().getTransparency();
//                BufferedImage img;
//                Graphics2D graphics2d;
//                (graphics2d =
//                        (img = new BufferedImage(h, w, type)).createGraphics()
//                ).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//                graphics2d.rotate(Math.toRadians(270), w / 2, h / 2 + (w - h) / 2);
//                graphics2d.drawImage(image, 0, 0, null);
//                graphics2d.dispose();

                String fileName = i + ".jpg";
                ImageIO.write(image, "jpg", new File(filePath + fileName));

                i++;
            }

        } catch (Exception e) {
            logger.error("生成支票图片异常", e);
        }

        return filePath;
    }

    /**
     * 填充pdf模板
     *
     * @param templatePath
     * @param bufferedImage
     * @return
     */
    public static ByteArrayOutputStream fillTemplate(String templatePath, BufferedImage bufferedImage) {
        PdfReader reader;
        ByteArrayOutputStream bos = null;
        PdfStamper stamper;
        try {
            if (bufferedImage != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpeg", baos);
                // 读取pdf模板
                reader = new PdfReader(templatePath);
                bos = new ByteArrayOutputStream();
                stamper = new PdfStamper(reader, bos);
                AcroFields form = stamper.getAcroFields();

                Rectangle rectangle = form.getFieldPositions("pic").get(0).position;

                int pageNo = form.getFieldPositions("pic").get(0).page;
                // 获取操作的页面
                PdfContentByte under = stamper.getOverContent(pageNo);
                Image image = Image.getInstance(baos.toByteArray());

                float leftMargin = 6.4f;
                float rightMargin = 0.1f;
                image.setAbsolutePosition(rectangle.getLeft(), rectangle.getBottom());
                image.setRotationDegrees(-270);
                image.scaleToFit(rectangle);

                under.addImage(image);

                // 如果为false那么生成的PDF文件还能编辑，一定要设为true
                stamper.setFormFlattening(true);
                stamper.getWriter().flush();
                stamper.close();
                return bos;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 生成pdf文件
     *
     * @param files
     * @return
     */
    private static String makePdf(File[] files) {

        // 创建一个文档对象
        Document doc = new Document(PageSize.A4);
        FileOutputStream outputStream = null;

        try {

            // 定义输出位置并把文档对象装入输出对象中
            outputStream = new FileOutputStream(ConfigUtils.get("template.file.path") + "/fund/fund_withdraw_cheque_template.pdf");
            PdfWriter.getInstance(doc, outputStream);

            // 打开文档对象
            doc.open();

            for (File file : files) {

                // 加入图片
                Image jpg = Image.getInstance(file.getPath());
                jpg.setAlignment(Image.ALIGN_CENTER);
                doc.add(jpg);
            }

        } catch (Exception e) {
            logger.error("生成pdf文件异常", e);
        } finally {
            doc.close();
        }

        return null;
    }

    /**
     * 字体设置
     *
     * @param g
     * @param fontName
     * @param fontStyle
     * @param fontSize
     * @param data
     * @param maxLen
     * @return
     */
    private static Font chooseFontSize(Graphics g, String fontName, int fontStyle, int fontSize, String data, int maxLen) {
        Font font = new Font(fontName, fontStyle, fontSize);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        if (fm.stringWidth(data) > maxLen) {
            return chooseFontSize(g, fontName, fontStyle, fontSize - 1, data, maxLen);
        } else {
            return font;
        }
    }

    public static void main(String[] args) {

        List<ClientFundWithdrawApplyEntity> list = Lists.newArrayList();
        ClientFundWithdrawApplyEntity entity = new ClientFundWithdrawApplyEntity();
        entity.setClientNameSpell("LAIJIEQIANG1");
        entity.setOccurBalance(new BigDecimal(11.11));
        entity.setChequeType(1);
        entity.setDay("13");
        entity.setMonth("Jan");
        entity.setYear("2019");

        list.add(entity);

        entity = new ClientFundWithdrawApplyEntity();
        entity.setClientNameSpell("LAIJIEQIANG2");
        entity.setOccurBalance(new BigDecimal(22.22));
        entity.setChequeType(2);
        entity.setDay("08");
        entity.setMonth("June");
        entity.setYear("2018");

        list.add(entity);

        Map<String, String> params = Maps.newHashMap();
        params.put("chequeType", "1");
        params.put("day", "14");
        params.put("month", "June");
        params.put("year", "2019");

        String filePath = draw(list, params);

        File[] files = FileUtil.ls(filePath);

        if (files.length > 0) {
            makePdf(files);
        }

        String srcFilePath = ConfigUtils.get("template.file.path") + "/fund/fund_withdraw_cheque_template.pdf";
        String destFilePath = ConfigUtils.get("crm.file.path") + "/fund/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + Utils.uuid() + ".pdf";

        File file = FileUtil.copy(srcFilePath, destFilePath, true);

        System.out.println(file.getPath());
    }
}
