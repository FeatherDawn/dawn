package com.ycx.demo.priority.daemon;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.priority.daemon
 * @date :       2022/3/31 17:31
 * @copyright :  wpwl
 */
public class MyDaemonThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 9999999; i++) {
            System.out.println("守护线程第"+i+"次执行");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
