package com.ycx.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.sun.deploy.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * easy excel 工具类
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.util
 * @date :       2022/3/10 15:37
 * @copyright :  wpwl
 */
public class EasyExcelUtil {

    private static final Logger logger = LoggerFactory.getLogger(EasyExcelUtil.class);

    public static void writeExcel(HttpServletResponse response, List list, String fileName,
                                  String sheetName, Class clazz) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String reFileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + reFileName + ".xlsx");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            EasyExcel.write(response.getOutputStream(), clazz)
                    .inMemory(true)
                    .sheet(sheetName).doWrite(list);
        } catch (IOException e) {
            logger.error("write excel fail,io exception", e);
        }
    }

    /**
     * 导出excel
     *
     * @param response          输出流
     * @param dataList          导出的数据
     * @param clazz             模板类
     * @param sheetName         sheetName
     * @param cellWriteHandlers 样式处理类
     */
    public static void writeExcelWithRegisterWriteHandler(HttpServletResponse response, List dataList, String fileName,
                                                          String sheetName, Class clazz, SheetWriteHandler
                                                          sheetWriteHandlers, CellWriteHandler... cellWriteHandlers) {
        try {

            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String reFileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + reFileName + ".xlsx");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            //指定文件的输出位置(response.getOutputStream())
            OutputStream outputStream = new FileOutputStream("F:/data/excel/"+fileName+".xlsx");
            writeWithTitleAndSpinnerHandler(outputStream, sheetName, clazz, dataList
                                            , sheetWriteHandlers, cellWriteHandlers);
        } catch (IOException e) {
            logger.error("write excel fail,io exception", e);
        }
    }


    private static void writeWithTitleAndSpinnerHandler(OutputStream outputStream, String sheetName, Class clazz,
                                                        List dataList, SheetWriteHandler sheetWriteHandlers,
                                                        CellWriteHandler[] cellWriteHandlers){

        ExcelWriterSheetBuilder excelWriterSheetBuilder = EasyExcel.write(outputStream, clazz)
                .inMemory(true)
                .registerWriteHandler(sheetWriteHandlers)
                .sheet(sheetName);
        if (null != cellWriteHandlers && cellWriteHandlers.length > 0) {
            for (int i = 0; i < cellWriteHandlers.length; i++) {
                excelWriterSheetBuilder.registerWriteHandler(cellWriteHandlers[i]);
            }
        }
        excelWriterSheetBuilder.doWrite(dataList);
    }

}
