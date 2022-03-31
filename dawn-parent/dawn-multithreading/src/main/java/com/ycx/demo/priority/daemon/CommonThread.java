package com.ycx.demo.priority.daemon;

/**
 * @author :     guowc
 * @version :    1.0
 * @package :    com.ycx.demo.priority.daemon
 * @date :       2022/3/31 16:06
 * @copyright :  wpwl
 */
public class CommonThread extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5 ; i++) {
            System.out.println("用户线程第" + i + "次执行!");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
