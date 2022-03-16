package com.ycx.handler;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;

import java.util.Map;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.handler
 * @date :       2022/3/10 16:32
 * @copyright :  wpwl
 */
public class CustomMeterInfoSpinnerWriteHandler implements SheetWriteHandler {
    //下拉框值
    private Map<Integer,String[]> dropDownMap;

    public CustomMeterInfoSpinnerWriteHandler(Map<Integer, String[]> dropDownMap) {
        this.dropDownMap = dropDownMap;
    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        Sheet sheet = writeSheetHolder.getSheet();
        //开始设置下拉框
        DataValidationHelper helper = sheet.getDataValidationHelper();
        for (Map.Entry<Integer, String[]> entry : dropDownMap.entrySet()) {
            //起始行、终止行、起始列、终止列
            CellRangeAddressList addressList = new CellRangeAddressList( 1, 1000, entry.getKey(), entry.getKey());
            //设置下拉框数据
            DataValidationConstraint constraint = helper.createExplicitListConstraint(entry.getValue());
            DataValidation dataValidation = helper.createValidation(constraint, addressList);
            //处理excel兼容性问题
            if (dataValidation instanceof XSSFDataValidation) {
                dataValidation.setSuppressDropDownArrow(true);
                dataValidation.setShowErrorBox(true);
            }else {
                dataValidation.setSuppressDropDownArrow(false);
            }
            sheet.addValidationData(dataValidation);
        }
    }

}
