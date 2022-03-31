package com.ycx.demo.priority.daemon;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.priority.daemon
 * @date :       2022/3/31 18:06
 * @copyright :  wpwl
 */
public class DaemonThreadDemo {

        public static void main(String[] args){
            Thread t1 = new CommonThread();
            Thread t2 = new Thread(new MyDaemonThread());
            //守护线程的设置必须要在执行线程之前，如果在执行线程之后设置守护线程，线程会失效并抛出IllegalThreadStateException异常
            //t2.start();
            t2.setDaemon(true);
            //正确做法在线程执行之前设置守护线程
            t2.start();
            t1.start();
    }
}
