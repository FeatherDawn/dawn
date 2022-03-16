package com.ycx.entity;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.entity
 * @date :       2022/3/10 14:46
 * @copyright :  wpwl
 */
public class BaseType {
    /**
     * 如果要是excel是否需要使用富文本
     * @return 是否需要使用富文本
     */
    public Boolean isGetRich(){
        return false;
    }


    /**
     * 设置单元格格式
     * @return 是设置单元格格式
     */
    public  Boolean isGetCellStyle(){
        return false;
    }
}
