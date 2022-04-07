package com.ycx.demo.thread.yield;

/**
 * 生产者
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.thread.yield
 * @date :       2022/4/7 14:16
 * @copyright :  wpwl
 */
public class Producer extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("I am Producer : Produced Item" + i);
            //Thread.yield();
        }
    }
}
