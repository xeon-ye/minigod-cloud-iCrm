package com.sunline.modules.account.online.helper;

import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: 图片合成工具类
 * @author: Larry Lai
 * @date: 2019/3/5 17:07
 * @version: v1.0
 */

public class OpenImgGraphicsGenerate {

    private static Log logger = LogFactory.getLog(OpenImgGraphicsGenerate.class);

    private BufferedImage image;

    /**
     * 图片的宽度
     */
    private final int IMAGE_WIDTH = 936;
    /**
     * 图片的高度
     */
    private final int IMAGE_HEIGHT = 837;

    /**
     * 生成图片文件
     *
     * @param fileLocation
     */
    @SuppressWarnings("restriction")
    private void createImage(String fileLocation) {
        BufferedOutputStream bos = null;
        if (image != null) {
            try {
                FileOutputStream fos = new FileOutputStream(fileLocation);
                bos = new BufferedOutputStream(fos);

                String formatName = fileLocation.substring(fileLocation.lastIndexOf(".") + 1);

                ImageIO.write(image, formatName , new File(fileLocation) );

                bos.close();
            } catch (Exception e) {
                logger.error("生成图片文件异常", e);
            } finally {
                if (bos != null) {
                    try {
                        bos.close();
                    } catch (IOException e) {
                        logger.error("关闭流异常", e);
                    }
                }
            }
        }
    }


    /**
     * 描绘图片
     *
     * @param imgUrl
     */
    public void graphicsGenerate(String imgUrl, String outPath, CustomerAccountOpenInfoEntity customerAccountOpenInfo) {
        // 头部高度
        int headHeight = 30;
        // 文字行高
        int fontRowHeight = 400;
        // 间隔高度
        int intervalHeight = 60;
        // 内容栏高度
        int contentHeight = (headHeight + fontRowHeight);
        // 行高基数
        int rowHeight = contentHeight + intervalHeight + 20;

        image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 设置图片的背景色
        Graphics2D main = image.createGraphics();
        main.setColor(Color.white);
        main.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        // 插入图片
        Graphics mainPic = image.getGraphics();
        BufferedImage buFImg = null;
        try {
            buFImg = ImageIO.read(new File(imgUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (buFImg != null) {
            mainPic.drawImage(buFImg, 0, headHeight, IMAGE_WIDTH, fontRowHeight, null);
            mainPic.dispose();
        }

        Graphics2D content = image.createGraphics();
        // 设置区域颜色
        content.setColor(Color.black);
        // 填充区域并确定区域大小位置
        content.fillRect(0, contentHeight, IMAGE_WIDTH, 1);

        // 设置字体颜色，先设置颜色，再填充内容
        content.setColor(Color.black);
        Font contentFont = new Font("微软雅黑", Font.PLAIN, 24);
        content.setFont(contentFont);
        content.drawString("中文姓名：" + customerAccountOpenInfo.getClientName(), 50, rowHeight);
        content.drawString("拼音/英文姓名：" + customerAccountOpenInfo.getClientNameSpell(), 50, rowHeight + 60);
        content.drawString("证件号码：" + customerAccountOpenInfo.getIdNo(), 50, rowHeight + 120);
        content.drawString("手机号码：" + customerAccountOpenInfo.getPhoneNumber(), 50, rowHeight + 180);
        content.drawString("邮箱地址：" + customerAccountOpenInfo.getEmail(), 50, rowHeight + 240);

        // 创建图片
        createImage(outPath);
    }

    public static void main(String[] args) {
        OpenImgGraphicsGenerate cg = new OpenImgGraphicsGenerate();

        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = new CustomerAccountOpenInfoEntity();

        customerAccountOpenInfoEntity.setClientName("赖洁强");
        customerAccountOpenInfoEntity.setClientNameSpell("LAIJIEQIANG");
        customerAccountOpenInfoEntity.setIdNo("123456789012345678");
        customerAccountOpenInfoEntity.setPhoneNumber("13800138000");
        customerAccountOpenInfoEntity.setEmail("aljqiang@163.com");

        try {
            cg.graphicsGenerate("F:\\workRecord\\0304\\sign.jpg", "F:\\workRecord\\0305\\signInfo123.jpg", customerAccountOpenInfoEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
