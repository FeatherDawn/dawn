package com.ycx.entity;

import com.ycx.annotation.ExcelStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.entity
 * @date :       2022/3/10 14:44
 * @copyright :  wpwl
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonCallBackData<T> {
    private Font font;
    private CellStyle cellStyle;
    private List<T> dataList;
    private Integer relativeRowIndex;
    private Cell cell;
    private Workbook workbook;
    private Field field;
    private ExcelStyle annotation;
    private Boolean isHead;
    private Boolean isRequire;
}
