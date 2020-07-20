package com.sunline.modules.common.utils;

import cn.hutool.core.date.DateUtil;
import com.sunline.modules.common.page.PageData;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Excel导入导出工具类
 * User: Larry Lai
 * Date: 2016-10-10
 * Version: 1.0
 */

public class ObjectExcelView {

	protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
//		String fileName = DateUtil.format(new Date(), "yyyyMMddHHmmssSSS");
//		HSSFSheet sheet;
//		HSSFCell cell;
//		response.setContentType("application/octet-stream");
//		response.setHeader("Content-Disposition", "attachment;filename="+ "datagrid_" +fileName+".xls");
//		sheet = workbook.createSheet("sheet1");
//
//		List<String> titles = (List<String>) model.get("titles");
//		int len = titles.size();
//        // 标题样式
//		HSSFCellStyle headerStyle = workbook.createCellStyle();
//		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//        // 标题字体
//		HSSFFont headerFont = workbook.createFont();
//		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//		headerFont.setFontHeightInPoints((short)11);
//        headerFont.setFontName("宋体");
//		headerStyle.setFont(headerFont);
//        headerStyle.setBorderTop((short) 1);
//        headerStyle.setBorderBottom((short) 1);
//        headerStyle.setBorderLeft((short) 1);
//        headerStyle.setBorderRight((short) 1);
//		short width = 20,height=25*20;
//		sheet.setDefaultColumnWidth(width);
//        // 设置标题
//		for(int i=0; i<len; i++){
//			String title = titles.get(i);
//			cell = getCell(sheet, 0, i);
//			cell.setCellStyle(headerStyle);
//			setText(cell,title);
//		}
//		sheet.getRow(0).setHeight(height);
//
//        // 内容样式
//		HSSFCellStyle contentStyle = workbook.createCellStyle();
//        // 内容字体
//        HSSFFont contentFont = workbook.createFont();
//        contentFont.setFontHeightInPoints((short)11);
//        contentFont.setFontName("宋体");
//        contentStyle.setFont(contentFont);
//        contentStyle.setBorderTop((short) 1);
//        contentStyle.setBorderBottom((short) 1);
//        contentStyle.setBorderLeft((short) 1);
//        contentStyle.setBorderRight((short) 1);
//		List<PageData> varList = (List<PageData>) model.get("varList");
//		int varCount = varList.size();
//		for(int i=0; i<varCount; i++){
//			PageData vpd = varList.get(i);
//			for(int j=0;j<len;j++){
//				String varstr = vpd.getString("var"+(j+1)) != null ? vpd.getString("var"+(j+1)) : "";
//				cell = getCell(sheet, i+1, j);
//				cell.setCellStyle(contentStyle);
//				setText(cell,varstr);
//			}
//		}
	}
}
