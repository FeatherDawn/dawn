package com.ycx.demo.priority.extend;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.priority.extend
 * @date :       2022/3/31 14:48
 * @copyright :  wpwl
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        super.run();
        //输出线程级别
        System.out.println("MyThread1 Priority = " + this.getPriority());
        //启动线程MyThread2
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}
