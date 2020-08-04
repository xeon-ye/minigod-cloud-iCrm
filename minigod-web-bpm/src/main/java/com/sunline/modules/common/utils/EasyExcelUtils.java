package com.sunline.modules.common.utils;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: easyExcel操作工具类
 * @author: Larry Lai
 * @date: 2018/11/13 14:54
 * @version: v1.0
 */

public class EasyExcelUtils {

    private static final Logger logger = LoggerFactory.getLogger(EasyExcelUtils.class);

    /**
     * 导出xlsx文件
     *
     * @param list
     * @param response
     * @param clazz
     * @return
     */
    public static void exportXlsxFile(List<? extends BaseRowModel> list, HttpServletResponse response, Class<? extends BaseRowModel> clazz) throws IOException {

        String fileName = DateUtil.format(new Date(), "yyyyMMddHHmmssSSS");

        response.setCharacterEncoding("utf-8");

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("datagrid_" + fileName + ".xlsx", "utf-8"));

        ServletOutputStream out = response.getOutputStream();

        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);

        try {

            Sheet sheet1 = new Sheet(1, 0, clazz, "sheet", null);
            sheet1.setSheetName("sheet1");

            writer.write(list, sheet1);

            out.flush();

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        } finally {
            writer.finish();
            try {
                out.close();
            } catch (IOException e) {
                logger.error("导出Excel文件异常", e);
            }
        }
    }

    /**
     * 导出xlsx文件
     *
     * @param list
     * @param response
     * @param clazz
     * @return
     */
    public static void exportXlsxFile(List<? extends BaseRowModel> list, HttpServletResponse response, Class<? extends BaseRowModel> clazz,String fileName) throws IOException {

        response.setCharacterEncoding("utf-8");

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "utf-8").replace("+","%20"));

        ServletOutputStream out = response.getOutputStream();

        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);

        try {

            Sheet sheet1 = new Sheet(1, 0, clazz, "sheet", null);
            sheet1.setSheetName("sheet1");

            writer.write(list, sheet1);

            out.flush();

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        } finally {
            writer.finish();
            try {
                out.close();
            } catch (IOException e) {
                logger.error("导出Excel文件异常", e);
            }
        }
    }

    /**
     * 导出xls文件
     *
     * @param list
     * @param response
     * @param clazz
     * @return
     */
    public static void exportXlsFile(List<? extends BaseRowModel> list, HttpServletResponse response, Class<? extends BaseRowModel> clazz) throws IOException {

        String fileName = DateUtil.format(new Date(), "yyyyMMddHHmmssSSS");

        response.setCharacterEncoding("utf-8");

        response.setContentType("application/vnd.ms-excel");

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("datagrid_" + fileName + ".xls", "utf-8"));

        ServletOutputStream out = response.getOutputStream();

        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLS, true);

        try {

            Sheet sheet1 = new Sheet(1, 0, clazz, "sheet", null);
            sheet1.setSheetName("sheet1");

            writer.write(list, sheet1);

            out.flush();

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        } finally {
            writer.finish();
            try {
                out.close();
            } catch (IOException e) {
                logger.error("导出Excel文件异常", e);
            }
        }
    }

    /**
     * 自定义表头导出xlsx文件
     *
     * @param list
     * @param headers
     * @param response
     * @throws IOException
     */
    public static void expDefinedHeaderXlsxFile(List<List<String>> list, List<List<String>> headers, HttpServletResponse response) throws IOException {

        String fileName = DateUtil.format(new Date(), "yyyyMMddHHmmssSSS");

        response.setCharacterEncoding("utf-8");

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("datagrid_" + fileName + ".xlsx", "utf-8"));

        ServletOutputStream out = response.getOutputStream();

        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);

        try {

            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");

            Table table = new Table(1);
            table.setHead(headers);

            writer.write0(list, sheet1, table);

            out.flush();

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        } finally {
            writer.finish();
            try {
                out.close();
            } catch (IOException e) {
                logger.error("导出Excel文件异常", e);
            }
        }
    }

    /**
     * 从Excel中读取文件，读取的文件是一个DTO类，该类必须继承BaseRowModel
     * 具体实例参考 ： MemberMarketDto.java
     * 参考：https://github.com/alibaba/easyexcel
     * 字符流必须支持标记，FileInputStream 不支持标记，可以使用BufferedInputStream 代替
     * BufferedInputStream bis = new BufferedInputStream(new FileInputStream(...));
     *
     * @param inputStream 文件输入流
     * @param clazz       继承该类必须继承BaseRowModel的类
     * @return 读取完成的list
     */
    public static <T extends BaseRowModel> List<T> readExcel(InputStream inputStream, Class<? extends BaseRowModel> clazz, int readLine) {
        if (null == inputStream) {
            throw new NullPointerException("the inputStream is null!");
        }
        AnalysisEventListener listener = new ExcelListener();
        //读取xls 和 xlxs格式
        //如果POI版本为3.17，可以如下声明
        ExcelReader reader = new ExcelReader(inputStream, null, listener);
        //判断格式，针对POI版本低于3.17
//        ExcelTypeEnum excelTypeEnum = valueOf(inputStream);
//        ExcelReader reader = new ExcelReader(inputStream, excelTypeEnum, null, listener);
        Sheet sheet = new Sheet(1, readLine, clazz);
        reader.read(sheet);

        return ((ExcelListener) listener).getData();
    }

    /**
     * 需要写入的Excel，有模型映射关系
     *
     * @param file 需要写入的Excel，格式为xlsx
     * @param list 写入Excel中的所有数据，继承于BaseRowModel
     */
    public static void writeExcel(final File file, List<? extends BaseRowModel> list) throws FileNotFoundException {
        OutputStream out = new FileOutputStream(file);
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //写第一个sheet,  有模型映射关系
            Class t = list.get(0).getClass();
            Sheet sheet = new Sheet(1, 0, t);
            writer.write(list, sheet);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 根据输入流，判断为xls还是xlsx，该方法原本存在于easyexcel 1.1.0 的ExcelTypeEnum中。
     * 如果POI版本为3.17以下，则FileMagic会报错，找不到该类，此时去到POI 3.17中将FileMagic抽取出来
     */
    public static ExcelTypeEnum valueOf(InputStream inputStream) {
        try {
            FileMagic fileMagic = FileMagic.valueOf(inputStream);
            if (FileMagic.OLE2.equals(fileMagic)) {
                return ExcelTypeEnum.XLS;
            }
            if (FileMagic.OOXML.equals(fileMagic)) {
                return ExcelTypeEnum.XLSX;
            }
            throw new IllegalArgumentException("excelTypeEnum can not null");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @version V1.0
     * @description 处理Excel，将读取到数据保存为对象并输出
     */
    static class ExcelListener<T extends BaseRowModel> extends AnalysisEventListener<T> {
        /**
         * 自定义用于暂时存储data。
         * 可以通过实例获取该值
         */
        private final List<T> data = new ArrayList<>();

        @Override
        public void invoke(T object, AnalysisContext context) {
            //数据存储
            data.add(object);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {

        }

        public List<T> getData() {
            return data;
        }

    }

}
