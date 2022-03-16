package com.ycx.annotation;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.lang.annotation.*;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.annotation.ExcelStyle.java
 * @date :       2022/3/10 14:33
 * @copyright :  wpwl
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelStyle {
    String fontName() default "宋体";
    short fontHeightInPoints() default 12;
    HorizontalAlignment horizontalAlignment() default HorizontalAlignment.CENTER;
    VerticalAlignment verticalAlignment() default VerticalAlignment.CENTER;
    boolean wrapText() default false;
    boolean richText() default false;
    boolean isRequire() default false;
}
