package com.ycx.demo.thread.thread;

/**
 * 创建线程(继承Thread类)
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.thread.thread
 * @date :       2022/3/9 11:06
 * @copyright :  wpwl
 */
public class HelloWorldThread extends Thread{

    @Override
    public void run() {
        System.out.println("Hello Concurrent World");
    }

    public static void main(String[] args) {
        System.out.println("---------------创建线程---------------");
        HelloWorldThread helloWorldThread = new HelloWorldThread();
        System.out.println("---------------启动线程---------------");
        helloWorldThread.start();
    }
}
