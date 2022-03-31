package com.ycx.demo.priority.extend;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.priority.extend
 * @date :       2022/3/31 14:54
 * @copyright :  wpwl
 */
public class MyThread2 extends Thread{
    @Override
    public void run() {
        super.run();
        //输出线程级别
        System.out.println("MyThread2 Priority = " + this.getPriority());
    }
}
