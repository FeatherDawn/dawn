package com.ycx.demo.priority.daemon;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.priority.daemon
 * @date :       2022/3/31 18:06
 * @copyright :  wpwl
 */
public class DaemonThreadDemo {    public static void main(String[] args){

        Thread t1 = new CommonThread();
        Thread t2 = new Thread(new MyDaemonThread());
        //抛出异常 : IllegalThreadStateException【设置守护线程必须在执行线程之前】
        //t2.start();
        //设置守护线程
        t2.setDaemon(true);
        //正确做法线程运行前设置守护线程
        t2.start();
        t1.start();
    }
}
