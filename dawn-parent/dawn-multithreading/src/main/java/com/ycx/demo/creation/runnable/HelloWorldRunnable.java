package com.ycx.demo.creation.runnable;

/**
 * 创建线程(实现Runnable接口)
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.thread.runnable
 * @date :       2022/3/9 11:14
 * @copyright :  wpwl
 */
public class HelloWorldRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello Concurrent World");
    }

    public static void main(String[] args) {
        System.out.println("---------------创建线程---------------");
        HelloWorldRunnable helloWorldRunnable = new HelloWorldRunnable();
        System.out.println("---------------创建开始---------------");
        Thread thread = new Thread(helloWorldRunnable);
        thread.start();
    }
}
