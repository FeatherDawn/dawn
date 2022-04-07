package com.ycx.demo.thread.yield;

/**
 * 消费者
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.thread.yield
 * @date :       2022/4/7 14:19
 * @copyright :  wpwl
 */
public class Consumer extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("I am Consumer : Consumed Item" + i);
            //Thread.yield();
        }
    }
}
