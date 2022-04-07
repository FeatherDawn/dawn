package com.ycx.demo.thread.yield;

/**
 * 分别观察没有调用yield()和调用yield()方法的输出
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.thread.yield
 * @date :       2022/4/7 14:21
 * @copyright :  wpwl
 */
public class YieldDemo {
    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();
        //最低优先级
        producer.setPriority(Thread.MIN_PRIORITY);
        //最高优先级
        consumer.setPriority(Thread.MAX_PRIORITY);
        consumer.start();
        producer.start();
    }
}
