package com.ycx.handler;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import com.ycx.util.EasyExcelUtil;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.handler
 * @date :       2022/3/14 18:46
 * @copyright :  wpwl
 */
public class CustomSheetWriteHandler implements SheetWriteHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomSheetWriteHandler.class);

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        logger.info("第{}个Sheet写入成功。",writeSheetHolder.getSheetNo());

        //区间设置 第三行第一列和第二列的数据。
        //起始行、终止行、起始列、终止列
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(2, 2, 0, 1);
        DataValidationHelper helper = writeSheetHolder.getSheet().getDataValidationHelper();
        DataValidationConstraint constraint = helper.createExplicitListConstraint(new String[]{"康师傅", "汤达人"});
        DataValidation dataValidation = helper.createValidation(constraint, cellRangeAddressList);
        writeSheetHolder.getSheet().addValidationData(dataValidation);
    }
}
