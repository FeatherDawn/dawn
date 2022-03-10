package com.ycx.demo.interruption;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.interruption
 * @date :       2022/3/9 16:44
 * @copyright :  wpwl
 */
public class IsInterruptedTest {
    public static void main(String[] args) {
        //获取当前线程
        Thread thread = Thread.currentThread();
        //判断当前线程是否中断
        System.out.println("1: "+thread.isInterrupted());
        //设置线程中断标识
        thread.interrupt();
        //判断当前线程是否中断
        System.out.println("2: "+thread.isInterrupted());
        //判断当前线程是否中断
        System.out.println("3: "+thread.isInterrupted());
        try {
            Thread.sleep(2000);
            System.out.println("not interrupted...");
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep interrupted....");
            //判断线程是否中断
            System.out.println("4: "+thread.isInterrupted());
        }
        System.out.println("5: "+thread.isInterrupted());
    }
}
