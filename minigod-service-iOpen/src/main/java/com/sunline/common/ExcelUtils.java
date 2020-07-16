package com.sunline.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * @author LiYangFeng
 * @createDate 2018/4/26
 * @description
 * @email justbelyf@gmail.com
 */
public class ExcelUtils {
    public static String NO_DEFINE = "no_define";//未定义的字段
    public static String DEFAULT_DATE_PATTERN = "yyyy年MM月dd日";//默认日期格式
    public static int DEFAULT_COLOUMN_WIDTH = 17;
    private static int MAX_ROW_NUMBER_OF_SHEET = 65535;


    /**
     * 通用列表数据导出
     * 导出Excel 2007 OOXML (.xlsx)格式
     *
     * @param headMap 属性-列头
     * @param data    数据集
     * @param out     输出流
     */
    public static void commonListExport(Map<String, String> headMap, JSONArray data, OutputStream out) {
//        // 声明一个工作薄
//        SXSSFWorkbook workbook = new SXSSFWorkbook();
//        workbook.setCompressTempFiles(true);
//        //表头样式
//        CellStyle titleStyle = workbook.createCellStyle();
//        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        Font titleFont = workbook.createFont();
//        titleFont.setFontHeightInPoints((short) 20);
//        titleFont.setBoldweight((short) 700);
//        titleStyle.setFont(titleFont);
//        // 列头样式
//        CellStyle headerStyle = workbook.createCellStyle();
//        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        headerStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
//        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//
//        Font headerFont = workbook.createFont();
//        headerFont.setFontHeightInPoints((short) 12);
//        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//        headerStyle.setFont(headerFont);
//        // 单元格样式
//        CellStyle cellStyle = workbook.createCellStyle();
////        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
//        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//        Font cellFont = workbook.createFont();
//        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
//        cellStyle.setFont(cellFont);
//
//
//        SXSSFSheet sheet = null;
//        int rowNumber = 0;
//        for (int i = 0; i < data.size(); i++) {
//            if (0 == rowNumber) {
//                int columnNumber = 0;
//                sheet = createDefaultSheet(workbook, headMap);
//                //列头
//                SXSSFRow headerRow = sheet.createRow(0);
//                for (String filedName : headMap.keySet()) {
//                    headerRow.createCell(columnNumber).setCellValue(headMap.get(filedName));
//                    headerRow.getCell(columnNumber).setCellStyle(headerStyle);
//                    columnNumber++;
//                }
//
//                rowNumber++;
//            }
//
//            Object rowData = data.get(i);
//            JSONObject rowDataJson = (JSONObject) JSONObject.toJSON(rowData);
//            SXSSFRow dataRow = sheet.createRow(rowNumber);
//            int columnNumber = 0;
//            for (String filedName : headMap.keySet()) {
//                SXSSFCell newCell = dataRow.createCell(columnNumber);
//                Object filedValue = rowDataJson.get(filedName);
//                newCell.setCellValue(parseValue(filedValue));
//                newCell.setCellStyle(cellStyle);
//                columnNumber++;
//            }
//
//            rowNumber++;
//        }
//
//        try {
//            workbook.write(out);
//            workbook.close();
//            workbook.dispose();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static SXSSFSheet createDefaultSheet(SXSSFWorkbook workbook, Map<String, String> headMap) {

        SXSSFSheet sheet = workbook.createSheet();
        //设置列宽
        int minBytes = DEFAULT_COLOUMN_WIDTH;//至少字节数

        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽

        int filedIndex = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter.hasNext(); ) {
            String fieldName = iter.next();

            int bytes = fieldName.getBytes().length;
            arrColWidth[filedIndex] = bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(filedIndex, arrColWidth[filedIndex] * 256);
            filedIndex++;
        }

        return sheet;
    }

    private static String parseValue(Object object) {
        if (object == null) {
            return "";
        } else if (object instanceof Date) {
            return new SimpleDateFormat(DEFAULT_DATE_PATTERN).format(object);
        } else if (object instanceof Float || object instanceof Double) {
            return new BigDecimal(object.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        } else {
            return object.toString();
        }

    }


    //Web 导出excel
//    public static void downloadExcelFile(String title, Map<String, String> headMap, JSONArray ja, HttpServletResponse response) {
//        try {
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            ExcelUtils.exportExcelX(title, headMap, ja, null, 0, os);
//            byte[] content = os.toByteArray();
//            InputStream is = new ByteArrayInputStream(content);
//            // 设置response参数，可以打开下载页面
//            response.reset();
//
//            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
//            response.setHeader("Content-Disposition", "attachment;filename=" + new String((title + ".xlsx").getBytes(), "iso-8859-1"));
//            response.setContentLength(content.length);
//            ServletOutputStream outputStream = response.getOutputStream();
//            BufferedInputStream bis = new BufferedInputStream(is);
//            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
//            byte[] buff = new byte[8192];
//            int bytesRead;
//            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                bos.write(buff, 0, bytesRead);
//
//            }
//            bis.close();
//            bos.close();
//            outputStream.flush();
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}
