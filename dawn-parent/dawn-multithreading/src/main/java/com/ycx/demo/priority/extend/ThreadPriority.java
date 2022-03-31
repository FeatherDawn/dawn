package com.ycx.demo.priority.extend;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.priority.extend
 * @date :       2022/3/31 14:58
 * @copyright :  wpwl
 */
public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println("once Main Thread Priority = " + Thread.currentThread().getPriority());
        //验证继承性时放开注释
        //Thread.currentThread().setPriority(10);
        System.out.println("twice Main Thread Priority = " + Thread.currentThread().getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}
