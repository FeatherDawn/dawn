package com.ycx.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.ycx.annotation.ExcelStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.entity
 * @date :       2022/3/10 16:11
 * @copyright :  wpwl
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExcelImport extends BaseType {
    /**
     * 父id
     */
    @ExcelIgnore
    private Long parentId;

    /**
     * 全量分类编码
     */
    @ExcelProperty(index = 0,value = {"父级分类编码"})
    @ColumnWidth(20)
    @ExcelStyle(richText = true,isRequire = true)
    private String parentClassifyCode;

    /**
     * 分类编码
     */
    @ExcelProperty(index = 1,value = {"分类编码"})
    @ColumnWidth(15)
    private String classifyCode;

    /**
     * 分类名
     */
    @ExcelProperty(index = 2,value = {"分类名称"})
    @ColumnWidth(15)
    private String classifyName;

    /**
     * 备注信息
     */
    @ExcelProperty(index = 3,value = {"备注信息"})
    @ColumnWidth(30)
    private String classifyDesc;


    @ExcelIgnore
    private Integer isEnabled;

    /**
     * 是否启用
     */
    @ExcelProperty(index = 4,value = {"是否启用"})
    @ColumnWidth(10)
    private String isEnabledValue;

    /**
     * 图片url
     */
    @ExcelProperty(index = 5,value = {"图片url"})
    @ColumnWidth(20)
    private String image;

    /**
     * 失败原因
     */
    @ExcelProperty(index = 6,value = {"失败原因"})
    @ColumnWidth(20)
    @ExcelStyle(isRequire = false)
    private String reason;

    @Override
    public Boolean isGetCellStyle() {
        return true;
    }

    @Override
    public Boolean isGetRich() {
        return true;
    }
}
