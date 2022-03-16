package com.ycx.entity;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.util.List;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.entity
 * @date :       2022/3/10 15:32
 * @copyright :  wpwl
 */
public class TypeConsumer <T extends BaseType>{

    public void richTextConsumer(CommonCallBackData<T> callBackData) {
        if (Boolean.TRUE.equals(callBackData.getIsHead())) {
            setRequireField(callBackData, "*");
            return;
        }
        Integer relativeRowIndex = callBackData.getRelativeRowIndex();
        List<T> dataList = callBackData.getDataList();
        T dto = dataList.get(relativeRowIndex);
        if (Boolean.TRUE.equals(dto.isGetRich())) {
            setRequireField(callBackData, "富文本");
        }
    }

    private static<T> void setRequireField(CommonCallBackData<T> callBackData, String markWord) {

        if (callBackData.getAnnotation().isRequire() == false) {
            return;
        }
        Workbook workbook = callBackData.getWorkbook();
        Cell cell = callBackData.getCell();
        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);
        String big = markWord;
        String value = cell.getStringCellValue() + big;
        int index = value.lastIndexOf(big);
        //将*三个字设置为红色字体
        RichTextString richTextString = new XSSFRichTextString(value);
        richTextString.applyFont(index, index + 1, font);
        cell.setCellValue(richTextString);
    }




    public  void cellStyleTextConsumer(CommonCallBackData<T> callBackData) {
        Integer relativeRowIndex = callBackData.getRelativeRowIndex();
        List<T> dataList = callBackData.getDataList();
        if(CollectionUtils.isEmpty(dataList)){
            return;
        }
        T dto = dataList.get(relativeRowIndex);
        if (Boolean.TRUE.equals(dto)) {
            CellStyle cellStyle = callBackData.getCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
        }
    }

}
