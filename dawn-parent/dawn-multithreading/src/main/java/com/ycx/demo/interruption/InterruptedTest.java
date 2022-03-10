package com.ycx.demo.interruption;

/**
 * 验证interrupted()会清除线程状态
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.interruption
 * @date :       2022/3/9 16:35
 * @copyright :  wpwl
 */
public class InterruptedTest {

    public static void main(String[] args) {
        //线程是否被中断
        System.out.println("1: "+Thread.interrupted());
        //设置线程中断
        Thread.currentThread().interrupt();
        //线程是否被中断
        System.out.println("2: "+Thread.interrupted());
        //线程是否被中断
        System.out.println("3: "+Thread.interrupted());
    }

}
