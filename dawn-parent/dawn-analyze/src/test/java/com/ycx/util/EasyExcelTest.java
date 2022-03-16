package com.ycx.util;

import com.ycx.DawnAnalyzeApplication;
import com.ycx.entity.CommonCallBackData;
import com.ycx.entity.ExcelImport;
import com.ycx.entity.TypeConsumer;
import com.ycx.handler.CustomMeterInfoSpinnerWriteHandler;
import com.ycx.handler.CustomSheetWriteHandler;
import com.ycx.handler.TitleHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.util
 * @date :       2022/3/10 16:04
 * @copyright :  wpwl
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DawnAnalyzeApplication.class)
public class EasyExcelTest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private MockHttpServletResponse response;

    @Test
    public void exportExcel() throws Exception{

        response = new MockHttpServletResponse();

        //1、指定要隐藏的列
        List<Integer> hiddenColumnIndexes = new ArrayList<>();
        hiddenColumnIndexes.add(6);

        //2、设置富文本,必选项
        TypeConsumer<ExcelImport> consumer = new TypeConsumer<>();
        Consumer<CommonCallBackData<ExcelImport>> cellStyleTextConsumer = consumer::cellStyleTextConsumer;
        Consumer<CommonCallBackData<ExcelImport>> richTextConsumer = consumer::richTextConsumer;

        TitleHandler titleHandler = new TitleHandler<ExcelImport>(ExcelImport.class, Collections.EMPTY_LIST,
                null, cellStyleTextConsumer, richTextConsumer, hiddenColumnIndexes);

        //3、设置下拉框
        Map<Integer,String[]> buildBoxSpinners = new HashMap<>();
        buildBoxSpinners.put(4, new String[]{"禁用", "启用"});

        //4、设置导出文件
        EasyExcelUtil.writeExcelWithRegisterWriteHandler(response, Collections.emptyList(),
                "文件导出test"  + FORMATTER.format(LocalDateTime.now()),
                "sheet", ExcelImport.class,new CustomSheetWriteHandler(), titleHandler);

    }
}
