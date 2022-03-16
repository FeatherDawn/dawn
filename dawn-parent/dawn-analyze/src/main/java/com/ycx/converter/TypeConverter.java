package com.ycx.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 *
 * @author :     guowc
 * @package :    com.ycx.converter
 * @date :       2022/3/11 10:39
 * @version :    1.0
 * @copyright :  wpwl
 */
public class TypeConverter implements Converter<Integer> {

    public static final String DISABLE = "禁用";
    public static final String ENABLE = "启用";

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty,
                                     GlobalConfiguration globalConfiguration) throws Exception {
        if (cellData.getStringValue().equals(DISABLE)) {
            return 0;
        } else  if (cellData.getStringValue().equals(ENABLE))  {
            return 1;
        }
        return 9999;
    }

    @Override
    public WriteCellData<?> convertToExcelData(Integer value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (value == 1) {
            return new WriteCellData<>(ENABLE);
        } else if (value == 0) {
            return new WriteCellData<>(DISABLE);
        } else {
            return new WriteCellData<>("");
        }
    }
}
