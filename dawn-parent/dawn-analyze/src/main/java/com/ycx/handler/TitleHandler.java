package com.ycx.handler;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.ycx.annotation.ExcelStyle;
import com.ycx.entity.CommonCallBackData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.handler
 * @date :       2022/3/10 14:48
 * @copyright :  wpwl
 */
public class TitleHandler<T> implements CellWriteHandler {

    private static final Logger logger = LoggerFactory.getLogger(TitleHandler.class);

    private Class<?> c;
    private List<T> dataList;
    private Consumer<CommonCallBackData<T>> fontConsumer;
    private Consumer<CommonCallBackData<T>> cellStyleConsumer;
    private Consumer<CommonCallBackData<T>> richTextConsumer;
    private List<Integer> hiddenColumnIndexes;

    public TitleHandler(Class<?> c, List<T> dataList, Consumer<CommonCallBackData<T>> fontConsumer,
                        Consumer<CommonCallBackData<T>> cellStyleConsumer,
                        Consumer<CommonCallBackData<T>> richTextConsumer, List<Integer> hiddenColumnIndexes) {
        this.c = c;
        this.dataList = dataList;
        this.fontConsumer = fontConsumer;
        this.cellStyleConsumer = cellStyleConsumer;
        this.richTextConsumer = richTextConsumer;
        this.hiddenColumnIndexes = hiddenColumnIndexes;
    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
                                 List<WriteCellData<?>> cellDataList, Cell cell, Head head,
                                 Integer relativeRowIndex, Boolean isHead) {
        //如果是头部
        if (isHead){
            try {
                //获取字段名称
                Field declaredField = c.getDeclaredField(head.getFieldName());
                ExcelStyle annotation = declaredField.getAnnotation(ExcelStyle.class);
                if (annotation != null) {
                    Workbook workbook = cell.getSheet().getWorkbook();
                    CellStyle cellStyle = workbook.createCellStyle();
                    cell.setCellStyle(cellStyle);
                    Font font = workbook.createFont();
                    CommonCallBackData<T> callBackData = create(font, cellStyle, cell.getRowIndex(), cell,
                            workbook, annotation, declaredField, isHead);
                    font.setFontName(annotation.fontName());
                    font.setFontHeightInPoints(annotation.fontHeightInPoints());
                    if (fontConsumer != null) {
                        fontConsumer.accept(callBackData);
                    }
                    cellStyle.setFont(font);
                    cellStyle.setAlignment(annotation.horizontalAlignment());
                    cellStyle.setVerticalAlignment(annotation.verticalAlignment());
                    cellStyle.setWrapText(annotation.wrapText());

                    boolean richText = annotation.richText();
                    if (richText && richTextConsumer != null) {
                        richTextConsumer.accept(callBackData);
                    }

                    if (cellStyleConsumer != null){
                        cellStyleConsumer.accept(callBackData);
                    }

                    if (CollectionUtils.isNotEmpty(hiddenColumnIndexes)){
                        for (Integer hiddenColumnIndex : hiddenColumnIndexes) {
                            writeSheetHolder.getSheet().setColumnHidden(hiddenColumnIndex,true);
                        }
                    }
                }
            } catch (NoSuchFieldException e) {
                logger.error("ExcelStyleAnnotationCellWriteHandler error:",e);
            }
        }
    }


    private CommonCallBackData<T> create(Font font, CellStyle cellStyle, Integer relativeRowIndex, Cell cell,
                                         Workbook workbook, ExcelStyle annotation, Field field, Boolean isHead){
        CommonCallBackData<T> callBackData = new CommonCallBackData<>();
        callBackData.setFont(font);
        callBackData.setCellStyle(cellStyle);
        callBackData.setRelativeRowIndex(relativeRowIndex);
        callBackData.setDataList(this.dataList);
        callBackData.setCell(cell);
        callBackData.setWorkbook(workbook);
        callBackData.setAnnotation(annotation);
        callBackData.setField(field);
        callBackData.setIsHead(isHead);
        return callBackData;
    }
}
