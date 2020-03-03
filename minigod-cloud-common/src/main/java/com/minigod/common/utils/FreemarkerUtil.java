package com.minigod.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Locale;

public class FreemarkerUtil {

    private static Configuration cfg; // 模版配置对象
    private final static Logger logger = LoggerFactory.getLogger(FreemarkerUtil.class);

    static {
        try {
            // 初始化FreeMarker配置
            // 创建一个Configuration实例
            cfg = new Configuration();
            cfg.setDefaultEncoding("UTF-8");
            cfg.setEncoding(Locale.CHINA, "UTF-8");
            // 设置FreeMarker的模版文件夹位置
            cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/");
        } catch (Exception e) {
            logger.error("报表工具初始化错误。", e);
        }
    }

    public static final void exeute(Object map, String templateFile, String outputFile) throws Exception {
        File outFile = new File(outputFile);
        // 如果文件已经存在则不重新生成
        if (outFile.exists()) {
            System.err.println(outputFile + "已经存在，不重新生成");
        } else {
            // 创建模版对象
            Template t = cfg.getTemplate(templateFile);
            t.setEncoding("UTF-8");

            File p = outFile.getParentFile();
            if (!p.exists()) {
                p.mkdirs();
            }
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
            // 在模版上执行插值操作，并输出到制定的输出流中
            t.process(map, writer);
            writer.close();
            System.out.println(outputFile + "生成成功");
        }

    }

    /**
     * 根据模板，生成文本并返回
     *
     * @param object
     * @param templateFile
     * @param outputContent
     * @return
     * @throws Exception
     */
    public static final String exeute4Content(Object object, String templateFile) throws Exception {
        // 创建模版对象
        Template t = cfg.getTemplate(templateFile);
        t.setEncoding("UTF-8");
        StringWriter writer = new StringWriter();
        // 在模版上执行插值操作，并输出到制定的输出流中
        t.process(object, writer);
        String res = writer.toString();
        writer.close();
        return res;
    }
}
