package com.ycx.demo.priority.systematicness;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.priority.systematicness
 * @date :       2022/3/31 15:15
 * @copyright :  wpwl
 */
public class ThreadPriority {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread1 myThread1 = new MyThread1();
            myThread1.setPriority(1);
            MyThread2 myThread2 = new MyThread2();
            myThread2.setPriority(10);
            myThread1.start();
            myThread2.start();
        }
    }
}
